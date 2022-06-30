package com.pos.framework.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pos.framework.sessCache.SessionCache;
import com.pos.framework.sessCache.dao.ClearSessionDao;
import com.pos.framework.sessCache.dao.IClearSessionDao;

public class SessionListener implements HttpSessionListener {

	private static int totalActiveSessions;
	IClearSessionDao clearSessionDao;
	@Autowired
	SessionCache sessionCache;

	public static int getTotalActiveSession() {
		return totalActiveSessions;
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		totalActiveSessions++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		totalActiveSessions--;
		WebApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(event.getSession()
						.getServletContext());
		clearSessionDao = (ClearSessionDao) ctx.getBean("clearSessionDao");
		clearSessionDao.deleteLogin(event.getSession().getId());
	}
}
