package com.pos.communication.dao;

import java.util.List;

import com.pos.common.exceptions.DuplicateEntryException;

public interface ISMSAlertListDAO {
	public void insertSMSAlertListRecs(
			final List<SMSAlert> smsAlertList) throws DuplicateEntryException;
}
