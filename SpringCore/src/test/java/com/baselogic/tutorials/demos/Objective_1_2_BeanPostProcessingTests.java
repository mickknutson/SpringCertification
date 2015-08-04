package com.baselogic.tutorials.demos;

//Hamcrest
//import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.core.IsNull.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

//JUnit
//import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baselogic.tutorials.service.ExampleServiceInitializingBeanImpl;

/**
 * Objective_1_2_BeanPostProcessingTests
 *
 * http://localhost:8080/ch03/declarative/entry
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
 * @since 2012
 *
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class Objective_1_2_BeanPostProcessingTests {

	private static final Logger logger = LoggerFactory
			.getLogger(Objective_1_2_BeanPostProcessingTests.class);

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	@Qualifier("exampleServiceInitializingBeanImplXml")
	ExampleServiceInitializingBeanImpl exampleServiceInitializingBeanImplXml;

    @BeforeClass
    public static void beforeClass(){
        logger.info("");
    }

    @Test
	public void testAddBeanPostProcessorNewTimestamp(){
		logger.info(">>>------------------------------------------------->>>");
		logger.debug("testAddBeanPostProcessorNewTimestamp: {}", exampleServiceInitializingBeanImplXml);
		logger.debug("testAddBeanPostProcessorNewTimestamp..getCreationDate(): {}", exampleServiceInitializingBeanImplXml.getCreationDate());

		assertThat(exampleServiceInitializingBeanImplXml, is(notNullValue()));
		assertThat(exampleServiceInitializingBeanImplXml.getCreationDate(), is(notNullValue()));
	}
}
