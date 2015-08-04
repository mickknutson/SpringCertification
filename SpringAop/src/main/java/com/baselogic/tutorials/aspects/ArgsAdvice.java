package com.baselogic.tutorials.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baselogic.tutorials.domain.Order;

/**
 * ArgsAdvice
 *
 * Spring supported types of pointcuts:
 *
 * <b>execution</b> - for matching method execution join points, this is the primary pointcut designator you
 * will use when working with Spring AOP
 *
 * <b>within</b> - limits matching to join points within certain types (simply the execution of a method
 * declared within a matching type when using Spring AOP)
 *
 * <b>this</b> - limits matching to join points (the execution of methods when using Spring AOP) where the
 * bean reference (Spring AOP proxy) is an instance of the given type
 *
 * <b>target</b> - limits matching to join points (the execution of methods when using Spring AOP) where the
 * target object (application object being proxied) is an instance of the given type
 *
 * <b>args</b> - limits matching to join points (the execution of methods when using Spring AOP) where the
 * arguments are instances of the given types
 *
 * <b>@target</b> - limits matching to join points (the execution of methods when using Spring AOP) where the
 * class of the executing object has an annotation of the given type
 *
 * <b>@args</b> - limits matching to join points (the execution of methods when using Spring AOP) where the
 * runtime type of the actual arguments passed have annotations of the given type(s)
 *
 * <b>@within</b> - limits matching to join points within types that have the given annotation (the execution
 * of methods declared in types with the given annotation when using Spring AOP)
 *
 * <b>@annotation</b> - limits matching to join points where the subject of the join point (method being
 * executed in Spring AOP) has the given annotation
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
 *
 */
@Aspect
public class ArgsAdvice {

	private final Logger logger = LoggerFactory.getLogger(ArgsAdvice.class);


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
    @Pointcut("within(com.baselogic.tutorials.service..*)")
    private void inService() {}

    /**
     * Execution in any method in any class in a package
     */
    @Pointcut("execution(* com.baselogic.tutorials.dao.*.*(..))")
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
