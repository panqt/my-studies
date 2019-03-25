[安装 Zookeeper](06-安装-RabbitMQ.md)

##### 1、安装环境与版本：

3个CentOS 7 虚拟机

3个Redis 实例

| 192.168.200.100 | 192.168.200.101 | 192.168.200.102 |
| --------------- | --------------- | --------------- |
| zookeeper-2181      | zookeeper-2181      | zookeeper-2181      |
[Zookeeper集群节点数量为什么要是奇数个？](https://blog.csdn.net/u010476994/article/details/79806041)

##### 2、配置并启动集群
先停止所有zookeeper节点 ```service zookeeper stop```

修改三个zookeeper节点中的zoo.cfg文件，添加server.0、server.1、server.2
vi /usr/java/zookeeper/conf/zoo.cfg
```
server.0=centos-100:2888:3888
server.1=centos-101:2888:3888
server.2=centos-102:2888:3888
```
再根据上面的列表修改 /usr/java/zookeeper/data/myid 的内容
echo "0" > /usr/java/zookeeper/data/myid

启动所有服务
service zookeeper start
查看节点状态
service zookeeper status
```
[root@centos-101 bin]# service zookeeper status
ZooKeeper JMX enabled by default
Using config: /usr/java/zookeeper/bin/../conf/zoo.cfg
Mode: leader
```

##### 2、测试
查看帮助信息：```/usr/java/zookeeper/bin/zkCli.sh help  ```
在zookeeper中任意一个节点，执行指令连接zookpeep集群```/usr/java/zookeeper/bin/zkCli.sh```
```
ls  /   查找根目录

create /test abc   创建节点并赋值

get /test   获取指定节点的值

set /test cb  设置已存在节点的值

rmr /test  递归删除节点

delete /test/test01  删除不存在子节点的节点
```

