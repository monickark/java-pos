package com.pos.communication.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface ISMSDetailsListDAO {
	public List<SMSDetails> getSMSDetailsList(final SMSDetailsKey smsDetailsKey)
			throws NoDataFoundException;
}
