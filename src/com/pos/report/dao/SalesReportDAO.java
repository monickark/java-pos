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
@Repository
public class SalesReportDAO extends BaseDao implements ISalesReportDAO {

	

	@Override
	public List<SalesReport> selectSalesReport()throws NoDataFoundException  {
		List<SalesReport> salesReports = new ArrayList<SalesReport>();
		StringBuffer sql = new StringBuffer()
				.append(" select * from ("
						+ "select s.INVOICE_NO,C.CUSTOMER_ID,c.customer_name, GROUP_CONCAT(IMEI) as imei,"
						+ "	sum(QUANTITY) as Quantity, date_format(DATE, '%d/%m/%y') AS DATE ,"
						+ " s.AMOUNT,PROMO_DISCOUNT,TAX,NET_AMOUNT,AMOUNT_PAYABLE"
						+ " from sal s, customer c, SALE_INFO SI"
						+ "	where s.CUSTOMER_ID = c.CUSTOMER_ID and"
						+ " s.invoice_no = si.invoice_no and"
						+ "	s.del_flg='N' group by s.invoice_no)as a order by date desc;");
						/*+ " union"
						+ " select s.INVOICE_NO,C.CUSTOMER_ID,c.customer_name, name as imei,"
						+ "	Quantity, date_format(DATE, '%d/%m/%y') AS DATE ,"
						+ " s.AMOUNT,PROMO_DISCOUNT,TAX,NET_AMOUNT,AMOUNT_PAYABLE"
						+ " from sal s, customer c, other_brand o"
						+ " where s.customer_id= c.customer_id AND"
						+ " s.invoice_no = o.invoice_no and"
						+ " s.del_flg='N' group by s.invoice_no"
						+ " )as a order by date desc;");*/
		
		salesReports = (List<SalesReport>) getJdbcTemplate().query(sql.toString(), new TestDataSet());
		
		return salesReports;
	}
	
	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public List<SalesReport> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			List<SalesReport> salesReports = new ArrayList<SalesReport>();
			while (resultSet.next()) {
				SalesReport salesReport = new SalesReport();
				salesReport.setInvoiceNo(resultSet.getString("INVOICE_NO"));
				salesReport.setCustomerId(resultSet.getString("CUSTOMER_ID"));
				salesReport.setCustomerName(resultSet.getString("CUSTOMER_NAME"));				
				salesReport.setImei(resultSet.getString("IMEI"));
				salesReport.setQty(resultSet.getString("QUANTITY"));
				salesReport.setDate(resultSet.getString("DATE"));
				salesReport.setAmount(resultSet.getString("AMOUNT"));
				salesReport.setPromoDiscount(resultSet.getString("PROMO_DISCOUNT"));
				salesReport.setTax(resultSet.getString("TAX"));
				salesReport.setNetAmount(resultSet.getString("NET_AMOUNT"));
				salesReport.setAmountPayable(resultSet.getString("AMOUNT_PAYABLE"));
				salesReports.add(salesReport);
			}

			return salesReports;

		}
	
	}
}
