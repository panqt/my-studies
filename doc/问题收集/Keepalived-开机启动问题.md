发现每次启动主机，Keepalived都没有运行。
明明已经设置开机启动了。
看了系统开机日志，发现Keepalived启动的非常早，比nginx，mycat，mysql都早，
然后一运行检查脚本，kill掉了自己。
真的非常奇怪，明明Keepalived设置的启动优先级比nginx，mycat，mysql都低，却比他们先启动。。。

后来发现是 /lib/systemd/system/keepalived.service  搞的鬼。。。
/lib/systemd/system/keepalived.service 是 systemd 的启动程序，也是开机启动，在这里改启动顺序，或者删掉这个systemd 。使用init.d启动
