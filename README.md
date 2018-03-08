# MySSM

### 相关技术
- 前端：Bootstrap、Bootstrap Fileinput插件
- 框架：Spring MVC、Spring、Mybatis
- 分布式框架：Dubbo、Zookeeper
- 连接池：Durid
- 数据库：Mysql、Redis

### 目录结构
```shell
├─SSM-API                       //API
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─xioruu
│      │  │          ├─api          
│      │  │          └─dto
│      │  └─resources
│      └─test
│          └─java
├─SSM-BOOT                      //提供给内部使用的dubbo依赖
│  └─src
│      ├─main
│      │  ├─java
│      │  │  └─com
│      │  │      └─xioruu
│      │  │          └─api
│      │  └─resources
│      │      └─applicationContext
│      └─test
│          └─java
├─SSM-SERVICE                   //Web应用
│   └─src
│       ├─main
│       │  ├─java
│       │  │  └─com
│       │  │      └─xioruu
│       │  │          ├─api
│       │  │          │  └─impl         //接口实现
│       │  │          ├─domain          //实体类
│       │  │          ├─intercept       //应用aop缓存数据到redis
│       │  │          ├─manage  
│       │  │          │  ├─controller   //控制器层
│       │  │          │  ├─dao          //dao层
│       │  │          │  └─service      //业务层
│       │  │          ├─shiro           //shiro相关代码
│       │  │          └─utils           //工具类
│       │  ├─resources
│       │  │  ├─applicationContext      //spring配置文件
│       │  │  └─sql                     //数据库脚本
│       │  └─webapp                     //前端文件
│       │      ├─bootstrap
│       │      ├─bootstrap-fileinput    //图片上传
│       │      ├─jquery
│       │      ├─js
│       │      └─WEB-INF
│       │          └─jsp                
│       │              ├─common         //公用页面
│       │              │  └─error
│       │              └─manage         //业务页面
│       │                  ├─login
│       │                  └─user
│       └─test
│           ├─java
│           │  └─com
│           │      └─xioruu
│           │          ├─redis
│           │          ├─spring
│           │          └─utils
│           └─resources
├─.gitignore
├─pom.xml
├─readme.md
```


### 应用截图
![登陆](https://blogcase-1256125353.cos.ap-shanghai.myqcloud.com/%E7%99%BB%E9%99%86.PNG)
![用户列表](https://blogcase-1256125353.cos.ap-shanghai.myqcloud.com/%E7%94%A8%E6%88%B7%E5%88%97%E8%A1%A8.PNG)
![edit](https://blogcase-1256125353.cos.ap-shanghai.myqcloud.com/%E7%94%A8%E6%88%B7%E4%BF%A1%E6%81%AF%E7%BC%96%E8%BE%91.PNG)
![redis缓存](https://blogcase-1256125353.cos.ap-shanghai.myqcloud.com/redis%E7%BC%93%E5%AD%98.PNG)
![comsumer](https://blogcase-1256125353.cos.ap-shanghai.myqcloud.com/consumer.PNG)


### 相关文章
[xioruu's blog：zookeeper集群配置](http://xioruu.github.io/2017/12/18/zookeeper集群配置/)


### 需要修改的配置
#### mysql
修改SSM-SERVICE中的jdbc.priperties
```properties
jdbc.url=jdbc:mysql://localhost:3306/MySSM
jdbc.username=root
jdbc.password=123456
```

#### redis
修改SSM-SERVICE中的redis.properties
```properties
redis.host=192.168.0.100
```

#### zookeeper
1. 修改SSM-API中的applicationContext-dubbo-consumer.xml
2. 修改SSM-SERVICE中的applicationContext-dubbo-provider.xml
```xml
<dubbo:registry address="zookeeper://192.168.0.100:2181"/>
```


### 几点说明
- 服务器启动前需要先启动zookeeper
- redis不启动不会影响服务器启动，之后获取用户信息时会报错但不影响使用
- 端口设为8090而不是8080


