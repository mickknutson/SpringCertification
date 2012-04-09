package com.baselogic.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baselogic.annotations.Auditable;
import com.baselogic.domain.Order;

/**
 * AfterAdvice
 *
 * After unconditionally
 * Handles normal and exception return
 * Can change return value or throw an exception
 * 
 * <p>Spring Certification objective: 2.1 AOP Recommendations</p>
 * <p>Spring Certification objective: 2.2 AOP Pointcuts</p>
 * <p>Spring Certification objective: 2.3 AOP Advice</p>
 * 
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#aop">Objective 2.1 AOP Recommendations</a><br />
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#aop">Objective 2.2 AOP Pointcuts</a><br />
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#aop">Objective 2.3 AOP Advice</a><br />
 *
 * @author Mick Knutson
 * @see Blog: <a href="http://www.baselogic.com">http://baselogic.com</a><br />
 * @see LinkedIN: <a href="http://linkedin.com/in/mickknutson">http://linkedin.com/in/mickknutson</a><br />
 * @see Twitter: <a href="http://twitter.com/mickknutson">http://twitter.com/mickknutson</a><br />
 * @see Github: <a href="http://github.com/mickknutson">http://github.com/mickknutson</a><br />
 * 
 * @see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a><br />
 * @see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a><br />
 * 
 * @since 2012
 * 
 */
@Aspect
public class AfterAdvice {
	
	private final Logger logger = LoggerFactory.getLogger(AfterAdvice.class);
	
	
	/**
	 * Specific method execution
	 */
    @Pointcut("execution(* com.baselogic.service.*.placeOrder(..))")
    public void placeOrderService() {}

	/**
	 * Within a given package
	 */
    @Pointcut("within(com.baselogic.service..*)")
    private void inService() {}       
    
    
	@After("inService() " +
			"&& @annotation(auditable) " +
			"&& args(order,..)")
	public void afterOrderDao(Auditable auditable, Order order) throws Throwable {
		
		logger.info(">>> ----- afterOrderDao...>>> {}", auditable.value());
		
		order.adviceGiven.add("afterOrderDao advice" + auditable.value());
	}

}