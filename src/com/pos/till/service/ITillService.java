package com.pos.till.service;

import java.util.List;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.till.controller.TillVO;

public interface ITillService {

	void addTill(TillVO tillVO, SessionCache sessionCache, ApplicationCache applicationCache) throws DatabaseException, DuplicateEntryException;

	List<TillVO> selectTill(TillVO tillVO) throws NoDataFoundException;

	TillVO selectTillObj() throws NoDataFoundException;

	void updateTill(String status);

}
