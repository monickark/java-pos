package com.pos.common.dropdown.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.dao.BaseDao;



@Repository
public class CategoryDAO extends BaseDao implements ICategoryDAO {

	Logger logger = Logger.getLogger(CategoryDAO.class);
	@Override
	public List<Category> selectCategory()  throws NoDataFoundException  {
		
		 
		StringBuffer sql = new StringBuffer();
		sql.append("select CATEGORY_ID,CATEGORY_NAME from category WHERE DEL_FLG='N'");
		List<Category> category = new ArrayList<Category>();
		category = (List<Category>) getJdbcTemplate().query(sql.toString(), new TestDataSet());
		if(category.size()==0){
			throw new NoDataFoundException();
		}
		return category;
	}

	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public List<Category> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			List<Category> categories= new ArrayList<Category>();
			
			while (resultSet.next()) {
				Category category = new Category();
				category.setCategoryId(resultSet.getString("CATEGORY_ID"));
				category.setCategoryName(resultSet.getString("CATEGORY_NAME"));
				categories.add(category);
			}
			return categories;

		}
	}
}
