package com.pos.sale.service;

import javax.servlet.http.HttpSession;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.sale.controller.TradeinVO;

public interface ITradeinService {

	void addTradein(TradeinVO tradeinVO, SessionCache sessionCache, ApplicationCache applicationCache
			,HttpSession session) throws DatabaseException, DuplicateEntryException;

	/*BufferedImage selectTradeinSign() throws NoDataFoundException;*/

	TradeinVO selectTradein(TradeinVO tradeinVO) throws NoDataFoundException;

	void addTradeinSale(String imei, String image) throws DatabaseException,
			DuplicateEntryException;

}
