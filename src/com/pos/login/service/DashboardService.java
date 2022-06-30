package com.pos.login.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pos.common.business.CommonBusiness;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.UserSessionDetails;
import com.pos.login.controller.DashboardConsolidatedVO;
import com.pos.login.dao.DashboardConsolidated;
import com.pos.login.dao.DashboardConsolidatedKey;
import com.pos.login.dao.IDashboardDao;

@Service
public class DashboardService implements IDashboardService {

	Logger logger = Logger.getLogger(DashboardService.class);
	@Autowired
	IDashboardDao dashboardDao;
	@Autowired
	CommonBusiness commonBusiness;
	@Autowired
	@Qualifier(value = "simpleIdGenerator")
	private IIdGeneratorService simpleIdGenerator;

	
	@Override
	
	public DashboardConsolidatedVO selectDashboardRecord(String fromDate, String toDate, UserSessionDetails userSessionDetails) throws NoDataFoundException {

		DashboardConsolidatedKey dashboardConsolidatedKey=new DashboardConsolidatedKey();
		dashboardConsolidatedKey.setInstId(userSessionDetails.getInstId());
		dashboardConsolidatedKey.setBranchId(userSessionDetails.getBranchId());
		dashboardConsolidatedKey.setFromDate(fromDate);
		dashboardConsolidatedKey.setToDate(toDate);
		DashboardConsolidatedVO   consolidatedVO=new DashboardConsolidatedVO();
		DashboardConsolidated consolidated=dashboardDao.retriveDashboardDetails(dashboardConsolidatedKey);
		commonBusiness.changeObject(consolidatedVO, consolidated);
		return consolidatedVO;

		
	}

}
