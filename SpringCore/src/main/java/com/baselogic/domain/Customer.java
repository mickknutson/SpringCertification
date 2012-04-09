package com.baselogic.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Customer
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
public class Customer { // JavaBean (Java) or POJO (Java) or Bean (Spring)

    private String firstName = null;
    
    private String lastName = null;
    
    private  Order order = null;
    
    private PhoneNumber phoneNumber = null;
    
    private Activity activity;
    
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}    
}
