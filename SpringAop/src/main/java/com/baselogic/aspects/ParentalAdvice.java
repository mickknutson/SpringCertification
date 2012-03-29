package com.baselogic.aspects;

import java.lang.reflect.Method;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import com.baselogic.dao.OrderDAO;
import com.baselogic.domain.Order;
import com.baselogic.service.OrderService;
import com.baselogic.service.UnImplementedService;
import com.baselogic.service.UsageTracked;

/**
 * ParentalAdvice
 * 
 * Introductions (known as inter-type declarations in AspectJ) enable an 
 * aspect to declare that advised objects implement a given interface, 
 * and to provide an implementation of that interface on behalf of 
 * those objects.
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
 */
@Aspect
public class ParentalAdvice {
	
	private final Logger logger = LoggerFactory.getLogger(ParentalAdvice.class);

	//OrderService
	//UsageTracked
	@DeclareParents(value="com.baselogic.service.OrderService*+",
			defaultImpl=UsageTracked.class)
	public static UsageTracked mixin;

	/*@DeclareParents(value="com.xzy.myapp.service.*+",
            defaultImpl=DefaultUsageTracked.class)*/
	
    @Pointcut("execution(* com.baselogic.*.place*Order(..))")
    public void placeOrderService() {}

    
	@Before("placeOrderService() && this(usageTracked)")
	public void recordUsage(UsageTracked usageTracked) {
		logger.info(">>> Parental Advice: {}", usageTracked.trackUsage());
		logger.info(">>> Parental Advice: {}", usageTracked.trackUsage());
		logger.info(">>> Parental Advice: {}", usageTracked.trackUsage());
		logger.info(">>> Parental Advice: {}", usageTracked.trackUsage());
		logger.info(">>> Parental Advice: {}", usageTracked.trackUsage());
	}

}