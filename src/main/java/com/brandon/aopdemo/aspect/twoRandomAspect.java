package com.brandon.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class twoRandomAspect {

    @Before("daoPackageNoGetterSetter()")
    public void twoRandomAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on twoRandomAdvice()");
    }

}
