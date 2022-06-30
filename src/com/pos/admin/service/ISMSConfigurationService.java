package com.pos.admin.service;

import com.pos.admin.controller.SMSConfigurationMasterVO;
import com.pos.admin.controller.SMSConfigurationVO;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.exceptions.util.TableNotSpecifiedForAuditException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.UserSessionDetails;

public interface ISMSConfigurationService {
	public SMSConfigurationMasterVO selectStudentGroupList(SMSConfigurationMasterVO smsConfigurationMasterVO,UserSessionDetails userSessionDetails)
			throws NoDataFoundException;
	public void saveSMSConfigurationDetails(SMSConfigurationMasterVO smsConfigurationMasterVO,UserSessionDetails userSessionDetails,String[] rowIds,
			String[] propertyValues,String[] propertyNames)
			throws NoDataFoundException, UpdateFailedException;
	public void updateSMSConfigurationRec(SMSConfigurationVO smsConfigurationVO,
			UserSessionDetails userSessionDetails,ApplicationCache applicationCache) throws UpdateFailedException,NoDataFoundException, DuplicateEntryException, DatabaseException, TableNotSpecifiedForAuditException;
}
