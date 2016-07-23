package com_spring_core9$_expresstion_collections$array;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Test {

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"classpath:**/spring9-list.xml");
		
		//parser List
		ExpressionParser parserList = new SpelExpressionParser();
		Expression expressionList = parserList.parseExpression("{{1,2,3},{1,2,3}}");
		List<List<String>> parserListstr = (List<List<String>>) expressionList.getValue();
		System.out.println(parserListstr.size());
		
		//parser Map
		ExpressionParser parserMap = new SpelExpressionParser();
		Expression expressionMap = parserMap.parseExpression("{a:{{'1':1},{'2':2}}}");
		Map<Object,Map<Object, Object>> parserMapstr = (Map<Object,Map<Object, Object>>) expressionMap.getValue();
		System.out.println(parserMapstr.size());
		
		//parser array
		ExpressionParser parserArray = new SpelExpressionParser();
		Expression expressionArray = parserArray.parseExpression("new int[]{5353}");
		int[] ints =   (int[]) expressionArray.getValue();
		System.out.println("array: "+ints[0]);
		
		Sv sv = new Sv();
		EvaluationContext context = new StandardEvaluationContext(sv);
		ExpressionParser parser = new SpelExpressionParser();
		parser.parseExpression("name='name'").getValue(context);
		parser.parseExpression("lists = new java.util.ArrayList()").getValue(context);
		parser.parseExpression("lists.add('2')").getValue(context);
		parser.parseExpression("lists[0]").setValue(context,"1");
		System.out.println("lists[0]: "+sv.getLists().get(0));
		System.out.println("name: "+sv.getName());
		

//		List<Integer> list = (List<Integer>) appContext.getBean("list");
//		System.out.println(list.size());
	}

}
