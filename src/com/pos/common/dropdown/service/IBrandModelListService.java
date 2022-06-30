package com.pos.common.dropdown.service;

import java.util.Map;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.product.controller.ModelVO;

public interface IBrandModelListService {

	Map<String, String> getBrandModelList()throws NoDataFoundException;

	void addBrandModel(ModelVO modelVO, SessionCache sessionCache, ApplicationCache applicationCache) throws DatabaseException, DuplicateEntryException;

	Map<String, String> getBrandModelList(String brand)
			throws NoDataFoundException;

}
