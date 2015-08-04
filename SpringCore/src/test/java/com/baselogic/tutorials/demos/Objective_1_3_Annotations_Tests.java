package com.baselogic.tutorials.demos;

import com.baselogic.tutorials.components.ConstructorInjectionComponent;
import com.baselogic.tutorials.components.MultipleConstructorInjectionComponent;
import com.baselogic.tutorials.components.PropertyInjectionComponent;
import com.baselogic.tutorials.domain.DefaultPojo;
import com.baselogic.tutorials.service.AsyncTask;
import com.baselogic.tutorials.service.ExampleService;
import com.baselogic.tutorials.service.ExampleServiceInitializingBeanImpl;
import com.baselogic.tutorials.service.ScheduleTask;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.Future;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;


/**
 * <p>Spring Certification objective: 1.3 Annotations</p>
 *
 * @author Mick Knutson
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html#beans">Objective 1.3 Annotations</a>
 * at_see <a href="http://www.baselogic.com">Blog: http://baselogic.com</a>
 * at_see <a href="http://linkedin.com/in/mickknutson">LinkedIN: http://linkedin.com/in/mickknutson</a>
 * at_see <a href="http://twitter.com/mickknutson">Twitter: http://twitter.com/mickknutson</a>
 * at_see <a href="http://github.com/mickknutson">Git hub: http://github.com/mickknutson</a>
 * at_see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a>
 * at_see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a>
 * @since 2012
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class Objective_1_3_Annotations_Tests {

    private static final Logger logger = LoggerFactory.getLogger(Objective_1_3_Annotations_Tests.class);

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DefaultPojo defaultPojo;

    @Autowired
    ScheduleTask scheduleTask;

    @Autowired
    AsyncTask asyncTask;

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
    public static void beforeClass() {
        logger.info("");
    }

    @Before
    public void beforeEachUnitTest() {
        logger.debug("beforeEachUnitTest");
        // Create a MOCK Object here:
        propertyInjectionComponent = new PropertyInjectionComponent();
    }

    @After
    public void afterEachUnitTest() {
        logger.debug("afterEachUnitTest");
        propertyInjectionComponent = null;
    }

    //-----------------------------------------------------------------------//
    //-----------------------------------------------------------------------//
    //-----------------------------------------------------------------------//
    //@Test
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
        logger.info("exampleServiceInitializingBeanImplJavaConfig: {}", exampleServiceInitializingBeanImplJavaConfig);
        assertThat(exampleServiceInitializingBeanImplJavaConfig instanceof ExampleService,
                is(true));
    }

    @Test
    public void testPostConstruct() {
        logger.info("exampleServiceInitializingBean: {}", exampleServiceInitializingBeanImpl);
        logger.info("exampleServiceInitializingBean..getInitializationOrder(): {}", exampleServiceInitializingBeanImpl.getInitializationOrder());

        List<String> initializationOrder = exampleServiceInitializingBeanImpl.getInitializationOrder();

        assertThat(initializationOrder.get(0), is("postConstruct"));
        assertThat(initializationOrder.get(1), is("afterPropertiesSet"));
        assertThat(initializationOrder.size(), is(2));

    }

    @Test
    public void testRequired() {
        assertThat(defaultPojo.getDescription(),
                is("A required field"));
    }

    //@Test
    public void testValue() {
        assertThat(systemProperty,
                is("static JavaConfiguration message: ${foo}"));
    }

    @Test
    public void testScheduled() {

        initSleep(5000);
        int count = scheduleTask.getCount();
        logger.info("Scheduled count: {}", count);

        assertThat(count > 40,
                is(true));

        assertThat(count < 75,
                is(true));

        scheduleTask.setCount(0);

        initSleep(1100);
        count = scheduleTask.getCount();
        logger.info("Scheduled count: {}", count);

        assertThat(count > 9,
                is(true));

        assertThat(count < 50,
                is(true));
    }

    @Test
    public void testAsync() {
        asyncTask.execute("testAsync", 1000);

        assertThat(asyncTask.isComplete(),
                is(false));

        initSleep(1250);

        assertThat(asyncTask.isComplete(),
                is(true));

        asyncTask.setComplete(false);

    }

    @Test
    public void testExecuteReturningFuture() {
        Future<String> future = asyncTask.executeReturningFuture("testExecuteReturningFuture", 1000);

        if(future.isDone()) {
            logger.info("Task Done");
        }
        else {
            logger.info("Still Working on Task");
        }

        assertThat(future.isDone(),
                is(false));

        assertThat(asyncTask.isComplete(),
                is(false));

        initSleep(1250);

        assertThat(future.isDone(),
                is(true));

        assertThat(asyncTask.isComplete(),
                is(true));

        asyncTask.setComplete(false);
    }

    private void initSleep(int time) {
        long end = System.currentTimeMillis() + time;
        while (System.currentTimeMillis() < end) {
            // Do nothing here Just time pass.
        }
    }

}
