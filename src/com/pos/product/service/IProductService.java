/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package com.pos.product.service;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.product.controller.ProductMasterVO;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of IProductService.
 * 
 * @author Ebidrive
 */
public interface IProductService {
	// Start of user code (user defined attributes for IProductService)

	// End of user code

	/**
	 * Description of the method addProduct.
	 * @param productMasterVO
	 * @param sessionCache
	 * @param applicationCahce
	 * @throws DatabaseException 
	 * @throws DuplicateEntryException 
	 */
	public void addProduct(ProductMasterVO productMasterVO,SessionCache sessionCache,
			ApplicationCache applicationCahce) throws DatabaseException, DuplicateEntryException;

	

	
	// Start of user code (user defined methods for IProductService)

	// End of user code

}
