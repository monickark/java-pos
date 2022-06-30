package com.pos.report.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.customer.controller.CustomerVO;
import com.pos.report.service.ICustomerReportService;

@Controller
public class CustomerReportController {

	@Autowired
	ICustomerReportService customerReportService;
	
	@RequestMapping(value = "/customerReport", method = RequestMethod.GET)
	public String salesReport(@ModelAttribute("customerReport") CustomerVO customerVO,
			HttpSession session) throws NoDataFoundException {
		List<CustomerVO> customerVOs = customerReportService.selectCustomer(customerVO);
		session.setAttribute("customerReport", customerVOs);

		return ".pos.customerReport";

	}
}
