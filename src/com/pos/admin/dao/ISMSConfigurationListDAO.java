package com.pos.admin.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;

public interface ISMSConfigurationListDAO {
	public List<SMSConfiguration> getSMSConfigurationList(final SMSConfigurationListKey smsConfigurationListKey)
			throws NoDataFoundException ;
	 void updateSMSConfigurationDetailsRecs(
				final List<SMSConfiguration> smsConfigurationList,final List<SMSConfigurationListKey> smsConfigurationKeyList) throws  UpdateFailedException;
}
