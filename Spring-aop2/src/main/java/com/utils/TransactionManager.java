package com.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionManager {

    @Pointcut("execution(* com.Dao.*.*(..))")
    public void pc(){}

    @Before("pc()")
    public void begin(){
        System.out.println("---开启事务---");
    }

    @After("pc()")
    public void commit(){
        System.out.println("---提交事务---");
    }

    @Around("pc()")
    public Object printExecuteTime(ProceedingJoinPoint point) throws Throwable {
        long time1 = System.currentTimeMillis();
        Object v = point.proceed();
        long time2 = System.currentTimeMillis();
        System.out.println("time:"+(time2-time1));
        return v;
    }
}
