package com.baselogic.demos;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.zip.DataFormatException;

import javax.naming.InsufficientResourcesException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baselogic.domain.Order;
import com.baselogic.service.OrderService;
import com.baselogic.service.OrderServiceImpl;

/**
 * AroundAdviceTests
 *
 * <p>Spring Certification objective: 1.2 Lifecycle</p>
 *
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#beans">Objective 1.2 Lifecycle</a>
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
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class AfterThrowingAdviceTests {

	private final Logger logger = LoggerFactory
			.getLogger(AfterThrowingAdviceTests.class);

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	OrderService orderService;

	@Test
	public void testAfterThrowingAdvice(){
		Order original = new Order();
		original.setId(1234L);
		original.adviceGiven.add("created in testAfterThrowingAdvice");

		Order returned = orderService.placeOrder(original);

		logger.info(">>> testAfterThrowingAdvice returned: {}", returned);
	}

	@Test
	public void testAfterThrowingAdviceWithAroundAdvice(){
		Order original = new Order();
		original.setId(1234L);
		original.adviceGiven.add("created in testAfterThrowingAdviceWithAroundAdvice");

		Order returned = orderService.placeDelayedOrder(original, 100L);

		logger.info(">>> testAfterThrowingAdviceWithAroundAdvice returned: {}", returned);
	}


}