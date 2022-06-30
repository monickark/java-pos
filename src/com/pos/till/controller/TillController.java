package com.pos.till.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.ErrorCodeConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.till.service.ITillService;

@Controller
public class TillController {

	Logger logger = Logger.getLogger(TillController.class.getName());
	@Autowired
	ITillService tillService;

	@RequestMapping(value = "/till", method = RequestMethod.GET)
	public ModelAndView addTillGet(@ModelAttribute("till") TillVO tillVO, Model model, HttpSession session) {
		logger.debug("Opening till Page");
		 TillVO newObj=null;
		 String status = "Closed";
		try {
			newObj = tillService.selectTillObj();

			 System.out.println("NEW OBJ"+newObj);
			if(newObj != null && newObj.getAmount()!=null) {
				status = "Opened";
				List<TillVO> tillVOs = tillService.selectTill(tillVO);
				session.setAttribute("till", tillVOs);
			}
		} catch (NoDataFoundException e) {
			logger.debug("No Data found");
		}


		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 Calendar cal = Calendar.getInstance();		 
		 String today=dateFormat.format(cal.getTime());	
		 
		ModelAndView mav = new ModelAndView(".pos.till","till", tillVO);
		session.setAttribute("today", today);
		session.setAttribute("status", status);
		mav.getModelMap().addAttribute("success", "");
		return mav;
	}

	@RequestMapping(value = "till", method = RequestMethod.POST)
	public ModelAndView addTillPost(@ModelAttribute("till") TillVO tillVO, HttpSession session,
			HttpServletRequest request, Model model)
			throws DatabaseException, DuplicateEntryException, NoDataFoundException {
		logger.debug("Add till post method called");
		System.out.println("Till VO in Ctrl: "+tillVO);
		String store=(String) session.getAttribute("status");
		String status=null;
		if(store=="Opened"){
			status="open";
		}else if(store=="Closed"){
			status="close";
		}
		tillVO.setStatus(status);
		SessionCache sessionCache = (SessionCache) session.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session.getServletContext()
				.getAttribute(ApplicationConstant.APPLICATION_CACHE);
		
		tillService.addTill( tillVO, sessionCache, applicationCache);		
		logger.debug("Till Added Successfully");
		tillVO = new TillVO();
		ModelAndView mav = new ModelAndView(".pos.till", "till", tillVO);
		mav.getModelMap().addAttribute("success", ErrorCodeConstant.ADD_SUCCESS_MESS);
		
		List<TillVO> tillVOs = tillService.selectTill(tillVO);
		session.setAttribute("till", tillVOs);
		return mav;

	}
	@RequestMapping(value = "till", method = RequestMethod.POST, params={"open_counter"})
	public String openCounter(@ModelAttribute("till") TillVO tillVO, HttpSession session,
			HttpServletRequest request, Model model)
			throws DatabaseException, DuplicateEntryException, NoDataFoundException {
		tillService.updateTill("open");
		return "redirect:/possale.htm";
		
		
	}
	@RequestMapping(value = "till", method = RequestMethod.POST, params={"close_counter"})
	public ModelAndView closeCounter(@ModelAttribute("till") TillVO tillVO, HttpSession session,
			HttpServletRequest request, Model model)
			throws DatabaseException, DuplicateEntryException, NoDataFoundException {
		tillService.updateTill("close");
		session.setAttribute("till", null);
		session.setAttribute("status", "Closed");
		ModelAndView mav = new ModelAndView(".pos.till","till", tillVO);
		return mav;
		
		
	}
	
}
