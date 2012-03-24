package com.baselogic.demos;

//Static imports
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baselogic.domain.Activity;
import com.baselogic.util.ExampleUtils;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Equivalent to: @ContextConfiguration("classpath:/com/baselogic/demos/UtilsTest-context.xml")
@ContextConfiguration

//Equivalent to: @ContextConfiguration("classpath:/com/baselogic/demos/utils-context.xml")
//@ContextConfiguration("utils-context.xml")

//Equivalent to: @ContextConfiguration("classpath:/com/baselogic/demos/META-INF/spring/utils-context.xml")
//@ContextConfiguration(value = "META-INF/spring/utils-context.xml")

//TODO: Not correct
//Equivalent to: @ContextConfiguration("classpath:/META-INF/spring/utils-context.xml")

//Equivalent to:
//@ContextConfiguration("classpath:/META-INF/spring/utils-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UtilsTests {
	
	private final Logger logger = LoggerFactory.getLogger(UtilsTests.class);

	@Autowired
	ApplicationContext applicationContext;

	
	@Test
	public void showUtilsInfo() {
		ExampleUtils exampleUtils = applicationContext.getBean(ExampleUtils.class);
		assertNotNull(exampleUtils);
		logger.info(">>>------------------------------------------------->>>");
		logger.info("ExampleUtils Results: {}", exampleUtils.toString());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testLinkedListUtil() {
		List<String> otherNames = applicationContext.getBean("otherNames", LinkedList.class);
		assertThat((otherNames instanceof LinkedList), is(true));
		logger.debug("otherNames instanceof LinkedList: {}", (otherNames instanceof LinkedList));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSetUtil() {
		Set<String> otherSet = applicationContext.getBean("otherSet", Set.class);
		assertThat((otherSet instanceof Set), is(true));
		assertThat(otherSet.size(), is(4));
		logger.debug("otherSet instanceof Set: {}", (otherSet instanceof Set));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testMapUtils() {
		Map<String, Object> additionalData = applicationContext.getBean("additionalData", Map.class);
		assertThat((additionalData instanceof Map), is(true));
		logger.debug("additionalData instanceof Map: {}", (additionalData instanceof Map));
		logger.debug("additionalData: {}", additionalData.toString());
	}

	@Test
	public void testActivity() {
		ExampleUtils exampleUtils = applicationContext.getBean(ExampleUtils.class);
		Activity activity = exampleUtils.getActivity();
		assertThat(activity, is(Activity.PARACHUTE));
		logger.debug("activity: {}", activity);
	}
}