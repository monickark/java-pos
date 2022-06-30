package com.pos.batch.service;

import java.util.List;

import com.pos.batch.controller.BatchStatusSearchVO;
import com.pos.batch.controller.BatchStatusVO;
import com.pos.batch.controller.ExportTemplateVO;
import com.pos.batch.dao.BatchPgms;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.batch.NoRecordFoundException;
import com.pos.framework.sessCache.UserSessionDetails;


//Interface for the BatchStatus service 
public interface IBatchStatusService {
	
	public List<BatchStatusVO> getBatchStatusList(BatchStatusSearchVO batchStatusVO,UserSessionDetails userSessionDetails) throws NoDataFoundException;
	public BatchStatusVO getBatchStatusRecord(BatchStatusSearchVO batchStatysVO,UserSessionDetails userSessionDetails,String batchSrlNo) throws NoRecordFoundException;
	public BatchStatusVO getBatchStatusRecord(BatchStatusSearchVO batchStatysVO) throws NoRecordFoundException;	
	public BatchPgms getBatchPgmRec(ExportTemplateVO exportDataVO,UserSessionDetails usrSession) throws NoRecordFoundException;
	

}
