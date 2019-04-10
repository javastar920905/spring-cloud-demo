package cn.javabus.feignservicecomsume.controller;

import cn.javabus.feignservicecomsume.feignclient.ServiceHiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    ServiceHiClient serviceHiClient;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return serviceHiClient.sayHiFromClientOne(name);
    }
}
