##### 1、备份

首先进入/etc/yum.repos.d/目录下，新建一个repo_backup目录，用于保存系统中原来的repo文件

```$ cd /etc/yum.repos.d```

```$ mkdir repo_backup```

```$ mv *.repo ./repo_backup```



##### 2、下载阿里云和网易 yum源

```$ wget http://mirrors.aliyun.com/repo/Centos-7.repo```

``` $ wget http://mirrors.163.com/.help/CentOS7-Base-163.repo```





##### 3、安装epel源

```$ yum install -y epel-release```

```$ wget https://mirrors.aliyun.com/repo/epel-7.repo```



##### 4、清除缓存

```$  yum clean all && yum makecache```



##### 5、查看系统可用的源

```$ yum repolist enabled```
<br>
附录：[Yum 命令参考](Yum-命令.md)