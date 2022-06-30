package com.pos.accessories.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pos.accessories.controller.AddAccessoriesVO;
import com.pos.accessories.dao.AddAccessoriesInventory;
import com.pos.accessories.dao.IAddAccessoriesInventoryDAO;
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

@Service
public class AddAccessoriesInventoryService implements IAddAccessoriesInventoryService {

	@Autowired
	CommonBusiness commonBusiness;
	@Autowired
	IAddAccessoriesInventoryDAO addAccessoriesInventoryDAO;
	@Autowired
	@Qualifier(value = "simpleIdGenerator")
	IIdGeneratorService simpleIdGenerator;
	
	Logger logger = Logger.getLogger(AddAccessoriesService.class.getName());
	@Override
	public void addAccessoriesInventory(AddAccessoriesVO addAccessoriesVO,SessionCache sessionCache,
			ApplicationCache applicationCache)throws DatabaseException, DuplicateEntryException {
		
		Integer sequence = simpleIdGenerator.getNextId(SequenceConstant.ACCESSORIES_INVENTORY_SEQUENCE, 1);
		String accessoriesInventoryIdSequence = AlphaSequenceUtil.generateAlphaSequence(ApplicationConstant.STRING_ACCESSORIES_INVENTORY_SEQ,
				sequence);
		
		
		AddAccessoriesInventory addAccessoriesInventory  = new AddAccessoriesInventory();
		commonBusiness.changeObject(addAccessoriesInventory, addAccessoriesVO);
		addAccessoriesInventory.setDbTs(1);
		addAccessoriesInventory.setDelFlg("N");
		
		addAccessoriesInventory.setAccessoriesInventoryId(accessoriesInventoryIdSequence);
		addAccessoriesInventory.setrCreId(sessionCache.getUserSessionDetails().getUserId());
		addAccessoriesInventory.setrModId(sessionCache.getUserSessionDetails().getUserId());
		
		addAccessoriesInventoryDAO.insertAccessoriesInventory(addAccessoriesInventory);
		
	}
	
	@Override
	public AddAccessoriesInventory getList(String accessoriesId)throws NoDataFoundException, DuplicateEntryException {
		
		AddAccessoriesInventory addAccessoriesInventory= addAccessoriesInventoryDAO.getList(accessoriesId);

		return addAccessoriesInventory;
	}

}
