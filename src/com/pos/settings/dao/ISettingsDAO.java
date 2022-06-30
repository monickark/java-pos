package com.pos.settings.dao;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;

public interface ISettingsDAO {

	void insertSetting(Settings setting) throws DuplicateEntryException;

	Settings selectCompanyDetails() throws NoDataFoundException;
	
	void updateSettings(Settings settings) throws UpdateFailedException;
	

}
