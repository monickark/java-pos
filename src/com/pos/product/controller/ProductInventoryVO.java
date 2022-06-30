/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package com.pos.product.controller;

import java.io.Serializable;

import org.apache.log4j.Logger;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of ProductInventoryVO.
 * 
 * @author Ebidrive
 */
public class ProductInventoryVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(ProductInventoryVO.class);
	private String productId = "";
	private String productName = "";
	private String category = "";
	private String brand = "";
	private String colour = "";
	private String model = "";
	private String inventoryId = "";
	private String inventoryDate = "";
	private String imei = "";
	private String quantity = "";
	private String costPrice = "";
	private String sellPrice = "";

	public String getProductId() {
		return this.productId;
	}

	/**
	 * Sets a value to attribute productId.
	 * 
	 * @param newProductId
	 */
	public void setProductId(String newProductId) {
		this.productId = newProductId;
	}

	/**
	 * Returns productName.
	 * 
	 * @return productName
	 */
	public String getProductName() {
		return this.productName;
	}

	/**
	 * Sets a value to attribute productName.
	 * 
	 * @param newProductName
	 */
	public void setProductName(String newProductName) {
		this.productName = newProductName;
	}

	/**
	 * Returns category.
	 * 
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets a value to attribute category.
	 * 
	 * @param newcategory
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Returns brand.
	 * 
	 * @return brand
	 */
	public String getBrand() {
		return this.brand;
	}

	/**
	 * Sets a value to attribute brand.
	 * 
	 * @param newBrand
	 */
	public void setBrand(String newBrand) {
		this.brand = newBrand;
	}

	/**
	 * Returns colour.
	 * 
	 * @return colour
	 */
	public String getColour() {
		return this.colour;
	}

	/**
	 * Sets a value to attribute colour.
	 * 
	 * @param newColour
	 */
	public void setColour(String newColour) {
		this.colour = newColour;
	}

	/**
	 * Returns model.
	 * 
	 * @return model
	 */
	public String getModel() {
		return this.model;
	}

	/**
	 * Sets a value to attribute model.
	 * 
	 * @param newModel
	 */
	public void setModel(String newModel) {
		this.model = newModel;
	}

	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInventoryDate() {
		return inventoryDate;
	}

	public void setInventoryDate(String inventoryDate) {
		this.inventoryDate = inventoryDate;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
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

	public String getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}

	@Override
	public String toString() {
		return "ProductInventory [logger=" + logger + ", productId="
				+ productId + ", productName=" + productName + ", category="
				+ category + ", brand=" + brand + ", colour=" + colour
				+ ", model=" + model + ", inventoryId=" + inventoryId
				+ ", invoiceDate=" + inventoryDate + ", imei=" + imei
				+ ", costPrice=" + costPrice + ", sellPrice=" + sellPrice + "]";
	}

}
