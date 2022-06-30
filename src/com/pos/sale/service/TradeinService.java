package com.pos.sale.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.SequenceConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.util.AlphaSequenceUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.SessionCache;
import com.pos.sale.controller.TradeinVO;
import com.pos.sale.dao.ITradeinDAO;
import com.pos.sale.dao.Tradein;
@Service
public class TradeinService implements ITradeinService {

	@Autowired
	ITradeinDAO tradeinDAO;
	@Autowired
	CommonBusiness commonBusiness;
	@Autowired
	@Qualifier(value = "simpleIdGenerator")
	IIdGeneratorService simpleIdGenerator;
	@Override
	public void addTradein(TradeinVO tradeinVO, SessionCache sessionCache, ApplicationCache applicationCache,HttpSession session)
			throws DatabaseException, DuplicateEntryException{
		Integer sequence = simpleIdGenerator.getNextId(SequenceConstant.TRADEIN_SEQUENCE, 1);
		String t_invoiceIdSequence = AlphaSequenceUtil.generateAlphaSequence(ApplicationConstant.STRING_TRADEIN_SEQ,
				sequence);
		 Calendar cal = Calendar.getInstance();
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		 String invoiceDate=dateFormat.format(cal.getTime());
		tradeinVO.setInvoiceDate(invoiceDate);
		tradeinVO.setT_invoiceId(t_invoiceIdSequence);
		Tradein tradein = new Tradein();
		commonBusiness.changeObject(tradein,tradeinVO);
		tradein.setDbTs(1);
		tradein.setDelFlg("N");
		tradein.setrCreId(sessionCache.getUserSessionDetails().getUserId());
		tradein.setrModId(sessionCache.getUserSessionDetails().getUserId());
		session.setAttribute("tradeinVO", tradeinVO);
		tradeinDAO.addTradein(tradein);
	}
	
	@Override
	public TradeinVO selectTradein(TradeinVO tradeinVO) throws NoDataFoundException{
		Tradein tradein = new Tradein();
		commonBusiness.changeObject(tradein, tradeinVO);

		tradein = tradeinDAO.selectTradein(tradein);
		commonBusiness.changeObject(tradeinVO, tradein);

		return tradeinVO;
	}
	
	
	@Override
	public void addTradeinSale(String imei, String image)
			throws DatabaseException, DuplicateEntryException{
			
		tradeinDAO.addTradeinSign(imei, image);
	}


}
