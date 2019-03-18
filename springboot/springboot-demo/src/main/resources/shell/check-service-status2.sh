#!/bin/sh
#服务检查脚本ssh-keygen
ssh panqt@centos-103 -tt << eeooff
echo "#!/bin/sh">/bin/start-dead-service.sh
chmod +x /bin/start-dead-service.sh

if [ "$(ps -ef | grep "/usr/java/mycat/bin/./wrapper-linux-x86-64"| grep -v grep )" == "" ]    
	then 
		if [ $(hostname) != "centos-102" ]
			then
				echo "mycat 停了"
				echo "service mycat start">>/bin/start-dead-service.sh
		fi
else echo "mycat 正在运行"
fi  

if [ "$(ps -ef | grep "nginx: master process"| grep -v grep )" == "" ]    
	then
		if [ $(hostname) != "centos-102" ]
			then
				echo "nginx 停了"
				echo "service nginx start">>/bin/start-dead-service.sh
		fi
else echo "nginx 正在运行"		
fi 

if [ "$(ps -ef | grep "keepalived -D"| grep -v grep )" == "" ]    
	then 
		if [ $(hostname) != "centos-102" ]
			then
				echo "keepalived 停了"
				echo "service keepalived start">>/bin/start-dead-service.sh	
		fi
else echo "keepalived 正在运行"		
fi 

if [ "$(ps -ef | grep "/usr/java/mysql/bin/mysqld"| grep -v grep )" == "" ]    
	then 
		echo "mysql 停了"
		echo "service mysql start">>/bin/start-dead-service.sh
else echo "mysql 正在运行"	
fi 

if [ "$(ps -ef | grep "/usr/java/elasticsearch/config"| grep -v grep )" == "" ]    
	then 
		echo "elasticsearch 停了"
		echo "service elasticsearch start">>/bin/start-dead-service.sh
else echo "elasticsearch 正在运行"	
fi


if [ "$(ps -ef | grep "/usr/bin/fdfs_storaged"| grep -v grep )" == "" ]    
	then 
		echo "fdfs_storaged 停了"
		echo "service fdfs_storaged start">>/bin/start-dead-service.sh
else echo "fdfs_storaged 正在运行"	
fi

if [ "$(ps -ef | grep "/usr/bin/fdfs_trackerd"| grep -v grep )" == "" ]    
	then 
		if [ $(hostname) != "centos-102" ]
			then
				echo "fdfs_trackerd 停了"
				echo "service fdfs_trackerd start">>/bin/start-dead-service.sh
		fi
else echo "fdfs_trackerd 正在运行"	
fi

if [ "$(ps -ef | grep "/bin/sh /usr/java/rabbitmq/sbin/rabbitmq-server"| grep -v grep )" == "" ]    
	then 
		echo "rabbitmq 停了"
		echo "service rabbitmq start">>/bin/start-dead-service.sh
else echo "rabbitmq 正在运行"	
fi

if [ "$(ps -ef | grep "bin/redis-server 0.0.0.0:6379"| grep -v grep )" == "" ]    
	then 
		echo "redis-6379 停了"
		echo "service redis-6379 start">>/bin/start-dead-service.sh
else echo "redis-6379 正在运行"	
fi
if [ "$(ps -ef | grep "bin/redis-server 0.0.0.0:6380"| grep -v grep )" == "" ]    
	then 
		echo "redis-6380 停了"
		echo "service redis-6380 start">>/bin/start-dead-service.sh
else echo "redis-6380 正在运行"	
fi
if [ "$(ps -ef | grep "/usr/java/jdk/bin/java -Dzookeeper"| grep -v grep )" == "" ]    
	then 
		echo "zookeeper 停了"
		echo "service zookeeper start">>/bin/start-dead-service.sh
else echo "zookeeper 正在运行"	
fi
echo "echo \"\">/bin/start-dead-service.sh">>/bin/start-dead-service.sh

exit 0
eeooff
