package com.baselogic.tutorials.service;

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
import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

// PowerMock
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

// Project
import com.baselogic.tutorials.dao.OrderDAO;

import com.baselogic.tutorials.util.ExampleUtils;


/**
 * OrderPowerMockServiceTests
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
@RunWith(PowerMockRunner.class)
@PrepareForTest({ ExampleUtils.class, OrderServiceImpl.class })

public class OrderPowerMockServiceTests {

	@InjectMocks OrderServiceImpl classUnderTest = new OrderServiceImpl();

	@Mock OrderDAO supportingDao;

	@Mock ExampleUtils supportingUtils;

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
	 * Advanced
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

	}

	/**
	 * Advanced
	 *
	 * Mock a static Class to use in our class under test.
	 *
	 * @throws Exception
	 */
	@Test
	public void staticMockThrowingException() throws Exception {

		PowerMockito.mockStatic(ExampleUtils.class);

		PowerMockito.doThrow(new RuntimeException("Static RuntimeException")).when(ExampleUtils.class);

		String result = classUnderTest.staticFunctions();

		assertThat(result, is("OrderServiceImpl: function(): null: staticFunction"));

		PowerMockito.verifyStatic();
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
