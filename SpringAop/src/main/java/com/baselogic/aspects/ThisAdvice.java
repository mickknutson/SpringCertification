package com.baselogic.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baselogic.dao.OrderDAO;
import com.baselogic.domain.Order;

/**
 * ThisAdvice
 *
 * Spring supported types of pointcuts:
 *
 * <b>this</b> - limits matching to join points (the execution of methods when using Spring AOP) where the
 * bean reference (Spring AOP proxy) is an instance of the given type
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
public class ThisAdvice {

	private final Logger logger = LoggerFactory.getLogger(ThisAdvice.class);

	@Pointcut("execution(* com.baselogic.dao.*.*(..))")
    public void dataAccessOperation() {}

    @AfterReturning("dataAccessOperation() && this(dao)")
	public void afterReturningOrderDaoThis(OrderDAO dao) throws Throwable {

		logger.info(">>> ----- afterReturningOrderDaoThis...>>> {}", dao);
	}

    @AfterReturning("dataAccessOperation() && args(order,..)")
	public void afterReturningOrderDaoArgs(Order order) throws Throwable {

		logger.info(">>> ----- afterReturningOrderDaoArgs...>>> {}", order);

		order.setDescription("altered in the afterReturningOrderDaoArgs() method.");

		order.adviceGiven.add("afterReturningOrderDaoArgs advice");
	}


}