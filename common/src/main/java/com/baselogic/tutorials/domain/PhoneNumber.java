package com.baselogic.tutorials.domain;

/**
 * PhoneNumber
 *
 * <p>Spring Certification objective: 1.2 Lifecycle</p>
 *
 * @since 2012
 *
 */
public class PhoneNumber {

	String areaCode;
	String prefix;
	String suffix;

	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}


	@Override
	public String toString() {
		return "PhoneNumber [areaCode=" + areaCode + ", prefix=" + prefix
				+ ", suffix=" + suffix + "]";
	}


}
