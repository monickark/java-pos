package com.pos.sale.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.common.business.CommonBusiness;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.sale.controller.TradeinVO;

import com.pos.sale.dao.ITradeinListDAO;
import com.pos.sale.dao.Tradein;

@Service
public class TradeinListService implements ITradeinListService{

	@Autowired
	CommonBusiness commonBusiness;
	@Autowired
	ITradeinListDAO tradeinListDAO;
	@Override
	public List<TradeinVO> selectTradeinList(TradeinVO tradeinVO) throws NoDataFoundException, DuplicateEntryException{
		List<TradeinVO> tradeinVOs = new ArrayList<TradeinVO>();
		Tradein tradein = new Tradein();
		commonBusiness.changeObject(tradein, tradeinVO);

		List<Tradein> tradeins = tradeinListDAO
				.selectTradein();

		for (Tradein tradein2 : tradeins) {
			TradeinVO tradeinVO2 = new TradeinVO();
			commonBusiness.changeObject(tradeinVO2, tradein2);
			if(tradein2.getDelFlg().equals("Y")){
				tradeinVO2.setStatus("Sold");
			}else{
				tradeinVO2.setStatus("In Stock");
			}			
			tradeinVOs.add(tradeinVO2);
		}

		return tradeinVOs;
	}
	
	@Override
	public TradeinVO selectTradein(TradeinVO tradeinVO) throws NoDataFoundException{
		Tradein tradein = new Tradein();
		commonBusiness.changeObject(tradein, tradeinVO);

		tradein = tradeinListDAO.selectTradein(tradein);
		commonBusiness.changeObject(tradeinVO, tradein);

		return tradeinVO;
	}
	
	@Override
	public String selectTradeinSign(String imei)throws NoDataFoundException{
		String image = tradeinListDAO.selectTradeinSign(imei);
		System.out.println("Image"+image);
		return image;
	}

}
