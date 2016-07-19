package com_spring_core6_$45_autowired;


public class A {

	private B b;

	
	
	public A(B b) {
		super();
		this.b = b;
	}

	/**
	 * @return the b
	 */
	public B getB() {
		return b;
	}

	/**
	 * @param b
	 *            the b to set
	 */
	public void setB(B b) {
		this.b = b;
	}

}
