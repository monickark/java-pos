package com.pos.accessories.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.framework.dao.BaseDao;

@Repository
public class AddCategoryDAO extends BaseDao implements IAddCategoryDAO{

	Logger logger = Logger.getLogger(AddCategoryDAO.class);
	@Override
	public void insertCategory(final AddCategory addCategory)throws DuplicateEntryException {
		
		StringBuffer query = new StringBuffer();
		query = query.append("insert into category(DB_TS,CATEGORY_ID,CATEGORY_NAME,DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID)"
				+ "values(?,?,?,?,now(),?,now(),?)");
		logger.debug(" Executing prepared SQL query");
		try {
			getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement pss) throws SQLException {
					pss.setInt(1, addCategory.getDbTs());
					pss.setString(2, addCategory.getCategoryId());
					pss.setString(3, addCategory.getCategoryName());
					pss.setString(4, addCategory.getDelFlg());
					pss.setString(5, addCategory.getrCreId());
					pss.setString(6, addCategory.getrModId());
					
				}
				
			});
		}catch (DuplicateKeyException duplicateKeyException) {
			logger.debug("Duplicate Entry");
			throw new DuplicateEntryException();
		}
	}

}
