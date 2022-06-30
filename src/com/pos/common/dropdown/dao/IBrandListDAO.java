package com.pos.common.dropdown.dao;

import java.util.List;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.framework.sessCache.UserSessionDetails;

public interface IBrandListDAO {

	List<BrandList> selectBrandList();

	void addBrand(BrandList brandList) throws DuplicateEntryException;
	

}
