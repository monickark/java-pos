package com.pos.batch.service;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.batch.controller.FileTransferVO;
import com.pos.batch.dao.BatchStatus;
import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.SequenceConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.UserSessionDetails;
@Service
public class FileTranDBToDiskService implements IFileTranDBToDiskService {
	
	@Autowired
	IIdGeneratorService simpleIdGenerator;
	@Autowired
	FileTransferHelper fileTransferHelper;
	@Autowired
	BatchHelper batchHelper;
	@Autowired
	CommonBusiness commonBusiness;
	
	
	@Override
	public String tranferingFilesToDisk(FileTransferVO fileTransferVO,UserSessionDetails userSessionDetails,
			ServletContext servletContext,ApplicationCache applicationCache) throws DatabaseException{
		
		BatchStatus batchStatus = new BatchStatus();
		fileTransferVO.setInstId(userSessionDetails.getInstId());
		commonBusiness.changeObject(batchStatus, fileTransferVO);
		
		final String batchSerialNo = simpleIdGenerator.getNextId(
				SequenceConstant.BATCH_SERIAL_SEQUENCE, 1).toString();	
		
		batchHelper.initializeBatch(batchStatus,batchSerialNo,userSessionDetails,fileTransferVO.getTypeOfOpt());
		
		if(fileTransferVO.getTypeOfOpt().equals(ApplicationConstant.DB_TO_DISK_CONSTANT)){
			fileTransferHelper.transferFileFromDBToDisk(fileTransferVO.getInstId(),fileTransferVO.getBranchId(),servletContext,
					applicationCache,userSessionDetails, batchSerialNo);
		}else if(fileTransferVO.getTypeOfOpt().equals(ApplicationConstant.DISK_TO_DB_CONSTANT)){		
			fileTransferHelper.transferFileFromDiskToDB(fileTransferVO.getInstId(),fileTransferVO.getBranchId(),servletContext,
					applicationCache,userSessionDetails, batchSerialNo);
		}
		
		
		
		return batchSerialNo;
		
		
	}
}
