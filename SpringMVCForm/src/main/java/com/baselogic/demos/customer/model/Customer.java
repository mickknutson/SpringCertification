package com.baselogic.demos.customer.model;

import java.util.Arrays;

import org.springmodules.validation.bean.conf.loader.annotation.handler.*;

public class Customer {
	
	//textbox
	@NotBlank
    @Length(max = 80)
	String userName;
	
	//textarea
	String address;
	
	//password
	String password;
	String confirmPassword;
	
	//checkbox
	boolean receiveNewsletter;
	String [] favFramework;
	
	//radio button
	String favNumber;
	String sex;
	
	//dropdown box
	String country;
	String javaSkills;
	
	//hidden value
	String secretValue;
	
	public String getSecretValue() {
		return secretValue;
	}
	public void setSecretValue(String secretValue) {
		this.secretValue = secretValue;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public boolean isReceiveNewsletter() {
		return receiveNewsletter;
	}
	public void setReceiveNewsletter(boolean receiveNewsletter) {
		this.receiveNewsletter = receiveNewsletter;
	}
	public String[] getFavFramework() {
		return favFramework;
	}
	public void setFavFramework(String[] favFramework) {
		this.favFramework = favFramework;
	}
	public String getFavNumber() {
		return favNumber;
	}
	public void setFavNumber(String favNumber) {
		this.favNumber = favNumber;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getJavaSkills() {
		return javaSkills;
	}
	public void setJavaSkills(String javaSkills) {
		this.javaSkills = javaSkills;
	}
	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", address=" + address
				+ ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", receiveNewsletter=" + receiveNewsletter
				+ ", favFramework=" + Arrays.toString(favFramework)
				+ ", favNumber=" + favNumber + ", sex=" + sex + ", country="
				+ country + ", javaSkills=" + javaSkills + ", secretValue="
				+ secretValue + "]";
	}	
	
}