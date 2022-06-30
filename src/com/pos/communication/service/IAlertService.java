package com.pos.communication.service;

import java.util.List;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DeleteFailedException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.exceptions.util.TableNotSpecifiedForAuditException;
import com.pos.communication.controller.AlertMasterVO;
import com.pos.communication.controller.AlertVO;
import com.pos.communication.dao.AlertListKey;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.UserSessionDetails;

public interface IAlertService {
	void insertAlertDetailsRec(AlertMasterVO alertMasterVO,
			UserSessionDetails userSessionDetails) throws
			 DatabaseException, DuplicateEntryException, NoDataFoundException, UpdateFailedException;
	
	void updateAlertDetailsRec(AlertVO alertVo,
			UserSessionDetails userSessionDetails,ApplicationCache applicationCache) throws UpdateFailedException, DuplicateEntryException, DatabaseException, TableNotSpecifiedForAuditException, NoDataFoundException;
	
	void deleteAlertDetailsRec(AlertVO alertVo,
			UserSessionDetails userSessionDetails,ApplicationCache applicationCache) throws DeleteFailedException,
			NoDataFoundException, DuplicateEntryException, DatabaseException, TableNotSpecifiedForAuditException;
	void stopAlertDetailsRec(AlertVO alertVo,
			UserSessionDetails userSessionDetails,ApplicationCache applicationCache) throws UpdateFailedException, DuplicateEntryException, DatabaseException, TableNotSpecifiedForAuditException, NoDataFoundException;
	void selectAlertList(AlertMasterVO alertMasterVO,
			UserSessionDetails userSessionDetails) throws NoDataFoundException;
	List<AlertVO> selectAlertListForDashBoard(AlertListKey alertListKey,UserSessionDetails userSessionDetails) throws NoDataFoundException;
}
