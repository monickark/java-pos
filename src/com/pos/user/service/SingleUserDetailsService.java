package com.pos.user.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.login.InvalidUserIdException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.common.util.ProfileGroup;
import com.pos.common.util.PropertyManagementUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.UserSessionDetails;
import com.pos.login.controller.LoginController;
import com.pos.user.controller.BranchAdminVO;
import com.pos.user.dao.IUserLinkDao;
import com.pos.user.dao.UserLink;

@Service
public class SingleUserDetailsService implements ISingleUserDetailsService {
	Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private IUserLinkDao userLinkDao;
	@Autowired
	private CommonBusiness commonBusiness;
	@Autowired
	PropertyManagementUtil propertyManagementUtil;
	
	@Override
	public String getSingleUser(ApplicationCache applicationCache,
			String userId, UserSessionDetails userSessionDetails,
			BranchAdminVO branchAdminVO,
			String profileGroup)
			throws NoDataFoundException, InvalidUserIdException,
			PropertyNotFoundException {
		
		UserLink users = userLinkDao.getUserDetails(userId);
		
		ProfileGroup pg = ProfileGroup.valueOf(users.getProfileGroup());
		System.out.println("User profile group :" + pg);
		
		/*branchAdminVO = nonStaffDetailsDAO.selectNonStaffRec(
						users.getInstId(),
						users.getBranchId(), users.getLinkId());
				commonBusiness.changeObject(branchAdminVO, nonStaff);*/
				branchAdminVO.setProfileGroup(ApplicationConstant.PG_NON_STAFF);
				
				profileGroup = ApplicationConstant.PG_NON_STAFF;

		System.out.println("Profile group in service :" + profileGroup);
		return profileGroup;
		
	}
}
