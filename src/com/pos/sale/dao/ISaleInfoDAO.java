package com.pos.sale.dao;

import java.util.List;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.customer.dao.Customer;
import com.pos.sale.controller.PosVO;

public interface ISaleInfoDAO {

	void insertSaleInfo(SaleInfo saleInfo) throws DuplicateEntryException;

	List<Customer> selectCustomer();
	
	Customer selectCustomerDetailsInvoice(String customerId);

	void insertOtherBrand(SaleInfo saleInfo) throws DuplicateEntryException;

	List<PosVO> getInfo(String invoiceNo) throws NoDataFoundException;

}
