package com.pos.report.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.common.business.CommonBusiness;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.product.controller.ProductMasterVO;
import com.pos.product.dao.ProductMaster;
import com.pos.report.controller.SalesReportVO;
import com.pos.report.dao.ISalesReportDAO;
import com.pos.report.dao.SalesReport;
@Service
public class SalesReportService implements ISalesReportService {

	Logger logger = Logger.getLogger(SalesReportService.class.getName());
	@Autowired
	ISalesReportDAO salesReportDAO;
	@Autowired
	private CommonBusiness commonBussiness;
	
	
	@Override
	public List<SalesReportVO> selectSalesReport(SalesReportVO salesReportVO)throws NoDataFoundException {
		List<SalesReportVO> salesReportVOs = new ArrayList<SalesReportVO>();
		SalesReport salesReport = new SalesReport();
		commonBussiness.changeObject(salesReport, salesReportVO);

		List<SalesReport> salesReports = salesReportDAO.selectSalesReport();

		for (SalesReport salesReport2 : salesReports) {
			SalesReportVO salesReportVO2 = new SalesReportVO();
			commonBussiness.changeObject(salesReportVO2, salesReport2);
			salesReportVOs.add(salesReportVO2);
		}
		return salesReportVOs;
	}

}
