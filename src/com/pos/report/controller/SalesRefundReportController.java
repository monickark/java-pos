package com.pos.report.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.report.service.ISalesRefundReportService;

@Controller
public class SalesRefundReportController {

	@Autowired
	ISalesRefundReportService salesRefundReportService;

	@RequestMapping(value = "/refundReport", method = RequestMethod.GET)
	public String refundReport(
			@ModelAttribute("refundReport") SalesRefundReportVO salesRefundReportVO,
			HttpSession session) throws NoDataFoundException {
		List<SalesRefundReportVO> salesRefundReportVOs = salesRefundReportService
				.selectSalesRefundReport(salesRefundReportVO);
		session.setAttribute("refundReport", salesRefundReportVOs);

		return ".pos.refundReport";

	}
}
