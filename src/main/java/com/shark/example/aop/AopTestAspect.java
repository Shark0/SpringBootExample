package com.shark.example.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Slf4j
@Aspect
@Component
public class AopTestAspect {

    @Around("@annotation(aopTest)")
    public Object around(ProceedingJoinPoint joinPoint, AopTest aopTest) throws Throwable {
        log.info("around start time: {}", new Date());
        Object proceed = joinPoint.proceed();
        log.info("around end time: {}", new Date());
        return proceed;
    }
}
