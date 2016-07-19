package com_spring_core6_$62_aware_beannameaware;

import org.springframework.beans.factory.BeanNameAware;

public class X implements BeanNameAware {

	private String beanName;

	/**
	 * @return the beanName
	 */
	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String name) {

		this.beanName = name;
	}

}
