package com.pos.report.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.common.business.CommonBusiness;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.report.controller.SalesRefundReportVO;
import com.pos.report.controller.SalesReportVO;
import com.pos.report.dao.ISalesRefundReportDAO;
import com.pos.report.dao.SalesRefundReport;
import com.pos.report.dao.SalesReport;

@Service
public class SalesRefundReportService implements ISalesRefundReportService {

	@Autowired
	ISalesRefundReportDAO salesRefundReportDAO;
	@Autowired
	private CommonBusiness commonBussiness;
	
	@Override
	public List<SalesRefundReportVO> selectSalesRefundReport(SalesRefundReportVO salesRefundReportVO)throws NoDataFoundException {
		
		List<SalesRefundReportVO> salesRefundReportVOs = new ArrayList<SalesRefundReportVO>();
		SalesRefundReport salesRefundReport = new SalesRefundReport();
		commonBussiness.changeObject(salesRefundReport, salesRefundReportVO);

		List<SalesRefundReport> salesRefundReports = salesRefundReportDAO.selectSalesRefundReport();

		for (SalesRefundReport salesRefundReport2 : salesRefundReports) {
			SalesRefundReportVO salesRefundReportVO2 = new SalesRefundReportVO();
			commonBussiness.changeObject(salesRefundReportVO2, salesRefundReport2);
			salesRefundReportVOs.add(salesRefundReportVO2);
		}
		return salesRefundReportVOs;
	}

}
