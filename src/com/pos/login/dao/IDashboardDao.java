package com.pos.login.dao;

import com.pos.common.exceptions.NoDataFoundException;

public interface IDashboardDao {

	DashboardConsolidated retriveDashboardDetails(
			DashboardConsolidatedKey dashboardConsolidatedKey)
			throws NoDataFoundException;

}
