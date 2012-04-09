package com.baselogic.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baselogic.domain.Order;

/**
 * WithinAdvice
 * 
 * Spring supported types of pointcuts:
 * 
 * <b>@within</b> - limits matching to join points within types that have the given annotation (the execution
 * of methods declared in types with the given annotation when using Spring AOP)
 * 
 * <p>Spring Certification objective: 2.1 AOP Recommendations</p>
 * <p>Spring Certification objective: 2.2 AOP Pointcuts</p>
 * <p>Spring Certification objective: 2.3 AOP Advice</p>
 * 
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#aop">Objective 2.1 AOP Recommendations</a>
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#aop">Objective 2.2 AOP Pointcuts</a>
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#aop">Objective 2.3 AOP Advice</a>
 *
 * @author Mick Knutson
 * @see <a href="http://www.baselogic.com">Blog: http://baselogic.com</a>
 * @see <a href="http://linkedin.com/in/mickknutson">LinkedIN: http://linkedin.com/in/mickknutson</a>
 * @see <a href="http://twitter.com/mickknutson">Twitter: http://twitter.com/mickknutson</a>
 * @see <a href="http://github.com/mickknutson">Git hub: http://github.com/mickknutson</a>
 * 
 * @see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 7 Cookbook Packt</a>
 * @see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 7 Cookbook Amazon</a>
 * 
 * @since 2012
 * 
 * 
 */
@Aspect
public class WithinAdvice {
	
	private final Logger logger = LoggerFactory.getLogger(WithinAdvice.class);
	
	
	/**
	 * Specific method execution
	 */
    @Pointcut("execution(* com.baselogic.*.placeOrder(..))")
    public void placeOrderService() {}

    /**
     * Any private method execution
     */
	@Pointcut("execution(private * *(..))")
    private void anyPrivateOperation() {}
    
	/**
	 * Within a given package
	 */
    @Pointcut("within(com.baselogic.service..*)")
    private void inService() {}
       
    /**
     * Execution in any method in any class in a package
     */
    @Pointcut("execution(* com.baselogic.dao.*.*(..))")
    public void dataAccessOperation() {}

    
    
    
    //=== Join Points =======================================================//
    
    //@args(javax.persistence.Entity)

	/**
	 * Advice on multiple pointcut's
	 * @throws Throwable
	 */
	@Before("anyPrivateOperation() && inService()")
	public void beforePrivateMethodsInService() throws Throwable {
		logger.info(">>> ----- beforePrivateMethodsInService...>>>");
	}

	
	/**
	 * Advice with pointcut in different class.
	 * @throws Throwable
	 */
	@Before("dataAccessOperation() && args(order,..)")
	public void beforeOrderDao(Order order) throws Throwable {		
		logger.info(">>> ----- beforeOrderDao...>>> {}", order);
		
		order.adviceGiven.add("beforeOrderDao advice");
	}

}