package com.pos.accessories.service;

import java.util.Map;

import com.pos.accessories.controller.AddAccessoriesVO;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;

public interface IAddAccessoriesService {

	AddAccessoriesVO addAccessories(AddAccessoriesVO addAccessoriesVO, SessionCache sessionCache,
			ApplicationCache applicationCache) throws DatabaseException, DuplicateEntryException;
	
	Map<String, String> getName(String category, String brand) throws NoDataFoundException;

	Map<String, String> getBrand(String category) throws NoDataFoundException;
}
