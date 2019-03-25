##### 1、解压并修改配置文件
```$ mkdir -p /usr/java```
```$ cd /usr/java ```

使用ftp工具把安装包放到java目录下，解压

```$ tar -zxvf zookeeper-3.4.13.tar.gz```

```$ mv zookeeper-3.4.13 zookeeper```

```$ mkdir ./zookeeper/data```

```$ mkdir ./zookeeper/logs```

```$ cp ./zookeeper/conf/zoo_sample.cfg ./zookeeper/conf/zoo.cfg```

```$ vi ./zookeeper/conf/zoo.cfg```

```
dataDir=/usr/java/zookeeper/data
dataLogDir=/usr/java/zookeeper/logs

server.1=centos-100:2888:3888
```

```$ touch ./zookeeper/data/myid```

```$ echo "1" > ./zookeeper/data/myid ```



##### 2、配置环境变量

```$ vi /etc/profile```

```
# Zookeeper Env
export ZOOKEEPER_HOME=/usr/java/zookeeper
export PATH=$ZOOKEEPER_HOME/bin:$PATH
```

```$ source /etc/profile```



##### 3、开放防火墙

添加：`$ sudo firewall-cmd --zone=public --add-port=2181/tcp --permanent`
重启：`$ sudo firewall-cmd --reload`
查看：`$ firewall-cmd --zone=public --list-port`



##### 4、添加到服务

```$ cd /etc/init.d  ```

```$ touch zookeeper```

```$ chmod 755 zookeeper ```

```$ vi zookeeper```

```shell
#!/bin/sh
# chkconfig: 2345 20 90
# Description: zookeeper
# processname: zookeeper

export JAVA_HOME=/usr/java/jdk

case $1 in
    start)
                su root /usr/java/zookeeper/bin/zkServer.sh start
    ;;
    stop)
                su root /usr/java/zookeeper/bin/zkServer.sh stop
    ;;
    status)
                su root /usr/java/zookeeper/bin/zkServer.sh status
    ;;
    restart)
                su root /usr/java/zookeeper/bin/zkServer.sh restart
    ;;
    *)
                echo "require start|stop|status|restart"  
    ;;
esac

```

```$ chkconfig zookeeper on```

```$ chkconfig --list```
