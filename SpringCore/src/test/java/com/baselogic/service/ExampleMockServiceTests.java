package com.baselogic.service;

//Static imports
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

import com.baselogic.service.ExampleService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baselogic.service.ExampleServiceImpl;
import com.baselogic.util.ContextUtils;

import junit.framework.TestCase;

@RunWith(PowerMockRunner.class)
@SuppressStaticInitializationFor("com.baselogic.util.ExampleUtils")
@PrepareForTest({ ContextUtils.class })
public class ExampleMockServiceTests {

	private ExampleService service;
	
	@Before
	public void beforeEachUnitTest(){
		service = new ExampleServiceImpl();
	}

	@After
	public void afterEachUnitTest(){
		service = null;
	}

	
	
	public void testReadOnce() throws Exception {
		assertEquals("Hello world!", service.getMessage());
	}

}