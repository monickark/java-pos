package com.pos.communication.dao;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.communication.controller.SMSRequestVO;

public interface ISMSRequestDAO {
public void saveSMSRequestRecord(SMSRequest smsRequest)throws DuplicateEntryException;
public void updateSMSRequestStatus(SMSRequest smsRequest,final SMSRequestKey smsRequestKey)throws UpdateFailedException;
SMSRequest selectSMSRequestRec(final SMSRequestKey smsRequestKey)	throws NoDataFoundException;
}
