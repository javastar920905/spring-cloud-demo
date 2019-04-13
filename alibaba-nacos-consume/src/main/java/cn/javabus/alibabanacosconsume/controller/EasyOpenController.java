package cn.javabus.alibabanacosconsume.controller;

import cn.javabus.alibabanacosconsume.feignclient.EasyOpenFeignClient;
import cn.javabus.alibabanacosconsume.util.EasyOpenUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class EasyOpenController {
    @Autowired
    private EasyOpenFeignClient easyOpenFeignClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String sayHello(){
        Map map = EasyOpenUtil.buildParamMap("hello.get");
        return easyOpenFeignClient.sayHello(map);
    }

    @GetMapping("/hi")
    public String sayHello2(){
        String url="http://localhost:8888/api";
        Map<String,Object> paramsMap= EasyOpenUtil.buildParamMap("hello.get");
        Map<String,Object> resultMap=  restTemplate.postForObject(url, paramsMap,Map.class);
        System.out.println(JSON.toJSONString(resultMap));
        return "ok";
    }
}
