package com.pos.settings.controller;

import java.io.Serializable;

public class SettingsVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String companyId;
	public String address1;
	public String address2;
	public String licenseNo;
	public String mobileNo;
	public String email;
	public String promoDiscount;
	public String tax;
	public String printerName;
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPromoDiscount() {
		return promoDiscount;
	}
	public void setPromoDiscount(String promoDiscount) {
		this.promoDiscount = promoDiscount;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getPrinterName() {
		return printerName;
	}
	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}
	@Override
	public String toString() {
		return "SettingVO [companyId=" + companyId + ", address1=" + address1 + ", address2=" + address2
				+ ", licenseNo=" + licenseNo + ", mobileNo=" + mobileNo + ", email=" + email + ", promoDiscount="
				+ promoDiscount + ", tax=" + tax + ", printerName=" + printerName + ", getCompanyId()=" + getCompanyId()
				+ ", getAddress1()=" + getAddress1() + ", getAddress2()=" + getAddress2() + ", getLicenseNo()="
				+ getLicenseNo() + ", getMobileNo()=" + getMobileNo() + ", getEmail()=" + getEmail()
				+ ", getPromoDiscount()=" + getPromoDiscount() + ", getTax()=" + getTax() + ", getPrinterName()="
				+ getPrinterName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
