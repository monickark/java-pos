package com.pos.customer.service;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.customer.controller.CustomerVO;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;

public interface ICustomerService {

	void addCustomer(CustomerVO customerVO, SessionCache sessionCache, ApplicationCache applicationCache) throws DatabaseException, DuplicateEntryException;

	CustomerVO getCustomer(String customerId) throws NoDataFoundException;

}
