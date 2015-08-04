package com.baselogic.tutorials.demos;

//Hamcrest
//import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.core.IsNull.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

//JUnit
//import static org.junit.Assert.*;
import com.baselogic.tutorials.domain.Customer;
import com.baselogic.tutorials.domain.Order;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

//Mockito
import static org.mockito.Matchers.any;
import static org.junit.Assert.assertEquals;

//PowerMock

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baselogic.tutorials.common.LegacySingletonComponent;
import com.baselogic.tutorials.components.ConstructorInjectionComponent;

/**
 * FactoryBean Tests
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
public class Objective_1_2_FactoryBeanTests {

	private static final Logger logger = LoggerFactory.getLogger(Objective_1_2_FactoryBeanTests.class);

	@Autowired
	ApplicationContext applicationContext;

    @BeforeClass
    public static void beforeClass(){
        logger.info("");
    }

    @Test
	public void testLegacySingletonFactoryPattern(){

		logger.info(">>>------------------------------------------------->>>");

		// Matches LegacySingletonComponent.class by type because there is only one LegacySingletonComponent.class type
		// in context.
		LegacySingletonComponent legacySingletonComponent = applicationContext.getBean(LegacySingletonComponent.class);

		logger.debug("legacySingletonComponent: {}", legacySingletonComponent.toString());

		assertThat(legacySingletonComponent.getName(), is("default LegacySingletonComponent Name"));
	}

	//@Test
	public void testLegacyFactoryPatternClass(){

		logger.info(">>>------------------------------------------------->>>");
		ConstructorInjectionComponent legacyConstructorInjectionComponent =
				applicationContext.getBean(ConstructorInjectionComponent.class);

		logger.debug("legacyConstructorInjectionComponent: {}", legacyConstructorInjectionComponent.toString());

		assertThat(legacyConstructorInjectionComponent.getMessage(),
				is("default legacyConstructorInjectionComponent from LegacyComponentFactory"));
	}


	@Test
	public void testCustomerWithXmlFactoryBeanOrder(){

		logger.info(">>>------------------------------------------------->>>");

		Customer customer = applicationContext.getBean("customer", Customer.class);

		logger.debug("customer: {}", customer.toString());

		assertThat(customer.getFirstName(), is("Mick"));
		assertThat(customer.getLastName(), is("Knutson"));

		assertThat(customer.getOrder().getItems().size(), is(2));

		assertThat(customer instanceof Customer, is(true));
	}

	@Test
	public void testCustomerWithJavaConfigFactoryOrder(){
		logger.info(">>>------------------------------------------------->>>");
		Customer customer1 = applicationContext.getBean("javaConfigCustomer", Customer.class);

		Customer customer2 = applicationContext.getBean("javaConfigCustomer", Customer.class);

		logger.debug("javaConfigCustomer1: {}", customer1.toString());
		logger.debug("javaConfigCustomer2: {}", customer2.toString());
		logger.debug("order: {}", applicationContext.getBean("javaConfigOrder", Order.class));

		assertThat(customer1.getOrder().getItems().size(), is(4));

		assertThat(customer1, equalTo(customer2));

		/*assertThat((customer1.getOrder().getItems()).get(0),
				not(equalTo(prototypePropertyInjectionComponent2.getSomeDouble())));*/

		assertThat(customer1 instanceof Customer, is(true));

		assertThat(customer1.getOrder() instanceof Order, is(true));

	}
}
