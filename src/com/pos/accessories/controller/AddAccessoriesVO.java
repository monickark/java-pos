package com.pos.accessories.controller;

import java.io.Serializable;

public class AddAccessoriesVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accessoriesInventoryId;;
	private String accessoriesId;
	private String category;
	private String brand;
	private String name;
	private String inStock;
	private String quantity;
	private String costPrice;
	private String sellingPrice;
	private String shortDescription;

	public String getAccessoriesInventoryId() {
		return accessoriesInventoryId;
	}

	public void setAccessoriesInventoryId(String accessoriesInventoryId) {
		this.accessoriesInventoryId = accessoriesInventoryId;
	}

	public String getAccessoriesId() {
		return accessoriesId;
	}

	public void setAccessoriesId(String accessoriesId) {
		this.accessoriesId = accessoriesId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInStock() {
		return inStock;
	}

	public void setInStock(String inStock) {
		this.inStock = inStock;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
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

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	@Override
	public String toString() {
		return "AddAccessoriesVO [accessoriesInventoryId="
				+ accessoriesInventoryId + ", accessoriesId=" + accessoriesId
				+ ", category=" + category + ", brand=" + brand + ", name="
				+ name + ", inStock=" + inStock + ", quantity=" + quantity
				+ ", costPrice=" + costPrice + ", sellingPrice=" + sellingPrice
				+ ", shortDescription=" + shortDescription
				+ ", getAccessoriesInventoryId()="
				+ getAccessoriesInventoryId() + ", getAccessoriesId()="
				+ getAccessoriesId() + ", getCategory()=" + getCategory()
				+ ", getBrand()=" + getBrand() + ", getName()=" + getName()
				+ ", getInStock()=" + getInStock() + ", getQuantity()="
				+ getQuantity() + ", getCostPrice()=" + getCostPrice()
				+ ", getSellingPrice()=" + getSellingPrice()
				+ ", getShortDescription()=" + getShortDescription()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
