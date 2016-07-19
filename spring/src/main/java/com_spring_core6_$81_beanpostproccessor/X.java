package com_spring_core6_$81_beanpostproccessor;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class X implements InitializingBean,DisposableBean {

	private String beanName;

	/**
	 * @return the beanName
	 */
	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {

		this.beanName = beanName;
	}

	public void destroy() throws Exception {

		System.out.println("Destroy ");
	}

	public void afterPropertiesSet() throws Exception {

		System.out.println("Init ");
	}

}
