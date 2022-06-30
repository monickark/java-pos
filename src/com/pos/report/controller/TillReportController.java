package com.pos.report.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pos.common.business.CommonBusiness;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.report.service.ITillReportService;

@Controller
public class TillReportController {
	
	Logger logger = Logger.getLogger(TillReportController.class.getName());
	
	@Autowired
	private CommonBusiness commonBussiness;
	@Autowired
	private ITillReportService tillReportService;
	
	@RequestMapping(value = "/tillReport", method = RequestMethod.GET)
	public String tillReport(@ModelAttribute("tillReport") TillReportVO tillReportVO,
			HttpSession session) throws NoDataFoundException {
		List<TillReportVO> tillReportVOs = tillReportService.selectTillReport(tillReportVO);
		session.setAttribute("tillReport", tillReportVOs);

		return ".pos.tillReport";

	}

}
