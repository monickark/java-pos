package com.pos.framework.appCache.dao;

import java.util.HashMap;

import com.pos.common.exceptions.NoDataFoundException;

public interface IApplicationCacheErrorCodeDao {
	public HashMap<String, String> getAllErrorCode()
			throws NoDataFoundException;

}
