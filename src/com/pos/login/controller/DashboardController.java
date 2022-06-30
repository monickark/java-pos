package com.pos.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pos.common.constants.ApplicationConstant;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.communication.controller.AlertVO;
import com.pos.communication.dao.AlertListKey;
import com.pos.communication.service.IAlertService;
import com.pos.framework.sessCache.SessionCache;
import com.pos.login.service.IDashboardService;

@Controller
public class DashboardController {
	// Logging
	Logger logger = Logger.getLogger(DashboardController.class);
	@Autowired
	IDashboardService dashboardService;
	@Autowired
	IAlertService alertService;

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView renderDashboard(HttpServletRequest request,
			HttpSession session) {

		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ModelAndView mav = new ModelAndView(".pos.dashboard");

		return mav;

	}


	// Ajax For Alert Details for dashboard
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET, params = { "dashBoardAlert" })
	public @ResponseBody List<AlertVO> getAlertList(HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		logger.debug("inside alert method");

		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);

		AlertListKey alertListKey = new AlertListKey();
		alertListKey.setAcTerm(sessionCache.getUserSessionDetails()
				.getCurrAcTerm());
		alertListKey
				.setInstId(sessionCache.getUserSessionDetails().getInstId());
		alertListKey.setBranchId(sessionCache.getUserSessionDetails()
				.getBranchId());
		List<AlertVO> alertVOs = null;
		try {
			alertVOs = alertService.selectAlertListForDashBoard(alertListKey,
					sessionCache.getUserSessionDetails());

		} catch (NoDataFoundException e) {
			response.setStatus(400);
			logger.error("Error occured in Alert details controller :"
					+ e.getMessage());
		}
		System.out.println("list size in controleler" + alertVOs.size());

		return alertVOs;
	}
}
