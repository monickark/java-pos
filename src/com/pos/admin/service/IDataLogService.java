package com.pos.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pos.admin.controller.DataLogDetailsVO;
import com.pos.admin.controller.DataLogListVO;
import com.pos.admin.controller.DataLogSearchVO;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.UserSessionDetails;

public interface IDataLogService {

	public List<DataLogListVO> selectListOfAuditRecords(
			DataLogSearchVO dataLogSearchVO,
			UserSessionDetails userSessionDetails) throws NoDataFoundException;

	public Map<String, ArrayList<String>> getDataLogRecFromListRec(
			DataLogListVO dataLogListVO, DataLogDetailsVO dataLogVO,
			UserSessionDetails userSessionDetails,
			ApplicationCache applicationCache) throws NoDataFoundException;

	public Map<String,ArrayList<String>> getTableKey(DataLogDetailsVO dataLog,ApplicationCache applicationCache,
			UserSessionDetails userSessionDetails) throws NoDataFoundException;

}
