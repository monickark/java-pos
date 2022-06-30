package com.pos.product.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.SequenceConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.util.AlphaSequenceUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.SessionCache;
import com.pos.product.controller.ProductMasterVO;
import com.pos.product.dao.IProductInventoryDAO;
import com.pos.product.dao.IProductMasterDAO;
import com.pos.product.dao.ProductMaster;

@Service
public class ProductListService implements IProductListService {

	Logger logger = Logger.getLogger(ProductListService.class);
	@Autowired
	IProductInventoryDAO productInventoryDAO;
	@Autowired
	@Qualifier(value = "simpleIdGenerator")
	IIdGeneratorService simpleIdGenerator;
	@Autowired
	CommonBusiness commonBusiness;
	@Autowired
	private CommonBusiness commonBussiness;
	@Autowired
	private IProductMasterDAO productMasterDAO;

	@Override
	public List<ProductMasterVO> selectProductList(
			ProductMasterVO productMasterVO) throws NoDataFoundException {

		List<ProductMasterVO> productMasterVOs = new ArrayList<ProductMasterVO>();
		ProductMaster productMaster = new ProductMaster();
		commonBussiness.changeObject(productMaster, productMasterVO);

		List<ProductMaster> productMasters = productMasterDAO
				.selectProductMaster();

		for (ProductMaster productMaster2 : productMasters) {
			ProductMasterVO productMasterVO2 = new ProductMasterVO();
			commonBussiness.changeObject(productMasterVO2, productMaster2);
			productMasterVOs.add(productMasterVO2);
		}

		return productMasterVOs;
	}

	@Override
	public ProductMasterVO viewProduct(ProductMasterVO productMasterVO)
			throws NoDataFoundException {
		// TODO Auto-generated method stub
		ProductMaster productMaster = new ProductMaster();
		commonBussiness.changeObject(productMaster, productMasterVO);
		productMaster = productMasterDAO.viewProduct(productMaster);
		commonBussiness.changeObject(productMasterVO, productMaster);

		return productMasterVO;

	}

	@Override
	public ProductMasterVO editProductMaster(ProductMasterVO productMasterVO)
			throws NoDataFoundException, UpdateFailedException {
		// TODO Auto-generated method stub
		ProductMaster productMaster = new ProductMaster();
		commonBussiness.changeObject(productMaster, productMasterVO);
		System.out.println("productMaster: " + productMaster);
		productMaster = productMasterDAO.selectProductMaster(productMaster);
		commonBussiness.changeObject(productMasterVO, productMaster);
		System.out.println("productMasterVO: " + productMasterVO);
		return productMasterVO;
	}

	@Override
	public void updateProduct(ProductMasterVO productMasterVO)
			throws UpdateFailedException {
		// TODO Auto-generated method stub
		// System.out.println("Product service" +productMasterVO);
		ProductMaster productMaster = new ProductMaster();
		commonBussiness.changeObject(productMaster, productMasterVO);
		productMaster = productMasterDAO.selectProductMaster(productMaster);

		commonBussiness.changeObject(productMaster, productMasterVO);
		productMasterDAO.editProductMaster(productMaster);

	}

	@Override
	public void deleteProduct(ProductMasterVO productMasterVO)
			throws NoDataFoundException, UpdateFailedException {
		// TODO Auto-generated method stub
		System.out.println("Delete Product" + productMasterVO);
		ProductMaster productMaster = new ProductMaster();
		commonBussiness.changeObject(productMaster, productMasterVO);
		productMaster = productMasterDAO.selectProductMaster(productMaster);
		System.out.println("product master after select: "
				+ productMaster.toString());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();

		String modTime = dateFormat.format(cal.getTime());
		productMaster.setRModTime(modTime);

		productMasterDAO.deleteProduct(productMaster);

	}

	@Override
	public void addInventory(ProductMasterVO productMasterVO,
			SessionCache sessionCache, ApplicationCache applicationCache)
			throws DatabaseException, DuplicateEntryException {

		System.out.println("Inventory service :" + productMasterVO);

		Integer sequence = simpleIdGenerator.getNextId(
				SequenceConstant.INVENTORY_SEQUENCE, 1);
		String inventoryIdSequence = AlphaSequenceUtil.generateAlphaSequence(
				ApplicationConstant.STRING_INVENTORY_SEQ, sequence);
		ProductMaster productMaster = new ProductMaster();
		commonBusiness.changeObject(productMaster, productMasterVO);
		productMaster.setDbTs(1);
		productMaster.setDelFlg("N");
		productMaster.setInventoryId(inventoryIdSequence);
		productMaster.setRCreId(sessionCache.getUserSessionDetails()
				.getUserId());
		productMaster.setRModId(sessionCache.getUserSessionDetails()
				.getUserId());
		System.out.println("Inventory service :" + productMaster);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();

		String creTime = dateFormat.format(cal.getTime());
		productMaster.setRCreTime(creTime);

		String modTime = dateFormat.format(cal.getTime());
		productMaster.setRModTime(modTime);

		String invoiceDate = dateFormat.format(cal.getTime());
		productMaster.setInvoiceDate(invoiceDate);

		productInventoryDAO.insertProductInventory(productMaster);
	}

}
