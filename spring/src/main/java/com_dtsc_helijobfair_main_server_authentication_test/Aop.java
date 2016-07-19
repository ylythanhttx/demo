package com_dtsc_helijobfair_main_server_authentication_test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Aop {

//	@Around("execution(* com.spring.core9$10.$.around.X.*(..))")
	@Around("execution(* com.dtsc.helijobfair.main.server.utils.test.Test.*(..))")
	public String around(ProceedingJoinPoint pjp) throws Throwable{
		//before
		System.out.println("before");
		
		try {
		
			Object x = pjp.proceed();
		} catch (Exception e) {

		}
		

		//after
		System.out.println("after"); 
		return "s";
	}
}
