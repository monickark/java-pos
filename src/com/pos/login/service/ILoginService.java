package com.pos.login.service;

import java.io.FileNotFoundException;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.DuplicatePasswordException;
import com.pos.common.exceptions.FileNotFoundInDatabase;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.PasswordMismatchException;
import com.pos.common.exceptions.PasswordrequestedLoginFailException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.exceptions.login.InvalidAttemptException;
import com.pos.common.exceptions.login.InvalidUserIdException;
import com.pos.common.exceptions.login.PasswordExpiredException;
import com.pos.common.exceptions.login.PasswordNotResetException;
import com.pos.common.exceptions.login.SessionCacheNotLoadedException;
import com.pos.common.exceptions.login.UserDisabledException;
import com.pos.common.exceptions.login.WrongPasswordException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.framework.sessCache.UserSessionDetails;
import com.pos.user.controller.UserVO;
import com.pos.user.dao.User;

public interface ILoginService {
	
	void loginUser(UserVO uservo, ApplicationCache applicationCache,
			SessionCache sessionCache) throws DuplicateEntryException,
			PasswordMismatchException, InvalidAttemptException,
			PasswordNotResetException, PasswordExpiredException,
			UserDisabledException, FileNotFoundInDatabase,
			FileNotFoundException, InvalidUserIdException, DatabaseException,
			SessionCacheNotLoadedException,
			PasswordrequestedLoginFailException, NumberFormatException,
			PropertyNotFoundException, UpdateFailedException, NoDataFoundException;
	
	boolean insertLogin(User user) throws DuplicateEntryException;
	
	void updatePassword(UserVO user, ApplicationCache applicationCache)
			throws PasswordMismatchException, WrongPasswordException,
			DuplicatePasswordException, DuplicateEntryException,
			InvalidUserIdException, DatabaseException, UpdateFailedException,
			PropertyNotFoundException;
	
	void logout(UserSessionDetails userSessionDetails)
			throws DuplicateEntryException, InvalidUserIdException,
			DatabaseException, UpdateFailedException;
	
}
