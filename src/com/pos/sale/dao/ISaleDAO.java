package com.pos.sale.dao;

import com.pos.common.exceptions.NoDataFoundException;

public interface ISaleDAO {

	PosPurchaseList selectSale(PosPurchaseList posPurchaseList) throws NoDataFoundException;

}
