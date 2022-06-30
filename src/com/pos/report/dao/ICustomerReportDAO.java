package com.pos.report.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.customer.dao.Customer;

public interface ICustomerReportDAO {

	List<Customer> selectCustomerReport() throws NoDataFoundException;

}
