package com.pos.accessories.dao;

public class AddAccessories {

	private int dbts;
	private String accessoriesId;
	private String category;
	private String brand;
	private String name;
	private String quantity;
	private String shortDescription;
	private String delFlg;
	private String rCreTime;
	private String rCreId;
	private String rModTime;
	private String rModId;
	
	public String getAccessoriesId() {
		return accessoriesId;
	}
	public void setAccessoriesId(String accessoriesId) {
		this.accessoriesId = accessoriesId;
	}
	public int getDbts() {
		return dbts;
	}
	public void setDbts(int dbts) {
		this.dbts = dbts;
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
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
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
	@Override
	public String toString() {
		return "AddAccessories [dbts=" + dbts + ", accessoriesId=" + accessoriesId + ", category=" + category
				+ ", brand=" + brand + ", name=" + name + ", quantity=" + quantity + ", shortDescription="
				+ shortDescription + ", delFlg=" + delFlg + ", rCreTime=" + rCreTime + ", rCreId=" + rCreId
				+ ", rModTime=" + rModTime + ", rModId=" + rModId + ", getAccessoriesId()=" + getAccessoriesId()
				+ ", getDbts()=" + getDbts() + ", getCategory()=" + getCategory() + ", getBrand()=" + getBrand()
				+ ", getName()=" + getName() + ", getQuantity()=" + getQuantity() + ", getShortDescription()="
				+ getShortDescription() + ", getDelFlg()=" + getDelFlg() + ", getrCreTime()=" + getrCreTime()
				+ ", getrCreId()=" + getrCreId() + ", getrModTime()=" + getrModTime() + ", getrModId()=" + getrModId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
