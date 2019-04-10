package cn.javabus.feignservicecomsume.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi")
public interface ServiceHiClient {

    /**
     * 會調用 http://service-hi/hi 服務(service-hi 會到註冊中心查找具體ip和端口)
     * @param name
     * @return
     */
    @GetMapping("/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
