package com_spring_core9$10_$_afterreturn;

import org.aspectj.lang.JoinPoint;

public class Aop {

	public void afterReturn(JoinPoint joinPoint, Object obj){
		System.out.println(joinPoint.getTarget().getClass());
		System.out.println(obj);
	}
}
