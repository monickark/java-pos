package com.pos.customer.controller;

import java.io.Serializable;

public class CustomerVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerId;
	private String customerName;
	private String email;
	private String phone;
	private String mobile;
	private String address;
	private String state;
	private String country;
	private String postCode;
	private String abnLicense;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAbnLicense() {
		return abnLicense;
	}
	public void setAbnLicense(String abnLicense) {
		this.abnLicense = abnLicense;
	}
	@Override
	public String toString() {
		return "CustomerVO [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email
				+ ", phone=" + phone + ", mobile=" + mobile + ", address=" + address + ", state=" + state + ", country="
				+ country + ", postCode=" + postCode + ", abnLicense=" + abnLicense + ", getCustomerId()="
				+ getCustomerId() + ", getCustomerName()=" + getCustomerName() + ", getEmail()=" + getEmail()
				+ ", getPhone()=" + getPhone() + ", getMobile()=" + getMobile() + ", getAddress()=" + getAddress()
				+ ", getState()=" + getState() + ", getCountry()=" + getCountry() + ", getPostCode()=" + getPostCode()
				+ ", getAbnLicense()=" + getAbnLicense() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
