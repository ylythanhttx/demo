package com_spring_core9$_expresstion_expresstionparser;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {

	public static void main(String[] args) {
		
		//parser String
		ExpressionParser parserString = new SpelExpressionParser();
		Expression expressionString = parserString.parseExpression("'Hello'");
		String parserStringstr = (String) expressionString.getValue();
		System.out.println("ex parser String: "+parserStringstr);
		
	}

}
