package com_spring_core9$21_mvc;


//@Component
public class Sv {

	private String name;
	private String age;
	private String id;

	public Sv() {

	}

	public Sv(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Sv getSv() {
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
	public void setAge(String age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void print() {
		System.out.println("name: A, age: 22");
	}

}
