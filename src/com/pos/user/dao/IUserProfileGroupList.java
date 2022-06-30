package com.pos.user.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface IUserProfileGroupList {

	List<String> selectProfileGroup(String instid, String branchId,
			String userMenuProfile) throws NoDataFoundException;
}
