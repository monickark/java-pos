package com.pos.framework.seqGen.service;

import com.pos.common.exceptions.DatabaseException;

//Interface for BatchIdGeneratorService & SimpleIdGeneratorService
public interface IIdGeneratorService {

	public Integer getNextId(String key, int granularity)
			throws DatabaseException;

}
