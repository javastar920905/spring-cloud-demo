package com.javastar920905.springbootcustom.controller;

import com.javastar920905.springbootcustom.annotation.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ouzhx on 2018/9/19.
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "hello";
    }

    @RequestMapping("/test")
    @Test("测试")
    public List<String> getById() {
        System.err.println("IndexController#getById ");
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("qwe");
        list.add("asd");
        return list;
    }

}
