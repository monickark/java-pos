package com.pos.login.service;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.sessCache.UserSessionDetails;
import com.pos.login.controller.DashboardConsolidatedVO;

public interface IDashboardService {

	DashboardConsolidatedVO selectDashboardRecord(String fromDate,
			String toDate, UserSessionDetails userSessionDetails) throws NoDataFoundException;


}
