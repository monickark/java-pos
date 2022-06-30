package com.pos.framework.appCache.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface IApplicationCacheTableMaintenanceDao {

	List<TableMaintenance> getTableMaintenanceData()
			throws NoDataFoundException;

}
