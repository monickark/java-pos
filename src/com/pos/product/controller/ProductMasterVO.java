/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package com.pos.product.controller;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of ProductMasterVO.
 * 
 * @author Ebidrive
 */
@Component
public class ProductMasterVO implements Serializable{
	
	

	Logger logger=Logger.getLogger(ProductMasterVO.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String productId = "";
	

	/**
	 * Description of the property productName.
	 */
	private String productName = "";
	
	/**
	 * Description of the property category.
	 */
	private String category = "";
	
	/**
	 * Description of the property brand.
	 */
	private String brand = "";

	/**
	 * Description of the property colour.
	 */
	private String colour = "";

	/**
	 * Description of the property model.
	 */
	private String model = "";

	/**
	 * Description of the property simType.
	 */
	private String simType = "";

	/**
	 * Description of the property simCardSize.
	 */
	private String simCardSize = "";

	/**
	 * Description of the property dimensions.
	 */
	private String dimensions = "";

	/**
	 * Description of the property display.
	 */
	public String display = "";

	/**
	 * Description of the property battery.
	 */
	private String battery = "";

	/**
	 * Description of the property nonRemovalBattery.
	 */
	private String nonRemovalBattery = "";

	/**
	 * Description of the property ramCapacity.
	 */
	private String ramCapacity = "";

	/**
	 * Description of the property os.
	 */
	private String os = "";

	/**
	 * Description of the property description.
	 */
	private String description = "";

	

	/**
	 * Description of the property published.
	 */
	private String published = "";
	
	private String inventoryId = "";
	private String invoiceDate = "";
	private String imei = "";
	private String costPrice ="";
	private String sellPrice = ""; 

	// Start of user code (user defined attributes for ProductMasterVO)

	// End of user code

	

	/**
	 * The constructor.
	 */
	public ProductMasterVO() {
		// Start of user code constructor for ProductMasterVO)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for ProductMasterVO)

	// End of user code
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * Returns productName.
	 * @return productName 
	 */
	public String getProductName() {
		return this.productName;
	}

	/**
	 * Sets a value to attribute productName. 
	 * @param newProductName 
	 */
	public void setProductName(String newProductName) {
		this.productName = newProductName;
	}
	
	/**
	 * Returns category.
	 * @return category 
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * Sets a value to attribute category. 
	 * @param newcategory 
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Returns brand.
	 * @return brand 
	 */
	public String getBrand() {
		return this.brand;
	}

	/**
	 * Sets a value to attribute brand. 
	 * @param newBrand 
	 */
	public void setBrand(String newBrand) {
		this.brand = newBrand;
	}

	/**
	 * Returns colour.
	 * @return colour 
	 */
	public String getColour() {
		return this.colour;
	}

	/**
	 * Sets a value to attribute colour. 
	 * @param newColour 
	 */
	public void setColour(String newColour) {
		this.colour = newColour;
	}

	/**
	 * Returns model.
	 * @return model 
	 */
	public String getModel() {
		return this.model;
	}

	/**
	 * Sets a value to attribute model. 
	 * @param newModel 
	 */
	public void setModel(String newModel) {
		this.model = newModel;
	}

	/**
	 * Returns simType.
	 * @return simType 
	 */
	public String getSimType() {
		return this.simType;
	}

	/**
	 * Sets a value to attribute simType. 
	 * @param newSimType 
	 */
	public void setSimType(String newSimType) {
		this.simType = newSimType;
	}

	/**
	 * Returns simCardSize.
	 * @return simCardSize 
	 */
	public String getSimCardSize() {
		return this.simCardSize;
	}

	/**
	 * Sets a value to attribute simCardSize. 
	 * @param newSimCardSize 
	 */
	public void setSimCardSize(String newSimCardSize) {
		this.simCardSize = newSimCardSize;
	}

	/**
	 * Returns dimensions.
	 * @return dimensions 
	 */
	public String getDimensions() {
		return this.dimensions;
	}

	/**
	 * Sets a value to attribute dimensions. 
	 * @param newDimensions 
	 */
	public void setDimensions(String newDimensions) {
		this.dimensions = newDimensions;
	}

	/**
	 * Returns display.
	 * @return display 
	 */
	public String getDisplay() {
		return this.display;
	}

	/**
	 * Sets a value to attribute display. 
	 * @param newDisplay 
	 */
	public void setDisplay(String newDisplay) {
		this.display = newDisplay;
	}

	/**
	 * Returns battery.
	 * @return battery 
	 */
	public String getBattery() {
		return this.battery;
	}

	/**
	 * Sets a value to attribute battery. 
	 * @param newBattery 
	 */
	public void setBattery(String newBattery) {
		this.battery = newBattery;
	}



	public String getNonRemovalBattery() {
		return nonRemovalBattery;
	}

	public void setNonRemovalBattery(String nonRemovalBattery) {
		this.nonRemovalBattery = nonRemovalBattery;
	}

	/**
	 * Returns ramCapacity.
	 * @return ramCapacity 
	 */
	public String getRamCapacity() {
		return this.ramCapacity;
	}

	/**
	 * Sets a value to attribute ramCapacity. 
	 * @param newRamCapacity 
	 */
	public void setRamCapacity(String newRamCapacity) {
		this.ramCapacity = newRamCapacity;
	}

	/**
	 * Returns os.
	 * @return os 
	 */
	public String getOs() {
		return this.os;
	}

	/**
	 * Sets a value to attribute os. 
	 * @param newOs 
	 */
	public void setOs(String newOs) {
		this.os = newOs;
	}

	/**
	 * Returns description.
	 * @return description 
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets a value to attribute description. 
	 * @param newDescription 
	 */
	public void setDescription(String newDescription) {
		this.description = newDescription;
	}

	
	/**
	 * Returns published.
	 * @return published 
	 */
	public String getPublished() {
		return this.published;
	}

	/**
	 * Sets a value to attribute published. 
	 * @param newPublished 
	 */
	public void setPublished(String newPublished) {
		this.published = newPublished;
	}
	
	public String getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
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
		return "ProductMasterVO [logger=" + logger + ", productId=" + productId + ", productName=" + productName
				+ ", category=" + category + ", brand=" + brand + ", colour=" + colour + ", model=" + model
				+ ", simType=" + simType + ", simCardSize=" + simCardSize + ", dimensions=" + dimensions + ", display="
				+ display + ", battery=" + battery + ", nonRemovalBattery=" + nonRemovalBattery + ", ramCapacity="
				+ ramCapacity + ", os=" + os + ", description=" + description + ", published=" + published
				+ ", inventoryId=" + inventoryId + ", invoiceDate=" + invoiceDate + ", imei=" + imei + ", costPrice="
				+ costPrice + ", sellPrice=" + sellPrice + ", getProductId()=" + getProductId() + ", getProductName()="
				+ getProductName() + ", getCategory()=" + getCategory() + ", getBrand()=" + getBrand()
				+ ", getColour()=" + getColour() + ", getModel()=" + getModel() + ", getSimType()=" + getSimType()
				+ ", getSimCardSize()=" + getSimCardSize() + ", getDimensions()=" + getDimensions() + ", getDisplay()="
				+ getDisplay() + ", getBattery()=" + getBattery() + ", isNonRemovalBattery()=" + getNonRemovalBattery()
				+ ", getRamCapacity()=" + getRamCapacity() + ", getOs()=" + getOs() + ", getDescription()="
				+ getDescription() + ", getPublished()=" + getPublished() + ", getInventoryId()=" + getInventoryId()
				+ ", getInvoiceDate()=" + getInvoiceDate() + ", getImei()=" + getImei() + ", getCostPrice()="
				+ getCostPrice() + ", getSellPrice()=" + getSellPrice() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}
