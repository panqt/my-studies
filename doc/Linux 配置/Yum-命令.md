Yum: 即Yellowdog Update Modifier,是一种基于rpm的包管理工具



##### yum仓库

```shell
#显示可用的仓库
repolist enabled
```


<br>
##### 应用程序包

```shell
#可用程序包
[root@local100 nginx]# yum list tre?
可安装的软件包
tree.x86_64                                      1.6.0-10.el7

[root@local100 nginx]# yum list available tre?
可安装的软件包
tree.x86_64                                      1.6.0-10.el7 
```

```shell
#程序包信息
yum info tree
```

```shell
#安装 tree 程序
yum install -y tree
```

```shell
#已安装程序包
yum list installed
```



```shell
#搜索程序包
yum search php
```
<br>
附录：[CentOS 7 使用国内yum和epel源](使用国内yum和epel源.md)