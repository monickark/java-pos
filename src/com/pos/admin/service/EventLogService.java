package com.pos.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.admin.controller.EventLogListVO;
import com.pos.admin.controller.EventLogSearchVO;
import com.pos.admin.dao.EventLog;
import com.pos.admin.dao.EventLogKey;
import com.pos.admin.dao.IEventLogListDao;
import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.sessCache.UserSessionDetails;

@Service
public class EventLogService implements IEventLogService {
	Logger logger = Logger.getLogger(EventLogService.class);
	@Autowired
	IEventLogListDao eventLogListDao;
	@Autowired
	CommonBusiness commonBusiness;

	@Override
	public List<EventLogListVO> selectListOfAuditEventLogRecords(
			EventLogSearchVO eventLogSearchVO,
			UserSessionDetails userSessionDetails) throws NoDataFoundException {
		
		logger.info("In Service,Going to select List of Event Log Records");
		Integer i = 0;
		if (eventLogSearchVO.getBranchId().equals(ApplicationConstant.INSP)) {
			eventLogSearchVO.setBranchId(userSessionDetails.getBranchId());
		}
		EventLogKey eventLogKey = new EventLogKey();
		List<EventLogListVO> eventLogListVOList = new ArrayList<EventLogListVO>();
		commonBusiness.changeObject(eventLogKey, eventLogSearchVO);
		eventLogKey.setInstId(userSessionDetails.getInstId());
		eventLogKey.setAuditFlg(ApplicationConstant.EVENT_LOG_CONSTANT);
		List<EventLog> eventLogList = eventLogListDao
				.getEventLogList(eventLogKey);
		for (EventLog eventLog : eventLogList) {
			EventLogListVO eventLogListVo = new EventLogListVO();
			commonBusiness.changeObject(eventLogListVo, eventLog);
			eventLogListVo.setRowid(i.toString());
			eventLogListVOList.add(eventLogListVo);
			i++;
		}
			
		return eventLogListVOList;
	}

}
