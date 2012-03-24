package com.baselogic.service;

//Static imports
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.baselogic.service.ExampleService;
import com.baselogic.util.ContextUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ExampleConfigurationTests {
	
	private static final Logger logger = LoggerFactory.getLogger(ExampleConfigurationTests.class);
	
	@Autowired
	private ContextUtils contextUtils;
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService service;
	
	@Autowired
	private ExampleServiceInitializingBeanImpl exampleServiceInitializingBeanImpl;
	
	@Before
	public void beforeEachUnitTest(){}

	@After
	public void afterEachUnitTest(){}

	@Test
	public void testInitializationSteps() throws Exception {
		List<String> initializationOrder = exampleServiceInitializingBeanImpl.initializationOrder;
		logger.info("--> exampleServiceInitializingBeanImpl: {}", initializationOrder);
		assertThat(initializationOrder.size(), is(2));
		assertThat(initializationOrder.get(0), is("postConstruct"));
		assertThat(initializationOrder.get(1), is("afterPropertiesSet"));
	}

	@Test
	public void testBeansInContext() throws Exception {
		contextUtils.showBeansInContext();
	}

}
