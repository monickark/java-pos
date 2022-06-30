package com.pos.till.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class TillDAO extends BaseDao implements ITillDAO {

	Logger logger = Logger.getLogger(TillDAO.class.getName());
	@Override
	public void addTill(final Till till) throws DuplicateEntryException{
		// TODO Auto-generated method stub
		StringBuffer query = new StringBuffer();
		query = query.append("insert into till(DB_TS,TILL_ID,DATE,AMOUNT,DESCRIPTION,STATUS,"
				+ "DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID)"
				+ "values(?,?,?,?,?,?,?,now(),?,now(),?)");
		try {
			getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement pss) throws SQLException {
					// TODO Auto-generated method stub
					pss.setInt(1,till.getDbTs());
					pss.setString(2, till.getTillId());
					pss.setString(3, till.getDate());
					pss.setString(4, till.getAmount());
					pss.setString(5, till.getDescription());
					pss.setString(6, till.getStatus());
					pss.setString(7, till.getDelFlg());
					pss.setString(8, till.getrCreId());
					pss.setString(9, till.getrModId());
				}
				
			});
		
	}
		catch (DuplicateKeyException duplicateKeyException) {
			
			throw new DuplicateEntryException();
		}


}
	@Override
	public List<Till> selectTill()throws NoDataFoundException {
		
		List<Till> tills = new ArrayList<Till>();
		StringBuffer sql = new StringBuffer()
				.append("select  amount, description  from till where del_flg!='C' and date(date)=curdate() union"
						+ " select  COALESCE(sum(amount_payable),0) as amount , 'Sales' as description FROM sales s where"
						+ " del_flg='N'and date(date)=curdate(); ");
		tills = (List<Till>) getJdbcTemplate().query(sql.toString(), new TestDataSet());
		
		return tills;
	}
	
	@Override
	public Till selectTillObj() throws NoDataFoundException {
		Till till;
		StringBuffer sql = new StringBuffer()
				.append("select * from till where date_format(date, '%Y-%m-%d') = curdate() and status ='open';");
		till = (Till) getJdbcTemplate().query(sql.toString(), new TillObject());
		if(till==null){
			throw new NoDataFoundException();
		}
		return till;
	}
	
	
	@SuppressWarnings("rawtypes")
	class TillObject implements ResultSetExtractor {
		@Override
		public Till extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			Till till=null;
			while (resultSet.next()) {
				till = new Till();
				till.setDescription(resultSet.getString("DESCRIPTION"));				
				till.setAmount(resultSet.getString("AMOUNT"));			
			}
			return till;
		}
	
	}
	
	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public List<Till> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			List<Till> tills = new ArrayList<Till>();
			while (resultSet.next()) {
				Till till = new Till();
				till.setDescription(resultSet.getString("DESCRIPTION"));
				
				till.setAmount(resultSet.getString("AMOUNT"));
				
				
				tills.add(till);
			}

			return tills;

		}
	
	}
	
	@Override
	public void updateTill(String status){
		// TODO Auto-generated method stub
		StringBuffer query = new StringBuffer();
		query = query.append("update till set status ='"+status+"' where date_format(date, '%Y-%m-%d') = curdate();");
			getJdbcTemplate().update(query.toString());
		
	
}
	
	
	
}
