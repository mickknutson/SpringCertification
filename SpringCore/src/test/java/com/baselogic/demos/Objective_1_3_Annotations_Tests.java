package com.baselogic.demos;

//Static imports

import com.baselogic.components.ConstructorInjectionComponent;
import com.baselogic.components.MultipleConstructorInjectionComponent;
import com.baselogic.components.PropertyInjectionComponent;
import com.baselogic.service.ExampleService;
import com.baselogic.service.ExampleServiceInitializingBeanImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;


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
 * @see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 7 Cookbook Packt</a>
 * @see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 7 Cookbook Amazon</a>
 *
 * @since 2012
 *
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class Objective_1_3_Annotations_Tests {

	private static final Logger logger = LoggerFactory.getLogger(Objective_1_3_Annotations_Tests.class);

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    @Qualifier("exampleServiceInitializingBeanImpl")
    ExampleServiceInitializingBeanImpl exampleServiceInitializingBeanImpl;

    @Autowired
    @Qualifier("exampleServiceInitializingBeanImplJavaConfig")
    ExampleServiceInitializingBeanImpl exampleServiceInitializingBeanImplJavaConfig;

    @Autowired
    ConstructorInjectionComponent constructorInjectionComponent;

    @Autowired
    MultipleConstructorInjectionComponent multipleConstructorInjectionComponent;

    @Autowired
    private String systemProperty;


    PropertyInjectionComponent propertyInjectionComponent;

    //-----------------------------------------------------------------------//
    //-----------------------------------------------------------------------//
    //-----------------------------------------------------------------------//
    @BeforeClass
    public static void beforeClass(){
        logger.info("");
    }

    @Before
	public void beforeEachUnitTest(){
		logger.debug("beforeEachUnitTest");
		propertyInjectionComponent = new PropertyInjectionComponent();
	}

	@After
	public void afterEachUnitTest(){
		logger.debug("afterEachUnitTest");
		propertyInjectionComponent = null;
	}

    //-----------------------------------------------------------------------//
    //-----------------------------------------------------------------------//
    //-----------------------------------------------------------------------//
    @Test
	public void testAutowired() {

		assertThat(multipleConstructorInjectionComponent.getSimpleComponent().getMessage(),
				is("default constructor"));

		assertThat(constructorInjectionComponent.getMessage(),
				is("static JavaConfiguration message: ${foo}::static JavaConfiguration message: ${foo}"));

//		assertThat(multipleConstructorInjectionComponent.getPropertyInjectionComponent(),
//				is(nullValue()));
	}

    @Test
	public void testQualifier() {
        logger.debug("exampleServiceInitializingBeanImplJavaConfig: {}", exampleServiceInitializingBeanImplJavaConfig);
        assertThat(exampleServiceInitializingBeanImplJavaConfig instanceof ExampleService,
				is(true));
	}

    @Test
	public void testPostConstruct() {
        logger.debug("exampleServiceInitializingBean: {}", exampleServiceInitializingBeanImpl);
        logger.debug("exampleServiceInitializingBean..getInitializationOrder(): {}", exampleServiceInitializingBeanImpl.getInitializationOrder());

        List<String> initializationOrder = exampleServiceInitializingBeanImpl.getInitializationOrder();

        assertThat(initializationOrder.get(0), is("postConstruct"));
        assertThat(initializationOrder.get(1), is("afterPropertiesSet"));
        assertThat(initializationOrder.size(), is(2));

    }

    @Test
	public void testValue() {
		assertThat(systemProperty,
				is("static JavaConfiguration message: ${foo}"));
				//is("/tmp"));
	}

    @Test
	public void testScheduled() {
		assertThat(propertyInjectionComponent instanceof PropertyInjectionComponent,
				is(true));
	}

    @Test
	public void testAsync() {
		assertThat(propertyInjectionComponent instanceof PropertyInjectionComponent,
				is(true));
	}

}