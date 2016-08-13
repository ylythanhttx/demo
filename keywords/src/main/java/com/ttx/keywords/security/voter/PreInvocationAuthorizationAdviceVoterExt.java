package com.ttx.keywords.security.voter;

import java.util.Collection;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.ExpressionBasedPreInvocationAdvice;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.prepost.PreInvocationAttribute;
import org.springframework.security.access.prepost.PreInvocationAuthorizationAdvice;
import org.springframework.security.core.Authentication;

public class PreInvocationAuthorizationAdviceVoterExt implements
		AccessDecisionVoter<MethodInvocation> {
	protected final Log logger = LogFactory.getLog(getClass());

	private PreInvocationAuthorizationAdvice preAdvice = new ExpressionBasedPreInvocationAdvice();
	private MethodSecurityExpressionHandler expressionHandler = new DefaultMethodSecurityExpressionHandler();
	private RoleHierarchy roleHierarchy;

	public RoleHierarchy getRoleHierarchy() {
		return roleHierarchy;
	}

	@Required
	public void setRoleHierarchy(RoleHierarchy roleHierarchy) {
		this.roleHierarchy = roleHierarchy;
	}

	public boolean supports(ConfigAttribute attribute) {
		return attribute instanceof PreInvocationAttribute;
	}

	public boolean supports(Class<?> clazz) {
		// return MethodInvocation.class.isAssignableFrom(clazz);
		return true;
	}

	public int vote(Authentication authentication, MethodInvocation method,
			Collection<ConfigAttribute> attributes) {

		// Find prefilter and preauth (or combined) attributes
		// if both null, abstain
		// else call advice with them

		PreInvocationAttribute preAttr = findPreInvocationAttribute(attributes);

		if (preAttr == null) {
			// No expression based metadata, so abstain
			return ACCESS_ABSTAIN;
		}

		((DefaultMethodSecurityExpressionHandler) expressionHandler)
				.setRoleHierarchy(roleHierarchy);
		((ExpressionBasedPreInvocationAdvice) preAdvice)
				.setExpressionHandler(expressionHandler);
		boolean allowed = preAdvice.before(authentication, method, preAttr);

		return allowed ? ACCESS_GRANTED : ACCESS_DENIED;
	}

	private PreInvocationAttribute findPreInvocationAttribute(
			Collection<ConfigAttribute> config) {
		for (ConfigAttribute attribute : config) {
			if (attribute instanceof PreInvocationAttribute) {
				return (PreInvocationAttribute) attribute;
			}
		}

		return null;
	}
}
