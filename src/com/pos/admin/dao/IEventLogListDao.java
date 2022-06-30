package com.pos.admin.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface IEventLogListDao {
	public List<EventLog> getEventLogList(EventLogKey eventLogKey) throws NoDataFoundException;

}
