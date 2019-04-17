# Created by Peixuan for packet generation and feed into bmv2 simple switch
# 04172019 for P4_Bug_Finder

from scapy.all import *
import time


# Packet Payload, this makes no difference in P4 testing
data="this is a test"

# Construct a packet
# 
p1 = Ether()/IP(src="128.0.0.0",dst="10.0.0.1")/TCP(sport=1234,dport=1)/data

# Sending the constructed packet into the interface veths
sendp(p1,iface="veth2")


p2 = Ether()/IP(src="128.0.0.1",dst="10.0.0.2")/TCP(sport=1234,dport=2)/data
sendp(p2,iface="veth2")


p3 = Ether()/IP(src="10.0.0.3",dst="128.0.0.1")/TCP(sport=1234,dport=3)/data
sendp(p3,iface="veth2")


p4 = Ether()/IP(src="10.0.0.0",dst="128.0.0.1")/TCP(sport=1234,dport=10)/data
sendp(p4,iface="veth2")


