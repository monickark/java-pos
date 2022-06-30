package com.pos.sale.dao;

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
public class SalesDAO extends BaseDao implements ISalesDAO {

	Logger logger = Logger.getLogger(SalesDAO.class.getName());

	@Override
	public void insertSales(final Sales sales) throws DuplicateEntryException {

		StringBuffer query = new StringBuffer();
		query = query
				.append("insert into sal(DB_TS,INVOICE_NO,CUSTOMER_ID,AMOUNT,PROMO_DISCOUNT,TAX,NET_AMOUNT,AMOUNT_PAYABLE,DATE,"
						+ "DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID)"
						+ "values(?,?,?,?,?,?,?,?,?,?,now(),?,now(),?)");

		try {
			getJdbcTemplate().update(query.toString(),
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement pss)
								throws SQLException {
							pss.setInt(1, sales.getDbTs());
							pss.setString(2, sales.getInvoiceNo());
							pss.setString(3, sales.getCustomerId());
							pss.setString(4, sales.getAmount());
							pss.setString(5, sales.getPromoDiscount());
							pss.setString(6, sales.getTax());
							pss.setString(7, sales.getNetAmount());
							pss.setString(8, sales.getAmountPayable());
							pss.setString(9, sales.getDate());
							pss.setString(10, sales.getDelFlg());
							pss.setString(11, sales.getrCreId());
							pss.setString(12, sales.getrModId());

						}

					});
		} catch (DuplicateKeyException duplicateKeyException) {

			throw new DuplicateEntryException();
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public Sales getSales(final String invoiceNo)throws NoDataFoundException {
		Sales Sales = new Sales();
		StringBuffer sql = new StringBuffer();
		sql.append("select INVOICE_NO,CUSTOMER_ID,AMOUNT,PROMO_DISCOUNT,TAX,NET_AMOUNT,AMOUNT_PAYABLE,DATE from sales WHERE INVOICE_NO=? and DEL_FLG='N'");
		Sales = (Sales) getJdbcTemplate().query(sql.toString(),
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement pss) throws SQLException {
						pss.setString(1, invoiceNo);
						
					}
			
		},new ModelList());
		System.out.println("Amount" +Sales);
		return Sales;
	}
		
		@SuppressWarnings("rawtypes")
		class ModelList implements ResultSetExtractor {

			@Override
			public Sales extractData(ResultSet rs)
					throws SQLException, DataAccessException {
				Sales sales = new Sales();
				while (rs.next()) {
					
					sales.setInvoiceNo(rs.getString("INVOICE_NO"));
					sales.setCustomerId(rs.getString("CUSTOMER_ID"));
					sales.setAmount(rs.getString("AMOUNT"));
					sales.setPromoDiscount(rs.getString("PROMO_DISCOUNT"));
					sales.setTax(rs.getString("TAX"));
					sales.setNetAmount(rs.getString("NET_AMOUNT"));
					
					sales.setAmountPayable(rs.getString("AMOUNT_PAYABLE"));
					
					sales.setDate(rs.getString("Date"));
					
				}
				return sales;
			}
		}

}
