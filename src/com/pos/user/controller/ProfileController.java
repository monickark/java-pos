package com.pos.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.pos.common.constants.ApplicationConstant;
import com.pos.common.dropdown.service.IDropDownListService;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.FileNotFoundInDatabase;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.login.InvalidUserIdException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.common.files.service.IFileMasterService;
import com.pos.common.util.ProfileGroup;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.student.admission.controller.FileTypeVO;
import com.pos.user.service.IUserManagementService;

//Common Controller class for Viewing a file
@Controller
public class ProfileController {
	
	// Logging
	Logger logger = Logger.getLogger(ProfileController.class);
	@Autowired
	IFileMasterService fileMasterService;
	@Autowired
	IUserManagementService userManagementService;
	@Autowired
	IDropDownListService dropDownListService;

	@RequestMapping(value = "/viewuser")
	public ModelAndView viewUser(HttpSession session,HttpServletRequest httpRequest) throws FileNotFoundInDatabase,
			NoDataFoundException, InvalidUserIdException, PropertyNotFoundException {
		ModelAndView modelAndView = null;
		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);			
		ProfileGroup profileGroup = ProfileGroup.valueOf(sessionCache.getUserSessionDetails()
				.getProfileGroup());
		WebUtils.setSessionAttribute(httpRequest, "success", null);
		FileTypeVO fileType = null;
		BranchAdminVO branchAdminVO = new BranchAdminVO();
		/*nonStaffService.getSingleNonStaff(branchAdminVO,
				sessionCache.getUserSessionDetails());*/
		modelAndView = new ModelAndView(".pos.nonStaffViewProfile",
				"singleUser", branchAdminVO);	
		if (fileType != null) {
			modelAndView.getModelMap().addAttribute("fileType", fileType);
		}
		
		return modelAndView;
	}
	
		
	@ExceptionHandler({
			DuplicateEntryException.class,
			FileNotFoundInDatabase.class
	})
	public ModelAndView handleException(Exception ex, HttpSession session,
			HttpServletRequest request) {
		logger.info("Error in staff Admission or staff profile");
		ModelAndView mav = (ModelAndView) request.getAttribute("page");
		mav.getModelMap().addAttribute("error", ex.getMessage());
		logger.info("Redirecting with error message");
		return mav;
		
	}
	
}
