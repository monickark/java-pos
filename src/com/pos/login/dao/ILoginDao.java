package com.pos.login.dao;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.user.dao.User;

public interface ILoginDao {
	public boolean insertLogin(User user) throws DuplicateEntryException;

	public void deleteLogin(String branchId, String instId, String userId);
}
