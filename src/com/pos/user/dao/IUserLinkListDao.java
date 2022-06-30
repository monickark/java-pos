package com.pos.user.dao;

import java.util.List;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;

public interface IUserLinkListDao {

	public void insertListOfUserLinkRec(List<UserLink> listOfUserLink)
			throws DuplicateEntryException;

	public List<UserLink> getListOfUserLinkRecords(UserLinkKey userLinkKey)
			throws NoDataFoundException;

}
