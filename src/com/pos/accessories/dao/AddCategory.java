package com.pos.accessories.dao;

public class AddCategory {

	private int dbTs;
	private String categoryId;
	private String categoryName;
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
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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
		return "category [dbTs=" + dbTs + ", categoryId=" + categoryId + ", categoryName=" + categoryName + ", delFlg="
				+ delFlg + ", rCreTime=" + rCreTime + ", rCreId=" + rCreId + ", rModTime=" + rModTime + ", rModId="
				+ rModId + ", getDbTs()=" + getDbTs() + ", getCategoryId()=" + getCategoryId() + ", getCategoryName()="
				+ getCategoryName() + ", getDelFlg()=" + getDelFlg() + ", getrCreTime()=" + getrCreTime()
				+ ", getrCreId()=" + getrCreId() + ", getrModTime()=" + getrModTime() + ", getrModId()=" + getrModId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
