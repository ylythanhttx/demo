package com_spring_core9_$_expresstion_spelparserconfig;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Test {

	public static void main(String[] args) {

		Sv sv = new Sv();
		SpelParserConfiguration config = new SpelParserConfiguration(true,true);
		ExpressionParser parser = new SpelExpressionParser(config);
		
		parser.parseExpression("setName('name')").getValue(sv);
		parser.parseExpression("setAge('age')").getValue(sv);
		
		System.out.println(sv.getName());
		System.out.println(sv.getAge());
	}

}
