package com.brandon.aopdemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AopExpresions {

    @Pointcut("execution(* com.brandon.aopdemo.dao.*.*(..))")
    public void daoPackage() {
    }

    @Pointcut("execution(* com.brandon.aopdemo.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* com.brandon.aopdemo.dao.*.set*(..))")
    public void setter() {
    }

    @Pointcut("daoPackage() && !(getter() || setter())")
    public void daoPackageNoGetterSetter() {
    }

}
