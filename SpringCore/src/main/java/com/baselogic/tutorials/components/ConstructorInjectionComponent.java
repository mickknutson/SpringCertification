package com.baselogic.tutorials.components;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ConstructorInjectionComponent
 *
 * This example shows how to construct a non-mutable object.
 *
 * <p>Spring Certification objective: 1.2 Lifecycle</p>
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html#beans">Objective 1.2 Lifecycle</a>
 *
 * <p>Spring Certification objective: 1.3 Annotations</p>
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html#beans">Objective 1.3 Annotations</a>
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
/*
 * at_see http://springindepth.com/book/in-depth-ioc-constructor-setter-injection.html
 * at_see http://springindepth.com/book/in-depth-ioc-multiple-parameter-constructor-injection.html
 *
 * <bean id="constructorInjectionComponent"
 * 		 class="com.baselogic.tutorials.components.ConstructorInjectionComponent" />
 */
@Component
public class ConstructorInjectionComponent {

    private String message;

    private Integer someInt;

    private Double someDouble;

    public ConstructorInjectionComponent(){
        message = "default constructor";
    }

    public ConstructorInjectionComponent(String message) {
        this.message = message;
    }

    public ConstructorInjectionComponent(String message, Integer someInt, Double someDouble) {
        this.message = message;
        this.someInt = someInt;
        this.someDouble = someDouble;
    }

    /**
     * Autowired constructor example.
     *
     * @param message1
     * @param message2
     */
//    @Autowired
    public ConstructorInjectionComponent(String message1, String message2){
        this.message = message1 +"::"+message2;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
