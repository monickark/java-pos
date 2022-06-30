package com.pos.sale.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.dao.BaseDao;

@Repository
public class TradeinListDAO extends BaseDao implements ITradeinListDAO {

	@Override
	public List<Tradein> selectTradein()throws DuplicateEntryException {
		
		List<Tradein> tradeins = new ArrayList<Tradein>();
		StringBuffer sql = new StringBuffer()
				.append("SELECT T_INVOICE_ID,INVOICE_DATE,CUSTOMER_NAME,CONTACT_NO,LISENCE_NUMBER,BRAND,MODEL_NO,COLOR,CAPACITY,IMEI,RESALE_VALUE,DESCRIPTION,DEL_FLG from tradein;");
		tradeins = (List<Tradein>) getJdbcTemplate().query(sql.toString(), new TestDataSet());

		return tradeins;

	}
	
	class TestDataSet implements ResultSetExtractor<List<Tradein>> {
		@Override
		public List<Tradein> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			List<Tradein> tradeins = new ArrayList<Tradein>();
			while (resultSet.next()) {
				Tradein tradein = new Tradein();
				tradein.setT_invoiceId(resultSet.getString("T_INVOICE_ID"));
				tradein.setInvoiceDate(resultSet.getString("INVOICE_DATE"));
				tradein.setCustomerName(resultSet.getString("CUSTOMER_NAME"));
				tradein.setContactNo(resultSet.getString("CONTACT_NO"));
				tradein.setLisenceNumber(resultSet.getString("LISENCE_NUMBER"));
				tradein.setBrand(resultSet.getString("BRAND"));
				tradein.setModelNo(resultSet.getString("MODEL_NO"));
				tradein.setColor(resultSet.getString("COLOR"));
				tradein.setCapacity(resultSet.getString("CAPACITY"));
				tradein.setImei(resultSet.getString("IMEI"));
				tradein.setResaleValue(resultSet.getString("RESALE_VALUE"));
				tradein.setDescription(resultSet.getString("DESCRIPTION"));
				tradein.setDelFlg(resultSet.getString("DEL_FLG"));

				tradeins.add(tradein);
			}

			return tradeins;

		}
	}
	
	@Override
	public Tradein selectTradein(final Tradein tradein)throws NoDataFoundException {
		Tradein tradein1 = new Tradein();
		StringBuffer sql = new StringBuffer()
				.append("SELECT T_INVOICE_ID,INVOICE_DATE,CUSTOMER_NAME,CONTACT_NO,LISENCE_NUMBER,BRAND,MODEL_NO,COLOR,CAPACITY,IMEI,RESALE_VALUE,DESCRIPTION,DEL_FLG "
						+ "from tradein WHERE IMEI= ?;");
		
		tradein1 = (Tradein) getJdbcTemplate().query(sql.toString() , new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pss) throws SQLException {
				pss.setString(1, tradein.getImei());
			}
			
		}, new TradeInData());
		
		if(tradein1==null){
			throw new NoDataFoundException();
		}

		return tradein1;

	}
	
	class TradeInData implements ResultSetExtractor<Tradein> {
		@Override
		public Tradein extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			Tradein tradein = null;
			while (resultSet.next()) {
				tradein = new Tradein();
				tradein.setT_invoiceId(resultSet.getString("T_INVOICE_ID"));
				tradein.setInvoiceDate(resultSet.getString("INVOICE_DATE"));
				tradein.setCustomerName(resultSet.getString("CUSTOMER_NAME"));
				tradein.setContactNo(resultSet.getString("CONTACT_NO"));
				tradein.setLisenceNumber(resultSet.getString("LISENCE_NUMBER"));
				tradein.setBrand(resultSet.getString("BRAND"));
				tradein.setModelNo(resultSet.getString("MODEL_NO"));
				tradein.setColor(resultSet.getString("COLOR"));
				tradein.setCapacity(resultSet.getString("CAPACITY"));
				tradein.setImei(resultSet.getString("IMEI"));
				tradein.setResaleValue(resultSet.getString("RESALE_VALUE"));
				tradein.setDescription(resultSet.getString("DESCRIPTION"));
				tradein.setDelFlg(resultSet.getString("DEL_FLG"));

			}

			return tradein;

		}
	}
	
	@Override
	public String selectTradeinSign(final String imei)throws NoDataFoundException {
		String image = null;
		StringBuffer sql = new StringBuffer()
				.append("SELECT sign "
						+ "from tradeinsign WHERE imei=?;");
		
		image = (String) getJdbcTemplate().query(sql.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pss) throws SQLException {
				pss.setString(1, imei);
			}
			
		}, new TradeInSign());
		
		if(image==null){
			throw new NoDataFoundException();
		}
		return image;

	}
	
	class TradeInSign implements ResultSetExtractor<String> {
		@Override
		public String extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			String image = null;
			while (resultSet.next()) {
				image = resultSet.getString("sign"); 

			}

			return image;

		}
	}

}