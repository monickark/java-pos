package com.pos.communication.dao;

import com.pos.common.exceptions.DeleteFailedException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;

public interface ISMSAlertDAO {
	void insertSMSAlertRec(SMSAlert smsAlertRecord)
			throws DuplicateEntryException;

	void updateSMSAlertRec(SMSAlert smsAlertRecord,final SMSAlertKey smsAlertKey)
			throws UpdateFailedException;
	SMSAlert selectSMSAlertRec(final SMSAlertKey alertKey)throws NoDataFoundException;
}
