package com.pos.report.dao;

public class ProductReport {

	private int dbTs;
	private String saleId;
	private String invoiceNo;
	private String imei;
	private String productId;
	private String quantity;
	private String price;
	private String amount;
	private String discount;
	private String refundAmount;
	private String refundReason;
	private String refundDate;
	private String delFlg;
	private String rCreTime;
	private String rCreId;
	private String rModTime;
	private String rModId;
	private String category;

	public int getDbTs() {
		return dbTs;
	}

	public void setDbTs(int dbTs) {
		this.dbTs = dbTs;
	}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
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

	public String getRefundDate() {
		return refundDate;
	}

	public void setRefundDate(String refundDate) {
		this.refundDate = refundDate;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductReport [dbTs=" + dbTs + ", saleId=" + saleId
				+ ", invoiceNo=" + invoiceNo + ", imei=" + imei
				+ ", productId=" + productId + ", quantity=" + quantity
				+ ", price=" + price + ", amount=" + amount + ", discount="
				+ discount + ", refundAmount=" + refundAmount
				+ ", refundReason=" + refundReason + ", refundDate="
				+ refundDate + ", delFlg=" + delFlg + ", rCreTime=" + rCreTime
				+ ", rCreId=" + rCreId + ", rModTime=" + rModTime + ", rModId="
				+ rModId + ", category=" + category + ", getDbTs()="
				+ getDbTs() + ", getSaleId()=" + getSaleId()
				+ ", getInvoiceNo()=" + getInvoiceNo() + ", getImei()="
				+ getImei() + ", getProductId()=" + getProductId()
				+ ", getQuantity()=" + getQuantity() + ", getPrice()="
				+ getPrice() + ", getAmount()=" + getAmount()
				+ ", getDiscount()=" + getDiscount() + ", getRefundAmount()="
				+ getRefundAmount() + ", getRefundReason()="
				+ getRefundReason() + ", getRefundDate()=" + getRefundDate()
				+ ", getDelFlg()=" + getDelFlg() + ", getrCreTime()="
				+ getrCreTime() + ", getrCreId()=" + getrCreId()
				+ ", getrModTime()=" + getrModTime() + ", getrModId()="
				+ getrModId() + ", getCategory()=" + getCategory()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
