package com.pos.report.dao;

import com.pos.common.exceptions.DuplicateEntryException;

public interface IRefundDAO {

	void insertRefund(ProductReport productReport)
			throws DuplicateEntryException;

}
