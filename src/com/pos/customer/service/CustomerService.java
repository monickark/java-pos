package com.pos.customer.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.SequenceConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.util.AlphaSequenceUtil;
import com.pos.customer.controller.CustomerVO;
import com.pos.customer.dao.Customer;
import com.pos.customer.dao.ICustomerDAO;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.SessionCache;

@Service
public class CustomerService implements ICustomerService{

	@Autowired
	ICustomerDAO customerDAO;
	@Autowired
	@Qualifier(value = "simpleIdGenerator")
	IIdGeneratorService simpleIdGenerator;
	@Autowired
	CommonBusiness commonBusiness;
	
	Logger logger = Logger.getLogger(CustomerService.class.getName());
	
	
	@Override
	public void addCustomer(CustomerVO customerVO, SessionCache sessionCache, ApplicationCache applicationCache)
			throws DatabaseException, DuplicateEntryException{
		
		Integer sequence = simpleIdGenerator.getNextId(SequenceConstant.CUSTOMER_SEQUENCE, 1);
		String customerIdSequence = AlphaSequenceUtil.generateAlphaSequence(ApplicationConstant.STRING_CUSTOMER_SEQ,
				sequence);
		
		Customer customer = new Customer();
		
		commonBusiness.changeObject(customer,customerVO);
		customer.setDbTs(1);
		customer.setDelFlg("N");
		customer.setCustomerId(customerIdSequence);
		customer.setrCreId(sessionCache.getUserSessionDetails().getUserId());
		customer.setrModId(sessionCache.getUserSessionDetails().getUserId());
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Calendar cal = Calendar.getInstance();
		 
		 String creTime=dateFormat.format(cal.getTime());
		 customer.setrCreTime(creTime);

		 String modTime=dateFormat.format(cal.getTime());
		 customer.setrModTime(modTime);

		 
		 
		 customerDAO.addCustomer(customer);
	}
	
	@Override
	public CustomerVO getCustomer(String customerId)throws NoDataFoundException {
		Customer customer = customerDAO.getCustomer(customerId);
		CustomerVO customerVO = new CustomerVO();
		commonBusiness.changeObject(customerVO, customer);
		return customerVO;
	}

		
	

}
