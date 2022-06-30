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
public class TillReportDAO extends BaseDao implements ITillReportDAO {

	@Override
	public List<TillReport> selectTillReport() throws NoDataFoundException {
		
			List<TillReport> tillReports = new ArrayList<TillReport>();
			StringBuffer sql = new StringBuffer()
					.append("select date_format(t.date, '%d/%m/%Y') as date, sum(t.amount)  as open_balance , sum(s.amount) as sales,\r\n" + 
							"sum(t.amount) + sum(s.amount) as close_balance\r\n" + 
							"from till t, sales s\r\n" + 
							"where\r\n" + 
							"date_format(s.date, '%Y-%m-%d') = date_format(t.date, '%Y-%m-%d')\r\n" + 
							"group by\r\n" + 
							"date_format(t.date, '%Y-%m-%d'); ");
			tillReports = (List<TillReport>) getJdbcTemplate().query(sql.toString(), new TestDataSet());
			
			return tillReports;
		}
	
	
	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public List<TillReport> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			List<TillReport> tillReports = new ArrayList<TillReport>();
			while (resultSet.next()) {
				TillReport tillReport = new TillReport();
				tillReport.setOpen_balance(resultSet.getString("OPEN_BALANCE"));
				tillReport.setSales(resultSet.getString("SALES"));
				tillReport.setClose_balance(resultSet.getString("CLOSE_BALANCE"));
				tillReport.setDate(resultSet.getString("DATE"));
				
				tillReports.add(tillReport);
			}

			return tillReports;

		}
	
	}
}
