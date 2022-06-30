package com.pos.accessories.dao;


import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;

public interface IAddAccessoriesInventoryDAO {

	void insertAccessoriesInventory(AddAccessoriesInventory addAccessoriesInventory) throws DuplicateEntryException;
	
	AddAccessoriesInventory getList(String accessoriesId) throws NoDataFoundException;

	void updateAccessoryInventory(String inventoryid, String qty, String rModId);

}
