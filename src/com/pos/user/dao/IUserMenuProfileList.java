package com.pos.user.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface IUserMenuProfileList {
	public List<String> selectMenuProfile(String instid, String branchId)
			throws NoDataFoundException;
}
