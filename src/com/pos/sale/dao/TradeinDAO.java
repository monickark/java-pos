package com.pos.sale.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.dao.BaseDao;
@Repository
public class TradeinDAO extends BaseDao implements ITradeinDAO{

	@Override
	public void addTradein(final Tradein tradein)throws DuplicateEntryException {
		
		StringBuffer query = new StringBuffer();
		query = query.append("insert into tradein(DB_TS,T_INVOICE_ID,INVOICE_DATE,CUSTOMER_NAME,CONTACT_NO,LISENCE_NUMBER,BRAND,MODEL_NO,COLOR,CAPACITY,IMEI,RESALE_VALUE,DESCRIPTION,"
				+ "DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?,now(),?)");
		try {
			getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement pss) throws SQLException {
					pss.setInt(1,tradein.getDbTs());
					pss.setString(2, tradein.getT_invoiceId());
					pss.setString(3, tradein.getInvoiceDate());
					pss.setString(4, tradein.getCustomerName());
					pss.setString(5, tradein.getContactNo());
					pss.setString(6, tradein.getLisenceNumber());
					pss.setString(7, tradein.getBrand());
					pss.setString(8, tradein.getModelNo());
					pss.setString(9, tradein.getColor());
					pss.setString(10, tradein.getCapacity());
					pss.setString(11, tradein.getImei());
					pss.setString(12, tradein.getResaleValue());
					pss.setString(13, tradein.getDescription());
					pss.setString(14, tradein.getDelFlg());
					pss.setString(15, tradein.getrCreId());
					pss.setString(16, tradein.getrModId());
					
					
				}
				
			});
		}catch (DuplicateKeyException duplicateKeyException) {
			
			throw new DuplicateEntryException();
		}
		
	}
	
	@Override
	public void addTradeinSign(final String imei, final String sign)throws DuplicateEntryException {
		
		StringBuffer query = new StringBuffer();
		query = query.append("insert into tradeinsign (imei,sign) values (?,?)");
		try {
			getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement pss) throws SQLException {
					pss.setString(1,imei);			
					pss.setString(2,sign);			
					
				}
				
			});
		}catch (DuplicateKeyException duplicateKeyException) {
			
			throw new DuplicateEntryException();
		}
		
	}
	
	@Override
	public Tradein selectTradein(final Tradein tradein)throws NoDataFoundException {
		Tradein tradein1 = new Tradein();
		StringBuffer sql = new StringBuffer()
				.append("SELECT T_INVOICE_ID,INVOICE_DATE,CUSTOMER_NAME,CONTACT_NO,LISENCE_NUMBER,BRAND,MODEL_NO,COLOR,CAPACITY,IMEI,RESALE_VALUE,DESCRIPTION "
						+ "from tradein WHERE IMEI= ? and DEL_FLG='N';");
		
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

			}

			return tradein;

		}
	}
	
	@Override
	public void deleteTradeInInventory(final String imei,final String rModId) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		query=query.append("update tradein set DEL_FLG=?, R_MOD_TIME=now(), R_MOD_ID=? WHERE IMEI=?");
		System.out.println("JDBC in delete:" + getJdbcTemplate());
		int changedrows=getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pss) throws SQLException {
				// TODO Auto-generated method stub
				pss.setString(1, "Y");
				pss.setString(2, rModId);
				pss.setString(3, imei);
			}
			
		});
		if(changedrows==0) {
			System.out.println("No data updated");
		}
		
	}
	

}
