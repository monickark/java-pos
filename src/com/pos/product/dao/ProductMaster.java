/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package com.pos.product.dao;

import java.io.Serializable;

import org.apache.log4j.Logger;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of ProductMaster.
 * 
 * @author Ebidrive
 */
public class ProductMaster implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Logger logger=Logger.getLogger(ProductMaster.class);
	/**
	 * Description of the property productId.
	 */
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
	
	/**
	 * Description of the property dbTs.
	 */
	private Integer dbTs;

	/**
	 * Description of the property delFlg.
	 */
	private String delFlg = "";

	/**
	 * Description of the property rCreTime.
	 */
	private String rCreTime = "";

	/**
	 * Description of the property rCreId.
	 */
	private String rCreId = "";

	/**
	 * Description of the property rModTime.
	 */
	private String rModTime = "";

	/**
	 * Description of the property rModId.
	 */
	private String rModId = "";

	// Start of user code (user defined attributes for ProductMaster)

	// End of user code

	private String inventoryId = "";
	private String invoiceDate = "";
	private String imei = "";
	private String costPrice = "";
	private String sellPrice = "";
	
	
	
	
	
	/**
	 * The constructor.
	 */
	public ProductMaster() {
		// Start of user code constructor for ProductMaster)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for ProductMaster)

	// End of user code
	/**
	 * Returns productId.
	 * @return productId 
	 */
	public String getProductId() {
		return this.productId;
	}

	/**
	 * Sets a value to attribute productId. 
	 * @param newProductId 
	 */
	public void setProductId(String newProductId) {
		this.productId = newProductId;
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

	/**
	 * Returns nonRemovalBattery.
	 * @return nonRemovalBattery 
	 */
	public String getNonRemovalBattery() {
		return this.nonRemovalBattery;
	}

	/**
	 * Sets a value to attribute nonRemovalBattery. 
	 * @param newNonRemovalBattery 
	 */
	public void setNonRemovalBattery(String newNonRemovalBattery) {
		this.nonRemovalBattery = newNonRemovalBattery;
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
	
	/**
	 * Returns dbTs.
	 * @return rCreId 
	 */
	public Integer getDbTs() {
		return this.dbTs;
	}

	/**
	 * Sets a value to attribute dbTs. 
	 * @param newDbTs 
	 */
	public void setDbTs(Integer newDbTs) {
		this.dbTs = newDbTs;
	}

	/**
	 * Returns delFlg.
	 * @return delFlg 
	 */
	public String getDelFlg() {
		return this.delFlg;
	}

	/**
	 * Sets a value to attribute delFlg. 
	 * @param newDelFlg 
	 */
	public void setDelFlg(String newDelFlg) {
		this.delFlg = newDelFlg;
	}

	/**
	 * Returns rCreTime.
	 * @return rCreTime 
	 */
	public String getRCreTime() {
		return this.rCreTime;
	}

	/**
	 * Sets a value to attribute rCreTime. 
	 * @param newRCreTime 
	 */
	public void setRCreTime(String newRCreTime) {
		this.rCreTime = newRCreTime;
	}

	/**
	 * Returns rCreId.
	 * @return rCreId 
	 */
	public String getRCreId() {
		return this.rCreId;
	}

	/**
	 * Sets a value to attribute rCreId. 
	 * @param newRCreId 
	 */
	public void setRCreId(String newRCreId) {
		this.rCreId = newRCreId;
	}

	/**
	 * Returns rModTime.
	 * @return rModTime 
	 */
	public String getRModTime() {
		return this.rModTime;
	}

	/**
	 * Sets a value to attribute rModTime. 
	 * @param newRModTime 
	 */
	public void setRModTime(String newRModTime) {
		this.rModTime = newRModTime;
	}

	/**
	 * Returns rModId.
	 * @return rModId 
	 */
	public String getRModId() {
		return this.rModId;
	}

	/**
	 * Sets a value to attribute rModId. 
	 * @param newRModId 
	 */
	public void setRModId(String newRModId) {
		this.rModId = newRModId;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
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
		return "ProductMaster [logger=" + logger + ", productId=" + productId + ", productName=" + productName
				+ ", category=" + category + ", brand=" + brand + ", colour=" + colour + ", model=" + model
				+ ", simType=" + simType + ", simCardSize=" + simCardSize + ", dimensions=" + dimensions + ", display="
				+ display + ", battery=" + battery + ", nonRemovalBattery=" + nonRemovalBattery + ", ramCapacity="
				+ ramCapacity + ", os=" + os + ", description=" + description + ", published=" + published + ", dbTs="
				+ dbTs + ", delFlg=" + delFlg + ", rCreTime=" + rCreTime + ", rCreId=" + rCreId + ", rModTime="
				+ rModTime + ", rModId=" + rModId + ", inventoryId=" + inventoryId + ", invoiceDate=" + invoiceDate
				+ ", imei=" + imei + ", costPrice=" + costPrice + ", sellPrice=" + sellPrice + "]";
	}

	
}
