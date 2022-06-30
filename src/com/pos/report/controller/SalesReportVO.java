package com.pos.report.controller;

public class SalesReportVO {

	private String invoiceNo;
	private String customerId;
	private String date;
	private String amount;
	private String promoDiscount;
	private String tax;
	private String netAmount;
	private String amountPayable;

	private String customerName;
	private String imei;
	private String qty;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
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
	@Override
	public String toString() {
		return "SalesReportVO [invoiceNo=" + invoiceNo + ", customerId=" + customerId + ", date=" + date + ", amount="
				+ amount + ", promoDiscount=" + promoDiscount + ", tax=" + tax + ", netAmount=" + netAmount
				+ ", amountPayable=" + amountPayable + ", getInvoiceNo()=" + getInvoiceNo() + ", getCustomerId()="
				+ getCustomerId() + ", getDate()=" + getDate() + ", getAmount()=" + getAmount()
				+ ", getPromoDiscount()=" + getPromoDiscount() + ", getTax()=" + getTax() + ", getNetAmount()="
				+ getNetAmount() + ", getAmountPayable()=" + getAmountPayable() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
