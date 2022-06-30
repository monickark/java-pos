package com.pos.customer.dao;

public class Customer {

	private int dbTs;
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
	private String delFlg;
	private String rCreTime;
	private String rCreId;
	private String rModTime;
	private String rModId;
	public int getDbTs() {
		return dbTs;
	}
	public void setDbTs(int dbTs) {
		this.dbTs = dbTs;
	}
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
	public String getDelFlg() {
		return delFlg;
	}
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}
	public String getrCreTime() {
		return rCreTime;
	}
	public void setrCreTime(String rCreTime) {
		this.rCreTime = rCreTime;
	}
	public String getrCreId() {
		return rCreId;
	}
	public void setrCreId(String rCreId) {
		this.rCreId = rCreId;
	}
	public String getrModTime() {
		return rModTime;
	}
	public void setrModTime(String rModTime) {
		this.rModTime = rModTime;
	}
	public String getrModId() {
		return rModId;
	}
	public void setrModId(String rModId) {
		this.rModId = rModId;
	}
	@Override
	public String toString() {
		return "Customer [dbTs=" + dbTs + ", customerId=" + customerId + ", customerName=" + customerName + ", email="
				+ email + ", phone=" + phone + ", mobile=" + mobile + ", address=" + address + ", state=" + state
				+ ", country=" + country + ", postCode=" + postCode + ", abnLicense=" + abnLicense + ", delFlg="
				+ delFlg + ", rCreTime=" + rCreTime + ", rCreId=" + rCreId + ", rModTime=" + rModTime + ", rModId="
				+ rModId + ", getDbTs()=" + getDbTs() + ", getCustomerId()=" + getCustomerId() + ", getCustomerName()="
				+ getCustomerName() + ", getEmail()=" + getEmail() + ", getPhone()=" + getPhone() + ", getMobile()="
				+ getMobile() + ", getAddress()=" + getAddress() + ", getState()=" + getState() + ", getCountry()="
				+ getCountry() + ", getPostCode()=" + getPostCode() + ", getAbnLicense()=" + getAbnLicense()
				+ ", getDelFlg()=" + getDelFlg() + ", getrCreTime()=" + getrCreTime() + ", getrCreId()=" + getrCreId()
				+ ", getrModTime()=" + getrModTime() + ", getrModId()=" + getrModId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
