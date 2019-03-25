nginx安装



### 一、官网yum[安装方法](http://nginx.org/en/linux_packages.html#RHEL-CentOS)

```$ sudo vi /etc/yum.repos.d/nginx.repo```

```properties
[nginx-stable]
name=nginx stable repo
baseurl=http://nginx.org/packages/centos/$releasever/$basearch/
gpgcheck=1
enabled=1
gpgkey=https://nginx.org/keys/nginx_signing.key
```

```$ sudo yum install nginx```



### 二、安装包安装

##### 1、安装编译工具及库文件

```$ yum -y install make zlib zlib-devel gcc-c++ libtool  openssl openssl-devel```



##### 2、安装[PCRE](http://www.pcre.org/)库 ```$ yum install -y pcre pcre-devel```
注：安装编译工具及库文件时pcre被依赖，已经安装了，使用```$ yum list installed | grep pcre```查看。
PCRE(Perl Compatible Regular Expressions) 是一个Perl库，包括 perl 兼容的正则表达式库。nginx 的 http 模块使用 pcre 来解析正则表达式，所以需要在 linux 上安装 pcre 库，pcre-devel 是使用 pcre 开发的一个二次开发库。nginx也需要此库。命令：
```$ mkdir -p /usr/java```

```$ cd /usr/java```

```$ wget https://ftp.pcre.org/pub/pcre/pcre-8.40.tar.gz```

```$ ./configure --prefix=/usr/java/pcre```

```$ make && make install```

查看pcre版本

```$ pcre-config --version```

配置环境变量



##### 3、安装[nginx](http://nginx.org/en/download.html)
```$ mkdir -p /usr/java```
```$ cd /usr/java```
```$ wget http://nginx.org/download/nginx-1.14.2.tar.gz```

```$ tar -zxvf nginx-1.14.2.tar.gz```

```$ cd  nginx-1.14.2```

```
$ ./configure --prefix=/usr/java/nginx --with-http_stub_status_module --with-http_ssl_module 
# --add-module=/usr/java/fastdfs-nginx-module/src       #fastdfs和nginx整合模块
#--with-pcre=/usr/pcre            #就用默认的，不指定自定义的pcre
```

```$ make && make install```

```$ cd .. && rm -rf nginx-1.14.2```

查看版本：```$ /usr/java/nginx/sbin/nginx -v```

启动：```$ /usr/java/nginx/sbin/nginx```



##### 4、配置

参考：


##### 5、服务脚本
```$ vi  /etc/init.d/nginx```
```
#!/bin/bash
# chkconfig: 2345 85 15
# description: Nginx server control script
# processname: nginx
# config file: /usr/java/nginx/conf/nginx.conf
# pid file: /usr/java/nginx/logs/nginx.pid
# 
# source function library
. /etc/rc.d/init.d/functions

NGINX_PROG="/usr/java/nginx/sbin/nginx"
NGINX_PID_FILE="/usr/java/nginx/logs/nginx.pid"
NGINX_CONF_FILE="/usr/java/nginx/conf/nginx.conf"
NGINX_LOCK_FILE="/var/lock/subsys/nginx.lock"

# check current user
[ "$USER" != "root" ] && exit 1

start() {
    status
        if [[ $? -eq 0 ]]; then
            echo $"Nginx (PID $(cat $NGINX_PID_FILE)) already started."
            return 1
        fi
    echo -n $"Starting nginx: "
        daemon $NGINX_PROG -c $NGINX_CONF_FILE
        retval=$?
        echo
    [ $retval -eq 0 ] && touch $NGINX_LOCK_FILE
    return $retval
}

stop() {
    status
        if [[ $? -eq 1 ]]; then
            echo "Nginx server already stopped."
            return 1
        fi
    echo -n $"Stoping nginx: "
        killproc $NGINX_PROG
        retval=$?
        echo
    [ $retval -eq 0 ] && rm -f $NGINX_LOCK_FILE
    return $retval
}

restart() {
    stop
        sleep 1
    start
    retval=$?
    return $retval
}

reload() {
    echo -n $"Reloading nginx: "
        killproc $NGINX_PROG -HUP
        retval=$?
        echo
    return $retval
}

status() {
    netstat -anpt | grep "/nginx" | awk '{print $6}' &> /dev/null
        if [[ $? -eq 0 ]]; then
            if [[ -f $NGINX_LOCK_FILE ]]; then
                return 0
            else
                return 1
            fi
        fi
    return 1
}

_status() {
    status
        if [[ $? -eq 0 ]]; then
            state=`netstat -anpt | grep "/nginx" | awk '{ print $6 }'`
            echo $"Nginx server status is: $state"
        else
            echo "Nginx server is not running"
        fi
}

test() {
    $NGINX_PROG -t -c $NGINX_CONF_FILE
        retval=$?
    return $retval
}

case "$1" in
    start)
        start
        ;;
    stop)
        stop
        ;;
    reload)
        reload
        ;;
    restart)
        restart
        ;;
    status)
        _status
        ;;
    test)
        test
        ;;
    *)
        echo "Usage: { start | stop | reload | restart | status | test }"
        exit 1
esac
```
```$ chmod 755 /etc/init.d/nginx```
```$ chkconfig nginx on```
```$ service nginx start```

[Nginx+Keepalived 实现高可用](17-Nginx+Keepalived-实现主备切换.md)

[Nginx的默认配置语法](https://www.jianshu.com/p/06e95028943e)
[详解Nginx服务器配置](http://baijiahao.baidu.com/s?id=1604485941272024493&wfr=spider&for=pc)
