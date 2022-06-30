package com.pos.customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.ErrorCodeConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.customer.service.ICustomerService;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;


@Controller
public class CustomerController {

	Logger logger = Logger.getLogger(CustomerController.class.getName());
	
	@Autowired
	ICustomerService customerService;
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ModelAndView addCustomerGet(@ModelAttribute("customer") CustomerVO customerVO) {
		logger.debug("Opening customer Page");
		ModelAndView mav = new ModelAndView(".pos.customer","customer", customerVO);
		return mav;
}
	@RequestMapping(value = "customer", method = RequestMethod.POST)
	public ModelAndView addCustomerPost(@ModelAttribute("customer") CustomerVO customerVO, HttpSession session,
			HttpServletRequest request, Model model)
			throws DatabaseException, DuplicateEntryException, NoDataFoundException {
		logger.debug("Add customer post method called");
		
		SessionCache sessionCache = (SessionCache) session.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session.getServletContext()
				.getAttribute(ApplicationConstant.APPLICATION_CACHE);
		ModelAndView mav = new ModelAndView(".pos.customer", "customer", new CustomerVO());
		if (customerVO != null && customerVO.getCustomerName() != null && customerVO.getCustomerName() != "") {
			customerService.addCustomer( customerVO, sessionCache, applicationCache);
			logger.debug("Customer Added Successfully");
			mav.getModelMap().addAttribute("success", ErrorCodeConstant.ADD_SUCCESS_MESS);
		}else{
			logger.debug("Customer Not Added");
		}
		
		return mav;

	}
}
