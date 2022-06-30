package com.pos.sale.service;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.sale.controller.PosVO;
import com.pos.sale.controller.SalesVO;

public interface ISaleService {

	PosVO sale(PosVO posVO) throws DatabaseException, DuplicateEntryException, NoDataFoundException;

	SalesVO getSales(String invoiceNo) throws NoDataFoundException;

}
