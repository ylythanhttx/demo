package com_spring_core6_$9$101_componentscan;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

@Service
public class Y {

	public String y;

	@Autowired
	@Qualifier("x")
	private X x2;

	@Resource(name="z")
	private Z z;
	/**
	 * @return the y
	 */
	public String getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	
	public void setY(String y) {
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public X getX() {
		return x2;
	}

	/**
	 * @param x the x to set
	 */
	
	public void setX(X x) {
		this.x2 = x;
	}

	/**
	 * @return the z
	 */
	public Z getZ() {
		return z;
	}

	@PostConstruct
	public void init(){
		System.out.println("init instance class Y");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("destroy instance class Y");
	}
}
