package com.pos.accessories.dao;

import java.util.List;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;

public interface IAddAccessoriesDAO {

	void insertAddAccessories(AddAccessories addAccessories) throws DuplicateEntryException;
	
	List<AddAccessories> selectName(String category, String brand) throws NoDataFoundException;

	List<AddAccessories> selectBrand(String category) throws NoDataFoundException;

}
