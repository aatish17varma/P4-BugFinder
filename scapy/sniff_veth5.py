# Created by Peixuan on 05042019
# Used in P4-Bugfinder Project
from scapy.all import *

#dpkt_eth0  = sniff(iface = "eth0", timeout = 60)


# Sniffing Packets
dpkt_veth5 = sniff(iface = "veth5", timeout = 60)

# Output pcap files
#wrpcap("eth0.pcap", dpkt_eth0)
wrpcap("veth5.pcap", dpkt_veth5)
