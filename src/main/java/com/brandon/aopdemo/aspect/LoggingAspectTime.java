package com.brandon.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspectTime {

    @Pointcut("execution(* com.brandon.aopdemo.dao.*.*(..))")
    public void daoPackage() {}

    @Pointcut("execution(* com.brandon.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.brandon.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("daoPackage() && !(getter() || setter())")
    public void daoPackageNoGetterSetter() {} 

    @Before("daoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

}
