package com.brandon.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class oneRandomAspect {

    @Before("com.brandon.aopdemo.aspect.AopExpresions.daoPackageNoGetterSetter()")
    public void oneRandomAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on oneRandomAdvice()");
    }

}
