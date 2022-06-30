package com.pos.product.controller;

public class BrandModelVO {
	private BrandVO brandVO;
	private ModelVO modelVO;
	public BrandVO getBrandVO() {
		return brandVO;
	}
	public void setBrandVO(BrandVO brandVO) {
		this.brandVO = brandVO;
	}
	public ModelVO getModelVO() {
		return modelVO;
	}
	public void setModelVO(ModelVO modelVO) {
		this.modelVO = modelVO;
	}
	@Override
	public String toString() {
		return "BrandModel [brandVO=" + brandVO + ", modelVO=" + modelVO + "]";
	}
 
}
