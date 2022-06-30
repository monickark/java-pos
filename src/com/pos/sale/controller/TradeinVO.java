package com.pos.sale.controller;

import java.io.Serializable;

public class TradeinVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TradeinVO [t_invoiceId=" + t_invoiceId + ", invoiceDate="
				+ invoiceDate + ", customerName=" + customerName
				+ ", contactNo=" + contactNo + ", lisenceNumber="
				+ lisenceNumber + ", brand=" + brand + ", modelNo=" + modelNo
				+ ", color=" + color + ", capacity=" + capacity + ", imei="
				+ imei + ", resaleValue=" + resaleValue + ", description="
				+ description + ", status=" + status + ", getT_invoiceId()="
				+ getT_invoiceId() + ", getInvoiceDate()=" + getInvoiceDate()
				+ ", getCustomerName()=" + getCustomerName()
				+ ", getContactNo()=" + getContactNo()
				+ ", getLisenceNumber()=" + getLisenceNumber()
				+ ", getBrand()=" + getBrand() + ", getModelNo()="
				+ getModelNo() + ", getColor()=" + getColor()
				+ ", getCapacity()=" + getCapacity() + ", getImei()="
				+ getImei() + ", getResaleValue()=" + getResaleValue()
				+ ", getDescription()=" + getDescription() + ", getStatus()="
				+ getStatus() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
