package com.pos.sale.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.pos.accessories.controller.AddAccessoriesVO;
import com.pos.accessories.dao.AddAccessoriesInventory;
import com.pos.accessories.service.IAddAccessoriesInventoryService;
import com.pos.accessories.service.IAddAccessoriesService;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.ErrorCodeConstant;
import com.pos.common.dropdown.service.IBrandListService;
import com.pos.common.dropdown.service.ICategoryService;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.customer.controller.CustomerVO;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.product.controller.ProductInventoryVO;
import com.pos.sale.service.ISaleInfoService;
import com.pos.sale.service.ISaleService;
import com.pos.sale.service.ITradeinService;
import com.pos.till.controller.TillVO;
import com.pos.till.service.ITillService;

@Controller
public class SaleController {

	Logger logger = Logger.getLogger(SaleController.class.getName());
	@Autowired
	ITillService tillService;
	@Autowired
	ISaleService saleService;
	@Autowired
	ISaleInfoService saleInfoService;
	@Autowired
	ICategoryService categoryService;
	@Autowired
	IBrandListService brandListService;
	@Autowired
	IAddAccessoriesService addAccessoriesService;
	@Autowired
	IAddAccessoriesInventoryService addAccessoriesInventoryService;
	@Autowired
	ITradeinService tradeinService;

