/* -*- P4_16 -*- */
#include <core.p4>
#include <v1model.p4>

const bit<16> TYPE_IPV4 = 0x800;

/*************************************************************************
*********************** H E A D E R S  ***********************************
*************************************************************************/

typedef bit<9>  egressSpec_t;
typedef bit<48> macAddr_t;
typedef bit<32> ip4Addr_t;

header ethernet_t {
    macAddr_t dstAddr;
    macAddr_t srcAddr;
    bit<16>   etherType;
}

header ipv4_t {
    bit<4>    version;
    bit<4>    ihl;
    bit<8>    diffserv;
    bit<16>   totalLen;
    bit<16>   identification;
    bit<3>    flags;
    bit<13>   fragOffset;
    bit<8>    ttl;
    bit<8>    protocol;
    bit<16>   hdrChecksum;
    ip4Addr_t srcAddr;
    ip4Addr_t dstAddr;
}

struct metadata {
    /* empty */
}

struct headers {
    ethernet_t   ethernet;
    ipv4_t       ipv4;
}

/*************************************************************************
*********************** P A R S E R  ***********************************
*************************************************************************/

parser MyParser(packet_in packet,
                out headers hdr,
                inout metadata meta,
                inout standard_metadata_t standard_metadata) {

    state start {
        transition parse_ethernet;
    }

    state parse_ethernet {
        packet.extract(hdr.ethernet);
        transition select(hdr.ethernet.etherType) {
            TYPE_IPV4: parse_ipv4;
            default: accept;
        }
    }

    state parse_ipv4 {
        packet.extract(hdr.ipv4);
        transition accept;
    }

}

/*************************************************************************
************   C H E C K S U M    V E R I F I C A T I O N   *************
*************************************************************************/

control MyVerifyChecksum(inout headers hdr, inout metadata meta) {   
    apply {  }
}


/*************************************************************************
**************  I N G R E S S   P R O C E S S I N G   *******************
*************************************************************************/

control MyIngress(inout headers hdr,
                  inout metadata meta,
                  inout standard_metadata_t standard_metadata) {
    action drop() {
        mark_to_drop();
    }
    
    // Original action
    action ipv4_forward_ori(macAddr_t dstAddr, egressSpec_t port) {
        standard_metadata.egress_spec = port;
        hdr.ethernet.srcAddr = hdr.ethernet.dstAddr;
        hdr.ethernet.dstAddr = dstAddr;
        hdr.ipv4.ttl = hdr.ipv4.ttl - 1;
    }

/**************************** GPX **************************************/
/******* 01 Put some middle variables in the forwarding actions ********/

/******* 001 The middle variables has the same type with the original ones */


action ipv4_forward(macAddr_t dstAddr, egressSpec_t port) {
        egressSpec_t newPort = port;			// Middle variable
	standard_metadata.egress_spec = newPort;	// Work with middle variable
	macAddr_t newDstAddr = dstAddr;			// Middle variable
        hdr.ethernet.srcAddr = hdr.ethernet.dstAddr;	// Work with middle variable
        hdr.ethernet.dstAddr = newDstAddr;
        hdr.ipv4.ttl = hdr.ipv4.ttl - 1;
    }


    
    table ipv4_lpm {
        key = {
            hdr.ipv4.dstAddr: lpm;
        }
        actions = {
            ipv4_forward;
            drop;
            NoAction;
        }
        size = 1024;
        default_action = drop();
    }
    

/****** GPX From Demo 8 *******/

// GPX: added default table for default action with if-statements
    action default_forward() {
        //meta.fwd_metadata.out_bd = bd;
        //hdr.ethernet.dstAddr = dmac;

        if (hdr.ipv4.dstAddr == 0xFFFFFFFF) {
            // redirect all the broadcast packets
            standard_metadata.egress_spec = 1;
        } /*else if (hdr.ipv4.dstAddr[0:0] == 0) {
            // try this expression to match with certain bits in the dstIP
            //hdr.ipv4.ttl = 3 + hdr.ipv4.ttl;
            standard_metadata.egress_spec = 2;
        } else if (hdr.ipv4.dstAddr[31:25] == 10) {
            // try this expression to match with certain bits in the dstIP
            //hdr.ipv4.ttl = 3 + hdr.ipv4.ttl;
            standard_metadata.egress_spec = 3;
        }*/ else {
            standard_metadata.egress_spec = 4;
        }
    }

    table default_table {
        key = {
            hdr.ipv4.dstAddr: lpm;
        }
        actions = {
            default_forward;
        }
        default_action = default_forward;
    }

    /****** From Demo 8 Finished ******/


    apply {
        /*if (hdr.ipv4.isValid()) {
            ipv4_lpm.apply();
        }*/
        default_table.apply();
    }
}

/*************************************************************************
****************  E G R E S S   P R O C E S S I N G   *******************
*************************************************************************/

control MyEgress(inout headers hdr,
                 inout metadata meta,
                 inout standard_metadata_t standard_metadata) {
    apply {  }
}

/*************************************************************************
*************   C H E C K S U M    C O M P U T A T I O N   **************
*************************************************************************/

control MyComputeChecksum(inout headers  hdr, inout metadata meta) {
     apply {
	update_checksum(
	    hdr.ipv4.isValid(),
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
            hdr.ipv4.hdrChecksum,
            HashAlgorithm.csum16);
    }
}

/*************************************************************************
***********************  D E P A R S E R  *******************************
*************************************************************************/

control MyDeparser(packet_out packet, in headers hdr) {
    apply {
        packet.emit(hdr.ethernet);
        packet.emit(hdr.ipv4);
    }
}

/*************************************************************************
***********************  S W I T C H  *******************************
*************************************************************************/

V1Switch(
MyParser(),
MyVerifyChecksum(),
MyIngress(),
MyEgress(),
MyComputeChecksum(),
MyDeparser()
) main;