package com.pos.framework.seqGen.dao;

import com.pos.common.exceptions.DatabaseException;
import com.pos.framework.sessCache.UserSessionDetails;

//Interface for BatchIdGeneratorDao & SimpleIdGeneratorDao

public interface ICustIdGeneratorDao {

		int getIdForSequence(String key, UserSessionDetails userSessionDetails)
			throws DatabaseException;

}
