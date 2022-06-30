package com.pos.product.controller;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.ErrorCodeConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.product.service.IProductListService;

@Controller
public class ProductListController {
	final Logger logger = Logger.getLogger(ProductListController.class
			.getName());
	@Autowired
	private IProductListService viewProductService;
	@Autowired
	private CommonBusiness commonBussiness;

	@RequestMapping(value = "/productMasterList", method = RequestMethod.GET)
	public String productListGet(
			@ModelAttribute("product_master_list") ProductMasterVO productMasterVO,
			HttpSession session) throws NoDataFoundException {
		List<ProductMasterVO> productMasterVOs = viewProductService
				.selectProductList(productMasterVO);
		session.setAttribute("productMasterList", productMasterVOs);

		return ".pos.productMasterList";

	}

	@RequestMapping(value = "/productMasterList", method = RequestMethod.GET, params = { "productId" })
	public String viewProduct(
			@ModelAttribute("viewProduct") ProductMasterVO productMasterVO,
			HttpSession session, HttpServletRequest request)
			throws NoDataFoundException {
		System.out.println("Views" + productMasterVO);

		String productId = request.getParameter("productId");
		productMasterVO.setProductId(productId);

		System.out.println("View Object" + productMasterVO);

		ProductMasterVO productMasterVO1 = viewProductService
				.viewProduct(productMasterVO);
		session.setAttribute("viewProduct", productMasterVO1);
		System.out.println("product data before jsp" + productMasterVO1);
		return ".pos.productMasterList";
	}

	@RequestMapping(value = "/productMasterList", method = RequestMethod.GET, params = { "id" })
	public @ResponseBody String deleteProduct(
			@ModelAttribute("deleteProduct") ProductMasterVO productMasterVO,
			HttpSession session, HttpServletRequest request, ModelMap map)
			throws NoDataFoundException, UpdateFailedException {
		try {
			String productId = request.getParameter("id");

			productMasterVO.setProductId(productId);
			System.out
					.println("ProductMasterVO :" + productMasterVO.toString());
			map.addAttribute("message", "success");
			viewProductService.deleteProduct(productMasterVO);
		} catch (UpdateFailedException e) {
			e.printStackTrace();
			map.addAttribute("message", "Failed");
		}
		return ".pos.productMasterList";

	}

	@RequestMapping(value = "/productMasterList", method = RequestMethod.GET, params = "productIdView")
	public @ResponseBody ProductMasterVO viewProductFromSession(ModelMap model,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, HttpSession session,
			RedirectAttributes redirectAttribute) {
		String productId = httpServletRequest.getParameter("productIdView");
		System.out.println("Product Id:" + productId);
		List<ProductMasterVO> productMasterVOs = (List<ProductMasterVO>) session
				.getAttribute("productMasterList");
		ProductMasterVO returnObj = null;
		for (ProductMasterVO productMasterVO : productMasterVOs) {
			if (productMasterVO.getProductId().equals(productId)) {
				System.out.println("Inside if:"
						+ productMasterVO.getProductId());
				returnObj = productMasterVO;
				break;
			}
		}
		System.out.println("Return Objetc :" + returnObj);
		return returnObj;

	}

	@RequestMapping(value = "/productMasterInventory", method = RequestMethod.GET)
	public @ResponseBody String addInventoryPost(
			@ModelAttribute("product_inventory") ProductMasterVO productMasterVO,
			HttpSession session, HttpServletRequest httpServletRequest)
			throws DatabaseException {
		System.out.println("INside Add inventory method");
		String productId = httpServletRequest.getParameter("inInvAdd");
		String imei = httpServletRequest.getParameter("imei");
		String cp = httpServletRequest.getParameter("cp");
		String sp = httpServletRequest.getParameter("sp");
		String colour = httpServletRequest.getParameter("colour");
		productMasterVO.setProductId(productId);
		productMasterVO.setColour(colour);
		productMasterVO.setImei(imei);
		productMasterVO.setCostPrice(cp);
		productMasterVO.setSellPrice(sp);

		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);
		System.out.println("Product Inventory :" + productMasterVO);
		session.setAttribute("product_inventory", productMasterVO);
		String returnVal = "success";
		try {
			viewProductService.addInventory(productMasterVO, sessionCache,
					applicationCache);
		} catch (DuplicateEntryException e) {
			returnVal = "fail";
		}
		return returnVal;

	}

}
