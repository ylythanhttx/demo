package com_spring_core9$10_$_around;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class X {

	@SuppressWarnings("unused")
	private String beanName;

	@Autowired
	private Y y;

	public void setBeanName(String name) {

		this.beanName = name;
	}

	public static String getBeanName() {
		System.out.println("fail...");
		return "";
	}

	/**
	 * @return the y
	 */
	public Y getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(Y y) {
		this.y = y;
	}

}
