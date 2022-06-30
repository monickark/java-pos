package com.pos.batch.service;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.batch.controller.BatchFileUploadVO;
import com.pos.batch.dao.BatchStatus;
import com.pos.batch.dao.IBatchStatusDao;
import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.SequenceConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.FileNotSaveException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.UserSessionDetails;
@Service
public class BatchFileUploadService implements IBatchFileUploadService {
	Logger logger = Logger.getLogger(BatchFileUploadService.class);
@Autowired
CommonBusiness commonBusiness;
@Autowired
IIdGeneratorService simpleIdGenerator;
@Autowired
IBatchStatusDao batchStatusDao;

@Autowired
BatchHelper batchHelper;
@Autowired
BatchFileUploadHelper batchFileUplfHelper;
	@Override
	public String batchFileInsert(final BatchFileUploadVO batchFileUpload,final UserSessionDetails userSessionDetails,
			ApplicationCache applicationCache,String profileGrp,ServletContext servletContext) throws DatabaseException, IllegalStateException, IOException, FileNotSaveException {
		
		
		BatchStatus batchStatus = new BatchStatus();

		//Check Branch Name for Institute Specific
		if(batchFileUpload.getBranchId().equals("Institute Specified")){
			batchFileUpload.setBranchId(userSessionDetails.getInstId());
		}
			
		commonBusiness.changeObject(batchStatus, batchFileUpload);
		
		final String batchSerialNo = simpleIdGenerator.getNextId(
				SequenceConstant.BATCH_SERIAL_SEQUENCE, 1).toString();	
		
		batchHelper.initializeBatch(batchStatus,batchSerialNo,userSessionDetails,ApplicationConstant.BATCH_PGMS_FILE_IMPORT);
		
		//Batch of files upload using thread
		batchFileUplfHelper.uploadBatchOfFiles(batchFileUpload, batchSerialNo, userSessionDetails, applicationCache, batchStatus,profileGrp,servletContext);
			
		return batchSerialNo;
		
	}
	

}
