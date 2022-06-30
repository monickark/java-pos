package com.pos.accessories.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pos.accessories.dao.AddAccessories;
import com.pos.accessories.service.IAccessoriesListService;
import com.pos.accessories.service.IAddAccessoriesInventoryService;
import com.pos.accessories.service.IAddAccessoriesService;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.ErrorCodeConstant;
import com.pos.common.dropdown.service.IBrandListService;
import com.pos.common.dropdown.service.ICategoryService;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;

@Controller
public class AddAccessoriesController {

	Logger logger = Logger.getLogger(AddAccessories.class.getName());
	@Autowired
	IAddAccessoriesService addAccessoriesService;
	@Autowired
	IAddAccessoriesInventoryService addAccessoriesInventoryService;
	@Autowired
	private IAccessoriesListService accessoriesListService;
	@Autowired
	IBrandListService brandListService;
	@Autowired
	ICategoryService categoryService;

	@RequestMapping(value = "/accessoriesList", method = RequestMethod.POST)
	public String addAccessoriesPost(
			@ModelAttribute("accessoriesList") AddAccessoriesVO addAccessoriesVO,
			HttpSession session, HttpServletRequest request)
			throws DatabaseException {

		logger.debug("Add product post method called");
		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);
		String category = request.getParameter("category");
		addAccessoriesVO.setCategory(category);
		System.out.println("Category Name:" + category);

		String brand = request.getParameter("brand");
		addAccessoriesVO.setBrand(brand);
		System.out.println("Brand Name:" + brand);

		String name = request.getParameter("name");
		addAccessoriesVO.setName(name);
		System.out.println("name:" + name);

		AddAccessoriesVO addAccessoriesVO1 = null;
		try {
			addAccessoriesVO1 = addAccessoriesService
					.addAccessories(addAccessoriesVO, sessionCache,
							applicationCache);
		} catch (DuplicateEntryException e) {
			System.out.println("accessory alread inserted");
		}

		addAccessoriesVO.setAccessoriesId(addAccessoriesVO1.getAccessoriesId());
		System.out.println("Accesories Id:" + addAccessoriesVO1);

		String quantity = request.getParameter("quantity");
		addAccessoriesVO.setQuantity(quantity);
		System.out.println("Quantity:" + quantity);

		String costPrice = request.getParameter("costPrice");
		addAccessoriesVO.setCostPrice(costPrice);
		System.out.println("Cost Price:" + costPrice);

		String sellingPrice = request.getParameter("sellingPrice");
		addAccessoriesVO.setSellingPrice(sellingPrice);
		System.out.println("Selling Price:" + sellingPrice);

		String shortDescription = request.getParameter("shortDescription");
		addAccessoriesVO.setShortDescription(shortDescription);
		System.out.println("Short Description:" + shortDescription);

		try {
			addAccessoriesInventoryService.addAccessoriesInventory(
					addAccessoriesVO, sessionCache, applicationCache);
		} catch (DuplicateEntryException e) {
			System.out.println("accessory inventory alread inserted");
		}

		addAccessoriesVO = null;
		ModelAndView mav = new ModelAndView(".pos.accessoriesList", "success",
				ErrorCodeConstant.ADD_SUCCESS_MESS);
		return "redirect:accessoriesList.htm" ;
	}

	// Ajax For getting Sub List
	@RequestMapping(value = "/accessoriesList", method = RequestMethod.GET, params = { "brand" })
	public @ResponseBody Map<String, String> retriveList(HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		logger.debug("Calling get brand method");
		Map<String, String> map = null;
		try {
			map = brandListService.getBrandList();
		} catch (Exception e) {
			logger.error("No Brands selected");
			response.setStatus(420);
		}
		return map;
	}

	@ModelAttribute("brandList")
	public Map<String, String> getStudentGroupList(HttpSession session,
			HttpServletRequest httpSevletRequest, HttpServletResponse response,
			ModelMap model) throws IOException, NoDataFoundException {
		Map<String, String> map = brandListService.getBrandList();
		httpSevletRequest.setAttribute("brandList", map);
		return map;

	}

	@RequestMapping(value = "/accessoriesList", method = RequestMethod.GET)
	public String accessoriesListGet(
			@ModelAttribute("accessoriesList") AddAccessoriesVO addAccessoriesVO,
			HttpSession session) throws NoDataFoundException,
			DuplicateEntryException {
		System.out.println("Accessories List controller:" + addAccessoriesVO);
		List<AddAccessoriesVO> addAccessoriesVOs = accessoriesListService
				.selectAccessoriesList(addAccessoriesVO);
		session.setAttribute("accessoriesList", addAccessoriesVOs);

		return ".pos.accessoriesList";

	}

	@ModelAttribute("category")
	public Map<String, String> getCategory(HttpSession session,
			HttpServletRequest httpSevletRequest, HttpServletResponse response,
			ModelMap model) throws IOException, NoDataFoundException {
		Map<String, String> map = categoryService.getCategory();
		httpSevletRequest.setAttribute("category", map);
		return map;

	}

}
