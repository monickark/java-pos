package com.pos.sale.service;

import java.util.List;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.sale.controller.TradeinVO;

public interface ITradeinListService {

	List<TradeinVO> selectTradeinList(TradeinVO tradeinVO) throws NoDataFoundException, DuplicateEntryException;

	TradeinVO selectTradein(TradeinVO tradeinVO) throws NoDataFoundException;

	String selectTradeinSign(String imei) throws NoDataFoundException;

}
