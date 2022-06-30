package com.pos.product.dao;

import com.pos.common.exceptions.DuplicateEntryException;

public interface IProductInventoryDAO {

	void insertProductInventory(ProductMaster productMaster) throws DuplicateEntryException;

	void deleteProductInventory(String Imei,String rModId);

}
