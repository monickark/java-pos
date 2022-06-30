package com.pos.accessories.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pos.accessories.service.IAddCategoryService;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.ErrorCodeConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
@Controller
public class AddCategoryController {

	@Autowired
	IAddCategoryService addCategoryService;
	Logger logger = Logger.getLogger(AddCategoryController.class);
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public ModelAndView productMasterGet(
			@ModelAttribute("category") AddCategoryVO categoryVO) {

		logger.debug("Opening Category Page");
		ModelAndView mav = new ModelAndView(".pos.category");
		return mav;
	}
	
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public ModelAndView addProductPost(
			@ModelAttribute("category") AddCategoryVO addCategoryVO,
			HttpSession session, HttpServletRequest request)
			throws DatabaseException, DuplicateEntryException {

		logger.debug("Add product post method called");
		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);

		String categoryId = request.getParameter("categoryId");
		String categoryName = request.getParameter("categoryName");
		

		addCategoryVO.setCategoryId(categoryId);
		addCategoryVO.setCategoryName(categoryName);;
		
		addCategoryService.addCategory(addCategoryVO, sessionCache,
				applicationCache);
		logger.debug("Product Added Successfully");

		ModelAndView mav = new ModelAndView(".pos.category",
				"category", new AddCategoryVO());
		mav.getModelMap().addAttribute("success",
				ErrorCodeConstant.ADD_SUCCESS_MESS);
		return mav;

	}

}
