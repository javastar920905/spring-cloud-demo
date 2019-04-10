# 參考文檔
[config-server](https://www.fangzhipeng.com/springcloud/2017/06/06/sc06-config.html)

## demo 測試

    http请求地址和资源文件映射如下:
    /{application}/{profile}[/{label}]
    /{application}-{profile}.yml
    /{label}/{application}-{profile}.yml
    /{application}-{profile}.properties
    /{label}/{application}-{profile}.properties
    
访问http://localhost:8888/foo/dev

    {"name":"foo","profiles":["dev"],"label":null,"version":"a2d82da1ac95d485ad7a4250fe5d189a8cb41cb2","state":null,"propertySources":[]}
    
## 高可用的配置中心
[高可用的分布式配置中心](https://www.fangzhipeng.com/springcloud/2017/06/07/sc07-config.html)

### 配置中心改造
     <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
     //將服務註冊到 服務註冊中心(eureka-server)
     @EnableEurekaClient
     
配置文件application.yml，指定服务注册地址为http://localhost:8761/eureka/
    
    eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
    
    
### 客戶端改造
    添加以依賴
      <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    @EnableDiscoveryClient 從註冊中心查詢服務

配置文件application.yml，指定服务注册地址为http://localhost:8761/eureka/
    eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka/
    spring.cloud.config.discovery.enabled=true
    spring.cloud.config.discovery.serviceId=config-server

