package cn.javabus.feignservicecomsume.hystric;

import cn.javabus.feignservicecomsume.feignclient.ServiceHiClient;
import org.springframework.stereotype.Component;

/**
 * 断路器 需要实现对应的feign接口
 */
@Component
public class ServiceHiClientHystric implements ServiceHiClient {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry hystric 熔断"+name;
    }
}
