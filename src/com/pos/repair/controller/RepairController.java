package com.pos.repair.controller;

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
import com.pos.customer.controller.CustomerController;
import com.pos.customer.controller.CustomerVO;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.repair.service.IRepairService;

@Controller
public class RepairController {

	Logger logger = Logger.getLogger(RepairController.class.getName());
	@Autowired
	IRepairService repairService;
	
	@RequestMapping(value = "/repair", method = RequestMethod.GET)
	public ModelAndView addRepairGet(@ModelAttribute("repair") RepairVO repairVO) {
		logger.debug("Opening repair Page");
		ModelAndView mav = new ModelAndView(".pos.repair","repair", repairVO);
		return mav;
}
	@RequestMapping(value = "repair", method = RequestMethod.POST)
	public ModelAndView addRepairPost(@ModelAttribute("repair") RepairVO repairVO, HttpSession session,
			HttpServletRequest request, Model model)
			throws DatabaseException, DuplicateEntryException, NoDataFoundException {
		logger.debug("Add repair post method called");
		System.out.println("repair VO in Ctrl: "+repairVO);
		
		
		SessionCache sessionCache = (SessionCache) session.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session.getServletContext()
				.getAttribute(ApplicationConstant.APPLICATION_CACHE);
		
		repairService.addRepair( repairVO, sessionCache, applicationCache);
		
		logger.debug("Repair Added Successfully");
		ModelAndView mav = new ModelAndView(".pos.repair", "repair", new RepairVO() );
		mav.getModelMap().addAttribute("success", ErrorCodeConstant.ADD_SUCCESS_MESS);
		return mav;

	}

}
