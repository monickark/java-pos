package com.pos.sale.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.common.business.CommonBusiness;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.sale.controller.PosVO;
import com.pos.sale.controller.SalesVO;
import com.pos.sale.dao.ISaleDAO;
import com.pos.sale.dao.ISalesDAO;
import com.pos.sale.dao.PosPurchaseList;
import com.pos.sale.dao.Sales;
@Service
public class SaleService implements ISaleService {

	@Autowired
	ISaleDAO saleDAO;
	@Autowired
	ISalesDAO salesDAO;
	@Autowired
	CommonBusiness commonBusiness;
	
	Logger logger = Logger.getLogger(SaleService.class.getName());
	
	public PosVO sale(PosVO posVO) throws DatabaseException, DuplicateEntryException, NoDataFoundException{
		
		PosPurchaseList posPurchaseList = new PosPurchaseList();
		commonBusiness.changeObject(posPurchaseList, posVO);
		posPurchaseList = saleDAO.selectSale(posPurchaseList);
		commonBusiness.changeObject(posVO,posPurchaseList);
		return posVO;
	}
	@Override
	public SalesVO getSales(String invoiceNo) throws NoDataFoundException {
		Sales sales = salesDAO.getSales(invoiceNo);
		SalesVO salesVO = new SalesVO();
		commonBusiness.changeObject(salesVO, sales);
		
		return salesVO;
	}
}
