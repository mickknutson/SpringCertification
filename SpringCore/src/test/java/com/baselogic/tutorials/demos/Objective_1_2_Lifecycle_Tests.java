package com.baselogic.tutorials.demos;

//Static imports

import com.baselogic.tutorials.components.ConstructorInjectionComponent;
import com.baselogic.tutorials.components.PropertyInjectionComponent;
import com.baselogic.tutorials.components.SimpleComponent;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


/**
 * Simple JUNit Test
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
public class Objective_1_2_Lifecycle_Tests {

	private static final Logger logger = LoggerFactory.getLogger(Objective_1_2_Lifecycle_Tests.class);

    @Autowired
    ApplicationContext applicationContext;

    //-----------------------------------------------------------------------//
    //-----------------------------------------------------------------------//
    //-----------------------------------------------------------------------//
    @BeforeClass
    public static void beforeClass(){
        logger.info("-------------------------------------------------------");
        logger.info("Running tests for Spring Certification objective: 1.1 General");
        logger.info("-------------------------------------------------------");
    }

    @Before
	public void beforeEachUnitTest(){
		logger.debug("beforeEachUnitTest");
	}

	@After
	public void afterEachUnitTest(){
		logger.debug("afterEachUnitTest");
	}

    //-----------------------------------------------------------------------//
    //-----------------------------------------------------------------------//
    //-----------------------------------------------------------------------//

    @Test
	public void testInitMethodsInXml() {
        SimpleComponent simpleComponent =
                applicationContext.getBean("simpleComponent", SimpleComponent.class);

        SimpleComponent simpleComponentInit =
                applicationContext.getBean("simpleComponentInit", SimpleComponent.class);

        SimpleComponent simpleComponentPrivateInit =
                applicationContext.getBean("simpleComponentPrivateInit", SimpleComponent.class);

        SimpleComponent simpleComponentPrivateInitWithReturnValue =
                applicationContext.getBean("simpleComponentPrivateInitWithReturnValue", SimpleComponent.class);

        assertThat(simpleComponent.getMessage(), equalTo("default message"));
        assertThat(simpleComponentInit.getMessage(), equalTo("default message: init"));
        assertThat(simpleComponentPrivateInit.getMessage(), equalTo("default message: privateInit"));
        assertThat(simpleComponentPrivateInitWithReturnValue.getMessage(), equalTo("default message: privateInitWithReturnValue"));
	}

    @Test
	public void testDestroyMethodsInXml() {
        SimpleComponent simpleComponent =
                applicationContext.getBean("simpleComponentDestroy", SimpleComponent.class);
        assertThat(simpleComponent.getMessage(), equalTo("default message"));
	}

    @Test
	public void testSpringLifecycle() {
        logger.info("Spring Lifecycle");
        logger.info("______________________________________________________");

        logger.info("Load all bean definitions creating ordered graph. [For singleton beans, when the application context is created/parsed]");

        logger.info("(*) --->>>");
        logger.info("Instantiate ... [Spring creates an instance of the Bean using Java Reflection API.)");
        logger.info("... run BeanFactoryPostProcessors (BFPP) (can update bean definitions here) -->");

        logger.info("Populate Properties --> [If there are any properties associated with bean then spring injects those properties. If there are any bean as a property then spring finds that bean and inject it.]");
        logger.info("BeanNameAware's setBeanName() --> [If the Bean class implements the BeanNameAware interface, then the spring will call setBeanName() method by passing the name of the Bean.]");
        logger.info("BeanFactoryAware's setBeanFactory() --> [If the Bean class implements the BeanFactoryAware interface, then the spring will call setBeanFactory() method by passing an instance of BeanFactory object.]");
        logger.info("ApplicationContextAware's setApplicationContext() -->");
        logger.info("Preinitialization BeanPostProcessors (BPP) --> [If there are any BeanPostProcessors associated with the BeanFactory that loads the Bean, then the spring will call postProcessBeforeInitialization() method before the properties for the Bean are injected.]");
        logger.info("@PostConstruct -->");
        logger.info("InitializationBean's afterPropertiesSet() --> [If the Bean class implements the InitializingBean interface, then the spring will call afterPropertiesSet() method once all the Bean properties defined in the Configuration file are injected.]");
        logger.info("Call custom init-method --> [If there is any custom init-method declared in the configuration file, that method will be called.]");
        logger.info("Postinitialization BeanPostProcessors (BPP) --> [If there are any BeanPostProcessors associated with the BeanFactory that loads the Bean, then the spring will call postProcessAfterInitialization() method.]");
        logger.info("*** Bean is ready to use ***");
        logger.info("-------------------------------------------------------");
        logger.info("*** Container is shut-down ***");
        logger.info("@PreDestroy -->");
        logger.info("DisposableBean's destroy() --> [If the Bean class implements the DisposableBean interface, then the spring calls destroy() method when the Application no longer needs the bean reference.]");
        logger.info("Call custom destroy-method --> [If there is any custom destroy-method declared in the configuration file, that method will be called.]");
        logger.info("--->>> (*)");
        logger.info("### The END ###");


    }

}
