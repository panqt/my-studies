##### 1、解压压缩包，创建文件夹
```$ mkdir -p /usr/java```

```$ cd /usr/java```

使用ftp工具把安装包放到java目录下，解压

```$ tar -zxvf elasticsearch-6.6.1.tar.gz```

```$ mv elasticsearch-6.6.1 elasticsearch```

```$ mkdir  -p ./elasticsearch/data```

```$ mkdir -p ./elasticsearch/logs```



##### 2、创建用户

```$ groupadd elasticsearch```

```$ useradd -r -g elasticsearch elasticsearch```


```$ chown -R elasticsearch:elasticsearch elasticsearch```



##### 3、修改配置文件

```$ vi elasticsearch/config/elasticsearch.yml```

```
path.data: /usr/java/elasticsearch/data

path.logs: /usr/java/elasticsearch/logs
```





##### 4、启动问题
启动：```$ /usr/java/elasticsearch/bin/elasticsearch```

- 无法使用root启动

```
can not run elasticsearch as root
```

elasticsearch不允许用root启动



- 无法创建本地线程问题,用户最大可创建线程数太小

```
max number of threads [2048] for user [es] is too low, increase to at least [4096]
```

修改```$ vi /etc/security/limits.d/20-nproc.conf```

添加 
```
elasticsearch soft nproc 4096
```



- 最大虚拟内存太小

```
max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]
```

```$ vi /etc/sysctl.conf```

在文件最后面添加内容:

```properties
vm.max_map_count=262144
```

刷新：```$ sysctl -p```



- 无法创建本地文件问题,用户最大可创建文件数太小

```
max file descriptors [4096] for elasticsearch process is too low, increase to at least [65536]
```

```$ vi /etc/security/limits.conf ```

```
elasticsearch soft nofile 65536
elasticsearch hard nofile 131072
elasticsearch soft nproc 4096　
elasticsearch hard nproc 4096　
```

修改后重启才能生效```$ sudo reboot```


##### 5、测试

```$ curl "127.0.0.1:9200"```

##### 6、防火墙开放端口

添加：`$ sudo firewall-cmd --zone=public --add-port=9200/tcp --permanent`
重启：`$ sudo firewall-cmd --reload`
查看：`$ firewall-cmd --zone=public --list-port`



##### 7、添加到服务

在/etc/rc.d/init.d下创建elasticsearch
```$ touch /etc/rc.d/init.d/elasticsearch```
```$ chmod 755 /etc/rc.d/init.d/elasticsearch```
```$ vi /etc/rc.d/init.d/elasticsearch```
```shell
#!/bin/sh
#chkconfig: 2345 80 05
#description: elasticsearch
 
export JAVA_HOME=/usr/java/jdk
export JAVA_BIN=${JAVA_HOME}/bin
export PATH=$PATH:$JAVA_HOME/bin
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export JAVA_HOME JAVA_BIN PATH CLASSPATH

es_user=elasticsearch
es_home=/usr/java/elasticsearch
 
case "$1" in
	start)
		su ${es_user} <<EOF
			cd $es_home
			./bin/elasticsearch -d
EOF
		echo "elasticsearch startup"
	;;
	stop)
		es_pid=`ps aux|grep elasticsearch | grep -v 'grep elasticsearch' | awk '{print $2}'`
		kill -9 $es_pid
		echo "elasticsearch stopped"
	;;
	restart)
		es_pid=`ps aux|grep elasticsearch | grep -v 'grep elasticsearch' | awk '{print $2}'`
		kill -9 $es_pid
		echo "elasticsearch stopped"
		su ${es_user}<<EOF
			cd $es_home
			./bin/elasticsearch -d
EOF
		echo "elasticsearch startup"
	;;
	*)
		echo "start|stop|restart"
	;;
esac


exit $?
```

```$ chkconfig elasticsearch on```
```$ chown -R elasticsearch:elasticsearch /usr/java/elasticsearch```
```$ sudo reboot```

[ElasticSearch 集群](14-ElasticSearch-集群.md)