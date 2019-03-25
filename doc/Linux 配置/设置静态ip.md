配置参数：
``` cd /etc/sysconfig/network-scripts/ ```
``` vi ifcfg-eno16777736 ```
```properties
#static
ONBOOT=yes
BOOTPROTO=static
IPADDR=192.168.200.101
DNS1=192.168.200.2
GATEWAY=192.168.200.2
NETMASK=255.255.255.0
```
重启网络：``` service network restart ```

如何 [设置虚拟机网段](设置虚拟机网段.md)

