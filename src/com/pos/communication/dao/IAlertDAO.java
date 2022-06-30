package com.pos.communication.dao;

import com.pos.common.exceptions.DeleteFailedException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;

public interface IAlertDAO {
	void insertAlertRec(Alert alertRecord)
			throws DuplicateEntryException;

	void updateAlertRec(Alert alertRecord,final AlertKey alertKey)
			throws UpdateFailedException;

	void deleteAlertRec(Alert alertRecord,final AlertKey alertKey) throws DeleteFailedException;
	void stopAlertRec(Alert alertRecord,final AlertKey alertKey) throws UpdateFailedException;

	Alert selectAlertRec(
			final AlertKey alertKey)
			throws NoDataFoundException;
}
