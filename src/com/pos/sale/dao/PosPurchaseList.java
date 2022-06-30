package com.pos.sale.dao;

public class PosPurchaseList {

	private String productName;
	private String brand;
	private String quantity;
	private String price;
	private String amount;
	private String discount;
	private String imei;
	private String productId;
	
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
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
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	@Override
	public String toString() {
		return "PosPurchaseList [productName=" + productName + ", brand=" + brand + ", quantity=" + quantity
				+ ", price=" + price + ", amount=" + amount + ", discount=" + discount + ", imei=" + imei
				+ ", getProductName()=" + getProductName() + ", getBrand()=" + getBrand() + ", getQuantity()="
				+ getQuantity() + ", getPrice()=" + getPrice() + ", getAmount()=" + getAmount() + ", getDiscount()="
				+ getDiscount() + ", getImei()=" + getImei() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
