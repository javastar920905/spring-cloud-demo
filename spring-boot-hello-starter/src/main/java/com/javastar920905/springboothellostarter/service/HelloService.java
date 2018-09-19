package com.javastar920905.springboothellostarter.service;

import lombok.Data;

/**
 * @author ouzhx on 2018/9/19.
 */
@Data
public class HelloService {
    private String msg;

    public String sayHello() {
        return "Hello " + msg;
    }
}
