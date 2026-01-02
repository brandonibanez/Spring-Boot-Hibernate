package com.brandon.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.brandon.aopdemo.dao.AccountDAO;

@Aspect
@Component
@Order(2)
public class LoggingAspectTime {

    @Before("com.brandon.aopdemo.aspect.AopExpresions.daoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");

        System.out.println("Method: " + theJoinPoint.getSignature());

        for (Object tempArg : theJoinPoint.getArgs()) {
            System.out.println("Argument: " + tempArg);
        }
    }

    @AfterReturning(
            pointcut = "com.brandon.aopdemo.aspect.AopExpresions.setter()",
            returning = "result"
    )
    public void afterReturningSetName(JoinPoint theJoinPoint, String result) {
        System.out.println("\n=====>>> Executing @AfterReturning advice on setName()");
        result = result.toUpperCase();
        System.out.println("Result: " + result);
    }

    // @AfterThrowing(
    //         pointcut = "com.brandon.aopdemo.aspect.AopExpresions.setter()",
    //         throwing = "theExc"
    // )
    // public void afterThrowingSetName(JoinPoint theJoinPoint, RuntimeException theExc) {
    //     System.out.println("\n=====>>> Executing @AfterThrowing advice on setName()");
    //     System.out.println("Exception: " + theExc);
    // }

    // @After("com.brandon.aopdemo.aspect.AopExpresions.daoPackageNoGetterSetter()")
    // public void afterFinallyAddAccount(JoinPoint theJoinPoint) {
    //     System.out.println("\n=====>>> Executing @After (finally) advice on addAccount()" + theJoinPoint.getSignature().toShortString());
    // }

    @Around("com.brandon.aopdemo.aspect.AopExpresions.setter()")
    public Object afterFinallyAddAccount(ProceedingJoinPoint theJoinPoint) throws Throwable {
        System.out.println("\n=====>>> Executing @Around advice on setName()" + theJoinPoint.getSignature().toShortString());
        Object result = null;
        try {
            result = theJoinPoint.proceed();
        } catch (Throwable e) {
            // e.printStackTrace();
            result = "Major Exception handled and returned value instead!";
        }
        return result;
    }

    @Around("com.brandon.aopdemo.aspect.AopExpresions.getter()")
    public Object aroundGetters(ProceedingJoinPoint theJoinPoint) throws Throwable {
        System.out.println("\n=====>>> Executing @Around advice on getters");
        System.out.println("Method: " + theJoinPoint.getSignature().toShortString());
        long begin = System.currentTimeMillis();
        Object result = theJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("\n=====>>> Duration: " + (end - begin) / 1000.0 + " seconds");
        return result;
    }

}
