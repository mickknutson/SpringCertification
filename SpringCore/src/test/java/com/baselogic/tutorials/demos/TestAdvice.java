package com.baselogic.tutorials.demos;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Objective_1_2_BeanFactoryPostProcessorTests
 *
 * NOTE: A BeanFactoryPostProcessor modifies bean definitions,
 * while a BeanPostProcessor replaces bean instances (such as when creating a proxy).
 *
 * <p>Spring Certification objective: 1.2 Lifecycle</p>
 *
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html#beans">Objective 1.2 Lifecycle</a>
 *
 * @author Mick Knutson
 * <p><a href="http://www.baselogic.com">Blog: http://baselogic.com</a></p>
 * <p><a href="http://linkedin.com/in/mickknutson">LinkedIN: http://linkedin.com/in/mickknutson</a></p>
 * <p><a href="http://twitter.com/mickknutson">Twitter: http://twitter.com/mickknutson</a></p>
 * <p><a href="http://github.com/mickknutson">Git hub: http://github.com/mickknutson</a></p>
 *
 * @since 2012
 *
 * @deprecated MOVE TO NEW PROJECT
 *
 * see http://andrewclement.blogspot.com/2009/02/aspectj-advising-methods-with-parameter.html
 * see http://blog.espenberntsen.net/2010/03/20/aspectj-cheat-sheet/
 *
 */
@Aspect
public class TestAdvice {

	private static final Logger logger = LoggerFactory.getLogger(TestAdvice.class);

    @BeforeClass
    public static void beforeClass(){
        logger.info("");
    }

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
