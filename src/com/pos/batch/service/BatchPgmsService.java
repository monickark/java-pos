package com.pos.batch.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.batch.controller.BatchDataUploadVO;
import com.pos.batch.controller.ExportTemplateVO;
import com.pos.batch.dao.BatchPgms;
import com.pos.batch.dao.BatchPgmsKey;
import com.pos.batch.dao.IBatchPgmsRecordDao;
import com.pos.common.batch.util.ExcelUtils;
import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.exceptions.batch.NoRecordFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.framework.sessCache.UserSessionDetails;

@Service
public class BatchPgmsService implements IBatchPgmsService {
	//Logging
		Logger logger = Logger.getLogger(BatchPgmsService.class);
	@Autowired
	IBatchPgmsRecordDao batchPgmsRecDao;
	@Autowired
	CommonBusiness commonBusiness;	
	
	@Override

	//Method to get the BatchPgms record for ImportData 
	public BatchPgms getBatchPgmsRec(ExportTemplateVO importDataVO,UserSessionDetails usrSession)
			throws NoRecordFoundException {		
		logger.info("Get the BatchPgms Record for ImportDataVO");
		if((importDataVO.getInstId()).equals("")){
			
			importDataVO.setInstId(usrSession.getInstId());
		}
			
		if((importDataVO.getBranchId()).equals("")){
			
			importDataVO.setBranchId(usrSession.getBranchId());
		}	
		BatchPgmsKey batchPgmKey = new BatchPgmsKey();
		commonBusiness.changeObject(batchPgmKey, importDataVO);	
		BatchPgms batchList =  batchPgmsRecDao.retrieveBatchPgmsRec(batchPgmKey);		
		return batchList;
	}
	
//Method to get the BatchPgms Rec for EXportData
	@Override
	public BatchPgms getBatchPgmsRec(BatchDataUploadVO exportDataVo)
			throws NoRecordFoundException {
		logger.info("Get the BatchPgms Record for ExportDataVO");
		BatchPgmsKey batchPgmKey = new BatchPgmsKey();
		commonBusiness.changeObject(batchPgmKey, exportDataVo);	
		BatchPgms batchList =  batchPgmsRecDao.retrieveBatchPgmsRec(batchPgmKey);
		return batchList;
	}
	
		
	
		

}
