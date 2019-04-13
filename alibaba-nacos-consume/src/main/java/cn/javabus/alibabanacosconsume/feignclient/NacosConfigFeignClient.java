package cn.javabus.alibabanacosconsume.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-config")
public interface NacosConfigFeignClient {

    /**
     * 会调用服务  http://注册的服务名/echo/{name}
     * @param name
     * @return
     */
    @GetMapping("/echo/{name}")
    String ehcoSth(@PathVariable String name);
}
