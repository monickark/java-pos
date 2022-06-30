package com.pos.product.service;

import java.util.List;
import java.util.Map;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.product.controller.ProductMasterVO;

public interface IProductListService {
	
	public ProductMasterVO viewProduct(ProductMasterVO productMasterVO) throws NoDataFoundException;

	List<ProductMasterVO> selectProductList(ProductMasterVO productMasterVO) throws NoDataFoundException;

	public ProductMasterVO editProductMaster(ProductMasterVO productMasterVO) throws NoDataFoundException, UpdateFailedException;

	public void updateProduct(ProductMasterVO productMasterVO) throws UpdateFailedException;

	public void deleteProduct(ProductMasterVO productMasterVO) throws NoDataFoundException, UpdateFailedException;

	void addInventory(ProductMasterVO productMasterVO, SessionCache sessionCache, ApplicationCache applicationCache)
			throws DatabaseException, DuplicateEntryException;

/*	public void editsave(ProductMasterVO productMasterVO);*/


}
