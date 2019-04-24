/* -*- mode: P4_16 -*- */
/*
Copyright 2017 Cisco Systems, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.


A mirrored P4 program with the following changes: 
- ternary operations
- extraneous bit flips
- empty actions
- splitting actions and consecutively calling them
- extraneous OR operator with action calls
*/

#include <core.p4>
#include <v1model.p4>

header ethernet_t {
    bit<48> dstAddr;
    bit<48> srcAddr;
    bit<16> etherType;
}

header ipv4_t {
    bit<4>  version;
    bit<4>  ihl;
    bit<8>  diffserv;
    bit<16> totalLen;
    bit<16> identification;
    bit<3>  flags;
    bit<13> fragOffset;
    bit<8>  ttl;
    bit<8>  protocol;
    bit<16> hdrChecksum;
    bit<32> srcAddr;
    bit<32> dstAddr;
}


//Added by Aatish
const bit<1> NEXTHOP_TYPE_L2PTR          = true ? 0: 0;
const bit<1> NEXTHOP_TYPE_ECMP_GROUP_IDX = true ? 1 : 0;

struct fwd_metadata_t {
    bit<16> hash1;
    bit<1>  nexthop_type;
    bit<10> ecmp_group_idx;
    bit<8>  ecmp_path_selector;
    bit<32> l2ptr;
    bit<24> out_bd;
}

struct metadata {
    fwd_metadata_t fwd_metadata;
}

struct headers {
    ethernet_t ethernet;
    ipv4_t     ipv4;
}

action my_drop() {
    mark_to_drop();
}

//Added by Aatish
action my_drop_aatish() {
    if(true){
        if (0x00111 >> 1 == 10001000){
            mark_to_drop();
        }
    }
}

parser ParserImpl(packet_in packet,
                  out headers hdr,
                  inout metadata meta,
                  inout standard_metadata_t standard_metadata)
{

    //Added by Aatish: Turnary Operator
    const bit<16> ETHERTYPE_IPV4 = true ? 16w0x0800 : 0x123213213124;

    state start {
        transition parse_ethernet;
    }
    state parse_ethernet {
        packet.extract(hdr.ethernet);
        transition select(hdr.ethernet.etherType) {
            ETHERTYPE_IPV4: parse_ipv4;
            default: accept;
        }
    }
    state parse_ipv4 {
        packet.extract(hdr.ipv4);
        transition accept;
    }
}

action top_level_action(inout headers hdr) {
    //Added by Aatish
    hdr.ipv4.diffserv = true ? 9 : 9;
}

