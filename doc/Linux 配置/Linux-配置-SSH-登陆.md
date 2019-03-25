
先看看本地有没有ssh密钥对：~/.ssh/id_rsa

没有就用git bash 或者 cmd生成ssh密钥对：```ssh-keygen -t rsa```

生成密钥时一直下一步，不设置密码可以实现无密码登陆

把公钥上传到linux的 ~/.ssh/目录下

```mkdir ~/.ssh```

```chmod 700 ~/.ssh```

生成authorized_keys文件：```cat id_rsa.pub >>authorized_keys```

```chmod 600 authorized_keys```

```rm -f  id_rsa.pub```

```vi  /etc/ssh/sshd_config```

```
PermitRootLogin yes #允许root登录
PermitEmptyPasswords yes #允许空密码登录
PasswordAuthentication yes #允许密码登陆
RSAAuthentication yes #允许用RSA密钥进行身份验证
PubkeyAuthentication yes #允许用公钥进行身份验证
AuthorizedKeysFile .ssh/authorized_keys #密钥位置
```
```service sshd restart```
