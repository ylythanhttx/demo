package com_spring_core9$10_$_after;

import org.springframework.beans.factory.BeanNameAware;

public class X implements BeanNameAware{

	private String beanName;
	
	@Override
	public void setBeanName(String name) {

		this.beanName = name; 
	}

	public String getBeanName(){
		System.out.println(beanName);
		return beanName;
	}
}
