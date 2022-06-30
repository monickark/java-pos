package com.pos.common.dropdown.dao;

public class BrandList {
private int dbTs;
private String brandId;
private String brandName;
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
public String getBrandId() {
	return brandId;
}
public void setBrandId(String brandId) {
	this.brandId = brandId;
}
public String getBrandName() {
	return brandName;
}
public void setBrandName(String brandName) {
	this.brandName = brandName;
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
	return "BrandList [dbTs=" + dbTs + ", brandId=" + brandId + ", brandName=" + brandName + ", delFlg=" + delFlg
			+ ", rCreTime=" + rCreTime + ", rCreId=" + rCreId + ", rModTime=" + rModTime + ", rModId=" + rModId
			+ ", getDbTs()=" + getDbTs() + ", getBrandId()=" + getBrandId() + ", getBrandName()=" + getBrandName()
			+ ", getDelFlg()=" + getDelFlg() + ", getrCreTime()=" + getrCreTime() + ", getrCreId()=" + getrCreId()
			+ ", getrModTime()=" + getrModTime() + ", getrModId()=" + getrModId() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
}
