package com.pos.repair.dao;

public class Repair {

	private int dbTs;
	private String repairId;
	private String name;
	private String contactNo;
	private String productName;
	private String reason;
	private String repairValue;
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
		return "Repair [dbTs=" + dbTs + ", repairId=" + repairId + ", name=" + name + ", contactNo=" + contactNo
				+ ", productName=" + productName + ", reason=" + reason + ", repairValue=" + repairValue + ", delFlg="
				+ delFlg + ", rCreTime=" + rCreTime + ", rCreId=" + rCreId + ", rModTime=" + rModTime + ", rModId="
				+ rModId + ", getDbTs()=" + getDbTs() + ", getRepairId()=" + getRepairId() + ", getName()=" + getName()
				+ ", getContactNo()=" + getContactNo() + ", getProductName()=" + getProductName() + ", getReason()="
				+ getReason() + ", getRepairValue()=" + getRepairValue() + ", getDelFlg()=" + getDelFlg()
				+ ", getrCreTime()=" + getrCreTime() + ", getrCreId()=" + getrCreId() + ", getrModTime()="
				+ getrModTime() + ", getrModId()=" + getrModId() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
