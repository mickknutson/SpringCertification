package com.baselogic.demos;

//Hamcrest
//import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.core.IsNull.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

//JUnit
//import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baselogic.service.ExampleServiceInitializingBeanImpl;

/**
 * BeanPostProcessingTests
 *
 * http://localhost:8080/ch03/declarative/entry
 *
 * @author Mick Knutson
 *         <a href="http://www.baselogic.com">Blog</a>< /br>
 *         <a href="http://linkedin.com/in/mickknutson">LinkedIN</a>< /br>
 *         <a href="http://twitter.com/mickknutson">Twitter</a>< /br>
 *         <a href="http://www.mickknutson.com">Personal</a>< /br>
 *         <a href="https://github.com/mickknutson">Git Hub</a>< /br> 
 * @since 2012
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class BeanPostProcessingTests {
	
	private final Logger logger = LoggerFactory
			.getLogger(BeanPostProcessingTests.class);

	@Autowired
	ApplicationContext applicationContext;

	@Autowired
	@Qualifier("exampleServiceInitializingBeanImplXml")
	ExampleServiceInitializingBeanImpl exampleServiceInitializingBeanImplXml;

	@Test
	public void testAddBeanPostProcessorNewTimestamp(){
		logger.info(">>>------------------------------------------------->>>");
		logger.info("testAddBeanPostProcessorNewTimestamp: {}", exampleServiceInitializingBeanImplXml);
		logger.info("testAddBeanPostProcessorNewTimestamp..getCreationDate(): {}", exampleServiceInitializingBeanImplXml.getCreationDate());
		
		assertThat(exampleServiceInitializingBeanImplXml, is(notNullValue()));
		assertThat(exampleServiceInitializingBeanImplXml.getCreationDate(), is(notNullValue()));
	}
}
