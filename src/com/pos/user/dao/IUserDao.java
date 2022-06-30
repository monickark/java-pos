package com.pos.user.dao;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.exceptions.login.InvalidUserIdException;

public interface IUserDao {
	public User validateUserId(String string) throws InvalidUserIdException;

	public void updateUser(User l) throws UpdateFailedException;

	void insertSingleUser(User users) throws DuplicateEntryException;

	public void updatePassword(User user) throws UpdateFailedException;

}
