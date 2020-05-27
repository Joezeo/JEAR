# JEAR 监听事件框架
    事件分为本地事件(Normal Event)，远程事件(Remote Event)；类似地对应的监听器也分为本地事件监听器和远程事件监听器
    
## 底层框架的使用
1. 为提高开发效率使用了lombok框架
```$maven
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.12</version>
    </dependency>
```
2. 远程通信考虑使用netty框架以及akka框架