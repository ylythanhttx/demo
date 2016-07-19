package com_spring_core8_$_customvalidate;

import com_spring_core8_$_customvalidate.ValidConstraint;

@ValidConstraint(stepBystep=false)
public class Sv {

	private String name;
	private int age;

	public Sv() {

	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
