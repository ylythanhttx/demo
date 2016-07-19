package com_spring_core6_$46_lookupmethod;

public class Xyz {

	private String hello;

	public String getS(){
		return "getS";
	}
	
	public Xyz getX() {
		return new Xyz();
	}

	/**
	 * @return the hello
	 */
	public String getHello() {
		return hello;
	}

	/**
	 * @param hello
	 *            the hello to set
	 */
	public void setHello(String hello) {
		this.hello = hello;
	}

}