package com.pos.accessories.service;

import com.pos.accessories.controller.AddAccessoriesVO;
import com.pos.accessories.dao.AddAccessoriesInventory;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;

public interface IAddAccessoriesInventoryService {

	void addAccessoriesInventory(AddAccessoriesVO addAccessoriesVO, SessionCache sessionCache, ApplicationCache applicationCache) throws DatabaseException, DuplicateEntryException;

	AddAccessoriesInventory getList(String accessoriesId) throws NoDataFoundException, DuplicateEntryException;
}
