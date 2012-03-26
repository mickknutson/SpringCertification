package com.baselogic.service;

// Hamcrest
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

// JUnit
//import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

// Mockito
import static org.mockito.Matchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

// PowerMock
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;

// Project
import com.baselogic.dao.OrderDAO;
import com.baselogic.domain.Order;

import com.baselogic.util.ExampleUtils;


@RunWith(PowerMockRunner.class)
@PrepareForTest({ ExampleUtils.class, OrderServiceImpl.class })

public class OrderPowerMockServiceTests {

	@InjectMocks OrderServiceImpl classUnderTest = new OrderServiceImpl();

	@Mock OrderDAO orderDao;
	
	@Mock ExampleUtils exampleUtils;
	
	@Before
	public void beforeEachUnitTest(){
		
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void afterEachUnitTest(){}


	//----- Mock Test methods -----------------------------------------------//
	/*-----------------------------------------------------------------------//
	 * Mockito:
	 * http://code.google.com/p/mockito/
	 * 
	 * PowerMock:
	 * http://code.google.com/p/powermock/
	 * 
	 * PowerMock Mockito Extensions:
	 * http://code.google.com/p/powermock/wiki/MockitoUsage13
	 *-----------------------------------------------------------------------*/

	/**
	 * Basic
	 * 
	 * Mock a static Class to use in our class under test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void staticRemoteMock() throws Exception {
		
		PowerMockito.mockStatic(ExampleUtils.class);
		
		when(ExampleUtils.staticFunction()).thenReturn("some static mocked value");

		String result = classUnderTest.staticFunctions();
		
		assertThat(result, is("OrderServiceImpl: function(): some static mocked value: staticFunction"));

		PowerMockito.verifyStatic();
		
		// verify statics in order.
	}

	/*@Test // basic
	public void staticPartialMock() throws Exception {
		
		PowerMockito.mockStaticPartial(ExampleUtils.class, "staticFunction");
		
		when(ExampleUtils.staticFunction()).thenReturn("some static mocked value");

		String result = orderService.staticFunctions();
		
		assertThat(result, is("OrderServiceImpl: function(): some static mocked value: staticFunction"));

		PowerMockito.verifyStatic();
		
		ExampleUtils.staticFunction();
	}*/


	/*TODO: @Test //int
	public void mockStaticMethodThrowsException() throws Exception {}*/

	
	/**
	 * Advanced
	 * 
	 * Partially mock the class under test to mock a private
	 * method with and without parameters.
	 * 
	 * @throws Exception
	 */
	@Test
	public void privatePartialMock() throws Exception {

		OrderServiceImpl classUnderTest = PowerMockito.spy(new OrderServiceImpl());

        // use PowerMockito to set up your expectation
        PowerMockito.doReturn("private string with no params").when(classUnderTest, "privateFunction");

        PowerMockito.doReturn("some altered private string").when(classUnderTest, "privateFunction", anyString());

        // execute your test
        String result = classUnderTest.executeInternalPrivate();
        
        assertThat(result, is("OrderServiceImpl: executeInternalPrivate(): private string with no params: some altered private string"));

        // Use PowerMockito.verify() to verify result
        PowerMockito.verifyPrivate(classUnderTest, times(1)).invoke("privateFunction");

        PowerMockito.verifyPrivate(classUnderTest, times(1)).invoke("privateFunction", anyString());
	}

	/*TODO: @Test //adv
	public void privateRemoteMock() throws Exception {}*/


} // the end...
