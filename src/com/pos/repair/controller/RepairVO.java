package com.pos.repair.controller;

public class RepairVO {

	private String repairId;
	private String name;
	private String contactNo;
	private String productName;
	private String reason;
	private String repairValue;
	public String getRepairId() {
		return repairId;
	}
	public void setRepairId(String repairId) {
		this.repairId = repairId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRepairValue() {
		return repairValue;
	}
	public void setRepairValue(String repairValue) {
		this.repairValue = repairValue;
	}
	@Override
	public String toString() {
		return "RepairVO [repairId=" + repairId + ", name=" + name + ", contactNo=" + contactNo + ", productName="
				+ productName + ", reason=" + reason + ", repairValue=" + repairValue + ", getRepairId()="
				+ getRepairId() + ", getName()=" + getName() + ", getContactNo()=" + getContactNo()
				+ ", getProductName()=" + getProductName() + ", getReason()=" + getReason() + ", getRepairValue()="
				+ getRepairValue() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
