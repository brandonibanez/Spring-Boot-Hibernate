package com.brandon.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class twoRandomAspect {

    @Before("com.brandon.aopdemo.aspect.AopExpresions.daoPackageNoGetterSetter()")
    public void twoRandomAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on twoRandomAdvice()");
    }

}
