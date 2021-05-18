package com.spring.basic_aop_aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopAspect {
   @Pointcut("execution(* com.spring.basic_aop_aspect.*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void begin(){
        System.out.println("begin aspect");
    }
    @After("pointCut()")
    public void after(){
        System.out.println("after apect");
    }
}
