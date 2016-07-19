package com_spring_core8_$_formatter_defineformattercustom;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	private String name = "A";

	private Date date;

	public Person() {

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