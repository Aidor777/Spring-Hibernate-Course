package com.lovetocode.aopdemo.aspect;

import com.lovetocode.aopdemo.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class DemoLoggingAspect {

    private static final Logger LOGGER = Logger.getLogger(DemoLoggingAspect.class.getName());

//    @Before("execution(public void addAccount())")
//    @Before("execution(public void updateAccount())")
//    @Before("execution(public void com.lovetocode.aopdemo.dao.AccountDAO.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(* add*())")
//    @Before("execution(* add*(com.lovetocode.aopdemo.model.Account))")
//    @Before("execution(* add*(com.lovetocode.aopdemo.model.Account, ..))")
//    @Before("execution(* add*(..))")
//    @Before("execution(* com.lovetocode.aopdemo.dao.*.*(..))")
//    @Before("forDaoPackage()")
//    @Before("forDaoPackageNoGettersOrSetters()")
    @Before("com.lovetocode.aopdemo.aspect.LoveAopExpressions.forDaoPackageNoGettersOrSetters()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("=====>>> Executing @Before advice on method");

        var methodSignature = joinPoint.getSignature();
        System.out.println("Method signature: " + methodSignature);

        System.out.print("Method arguments: ");
        for (var arg : joinPoint.getArgs()) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }

    @AfterReturning(pointcut = "execution(* com.lovetocode.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        System.out.println("\n=====>>> Executing @AfterReturning advice on method: " + joinPoint.getSignature().toShortString());
        System.out.println("=====>>> Result is: " + result);

        // Post-processing data (Careful !)
        result.forEach(account -> account.setName(account.getName().toUpperCase()));
        System.out.println("=====>>> Result is now: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.lovetocode.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println("\n=====>>> Executing @AfterThrowing advice on method: " + joinPoint.getSignature().toShortString());
        System.out.println("=====>>> Exception is: " + exception);
    }

    @After("execution(* com.lovetocode.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        System.out.println("\n=====>>> Executing @After (finally) advice on method: " + joinPoint.getSignature().toShortString());
    }

    @Around("execution(* com.lovetocode.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("\n=====>>> Executing @Around advice on method: " + proceedingJoinPoint.getSignature().toShortString());
        var timeBefore = System.currentTimeMillis();
        Object result;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            // Return a default message (careful with this approach!)
//            result = "Major accident! But no worries, your private AOP helicopter is on the way!";
            throw e;
        }

        var timeAfter = System.currentTimeMillis();
        LOGGER.info("=====>>> Method run time: " + (timeAfter - timeBefore) / 1000.0);
        return result;
    }
}
