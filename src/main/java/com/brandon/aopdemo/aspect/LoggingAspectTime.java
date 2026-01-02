package com.brandon.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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

}
