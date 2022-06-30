package com.pos.accessories.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pos.accessories.controller.AddCategoryVO;
import com.pos.accessories.dao.AddCategory;
import com.pos.accessories.dao.IAddCategoryDAO;
import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.SequenceConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.util.AlphaSequenceUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.SessionCache;

@Service
public class AddCategoryService implements IAddCategoryService {

	@Autowired
	@Qualifier(value = "simpleIdGenerator")
	IIdGeneratorService simpleIdGenerator;
	@Autowired
	CommonBusiness commonBusiness;
	@Autowired
	IAddCategoryDAO addCategoryDAO;
	Logger logger = Logger.getLogger(AddCategoryService.class);
	@Override
	public void addCategory(AddCategoryVO addCategoryVO, SessionCache sessionCache, ApplicationCache applicationCache)
			throws DatabaseException, DuplicateEntryException {
		logger.debug("Inserting Product");
		Integer sequence = simpleIdGenerator.getNextId(SequenceConstant.CATEGORY_SEQUENCE, 1);
		String categoryIdSequence = AlphaSequenceUtil.generateAlphaSequence(ApplicationConstant.STRING_CATEGORY_SEQ,
				sequence);

		AddCategory addCategory = new AddCategory();
		commonBusiness.changeObject(addCategory, addCategoryVO);
		addCategory.setDbTs(1);
		addCategory.setDelFlg("N");
		addCategory.setCategoryId(categoryIdSequence);
		addCategory.setrCreId(sessionCache.getUserSessionDetails().getUserId());
		addCategory.setrModId(sessionCache.getUserSessionDetails().getUserId());

		addCategoryDAO.insertCategory(addCategory);
		
	}

}
