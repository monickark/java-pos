package com.pos.framework.appCache.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface IApplicationCachePropertyMaintenanceDao {
	public List<PropertyMaintenance> getPrpmCodes() throws NoDataFoundException;
}
