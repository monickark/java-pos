package com.pos.report.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.common.business.CommonBusiness;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.customer.controller.CustomerVO;
import com.pos.customer.dao.Customer;
import com.pos.report.controller.SalesReportVO;
import com.pos.report.dao.ICustomerReportDAO;
import com.pos.report.dao.SalesReport;

@Service
public class CustomerReportService implements ICustomerReportService{

	@Autowired
	ICustomerReportDAO customerReportDAO;
	@Autowired
	private CommonBusiness commonBussiness;
	
	@Override
	public List<CustomerVO> selectCustomer(CustomerVO customerVO)throws NoDataFoundException {
	
		List<CustomerVO> customerVOs = new ArrayList<CustomerVO>();
		Customer customer = new Customer();
		commonBussiness.changeObject(customer, customerVO);

		List<Customer> customers = customerReportDAO.selectCustomerReport();

		for (Customer customer2 : customers) {
			CustomerVO CustomerVO2 = new CustomerVO();
			commonBussiness.changeObject(CustomerVO2, customer2);
			customerVOs.add(CustomerVO2);
		}
		return customerVOs;
	}

}
