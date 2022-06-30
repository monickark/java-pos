package com.pos.accessories.service;

import com.pos.accessories.controller.AddCategoryVO;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;

public interface IAddCategoryService {

	void addCategory(AddCategoryVO addCategoryVO, SessionCache sessionCache, ApplicationCache applicationCache) throws DatabaseException, DuplicateEntryException;

}
