package com.baselogic.components;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * PropertyInjectionComponent
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
/*
 * @see http://springindepth.com/book/in-depth-ioc-constructor-setter-injection.html
 * @see http://springindepth.com/book/in-depth-ioc-multiple-parameter-constructor-injection.html
 *
 */
public class PropertyInjectionComponent {
	
	private String message;
	
	private int someInt;
	
	private double someDouble;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
