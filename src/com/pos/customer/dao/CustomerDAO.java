package com.pos.customer.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.dao.BaseDao;

@Repository
public class CustomerDAO extends BaseDao implements ICustomerDAO {

	Logger logger = Logger.getLogger(CustomerDAO.class.getName());
	@Override
	public void addCustomer(final Customer customer) throws DuplicateEntryException {
		StringBuffer query = new StringBuffer();
		query = query.append("insert into cus(DB_TS,CUSTOMER_ID,CUSTOMER_NAME,EMAIL,PHONE,MOBILE,ADDRESS,STATE,COUNTRY,POST_CODE,ABN_LICENSE,"
				+ "DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,now(),?,now(),?)");
		try {
			getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement pss) throws SQLException {
					// TODO Auto-generated method stub
					pss.setInt(1,customer.getDbTs());
					pss.setString(2, customer.getCustomerId());
					pss.setString(3, customer.getCustomerName());
					pss.setString(4, customer.getEmail());
					pss.setString(5, customer.getPhone());
					pss.setString(6, customer.getMobile());
					pss.setString(7, customer.getAddress());
					pss.setString(8, customer.getState());
					pss.setString(9, customer.getCountry());
					pss.setString(10, customer.getPostCode());
					pss.setString(11, customer.getAbnLicense());
					pss.setString(12, customer.getDelFlg());
					pss.setString(13, customer.getrCreId());
					pss.setString(14, customer.getrModId());
				}
				
			});
		
	}
		catch (DuplicateKeyException duplicateKeyException) {
			
			throw new DuplicateEntryException();
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public Customer getCustomer(final String customerId)throws NoDataFoundException {
		Customer customer = new Customer();
		StringBuffer sql = new StringBuffer();
		sql.append("select CUSTOMER_ID,CUSTOMER_NAME,EMAIL,PHONE,MOBILE,ADDRESS,STATE,COUNTRY,POST_CODE,ABN_LICENSE from customer WHERE CUSTOMER_ID=? and DEL_FLG='N'");
		customer = (Customer) getJdbcTemplate().query(sql.toString(),
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement pss) throws SQLException {
						pss.setString(1, customerId);
						
					}
			
		},new ModelList());
		if(customer ==null){
			throw new NoDataFoundException();
		}
		return customer;
		
	}
	
	@SuppressWarnings("rawtypes")
	class ModelList implements ResultSetExtractor {

		@Override
		public Customer extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			Customer customer =null;
			while (rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getString("CUSTOMER_ID"));
				customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
				customer.setEmail(rs.getString("EMAIL"));
				customer.setPhone(rs.getString("PHONE"));
				customer.setMobile(rs.getString("MOBILE"));
				customer.setAddress(rs.getString("ADDRESS"));
				customer.setState(rs.getString("STATE"));
				customer.setCountry(rs.getString("COUNTRY"));
				customer.setPostCode(rs.getString("POST_CODE"));
				customer.setAbnLicense(rs.getString("ABN_LICENSE"));
			}
			return customer;
		}
	}

}
