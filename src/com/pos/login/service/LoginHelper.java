package com.pos.login.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.PropertyManagementConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.FileNotFoundInDatabase;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.PasswordMismatchException;
import com.pos.common.exceptions.PasswordrequestedLoginFailException;
import com.pos.common.exceptions.login.InvalidAttemptException;
import com.pos.common.exceptions.login.PasswordExpiredException;
import com.pos.common.exceptions.login.PasswordNotResetException;
import com.pos.common.exceptions.login.SessionCacheNotLoadedException;
import com.pos.common.exceptions.login.UserDisabledException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.common.files.dao.IFileMasterDao;
import com.pos.common.util.DateUtil;
import com.pos.common.util.PropertyManagementUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.user.controller.UserVO;
import com.pos.user.dao.User;
import com.pos.user.dao.UserLink;
import com.pos.user.service.UserProfileHelper;

@Component
public class LoginHelper {
	Logger logger = Logger.getLogger(LoginHelper.class);
	@Autowired
	ApplicationCache applicationCache;
	@Autowired
	com.jaw.security.SecurityCheck securityCheck;
	@Autowired
	PropertyManagementUtil propertyManagementUtil;
	@Autowired
	private IFileMasterDao fileMasterDAO;
	@Autowired
	private UserProfileHelper userProfileHelper;
	@Autowired
	private CommonBusiness commonBusiness;
	@Autowired
	private DateUtil dateUtil;
	@Autowired
	private LoginSCHelper loginSCHelper;
	
	public boolean checkUserEnabled(User user) throws UserDisabledException {
		logger.debug("checking whether user is enable r not");
		if (user.getUserEnableFlag().equals(ApplicationConstant.USER_DISABLE_FLG)) {
			logger.info(user.getUserId() + " is disabled unable to login.");
			
			throw new UserDisabledException();
		}
		
		return true;
	}
	
	public boolean checkUserRequestedForPassword(User user)
			throws PasswordrequestedLoginFailException {
		logger.debug("checking whether user is erequested for password or not");
		
		if (user.getUserEnableFlag().equals(ApplicationConstant.REQUEST_STATUS_REQUESTED)) {
			
			logger.info(user.getUserId()
					+ " is requested for new password, unable to login.");
			throw new PasswordrequestedLoginFailException();
		}
		return true;
	}
	
	public void validatePassword(User user, UserVO uservo)
			throws PasswordMismatchException {
		if (!securityCheck.checkPassword(uservo.getPassword(),
				user.getPassword())) {
			user.setNoOfAttempts(user.getNoOfAttempts() + 1);
			throw new PasswordMismatchException();
		}
		
	}
	
	public void checkNumberOfInvalidAttempts(
			ApplicationCache applicationCache2, User user)
			throws InvalidAttemptException, NumberFormatException,
			PropertyNotFoundException {
		logger.debug("checking number of invalid attempts");
		Integer maxInvalidAttemptsAllowed = Integer
				.parseInt(propertyManagementUtil.getPropertyValue(
						applicationCache,
						user.getInstId(),
						user.getBranchId(),
						PropertyManagementConstant.NO_OF_INVALID_ATTEMPTS_ALLOWED));
		logger.debug("User :" + user.getUserId() + "'s invalid attempts is "
				+ user.getNoOfAttempts() + " , Max invalid attemmpts :"
				+ maxInvalidAttemptsAllowed);
		if (user.getNoOfAttempts() > maxInvalidAttemptsAllowed) {
			logger.error("User :" + user.getUserId()
					+ " exceed maximum number of invalid attempts"
					+ user.getNoOfAttempts() + " , User  disabled");
			user.setUserEnableFlag("N");
			user.setNoOfAttempts(0);
			throw new InvalidAttemptException();
		}
	}
	
	public boolean checkPasswordResetRequired(User user)
			throws PasswordNotResetException {
		logger.debug("checking whether password reset is required r not");
		if (user.getPasswordResetFlag().equals(ApplicationConstant.PASSWORD_RESET_REQUIRED)) {
			logger.info("Password reset required for user :" + user.getUserId());
			throw new PasswordNotResetException();
		}
		
		return true;
	}
	
	public boolean checkPasswordExpiredDate(User user)
			throws PasswordExpiredException
	
	{
		logger.debug("checking whether password  is expires r not");
		if (dateUtil.checkDate(user.getPasswordExpiryDate())) {
			logger.info("Password expired for user :" + user.getUserId());
			throw new PasswordExpiredException();
		}
		
		return true;
	}
	
	public void createUserObjectLoginSuccess(User user, UserVO userVO,
			UserLink userLink, SessionCache sessionCache)
			throws FileNotFoundInDatabase, SessionCacheNotLoadedException,
			PropertyNotFoundException {
		logger.debug("Login success");
		Integer num = Integer.parseInt(user.getTotalNoOfLogin()) + 1;
		user.setTotalNoOfLogin(num.toString());
		user.setNoOfAttempts(0);
		user.setIpAddress(userVO.getIpAddress());
		user.setSessionId(userVO.getSessionId());
		user.setLoginTime(dateUtil.getCurrentDateInDateDataType());
		try {
			loginSCHelper.setUserSessionObject(sessionCache, user, userLink);
		} catch (NoDataFoundException e) {
			throw new SessionCacheNotLoadedException();
		} catch (DatabaseException e) {
			throw new SessionCacheNotLoadedException();
		}
		
	}
	
}
