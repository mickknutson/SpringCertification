package com.baselogic.tutorials.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Customer
 * Spring Certification objective: 1.2 Lifecycle
 *
 * @since 2012
 *
 */
public class Customer { // JavaBean (Java) or POJO (Java) or Bean (Spring)

    private String firstName = null;

    private String lastName = null;

    private Order order = null;

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
