package com.baselogic.demos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baselogic.tutorials.domain.Order;
import com.baselogic.tutorials.service.OrderService;
import com.baselogic.tutorials.service.OrderServiceImpl;
import com.baselogic.tutorials.service.UsageTracked;

/**
 * ParentalAdviceTests
 *
 * <p>Spring Certification objective: 1.2 Lifecycle</p>
 *
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html#beans">Objective 1.2 Lifecycle</a>
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
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ParentalAdviceTests {

	private final Logger logger = LoggerFactory
			.getLogger(ParentalAdviceTests.class);

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	OrderService orderService;

	@Test
	public void testParentalAdviceNewInterface(){
		Order original = new Order();

		Order returned = orderService.placeOrder(original);

		logger.info(">>> testParentalAdviceTrackedAdvice returned: {}", returned);

		assertThat(orderService instanceof UsageTracked, is(true));
	}

	@Test
	public void testParentalAdviceTrackedAdvice(){
		Order original = new Order();

		Order returned = orderService.placeOrder(original);

		logger.info(">>> testParentalAdviceTrackedAdvice returned: {}", returned);

		assertThat(orderService instanceof UsageTracked, is(true));

		UsageTracked parentalAdvisor = applicationContext.getBean("orderService", UsageTracked.class);

		logger.info(">>> UsageTracked parentalAdvisor: {}", parentalAdvisor.trackUsage());
		logger.info(">>> UsageTracked parentalAdvisor: {}", parentalAdvisor.toString());
	}

}
