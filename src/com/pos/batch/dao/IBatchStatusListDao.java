package com.pos.batch.dao;

import java.util.List;

import com.pos.batch.controller.BatchStatusSearchVO;
import com.pos.common.exceptions.NoDataFoundException;

//Interface for BatchStatusList dao
public interface IBatchStatusListDao {
	
	public List<BatchStatus> retrieveBatchStatus(BatchStatusSearchVO batchStatus) throws NoDataFoundException;
	
}
