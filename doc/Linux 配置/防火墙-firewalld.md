firewall-cmd 是 firewalld的字符界面管理工具，firewalld是centos7的一大特性，最大的好处有两个：支持动态更新，不用重启服务；第二个就是加入了防火墙的“zone”概念。

firewalld跟iptables比起来至少有两大好处：

1. firewalld可以动态修改单条规则，而不需要像iptables那样，在修改了规则后必须得全部刷新才可以生效。
2. firewalld在使用上要比iptables人性化很多，即使不明白“五张表五条链”而且对TCP/IP协议也不理解也可以实现大部分功能。

firewalld自身并不具备防火墙的功能，而是和iptables一样需要通过内核的netfilter来实现，也就是说firewalld和 iptables一样，他们的作用都是用于维护规则，而真正使用规则干活的是内核的netfilter，只不过firewalld和iptables的结 构以及使用方法不一样罢了。
<br>
#### 基本命令
```shell
# 安装firewalld
yum install firewalld firewall-config

systemctl start  firewalld # 启动
systemctl stop firewalld  # 关闭
systemctl status firewalld # 查看状态 或 firewall-cmd --state
systemctl disable firewalld # 开机禁用
systemctl enable firewalld # 开机启用

# 关闭服务的方法
# 你也可以关闭目前还不熟悉的FirewallD防火墙，而使用iptables，命令如下：
systemctl stop firewalld
systemctl disable firewalld
yum install iptables-services
systemctl start iptables
systemctl enable iptables
```


<br>
#### 开放端口：
```shell
#添加  --permanent永久生效，没有此参数重启后失效
firewall-cmd --zone=public --add-port=80/tcp --permanent

#重新载入
firewall-cmd --reload

#查看
firewall-cmd --zone=public --query-port=80/tcp
firewall-cmd --zone=public --list-ports

#删除
firewall-cmd --zone=public --remove-port=80/tcp --permanent
```
