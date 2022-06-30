package com.pos.batch.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pos.batch.controller.BatchDataUploadVO;
import com.pos.batch.controller.ExportTemplateVO;
import com.pos.batch.dao.BatchPgms;
import com.pos.common.exceptions.batch.NoRecordFoundException;
import com.pos.framework.sessCache.SessionCache;
import com.pos.framework.sessCache.UserSessionDetails;


public interface IBatchPgmsService {
	
	public BatchPgms getBatchPgmsRec(ExportTemplateVO importDataVo,UserSessionDetails usrSession)  throws NoRecordFoundException;
	public BatchPgms getBatchPgmsRec(BatchDataUploadVO exportDataVo) throws NoRecordFoundException;	
//	public void generateExcel(String createtemp,ExportTemplateVO exportDataVO,SessionCache sessionCache,HttpSession session,HttpServletResponse response) throws NoRecordFoundException, IOException;

}
