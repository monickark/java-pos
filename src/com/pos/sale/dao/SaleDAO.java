package com.pos.sale.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.dao.BaseDao;

@Repository
public class SaleDAO extends BaseDao implements ISaleDAO {

	Logger logger = Logger.getLogger(SaleDAO.class.getName());

	@SuppressWarnings("unchecked")
	public PosPurchaseList selectSale(final PosPurchaseList posPurchaseList) throws NoDataFoundException{
		PosPurchaseList ppl = new PosPurchaseList();
		StringBuffer query = new StringBuffer();
		query = query
				.append("SELECT pm.product_id, IMEI, sell_price as amount, pm.product_name FROM\r\n"
						+ "product_inventory p, productmaster pm\r\n"
						+ "where p.product_id = pm.product_id and IMEI=? and p.DEL_FLG='N';");
		ppl = (PosPurchaseList) getJdbcTemplate().query(query.toString(),
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement pss)
							throws SQLException {
						pss.setString(1, posPurchaseList.getImei());
					}

				}, new TestDataSet1());
		if(ppl==null){
			throw new NoDataFoundException();
		}
		System.out.println("PPL:"+ppl);
		return ppl;
		
	}

	@SuppressWarnings("rawtypes")
	class TestDataSet1 implements ResultSetExtractor {
		@Override
		public PosPurchaseList extractData(ResultSet resultSet)
				throws SQLException, DataAccessException {

			PosPurchaseList posPurchaseList = null;
			while (resultSet.next()) {
				posPurchaseList = new PosPurchaseList();
				posPurchaseList.setProductId(resultSet.getString("PRODUCT_ID"));
				posPurchaseList.setProductName(resultSet
						.getString("PRODUCT_NAME"));
				posPurchaseList.setAmount(resultSet.getString("AMOUNT"));
				posPurchaseList.setPrice(resultSet.getString("AMOUNT"));
				posPurchaseList.setImei(resultSet.getString("IMEI"));
			}

			return posPurchaseList;
		}

	}

}
