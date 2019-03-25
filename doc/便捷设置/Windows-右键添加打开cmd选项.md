将下面代码另存为a.reg，运行即可
```java
Windows Registry Editor Version 5.00

[HKEY_CLASSES_ROOT\Directory\Background\shell\此处打开命令行]
"ShowBasedOnVelocityId"=dword:00639bc8

[HKEY_CLASSES_ROOT\Directory\Background\shell\此处打开命令行\command]
@="cmd.exe /s /k pushd \"%V\""
```
