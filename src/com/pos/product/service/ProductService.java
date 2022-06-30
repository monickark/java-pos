/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package com.pos.product.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pos.admin.controller.BranchMasterVO;
import com.pos.admin.dao.BranchMaster;
import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.SequenceConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.util.AlphaSequenceUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.SessionCache;
import com.pos.product.controller.ProductMasterVO;
import com.pos.product.dao.IProductMasterDAO;
import com.pos.product.dao.ProductMaster;
import com.pos.product.service.IProductService;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of ProductService.
 * 
 * @author Ebidrive
 */
@Service
public class ProductService implements IProductService {
	// Start of user code (user defined attributes for ProductService)
	@Autowired
	IProductMasterDAO productMasterDAO;
	@Autowired
	@Qualifier(value = "simpleIdGenerator")
	IIdGeneratorService simpleIdGenerator;
	@Autowired
	CommonBusiness commonBusiness;
	// End of user code
	Logger logger = Logger.getLogger(ProductService.class);

	/**
	 * Description of the method addProduct.
	 * 
	 * @param productMasterVO
	 * @param sessionCache
	 * @param applicationCahce
	 * @throws DatabaseException
	 * @throws DuplicateEntryException
	 */
	@Override
	public void addProduct(ProductMasterVO productMasterVO, SessionCache sessionCache,
			ApplicationCache applicationCahce) throws DatabaseException, DuplicateEntryException {

		// Start of user code for method addProduct
		logger.debug("Inserting Product");
		Integer sequence = simpleIdGenerator.getNextId(SequenceConstant.PRODUCT_SEQUENCE, 1);
		String productIdSequence = AlphaSequenceUtil.generateAlphaSequence(ApplicationConstant.STRING_PRODUCT_SEQ,
				sequence);

		ProductMaster productMaster = new ProductMaster();
		commonBusiness.changeObject(productMaster, productMasterVO);
		productMaster.setDbTs(1);
		productMaster.setDelFlg("N");
		productMaster.setProductId(productIdSequence);
		productMaster.setRCreId(sessionCache.getUserSessionDetails().getUserId());
		productMaster.setRModId(sessionCache.getUserSessionDetails().getUserId());

		productMasterDAO.insertProductMaster(productMaster);
		// End of user code
	}
}
