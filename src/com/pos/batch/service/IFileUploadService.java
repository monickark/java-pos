package com.pos.batch.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletContext;

import com.pos.batch.controller.BatchDataUploadVO;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.FileNotSaveException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.batch.DataIntegrityException;
import com.pos.common.exceptions.batch.ExcelRejectException;
import com.pos.common.exceptions.batch.InValidCellValue;
import com.pos.common.exceptions.batch.NoRecordFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.UserSessionDetails;

public interface IFileUploadService {
	public String fileupload(String fileExtn, BatchDataUploadVO fileVO,
			ApplicationCache applicationCache, ServletContext servletContext,
			UserSessionDetails userSessionDetails, String dataType)
			throws IllegalAccessException, InvocationTargetException,
			IOException, InValidCellValue, DataIntegrityException,
			DuplicateEntryException, DatabaseException, NoRecordFoundException,
			ExcelRejectException, NoDataFoundException, FileNotSaveException;
}
