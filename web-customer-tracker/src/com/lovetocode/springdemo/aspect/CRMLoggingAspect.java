package com.lovetocode.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.lovetocode.springdemo.controller.*.*(..))")
    private void forControllers() {}

    @Pointcut("execution(* com.lovetocode.springdemo.service.*.*(..))")
    private void forServices() {}

    @Pointcut("execution(* com.lovetocode.springdemo.dao.*.*(..))")
    private void forDAOs() {}

    @Pointcut("forControllers() || forServices() || forDAOs()")
    private void forApplicationFlow() {}

    @Before("forApplicationFlow()")
    public void beforeApplicationFlowAdvice(JoinPoint joinPoint) {
        logger.info("\n=====>>> @Before method " + joinPoint.getSignature().toShortString());
        Arrays.asList(joinPoint.getArgs()).forEach(arg -> logger.info("=====>>> Argument: " + arg));
    }

    @AfterReturning(pointcut = "forApplicationFlow()", returning = "result")
    public void afterReturningApplicationFlowAdvice(JoinPoint joinPoint, Object result) {
        logger.info("\n=====>>> @AfterReturning from method " + joinPoint.getSignature().toShortString());
        logger.info("=====>>> Return value: " + result);
    }

}
