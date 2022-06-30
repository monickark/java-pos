package com.pos.admin.dao;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;

public interface ISMSConfigurationDAO {
	void updateSMSConfigurationRec(SMSConfiguration smsConfigRecord,final SMSConfigurationKey smsConfigKey)
			throws UpdateFailedException;
	
	SMSConfiguration selectSMSConfigurationRec(
			final SMSConfigurationKey smsConfigKey)
			throws NoDataFoundException;
}
