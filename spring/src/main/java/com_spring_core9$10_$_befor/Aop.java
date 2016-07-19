package com_spring_core9$10_$_befor;

import org.aspectj.lang.JoinPoint;

public class Aop {

	public void before(JoinPoint joinPoint){
		
		System.out.println(joinPoint.getTarget().getClass());
	}
}
