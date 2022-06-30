package com.pos.report.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.customer.dao.Customer;
import com.pos.framework.dao.BaseDao;

@Repository
public class CustomerReportDAO extends BaseDao implements ICustomerReportDAO {

	@Override
	public List<Customer> selectCustomerReport()throws NoDataFoundException {
		
		List<Customer> customers = new ArrayList<Customer>();
		StringBuffer sql = new StringBuffer()
				.append("select CUSTOMER_ID,CUSTOMER_NAME,EMAIL,PHONE,MOBILE,ADDRESS from customer where DEL_FLG='N';");
		
		customers = (List<Customer>) getJdbcTemplate().query(sql.toString(), new TestDataSet());
		
		return customers;
	}
	
	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public List<Customer> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			List<Customer> customers = new ArrayList<Customer>();
			while (resultSet.next()) {
				Customer customer = new Customer();
				
				customer.setCustomerId(resultSet.getString("CUSTOMER_ID"));
				customer.setCustomerName(resultSet.getString("CUSTOMER_NAME"));				
				customer.setEmail(resultSet.getString("EMAIL"));
				customer.setPhone(resultSet.getString("PHONE"));
				customer.setMobile(resultSet.getString("MOBILE"));
				customer.setAddress(resultSet.getString("ADDRESS"));
				customers.add(customer);
			}

			return customers;

		}
	}

}
