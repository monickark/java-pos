package com.pos.accessories.dao;

public class AccessoriesList {

	private String name;
	private String brand;
	private String quantity;
	private String category;
	private String costPrice;
	private String sellingPrice;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}
	public String getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(String sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	@Override
	public String toString() {
		return "AccessoriesList [name=" + name + ", brand=" + brand + ", quantity=" + quantity + ", category="
				+ category + ", costPrice=" + costPrice + ", sellingPrice=" + sellingPrice + ", getName()=" + getName()
				+ ", getBrand()=" + getBrand() + ", getQuantity()=" + getQuantity() + ", getCategory()=" + getCategory()
				+ ", getCostPrice()=" + getCostPrice() + ", getSellingPrice()=" + getSellingPrice() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	

	
}
