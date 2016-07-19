package com_spring_core9_$_expresstion_expresstions;

import java.util.ArrayList;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		

		//Type
		ExpressionParser parser = new SpelExpressionParser();
		Class<String> cls = (Class<String>) parser.parseExpression("T(java.lang.String)").getValue();
		System.out.println(cls);
		
		//Constructor (package k chứa $)
		ArrayList sv = parser.parseExpression("new java.util.ArrayList()").getValue(ArrayList.class);
		System.out.println(sv);
		
		//Method
		String strs = parser.parseExpression("'12'.substring(0,1)").getValue(String.class);
		System.out.println(strs);
	}

}
