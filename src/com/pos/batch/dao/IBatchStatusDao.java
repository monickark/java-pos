package com.pos.batch.dao;


import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.batch.NoRecordFoundException;

//Interface for BatchStatus Dao class
public interface IBatchStatusDao {
	
	public void insertBatchStatus(BatchStatus batchStatus) throws DatabaseException;		
	public void updateBatchStatus(BatchStatus batchStatus,
			BatchStatusKey batchStatusKey);		
	public BatchStatus retrieveBatchStatusRec(String batchId) throws NoRecordFoundException;
	

}
