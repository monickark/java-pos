package com.pos.framework.appCache.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface IApplicationCacheProfileOptionLinking {

	List<MenuProfileOptionLinking> getMenuProfileOption()
			throws NoDataFoundException;

	List<MenuProfileOptionLinking> getMenuProfile() throws NoDataFoundException;
}
