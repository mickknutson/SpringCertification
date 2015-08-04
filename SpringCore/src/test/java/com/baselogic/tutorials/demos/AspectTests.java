package com.baselogic.tutorials.demos;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ExampleMockServiceTests
 *
 * <p>Spring Certification objective: 1.2 Lifecycle</p>
 *
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html#beans">Objective 1.2 Lifecycle</a>
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
@ContextConfiguration(classes = AspectTests.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AspectTests {

	private final Logger logger = LoggerFactory
			.getLogger(AspectTests.class);

	@Test
	public void testHolder(){
		logger.info("testHolder");
	}

	/*

	// TESTING Autowired. See Log Output, after running.
	@Autowired
	private MyExceptionThrower myExceptionThrower;

	@Test
	public void testExceptionAOP() throws Exception {
		logger.debug("***** TEST Throwing Data Format Exception *****");
		try {
			myExceptionThrower.throwDFE();
		} catch (DataFormatException dae) {
			assertTrue(true);
		} catch (Exception e) {
			fail("Expected DataFormatException");
		}

	}

	@Test
	public void testExceptionAOP2() throws Exception {
		logger.debug("***** TEST Throwing Insufficient Resources Exception *****");
		try {
			myExceptionThrower.throwIRE();
		} catch (InsufficientResourcesException ire) {
			assertTrue(true);
		} catch (Exception e) {
			fail("Expected InsufficientResourcesException");
		}

	}*/

}
