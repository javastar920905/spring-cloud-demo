package com.javastar920905.springbootcustom.annotation;

import java.lang.annotation.*;

/**
 * @author ouzhx on 2018/9/19.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Test {
    String value();
}
