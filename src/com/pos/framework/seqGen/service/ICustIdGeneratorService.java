package com.pos.framework.seqGen.service;

import com.pos.common.exceptions.DatabaseException;
import com.pos.framework.sessCache.UserSessionDetails;

//Interface for BatchIdGeneratorService & SimpleIdGeneratorService
public interface ICustIdGeneratorService {

	Integer getNextId(String key, int granularity,
			UserSessionDetails userSessionDetails) throws DatabaseException;

}
