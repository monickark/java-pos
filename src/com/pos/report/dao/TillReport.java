package com.pos.report.dao;

public class TillReport {

	private int dbTs;
	private String open_balance;
	private String sales;
	private String close_balance;
	private String date;
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
	public String getOpen_balance() {
		return open_balance;
	}
	public void setOpen_balance(String open_balance) {
		this.open_balance = open_balance;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public String getClose_balance() {
		return close_balance;
	}
	public void setClose_balance(String close_balance) {
		this.close_balance = close_balance;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
		return "TillReport [dbTs=" + dbTs + ", open_balance=" + open_balance + ", sales=" + sales + ", close_balance="
				+ close_balance + ", date=" + date + ", delFlg=" + delFlg + ", rCreTime=" + rCreTime + ", rCreId="
				+ rCreId + ", rModTime=" + rModTime + ", rModId=" + rModId + ", getDbTs()=" + getDbTs()
				+ ", getOpen_balance()=" + getOpen_balance() + ", getSales()=" + getSales() + ", getClose_balance()="
				+ getClose_balance() + ", getDate()=" + getDate() + ", getDelFlg()=" + getDelFlg() + ", getrCreTime()="
				+ getrCreTime() + ", getrCreId()=" + getrCreId() + ", getrModTime()=" + getrModTime() + ", getrModId()="
				+ getrModId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
