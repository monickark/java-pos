package com.pos.framework.appCache.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface IApplicationCacheSMSPropertyDao {
	public List<SMSProperty> getPrpmCodes() throws NoDataFoundException;
}
