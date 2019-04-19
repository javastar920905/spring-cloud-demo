package cn.javabus.alibabanacosconsume.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * 模拟easyopen api 服务调用
 */
@FeignClient(value = "easyopen-server-manual")
public interface EasyOpenFeignClient {

    /**
     * 会调用服务  http://注册的服务名/api  攔截器中會自動講參數放置到header中
     * @return
     */
    @PostMapping("api")
    String sayHello(@RequestBody Map param);
}
