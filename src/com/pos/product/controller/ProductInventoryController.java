package com.pos.product.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pos.common.business.CommonBusiness;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.product.service.IProductInventoryService;

@Controller
public class ProductInventoryController {
	final Logger logger = Logger.getLogger(ProductInventoryController.class.getName());
	@Autowired
	private IProductInventoryService productInventoryService;
	@Autowired
	private CommonBusiness commonBussiness;
	
	@RequestMapping(value="/productInventoryList", method=RequestMethod.GET)
	public String productInventoryListGet(@ModelAttribute ("productInventoryList") ProductInventoryVO productInventoryVO,
			HttpSession session) throws NoDataFoundException {
		List<ProductInventoryVO> productInventoryVOs = productInventoryService.selectProductInventoryList(productInventoryVO);
		session.setAttribute("productInventoryList", productInventoryVOs);
				return ".pos.productInventoryList";
		
	}
	@RequestMapping(value="/productInventoryList",method=RequestMethod.GET, params= {"inventoryView"})
	public String productInventoryViewGet (@ModelAttribute("productInventoryList")ProductInventoryVO productInventoryVO,
			HttpSession session,HttpServletRequest httpServletRequest, Model model ) throws NoDataFoundException{
		String productId = httpServletRequest.getParameter("productId");
		String inventoryDate = httpServletRequest.getParameter("inventoryDate");
		List<ProductInventoryVO> productInventoryVOs = productInventoryService.viewProductInventory(productId,inventoryDate);
		System.out.println("Detail "+productInventoryVOs);
		session.setAttribute("productInventoryView", productInventoryVOs);
		
				return ".pos.viewInventory";
		
	}
	
}
