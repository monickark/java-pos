package com.pos.admin.service;

import java.util.List;

import com.pos.admin.controller.EventLogListVO;
import com.pos.admin.controller.EventLogSearchVO;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.sessCache.UserSessionDetails;

public interface IEventLogService {
	public List<EventLogListVO> selectListOfAuditEventLogRecords(
			EventLogSearchVO eventLogSearchVO,
			UserSessionDetails userSessionDetails) throws NoDataFoundException;
}
