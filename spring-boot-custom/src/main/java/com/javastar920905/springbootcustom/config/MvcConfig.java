package com.javastar920905.springbootcustom.config;

import com.javastar920905.springbootcustom.inteceptor.CustomInteceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author ouzhx on 2018/9/19.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求
        registry.addInterceptor(new CustomInteceptor()).addPathPatterns("/**");
        //super.addInterceptors(registry);
    }
}
