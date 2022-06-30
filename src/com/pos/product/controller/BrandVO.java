package com.pos.product.controller;

public class BrandVO {

	private String brandId;
	private String brandName;
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
	@Override
	public String toString() {
		return "BrandListVO [brandId=" + brandId + ", brandName=" + brandName + ", getBrandId()=" + getBrandId()
				+ ", getBrandName()=" + getBrandName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
