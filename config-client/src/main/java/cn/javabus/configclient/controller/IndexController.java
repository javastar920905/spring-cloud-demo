package cn.javabus.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Value("${foo}")
    String foo;

    @GetMapping(value = "/hi")
    public String hi() {
        return foo;
    }

}
