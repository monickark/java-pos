package com.pos.report.dao;

public class SalesRefundReport {

	
	private String invoiceNo;
	private String productId;
	private String productName;
	private String refundDate;
	private String refundAmount;
	private String refundReason;
	
	
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getRefundDate() {
		return refundDate;
	}
	public void setRefundDate(String refundDate) {
		this.refundDate = refundDate;
	}
	public String getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	
	@Override
	public String toString() {
		return "SalesRefundReport [invoiceNo=" + invoiceNo + ", productId=" + productId + ", productName=" + productName
				+ ", refundDate=" + refundDate + ", refundAmount=" + refundAmount + ", refundReason=" + refundReason
				+ ", getInvoiceNo()=" + getInvoiceNo() + ", getProductId()=" + getProductId() + ", getProductName()="
				+ getProductName() + ", getRefundDate()=" + getRefundDate() + ", getRefundAmount()=" + getRefundAmount()
				+ ", getRefundReason()=" + getRefundReason() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
