package com.example.springexam1.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class timeTraceAop {

    @Around("execution(* com.example.springexam1..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("start: " + joinPoint.toLongString());
        try {
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs=finish-start;
            System.out.println("end: " + joinPoint.toLongString() + " " + timeMs + "Ms");
        }


    }
}
