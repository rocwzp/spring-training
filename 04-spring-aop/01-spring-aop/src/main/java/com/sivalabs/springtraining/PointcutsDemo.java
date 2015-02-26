/**
 * 
 */
package com.sivalabs.springtraining;

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
public class PointcutsDemo {
	
	@Pointcut("execution(* com.sivalabs.springtraining..*(String,Integer))")
	public void myPointcut()
	{
		
	}
	
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
	
	@AfterReturning(pointcut="execution(* com.sivalabs.springtraining..*(..))", returning="returnValue")
	public void afterReturning(JoinPoint joinPoint, Object returnValue) throws Throwable {
			System.out.println("afterReturning :"+returnValue);
	}
	
	@AfterThrowing(pointcut="execution(* com.sivalabs.springtraining..*(..))", throwing="ex")
	public void afterThrowing(JoinPoint joinPoint, IllegalArgumentException ex) throws Throwable {
			System.out.println("***");
			System.out.println("IllegalArgumentException Capture");
			System.out.println("Caught: " + ex.getClass().getName());
			System.out.println("***\n");
	}
	
}
