package com.pos.report.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.dao.BaseDao;
import com.pos.report.dao.SalesReportDAO.TestDataSet;

@Repository
public class ProductReportDAO extends BaseDao implements IProductReportDAO {

	
	@Override
	public List<ProductReport> selectProductReport() throws NoDataFoundException {
		List<ProductReport> productReports = new ArrayList<ProductReport>();
		StringBuffer sql = new StringBuffer()
				.append("select DB_TS,INVOICE_NO,IMEI,PRODUCT_ID,QUANTITY,PRICE,AMOUNT,DISCOUNT,"
						+ "DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID,CATEGORY from sain");
		productReports = (List<ProductReport>) getJdbcTemplate().query(sql.toString(), new TestDataSet());
		
		return productReports;
	
	}

	
	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public List<ProductReport> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			List<ProductReport> productReports = new ArrayList<ProductReport>();
			while (resultSet.next()) {
				ProductReport productReport = new ProductReport();
				productReport.setImei(resultSet.getString("IMEI"));
				productReport.setInvoiceNo(resultSet.getString("INVOICE_NO"));
				productReport.setProductId(resultSet.getString("PRODUCT_ID"));
				productReport.setQuantity(resultSet.getString("QUANTITY"));
				productReport.setPrice(resultSet.getString("PRICE"));
				productReport.setAmount(resultSet.getString("AMOUNT"));
				productReport.setDiscount(resultSet.getString("DISCOUNT"));
				productReport.setCategory(resultSet.getString("CATEGORY"));
				
				productReports.add(productReport);
			}

			return productReports;

		}
	
	}
}
