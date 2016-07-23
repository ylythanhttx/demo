package com_spring_core9$_expresstion_collections$array;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;

public class Sv implements InitializingBean{

	private String name;
	private String age;
	private List<String> lists;

	public Sv() {

	}

	public Sv(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Sv(String name, String age, ArrayList<String> lists) {
		super();
		this.name = name;
		this.age = age;
		this.lists = lists;
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

	public void print() {
		System.out.println("name: A, age: 22");
	}

	/**
	 * @return the lists
	 */
	public List<String> getLists() {
		return lists;
	}

	/**
	 * @param lists
	 *            the lists to set
	 */
	public void setLists(ArrayList<String> lists) {
		this.lists = lists;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		lists.add("test");
	}

}
