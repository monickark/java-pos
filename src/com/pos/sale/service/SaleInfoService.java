package com.pos.sale.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pos.accessories.dao.IAddAccessoriesInventoryDAO;
import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.SequenceConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.util.AlphaSequenceUtil;
import com.pos.common.util.ProfileGroup;
import com.pos.customer.controller.CustomerVO;
import com.pos.customer.dao.Customer;
import com.pos.customer.dao.ICustomerDAO;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.SessionCache;
import com.pos.product.dao.IProductInventoryDAO;
import com.pos.product.dao.ProductInventoryDAO;
import com.pos.sale.controller.PosVO;
import com.pos.sale.controller.SalesVO;
import com.pos.sale.dao.ISaleInfoDAO;
import com.pos.sale.dao.ISalesDAO;
import com.pos.sale.dao.ITradeinDAO;
import com.pos.sale.dao.SaleInfo;
import com.pos.sale.dao.Sales;

@Service
public class SaleInfoService implements ISaleInfoService {

	Logger logger = Logger.getLogger(SaleInfoService.class.getName());
	@Autowired
	private CommonBusiness commonBussiness;
	@Autowired
	private ISaleInfoDAO saleInfoDAO;
	@Autowired
	private ISalesDAO salesDAO;
	@Autowired
	private ICustomerDAO customerDAO;
	@Autowired
	private IProductInventoryDAO productInventoryDAO;
	@Autowired
	private IAddAccessoriesInventoryDAO addAccessoriesInventoryDAO;
	@Autowired
	private ITradeinDAO tradeinDAO;
	@Autowired
	@Qualifier(value = "simpleIdGenerator")
	IIdGeneratorService simpleIdGenerator;

