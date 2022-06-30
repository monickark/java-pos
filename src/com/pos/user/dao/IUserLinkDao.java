package com.pos.user.dao;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.exceptions.login.InvalidUserIdException;

public interface IUserLinkDao {
	void insertUserLink(UserLink userLink) throws DuplicateEntryException;
	
	UserLink getUserDetails(String userId)
			throws InvalidUserIdException;
	
	UserLink getUserDetailsByLinkId(String linkId, String instId, String branchId)
			throws InvalidUserIdException;
	
	void updateUserLinkRec(UserLink userlink) throws UpdateFailedException;
}
