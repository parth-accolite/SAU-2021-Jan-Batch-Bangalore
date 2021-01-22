package com.au.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//multiple advices inside aspect
@Aspect
public class LoggingAspect {
	
	//to write specifically for circle class write om.au.aop.model.Circle.getName()
//	@Before("execution(public String getName())")
//	public void LoggingAdvice() {
//		System.out.println("Logging Advice");
//	}
	
	//Apply before all methods start with get
	//execution(public * get*(*) - with parameter
	//execution(public * get*(..) - with any number of parameters
	//execution(* com.au.aop.model.*.get*()) - all get functions for class under model
//	@Before("execution(public * get*())")
//	public void LoggingAdvice() {
//		System.out.println("Logging Advice");
//		
//	}
//	
//	@Before("allGetters()")
//	public void SecondAdvice() {
//		System.out.println("Second Advice");
//		
//	}
//	
//	//Define pointcut expression
//	@Pointcut("execution(public * get*(..))")
//	public void allGetters() { 
//		/* this is a dummy method for holding pointcut expressions, so they can be referenced later in annotations @Before etc */
//	}
//	
	
	// After Advice
/*	@Pointcut("execution(public * set*(..))")
	public void allSetters() {	}
	
	@After("allSetters()")
	public void afterAdvice() {
		System.out.println("This is executed after a Setter method is executed");
	} */
	
	// After Returning
	/* @AfterReturning(pointcut="execution( public * *(..))", returning = "retVal")
	public void afterReturningAdvice(JoinPoint jp, Object retVal) {
		System.out.println("After returning something");
		System.out.println("Method Signature: "  + jp.getSignature());  
//		System.out.println("Returning:" + retVal.toString() );
	} */
	
//	AfterThrowing
	/*
	@AfterThrowing(pointcut ="execution( public * *(..))",throwing="error")
	public void afterThrowingAdvice() {
		System.out.println("An Excepption has occured");
	} */
	
//	Around
	 /* @Pointcut("execution (public * set*(..))")
	private void setterMethods() {}
	
	@Around("setterMethods()")
	public void aroundAdvice() {
		System.out.println("Print before entering and after exiting the setter");
	}
	*/

}
