package com_spring_core8_$_beanwraper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class Test {

	public static void main(String[] args) {

		 Y y = new Y();
		 BeanWrapper beanWrapperX = new BeanWrapperImpl(new X());
		 beanWrapperX.setPropertyValue("x", "dshjfh");
         
         BeanWrapper beanWrapperY = new BeanWrapperImpl(y);
         beanWrapperY.setPropertyValue("x", beanWrapperX.getWrappedInstance());

//         String x = (String) beanWrapperY.getPropertyValue("x.x");
         System.out.println(y.getX().getX());
	}

}