	@Override
	public CustomerVO insertSaleInfo(List<PosVO> PosVOs, SalesVO salesVo,
			CustomerVO customerVO, HttpSession session,
			SessionCache sessionCache, ApplicationCache applicationCache)
			throws NoDataFoundException, DuplicateEntryException,
			DatabaseException {

		// Sales data
		Integer sequence = simpleIdGenerator.getNextId(
				SequenceConstant.SALE_SEQUENCE, 1);
		String saleIdSequence = AlphaSequenceUtil.generateAlphaSequence(
				ApplicationConstant.STRING_SALE_SEQ, sequence);
		// Invoice data
		Integer sequenceInvoice = simpleIdGenerator.getNextId(
				SequenceConstant.INVOICE_SEQUENCE, 1);
		String invoiceNoSequence = AlphaSequenceUtil.generateAlphaSequence(
				ApplicationConstant.STRING_INVOICE_SEQ, sequenceInvoice);

		
		Sales sales = new Sales();
		System.out.println("customerVO11" + customerVO);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();

		String date = dateFormat.format(cal.getTime());
		salesVo.setDate(date);
		salesVo.setInvoiceNo(invoiceNoSequence);

		session.setAttribute("salesVO", salesVo);

		commonBussiness.changeObject(sales, salesVo);
		if (customerVO != null && customerVO.getCustomerName() != null && customerVO.getCustomerName() != "") {
			// customer data
			Integer sequence1 = simpleIdGenerator.getNextId(
					SequenceConstant.CUSTOMER_SEQUENCE, 1);
			String customerIdSequence = AlphaSequenceUtil
					.generateAlphaSequence(
							ApplicationConstant.STRING_CUSTOMER_SEQ, sequence1);
			System.out.println("customerVO111" + customerVO);
			commonBussiness.changeObject(customerVO, customerVO);
			customerVO.setCustomerId(customerIdSequence);
			session.setAttribute("customerVO", customerVO);
			Customer customer = new Customer();
			commonBussiness.changeObject(customer, customerVO);
			customer.setDbTs(1);
			customer.setDelFlg("N");
			customer.setrCreId(sessionCache.getUserSessionDetails().getUserId());
			customer.setrModId(sessionCache.getUserSessionDetails().getUserId());
			System.out.println("customer service :" + customer);

			DateFormat dateTimeFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Calendar calendar = Calendar.getInstance();

			String time = dateTimeFormat.format(calendar.getTime());
			customer.setrCreTime(time);
			customer.setrModTime(time);

			customerDAO.addCustomer(customer);
			sales.setCustomerId(customer.getCustomerId());
			session.setAttribute("customerVO", customerVO);

		}
		if (customerVO != null && customerVO.getCustomerId() != null) {
			System.out.println("customerVOID" + customerVO.getCustomerId());
			sales.setCustomerId(customerVO.getCustomerId());
			Customer customer = saleInfoDAO
					.selectCustomerDetailsInvoice(customerVO.getCustomerId());
			commonBussiness.changeObject(customerVO, customer);
			session.setAttribute("customerVO", customerVO);
		}
		if(customerVO.getCustomerId()==null && (customerVO.getCustomerName() == null || customerVO.getCustomerName() == "")){
			sales.setCustomerId("CU000");
			Customer customer = saleInfoDAO
					.selectCustomerDetailsInvoice(sales.getCustomerId());
			commonBussiness.changeObject(customerVO, customer);
			session.setAttribute("customerVO", customerVO);
		}
		
		
		for (PosVO posVO : PosVOs) {			
			System.out.println("POS VO: "+ posVO.toString());
			
				SaleInfo saleInfo = new SaleInfo();
				commonBussiness.changeObject(saleInfo, posVO);
				saleInfo.setDbTs(1);
				saleInfo.setDelFlg("N");
				saleInfo.setCustomerId(customerVO.getCustomerId());
				saleInfo.setInvoiceNo(invoiceNoSequence);
				saleInfo.setrCreId(sessionCache.getUserSessionDetails().getUserId());
				saleInfo.setrModId(sessionCache.getUserSessionDetails().getUserId());
				Category category=Category.valueOf(posVO.getCategory());
				String accessoryId=saleInfo.getProductId();
				saleInfo.setProductId(posVO.getProductName());
				saleInfoDAO.insertSaleInfo(saleInfo);				
				switch(category){
				case PRODUCT:{
					
					productInventoryDAO.deleteProductInventory(saleInfo.getImei(),
							sessionCache.getUserSessionDetails().getUserId());
					break;
				}case ACCESSORY:{
					addAccessoriesInventoryDAO.updateAccessoryInventory(accessoryId, saleInfo.getQuantity(), 
							sessionCache.getUserSessionDetails().getUserId());
					break;
				}case TRADEIN:{
					tradeinDAO.deleteTradeInInventory(saleInfo.getImei(), 
							sessionCache.getUserSessionDetails().getUserId());
					break;
				}case OTHERBRAND:{
					saleInfo.setProductId(posVO.getProductName());
					saleInfoDAO.insertOtherBrand(saleInfo);
					break;
				}
				
				}
				
			/*if((posVO.getImei()!=null && (posVO.getImei() != ""))){
				saleInfoDAO.insertSaleInfo(saleInfo);
				productInventoryDAO.deleteProductInventory(saleInfo.getImei(),
						sessionCache.getUserSessionDetails().getUserId());
			} else {
				saleInfoDAO.insertOtherBrand(saleInfo);
			}*/
			
		}

		sales.setDbTs(1);
		sales.setDelFlg("N");
		sales.setrCreId(sessionCache.getUserSessionDetails().getUserId());
		sales.setrModId(sessionCache.getUserSessionDetails().getUserId());

		salesDAO.insertSales(sales);
		System.out.println("return customer data : "+customerVO);
		return customerVO;

	}

	public Map<String, String> getCustomer() throws NoDataFoundException {
		List<Customer> customers = saleInfoDAO.selectCustomer();
		System.out.println("Customer Service :" + customers);

		Map<String, String> customerMap = new LinkedHashMap<String, String>();
		for (Customer customer : customers) {
			customerMap.put(customer.getCustomerId(),
					customer.getCustomerName());

		}
		System.out.println("Customer Map Service :" + customerMap);
		return customerMap;

	}
	enum Category{
		PRODUCT,ACCESSORY,TRADEIN,OTHERBRAND;
	}
	
	@Override
	public List<PosVO> getInfo(String invoiceNo) throws NoDataFoundException {
		List<PosVO> posVO = saleInfoDAO.getInfo(invoiceNo);
		return posVO;
	}

}
