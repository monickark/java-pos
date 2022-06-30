package com.pos.batch.service;

import java.io.IOException;

import javax.servlet.ServletContext;

import com.pos.batch.controller.BatchFileUploadVO;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.FileNotSaveException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.UserSessionDetails;

public interface IBatchFileUploadService {
	public String batchFileInsert(final BatchFileUploadVO batchFileUpload,final UserSessionDetails userSessionDetails,
			ApplicationCache applicationCache,String profileGrp,ServletContext servletContext) throws DatabaseException, IllegalStateException, IOException, FileNotSaveException;	
}
