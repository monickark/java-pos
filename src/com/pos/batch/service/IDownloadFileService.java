package com.pos.batch.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import com.pos.batch.controller.DownLoadFileVO;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.UserSessionDetails;

public interface IDownloadFileService {
public List<DownLoadFileVO> downloadFile(DownLoadFileVO downloadFile,UserSessionDetails userSessionDetails,
		ApplicationCache applicationCache,ServletContext servletContext,String profileGrp) throws NoDataFoundException, FileNotFoundException, IOException;
}
