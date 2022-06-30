package com.pos.sale.dao;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;

public interface ITradeinDAO {

	void addTradein(Tradein tradein) throws DuplicateEntryException;

	Tradein selectTradein(Tradein tradein) throws NoDataFoundException;

	void addTradeinSign(String imei, String sign)
			throws DuplicateEntryException;

	void deleteTradeInInventory(String imei, String rModId);

}
