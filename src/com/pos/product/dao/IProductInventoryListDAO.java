package com.pos.product.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface IProductInventoryListDAO {

	List<ProductInventory> selectProductInventory() throws NoDataFoundException;

	List<ProductInventory> viewProductInventory(String productId,
			String inventoryDate) throws NoDataFoundException;

}
