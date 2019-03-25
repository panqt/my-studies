[安装 ElasticSearch](05-安装-ElasticSearch.md)

##### 1、安装环境与版本：

3个CentOS 7 虚拟机

3个ElasticSearch 实例

| centos-100 | centos-101 | centos-102 | 
| --------------- | --------------- | --------------- | 

##### 2、修改配置
```vi /usr/java/elasticsearch/config/elasticsearch.yml```
```
cluster.name: panqt-es
node.name: node-centos-100
node.master: true
node.data: true
network.host: centos-100 #本机ip
http.port: 9200
transport.tcp.port: 9300
discovery.zen.ping.unicast.hosts: ["centos-100", "centos-101", "centos-102"]
discovery.zen.minimum_master_nodes: 2   #(候选主节点数 / 2) + 1
```
启动所有节点
日志报错：[failed to send join request to master](https://blog.csdn.net/diyiday/article/details/83926488)

3、测试
```$ curl -XGET 'http://centos-100:9200/_cat/nodes?pretty'```
```
[root@centos-100 panqt]# curl -XGET 'http://centos-100:9200/_cat/nodes?pretty'
192.168.200.100 12 94 38 1.08 0.56 0.52 mdi - node-centos-100
192.168.200.101 13 95 47 0.92 0.51 0.48 mdi * node-centos-101 # * 表示主节点
192.168.200.102 12 95 51 0.95 0.49 0.47 mdi - node-centos-101
```

[谈一谈Elasticsearch的集群部署](https://blog.csdn.net/zwgdft/article/details/54585644)