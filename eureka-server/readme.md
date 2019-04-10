# 参考文档
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
[高可用的服务注册中心](https://www.fangzhipeng.com/springcloud/2017/06/10/sc-ha-eureka.html)

按照官方文档的指示，需要改变etc/hosts，linux系统通过vim /etc/hosts ,加上：

    127.0.0.1 peer1
    127.0.0.1 peer2
    windows电脑，在c:/windows/systems/drivers/etc/hosts 修改。
    
在eureka-server工程中resources文件夹下，

    创建配置文件application-peer1.yml
    创建另外一个配置文件application-peer2.yml
    

启动eureka-server：

    java -jar eureka-server-0.0.1-SNAPSHOT.jar - -spring.profiles.active=peer1
    java -jar eureka-server-0.0.1-SNAPSHOT.jar - -spring.profiles.active=peer2


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