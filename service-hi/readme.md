# 參考文檔
[博客-2](https://www.fangzhipeng.com/springcloud/2017/06/01/sc01-eureka.html)

# 創建項目
通过注解@EnableEurekaClient 表明自己是一个eurekaclient.

仅仅@EnableEurekaClient是不够的，还需要在配置文件中注明自己的服务注册中心的地址

需要指明spring.application.name,这个很重要，这在以后的服务与服务之间相互调用一般都是根据这个name 。

# 启动后，在註冊中心查看服務是否成功注册
打开注册中心server地址 http://localhost:8761
查看是否注册了 服务名为SERVICE-HI ,端口为7862

# 测试当前服务 
这时打开 http://localhost:8762/hi?name=forezp 