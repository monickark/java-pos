package com.pos.login.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.AuditConstant;
import com.pos.common.constants.PropertyManagementConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.common.util.DateUtil;
import com.pos.common.util.PropertyManagementUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.audit.dao.IAuditDao;
import com.pos.framework.audit.service.DoAudit;
import com.pos.framework.sessCache.UserSessionDetails;
import com.pos.user.controller.UserVO;
import com.pos.user.dao.User;

@Component
public class PasswordChangeHelper {
	@Autowired
	IAuditDao auditDaoImpl;
	@Autowired
	DateUtil dateUtil;
	@Autowired
	CommonBusiness commonBusiness;
	@Autowired
	PropertyManagementUtil propertyManagementUtil;
	// Helper class to do Auditing
	@Autowired
	DoAudit doAudit;
	Logger logger = Logger.getLogger(PasswordChangeHelper.class);

	public void updatePasswordChangeUser(UserVO userVO, User user,
			ApplicationCache applicationCache) throws DuplicateEntryException,
			DatabaseException, NumberFormatException, PropertyNotFoundException {
		UserSessionDetails userSessionDetails = new UserSessionDetails();
		userSessionDetails.setInstId(user.getInstId());
		userSessionDetails.setBranchId(user.getBranchId());
		userSessionDetails.setUserId(user.getUserId());
		userSessionDetails.setIpAddress(userVO.getIpAddress());
		int days = Integer.parseInt(propertyManagementUtil.getPropertyValue(
				applicationCache, user.getInstId(), user.getBranchId(),
				PropertyManagementConstant.PWD_EXPIRY_PRD).toString());
		user.setPasswordExpiryDate(dateUtil.addDaysToCurrentDate(days));
		user.setNoOfAttempts(0);
		user.setPasswordResetDate(user.getCurrentDate());
		user.setPasswordResetFlag("N");

		doAudit.doFunctionalAudit(userSessionDetails,
				AuditConstant.PASSWORD_CHANGE, " ");

	}

}
