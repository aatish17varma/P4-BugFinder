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

const bit<1> NEXTHOP_TYPE_L2PTR          = 0;
const bit<1> NEXTHOP_TYPE_ECMP_GROUP_IDX = 1;

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

parser ParserImpl(packet_in packet,
                  out headers hdr,
                  inout metadata meta,
                  inout standard_metadata_t standard_metadata)
{
    const bit<16> ETHERTYPE_IPV4 = 16w0x0800;

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
    hdr.ipv4.diffserv = 9;
}

control ingress(inout headers hdr,
                inout metadata meta,
                inout standard_metadata_t standard_metadata) {
    direct_counter(CounterType.packets) ipv4_da_lpm_stats;

    action compute_lkp_ipv4_hash() {
        hash(meta.fwd_metadata.hash1, HashAlgorithm.crc16,
             (bit<16>) 0, { hdr.ipv4.srcAddr,
                            hdr.ipv4.dstAddr,
                            hdr.ipv4.protocol },
             (bit<32>) 65536);
    }
    table compute_ipv4_hashes {
        actions = {
            compute_lkp_ipv4_hash;
        }
        default_action = compute_lkp_ipv4_hash;
    }

    action set_l2ptr_with_stat(bit<32> l2ptr) {
        ipv4_da_lpm_stats.count();
        meta.fwd_metadata.nexthop_type = NEXTHOP_TYPE_L2PTR;
        meta.fwd_metadata.l2ptr = l2ptr;
    }
    action set_ecmp_group_idx(bit<10> ecmp_group_idx) {
        ipv4_da_lpm_stats.count();
        meta.fwd_metadata.nexthop_type = NEXTHOP_TYPE_ECMP_GROUP_IDX;
        meta.fwd_metadata.ecmp_group_idx = ecmp_group_idx;
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
        }
        default_action = my_drop_with_stat;
        counters = ipv4_da_lpm_stats;
    }

    action set_ecmp_path_idx(bit<8> num_paths) {
        hash(meta.fwd_metadata.ecmp_path_selector, HashAlgorithm.identity,
             (bit<16>) 0, { meta.fwd_metadata.hash1 }, (bit<32>)num_paths);
    }
    action set_l2ptr(bit<32> l2ptr) {
        meta.fwd_metadata.nexthop_type = NEXTHOP_TYPE_L2PTR;
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
            set_bd_dmac_intf;
            my_drop;
        }
        default_action = my_drop;
    }

    apply {
        compute_ipv4_hashes.apply();
        ipv4_da_lpm.apply();
        // Adding an assignment directly inside a 'control apply'
        // block, to test whether the compiler and bmv2 track its
        // filename and line number info in the bmv2 trace output.
        if (hdr.ipv4.srcAddr[0:0] == 0) {
            hdr.ipv4.identification = hdr.ipv4.identification + 1;
        } else {
            hdr.ipv4.identification = hdr.ipv4.identification - 8;
        }
        if (meta.fwd_metadata.nexthop_type != NEXTHOP_TYPE_L2PTR) {
            ecmp_group.apply();
            if (meta.fwd_metadata.nexthop_type != NEXTHOP_TYPE_L2PTR) {
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
