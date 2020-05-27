# JEAR 监听事件框架
    事件分为本地事件(Normal Event)，远程事件(Remote Event)；类似地对应的监听器也分为本地事件监听器和远程事件监听器
    
## 底层框架的使用
1. 为提高开发效率使用了lombok框架、commons.lang框架
```maven
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.12</version>
    </dependency>

    <dependency>
      <groupId>org.apache.commons</groupId>
      <artifactId>commons-lang3</artifactId>
      <version>3.5</version>
    </dependency>
```

2. 框架日志系统使用Log4j+Sl4j
```maven
    <dependency>
      <groupId>log4j</groupId>
      <artifactId>log4j</artifactId>
      <version>1.2.17</version>
    </dependency>
```

3. 远程通信考虑使用netty框架以及akka框架