/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package com.pos.product.dao;

import java.util.List;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.product.controller.ProductMasterVO;
import com.pos.product.dao.ProductMaster;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of IProductMasterDAO.
 * 
 * @author Ebidrive
 */
public interface IProductMasterDAO {
	// Start of user code (user defined attributes for IProductMasterDAO)

	// End of user code

	/**
	 * Description of the method insertProductMaster.
	 * @param productMaster 
	 * @throws DuplicateEntryException 
	 */
	public void insertProductMaster(ProductMaster productMaster) throws DuplicateEntryException;

	
	public List<ProductMaster> selectProductMaster()throws NoDataFoundException;


	public ProductMaster viewProduct(ProductMaster productMaster) throws NoDataFoundException;


	


	


	void editProductMaster(ProductMaster productMaster) throws UpdateFailedException;


	public ProductMaster selectProductMaster(ProductMaster productMaster) throws UpdateFailedException;


	public void deleteProduct(ProductMaster pm);


	


	
	



	
	// Start of user code (user defined methods for IProductMasterDAO)

	// End of user code

}
