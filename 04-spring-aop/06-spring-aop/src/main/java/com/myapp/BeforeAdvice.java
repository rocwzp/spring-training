/**
 * 
 */
package com.myapp;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author user
 *
 */
@Aspect
@Component
public class BeforeAdvice {
	//pointcut - target classes/methods
	//joinpoint - method execution
	//Aspect
	//Advice
	/*
		Before
		After
		AfterReturning
		AfterThrowing
		Around
	*/
	@Pointcut("execution(* com.myapp..*(String,Integer))")
	public void myPointcut()
	{}
	
	@Before("myPointcut()") 
	@Order(2)
	public void doBeforeCheck(JoinPoint joinPoint) {
        System.out.println("-----before--------");
        System.out.println("The method " + joinPoint.getSignature().getName()
        		+ "() begins with " + Arrays.toString(joinPoint.getArgs()));
    }

	
	@After("myPointcut()")
	public void doAfterCheck(JoinPoint joinPoint) {
        System.out.println("-----after--------");
        System.out.println("The method " + joinPoint.getSignature().getName()
        		+ "() ends");
    }
	
	@Around("myPointcut()")
	@Order(1)
	public Object doArounfCheck(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("-----around-before-------");
        Object retVal = pjp.proceed();
        System.out.println("-----around-after-------");
        return retVal;
    }
	
	/*@AfterReturning(pointcut="execution(* com.myapp..*(..))", returning="returnValue")
	public void afterReturning(JoinPoint joinPoint, Object returnValue) throws Throwable {
			System.out.println("afterReturning :"+returnValue);
	}*/
	
	@AfterThrowing(pointcut="execution(* com.myapp..*(..))", throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, IllegalArgumentException ex) throws Throwable {
			System.out.println("***");
			System.out.println("IllegalArgumentException Capture");
			System.out.println("Caught: " + ex.getClass().getName());
			System.out.println("***\n");
	}
	
}
