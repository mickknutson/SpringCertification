package com.baselogic.demos.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import java.util.Arrays;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

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
 * @see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a>
 * @see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a>
 *
 * @since 2012
 *
 */
public class Customer { // JavaBean (Java) or POJO (Java) or Bean (Spring)

		//textbox
		@NotNull
	    @Min(3)
	    @Max(80)
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
		return ToStringBuilder.reflectionToString(this);
		}

	}