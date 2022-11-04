package com.example.ex3.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Configuration
@Aspect
@EnableAspectJAutoProxy
public class MyLoggingAspect {

    /**
     * jointpoint(locul de actiune al aspectului)
     * point cut(expresie ce identifica locul de actiune)
     * advice( before,after returning,after throwing,after,around)
     */
    @Pointcut("execution(* com.example.ex3.service.*.*(..))")
    public void firstPointCut(){}


    @Before(value = "firstPointCut()")
    public void doLoggingBefore(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName =  signature.getMethod().getName();
        System.out.println("Executing aspect method before " + methodName);
    }


    @AfterReturning(value = "firstPointCut()", returning = "result")
    public void doLoggingAfterReturning(JoinPoint joinPoint, Object result){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName =  signature.getMethod().getName();
        System.out.println(" Executing aspect after returning " + result + " in " + methodName);
    }

    @Around(value = "firstPointCut()")
    public Object doLoggingAround(ProceedingJoinPoint proceedingJoinPoint){
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName =  signature.getMethod().getName();
        System.out.println(" Executing around in method " + methodName);
        try {
            return proceedingJoinPoint.proceed(new Object[]{7});
        } catch (Throwable e) {
            e.printStackTrace();
            return 0;
        }
    }
}
