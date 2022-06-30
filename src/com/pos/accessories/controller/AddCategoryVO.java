package com.pos.accessories.controller;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class AddCategoryVO implements Serializable{

	/**
	 * 
	 */
	Logger logger = Logger.getLogger(AddCategoryVO.class);
	private static final long serialVersionUID = 1L;
	private String categoryId;
	private String categoryName;

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

	@Override
	public String toString() {
		return "CatyegoryVO [categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", getCategoryId()=" + getCategoryId()
				+ ", getCategoryName()=" + getCategoryName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
