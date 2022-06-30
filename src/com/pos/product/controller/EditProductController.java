package com.pos.product.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ErrorCodeConstant;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.product.service.IProductListService;

@Controller
public class EditProductController {

	final Logger logger = Logger.getLogger(EditProductController.class
			.getName());
	@Autowired
	IProductListService viewProductService;
	@Autowired
	private CommonBusiness commonBussiness;

	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public ModelAndView editProductGet(
			@ModelAttribute("editProduct") ProductMasterVO productMasterVO,
			HttpSession session, HttpServletRequest request)
			throws NoDataFoundException, UpdateFailedException {
		String productId = request.getParameter("productId");
		System.out.println("Product Id: "+productId);
		productMasterVO.setProductId(productId);
		productMasterVO = viewProductService.editProductMaster(productMasterVO);
		session.setAttribute("productId", productId);
		ModelAndView mav = new ModelAndView(".pos.productEdit", "editProduct",
				productMasterVO);
		return mav;

	}

	@RequestMapping(value = "/editProduct", method = RequestMethod.POST)
	public ModelAndView editProductPost(
			@ModelAttribute("editProduct") ProductMasterVO productMasterVO,
			HttpSession sess, ModelMap map) throws NoDataFoundException {
		try {

			String productId = (String) sess.getAttribute("productId");
			productMasterVO.setProductId(productId);
			System.out.println("ProductEdit" + productMasterVO);
			viewProductService.updateProduct(productMasterVO);

		} catch (UpdateFailedException e) {
			e.printStackTrace();
			map.addAttribute("message", "Failed");
		}
		ModelAndView mav = new ModelAndView(".pos.productEdit", "editProduct",
				productMasterVO);
		mav.addObject("success", ErrorCodeConstant.UPDATE_SUCCESS_MESS);
		return mav;

	}

}
