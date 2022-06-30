package com.pos.user.service;

import java.io.IOException;

import javax.servlet.ServletContext;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DeleteFailedException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.FileNotFoundInDatabase;
import com.pos.common.exceptions.FileNotSaveException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.exceptions.UserNotCreatedException;
import com.pos.common.exceptions.login.InvalidUserIdException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.UserSessionDetails;
import com.pos.user.controller.BranchAdminVO;

public interface IBranchAdminService {

	public void insertBranchAdmin(BranchAdminVO adminVO,
			UserSessionDetails userSessionDetails,
			ApplicationCache applicationCache,ServletContext servletContext) throws FileNotFoundInDatabase,
			DuplicateEntryException, InvalidUserIdException,
			UpdateFailedException, DatabaseException, NumberFormatException,
			PropertyNotFoundException, IllegalStateException, IOException, DeleteFailedException, FileNotSaveException;
	
	void selectStaffDetails(BranchAdminVO adminVO,
			UserSessionDetails userSessionDetails) throws NoDataFoundException,
			UserNotCreatedException;

}
