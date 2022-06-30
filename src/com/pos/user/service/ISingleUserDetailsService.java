package com.pos.user.service;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.login.InvalidUserIdException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.UserSessionDetails;
import com.pos.user.controller.BranchAdminVO;

public interface ISingleUserDetailsService {

	String getSingleUser(ApplicationCache applicationCache, String userId,
			UserSessionDetails userSessionDetails,
			BranchAdminVO branchAdminVO, String profileGroup)
			throws NoDataFoundException, InvalidUserIdException,
			PropertyNotFoundException;

}
