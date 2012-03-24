package com.baselogic.demos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @see http://andrewclement.blogspot.com/2009/02/aspectj-advising-methods-with-parameter.html
 * @see http://blog.espenberntsen.net/2010/03/20/aspectj-cheat-sheet/
 * @author mknuts6173c
 *
 */
@Aspect
public class TestAdvice {

	private final Logger logger = LoggerFactory.getLogger(TestAdvice.class);

	@Pointcut("within(@org.junit.Test *)")
	public void methodAnnotatedWithTest() {}
	
	//@Pointcut("within(*..*Tests)")
	@Pointcut("execution(public * *(..))")
    void publicTestMethod() {}
	
	@Pointcut("publicTestMethod() && methodAnnotatedWithTest()")
	public void publicMethodInsideAClassMarkedWithAtTest() {}

    @Before("publicMethodInsideAClassMarkedWithAtTest()")
    public void beforeJunitTestCases(JoinPoint jp) {
    	if (jp.getTarget() != null && jp.getTarget().getClass().isAnnotationPresent(Test.class)) {
    	       // perform the monitoring actions
    		logger.debug("----- Start Test {} ----------------------------------",
    				jp.getSignature());
    		
    	} else{
    		logger.debug("----- ??? Test {} ----------------------------------",
    				jp.getSignature());
    	}    
    }

    /*@After("junitTestMethods()")
    public void afterJunitTestCases() {    	
    	logger.debug("----- After Test {} ----------------------------------");
    }*/

	
	// Using joinPoint.getArgs() to show arguments.
    //@Around("junitTestMethods()")
    //@Around("execution(@Test * *.*Tests(..))")
    public void aroundJunitTestCases(ProceedingJoinPoint joinPoint) throws Throwable {
    	/*logger.debug("Executed the @Injected method: "
                + joinPoint.getSignature() + " with value(s): ");
 
        for (Object object : joinPoint.getArgs()) {
            System.out.print(object);
        }
        logger.debug("");*/

    	logger.debug("----- Start Test {} ----------------------------------");
    	 
    	joinPoint.proceed();
     
    	logger.debug("----- End Test {} ------------------------------------");
        // Post processing work..

    }

}
