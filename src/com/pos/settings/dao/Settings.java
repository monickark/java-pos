package com.pos.settings.dao;

import java.io.Serializable;

public class Settings implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int dbTs;
	public String companyId;
	public String address1;
	public String address2;
	public String licenseNo;
	public String mobileNo;
	public String email;
	public String promoDiscount;
	public String tax;
	public String printerName;
	public String delFlg;
	public String rCreTime;
	public String rCreId;
	public String rModTime;
	public String rModId;
	public int getDbTs() {
		return dbTs;
	}
	public void setDbTs(int dbTs) {
		this.dbTs = dbTs;
	}
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
		return "Setting [dbTs=" + dbTs + ", companyId=" + companyId + ", address1=" + address1 + ", address2="
				+ address2 + ", licenseNo=" + licenseNo + ", mobileNo=" + mobileNo + ", email=" + email
				+ ", promoDiscount=" + promoDiscount + ", tax=" + tax + ", printerName=" + printerName + ", delFlg="
				+ delFlg + ", rCreTime=" + rCreTime + ", rCreId=" + rCreId + ", rModTime=" + rModTime + ", rModId="
				+ rModId + ", getDbTs()=" + getDbTs() + ", getCompanyId()=" + getCompanyId() + ", getAddress1()="
				+ getAddress1() + ", getAddress2()=" + getAddress2() + ", getLicenseNo()=" + getLicenseNo()
				+ ", getMobileNo()=" + getMobileNo() + ", getEmail()=" + getEmail() + ", getPromoDiscount()="
				+ getPromoDiscount() + ", getTax()=" + getTax() + ", getPrinterName()=" + getPrinterName()
				+ ", getDelFlg()=" + getDelFlg() + ", getrCreTime()=" + getrCreTime() + ", getrCreId()=" + getrCreId()
				+ ", getrModTime()=" + getrModTime() + ", getrModId()=" + getrModId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
