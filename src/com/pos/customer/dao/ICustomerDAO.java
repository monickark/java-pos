package com.pos.customer.dao;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;

public interface ICustomerDAO {

	void addCustomer(Customer customer) throws DuplicateEntryException;

	Customer getCustomer(String customerId) throws NoDataFoundException;

}
