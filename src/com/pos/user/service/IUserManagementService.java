package com.pos.user.service;

import java.util.List;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.exceptions.login.InvalidUserIdException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.framework.sessCache.UserSessionDetails;
import com.pos.user.controller.UserManagementVO;

public interface IUserManagementService {
	List<String> getMenuProfileList(UserSessionDetails userSessionDetails)
			throws NoDataFoundException;
	
	UserManagementVO userEnableOrDisable(UserManagementVO managementVO,
			UserSessionDetails userSessionDetails,
			ApplicationCache applicationCache) throws DuplicateEntryException,
			InvalidUserIdException, DatabaseException, NumberFormatException,
			PropertyNotFoundException, UpdateFailedException;
	
	List<UserManagementVO> getUserDetailsForUserManagement(
			ApplicationCache applicationCache, SessionCache sessionCache,
			String branchId, String instId, UserManagementVO userManagementVO,
			String url) throws NoDataFoundException;
	
}
