package com.pos.batch.service;

import javax.servlet.ServletContext;

import com.pos.batch.controller.FileTransferVO;
import com.pos.common.exceptions.DatabaseException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.UserSessionDetails;

public interface IFileTranDBToDiskService {
	public String tranferingFilesToDisk(FileTransferVO fileTransferVO,UserSessionDetails userSessionDetails,
			ServletContext servletContext,ApplicationCache applicationCache) throws DatabaseException;
	

}
