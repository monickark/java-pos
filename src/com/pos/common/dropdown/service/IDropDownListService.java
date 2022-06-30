package com.pos.common.dropdown.service;

import java.util.Map;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.sessCache.UserSessionDetails;

public interface IDropDownListService {

	public Map<String, String> getBranchListTag(
			final UserSessionDetails userSessionDetails)
			throws NoDataFoundException;

	Map<String, String> selectMenuProfileList(String profileGroup,
			UserSessionDetails userSessionDetails) throws NoDataFoundException;

	Map<String, String> selectAdminUserList() throws NoDataFoundException;
}
