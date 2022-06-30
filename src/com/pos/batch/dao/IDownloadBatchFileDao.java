package com.pos.batch.dao;

import java.util.List;

import com.pos.common.exceptions.FileNotFoundInDatabase;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.files.dao.FileMaster;

public interface IDownloadBatchFileDao {
	public List<FileMaster> downloadFile(DownloadFileKey downloadFileKey) throws NoDataFoundException ;

}
