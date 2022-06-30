package com.pos.report.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pos.common.business.CommonBusiness;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.product.controller.ProductMasterVO;
import com.pos.report.service.ISalesReportService;

@Controller
public class SalesReportController {

	Logger logger = Logger.getLogger(SalesReportController.class.getName());
	
	@Autowired
	ISalesReportService salesReportService;
	@Autowired
	private CommonBusiness commonBussiness;
	
	
	@RequestMapping(value = "/salesReport", method = RequestMethod.GET)
	public String salesReport(@ModelAttribute("salesReport") SalesReportVO salesReportVO,
			HttpSession session) throws NoDataFoundException {
		List<SalesReportVO> salesReportVOs = salesReportService.selectSalesReport(salesReportVO);
		session.setAttribute("salesReport", salesReportVOs);

		return ".pos.salesReport";

	}

}
