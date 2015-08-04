package com.baselogic.tutorials.aspects;

import com.baselogic.tutorials.annotations.Auditable;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baselogic.tutorials.domain.Order;

/**
 * AnnotationAdvice
 *
 * <p>Spring Certification objective: 2.1 AOP Recommendations</p>
 * <p>Spring Certification objective: 2.2 AOP Pointcuts</p>
 * <p>Spring Certification objective: 2.3 AOP Advice</p>
 *
 * <b>@annotation</b> - limits matching to join points where the subject of the join point (method being
 * executed in Spring AOP) has the given annotation
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
public class AnnotationAdvice {

	private final Logger logger = LoggerFactory.getLogger(AnnotationAdvice.class);


	/**
	 * Specific method execution
	 */
    @Pointcut("execution(* com.baselogic.tutorials.service.*.placeOrder(..))")
    public void placeOrderService() {}

	/**
	 * Within a given package
	 */
    @Pointcut("within(com.baselogic.tutorials.service..*)")
    private void inService() {}


	@After("inService() " +
			"&& @annotation(auditable) " +
			"&& args(order,..)")
	public void afterOrderDao(Auditable auditable, Order order) throws Throwable {

		logger.info(">>> ----- afterOrderDao...>>> {}", auditable.value());

		order.adviceGiven.add("afterOrderDao advice" + auditable.value());
	}

}
