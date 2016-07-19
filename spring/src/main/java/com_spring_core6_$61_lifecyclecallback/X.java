package com_spring_core6_$61_lifecyclecallback;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


public class X implements BeanNameAware,InitializingBean,DisposableBean{

	private String x;
	
	private String beanName;

	public void init(){
		System.out.println("Method init bean: "+beanName);
	}
	
	public void destroy(){
		System.out.println("Method destroy bean: "+beanName);
	}
	
	/**
	 * @return the x
	 */
	public String getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(String x) {
		this.x = x;
	}

	public void setBeanName(String name) {

		this.beanName = name;
	}

	public void afterPropertiesSet() throws Exception {

		System.out.println("Method init bean: "+beanName);
	}

}
