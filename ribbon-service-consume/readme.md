# 参考文档
[博客3](https://www.fangzhipeng.com/springcloud/2017/06/02/sc02-rest-ribbon.html)

# ribbon （rpc的一种实现）
服务消费者通过restful方式，远程调用服务


# 访问当前服务接口
启动两个 service-hi 服务，端口分别为： 8762和8763
在浏览器上多次访问http://localhost:8764/hi?name=forezp，浏览器交替显示：

    hi forezp,i am from port:8762
    hi forezp,i am from port:8763
这说明当我们通过调用restTemplate.getForObject(“http://SERVICE-HI/hi?name=”+name,String.class)方法时，已经做了负载均衡，访问了不同的端口的服务实例。

