package com.pos.sale.dao;

import java.util.List;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;

public interface ITradeinListDAO {

	List<Tradein> selectTradein() throws DuplicateEntryException;

	Tradein selectTradein(Tradein tradein) throws NoDataFoundException;

	String selectTradeinSign(String imei) throws NoDataFoundException;

}
