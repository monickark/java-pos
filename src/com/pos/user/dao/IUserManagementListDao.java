package com.pos.user.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface IUserManagementListDao {
	public List<UserManagement> selectUserManagementListFromUserManagement(
			UserManagement UserManagement) throws NoDataFoundException;
}
