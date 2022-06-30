package com.pos.communication.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface ISMSRequestListDAO {
	public List<SMSRequest> getSMSRequestList(final SMSRequestListKey smsRequestListKey)
			throws NoDataFoundException;
}
