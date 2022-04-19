package com.lovetocode.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoveAopExpressions {

    @Pointcut("execution(* com.lovetocode.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.lovetocode.aopdemo.dao.*.get*(..))")
    public void getters() {}

    @Pointcut("execution(* com.lovetocode.aopdemo.dao.*.set*(..))")
    public void setters() {}

    // Combo pointcut: for execution of all methods in dao package except getters and setters
    @Pointcut("forDaoPackage() && !(getters() || setters())")
    public void forDaoPackageNoGettersOrSetters() {}

}
