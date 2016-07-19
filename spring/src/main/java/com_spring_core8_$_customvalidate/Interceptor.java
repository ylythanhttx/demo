package com_spring_core8_$_customvalidate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.validation.Constraint;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author thanh.nv
 */
public class Interceptor implements ApplicationContextAware {

	private ValidatorFactory factory;
	private Validator validator;
	private static ApplicationContext context;

	public void test(JoinPoint joinPoint) {

		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Annotation[] annMethods = method.getDeclaredAnnotations();
		int position = 0;
		for (Annotation annMethod : annMethods) {
			if (annMethod instanceof TargetCheck) {
				position = ((TargetCheck) annMethod).value();
				break;
			}
		}
		if (factory == null) {
			Annotation[] anns = method.getParameterTypes()[position]
					.getDeclaredAnnotations();
			String targetMsg = "";
			parent: for (Annotation ann : anns) {
				Annotation[] ann1s = ann.annotationType()
						.getDeclaredAnnotations();
				for (Annotation ann1 : ann1s)
					if (ann1 instanceof Constraint) {
						Class<?>[] classes = ((Constraint) ann1).validatedBy();
						if ((classes[0].getName()
								.equals(CustomConstraintValidator.class
										.getName()))) {
							String[] targetMsgs = ann.annotationType()
									.getName().split("[\\.]");
							targetMsg = targetMsgs[targetMsgs.length - 1];
							break parent;
						}
					}
			}
			factory = Validation
					.byDefaultProvider()
					.configure()
					.messageInterpolator(
							new ResourceBundleMessageInterpolator(
									new PlatformResourceBundleLocator(targetMsg)))
					.buildValidatorFactory();
			validator = factory.getValidator();
		}

		Object object = joinPoint.getArgs()[position];
		if (object == null) {
			try {
				object = method.getParameterTypes()[position].newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Set<ConstraintViolation<Object>> constraintViolations = validator
				.validate(object);
		Iterator<ConstraintViolation<Object>> it = constraintViolations
				.iterator();
		Map<String, String> mapMsg = new HashMap<String, String>();
		while (it.hasNext()) {
			ConstraintViolation<Object> constraint = it.next();
			mapMsg.put(constraint.getPropertyPath().toString(), constraint.getMessage());
		}
		if (constraintViolations.size() != 0) {
			throw new ValidException(mapMsg);
		}
	}

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
	}

	public static ApplicationContext getContext() {
		return context;
	}
}
