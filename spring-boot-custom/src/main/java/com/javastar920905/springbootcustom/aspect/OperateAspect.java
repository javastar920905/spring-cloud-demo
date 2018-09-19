package com.javastar920905.springbootcustom.aspect;

import com.javastar920905.springbootcustom.annotation.Test;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author ouzhx on 2018/9/19.
 * aop常用的注解
 * 1、@Aspect作用是把当前类标识为一个切面供容器读取
 * 2、@before标识一个前置增强方法，相当于BeforeAdvice的功能
 * 3、@after final增强，不管是抛出异常或者正常退出都会执行
 * 4、@Pointcut定义切点
 * 5、@Around
 */
@Aspect
@Component
public class OperateAspect {
    @Pointcut("@annotation(com.javastar920905.springbootcustom.annotation.Test)")
    public void annotationPointCut() {

    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();
        Test annotation = method.getAnnotation(Test.class);
        System.out.print("before 打印：" + annotation.value() + " 开始前");//执行顺序 2
    }

    @Around("annotationPointCut()")
    public Object advice(ProceedingJoinPoint joinPoint) {
        System.out.println("advice 通知之开始");//执行顺序 1
        Object retmsg = null;
        try {
            retmsg = joinPoint.proceed();
            System.err.println("advice end ++++++++" + retmsg);//执行顺序 4
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("advice 通知之结束");
        return retmsg;
    }

    @After("annotationPointCut()")
    public void after() {
        System.out.println("after方法执行后");//执行顺序 3
    }
}
