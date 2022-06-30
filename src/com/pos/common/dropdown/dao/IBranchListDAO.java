package com.pos.common.dropdown.dao;

import java.util.List;

import com.pos.admin.dao.BranchMaster;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.sessCache.UserSessionDetails;

public interface IBranchListDAO {

	List<BranchMaster> selectBranchList(final UserSessionDetails userSessionDetails) throws NoDataFoundException;

}
