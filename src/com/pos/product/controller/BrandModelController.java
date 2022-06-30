package com.pos.product.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.ErrorCodeConstant;
import com.pos.common.dropdown.service.IBrandListService;
import com.pos.common.dropdown.service.IBrandModelListService;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;

@Controller
public class BrandModelController {

	@Autowired
	IBrandListService brandListService;

	@Autowired
	IBrandModelListService brandModelListService;

	@RequestMapping(value = "/brandModelSetup", method = RequestMethod.GET)
	public ModelAndView addBrandGet(
			@ModelAttribute("brandmodel") BrandModelVO brandBrandModelVO,
			HttpServletRequest request) throws IOException,
			NoDataFoundException {

		ModelAndView mav = new ModelAndView(".pos.brandmodel", "brandmodel",
				new BrandModelVO());
		getBrandList(request, mav.getModelMap());
		return mav;
	}

	@RequestMapping(value = "/brandModelSetup", method = RequestMethod.POST)
	public ModelAndView addBrandPost(
			@ModelAttribute("brandmodel") BrandModelVO brandVO, Model model,
			HttpSession session, HttpServletRequest request)
			throws DatabaseException, IOException,
			NoDataFoundException {

		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);
		BrandVO brandVo = brandVO.getBrandVO();
		request.setAttribute("brandVO", brandVo);
		System.out.println("BrandVO : " + brandVo.toString());
		ModelAndView mav=new ModelAndView(".pos.brandmodel", "brandmodel",
				new BrandModelVO());;
		try {
			brandListService.addBrand(brandVo, sessionCache, applicationCache);
			
			mav.addObject("success", ErrorCodeConstant.BRAND_ADDED_SUCCESS);
			
		} catch (DuplicateEntryException e) {
			model.addAttribute("error", ErrorCodeConstant.DUPLICATE_ENTRY);
		}
		getBrandList(request, mav.getModelMap());
		return mav;
	}

	@RequestMapping(value = "/brandModelSetup", method = RequestMethod.POST, params = { "model_action" })
	public ModelAndView addBrandModelPost(
			@ModelAttribute("brandmodel") BrandModelVO brandModelVO, Model model,
			HttpSession session, HttpServletRequest request)
			throws DatabaseException, IOException,
			NoDataFoundException {

		System.out.println("Brand Model VO :" + brandModelVO);

		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);
		ModelVO modelVO = brandModelVO.getModelVO();
		request.setAttribute("modelVO", modelVO);
		System.out.println("modelVO : " + modelVO.toString());
		ModelAndView mav = new ModelAndView(".pos.brandmodel", "brandmodel",
				new BrandModelVO());
		try {
			brandModelListService.addBrandModel(modelVO, sessionCache,
					applicationCache);
			session.setAttribute("addBrandModel", brandModelVO);
			
			mav.addObject("success", ErrorCodeConstant.MODEL_ADDED_SUCCESS);
		} catch (DuplicateEntryException e) {
			model.addAttribute("error", ErrorCodeConstant.DUPLICATE_ENTRY);
		}
		
		getBrandList(request, mav.getModelMap());
		return mav;
	}

	public void getBrandList(HttpServletRequest httpServletRequest,
			ModelMap model) throws IOException, NoDataFoundException {
		Map<String, String> map = brandListService.getBrandList();
		httpServletRequest.setAttribute("brandList", map);

	}
	
	/*@ExceptionHandler({ DuplicateEntryException.class })
	public ModelAndView handleException(Exception ex, HttpServletRequest request) {

		BrandVO brandVO = (BrandVO) request.getAttribute("brandVO");
		ModelVO modelVO = (ModelVO) request.getAttribute("modelVO");
		BrandModelVO brandModelVO = new BrandModelVO();
		brandModelVO.setBrandVO(brandVO);
		brandModelVO.setModelVO(modelVO);
		
		ModelAndView mav = new ModelAndView(".pos.brandmodel","brandmodel",
				brandModelVO);
		mav.getModelMap().addAttribute("error", ex.getMessage());
		return mav;

	}*/

}
