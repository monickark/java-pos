package com.pos.report.service;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.customer.controller.CustomerVO;

public interface ICustomerReportService {

	List<CustomerVO> selectCustomer(CustomerVO customerVO) throws NoDataFoundException;

}
