package com.pos.framework.listener;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pos.common.constants.ApplicationConstant;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.util.MenuProfileUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.appCache.dao.ApplicationCacheCommonCodeDao;
import com.pos.framework.appCache.dao.ApplicationCacheErrorCodeDao;
import com.pos.framework.appCache.dao.ApplicationCacheProfileOptionLinking;
import com.pos.framework.appCache.dao.ApplicationCachePropertyMaintenanceDao;
import com.pos.framework.appCache.dao.ApplicationCacheSMSPropertyDao;
import com.pos.framework.appCache.dao.ApplicationCacheTableMaintenanceDao;
import com.pos.framework.appCache.dao.CommonCode;
import com.pos.framework.appCache.dao.IApplicationCacheCommonCodeDao;
import com.pos.framework.appCache.dao.IApplicationCacheErrorCodeDao;
import com.pos.framework.appCache.dao.IApplicationCacheProfileOptionLinking;
import com.pos.framework.appCache.dao.IApplicationCachePropertyMaintenanceDao;
import com.pos.framework.appCache.dao.IApplicationCacheSMSPropertyDao;
import com.pos.framework.appCache.dao.IApplicationCacheTableMaintenanceDao;
import com.pos.framework.appCache.dao.MenuProfileOptionLinking;
@Component
public class AppServletContextListenerHelper {
	
	Logger logger = Logger.getLogger(AppServletContextListenerHelper.class);
	
	IApplicationCacheCommonCodeDao commonCodeDao;
	IApplicationCachePropertyMaintenanceDao propertyMaintenanceDao;
	IApplicationCacheProfileOptionLinking profileOptionLinking;
	MenuProfileUtil menuProfileUtil;
	IApplicationCacheErrorCodeDao applicationCacheErrorCodeDao;
	IApplicationCacheTableMaintenanceDao applicationCacheTableMaintenanceDao;
	ApplicationCache applicationCache;
	IApplicationCacheSMSPropertyDao smsPropertyDao;
	public void contextInitialized(ServletContext context) {
		logger.debug("contextInitialized");
		
		// Load Application Dao from xml
		
		logger.debug("Loading Application Dao beans from applicationContext.xml");
		WebApplicationContext applicationContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(context);
		
		applicationCache = (ApplicationCache) applicationContext
				.getBean("applicationCache");
		
		// Load CommonCode into Application cache
		try {
			logger.debug("Get commoncode  for application cache");
			
			commonCodeDao = (ApplicationCacheCommonCodeDao) applicationContext
					.getBean("commonCodeDao");
			commonCodeDao.setSQL();
			applicationCache
					.setCommoncode(commonCodeDao.getAllCommonCodeList());
			
			// Load Common code map into application cache
			
			Map<String, String> commonCodeMap = new HashMap<String, String>();
			for (CommonCode commonCode : commonCodeDao.getAllCommonCodeList()) {
				commonCodeMap.put(
						commonCode.getInstId() + "," + commonCode.getBranchId() + ","
								+ commonCode.getCodeType() + ","
								+ commonCode.getCommonCode(),
						commonCode.getCodeDescription());
			}
			applicationCache.setCommoncodeMap(commonCodeMap);
			
			// Load error code into ApplicationCache
			
			applicationCacheErrorCodeDao = (ApplicationCacheErrorCodeDao) applicationContext
					.getBean("errorCodeDao");
			
			logger.debug("Get messages from application dao for application cache");
			
			applicationCache.setErrorcode(applicationCacheErrorCodeDao
					.getAllErrorCode());
			
			// Get constant property from PropertyMaintenanceDao for application
			// cache
			
			propertyMaintenanceDao = (ApplicationCachePropertyMaintenanceDao) applicationContext
					.getBean("propertyMaintenanceDao");
			smsPropertyDao=(ApplicationCacheSMSPropertyDao) applicationContext.getBean("smsMaintenanceDao");
			logger.debug("Get constant property  from PropertyMaintenanceDao for application cache");
			
			applicationCache.setPropertyManagement(propertyMaintenanceDao
					.getPrpmCodes());
			applicationCache.setSmsProperty(smsPropertyDao.getPrpmCodes());
			// Get menus from Menu for application
			// cache
			
			profileOptionLinking = (ApplicationCacheProfileOptionLinking) applicationContext
					.getBean("menuProfile");
			List<MenuProfileOptionLinking> umplList = profileOptionLinking
					.getMenuProfileOption();
			List<MenuProfileOptionLinking> menuProfileList = profileOptionLinking
					.getMenuProfile();
			menuProfileUtil = (MenuProfileUtil) applicationContext
					.getBean("umplUtil");
			applicationCache.setMenuProfileList(menuProfileUtil
					.getMenuProfileByMenuId(umplList, menuProfileList));
			applicationCache.setMenuIdList(menuProfileUtil
					.getMenuIdList(umplList));
			// TBPM application cache loading
			applicationCacheTableMaintenanceDao = (ApplicationCacheTableMaintenanceDao) applicationContext
					.getBean("tableMaintenanceDao");
			
			applicationCache
					.setTableMaintenances(applicationCacheTableMaintenanceDao
							.getTableMaintenanceData());
			Properties properties = new Properties();
			properties.load(getClass()
					.getResourceAsStream("/sample.properties"));
			
			context.setAttribute(ApplicationConstant.APPLICATION_CACHE,
					applicationCache);
		}
		catch (NoDataFoundException exception) {
			exception.printStackTrace();
			logger.debug("Error occured while loading applicationg cache , Application shut down...");
			System.exit(0);
		}
		catch (IOException e) {
			logger.debug("Error occured while loading property files");
		}
		
	}
}