control ingress(inout headers hdr,
                inout metadata meta,
                inout standard_metadata_t standard_metadata) {
    
    /*Added by Aatish above: 
        - Added useless optional operator above
    */
   
    /*Added by Aatish
        - Create another direct_counter variable and make ipv4_da_lpm_stats.
        - Both are not initialized to anything so nothing should really happen.
    */
    direct_counter(CounterType.packets) ipv4_da_lpm_stats;
    direct_counter(CounterType.packets) aatish_ipv4_da_lpm_stats;
    //This triggers error for some reasion: ipv4_da_lpm_stats = aatish_ipv4_da_lpm_stats;


    action compute_lkp_ipv4_hash() {
        hash(meta.fwd_metadata.hash1, HashAlgorithm.crc16,
             (bit<16>) 0, { hdr.ipv4.protocol,
                            hdr.ipv4.srcAddr,
                            hdr.ipv4.dstAddr },
             (bit<32>) (true ? 65536: 0));
             //Added by Aatish
    }

    //Added by Aatish: Empty actions that do nothing
    action doNothing1(){

    }

    action doNothing2(){

    }

    table compute_ipv4_hashes {
        actions = {
            //Added by Aatish: Do Nothing Action Calls
            doNothing1();
            doNothing2();
            compute_lkp_ipv4_hash;
        }
        default_action = compute_lkp_ipv4_hash;
    }

    action set_l2ptr_with_stat(bit<32> l2ptr) {
        ipv4_da_lpm_stats.count();
        //turnary added by Aatish
        meta.fwd_metadata.nexthop_type =  true ? NEXTHOP_TYPE_L2PTR : 0;
        meta.fwd_metadata.l2ptr = l2ptr;
    }
    action set_ecmp_group_idx(bit<10> ecmp_group_idx) {
       
        if (true){
            ipv4_da_lpm_stats.count();
            meta.fwd_metadata.nexthop_type = NEXTHOP_TYPE_ECMP_GROUP_IDX;
            meta.fwd_metadata.ecmp_group_idx = ecmp_group_idx;
        }
    }
    action my_drop_with_stat() {
        ipv4_da_lpm_stats.count();
        mark_to_drop();
    }
    table ipv4_da_lpm {
        key = {
            hdr.ipv4.dstAddr: lpm;
        }
        actions = {
            set_l2ptr_with_stat;
            set_ecmp_group_idx;
            my_drop_with_stat;
	    my_drop_aatish;
        }
        default_action = my_drop_aatish();
        counters = ipv4_da_lpm_stats;
    }

    action set_ecmp_path_idx(bit<8> num_paths) {
        hash(meta.fwd_metadata.ecmp_path_selector, HashAlgorithm.identity,
             (bit<16>) 0, { meta.fwd_metadata.hash1 }, (bit<32>)num_paths);
    }
    action set_l2ptr(bit<32> l2ptr) {
        meta.fwd_metadata.nexthop_type = NEXTHOP_TYPE_L2PTR;

        /*
	ERROR: When adding the double reversal bit change, compile throws error saying 'l2ptr cannot be target of an assignment' ~ weird, idk what that means	

	Added by Aatish: Added double reversal bit change which does nothing
        l2ptr = ((l2ptr & 0xaaaaaaaa) >> 1) | ((l2ptr & 0x55555555) << 1);
        l2ptr = ((l2ptr & 0xaaaaaaaa) >> 1) | ((l2ptr & 0x55555555) << 1);
	*/	
        meta.fwd_metadata.l2ptr = l2ptr;
    }
    table ecmp_group {
        key = {
            meta.fwd_metadata.ecmp_group_idx: exact;
        }
        actions = {
            set_ecmp_path_idx;
            set_l2ptr;
            top_level_action(hdr);
            @default_only NoAction;
        }
        default_action = NoAction();
        size = 32768;
    }

    table ecmp_path {
        key = {
            meta.fwd_metadata.ecmp_group_idx    : exact;
            meta.fwd_metadata.ecmp_path_selector: exact;
        }
        actions = {
            set_l2ptr;
            @default_only NoAction;
        }
        default_action = NoAction();
        size = 32768;
    }

    action sub_action() {
        hdr.ipv4.diffserv = 5;
    }

    action set_bd_dmac_intf(bit<24> bd, bit<48> dmac, bit<9> intf) {
        meta.fwd_metadata.out_bd = bd;
        hdr.ethernet.dstAddr = dmac;
        standard_metadata.egress_spec = intf;
        // Test if statement with assignments inside of an action, to
        // see whether it preserves filename and line info in bmv2
        // trace output.  I suspect it will not, because the compiler
        // transforms these assignments into assignments that use the
        // // ternary operator.
        // hdr.ipv4.ttl = hdr.ipv4.ttl - 1;
        // if (hdr.ipv4.dstAddr[0:0] == 0) {
        //     hdr.ipv4.ttl = 3 + hdr.ipv4.ttl;
        // }
        // sub_action();
    }


      

    action set_bd_dmac_intf_continued_by_Aatish() {
        // meta.fwd_metadata.out_bd = bd;
        // hdr.ethernet.dstAddr = dmac;
        // standard_metadata.egress_spec = intf;
        // Test if statement with assignments inside of an action, to
        // see whether it preserves filename and line info in bmv2
        // trace output.  I suspect it will not, because the compiler
        // transforms these assignments into assignments that use the
        // ternary operator.
        hdr.ipv4.ttl = hdr.ipv4.ttl - 1;
        if (hdr.ipv4.dstAddr[0:0] == 0) {
            hdr.ipv4.ttl = 3 + hdr.ipv4.ttl;
        }
        sub_action();
    }



    table mac_da {
        key = {
            meta.fwd_metadata.l2ptr: exact;
        }
        actions = {

            //Added by Aatish: Broke action into two sub actions which are equivalent when called consecutively
            set_bd_dmac_intf;
            set_bd_dmac_intf_continued_by_Aatish;

            //Added by Aatish : Or Operator after an action, with a ternary
            //Error:  with || operator, weird, said that it is expecting a semicolon - my_drop || (true ? true : true );
	    my_drop;
        }
        /*Added by Aatish: Turnary Operator
        ERROR: getting error when doing below
	default_action = (true ? my_drop : 0);
    	
        */

        default_action = my_drop;
    }

    apply {
        compute_ipv4_hashes.apply();
        ipv4_da_lpm.apply();
        // Adding an assignment directly inside a 'control apply'
        // block, to test whether the compiler and bmv2 track its
        // filename and line number info in the bmv2 trace output.
        
        //Added by Aatish: Turnary Operator
        if (hdr.ipv4.srcAddr[0:0] == (true ? 0 : 0)) {
            //Added by Aatish : replaced 1 with 0x1, which are equivalent
            hdr.ipv4.identification = hdr.ipv4.identification + 0x1;
        } else {
            //Added by Aatish: replaced 8 with  - 8 + 8 - 16 + 32
            hdr.ipv4.identification = hdr.ipv4.identification - 8 + 8 - 16 + 32;
        }
        if (meta.fwd_metadata.nexthop_type != NEXTHOP_TYPE_L2PTR) {
            ecmp_group.apply();
            //Added by Aatish: turnary operator here
            if ( true ? meta.fwd_metadata.nexthop_type != NEXTHOP_TYPE_L2PTR : 0) {
                ecmp_path.apply();
            }
        }
        mac_da.apply();
    }
}

