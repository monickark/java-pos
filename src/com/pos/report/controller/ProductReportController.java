package com.pos.report.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.report.service.IProductReportService;
@Controller
public class ProductReportController {

Logger logger = Logger.getLogger(ProductReportController.class.getName());
	
	@Autowired
	IProductReportService productReportService;
	@Autowired
	private CommonBusiness commonBussiness;
	
	
	@RequestMapping(value = "/productReport", method = RequestMethod.GET)
	public String productReport(@ModelAttribute("productReport") ProductReportListVO productReportVO,
			HttpSession session) throws NoDataFoundException {
		List<ProductReportListVO> productReportVOs = productReportService.selectProductReport(productReportVO);
		session.setAttribute("productReport", productReportVOs);

		return ".pos.productReport";

	}
	
	@RequestMapping(value = "/productReport", method = RequestMethod.GET,params={"form"})
	public void addRefund(@ModelAttribute("productReport") ProductReportListVO productReportVO,ProductReportVO productVO,HttpServletRequest request, HttpSession session)
			throws DatabaseException, DuplicateEntryException, NoDataFoundException{
		
		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);
		
		String productId = request.getParameter("productId");
		productReportVO.setProductId(productId);
		
		String refundAmount = request.getParameter("refundAmount");
		System.out.println("Refund : " +refundAmount);
		
		String refundReason = request.getParameter("refundReason");
		
		System.out.println("Refund Amount: " + productVO.getRefundAmount());
		System.out.println("Refund Reason: " + productVO.getRefundReason());
		List<ProductReportListVO> productReportVOs;
		productReportVOs = (List<ProductReportListVO>) WebUtils.getSessionAttribute(request, "productReport");
		System.out.println("Invoice No: "+productReportVOs);
		ProductReportListVO returnobj = null;
		
		for (ProductReportListVO productReportVO1 : productReportVOs) {
			//if (productReportVO1.getProductId().equals(productId)) {
				//System.out.println("Inside if:" + productReportVO.getProductId());
					
				
			productReportVO1.setRefundAmount(refundAmount);
			productReportVO1.setRefundReason(refundReason);
			//returnobj = productReportVO1;		
			//break;
			
			//}
		}
		
		System.out.println("Return Objetc :" + returnobj);
		productReportService.refund(returnobj, sessionCache, applicationCache);
		
		
		
		
		WebUtils.setSessionAttribute(request, "productReport", productReportVOs);
		
		
		
	}
}
