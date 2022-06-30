package com.pos.communication.dao;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;

public interface ISMSDetailsDAO {
	public void saveSMSDetailsRecord(SMSDetails smsDetails)throws DuplicateEntryException;
	public void updateSMSDetailsRecord(SMSDetails smsDetails,final SMSDetailsKey smsDetailsKey)throws UpdateFailedException;
	SMSDetails selectSMSDetailsRec(final SMSDetailsKey smsDetailsKey)	throws NoDataFoundException;
	
}
