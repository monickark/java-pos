package com.pos.admin.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface IBranchMasterListDAO {

	List<BranchMasterList> getBranchMasterList(final String instId)
			throws NoDataFoundException;

}
