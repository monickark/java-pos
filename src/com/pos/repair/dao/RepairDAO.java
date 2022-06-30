package com.pos.repair.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.framework.dao.BaseDao;

@Repository
public class RepairDAO extends BaseDao implements IRepairDAO{

	@Override
	public void addRepair(final Repair repair) throws DuplicateEntryException {
		
		StringBuffer query = new StringBuffer();
		query = query.append("insert into repair(DB_TS,REPAIR_ID,NAME,CONTACT_NO,PRODUCT_NAME,REASON,REPAIR_VALUE,"
				+ "DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID)"
				+ "values(?,?,?,?,?,?,?,?,now(),?,now(),?)");
		try {
			getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement preparedStatement) throws SQLException {
					
					preparedStatement.setInt(1, repair.getDbTs());
					preparedStatement.setString(2, repair.getRepairId());
					preparedStatement.setString(3, repair.getName());
					preparedStatement.setString(4, repair.getContactNo());
					preparedStatement.setString(5, repair.getProductName());
					preparedStatement.setString(6, repair.getReason());
					preparedStatement.setString(7, repair.getRepairValue());
					preparedStatement.setString(8, repair.getDelFlg());
					preparedStatement.setString(9, repair.getrCreId());
					preparedStatement.setString(10, repair.getrModId());
				}
				
			});
		}catch (DuplicateKeyException duplicateKeyException) {
			
			throw new DuplicateEntryException();
		}
	}



}
