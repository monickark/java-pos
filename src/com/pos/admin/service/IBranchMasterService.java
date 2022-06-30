package com.pos.admin.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import com.pos.admin.controller.BranchMasterListVO;
import com.pos.admin.controller.BranchMasterVO;
import com.pos.admin.dao.BranchMaster;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DeleteFailedException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.FileNotFoundInDatabase;
import com.pos.common.exceptions.FileNotSaveException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.exceptions.util.TableNotSpecifiedForAuditException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;

public interface IBranchMasterService {

	public void insertIntoBranchMaster(ApplicationCache applicationCahce,
			BranchMasterVO branchVO, SessionCache session,ServletContext servletContext)
			throws DuplicateEntryException, DatabaseException,
			TableNotSpecifiedForAuditException, IllegalStateException, IOException, DeleteFailedException, FileNotSaveException;

	public BranchMaster selectBranchMasterRecord(
			BranchMasterListVO branchMasterListVO,
			BranchMasterVO branchMasterVORecord, SessionCache sessionCache)
			throws NoDataFoundException;

	List<BranchMasterListVO> selectBranchMasterList(String instId)
			throws NoDataFoundException;

	public void updateBranchMaster(BranchMasterListVO oldRec,
			ApplicationCache applicationCache, BranchMasterVO branchMasterVo,
			SessionCache sessionCache,ServletContext servletContext) throws NoDataFoundException,
			UpdateFailedException, DuplicateEntryException,
			FileNotFoundInDatabase, DatabaseException,
			TableNotSpecifiedForAuditException, IllegalStateException, IOException, DeleteFailedException, FileNotSaveException;

	public void deleteBranchMaster(ApplicationCache applicationCache,
			BranchMasterListVO branchMasterVoRecord, SessionCache sessionCache)
			throws NoDataFoundException, DeleteFailedException,
			DuplicateEntryException, DatabaseException,
			TableNotSpecifiedForAuditException;

	public BranchMasterListVO selectBranchMasterRecordAfterUpdate(
			BranchMasterVO branchMasterVO, SessionCache sessionCache)
			throws NoDataFoundException;

}
