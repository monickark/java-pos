package com.pos.accessories.dao;

public class AddAccessoriesInventory {

	private int dbTs;
	private String accessoriesId;
	private String accessoriesInventoryId;
	private String quantity;
	private String costPrice;
	private String sellingPrice;
	private String shortDescription;
	private String delFlg;
	private String rCreTime;
	private String rCreId;
	private String rModTime;
	private String rModId;
	public int getDbTs() {
		return dbTs;
	}
	public void setDbTs(int dbTs) {
		this.dbTs = dbTs;
	}
	public String getAccessoriesId() {
		return accessoriesId;
	}
	public void setAccessoriesId(String accessoriesId) {
		this.accessoriesId = accessoriesId;
	}
	public String getAccessoriesInventoryId() {
		return accessoriesInventoryId;
	}
	public void setAccessoriesInventoryId(String accessoriesInventoryId) {
		this.accessoriesInventoryId = accessoriesInventoryId;
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
		return "AddAccessoriesInventory [dbTs=" + dbTs + ", accessoriesId=" + accessoriesId
				+ ", accessoriesInventoryId=" + accessoriesInventoryId + ", quantity=" + quantity + ", costPrice="
				+ costPrice + ", sellingPrice=" + sellingPrice + ", shortDescription=" + shortDescription + ", delFlg="
				+ delFlg + ", rCreTime=" + rCreTime + ", rCreId=" + rCreId + ", rModTime=" + rModTime + ", rModId="
				+ rModId + ", getDbTs()=" + getDbTs() + ", getAccessoriesId()=" + getAccessoriesId()
				+ ", getAccessoriesInventoryId()=" + getAccessoriesInventoryId() + ", getQuantity()=" + getQuantity()
				+ ", getCostPrice()=" + getCostPrice() + ", getSellingPrice()=" + getSellingPrice()
				+ ", getShortDescription()=" + getShortDescription() + ", getDelFlg()=" + getDelFlg()
				+ ", getrCreTime()=" + getrCreTime() + ", getrCreId()=" + getrCreId() + ", getrModTime()="
				+ getrModTime() + ", getrModId()=" + getrModId() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
