package com.pos.till.dao;

import java.util.List;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;

public interface ITillDAO {

	void addTill(Till till) throws DuplicateEntryException;

	List<Till> selectTill() throws NoDataFoundException;

	Till selectTillObj() throws NoDataFoundException;

	void updateTill(String status);

}
