package com.baselogic.tutorials.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baselogic.tutorials.dao.OrderDAO;
import com.baselogic.tutorials.domain.Order;

/**
 * AfterReturningAdvice
 *
 * @AfterReturning
 * After on success only
 * Can change return value but it is not possible to return a totally different reference when using after-returning advice.
 * Use:
 * view sourceprint?
 * 		@AfterReturning(pointcut="...", returning="retval")
 * 		public void doAdvice(Object retVal)
 *
 * Spring supported types of pointcuts:
 *
 * <b>this</b> - limits matching to join points (the execution of methods when using Spring AOP) where the
 * bean reference (Spring AOP proxy) is an instance of the given type
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
 * @see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a>
 * @see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a>
 *
 * @since 2012
 *
 */
@Aspect
public class AfterReturningAdvice {

	private final Logger logger = LoggerFactory.getLogger(AfterReturningAdvice.class);

	@Pointcut("execution(* com.baselogic.tutorials.dao.*.*(..))")
    public void dataAccessOperation() {}



    @AfterReturning("dataAccessOperation() && this(dao)")
	public void afterReturningOrderDaoThis(OrderDAO dao) throws Throwable {

		logger.info(">>> ----- afterReturningOrderDaoThis...>>> {}", dao);
	}

    @AfterReturning(pointcut="dataAccessOperation() && args(order,..)", returning="returnOrder")
	public void afterReturningOrderDaoArgs(Order order, Order returnOrder) throws Throwable {

		logger.info(">>> ----- afterReturningOrderDaoArgs.order..>>> {}", order);

		order.setDescription("altered in the afterReturningOrderDaoArgs() method.");

		order.adviceGiven.add("afterReturningOrderDaoArgs advice");

		logger.info(">>> ----- afterReturningOrderDaoArgs.returnOrder..>>> {}", returnOrder);
	}


}
