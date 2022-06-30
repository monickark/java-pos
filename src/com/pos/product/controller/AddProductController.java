/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package com.pos.product.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.pos.product.service.IProductService;

// End of user code

/**
 * Description of ProductMasterController.
 * 
 * @author Ebidrive
 */
@Controller
public class AddProductController {
	@Autowired
	IProductService productService;
	@Autowired
	IBrandListService brandListService;
	@Autowired
	IBrandModelListService iBrandModelListService;
	@Autowired
	IBrandModelListService brandModelListService;
	Logger logger = Logger.getLogger(AddProductController.class);

	/**
	 * Description of the method productMasterGet.
	 * 
	 * @param productMasterVO
	 */
	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public ModelAndView productMasterGet(
			@ModelAttribute("product_master") ProductMasterVO productMasterVO) {

		logger.debug("Opening Product Master Page");
		ModelAndView mav = new ModelAndView(".pos.productMaster");
		return mav;
	}

	/**
	 * Description of the method addProductPost.
	 * 
	 * @param productMasterVO
	 * @throws DatabaseException
	 * @throws DuplicateEntryException
	 */
	// To add the product
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public ModelAndView addProductPost(
			@ModelAttribute("product_master") ProductMasterVO productMasterVO,
			HttpSession session, HttpServletRequest request)
			throws DatabaseException, DuplicateEntryException {

		logger.debug("Add product post method called");
		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);

		String simtype = request.getParameter("simType");
		String os = request.getParameter("os");
		String category = request.getParameter("category");

		productMasterVO.setSimType(simtype);
		productMasterVO.setOs(os);
		productMasterVO.setCategory(category);

		ModelAndView mav = new ModelAndView(".pos.productMaster",
				"product_master", new ProductMasterVO());

		try {
			productService.addProduct(productMasterVO, sessionCache,
					applicationCache);
			mav.getModelMap().addAttribute("success",
					ErrorCodeConstant.ADD_SUCCESS_MESS);
			logger.debug("Product Added Successfully");
		} catch (DuplicateEntryException e) {
			mav.getModelMap().addAttribute("error",
					ErrorCodeConstant.DUPLICATE_ENTRY);
			logger.debug("Data already exist");
		}
		
		return mav;

	}

	@RequestMapping(value = "/addproduct", method = RequestMethod.GET, params = { "addBrand" })
	public ModelAndView addBrandGet(
			@ModelAttribute("addBrand") BrandVO brandListVO,
			HttpSession session, HttpServletRequest request)
			throws DatabaseException, DuplicateEntryException {
		System.out.println("Inside add brand method");
		String brandIdName = request.getParameter("brand-name");
		brandListVO.setBrandName(brandIdName);
		System.out.println("Brand Name: " + brandIdName);
		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);

		brandListService.addBrand(brandListVO, sessionCache, applicationCache);
		session.setAttribute("addBrand", brandListVO);
		
		

		ModelAndView mav = new ModelAndView(".pos.addproduct", "success",
				ErrorCodeConstant.ADD_SUCCESS_MESS);
		return mav;
	}

	@RequestMapping(value = "/addproduct", method = RequestMethod.GET, params = { "addModel" })
	public void addBrandModelGet(
			@ModelAttribute("addBrandModel") ModelVO brandModelListVO,
			HttpSession session, HttpServletRequest request)
			throws DatabaseException, DuplicateEntryException {

		brandModelListVO.setModelId("BRM016");
		brandModelListVO.setBrandId("BR001");
		brandModelListVO.setModelValue("iPhone 5s");

		System.out.println("Brand Model :" + brandModelListVO);

		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);

		brandModelListService.addBrandModel(brandModelListVO, sessionCache,
				applicationCache);
		session.setAttribute("addBrandModel", brandModelListVO);

		brandModelListVO = null;
		ModelAndView mav = new ModelAndView(".pos.addproduct", "success",
				ErrorCodeConstant.ADD_SUCCESS_MESS);

	}

	@ModelAttribute("brandList")
	public Map<String, String> getBrandList(HttpSession session,
			HttpServletRequest httpSevletRequest, HttpServletResponse response,
			ModelMap model) throws IOException, NoDataFoundException {
		Map<String, String> map = brandListService.getBrandList();
		httpSevletRequest.setAttribute("brandList", map);
		return map;

	}

	// Ajax Display Model
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST, params = "modelList")
		public @ResponseBody Map<String, String> getName(
				HttpServletRequest request, HttpServletResponse response,
				ModelMap modelMap, HttpSession session) throws NoDataFoundException {
			System.out.println("Inside Model select ajax");
			String brand = (String) request.getParameter("brand");
			System.out.println("Brand name: "+brand);
			Map<String, String> model = brandModelListService.getBrandModelList(brand);
			System.out.println("Return obj: "+model);
			return model;
		}


	@ExceptionHandler({ DuplicateEntryException.class })
	public ModelAndView handleException(Exception ex, HttpServletRequest request) {

		ProductMasterVO productMasterVO = (ProductMasterVO) request
				.getAttribute("productMasterVO");
		ModelAndView mav = new ModelAndView(".pos.productMaster",
				"productMaster", productMasterVO);
		mav.getModelMap().addAttribute("error", ex.getMessage());
		return mav;

	}

}
