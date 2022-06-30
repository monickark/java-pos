package com.pos.admin.controller;

import java.io.IOException;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pos.admin.service.IInstituteMasterService;
import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.ErrorCodeConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DeleteFailedException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.FileNotFoundInDatabase;
import com.pos.common.exceptions.FileNotSaveException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.exceptions.batch.NoRecordFoundException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.common.exceptions.util.TableNotSpecifiedForAuditException;
import com.pos.common.util.ErrorCodeUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;

//Institute Master Controller Class
@Controller
public class InstituteMasterController {

	// Logging
	Logger logger = Logger.getLogger(InstituteMasterController.class);

	@Autowired
	IInstituteMasterService instMasterService;
	@Autowired
	ErrorCodeUtil errorCodeUtil;
	@Autowired
	CommonBusiness commonBusiness;

	// method to view inst-master.jsp-Institute Master Page
	@RequestMapping(value = "/instMaster", method = RequestMethod.GET)
	public ModelAndView viewInstMaster(
			@ModelAttribute("inst") InstituteMasterVO instVO,
			HttpSession session, HttpServletRequest httpServletRequest,
			ModelMap model,
			RedirectAttributes redirect) throws NoRecordFoundException,
			DatabaseException, PropertyNotFoundException {

		logger.info("Opening Institute Master Page");

		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);

		ModelAndView mav = new ModelAndView(".pos.inst-master");
		httpServletRequest.setAttribute("instPojo", instVO);
		instMasterService.selectInstituteMasterRec(
				applicationCache, instVO); 
				
		return mav;
	}

	// method to Update Institute Master
	@RequestMapping(value = "/instMaster", method = RequestMethod.POST)
	public ModelAndView updateInstMaster(
			@ModelAttribute("inst") InstituteMasterVO instVO,
			HttpSession session, HttpServletRequest httpServletRequest,
			RedirectAttributes redirect) throws FileNotFoundInDatabase,
			DuplicateEntryException, NoRecordFoundException, DatabaseException,
			UpdateFailedException, TableNotSpecifiedForAuditException, IllegalStateException, IOException, DeleteFailedException, FileNotSaveException {

		logger.info("inside updateInstMaster");		
		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);
		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		httpServletRequest.setAttribute("instVO", instVO);
		if ((httpServletRequest.getParameter("actionReset") != null)) {
			httpServletRequest.setAttribute("instVO",
					httpServletRequest.getAttribute("instPojo"));
			return new ModelAndView("redirect:instMaster.htm");

		}

		instMasterService.updateInstituteMasterRec(instVO,
				sessionCache.getUserSessionDetails(), applicationCache,session.getServletContext());
		redirect.addFlashAttribute("success",
				ErrorCodeConstant.UPDATE_SUCCESS_MESS);
		logger.info("Record updated successfully!");
		return new ModelAndView("redirect:instMaster.htm");
	}

	@ExceptionHandler({ FileNotFoundInDatabase.class,
			DuplicateEntryException.class, UpdateFailedException.class,
			PropertyNotFoundException.class,
			TableNotSpecifiedForAuditException.class,DeleteFailedException.class,FileNotSaveException.class })
	public ModelAndView handleException(Exception ex, HttpSession session,
			HttpServletRequest request) {

		InstituteMasterVO instVO = (InstituteMasterVO) request
				.getAttribute("instVO");

		ModelAndView mav = new ModelAndView(".pos.inst-master", "inst", instVO);
		mav.getModelMap().addAttribute("error", ex.getMessage());
		return mav;

	}
}
