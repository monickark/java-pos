package com.pos.settings.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.ErrorCodeConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.settings.service.ISettingsService;

@Controller
public class SettingsController {

	Logger logger = Logger.getLogger(SettingsController.class.getName());

	@Autowired
	ISettingsService settingService;

	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public ModelAndView settingGet(
			@ModelAttribute("settings") SettingsVO settingVO)
			throws NoDataFoundException {
		settingVO = settingService.getCompanyDetails();
		ModelAndView mav = new ModelAndView(".pos.settings", "settings",
				settingVO);

		return mav;
	}

	@RequestMapping(value = "/settings", method = RequestMethod.POST)
	public String settingPost(@ModelAttribute("settings") SettingsVO settingVO,
			HttpSession session, HttpServletRequest request,
			RedirectAttributes redirectAttributes) throws DatabaseException,
			DuplicateEntryException, UpdateFailedException,
			NoDataFoundException {

		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);
		// settingService.addSettings(settingVO,sessionCache,applicationCache);

		settingService
				.updateSettings(settingVO, sessionCache, applicationCache);

		// settingVO=null;
		redirectAttributes.addFlashAttribute("success",
				ErrorCodeConstant.ADD_SUCCESS_MESS);
		return "redirect:/settings.htm";

	}

}
