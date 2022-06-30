package com.pos.sale.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.customer.dao.Customer;
import com.pos.framework.dao.BaseDao;
import com.pos.sale.controller.PosVO;
@Repository
public class SaleInfoDAO extends BaseDao implements ISaleInfoDAO{

	Logger logger = Logger.getLogger(SaleInfoDAO.class.getName());
	
	@Override
	public void insertSaleInfo(final SaleInfo saleInfo)throws DuplicateEntryException{
		System.out.println("Sale Info DAO :" + saleInfo);
		StringBuffer query = new StringBuffer();
		query = query.append("insert into sain(DB_TS,INVOICE_NO,IMEI,PRODUCT_ID,QUANTITY,PRICE,AMOUNT,DISCOUNT,"
				+ "DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID,CATEGORY)"
				+ "values(?,?,?,?,?,?,?,?,?,now(),?,now(),?,?)");
		logger.debug(" Executing prepared SQL query");
		try {
			getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement pss) throws SQLException {
					pss.setInt(1, saleInfo.getDbTs());
					pss.setString(2, saleInfo.getInvoiceNo());
					pss.setString(3, saleInfo.getImei());
					pss.setString(4, saleInfo.getProductId());
					pss.setString(5, saleInfo.getQuantity());
					pss.setString(6, saleInfo.getPrice());
					pss.setString(7, saleInfo.getAmount());
					pss.setString(8, saleInfo.getDiscount());
					pss.setString(9, saleInfo.getDelFlg());
					pss.setString(10, saleInfo.getrCreId());
					pss.setString(11, saleInfo.getrModId());
					pss.setString(12, saleInfo.getCategory());
					
				}
				
			});
		}catch (DuplicateKeyException duplicateKeyException) {
			logger.debug("Duplicate Entry");
			throw new DuplicateEntryException();
		}
	}
	
	
	@Override
	public void insertOtherBrand(final SaleInfo saleInfo)throws DuplicateEntryException{
		
		StringBuffer query = new StringBuffer();
		query = query.append("INSERT INTO OTHER_BRAND (NAME, QUANTITY, PRICE, AMOUNT, DISCOUNT, CUSTOMER, INVOICE_NO)"
				+ "values(?,?,?,?,?,?,?)");
		logger.debug(" Executing prepared SQL query");
		try {
			getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement pss) throws SQLException {
					pss.setString(1, saleInfo.getProductId());
					pss.setString(2, saleInfo.getQuantity());
					pss.setString(3, saleInfo.getPrice());
					pss.setString(4, saleInfo.getAmount());
					pss.setString(5, saleInfo.getDiscount());
					pss.setString(6, saleInfo.getCustomerId());	
					pss.setString(7, saleInfo.getInvoiceNo());	
				}
				
			});
		}catch (DuplicateKeyException duplicateKeyException) {
			logger.debug("Duplicate Entry");
			throw new DuplicateEntryException();
		}
	}

	@Override
	public List<Customer> selectCustomer() {
		List<Customer> customer = new ArrayList<Customer>();
		StringBuffer sql = new StringBuffer();
		sql.append("select CUSTOMER_ID,CUSTOMER_NAME from cus where DEL_FLG='N'");
		customer = (List<Customer>) getJdbcTemplate().query(sql.toString(),new TestDataSet1());

		
		return customer;
	}
	
	
	class TestDataSet1 implements ResultSetExtractor<List<Customer>> {
		@Override
		public List<Customer> extractData(ResultSet resultSet) throws SQLException, DataAccessException {

			List<Customer> customers = new ArrayList<Customer>();
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(resultSet.getString("CUSTOMER_ID"));
				customer.setCustomerName(resultSet.getString("CUSTOMER_NAME"));				
				customers.add(customer);
			}

			return customers;

		}

	}
	
	@Override
	public Customer selectCustomerDetailsInvoice(final String customerId) {
		Customer customer = new Customer();
		StringBuffer sql = new StringBuffer();
		sql.append("select CUSTOMER_ID,CUSTOMER_NAME,EMAIL,PHONE,ADDRESS,STATE,COUNTRY,POST_CODE,ABN_LICENSE"
				+ " from cus where CUSTOMER_ID = ?");
		customer = (Customer) getJdbcTemplate().query(sql.toString() , new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pss) throws SQLException {
				pss.setString(1, customerId);
			}
			
		},new CustomerData());
		return customer;
		
	}
	
	
	class CustomerData implements ResultSetExtractor<Customer> {
		@Override
		public Customer extractData(ResultSet resultSet) throws SQLException, DataAccessException {

			Customer customer = new Customer();
			while (resultSet.next()) {
				customer.setCustomerId(resultSet.getString("CUSTOMER_ID"));
				customer.setCustomerName(resultSet.getString("CUSTOMER_NAME"));
				customer.setEmail(resultSet.getString("EMAIL"));
				customer.setPhone(resultSet.getString("PHONE"));
				customer.setAddress(resultSet.getString("ADDRESS"));
				customer.setState(resultSet.getString("STATE"));
				customer.setCountry(resultSet.getString("COUNTRY"));
				customer.setPostCode(resultSet.getString("POST_CODE"));
				customer.setAbnLicense(resultSet.getString("ABN_LICENSE"));				
			}

			return customer;

		}

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<PosVO> getInfo(final String invoiceNo) throws NoDataFoundException {
		
		List <PosVO> posVO = new ArrayList<PosVO>();
		StringBuffer sql = new StringBuffer();
		sql.append("select INVOICE_NO,IMEI,PRODUCT_ID,QUANTITY,PRICE,AMOUNT,DISCOUNT from sale_info WHERE INVOICE_NO=? and DEL_FLG='N'");
		posVO = (List<PosVO>) getJdbcTemplate().query(sql.toString(),
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement pss) throws SQLException {
						pss.setString(1, invoiceNo);
						
					}
			
		},new ModelList());
		return posVO;
	}
	
	@SuppressWarnings("rawtypes")
	class ModelList implements ResultSetExtractor {

		@Override
		public List<PosVO> extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			List<PosVO> posVOs = new ArrayList<PosVO>();
			while (rs.next()) {
				PosVO posVO = new PosVO();
				posVO.setInvoiceNo(rs.getString("INVOICE_NO"));
				posVO.setImei(rs.getString("IMEI"));
				posVO.setProductId(rs.getString("PRODUCT_ID"));
				posVO.setProductName(rs.getString("PRODUCT_ID"));
				posVO.setQuantity(rs.getString("QUANTITY"));
				posVO.setPrice(rs.getString("PRICE"));
				posVO.setAmount(rs.getString("AMOUNT"));
				posVO.setDiscount(rs.getString("DISCOUNT"));
				
				posVOs.add(posVO);
			}
			return posVOs;
		}
	}

	
}
