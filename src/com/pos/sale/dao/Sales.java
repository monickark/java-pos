package com.pos.sale.dao;

import java.io.Serializable;

public class Sales implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dbTs;
	private String invoiceNo;
	private String customerId;
	private String amount;
	private String promoDiscount;
	private String tax;
	private String netAmount;
	private String amountPayable;
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

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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

	public String getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(String netAmount) {
		this.netAmount = netAmount;
	}

	public String getAmountPayable() {
		return amountPayable;
	}

	public void setAmountPayable(String amountPayable) {
		this.amountPayable = amountPayable;
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
		return "Sales [dbTs=" + dbTs + ", invoiceNo=" + invoiceNo
				+ ", customerId=" + customerId + ", amount=" + amount
				+ ", promoDiscount=" + promoDiscount + ", tax=" + tax
				+ ", netAmount=" + netAmount + ", amountPayable="
				+ amountPayable + ", date=" + date + ", delFlg=" + delFlg
				+ ", rCreTime=" + rCreTime + ", rCreId=" + rCreId
				+ ", rModTime=" + rModTime + ", rModId=" + rModId
				+ ", getDbTs()=" + getDbTs() + ", getInvoiceNo()="
				+ getInvoiceNo() + ", getCustomerId()=" + getCustomerId()
				+ ", getAmount()=" + getAmount() + ", getPromoDiscount()="
				+ getPromoDiscount() + ", getTax()=" + getTax()
				+ ", getNetAmount()=" + getNetAmount()
				+ ", getAmountPayable()=" + getAmountPayable() + ", getDate()="
				+ getDate() + ", getDelFlg()=" + getDelFlg()
				+ ", getrCreTime()=" + getrCreTime() + ", getrCreId()="
				+ getrCreId() + ", getrModTime()=" + getrModTime()
				+ ", getrModId()=" + getrModId() + "]";
	}
}
