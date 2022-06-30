package com.pos.framework.appCache.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface IApplicationCacheCommonCodeDao {
	public List<CommonCode> getAllCommonCodeList() throws NoDataFoundException;

	void setSQL();

}
