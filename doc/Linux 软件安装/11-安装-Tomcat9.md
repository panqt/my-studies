##### 1、安装
下载：```$ wget https://mirrors.tuna.tsinghua.edu.cn/apache/tomcat/tomcat-9/v9.0.16/bin/apache-tomcat-9.0.16.tar.gz```
解压：```$ tar -zxvf apache-tomcat-9.0.16.tar.gz```
##### 2、环境变量
```$ vi /etc/profile```
```
 export CATALINA_HOME=/usr/local/tomcat/apache-tomcat-9.0.0.M4
 export CATALINA_BASE=/usr/local/tomcat/apache-tomcat-9.0.0.M4
 export PATH=$PATH:$CATALINA_BASE/bin
```
```$ source /etc/profile```

启动：```$  ./startup.sh```
停止：```$  ./shutdown.sh ```

##### 3、加入服务列表
```$ vi /etc/init.d/tomcat```
```
#!/bin/bash
   # description: Tomcat Start Stop Restart
   # processname: tomcat
   # chkconfig: 2345 20 80
   JAVA_HOME=/usr/local/jdk/jdk1.8.0_91/
   export JAVA_HOME
   PATH=$JAVA_HOME/bin:$PATH
   export PATH
   CATALINA_HOME=/usr/local/tomcat/apache-tomcat-9.0.0.M4/

   case $1 in
   start)
     sh $CATALINA_HOME/bin/startup.sh
   ;;
   stop)
     sh $CATALINA_HOME/bin/shutdown.sh
   ;;
   restart)
     sh $CATALINA_HOME/bin/shutdown.sh
     sh $CATALINA_HOME/bin/startup.sh
   ;;
   esac
   exit 0
```  
 ```$ chmod 755 tomcat```
 ```$ chkconfig tomcat on```
