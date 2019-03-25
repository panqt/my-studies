给用户添加写权限：``` chmod u+w /etc/sudoers ```
编辑文件 ``` vi /etc/sudoers ```
找到这一 行：``` root ALL=(ALL) ALL ```在起下面添加``` panqt ALL=(ALL) ALL``` (panqt 是用户名)
撤销用户写权限：``` chmod u-w /etc/sudoers ```
如此，用户就可以拥有sudo权限了
