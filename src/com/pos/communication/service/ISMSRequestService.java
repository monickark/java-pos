package com.pos.communication.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.exceptions.util.TableNotSpecifiedForAuditException;
import com.pos.communication.controller.SMSHistoryMasterVO;
import com.pos.communication.controller.SMSRequestVO;
import com.pos.communication.dao.SMSListKey;
import com.pos.communication.dao.SMSMemberList;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.framework.sessCache.UserSessionDetails;

public interface ISMSRequestService {
	public List<SMSMemberList> getSpecificMemberList(UserSessionDetails userSessiondetails,String genGroup,String speGroup)throws NoDataFoundException;
	public void saveSMSRequest(UserSessionDetails userSessiondetails,SMSRequestVO smsRequestVo,String[] specificMembList,ApplicationCache applicationCache)throws  DatabaseException, DuplicateEntryException, NoDataFoundException, UpdateFailedException, TableNotSpecifiedForAuditException;
	public SMSHistoryMasterVO selectSMSRequestList(
			SMSHistoryMasterVO smsHistoryMasterVO,
			UserSessionDetails usersessiondetails) throws NoDataFoundException;
	public SMSHistoryMasterVO selectSMSDetailsList(
			SMSHistoryMasterVO smsHistoryMasterVO,
			UserSessionDetails usersessiondetails) throws NoDataFoundException;
}
