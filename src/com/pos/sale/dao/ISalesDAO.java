package com.pos.sale.dao;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;

public interface ISalesDAO {

	

	void insertSales(Sales sales) throws DuplicateEntryException;

	Sales getSales(String invoiceNo) throws NoDataFoundException;

}
