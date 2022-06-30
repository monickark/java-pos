package com.pos.product.controller;

public class ModelVO {

	private String modelId;
	private String brandId;
	private String modelValue;
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getModelValue() {
		return modelValue;
	}
	public void setModelValue(String modelValue) {
		this.modelValue = modelValue;
	}

	@Override
	public String toString() {
		return "BrandModelList [modelId=" + modelId + ", brandId=" + brandId + ", modelValue=" + modelValue
				+ ", getModelId()=" + getModelId() + ", getBrandId()=" + getBrandId() + ", getModelValue()="
				+ getModelValue() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
