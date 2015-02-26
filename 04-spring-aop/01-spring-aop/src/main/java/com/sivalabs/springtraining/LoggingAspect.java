package com.sivalabs.springtraining;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
 
	@Before("execution(* com.sivalabs.springtraining.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
 
		System.out.println("logBefore() is running!");
		System.out.println("Executing : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
 
	@After("execution(* com.sivalabs.springtraining.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
 
		System.out.println("logAfter() is running!");
		System.out.println("completed : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
	
	@Around("execution(* com.sivalabs.springtraining.*.*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
 
		System.out.println("logAround() is running!");
		Object result = joinPoint.proceed();
		System.out.println("completed : " + joinPoint.getSignature().getName());
		return result;
	}
	
}
