[Centos 7 安装 FastDFS](08-安装-FastDFS.md)

[CentOS 7 安装 Nginx](09-安装-Nginx.md)

[FastDFS 和 Nginx 整合](10-FastDFS-和-Nginx-整合.md)

[Nginx+Keepalived 实现主备切换](17-Nginx+Keepalived-实现主备切换.md)


##### 1、安装环境与版本

3个CentOS 7 虚拟机 

2个tracker3个storage

3个 nginx，虚拟ip为  192.168.200.99

| 192.168.200.100(centos-100) | 192.168.200.101(centos-101) | 192.168.200.102(centos-102) |
| ---------------- | ------------------- | ------------------ |
| tracker  | tracker    |                       |
| storage（group1） | storage（group1） | storage（group2） |
| nginx | nginx |      nginx       |
##### 2、配置tacker

```$ vi /etc/fdfs/tracker.conf```

```
store_lookup=2 #0是轮询，1是指定组,2是负载均衡，
#store_group=group2 #如果store_lookup=1.那么一定要填这项，会一直往这个组里上传
```

三台tracker配置一样

##### 3、.配置storage

```$ vi /etc/fdfs/storage.conf```

```
tracker_server=centos-100:22122
tracker_server=centos-101:22122

group_name=group1 #注意组名
port=23000 #storage 的端口号,同一个组的 storage 端口号必须相同
```

```$ service fdfs_trackerd  restart && service fdfs_storaged  restart``` 

查看storage的日志，发现centos-101主机的tacker被选为leader

```
set tracker leader: 192.168.200.101:22122
```

在centos-100主机的storage日志中,发现storage成功连上了centos-101的storage，因为他们都是group1

```
successfully connect to storage server 192.168.200.101:23000
```

在traker日志中，也发现centos-102主机的tacker被选为leader

```
the tracker leader is 192.168.200.102:22122
```



##### 4、测试

关掉 tracker leader centos-101 ```service fdfs_trackerd  stop```发现tracker leader成功更换为centos-100，而且连不上centos-101了

```
#storage 日志
set tracker leader: 192.168.200.100:22122
connect to tracker server 192.168.200.101:22122 fail, errno: 111, error info: Connection refused
```

```
#tracker 日志
the tracker leader is 192.168.200.100:22122
```

再次启动centos-101的tracker,```service fdfs_trackerd start```，storage成功连上，但没有更换tracker leader

```
successfully connect to tracker server 192.168.200.101:22122
```



查看集群的信息：```$ /usr/bin/fdfs_monitor /etc/fdfs/storage.conf```

```$ vi client.conf```

```
tracker_server=centos-100:22122
tracker_server=centos-101:22122
```

测试上传：```$ /usr/bin/fdfs_test /usr/java/fastdfs/conf/client.conf upload 1.jpg```

上传到group1的图片在两台主机上都能查询到

```$ cd / && find -name wKjIZlyK-sKAYMX3AADtXa53YW0412.PNG```

##### 5、安装ngx_cache_pure模块

```$ cd /usr/java```

```$ wget http://labs.frickle.com/files/ngx_cache_purge-2.3.tar.gz```

```$ tar -zxvf ngx_cache_purge-2.3.tar.gz```

```$ mv ngx_cache_purge-2.3 ngx_cache_purge```



```$ ./configure --prefix=/usr/java/nginx --with-http_stub_status_module --with-http_ssl_module --add-module=/usr/java/fastdfs-nginx-module/src --add-module=/usr/java/ngx_cache_purge```

##### 6、配置nginx

```$ vi /etc/fdfs/mod_fastdfs.conf```

```
tracker_server=centos-100:22122
tracker_server=centos-101:22122

group_name=group1 #注意组名
group_count = 2

[group1]
group_name=group1
storage_server_port=23000
store_path_count=1
store_path0=/home/fastdfs/fdfs_storage

[group2]
group_name=group2
storage_server_port=23000
store_path_count=1
store_path0=/home/fastdfs/fdfs_storage
```



```$ vi /usr/java/nginx/conf/nginx.conf```

```
	include       mime.types;
    default_type  application/octet-stream;

    sendfile        on;  
    tcp_nopush      on;  
    keepalive_timeout  65;

    #设置缓存  
    server_names_hash_bucket_size 128;  
    client_header_buffer_size 32k;  
    large_client_header_buffers 4 32k;  
    client_max_body_size 300m;  
  
    proxy_redirect off;  
    proxy_set_header Host $http_host;  
    proxy_set_header X-Real-IP $remote_addr;  
    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;  
    proxy_connect_timeout 90;  
    proxy_send_timeout 90;  
    proxy_read_timeout 90;  
    proxy_buffer_size 16k;  
    proxy_buffers 4 64k;  
    proxy_busy_buffers_size 128k;  
    proxy_temp_file_write_size 128k;
    #设置缓存存储路径，存储方式，分别内存大小，磁盘最大空间，缓存期限  
    proxy_cache_path /home/fastdfs/cache/nginx/proxy_cache levels=1:2 
    keys_zone=http-cache:200m max_size=1g inactive=30d;
    proxy_temp_path /home/fastdfs/cache/nginx/proxy_cache/tmp;
    #group1的服务设置  
    upstream fdfs_group1 {  
         server centos-100:8888 weight=1 max_fails=2 fail_timeout=30s;  
         server centos-101:8888 weight=1 max_fails=2 fail_timeout=30s;  
    }
    
    server {
        listen       80;
        server_name  localhost;

        #group1的负载均衡配置  
        location /group1/M00 {  
            proxy_next_upstream http_502 http_504 error timeout invalid_header;  
            proxy_cache http-cache;  
            proxy_cache_valid 200 304 12h;  
            proxy_cache_key $uri$is_args$args;  
            #对应group1的服务设置  
            proxy_pass http://fdfs_group1;  
            expires 30d;  
			ngx_fastdfs_module; //****重要****
        }
        location /group2/M00 {  
            proxy_next_upstream http_502 http_504 error timeout invalid_header;  
            proxy_cache http-cache;  
            proxy_cache_valid 200 304 12h;  
            proxy_cache_key $uri$is_args$args;  
            #对应group2的服务设置  
            proxy_pass http://centos-102:8888;  
            expires 30d;  
			ngx_fastdfs_module;//****重要****
         }
        location ~/purge(/.*) {  
            allow 127.0.0.1;  
            allow 192.168.200.0/24;  
            deny all;  
            proxy_cache_purge http-cache $1$is_args$args;  
        }        
        location / {
            root   html;
            index  index.html index.htm;
        }

        error_page  404              /404.html;

        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
```

```$ mkdir -p /home/fastdfs/cache/nginx/proxy_cache```

```$ mkdir -p /home/fastdfs/cache/nginx/proxy_cache/tmp```



重启nginx和keepalived

通过虚拟ip 192.168.200.99 访问

http://192.168.200.99/group1/M00/00/00/wKjIZVyLMi6AH08jAADtXa53YW0605.PNG

[keepalived+nginx对多tracker进行高可用热备](https://blog.csdn.net/zs1041126478/article/details/79083291)