	@RequestMapping(value = "/possale", method = RequestMethod.GET)
	public ModelAndView saleGet(@ModelAttribute("possale") PosVO posVO,
			HttpServletRequest request, HttpSession session) {
		TillVO newObj=null;
		try {
			newObj = tillService.selectTillObj();
		} catch (NoDataFoundException e) {
			logger.info("No Record Found");
		}
		System.out.println("newobj :" + newObj);
		ModelAndView mav = null;
		if (newObj != null && newObj.getAmount() != null) {
			session.setAttribute("customerVO", null);
			mav = new ModelAndView(".pos.possale", "possale", posVO);
		} else {
			mav = new ModelAndView(".pos.till", "till", new TillVO());
			mav.getModelMap().addAttribute("success1",
					ErrorCodeConstant.COUNTER_NOT_OPENED);
		}

		WebUtils.setSessionAttribute(request, "pos_list", null);
		return mav;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/possale", method = RequestMethod.POST, params = { "imeino" })
	public ModelAndView sale(@ModelAttribute("possale") PosVO posVO,
			Model model, HttpServletRequest httpServletRequest,
			HttpSession session) throws DatabaseException,
			DuplicateEntryException, NoDataFoundException {
		
		String[] disc = httpServletRequest.getParameterValues("discount");
		System.out.println("Discount :"+ disc);
		if(disc !=null && disc.length!=0) {
			for(String s :disc) {
				System.out.println("S : "+s);
			}
		}
		
		String imei = httpServletRequest.getParameter("imei");
		posVO.setImei(imei);

		Integer totalAmount = 0;
		Integer netAmount = 0;
		Integer tax = 0;
		Integer amountPayable = 0;
		List<PosVO> posVOs;
		posVOs = (List<PosVO>) WebUtils.getSessionAttribute(
				httpServletRequest, "pos_list");
		boolean success = false;
		try {
			posVO = saleService.sale(posVO);
			posVO.setQuantity("1");
			posVO.setCategory("PRODUCT");
			System.out.println("IMEI Number" + posVO);			
				
			String add = "true";
			
			if (posVOs == null || posVOs.size() == 0) {
				System.out.println("Data list null");
				posVOs = new ArrayList<PosVO>();
			} else{
				for (PosVO posVO1 : posVOs) {
					System.out.println(" list name: " + posVO1.getProductName());
					System.out.println(" list name: " + posVO.getProductName());
					if(posVO1.getCategory().equals("PRODUCT") && posVO.getCategory().equals("PRODUCT"))
					if (posVO1.equals(posVO)) {
						add = "false";
						break;
					}
				}
			}

			
			System.out.println("Add :" + add);

			if (add.equals("true")) {
				posVO.setQuantity("1");
				posVOs.add(posVO);
			}

			System.out.println("Data list size " + posVOs.size());	
			success = true;

		} catch (NoDataFoundException e) {
			model.addAttribute("imeierror", ErrorCodeConstant.IMEI_NOT_FOUND);
		} finally {
			Integer quantity;
			Integer price;
			Integer discount;
			Integer amount;
			System.out.println("suceess"+posVOs);

			if(posVOs != null && posVOs.size() != 0){
			for (int i=0; i<posVOs.size(); i++) {
				PosVO posVO1 = posVOs.get(i);
				if((success)&&(i==posVOs.size()-1)) {
					posVO1.setDiscount("0");
				} else {
					if(disc !=null && disc.length!=0) {
						System.out.println("disc on i "+disc[i]);
						posVO1.setDiscount(disc[i]);
					}
				}
				System.out.println("pos vo after vo: "+posVO1);
				quantity = Integer.parseInt(posVO1.getQuantity());
				price = Integer.parseInt(posVO1.getPrice());
				discount= Integer.parseInt(posVO1.getDiscount());
				amount=(quantity*price)-discount;
				posVO1.setAmount(amount.toString());
				
				if (posVO1.getAmount() != null) {
					System.out.println("inside for:" + posVO1.getAmount());
					totalAmount += Integer.valueOf(posVO1.getAmount())
							.intValue();
					netAmount = totalAmount;					
				}
				
				
			}

			System.out.println("totalAmount" + totalAmount);
			netAmount = (int) (totalAmount * 0.90909);
			System.out.println("netAmount" + netAmount);
			tax = totalAmount - netAmount;
			System.out.println("tax" + tax);
			amountPayable = totalAmount;
			System.out.println("amountPayable" + amountPayable);

			SalesVO salesVO = new SalesVO();
			salesVO.setAmount(totalAmount.toString());
			salesVO.setTax(tax.toString());
			salesVO.setNetAmount(netAmount.toString());
			salesVO.setAmountPayable(amountPayable.toString());

			WebUtils.setSessionAttribute(httpServletRequest, "pos_list", posVOs);
			WebUtils.setSessionAttribute(httpServletRequest, "salesVO", salesVO);
			
			}
		}

		ModelAndView mav = new ModelAndView(".pos.possale", "possale", posVO);
		mav.getModelMap().addAttribute("totalAmount", totalAmount);
		mav.getModelMap().addAttribute("netAmount", netAmount);
		mav.getModelMap().addAttribute("tax", tax);
		mav.getModelMap().addAttribute("amountPayable", amountPayable);

		return mav;

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/possale", method = RequestMethod.POST, params = "action")
	public ModelAndView otherBrand(@ModelAttribute("possale") PosVO posVO,
			Model model, HttpServletRequest httpServletRequest,
			HttpSession session) throws DatabaseException,
			DuplicateEntryException, NoDataFoundException {
		
		String[] disc = httpServletRequest.getParameterValues("discount");
		System.out.println("Discount :"+ disc);
		if(disc !=null && disc.length!=0 && ArrayUtils.isEmpty(disc)) {
			for(String s :disc) {
				System.out.println("S : "+s);
			}
		}		
		
		System.out.println("Other brand detail: " + posVO.getOtherBrand());
		ProductInventoryVO other = posVO.getOtherBrand();
		Double totalAmount = 0.00;
		Double netAmount = 0.00;
		Double tax = 0.00;
		Double amountPayable = 0.00;

		System.out.println("Customer Vo Obj: " + posVO.getCustomer());

		posVO.setAmount(other.getSellPrice());
		posVO.setProductName(other.getProductId());
		posVO.setQuantity(other.getQuantity());
		posVO.setPrice(other.getCostPrice());
		posVO.setDiscount("0");
		posVO.setCategory("OTHERBRAND");
		System.out.println("Other brand" + posVO);

		List<PosVO> posVOs;
		posVOs = (List<PosVO>) WebUtils.getSessionAttribute(httpServletRequest,
				"pos_list");

		Integer quantity;
		Integer price;
		Integer discount;
		Integer amount;
		if (posVOs == null || posVOs.size() == 0) {
			System.out.println("Data list null");
			posVOs = new ArrayList<PosVO>();
		} else {
			System.out.println("Data list not null");
			for(int i=0; i<posVOs.size(); i++) {
				System.out.println("i "+i);
				PosVO vo = posVOs.get(i);
				if(disc!=null && disc.length!=0 && ArrayUtils.isEmpty(disc)){
					System.out.println("disc on i "+disc[i]);
					vo.setDiscount(disc[i]);
				}
				System.out.println("pos vo after vo: "+vo);
				quantity = Integer.parseInt(vo.getQuantity());
				price = Integer.parseInt(vo.getPrice());
				discount= Integer.parseInt(vo.getDiscount());
				amount=(quantity*price)-discount;
				vo.setAmount(amount.toString());
				
			}
		}

		posVOs.add(posVO);
		System.out.println("Data list size " + posVOs.size());
		System.out.println("Data list " + posVOs);
		for (PosVO posVO1 : posVOs) {
			if (posVO1.getAmount() != null) {
				System.out.println("inside for:" + posVO1.getAmount());
				totalAmount += Double.parseDouble(posVO1.getAmount());
				netAmount = totalAmount;
			}
		}

		System.out.println("totalAmount" + totalAmount);
		totalAmount =round(totalAmount, 2);
		netAmount = (double) (totalAmount * 0.90909);
		netAmount =round(netAmount, 2);
		System.out.println("netAmount" + netAmount);
		tax = totalAmount - netAmount;
		tax =round(tax, 2);
		System.out.println("tax" + tax);
		amountPayable = totalAmount;
		amountPayable =round(amountPayable, 2);
		System.out.println("amountPayable" + amountPayable);

		SalesVO salesVO = new SalesVO();
		salesVO.setAmount(totalAmount.toString());
		salesVO.setTax(tax.toString());
		salesVO.setNetAmount(netAmount.toString());
		salesVO.setAmountPayable(amountPayable.toString());

		WebUtils.setSessionAttribute(httpServletRequest, "pos_list", posVOs);
		WebUtils.setSessionAttribute(httpServletRequest, "salesVO", salesVO);

		System.out.println("Before page :" + posVO.getCustomer());
		ModelAndView mav = new ModelAndView(".pos.possale", "possale", posVO);
		mav.getModelMap().addAttribute("totalAmount", totalAmount);
		mav.getModelMap().addAttribute("netAmount", netAmount);
		mav.getModelMap().addAttribute("tax", tax);
		mav.getModelMap().addAttribute("amountPayable", amountPayable);

		return mav;

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/possale", method = RequestMethod.POST, params = "addaccessory")
	public ModelAndView addaccessory(@ModelAttribute("possale") PosVO posVO,
			Model model, HttpServletRequest httpServletRequest,
			HttpSession session) throws DatabaseException,
			DuplicateEntryException, NoDataFoundException {
		
		String[] disc = httpServletRequest.getParameterValues("discount");
		System.out.println("Discount :"+ disc);
		if(disc !=null && disc.length!=0) {
			for(String s :disc) {
				System.out.println("S : "+s);
			}
		}
		
		System.out.println("Other brand detail: " + posVO.getAccessories());
		AddAccessoriesVO accessory = posVO.getAccessories();
		Double totalAmount = 0.00;
		Double netAmount = 0.00;
		Double tax = 0.00;
		Double amountPayable = 0.00;

		System.out.println("Customer Vo Obj: " + posVO.getCustomer());
		Integer amountAcces = Integer.parseInt(accessory.getSellingPrice())*Integer.parseInt(accessory.getQuantity());
		posVO.setAmount(amountAcces.toString());
		posVO.setProductName(accessory.getName());
		posVO.setProductId(accessory.getAccessoriesId());
		posVO.setQuantity(accessory.getQuantity());
		posVO.setPrice(accessory.getSellingPrice());
		posVO.setDiscount("0");
		posVO.setCategory("ACCESSORY");
		System.out.println("Accessory" + posVO);

		List<PosVO> posVOs;
		posVOs = (List<PosVO>) WebUtils.getSessionAttribute(httpServletRequest,
				"pos_list");

		Integer quantity;
		Integer price;
		Integer discount;
		Integer amount;
		if (posVOs == null || posVOs.size() == 0) {
			System.out.println("Data list null");
			posVOs = new ArrayList<PosVO>();
		} else {
			System.out.println("Data list not null");
			for(int i=0; i<posVOs.size(); i++) {
				System.out.println("i "+i);
				PosVO vo = posVOs.get(i);
				if(disc!=null && disc.length!=0 && ArrayUtils.isEmpty(disc)){
					System.out.println("disc on i "+disc[i]);
					vo.setDiscount(disc[i]);
				}
				System.out.println("pos vo after vo: "+vo);
				quantity = Integer.parseInt(vo.getQuantity());
				price = Integer.parseInt(vo.getPrice());
				discount= Integer.parseInt(vo.getDiscount());
				amount=(quantity*price)-discount;
				vo.setAmount(amount.toString());
				
			}
		}

		posVOs.add(posVO);
		System.out.println("Data list size " + posVOs.size());
		System.out.println("Data list " + posVOs);
		for (PosVO posVO1 : posVOs) {
			if (posVO1.getAmount() != null) {
				System.out.println("inside for:" + posVO1.getAmount());
				totalAmount += Double.parseDouble(posVO1.getAmount());
				netAmount = totalAmount;
			}
		}

		System.out.println("totalAmount" + totalAmount);
		totalAmount =round(totalAmount, 2);
		netAmount = (double) (totalAmount * 0.90909);
		netAmount =round(netAmount, 2);
		System.out.println("netAmount" + netAmount);
		tax = totalAmount - netAmount;
		tax =round(tax, 2);
		System.out.println("tax" + tax);
		amountPayable = totalAmount;
		amountPayable =round(amountPayable, 2);
		System.out.println("amountPayable" + amountPayable);

		SalesVO salesVO = new SalesVO();
		salesVO.setAmount(totalAmount.toString());
		salesVO.setTax(tax.toString());
		salesVO.setNetAmount(netAmount.toString());
		salesVO.setAmountPayable(amountPayable.toString());

		WebUtils.setSessionAttribute(httpServletRequest, "pos_list", posVOs);
		WebUtils.setSessionAttribute(httpServletRequest, "salesVO", salesVO);

		System.out.println("Before page :" + posVO.getCustomer());
		ModelAndView mav = new ModelAndView(".pos.possale", "possale", posVO);
		mav.getModelMap().addAttribute("totalAmount", totalAmount);
		mav.getModelMap().addAttribute("netAmount", netAmount);
		mav.getModelMap().addAttribute("tax", tax);
		mav.getModelMap().addAttribute("amountPayable", amountPayable);

		return mav;

	}
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/possale", method = RequestMethod.POST, params = { "addtradein" })
	public ModelAndView addTradeIn(@ModelAttribute("possale") PosVO posVO,
			Model model, HttpServletRequest httpServletRequest,
			HttpSession session) throws DatabaseException,
			DuplicateEntryException, NoDataFoundException {
		
		String[] disc = httpServletRequest.getParameterValues("discount");
		System.out.println("Discount :"+ disc);
		if(disc !=null && disc.length!=0) {
			for(String s :disc) {
				System.out.println("S : "+s);
			}
		}
		TradeinVO tradein = posVO.getTradein();
		TradeinVO tradeinVO =new TradeinVO();
		tradeinVO.setImei(tradein.getImei());

		Integer totalAmount = 0;
		Integer netAmount = 0;
		Integer tax = 0;
		Integer amountPayable = 0;
		List<PosVO> posVOs;
		posVOs = (List<PosVO>) WebUtils.getSessionAttribute(
				httpServletRequest, "pos_list");
		boolean success = false;
		
		try {
			System.out.println("Tradein IMEI Number" + tradeinVO.getImei());
			tradeinVO = tradeinService.selectTradein(tradeinVO);
			
			posVO.setAmount(tradeinVO.getResaleValue());
			posVO.setProductName(tradeinVO.getImei());
			posVO.setProductId(tradeinVO.getImei());
			posVO.setImei(tradeinVO.getImei());
			posVO.setQuantity("1");
			posVO.setPrice(tradeinVO.getResaleValue());
			posVO.setDiscount("0");				
			posVO.setCategory("TRADEIN");
			System.out.println("Tradein IMEI Number" + posVO);			
				
			String add = "true";
			
			if (posVOs == null || posVOs.size() == 0) {
				System.out.println("Data list null");
				posVOs = new ArrayList<PosVO>();
			} else{
				for (PosVO posVO1 : posVOs) {
					System.out.println(" list name: " + posVO1.getProductName());
					System.out.println(" list name: " + posVO.getProductName());
					if(posVO1.getCategory().equals("TRADEIN") && posVO.getCategory().equals("TRADEIN"))
					if (posVO1.equals(posVO)) {
						add = "false";
						break;
					}
				}
			}

			
			System.out.println("Add :" + add);

			if (add.equals("true")) {
				posVO.setQuantity("1");
				posVOs.add(posVO);
			}

			System.out.println("Data list size " + posVOs.size());	
			success = true;

		} catch (NoDataFoundException e) {
			model.addAttribute("tradeinimeierror", ErrorCodeConstant.IMEI_NOT_FOUND);
		} finally {
			Integer quantity;
			Integer price;
			Integer discount;
			Integer amount;
			if(posVOs != null && posVOs.size() != 0){
			for (int i=0; i<posVOs.size(); i++) {
				PosVO posVO1 = posVOs.get(i);

				if((success)&&(i==posVOs.size()-1)) {
					posVO1.setDiscount("0");
				} else {
					if(disc!=null && disc.length!=0 && ArrayUtils.isEmpty(disc)){
						System.out.println("disc on i "+disc[i]);
						posVO1.setDiscount(disc[i]);
					}
				}
				System.out.println("pos vo after vo: "+posVO1);
				quantity = Integer.parseInt(posVO1.getQuantity());
				price = Integer.parseInt(posVO1.getPrice());
				discount= Integer.parseInt(posVO1.getDiscount());
				amount=(quantity*price)-discount;
				posVO1.setAmount(amount.toString());
				
				if (posVO1.getAmount() != null) {
					System.out.println("inside for:" + posVO1.getAmount());
					totalAmount += Integer.valueOf(posVO1.getAmount())
							.intValue();
					netAmount = totalAmount;					
				}
				
			}	
			}
			

			System.out.println("totalAmount" + totalAmount);
			netAmount = (int) (totalAmount * 0.90909);
			System.out.println("netAmount" + netAmount);
			tax = totalAmount - netAmount;
			System.out.println("tax" + tax);
			amountPayable = totalAmount;
			System.out.println("amountPayable" + amountPayable);

			SalesVO salesVO = new SalesVO();
			salesVO.setAmount(totalAmount.toString());
			salesVO.setTax(tax.toString());
			salesVO.setNetAmount(netAmount.toString());
			salesVO.setAmountPayable(amountPayable.toString());

			WebUtils.setSessionAttribute(httpServletRequest, "pos_list", posVOs);
			WebUtils.setSessionAttribute(httpServletRequest, "salesVO", salesVO);
		}

		ModelAndView mav = new ModelAndView(".pos.possale", "possale", posVO);
		mav.getModelMap().addAttribute("totalAmount", totalAmount);
		mav.getModelMap().addAttribute("netAmount", netAmount);
		mav.getModelMap().addAttribute("tax", tax);
		mav.getModelMap().addAttribute("amountPayable", amountPayable);

		return mav;

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/possale", method = RequestMethod.POST, params = { "delete" })
	public @ResponseBody void deleteProduct(@ModelAttribute("possale") PosVO posVO,
			Model model, HttpServletRequest httpServletRequest,
			HttpSession session) throws DatabaseException,
			DuplicateEntryException, NoDataFoundException {

		
		String productName = httpServletRequest.getParameter("productName");

		List<PosVO> posVOs;
		posVOs = (List<PosVO>) WebUtils.getSessionAttribute(
				httpServletRequest, "pos_list");
	
			if (posVOs == null || posVOs.size() == 0) {
				System.out.println("Data list null");
				posVOs = new ArrayList<PosVO>();
			} else{
				for (int i=0; i<posVOs.size(); i++) {
					PosVO posVO1 =posVOs.get(i);
					System.out.println(" list name: " + posVO1.getProductName());
					if(posVO1.getProductName().equals(productName)){
						posVOs.remove(i);
					}

				}
			}		

			System.out.println("Data list size " + posVOs.size());
			WebUtils.setSessionAttribute(
					httpServletRequest, "pos_list",posVOs);

		}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/possale", method = RequestMethod.POST)
	public ModelAndView saleSubmit(@ModelAttribute("possale") PosVO posVO,
			HttpServletRequest httpServletRequest, HttpSession session)
			throws DatabaseException, DuplicateEntryException {
		System.out.println("inside sales update method");
		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);
		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		
		String[] disc = httpServletRequest.getParameterValues("discount");
		System.out.println("Discount :"+ disc);
		if(disc !=null && disc.length!=0) {
			for(String s :disc) {
				System.out.println("S : "+s);
			}
		}
		
		


		List<PosVO> posVOs = (List<PosVO>) WebUtils.getSessionAttribute(
				httpServletRequest, "pos_list");
		

		if (posVOs!=null && posVOs.size()!=0){
		System.out.println("POS List: " + posVOs.size());

		Double promoDiscount=0.00;
		Double totalAmount = 0.00;
		Double netAmount;
		Double tax;
		Double amountPayable;
		
		/*Integer quantity;
		Integer price;
		Integer discount;
		Integer amount;*/
		

		for (int i = 0; i < posVOs.size(); i++) {
			System.out.println(" i :" + i);
			PosVO posVO1 = posVOs.get(i);
			/*posVO1.setProductId(posVO1.getProductName());*/
			System.out.println("start for:" + posVO1);
			
			/*if (posVO.getQuantityList() != null
					&& posVO.getQuantityList().length != 0) {
				System.out.println("Not null qty");
				System.out.println("get i of quantity: "
						+ posVO.getQuantityList()[i]);
				posVO1.setQuantity(posVO.getQuantityList()[i]);
			} else {
				System.out.println("null qty");
				posVO1.setQuantity("1");
			}*/

			/*if (posVO.getDiscountList() != null
					&& posVO.getDiscountList().length != 0) {
				System.out.println("Not null disc :" + posVO.getDiscountList());
				System.out.println("get i of discount: "
						+ posVO.getDiscountList()[i]);
				posVO1.setDiscount(posVO.getDiscountList()[i]);
			} else {
				System.out.println("null disc");
				posVO1.setDiscount("0");
			}*/

			System.out.println("Before calculation");
			Double intQty = Double.parseDouble(posVO1.getQuantity());
			intQty =round(intQty, 2);
			Double intPrice = Double.parseDouble(posVO1.getPrice());
			intPrice =round(intPrice, 2);
			posVO1.setDiscount(disc[i]);
			Double intDisc = Double.parseDouble(posVO1.getDiscount());
			intDisc =round(intDisc, 2);
			System.out.println("intQty :" + intQty + " intPrice :" + intPrice
					+ " intDisc:" + intDisc);
			Double amount = (intQty * intPrice) - intDisc;
			amount =round(amount, 2);
			posVO1.setAmount(amount.toString());
			totalAmount = totalAmount + amount;
			System.out.println("end for:" + posVO1);
		}

		if ((posVO.getPromoDiscount() != null)
				&& (posVO.getPromoDiscount() != "")) {
			promoDiscount = Double.parseDouble(posVO.getPromoDiscount());
			promoDiscount =round(promoDiscount, 2);
		}
		totalAmount = totalAmount - promoDiscount;
		totalAmount =round(totalAmount, 2);
		System.out.println("totalAmount" + totalAmount);
		netAmount = (Double) (totalAmount * 0.90909);
		netAmount =round(netAmount, 2);
		System.out.println("netAmount" + netAmount);
		tax = totalAmount - netAmount;
		tax =round(tax, 2);
		System.out.println("tax" + tax);
		amountPayable = totalAmount;
		System.out.println("amountPayable" + amountPayable);

		SalesVO salesVO1 = new SalesVO();
		salesVO1.setAmount(totalAmount.toString());
		salesVO1.setTax(tax.toString());
		salesVO1.setNetAmount(netAmount.toString());
		salesVO1.setPromoDiscount(promoDiscount.toString());
		salesVO1.setAmountPayable(amountPayable.toString());

		System.out.println("Value in session :" + posVOs);
		WebUtils.setSessionAttribute(httpServletRequest, "pos_list", posVOs);
		WebUtils.setSessionAttribute(httpServletRequest, "salesVO", salesVO1);

		try {
			CustomerVO sessionObj = saleInfoService.insertSaleInfo(posVOs,
					salesVO1, posVO.getCustomer(), session, sessionCache,
					applicationCache);

			WebUtils.setSessionAttribute(httpServletRequest, "customerVo",
					sessionObj);
		} catch (NoDataFoundException e) {
			e.printStackTrace();
		}
		return new ModelAndView ("redirect:/possale.htm?invoice");
		}
		else {
			System.out.println("Select one product");
			ModelAndView mav = new ModelAndView(".pos.possale", "possale", posVO);
			mav.getModelMap().addAttribute("error", "*Select one product ");
			return mav;
		}

	}
	
/*
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/possale", method = RequestMethod.POST)
	public String saleSubmit(@ModelAttribute("possale") PosVO posVO,
			HttpServletRequest httpServletRequest, HttpSession session)
			throws DatabaseException, DuplicateEntryException {
		System.out.println("inside sales update method");
		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);
		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);

		System.out.println("Customer Id: "
				+ posVO.getCustomer().getCustomerId());
		System.out.println("Quantity List: "
				+ posVO.getQuantityList().toString());
		System.out.println("Discount List: "
				+ posVO.getDiscountList().toString());
		System.out.println("Customer Name: "
				+ posVO.getCustomer().getCustomerName());
		System.out.println("Customer Email: " + posVO.getCustomer().getEmail());
		System.out.println("Customer MObile: "
				+ posVO.getCustomer().getMobile());
		System.out.println("Customer getAddress: "
				+ posVO.getCustomer().getAddress());
		System.out.println("Promo Discount: " + posVO.getPromoDiscount());
		System.out.println("Other brand details: " + posVO.getOtherBrand());

		List<PosVO> posVOs = (List<PosVO>) WebUtils.getSessionAttribute(
				httpServletRequest, "pos_list");
		System.out.println("POS List: " + posVOs.size());

		Integer promoDiscount = 0;
		Integer totalAmount = 0;
		Integer netAmount = 0;
		Integer tax = 0;
		Integer amountPayable = 0;

		for (int i = 0; i < posVOs.size(); i++) {
			System.out.println(" i :" + i);
			PosVO posVO1 = posVOs.get(i);
			posVO1.setProductId(posVO1.getProductName());
			System.out.println("start for:" + posVO1);
			System.out.println("start for qty:" + posVO.getQuantityList());
			if (posVO.getQuantityList() != null
					&& posVO.getQuantityList().length != 0) {
				System.out.println("Not null qty");
				System.out.println("get i of quantity: "
						+ posVO.getQuantityList()[i]);
				posVO1.setQuantity(posVO.getQuantityList()[i]);
			} else {
				System.out.println("null qty");
				posVO1.setQuantity("1");
			}

			System.out.println("start for disc :" + posVO.getDiscountList());
			if (posVO.getDiscountList() != null
					&& posVO.getDiscountList().length != 0) {
				System.out.println("Not null disc :" + posVO.getDiscountList());
				System.out.println("get i of discount: "
						+ posVO.getDiscountList()[i]);
				posVO1.setDiscount(posVO.getDiscountList()[i]);
			} else {
				System.out.println("null disc");
				posVO1.setDiscount("0");
			}

			System.out.println("Before calculation");
			Integer intQty = Integer.parseInt(posVO1.getQuantity());
			Integer intPrice = Integer.parseInt(posVO1.getPrice());
			Integer intDisc = Integer.parseInt(posVO1.getDiscount());
			System.out.println("intQty :" + intQty + " intPrice :" + intPrice
					+ " intDisc:" + intDisc);
			Integer amount = (intQty * intPrice) - intDisc;
			posVO1.setAmount(amount.toString());
			totalAmount = totalAmount + amount;
			System.out.println("end for:" + posVO1);
		}

		if ((posVO.getPromoDiscount() != null)
				&& (posVO.getPromoDiscount() != "")) {
			promoDiscount = Integer.parseInt(posVO.getPromoDiscount());
		}
		totalAmount = totalAmount - promoDiscount;
		System.out.println("totalAmount" + totalAmount);
		netAmount = (int) (totalAmount * 0.90909);
		System.out.println("netAmount" + netAmount);
		tax = totalAmount - netAmount;
		System.out.println("tax" + tax);
		amountPayable = totalAmount;
		System.out.println("amountPayable" + amountPayable);

		SalesVO salesVO1 = new SalesVO();
		salesVO1.setAmount(totalAmount.toString());
		salesVO1.setTax(tax.toString());
		salesVO1.setNetAmount(netAmount.toString());
		salesVO1.setPromoDiscount(promoDiscount.toString());
		salesVO1.setAmountPayable(amountPayable.toString());

		System.out.println("Value in session :" + posVOs);
		WebUtils.setSessionAttribute(httpServletRequest, "pos_list", posVOs);
		WebUtils.setSessionAttribute(httpServletRequest, "salesVO", salesVO1);

		try {
			CustomerVO sessionObj = saleInfoService.insertSaleInfo(posVOs,
					salesVO1, posVO.getCustomer(), session, sessionCache,
					applicationCache);

			WebUtils.setSessionAttribute(httpServletRequest, "customerVo",
					sessionObj);
		} catch (NoDataFoundException e) {
			e.printStackTrace();
		}
		return "redirect:/possale.htm?invoice";

	}*/

	@ModelAttribute("customer")
	public Map<String, String> getCustomerList(HttpSession session,
			HttpServletRequest httpSevletRequest, HttpServletResponse response,
			ModelMap model) throws IOException, NoDataFoundException {
		Map<String, String> map = saleInfoService.getCustomer();
		httpSevletRequest.setAttribute("customer", map);
		return map;

	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	@ModelAttribute("category")
	public Map<String, String> getCategory(HttpSession session,
			HttpServletRequest httpSevletRequest, HttpServletResponse response,
			ModelMap model) throws IOException {
		Map<String, String> map=null;
		try {
			map = categoryService.getCategory();
		} catch (NoDataFoundException e) {
			response.setStatus(406);
		}
		httpSevletRequest.setAttribute("category", map);
		return map;

	}
	
	@RequestMapping(value = "/possale", method = RequestMethod.POST, params = "brandList")
	public @ResponseBody Map<String, String> getBrand(HttpSession session,
			HttpServletRequest httpSevletRequest, HttpServletResponse response,
			ModelMap model) throws IOException {
		String category = (String) httpSevletRequest.getParameter("category");
		Map<String, String> map=null;
		try {
			map = addAccessoriesService.getBrand(category);
		} catch (NoDataFoundException e) {
			response.setStatus(406);
		}
		return map;

	}
	
	@RequestMapping(value = "/possale", method = RequestMethod.POST, params = "nameList")
	public @ResponseBody Map<String, String> getAccessory(HttpSession session,
			HttpServletRequest httpSevletRequest, HttpServletResponse response,
			ModelMap model) throws IOException{
		String category = (String) httpSevletRequest.getParameter("category");
		String brand = (String) httpSevletRequest.getParameter("brand");
		Map<String, String> map=null;
		try {
			map = addAccessoriesService.getName(category,brand);
		} catch (NoDataFoundException e) {
			response.setStatus(406);
		}
		return map;
		
	}
	
	@RequestMapping(value = "/possale", method = RequestMethod.POST, params = "getInventory")
	public @ResponseBody AddAccessoriesInventory getList (HttpServletRequest httpSevletRequest,
			HttpServletResponse response) throws DuplicateEntryException{
		
		String accessoriesId = (String) httpSevletRequest.getParameter("accessory");
		AddAccessoriesInventory addAccessories=null;
		try {
			addAccessories = addAccessoriesInventoryService.getList(accessoriesId);
		} catch (NoDataFoundException e) {
			response.setStatus(406);
		}
		return addAccessories;
		
	}

	@ExceptionHandler({ NoDataFoundException.class,
			DuplicateEntryException.class })
	public ModelAndView handleException(Exception ex, HttpServletRequest request) {

		PosVO posVo = (PosVO) request.getAttribute("posVO");
		ModelAndView mav = new ModelAndView(".pos.possale", "possale", posVo);
		mav.getModelMap().addAttribute("error", ex.getMessage());
		return mav;

	}

}
