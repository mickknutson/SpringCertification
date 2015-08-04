package com.baselogic.tutorials.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AroundAdvice
 *
 * @Around
 * Surrounds
 * Takes ProceedingJoinPoint, can intercept call or ignore exception
 * First parameter of the advice method must be of type ProceedingJoinPoint
 * Call proceed() on the ProceedingJoinPoint to execute the method
 *
 * <p>Spring Certification objective: 2.1 AOP Recommendations</p>
 * <p>Spring Certification objective: 2.2 AOP Pointcuts</p>
 * <p>Spring Certification objective: 2.3 AOP Advice</p>
 *
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html#aop">Objective 2.1 AOP Recommendations</a>
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html#aop">Objective 2.2 AOP Pointcuts</a>
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html#aop">Objective 2.3 AOP Advice</a>
 *
 * @author Mick Knutson
 * at_see <a href="http://www.baselogic.com">Blog: http://baselogic.com</a>
 * at_see <a href="http://linkedin.com/in/mickknutson">LinkedIN: http://linkedin.com/in/mickknutson</a>
 * at_see <a href="http://twitter.com/mickknutson">Twitter: http://twitter.com/mickknutson</a>
 * at_see <a href="http://github.com/mickknutson">Git hub: http://github.com/mickknutson</a>
 *
 * at_see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a>
 * at_see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a>
 *
 * @since 2012
 *
 */
@Aspect
public class AroundAdvice {

	private final Logger logger = LoggerFactory.getLogger(AroundAdvice.class);

	@Pointcut("execution(* com.baselogic.tutorials.service.*.placeDelayedOrder(..))")
    public void placeDelayedOrderService() {}


	/**
	 * Runs @Before, (jp) then allow code to execute, (jp) then @AfterReturning
	 *
	 * Potential issue:
	 * Multiple markers at this line
	 * - advice defined in com.baselogic.tutorials.aspects.AroundAdvice has not been applied [Xlint:adviceDidNotMatch]
	 * - applying to join point that doesn't return void: method-execution(com.baselogic.tutorials.domain.Order
	 * com.baselogic.tutorials.service.OrderServiceImpl.placeDelayedOrder(com.baselogic.tutorials.domain.Order, long))
	 *
	 * @param joinpoint
	 */
    @Around("placeDelayedOrderService()")
    public Object aroundPlaceDelayedOrderService(ProceedingJoinPoint joinpoint)
    		throws Throwable {

    	Object returnVal = null;

    	// get execution control here.

	    try {
            // Before Logic....
		    logger.info(">>> ----- aroundPlaceDelayedOrderService...>>>");
		    long start = System.currentTimeMillis();



		    // Return control back to the executing code's at the join-point
		    // give control back to code execution.
		    returnVal = joinpoint.proceed();

		    // get execution control again.

		    long end = System.currentTimeMillis();

		    logger.info(">>> ----- The order took {} milliseconds to complete...>>>", (end-start));

	    } catch(Throwable t){
	    	logger.error(t.getMessage());
	    	// if error is thrown, will NOT stop code execution.

	    	// Can propagate Throwable.
	    	throw t;
	    }

	    // return control again to execution code.
	    return returnVal;
    }

    /**
     * No annotation version of advice
     * @param joinpoint
     * @return
     */
    public Object aroundXmlPlaceDelayedOrderService(ProceedingJoinPoint joinpoint){
    	Object returnVal = null;

    	// get execution control here.

	    try {
		    logger.info(">>> ----- aroundXmlPlaceDelayedOrderService...>>>");
		    long start = System.currentTimeMillis();

		    // Return control back to the executing code's at the join-point
		    // give control back to code execution.
		    returnVal = joinpoint.proceed();

		    // get execution control again.

		    long end = System.currentTimeMillis();

		    logger.info(">>> ----- The xml order took {} milliseconds to complete...>>>", (end-start));

	    } catch(Throwable t){
	    	logger.error(t.getMessage());
	    	// if error is thrown, will stop all execution.
	    }

	    // return control again to execution code.
	    return returnVal;
    }

    /**
     * @deprecated For testing ONLY!
     */
    public void beforeXmlPlaceDelayedOrderService(){
    	logger.info(">>> ----- beforeXmlPlaceDelayedOrderService...>>>");
    }
}
