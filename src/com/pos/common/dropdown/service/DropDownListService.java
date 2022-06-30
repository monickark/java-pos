package com.pos.common.dropdown.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

	
import com.pos.admin.dao.BranchMaster;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.PropertyManagementConstant;
import com.pos.common.dropdown.dao.IBranchListDAO;
import com.pos.common.dropdown.dao.IMenuProfileListDAO;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.common.util.PropertyManagementUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.framework.sessCache.UserSessionDetails;


//Service Class for Simple Sequence Generation

@Service
public class DropDownListService implements IDropDownListService {

	@Autowired
	IBranchListDAO branchListTag;
	@Autowired
	IMenuProfileListDAO menuProfileListDAO;
	@Autowired
	PropertyManagementUtil propertyManagementUtil;
	// Logging
	Logger logger = Logger.getLogger(DropDownListService.class);

	@Override
	public Map<String, String> getBranchListTag(
			final UserSessionDetails userSessionDetails)
			throws NoDataFoundException {
		List<BranchMaster> branchMasters = branchListTag
				.selectBranchList(userSessionDetails);
		Map<String, String> branchMap = new LinkedHashMap<String, String>();
		for (BranchMaster branchMaster : branchMasters) {
			branchMap.put(branchMaster.getBranchId(),
					branchMaster.getBranchName());
		}
		return branchMap;

	}


	@Override
	public Map<String, String> selectMenuProfileList(String profileGroup,
			UserSessionDetails userSessionDetails) throws NoDataFoundException {
		return menuProfileListDAO.selectMenuProfileList(
				userSessionDetails.getInstId(),
				userSessionDetails.getBranchId(), profileGroup);

	}
	
	@Override
	public Map<String, String> selectAdminUserList() throws NoDataFoundException {
		return menuProfileListDAO.selectAdminUserList();

	}

}
