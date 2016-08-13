package com.ttx.keywords.security.voter;

import org.springframework.security.web.access.expression.WebExpressionVoter;

public class WebExpressionVoterExt extends WebExpressionVoter {

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
