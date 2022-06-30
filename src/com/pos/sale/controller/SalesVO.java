package com.pos.sale.controller;

import java.io.Serializable;

public class SalesVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String invoiceNo;
	private String amount;
	private String promoDiscount;
	private String tax;
	private String netAmount;
	private String amountPayable;
	private String date;
	private String customerId;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
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
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "SalesVO [invoiceNo=" + invoiceNo + ", amount=" + amount
				+ ", promoDiscount=" + promoDiscount + ", tax=" + tax
				+ ", netAmount=" + netAmount + ", amountPayable="
				+ amountPayable + ", date=" + date + ", customerId="
				+ customerId + ", getDate()=" + getDate() + ", getInvoiceNo()="
				+ getInvoiceNo() + ", getAmount()=" + getAmount()
				+ ", getPromoDiscount()=" + getPromoDiscount() + ", getTax()="
				+ getTax() + ", getNetAmount()=" + getNetAmount()
				+ ", getAmountPayable()=" + getAmountPayable()
				+ ", getCustomerId()=" + getCustomerId() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
