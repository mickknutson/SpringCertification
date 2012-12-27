package com.baselogic.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Spring Certification objective: 1.2 Lifecycle
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
@Component
public class SimpleComponent {

    private static final Logger logger = LoggerFactory.getLogger(SimpleComponent.class);

    private String message;

    public SimpleComponent() {
        message = "default constructor";
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


    public void init(){
        message += ": init";
    }

    private void privateInit(){
        message += ": privateInit";
    }

    private String privateInitWithReturnValue(){
        message += ": privateInitWithReturnValue";
        return message;
    }

    private void destroy(){
        logger.info("destroy...");
    }


    /**
     * Example of a stand-alone execution of a Spring container.
     * @param args
     */
	public static void main(String... args) {

		ApplicationContext springApplicationContext = new ClassPathXmlApplicationContext(
				"/META-INF/spring/simple.xml");

		SimpleComponent simpleComponent = springApplicationContext.getBean("simpleComponent", SimpleComponent.class);

		System.out.println("simpleComponent:getMessage() is "
				+ simpleComponent.getMessage());

		SimpleComponent simpleComponentAlias = springApplicationContext.getBean("simpleComponentAlias", SimpleComponent.class);

		logger.info("simpleComponentAlias:getMessage() is "
				+ simpleComponentAlias.getMessage());


		// Single constructor args:
		ConstructorInjectionComponent constructorInjectionComponent =
				springApplicationContext.getBean("constructorInjectionComponent", ConstructorInjectionComponent.class);

		logger.info("constructorInjectionComponent:getMessage() is "
			+ constructorInjectionComponent.getMessage());


		// Multiple constructor args default
		MultipleConstructorInjectionComponent multipleConstructorInjectionComponent = springApplicationContext
				.getBean("multipleConstructorInjectionComponent",
						MultipleConstructorInjectionComponent.class);

		logger.info("multipleConstructorInjectionComponent:getMessage() is "
				+ multipleConstructorInjectionComponent.getMessage());

		// Multiple constructor args default
		MultipleConstructorInjectionComponent multipleConstructorInjectionComponentByIndex = springApplicationContext
				.getBean("multipleConstructorInjectionComponentByIndex",
						MultipleConstructorInjectionComponent.class);

		logger.info("multipleConstructorInjectionComponentByIndex:getMessage() is "
				+ multipleConstructorInjectionComponentByIndex.getMessage());



		PropertyInjectionComponent propertyInjectionComponent = springApplicationContext
				.getBean("propertyInjectionComponent",
						PropertyInjectionComponent.class);

		logger.info("propertyInjectionComponent: String: "
				+ propertyInjectionComponent.getMessage() +", instance of String: "
				+ (propertyInjectionComponent.getMessage() instanceof String));

		logger.info("propertyInjectionComponent: int: "
				+ propertyInjectionComponent.getSomeInt() +", instance of Integer: "
				+ (propertyInjectionComponent.getSomeInt() instanceof Integer));

		logger.info("propertyInjectionComponent: double: "
				+ propertyInjectionComponent.getSomeDouble() +", instance of Double: "
				+ (propertyInjectionComponent.getSomeDouble() instanceof Double));



		/*ApplicationContext springApplicationContext2 = new ClassPathXmlApplicationContext(
				"/META-INF/spring/simple2.xml");

		ExampleService exampleService2 = (ExampleService) springApplicationContext2
				.getBean("exampleService");

		logger.info("exampleService2:getMessage() is "
				+ exampleService2.getMessage());

		ExampleService altExampleService2 = (ExampleService) springApplicationContext2
				.getBean("altExampleService");

		logger.info("altExampleService2:getMessage() is "
				+ altExampleService2.getMessage());*/
	}

}
