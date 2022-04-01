package com.training.pms.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	@Before(value = "execution(* com.training.pms.service.ProductService.*(..))")
	public void doLogging(JoinPoint joinpoint) {
		Signature signature = joinpoint.getSignature();
		System.out.println("2.###I am performing a loggin function before for : " + signature.getName());
	}
	@After(value = "execution(* com.training.pms.service.ProductService.*(..))")
	public void doLogging2(JoinPoint joinpoint) {
		Signature signature = joinpoint.getSignature();
		System.out.println("3.### I am performing a loggin function after for : " + signature.getName());
	}
	
	@Around(value = "execution(* com.training.pms.service.ProductService.*(..))")
	public Object checkData(ProceedingJoinPoint joinpoint) throws Throwable {
		Signature signature = joinpoint.getSignature();
		System.out.println("1.###I am AROUND ASPECT : " + signature.getName());
		//Please proceeed with the method call
		Object retVal = joinpoint.proceed();
		System.out.println("4.###I am AROUND ASPECT : " + signature.getName());
		
		return retVal;
	}
}
