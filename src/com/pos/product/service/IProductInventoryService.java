package com.pos.product.service;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.product.controller.ProductInventoryVO;

public interface IProductInventoryService {

	List<ProductInventoryVO> selectProductInventoryList(ProductInventoryVO productInventoryVO) throws NoDataFoundException;

	List<ProductInventoryVO> viewProductInventory(String productId,
			String inventoryDate) throws NoDataFoundException;

}
