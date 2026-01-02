package com.brandon.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class oneRandomAspect {

    @Before("daoPackageNoGetterSetter()")
    public void oneRandomAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on oneRandomAdvice()");
    }

}
