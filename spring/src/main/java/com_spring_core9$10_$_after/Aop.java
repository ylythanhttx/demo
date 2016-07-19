package com_spring_core9$10_$_after;

import org.aspectj.lang.JoinPoint;

public class Aop {

	public void after(JoinPoint joinPoint){
		
		System.out.println(joinPoint.getTarget().getClass());
	}
}
