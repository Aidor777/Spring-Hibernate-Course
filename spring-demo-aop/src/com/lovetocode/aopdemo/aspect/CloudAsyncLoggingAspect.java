package com.lovetocode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudAsyncLoggingAspect {

    @Before("com.lovetocode.aopdemo.aspect.LoveAopExpressions.forDaoPackageNoGettersOrSetters()")
    public void logToCloudAsync() {
        System.out.println("\n=====>>> Logging to the Cloud in an async fashion");
    }
}
