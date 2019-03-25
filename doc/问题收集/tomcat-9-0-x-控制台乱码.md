根本原因，tomcat 输出的东西，与cmd控制台或者IDE控制台编码不一致。

误区： 修改 ```JAVA_OPTS   -Dfile.encoding=GBK```。 原因：影响范围太大。

应修改tomcat输出内容的编码，```%CATALINA_HOME%/conf/logging.properties```

9.0.14版本比9.0.12版本多了如下代码

```java.util.logging.ConsoleHandler.encoding = UTF-8```
删除：

```#java.util.logging.ConsoleHandler.encoding = UTF-8```
或者改成和控制台一致的编码比如```GBK```
--------------------- 
作者：ET最终珍藏版 
来源：CSDN 
原文：https://blog.csdn.net/colcool/article/details/85180935 
版权声明：本文为博主原创文章，转载请附上博文链接！
