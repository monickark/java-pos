package com.pos.common.files.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;

import com.pos.common.exceptions.FileNotFoundInDatabase;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.files.dao.FileMaster;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.UserSessionDetails;

//Interface for FileMaster
@Service
public interface IFileMasterService {

	public FileMaster getFile(String instId, String branchId, String linkId,
			String type,String srlNo,ApplicationCache applicationCache,ServletContext servletContext) throws FileNotFoundInDatabase, FileNotFoundException, IOException;

	public List<FileMaster> getListOfFilesFileId(
			UserSessionDetails userSessionDetails, String linkId);

}
