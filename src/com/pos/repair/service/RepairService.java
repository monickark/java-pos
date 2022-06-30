package com.pos.repair.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.SequenceConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.util.AlphaSequenceUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.SessionCache;
import com.pos.repair.controller.RepairVO;
import com.pos.repair.dao.IRepairDAO;
import com.pos.repair.dao.Repair;

@Service
public class RepairService implements IRepairService {

	@Autowired
	@Qualifier(value = "simpleIdGenerator")
	IIdGeneratorService simpleIdGenerator;
	@Autowired
	CommonBusiness commonBusiness;
	@Autowired
	IRepairDAO repairDAO;
	
	Logger logger = Logger.getLogger(RepairService.class.getName());

	@Override
	public void addRepair(RepairVO repairVO, SessionCache sessionCache, ApplicationCache applicationCache)
			throws DatabaseException, DuplicateEntryException{
		
		Integer sequence = simpleIdGenerator.getNextId(SequenceConstant.REPAIR_SEQUENCE, 1);
		String repairIdSequence = AlphaSequenceUtil.generateAlphaSequence(ApplicationConstant.STRING_REPAIR_SEQ,
				sequence);
		Repair repair = new Repair();
		commonBusiness.changeObject(repair,repairVO);
		repair.setDbTs(1);
		repair.setDelFlg("N");
		repair.setRepairId(repairIdSequence);
		repair.setrCreId(sessionCache.getUserSessionDetails().getUserId());
		repair.setrModId(sessionCache.getUserSessionDetails().getUserId());
		System.out.println("Repair Service :" +repair);
		repairDAO.addRepair(repair);
	}
}
