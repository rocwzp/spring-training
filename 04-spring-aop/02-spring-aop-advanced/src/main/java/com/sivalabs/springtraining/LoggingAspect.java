/**
 * 
 */
package com.sivalabs.springtraining;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * @author user
 *
 */
@Aspect
@Component
public class LoggingAspect 
{
	
	@Before("execution(* com.sivalabs.springtraining.UserService.*(..))")
	public void logBefore(JoinPoint jp) {
		System.out.println("(logBefore) Entering into Method: "+jp.getSignature().getName()+"() with argumanets :"+Arrays.asList(jp.getArgs()));
	}
	
	@After("execution(* com.sivalabs.springtraining.UserService.*(..))")
	public void logAfter(JoinPoint jp) {
		System.out.println("(logAfter) Exiting from Method: "+jp.getSignature().getName()+"()");
	}
	
	@Pointcut("execution(* com.sivalabs.springtraining.*.*(..))")
	public void userServicePointCut(){
		
	}
	
	@Around("userServicePointCut()")
	public Object logArounf(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Entering into Method: "+jp.getSignature().getName()+"() with argumanets :"+Arrays.asList(jp.getArgs()));
		Object object = jp.proceed();
		System.out.println("Exiting from Method: "+jp.getSignature().getName()+"()");
		return object;
	}
	
	@AfterThrowing(pointcut="userServicePointCut()", throwing="tx")
	public void handleIllegalArgumentException(JoinPoint jp) {
		System.out.println("We encountered some IllegalArgumentException issue. ProductionSupprt, plz look into the issue!!");
	}

	
	
}
