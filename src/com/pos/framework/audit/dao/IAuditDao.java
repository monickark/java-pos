package com.pos.framework.audit.dao;

import com.pos.admin.dao.DataLog;
import com.pos.admin.dao.DataLogKey;
import com.pos.common.exceptions.BatchUpdateFailedException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;

public interface IAuditDao {
	public void insert(Audit auditPojo) throws DuplicateEntryException;

	public DataLog getAuditRecord(DataLogKey dataLogKey)
			throws NoDataFoundException;

	int[] insertBatch(Audit auditPojo, String[] userId, String[] slNos)
			throws DuplicateEntryException, BatchUpdateFailedException;
}
