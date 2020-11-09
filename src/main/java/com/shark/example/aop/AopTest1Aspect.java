package com.shark.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Aspect
@Component
public class AopTest1Aspect {

    @Pointcut("execution(* com.shark.example.controller.*.*(..))")
    public void AopTest1Aspect() {}

    @Before("AopTest1Aspect()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("before");
    }

    @After("AopTest1Aspect()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("after");
    }

    @AfterReturning("AopTest1Aspect()")
    public void doAfterReturning(JoinPoint joinPoint) {
        log.info("after returning");
    }

    @AfterThrowing("AopTest1Aspect()")
    public void doAfterThrowing(JoinPoint joinPoint) {
        log.info("do after throwing");
    }

//    @Around("AopTest1Aspect()")
//    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("do around before");
//        Object proceed = joinPoint.proceed();
//        log.info("do around after");
//        return proceed;
//    }
}
