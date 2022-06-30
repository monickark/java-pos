package com.pos.accessories.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.framework.dao.BaseDao;


@Repository
public class AccessoriesListDAO extends BaseDao implements IAccessoriesListDAO {

	@Override
	public List<AccessoriesList> selectAccessoriesList()throws DuplicateEntryException {
		
		List<AccessoriesList> accessoriesLists = new ArrayList<AccessoriesList>();
		StringBuffer sql = new StringBuffer()
				.append("select category_name as category, brand_value as brand, name as name, quantity, cost_price, selling_price\r\n" + 
						"from accessories ac, accessories_inventory ai, category c, brand b\r\n" + 
						"where\r\n" + 
						"ac.brand = b.brand_id and\r\n" + 
						"c.category_id = ac.category and\r\n" + 
						"ac.accessories_id = ai.accessories_id;");
		accessoriesLists = (List<AccessoriesList>) getJdbcTemplate().query(sql.toString(), new TestDataSet());
		System.out.println("ACC List Dao" +accessoriesLists);
		return accessoriesLists;
	}

	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public List<AccessoriesList> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			List<AccessoriesList> accessoriesLists = new ArrayList<AccessoriesList>();
			while (resultSet.next()) {
				AccessoriesList accessoriesList = new AccessoriesList();
				accessoriesList.setCategory(resultSet.getString("category"));
				accessoriesList.setBrand(resultSet.getString("brand"));
				accessoriesList.setName(resultSet.getString("name"));
				accessoriesList.setQuantity(resultSet.getString("quantity"));
				accessoriesList.setCostPrice(resultSet.getString("cost_price"));
				accessoriesList.setSellingPrice(resultSet.getString("selling_price"));

				accessoriesLists.add(accessoriesList);
			}

			return accessoriesLists;

		}
	}
}
