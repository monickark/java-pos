package com.pos.till.dao;

import java.io.Serializable;

public class Till implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dbTs;
	private String tillId;
	private String date;
	private String amount;
	private String description;
	private String status;
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
	public String getTillId() {
		return tillId;
	}
	public void setTillId(String tillId) {
		this.tillId = tillId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
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
		return "Till [dbTs=" + dbTs + ", tillId=" + tillId + ", date=" + date + ", amount=" + amount + ", description="
				+ description + ", status=" + status + ", delFlg=" + delFlg + ", rCreTime=" + rCreTime + ", rCreId="
				+ rCreId + ", rModTime=" + rModTime + ", rModId=" + rModId + ", getDbTs()=" + getDbTs()
				+ ", getTillId()=" + getTillId() + ", getDate()=" + getDate() + ", getAmount()=" + getAmount()
				+ ", getDescription()=" + getDescription() + ", getStatus()=" + getStatus() + ", getDelFlg()="
				+ getDelFlg() + ", getrCreTime()=" + getrCreTime() + ", getrCreId()=" + getrCreId() + ", getrModTime()="
				+ getrModTime() + ", getrModId()=" + getrModId() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
