package com.pos.batch.dao;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.exceptions.batch.NoRecordFoundException;

//Interface for BatchList dao
public interface IBatchPgmsRecordDao {
	
	public BatchPgms retrieveBatchPgmsRec(BatchPgmsKey batchPgmsKey) throws NoRecordFoundException;
	public void insertBatchPgmRec(final BatchPgms batchPgms) throws DuplicateEntryException;
	public void updateBatchPgmRec(final BatchPgmsKey batchPgmsKey, final BatchPgms batchPgms) throws UpdateFailedException;


}
