package com.baselogic.tutorials.components;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

/**
 * MultipleConstructorInjectionComponent
 *
 * <p>Spring Certification objective: 1.2 Lifecycle</p>
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#beans">Objective 1.2 Lifecycle</a>
 *
 * <p>Spring Certification objective: 1.3 Annotations</p>
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html#beans">Objective 1.3 Annotations</a>
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
/*
 * @see http://springindepth.com/book/in-depth-ioc-constructor-setter-injection.html
 * @see http://springindepth.com/book/in-depth-ioc-multiple-parameter-constructor-injection.html
 */
@Component
public class MultipleConstructorInjectionComponent {

    private String message;

    private Integer someInt;

    private Double someDouble;

    private SimpleComponent simpleComponent;

    private PropertyInjectionComponent propertyInjectionComponent;

    public MultipleConstructorInjectionComponent(){
		message = "default constructor";
	}

    public MultipleConstructorInjectionComponent(String message, Integer someInt, Double someDouble) {
        this.message = message;
        this.someInt = someInt;
        this.someDouble = someDouble;
    }

//    @Autowired
	public MultipleConstructorInjectionComponent(String message1, String message2){
		this.message = message1 + "::" + message2;
	}

	public String getMessage() {
		return message;
	}

    public Integer getSomeInt() {
        return someInt;
    }

    public void setSomeInt(Integer someInt) {
        this.someInt = someInt;
    }

    public Double getSomeDouble() {
        return someDouble;
    }

    public void setSomeDouble(Double someDouble) {
        this.someDouble = someDouble;
    }

    public SimpleComponent getSimpleComponent() {
        return simpleComponent;
    }

    /**
     * Example of setter based @Autowired annotation.
     * @Autowired public setValue(field) {}
     * If > 1 match, throws exception (unless injecting into Collection).
     * If no matches, sets to null unless using @Required or required attribute
     *
     * @param simpleComponent
     */
    @Autowired
    @Required
    public void setSimpleComponent(SimpleComponent simpleComponent) {
        this.simpleComponent = simpleComponent;
    }

    public PropertyInjectionComponent getPropertyInjectionComponent() {
        return propertyInjectionComponent;
    }

    /**
     * TODO FIXME: This does NOT set the field to null!
     *
     * in Spring 3.0.*, this was suppose set a 'null' for @Autowired but this does NOT!!!
     * In Spring 3.1.*, an error is thrown if no bean candidate is found.
     * @param propertyInjectionComponent
     * @Throws NoSuchBeanDefinitionException
     */
//    @Autowired
    public void setPropertyInjectionComponent(PropertyInjectionComponent propertyInjectionComponent) {
        this.propertyInjectionComponent = propertyInjectionComponent;
    }


    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
