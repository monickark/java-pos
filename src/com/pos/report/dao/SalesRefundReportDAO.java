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
public class SalesRefundReportDAO extends BaseDao implements ISalesRefundReportDAO {

	@Override
	public List<SalesRefundReport> selectSalesRefundReport() throws NoDataFoundException {
		List<SalesRefundReport> salesRefundReports = new ArrayList<SalesRefundReport>();
		StringBuffer sql = new StringBuffer()
				.append("Select sr.INVOICE_NO,p.PRODUCT_ID,p.PRODUCT_NAME as PRODUCT_NAME,sr.REFUND_DATE,REFUND_AMOUNT,REFUND_REASON from productmaster p, sales_refund sr\r\n" + 
						" WHERE\r\n" + 
						" sr.PRODUCT_ID = p.PRODUCT_ID and\r\n" + 
						" sr.DEL_FLG='N';");
		salesRefundReports = (List<SalesRefundReport>) getJdbcTemplate().query(sql.toString(), new TestDataSet());
		
		return salesRefundReports;

	}
	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public List<SalesRefundReport> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			List<SalesRefundReport> salesRefundReports = new ArrayList<SalesRefundReport>();
			while (resultSet.next()) {
				SalesRefundReport salesRefundReport = new SalesRefundReport();
				salesRefundReport.setInvoiceNo(resultSet.getString("INVOICE_NO"));
				salesRefundReport.setProductId(resultSet.getString("PRODUCT_ID"));
				salesRefundReport.setProductName(resultSet.getString("PRODUCT_NAME"));
				salesRefundReport.setRefundDate(resultSet.getString("REFUND_DATE"));				
				salesRefundReport.setRefundAmount(resultSet.getString("REFUND_AMOUNT"));
				salesRefundReport.setRefundReason(resultSet.getString("REFUND_REASON"));
								salesRefundReports.add(salesRefundReport);
			}

			return salesRefundReports;

		}
		
	}

}
