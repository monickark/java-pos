package com.pos.prodAdm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pos.common.constants.ModelAndViewConstant;
import com.pos.framework.listener.AppServletContextListenerHelper;

@Controller
public class ApplicationCacheRefreshController {

	// To show login page
	
	@RequestMapping(value = "/refreshApplicationCache", method = RequestMethod.GET)
	public ModelAndView refAppCache(HttpSession session) {

		AppServletContextListenerHelper appServletContextListener = new AppServletContextListenerHelper();
		appServletContextListener.contextInitialized(session
				.getServletContext());
		ModelAndView mav = new ModelAndView(".pos.refAppCache");
		return mav;
	}
	
	@RequestMapping(value = "/refreshApplicationCache", method = RequestMethod.GET,params={"refresh"})
	public String sessionTimeout(HttpSession session) {

		AppServletContextListenerHelper appServletContextListener = new AppServletContextListenerHelper();
		appServletContextListener.contextInitialized(session
				.getServletContext());

		return "common/session_timeout";
	}

}
