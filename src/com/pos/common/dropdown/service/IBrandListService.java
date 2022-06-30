package com.pos.common.dropdown.service;

import java.util.Map;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.product.controller.BrandModelVO;
import com.pos.product.controller.BrandVO;

public interface IBrandListService {

	Map<String, String> getBrandList() throws NoDataFoundException;

	void addBrand(BrandVO brandListVO, SessionCache sessionCache,
			ApplicationCache applicationCahce) throws DatabaseException,
			DuplicateEntryException;

}
