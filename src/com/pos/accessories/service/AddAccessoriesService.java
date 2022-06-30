package com.pos.accessories.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pos.accessories.controller.AddAccessoriesVO;
import com.pos.accessories.dao.AddAccessories;
import com.pos.accessories.dao.IAddAccessoriesDAO;
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
public class AddAccessoriesService implements IAddAccessoriesService {

	@Autowired
	@Qualifier(value = "simpleIdGenerator")
	IIdGeneratorService simpleIdGenerator;
	@Autowired
	CommonBusiness commonBusiness;
	@Autowired
	IAddAccessoriesDAO addAccessoriesDAO;
	
	Logger logger = Logger.getLogger(AddAccessoriesService.class.getName());
	
	
	@Override
	public AddAccessoriesVO addAccessories(AddAccessoriesVO addAccessoriesVO, SessionCache sessionCache,
			ApplicationCache applicationCache) throws DatabaseException, DuplicateEntryException {
		
		
		Integer sequence = simpleIdGenerator.getNextId(SequenceConstant.ACCESSORIES_SEQUENCE, 1);
		String accessoriesIdSequence = AlphaSequenceUtil.generateAlphaSequence(ApplicationConstant.STRING_ACCESSORIES_SEQ,
				sequence);
		addAccessoriesVO.setAccessoriesId(accessoriesIdSequence);
		AddAccessories addAccessories  = new AddAccessories();
		commonBusiness.changeObject(addAccessories, addAccessoriesVO);
		addAccessories.setDbts(1);
		addAccessories.setDelFlg("N");
		
		addAccessories.setrCreId(sessionCache.getUserSessionDetails().getUserId());
		addAccessories.setrModId(sessionCache.getUserSessionDetails().getUserId());
		
		addAccessoriesDAO.insertAddAccessories(addAccessories);
		return addAccessoriesVO;
		
	}
	
	public Map<String, String> getName(String category, String brand
			)
			throws NoDataFoundException {
		List<AddAccessories> addAccessoriess = addAccessoriesDAO
				.selectName(category,brand);
		
		Map<String, String> nameMap = new LinkedHashMap<String, String>();
		for (AddAccessories addAccessories : addAccessoriess) {
			nameMap.put(addAccessories.getAccessoriesId(),
					addAccessories.getName());
					
			
		}
		
		return nameMap;

	}

	@Override
	public Map<String, String> getBrand(String category)throws NoDataFoundException {
		
		List<AddAccessories> addAccessoriess = addAccessoriesDAO
				.selectBrand(category);
		
		Map<String, String> nameMap = new LinkedHashMap<String, String>();
		for (AddAccessories addAccessories : addAccessoriess) {
			nameMap.put(addAccessories.getAccessoriesId(),
					addAccessories.getBrand());
					
			
		}
		return nameMap;
	}

}
