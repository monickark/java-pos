package com.pos.framework.seqGen.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pos.common.constants.ApplicationConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.framework.dao.BaseDao;
import com.pos.framework.seqGen.service.SimpleIdGeneratorService;

//Dao class for Batch Sequence Id Generation
@Repository("simpleIdGenDao")
public class SimpleIdGeneratorDao extends BaseDao implements IIdGeneratorDao {

	// Logging
	Logger logger = Logger.getLogger(SimpleIdGeneratorService.class);

	// method to get Sequence
	@Override
	public int getIdForSequence(final String key) throws DatabaseException {

		int ID = 0;
		logger.debug("Inside select method");

		StringBuffer sql = new StringBuffer();

		sql = sql.append("SELECT ").append("NEXT_SEQUENCE_NO ")
				.append("FROM sequ ").append("WHERE SEQUENCE_TYPE = ?;");

		ID = getJdbcTemplate().query(sql.toString(),
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement pss)
							throws SQLException {
						pss.setString(1, key);
					}

				}, new ResultSetExtractor<Integer>() {

					@Override
					public Integer extractData(ResultSet rs)
							throws SQLException, DataAccessException {

						Integer idNo = null;
						if (rs.next()) {
							idNo = rs.getInt("NEXT_SEQUENCE_NO");
						}

						return idNo;
					}

				});
		final Integer nextSequ = (ID + ApplicationConstant.SIMPLE_ID_GEN_INC);
		logger.debug("select query :" + sql.toString());

		StringBuffer sqlQuery = new StringBuffer();
		sqlQuery = sqlQuery.append("UPDATE sequ set")
				.append(" NEXT_SEQUENCE_NO=?")
				.append(" where SEQUENCE_TYPE =?");
		int updateStatus = getJdbcTemplate().update(sqlQuery.toString(),
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setInt(1, nextSequ);
						ps.setString(2, key);

					}

				});
		if (updateStatus == 0) {
			throw new DatabaseException();

		}
		logger.debug("update query :" + sqlQuery.toString());
		return ID;
	}

}
