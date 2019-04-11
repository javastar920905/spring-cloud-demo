package com.javastar920905.springboothellostarter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ouzhx on 2018/9/19.
 */
@ConfigurationProperties(prefix = "hello")
@Data
public class HelloServiceProperties  {
    private String msg;
}
