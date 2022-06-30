package com.pos.login.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pos.admin.dao.BranchMaster;
import com.pos.admin.dao.BranchMasterKey;
import com.pos.admin.dao.IBranchMasterDAO;
import com.pos.admin.dao.IInstituteMasterDAO;
import com.pos.admin.dao.InstituteMaster;
import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.login.SessionCacheNotLoadedException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.common.files.dao.IFileMasterDao;
import com.pos.common.util.CommonCodeUtil;
import com.pos.common.util.DateUtil;
import com.pos.common.util.PropertyManagementUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.appCache.dao.MenuProfileOptionLinking;
import com.pos.framework.sessCache.SessionCache;
import com.pos.framework.sessCache.UserSessionDetails;
import com.pos.user.dao.User;
import com.pos.user.dao.UserLink;

@Component
public class LoginSCHelper {
	
	Logger logger = Logger.getLogger(LoginSCHelper.class);
	@Autowired
	ApplicationCache applicationCache;
	@Autowired
	com.jaw.security.SecurityCheck securityCheck;
	@Autowired
	PropertyManagementUtil propertyManagementUtil;
	@Autowired
	private IFileMasterDao fileMasterDAO;
	@Autowired
	private CommonBusiness commonBusiness;
	@Autowired
	private DateUtil dateUtil;
	@Autowired
	IInstituteMasterDAO instituteMasterDao;
	@Autowired
	IBranchMasterDAO branchMasDao;
	@Autowired
	CommonCodeUtil commonCodeUtil;
	
	public enum Grade {
		PAR, STU, MGT, NSF, STF
	};
	
	public void setUserSessionObject(SessionCache sessionCache, User user,
			UserLink userLink) throws
			SessionCacheNotLoadedException, PropertyNotFoundException, NoDataFoundException, DatabaseException {
		String inbrCategory = null;
		UserSessionDetails userSessionDetails = new UserSessionDetails();
		 String acaTermDetails = null;
		user.setUserEnableFlag("Y");
		commonBusiness.changeObject(userSessionDetails, user);
		commonBusiness.changeObject(userSessionDetails, userLink);
		sessionCache.setUserSessionDetails(userSessionDetails);
		
		Grade cadre = Grade.valueOf(sessionCache.getUserSessionDetails()
				.getProfileGroup());
		userSessionDetails = sessionCache.getUserSessionDetails();
		if((!sessionCache.getUserSessionDetails().getUserMenuProfile().equals(ApplicationConstant.SUPER_ADMIN)) && 
		(!sessionCache.getUserSessionDetails().getProfileGroup().equals(ApplicationConstant.PG_MGMT)))
		{
		
		//Getting INBR category				
		if(userSessionDetails.getInstId().equals(userSessionDetails.getBranchId())){
			InstituteMaster instMas = instituteMasterDao.selectInstituteMasterRec(null, userSessionDetails.getInstId());
			inbrCategory = instMas.getInstCategory();
					
		}else{
			BranchMasterKey branchMasKey = new BranchMasterKey();
			branchMasKey.setInstId(userSessionDetails.getInstId());
			branchMasKey.setBranchId(userSessionDetails.getBranchId());
			
			BranchMaster branchMas = branchMasDao.selectBranchMaster(branchMasKey);
			inbrCategory = branchMas.getBranchCategory();			
			
		}
		if((inbrCategory.equals(""))||(inbrCategory==null)){
				throw new SessionCacheNotLoadedException();
			}else{
				userSessionDetails.setInbrCategory(inbrCategory);
			}	
						
		}
		
		
		switch (cadre) {
			
		}
		logger.debug("before getting menus ");
		setUserMenuAndUrl(applicationCache, userLink, sessionCache);
		logger.debug("after getting menus ");
	}
	
	private void setUserMenuAndUrl(ApplicationCache applicationCache,
			UserLink userLink, SessionCache sessionCache) throws SessionCacheNotLoadedException {
		
		List<MenuProfileOptionLinking> userMenu = new ArrayList<MenuProfileOptionLinking>();
		Map<String, ArrayList<MenuProfileOptionLinking>> menuProfileOptionLinking = applicationCache
				.getMenuProfileList();
		List<String> allowedUrl = new ArrayList<String>();
		String key = userLink.getInstId() + "-" + userLink.getBranchId() + "-"
				+ userLink.getUserMenuProfile();
				System.out.println("user menu key :"+key);
		userMenu = menuProfileOptionLinking.get(key);
		sessionCache.setOptionLinkings(userMenu);
		if (userMenu == null) {
			throw new SessionCacheNotLoadedException();
		}
		for (MenuProfileOptionLinking linking : userMenu) {
			allowedUrl.add(linking.getMenuUrl());
		}
		sessionCache.setAllowedUrl(allowedUrl);
		
	}
}
