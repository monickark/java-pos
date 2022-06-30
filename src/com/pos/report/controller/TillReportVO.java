package com.pos.report.controller;

public class TillReportVO {

	private String open_balance;
	private String sales;
	private String close_balance;
	private String date;
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
	@Override
	public String toString() {
		return "TillReportVO [open_balance=" + open_balance + ", sales=" + sales + ", close_balance=" + close_balance
				+ ", date=" + date + ", getOpen_balance()=" + getOpen_balance() + ", getSales()=" + getSales()
				+ ", getClose_balance()=" + getClose_balance() + ", getDate()=" + getDate() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
