package com_spring_core6_$42_DIs;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext  context = new ClassPathXmlApplicationContext(
				"classpath:**/spring642.xml");

         LopHoc lopHoc = (LopHoc) context.getBean("lopHoc");
         
         Sv sv = lopHoc.getSv();
         System.out.println(sv.getName());
         
         System.out.println("test emty: "+lopHoc.getTestEmty());
         System.out.println("test Null: "+lopHoc.getTextNull());
         
         System.out.println("test List: "+lopHoc.getTestList().size());
         System.out.println("test Set: "+lopHoc.getTestSet().size());
         System.out.println("test Map: "+lopHoc.getTestMap().keySet().size());
         
	}

}
