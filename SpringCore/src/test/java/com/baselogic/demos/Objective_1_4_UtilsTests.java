package com.baselogic.demos;

//Static imports
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

import org.junit.BeforeClass;
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

/**
 * Objective_1_4_UtilsTests
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
 * @see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 7 Cookbook Packt</a>
 * @see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 7 Cookbook Amazon</a>
 *
 * @since 2012
 *
 */
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
public class Objective_1_4_UtilsTests {

	private static final Logger logger = LoggerFactory.getLogger(Objective_1_4_UtilsTests.class);

	@Autowired
	ApplicationContext applicationContext;

    @BeforeClass
    public static void beforeClass(){
        logger.info("");
    }

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
		logger.info(">>>------------------------------------------------->>>");
		List<String> namedIds = applicationContext.getBean("namedIds", LinkedList.class);
		assertThat((namedIds instanceof LinkedList), is(true));
		logger.debug("namedIds: {} ... namedIds instanceof LinkedList: {}", namedIds, (namedIds instanceof LinkedList));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testSetUtil() {
		logger.info(">>>------------------------------------------------->>>");
		Set<String> otherSet = applicationContext.getBean("otherSet", Set.class);
		assertThat((otherSet instanceof Set), is(true));
		assertThat(otherSet.size(), is(4));
		logger.debug("otherSet instanceof Set: {}", (otherSet instanceof Set));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testMapUtils() {
		logger.info(">>>------------------------------------------------->>>");
		Map<String, Object> additionalData = applicationContext.getBean("additionalData", Map.class);
		assertThat((additionalData instanceof Map), is(true));
		logger.debug("additionalData instanceof Map: {}", (additionalData instanceof Map));
		logger.debug("additionalData: {}", additionalData.toString());
	}

	@Test
	public void testActivity() {
		logger.info(">>>------------------------------------------------->>>");
		ExampleUtils exampleUtils = applicationContext.getBean(ExampleUtils.class);
		Activity activity = exampleUtils.getActivity();
		assertThat(activity, is(Activity.PARACHUTE));
		logger.debug("activity: {}", activity);
	}
}