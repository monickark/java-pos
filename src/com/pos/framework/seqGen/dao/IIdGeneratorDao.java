package com.pos.framework.seqGen.dao;

import com.pos.common.exceptions.DatabaseException;

//Interface for BatchIdGeneratorDao & SimpleIdGeneratorDao

public interface IIdGeneratorDao {

	public int getIdForSequence(String key) throws DatabaseException;

}
