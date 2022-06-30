package com.pos.sale.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.customer.controller.CustomerVO;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.sale.controller.PosVO;
import com.pos.sale.controller.SalesVO;

public interface ISaleInfoService {

	CustomerVO insertSaleInfo(List<PosVO> saleInfoVOs, SalesVO salesVo,
			CustomerVO customerVO, HttpSession session,
			SessionCache sessionCache, ApplicationCache applicationCahce)
			throws NoDataFoundException, DuplicateEntryException,
			DatabaseException;

	Map<String, String> getCustomer() throws NoDataFoundException;

	List<PosVO> getInfo(String invoiceNo) throws NoDataFoundException;

}
