package com.pos.admin.dao;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;

public interface IBranchMasterDAO {
	
	
	void insertBranchMasterDetails(BranchMaster code) throws DuplicateEntryException;

	void updateBranchMaster(BranchMaster code, BranchMasterKey codeKey) throws UpdateFailedException;

	BranchMaster selectBranchMaster(BranchMasterKey code) throws NoDataFoundException;

}
