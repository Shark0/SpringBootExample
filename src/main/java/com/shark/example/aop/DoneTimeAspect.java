package com.shark.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class DoneTimeAspect {

    @Around("@annotation(doneTime)")
    public Object around(ProceedingJoinPoint joinPoint, DoneTime doneTime) throws Throwable {
        System.out.println("start time: " + new Date());
        Object proceed = joinPoint.proceed();
        System.out.println("end time: " + new Date());
        return proceed;
    }
}
