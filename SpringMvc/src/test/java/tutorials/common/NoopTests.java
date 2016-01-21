package tutorials.common;

import com.baselogic.tutorials.domain.Order;
import com.baselogic.tutorials.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * BeforeAdviceTests
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
//@ContextConfiguration(classes = AfterAdviceTestsContext.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class NoopTests {

    private final Logger logger = LoggerFactory
            .getLogger(NoopTests.class);

//    @Autowired
//    ApplicationContext applicationContext;
//
//    @Autowired
//    OrderService orderService;

    @Test
    public void testAfterAdvice(){
        logger.info("testAfterAdvice");

//        Order original = new Order();
//        original.adviceGiven.add("created in BeforeAdviceTests");
//
//        Order returned = orderService.placeOrder(original);
//
//        logger.debug(">>> beforeAdvice returned: {}", returned);
    }

} // The End...
