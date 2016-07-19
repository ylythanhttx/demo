package com_spring_core9$10_$_afterthrow;

import org.aspectj.lang.JoinPoint;

public class Aop {

	public void afterThrow(JoinPoint joinPoint, Exception ex){
		System.out.println(joinPoint.getTarget().getClass());
		System.out.println(ex.getMessage());
	}
}
