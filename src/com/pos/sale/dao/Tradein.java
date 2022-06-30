package com.pos.sale.dao;

import java.io.Serializable;

public class Tradein implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dbTs;
	private String t_invoiceId;
	private String invoiceDate;
	private String customerName;
	private String contactNo;
	private String lisenceNumber;
	private String brand;
	private String modelNo;
	private String color;
	private String capacity;
	private String imei;
	private String resaleValue;
	private String description;
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
	public String getT_invoiceId() {
		return t_invoiceId;
	}
	public void setT_invoiceId(String t_invoiceId) {
		this.t_invoiceId = t_invoiceId;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getLisenceNumber() {
		return lisenceNumber;
	}
	public void setLisenceNumber(String lisenceNumber) {
		this.lisenceNumber = lisenceNumber;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModelNo() {
		return modelNo;
	}
	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getResaleValue() {
		return resaleValue;
	}
	public void setResaleValue(String resaleValue) {
		this.resaleValue = resaleValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		return "Tradein [dbTs=" + dbTs + ", t_invoiceId=" + t_invoiceId
				+ ", invoiceDate=" + invoiceDate + ", customerName="
				+ customerName + ", contactNo=" + contactNo
				+ ", lisenceNumber=" + lisenceNumber + ", brand=" + brand
				+ ", modelNo=" + modelNo + ", color=" + color + ", capacity="
				+ capacity + ", imei=" + imei + ", resaleValue=" + resaleValue
				+ ", description=" + description + ", delFlg=" + delFlg
				+ ", rCreTime=" + rCreTime + ", rCreId=" + rCreId
				+ ", rModTime=" + rModTime + ", rModId=" + rModId
				+ ", getDbTs()=" + getDbTs() + ", getT_invoiceId()="
				+ getT_invoiceId() + ", getInvoiceDate()=" + getInvoiceDate()
				+ ", getCustomerName()=" + getCustomerName()
				+ ", getContactNo()=" + getContactNo()
				+ ", getLisenceNumber()=" + getLisenceNumber()
				+ ", getBrand()=" + getBrand() + ", getModelNo()="
				+ getModelNo() + ", getColor()=" + getColor()
				+ ", getCapacity()=" + getCapacity() + ", getImei()="
				+ getImei() + ", getResaleValue()=" + getResaleValue()
				+ ", getDescription()=" + getDescription() + ", getDelFlg()="
				+ getDelFlg() + ", getrCreTime()=" + getrCreTime()
				+ ", getrCreId()=" + getrCreId() + ", getrModTime()="
				+ getrModTime() + ", getrModId()=" + getrModId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
