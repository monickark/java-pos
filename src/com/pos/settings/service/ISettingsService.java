package com.pos.settings.service;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.settings.controller.SettingsVO;

public interface ISettingsService {

	void addSettings(SettingsVO settingVO, SessionCache sessionCache, ApplicationCache applicationCache) throws DatabaseException, DuplicateEntryException;
	
	void updateSettings(SettingsVO settingVO, SessionCache sessionCache, ApplicationCache applicationCache) throws   UpdateFailedException, NoDataFoundException;

	SettingsVO getCompanyDetails() throws NoDataFoundException;

}
