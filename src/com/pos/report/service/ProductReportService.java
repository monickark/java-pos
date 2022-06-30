package com.pos.report.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.common.business.CommonBusiness;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.report.controller.ProductReportListVO;
import com.pos.report.controller.ProductReportVO;
import com.pos.report.dao.IProductReportDAO;
import com.pos.report.dao.IRefundDAO;
import com.pos.report.dao.ProductReport;

@Service
public class ProductReportService implements IProductReportService {

	Logger logger = Logger.getLogger(ProductReportService.class.getName());
	@Autowired
	IProductReportDAO productReportDAO;
	@Autowired
	IRefundDAO refundDAO;
	@Autowired
	private CommonBusiness commonBussiness;
	
	@Override
	public List<ProductReportListVO> selectProductReport(ProductReportListVO productReportVO)throws NoDataFoundException  {
		List<ProductReportListVO> productReportVOs = new ArrayList<ProductReportListVO>();
		ProductReport productReport = new ProductReport();
		commonBussiness.changeObject(productReport, productReportVO);

		List<ProductReport> productReports = productReportDAO.selectProductReport();

		for (ProductReport productReport2 : productReports) {
			ProductReportListVO productReportVO2 = new ProductReportListVO();
			commonBussiness.changeObject(productReportVO2, productReport2);
			productReportVOs.add(productReportVO2);
		}
		return productReportVOs;
	
	}

	@Override
	public void refund(ProductReportListVO productReportVO,SessionCache sessionCache,
			ApplicationCache applicationCahce) throws DuplicateEntryException {
		System.out.println("Invoice service :" +productReportVO);
		ProductReport productReport = new ProductReport();
		commonBussiness.changeObject(productReport, productReportVO);
		productReport.setDbTs(1);
		productReport.setDelFlg("N");
		
		productReport.setrCreId(sessionCache.getUserSessionDetails().getUserId());
		productReport.setrModId(sessionCache.getUserSessionDetails().getUserId());
		System.out.println("Invoice service1 :" +productReport);
		refundDAO.insertRefund(productReport);
		

		
		
		
	}

	


}
