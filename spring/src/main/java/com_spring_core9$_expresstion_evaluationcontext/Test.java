package com_spring_core9$_expresstion_evaluationcontext;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Test {

	public static void main(String[] args) {
		
		
		//EvaluationContext
		@SuppressWarnings("rawtypes")
		Class svclass = Sv.class;
		EvaluationContext evaluationContext = new StandardEvaluationContext(svclass);
		ExpressionParser parserObj = new SpelExpressionParser();
		Expression expressionObj = parserObj.parseExpression("newInstance()");
		Sv parserObjstr = (Sv) expressionObj.getValue(evaluationContext);
		System.out.println(parserObjstr.getName());
		
	}

	public <T> T getT(Class<T> cls){
		try {
			return cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
