# 参考文档
[入门文档-开启健康检查](https://blog.battcn.com/2017/07/25/springcloud/dalston/spring-cloud-discovery/)
[方志朋的博客](https://www.fangzhipeng.com/springcloud/2017/06/01/sc01-eureka.html)

# idea中 使用spring initial 创建项目

# 项目介绍
eureka-server启动一个服务注册中心

# 使用介绍
eureka server 是有界面的，启动工程,打开浏览器访问： http://localhost:8761

注册中心，启动后就处于等待服务提供者 (eureka client)注册服务，状态

#接下来需要创建一个服务提供者(eureka client)
当client向server注册时，它会提供一些元数据，例如主机和端口，URL，主页等。
Eureka server 从每个client实例接收心跳消息。 如果心跳超时，则通常将该实例从注册server中删除。
 
## 服务注册中心高可用
[高可用的服务注册中心](http://www.ityouknow.com/springcloud/2017/05/10/springcloud-eureka.html)
注册中心这么关键的服务，如果是单点话，遇到故障就是毁灭性的。

在一个分布式系统中，服务注册中心是最重要的基础部分，理应随时处于可以提供服务的状态。

为了维持其可用性，使用集群是很好的解决方案。

Eureka通过互相注册的方式来实现高可用的部署，所以我们只需要将Eureke Server配置其他可用的serviceUrl就能实现高可用部署。

1 按照官方文档的指示，需要改变etc/hosts，linux系统通过vim /etc/hosts ,加上：

    127.0.0.1 peer1
    127.0.0.1 peer2
    windows电脑，在c:/windows/systems/drivers/etc/hosts 修改。
    
2 在eureka-server工程中resources文件夹下，

    创建配置文件          application-peer1.yml
    创建另外一个配置文件   application-peer2.yml
    

3 启动双节点注册中心 eureka-server：

    java -jar eureka-server-0.0.1-SNAPSHOT.jar - -spring.profiles.active=peer1 (启动第一个的时候会报错,继续启动第二个就ok了)
    java -jar eureka-server-0.0.1-SNAPSHOT.jar - -spring.profiles.active=peer2
    
    访问 http://localhost:8761/ http://localhost:8769/


### 改造服务注册地址
这时需要改造下service-hi:

eureka:
  client:
    serviceUrl:
      defaultZone: http://peer1:8761/eureka/
server:
  port: 8762
spring:
  application:
    name: service-hi