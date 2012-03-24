package com.baselogic.aspects;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import com.baselogic.service.ExampleServiceInitializingBeanImpl;

public class SimpleAdvice implements MethodBeforeAdvice {
	
	private final Logger logger = LoggerFactory.getLogger(SimpleAdvice.class);

	@Override
	public void before(Method method, Object[] objects, Object object)
			throws Throwable {
		logger.info(">>>------------------------------------------------->>>");
		logger.info(">>>------------------------------------------------->>>");
		logger.info(">>>------------------------------------------------->>>");
		logger.info(">>>>> SimpleAdvice >>>>> Currently Processing {} on Object {}",
				method,
				object);
		if( object instanceof ExampleServiceInitializingBeanImpl){
			((ExampleServiceInitializingBeanImpl)object).setMessage("SimpleAdvice.before advice");
		}
	}
}