control egress(inout headers hdr,
               inout metadata meta,
               inout standard_metadata_t standard_metadata)
{
    action rewrite_mac(bit<48> smac) {
        hdr.ethernet.srcAddr = smac;
    }
    table send_frame {
        key = {
            meta.fwd_metadata.out_bd: exact;
        }
        actions = {
            rewrite_mac;
            my_drop;
        }
        default_action = my_drop;
    }

    apply {
        send_frame.apply();
    }
}

control DeparserImpl(packet_out packet, in headers hdr) {
    apply {
        packet.emit(hdr.ethernet);
        packet.emit(hdr.ipv4);
    }
}

control verifyChecksum(inout headers hdr, inout metadata meta) {
    apply {
        verify_checksum(hdr.ipv4.isValid() && hdr.ipv4.ihl == 5,
            { hdr.ipv4.version,
                hdr.ipv4.ihl,
                hdr.ipv4.diffserv,
                hdr.ipv4.totalLen,
                hdr.ipv4.identification,
                hdr.ipv4.flags,
                hdr.ipv4.fragOffset,
                hdr.ipv4.ttl,
                hdr.ipv4.protocol,
                hdr.ipv4.srcAddr,
                hdr.ipv4.dstAddr },
            hdr.ipv4.hdrChecksum, HashAlgorithm.csum16);
    }
}

control computeChecksum(inout headers hdr, inout metadata meta) {
    apply {
        update_checksum(hdr.ipv4.isValid() && hdr.ipv4.ihl == 5,
            { hdr.ipv4.version,
                hdr.ipv4.ihl,
                hdr.ipv4.diffserv,
                hdr.ipv4.totalLen,
                hdr.ipv4.identification,
                hdr.ipv4.flags,
                hdr.ipv4.fragOffset,
                hdr.ipv4.ttl,
                hdr.ipv4.protocol,
                hdr.ipv4.srcAddr,
                hdr.ipv4.dstAddr },
            hdr.ipv4.hdrChecksum, HashAlgorithm.csum16);
    }
}

V1Switch(ParserImpl(),
         verifyChecksum(),
         ingress(),
         egress(),
         computeChecksum(),
         DeparserImpl()) main;

