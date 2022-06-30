package com.pos.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.common.business.CommonBusiness;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.product.controller.ProductInventoryVO;
import com.pos.product.dao.IProductInventoryListDAO;
import com.pos.product.dao.ProductInventory;
@Service
public class ProductInventoryService implements IProductInventoryService {
	Logger logger = Logger.getLogger(ProductInventoryService.class.getName());
	@Autowired
	private CommonBusiness commonBussiness;
	@Autowired
	IProductInventoryListDAO productInventoryListDAO;
	@Override
	public List<ProductInventoryVO> selectProductInventoryList(ProductInventoryVO productInventoryVO) throws NoDataFoundException {
		// TODO Auto-generated method stub
		List<ProductInventoryVO> productMasterVOs = new ArrayList<ProductInventoryVO>();
		ProductInventory productMaster = new ProductInventory();
		commonBussiness.changeObject(productMaster, productInventoryVO);

		List<ProductInventory> productMasters = productInventoryListDAO.selectProductInventory();

		for (ProductInventory productMaster2 : productMasters) {
			ProductInventoryVO productMasterVO2 = new ProductInventoryVO();
			commonBussiness.changeObject(productMasterVO2, productMaster2);
			productMasterVOs.add(productMasterVO2);
		}
		return productMasterVOs;
	}
	
	@Override
	public List<ProductInventoryVO> viewProductInventory(String productId, String inventoryDate) throws NoDataFoundException {
		List<ProductInventory> productInventory =productInventoryListDAO.viewProductInventory( productId,  inventoryDate);
		List<ProductInventoryVO> productInventoryVO = new ArrayList<ProductInventoryVO>();
		
		for (ProductInventory productMaster2 : productInventory) {
			ProductInventoryVO productMasterVO2 = new ProductInventoryVO();
			commonBussiness.changeObject(productMasterVO2, productMaster2);
			productInventoryVO.add(productMasterVO2);
		}
		return productInventoryVO;
	}

}
