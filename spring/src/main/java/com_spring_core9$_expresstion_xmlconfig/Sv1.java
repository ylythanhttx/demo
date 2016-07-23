package com_spring_core9$_expresstion_xmlconfig;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author thanhnv5
 *
 */
public class Sv1 {

	private String name;
	
	private String age;
	private Date date;

	public Sv1() {

	}

	public Sv1(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Sv1 getSv() {
		return this;
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

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	@Value(value ="#{new String('11')}")
	public void setAge(String age) {
		this.age = age;
	}

	public void print() {
		System.out.println("name: A, age: 22");
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
