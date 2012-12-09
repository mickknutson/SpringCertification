package com.baselogic.demos;

//Static imports

import com.baselogic.components.ConstructorInjectionComponent;
import com.baselogic.components.MultipleConstructorInjectionComponent;
import com.baselogic.components.PropertyInjectionComponent;
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
import static org.hamcrest.Matchers.not;


/**
 * Spring Certification objective: 1.1 General
 *
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#beans">Objective 1.1 General</a>
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
public class Objective_1_1_General_Tests {

	private static final Logger logger = LoggerFactory.getLogger(Objective_1_1_General_Tests.class);

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
    public void testConstructorInjection() {

        ConstructorInjectionComponent constructorInjectionComponent1 =
                applicationContext.getBean("constructorInjectionComponent", ConstructorInjectionComponent.class);

        ConstructorInjectionComponent constructorInjectionComponent2 =
                applicationContext.getBean("constructorInjectionComponent", ConstructorInjectionComponent.class);

        logger.debug("constructorInjectionComponent1: {}", constructorInjectionComponent1.toString());
        logger.debug("constructorInjectionComponent2: {}", constructorInjectionComponent2.toString());

        assertThat(constructorInjectionComponent1,
                equalTo(constructorInjectionComponent2));

        assertThat(constructorInjectionComponent1.getSomeDouble(),
                equalTo(constructorInjectionComponent2.getSomeDouble()));

        assertThat(constructorInjectionComponent1 instanceof ConstructorInjectionComponent,
                is(true));
    }

    @Test
    public void testMultipleConstructorInjectionComponent() {
        MultipleConstructorInjectionComponent multipleConstructorInjectionComponent =
                applicationContext.getBean("multipleConstructorInjectionComponent", MultipleConstructorInjectionComponent.class);

        assertThat(multipleConstructorInjectionComponent.getMessage(),
                is("Constructor Arg 1::Constructor Arg 2"));
    }

    @Test
    public void testMultipleConstructorInjectionComponentByIndex() {
        MultipleConstructorInjectionComponent multipleConstructorInjectionComponentByIndex =
                applicationContext.getBean("multipleConstructorInjectionComponentByIndex", MultipleConstructorInjectionComponent.class);

        assertThat(multipleConstructorInjectionComponentByIndex.getMessage(),
                is("Constructor Arg 1::Constructor Arg 2"));
    }



    @Test
    public void testSingletonPropertyInjectionComponent() {

        PropertyInjectionComponent propertyInjectionComponent1 =
                applicationContext.getBean("propertyInjectionComponent", PropertyInjectionComponent.class);

        PropertyInjectionComponent propertyInjectionComponent2 =
                applicationContext.getBean("propertyInjectionComponent", PropertyInjectionComponent.class);

        logger.info(">>>------------------------------------------------->>>");
        logger.debug("propertyInjectionComponent1: {}", propertyInjectionComponent1.toString());
        logger.debug("propertyInjectionComponent2: {}", propertyInjectionComponent2.toString());

        assertThat(propertyInjectionComponent1,
                equalTo(propertyInjectionComponent2));

        assertThat(propertyInjectionComponent1.getSomeDouble(),
                equalTo(propertyInjectionComponent2.getSomeDouble()));

        assertThat(propertyInjectionComponent1 instanceof PropertyInjectionComponent,
                is(true));
    }

    @Test
    public void testPrototypePropertyInjectionComponent() {

        PropertyInjectionComponent prototypePropertyInjectionComponent1 =
                applicationContext.getBean("prototypePropertyInjectionComponent", PropertyInjectionComponent.class);

        PropertyInjectionComponent prototypePropertyInjectionComponent2 =
                applicationContext.getBean("prototypePropertyInjectionComponent", PropertyInjectionComponent.class);

        logger.info(">>>------------------------------------------------->>>");
        logger.debug("prototypePropertyInjectionComponent1: {}", prototypePropertyInjectionComponent1.toString());
        logger.debug("prototypePropertyInjectionComponent2: {}", prototypePropertyInjectionComponent2.toString());

        assertThat(prototypePropertyInjectionComponent1,
                not(equalTo(prototypePropertyInjectionComponent2)));

        assertThat(prototypePropertyInjectionComponent1.getSomeDouble(),
                not(equalTo(prototypePropertyInjectionComponent2.getSomeDouble())));

        assertThat(prototypePropertyInjectionComponent1 instanceof PropertyInjectionComponent,
                is(true));
    }

}