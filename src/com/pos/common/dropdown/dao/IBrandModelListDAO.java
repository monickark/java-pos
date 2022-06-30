package com.pos.common.dropdown.dao;

import java.util.List;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;

public interface IBrandModelListDAO {

	List<BrandModelList> selectBrandModelList();

	void addBrandModel(BrandModelList brandModelList) throws DuplicateEntryException;

	List<BrandModelList> selectBrandModelList(String brand) throws NoDataFoundException;

	

}
