package com_spring_core9$21_mvc;

import org.springframework.beans.factory.InitializingBean;

public class TestHttpRequest implements InitializingBean{

	private String name;
	private String age;
	public TestHttpRequest() {

	}
	
	
	
	public TestHttpRequest(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}



	public TestHttpRequest getSv(){
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



	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("new Object httprequest");
	}
	
}
