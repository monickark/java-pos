package com.pos.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.login.InvalidUserIdException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.common.util.ErrorCodeUtil;
import com.pos.common.util.ProfileGroup;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.user.service.ISingleUserDetailsService;

@Controller
public class SingleUserDetailsController {
	Logger logger = Logger.getLogger(SingleUserDetailsController.class);
	@Autowired
	CommonBusiness commonBusiness;
	@Autowired
	ErrorCodeUtil errorCodeUtil;
	@Autowired
	ISingleUserDetailsService singleUserDetailsService;
	String error = "";
	
	@RequestMapping(value = "/userDetails", method = RequestMethod.GET)
	public ModelAndView singleUserDetails(
			HttpServletRequest httpServletRequest, HttpSession session,
			ModelMap map) throws NoDataFoundException, InvalidUserIdException,
			PropertyNotFoundException {
		ApplicationCache applicationCache = (ApplicationCache) session.getServletContext()
				.getAttribute(
						ApplicationConstant
						.APPLICATION_CACHE);
		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.
				SESSION_CACHE_KEY);
		
		String userId = httpServletRequest.getParameter("userId");
		
		BranchAdminVO branchAdminVO = new BranchAdminVO();
		ModelAndView modelAndView = null;
		String profileGroup = new String();
		profileGroup = singleUserDetailsService
				.getSingleUser(applicationCache, userId, sessionCache.getUserSessionDetails(),
						branchAdminVO,profileGroup);
		
		logger.debug("Profile group :" + profileGroup);
		
		ProfileGroup pg = ProfileGroup.valueOf(profileGroup);
		switch (pg) {
			case NSF: {
				System.out.println("branch admin :" + branchAdminVO.getStaffId());
				modelAndView = new ModelAndView(".pos.NonStaffDetails", "singleUser", branchAdminVO);
				break;
			}
			
			default:
				break;
		
		}
		httpServletRequest.setAttribute("page"
				, modelAndView);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/singleUser", method = RequestMethod.POST, params = "Search=Search")
	public ModelAndView userManagementBack(
			@ModelAttribute("userManagement") UserManagementVO userManagement) {
		return new ModelAndView(".pos.userManagement");
		
	}
	
	@ExceptionHandler({
			InvalidUserIdException.class,
			NoDataFoundException.class,
	})
	public ModelAndView handleException(Exception ex, HttpSession session,
			HttpServletRequest request) {
		WebUtils.setSessionAttribute(request, "request", null);
		ModelAndView page = (ModelAndView) request.getAttribute("page");
		logger.debug("Page is :" + page.getViewName());
		String type = "error";
		String message = ex.getMessage();
		page.getModelMap().addAttribute("message", message)
				.addAttribute("type", type);
		return page;
		
	}
}
