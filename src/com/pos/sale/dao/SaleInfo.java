package com.pos.sale.dao;

import java.io.Serializable;

public class SaleInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dbTs;
	private String saleId;
	private String customerId;
	private String invoiceNo;
	private String imei;
	private String productId;
	private String quantity;
	private String price;
	private String amount;
	private String discount;
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
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
		return "SaleInfo [dbTs=" + dbTs + ", saleId=" + saleId
				+ ", customerId=" + customerId + ", invoiceNo=" + invoiceNo
				+ ", imei=" + imei + ", productId=" + productId + ", quantity="
				+ quantity + ", price=" + price + ", amount=" + amount
				+ ", discount=" + discount + ", delFlg=" + delFlg
				+ ", rCreTime=" + rCreTime + ", rCreId=" + rCreId
				+ ", rModTime=" + rModTime + ", rModId=" + rModId
				+ ", category=" + category + ", getDbTs()=" + getDbTs()
				+ ", getSaleId()=" + getSaleId() + ", getCustomerId()="
				+ getCustomerId() + ", getInvoiceNo()=" + getInvoiceNo()
				+ ", getImei()=" + getImei() + ", getProductId()="
				+ getProductId() + ", getQuantity()=" + getQuantity()
				+ ", getPrice()=" + getPrice() + ", getAmount()=" + getAmount()
				+ ", getDiscount()=" + getDiscount() + ", getDelFlg()="
				+ getDelFlg() + ", getrCreTime()=" + getrCreTime()
				+ ", getrCreId()=" + getrCreId() + ", getrModTime()="
				+ getrModTime() + ", getrModId()=" + getrModId()
				+ ", getCategory()=" + getCategory() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
