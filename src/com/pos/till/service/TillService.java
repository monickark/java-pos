package com.pos.till.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

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
import com.pos.till.controller.TillVO;
import com.pos.till.dao.ITillDAO;
import com.pos.till.dao.Till;

@Service
public class TillService implements ITillService {
	@Autowired
	ITillDAO tillDAO;
	@Autowired
	@Qualifier(value = "simpleIdGenerator")
	IIdGeneratorService simpleIdGenerator;
	@Autowired
	CommonBusiness commonBusiness;

	Logger logger = Logger.getLogger(TillService.class.getName());

	@Override
	public void addTill(TillVO tillVO, SessionCache sessionCache,
			ApplicationCache applicationCache) throws DatabaseException,
			DuplicateEntryException {
		System.out.println("Till amount :" + tillVO);

		Integer sequence = simpleIdGenerator.getNextId(
				SequenceConstant.TILL_SEQUENCE, 1);
		String tillIdSequence = AlphaSequenceUtil.generateAlphaSequence(
				ApplicationConstant.STRING_TILL_SEQ, sequence);

		Till till = new Till();
		commonBusiness.changeObject(till, tillVO);
		till.setDbTs(1);
		till.setDelFlg("N");
		till.setTillId(tillIdSequence);
		till.setrCreId(sessionCache.getUserSessionDetails().getUserId());
		till.setrModId(sessionCache.getUserSessionDetails().getUserId());
		System.out.println("Till service :" + till);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();

		String creTime = dateFormat.format(cal.getTime());
		till.setrCreTime(creTime);

		String modTime = dateFormat.format(cal.getTime());
		till.setrModTime(modTime);

		String Date = dateFormat.format(cal.getTime());
		till.setDate(Date);

		tillDAO.addTill(till);
	}

	@Override
	public List<TillVO> selectTill(TillVO tillVO) throws NoDataFoundException {
		List<TillVO> tillVOs = new ArrayList<TillVO>();
		Till till = new Till();
		commonBusiness.changeObject(till, tillVO);

		List<Till> tills = tillDAO.selectTill();
		Double total = 0.00;
		for (Till till2 : tills) {
			TillVO tillVO2 = new TillVO();
			commonBusiness.changeObject(tillVO2, till2);
			tillVOs.add(tillVO2);
			System.out.println("get amount: " + tillVO2.getAmount());
			total += tillVO2.getAmount();
		}
		total =round(total, 2);
		TillVO totalrow = new TillVO();
		totalrow.setDescription("Total");
		totalrow.setAmount(total);
		tillVOs.add(totalrow);
		return tillVOs;
	}

	@Override
	public void updateTill(String status) {
		tillDAO.updateTill(status);

	}

	@Override
	public TillVO selectTillObj() throws NoDataFoundException {
		Till till =  tillDAO.selectTillObj();
		TillVO tillvo = new TillVO();
		commonBusiness.changeObject(tillvo, till);
		return tillvo;
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

}
