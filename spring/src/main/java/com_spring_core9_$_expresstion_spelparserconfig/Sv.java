package com_spring_core9_$_expresstion_spelparserconfig;

public class Sv {

	private String name;
	private String age;
	public Sv() {

	}
	
	
	
	public Sv(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}



	public Sv getSv(){
		return this;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
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
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	
	public void print(){
		System.out.println("name: A, age: 22");
	}
	
}
