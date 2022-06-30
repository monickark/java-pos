package com.pos.common.dropdown.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.framework.dao.BaseDao;

@Repository
public class BrandListDAO extends BaseDao implements IBrandListDAO{
	Logger logger = Logger.getLogger(BrandListDAO.class.getName());
	@Override
	public List<BrandList> selectBrandList() {
		// TODO Auto-generated method stub
		List<BrandList> brandList = new ArrayList<BrandList>();
		StringBuffer sql = new StringBuffer();
		sql.append("select BRAND_ID,BRAND_VALUE from brand WHERE DEL_FLG='N'");
		brandList = (List<BrandList>) getJdbcTemplate().query(sql.toString(),new TestDataSet());
		System.out.println("Brand List :" +brandList);
		System.out.println("Brand List size :" +brandList.size());
		return brandList;
	}
	
	

	@Override
	public void addBrand(final BrandList brandList)throws DuplicateEntryException {
		StringBuffer query = new StringBuffer();
		query = query.append("insert into bd(DB_TS,BRAND_ID,BRAND_VALUE,DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID)"
				+ "values(?,?,?,?,now(),?,now(),?)");
		
		logger.debug(" Executing prepared SQL query");
		try {
			getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement pss) throws SQLException {
					// TODO Auto-generated method stub
					pss.setInt(1, brandList.getDbTs());
					pss.setString(2, brandList.getBrandId());
					pss.setString(3, brandList.getBrandName());
					pss.setString(4, brandList.getDelFlg());
					pss.setString(5, brandList.getrCreId());
					pss.setString(6, brandList.getrModId());
				}
				
			});
	}
		 catch (DuplicateKeyException duplicateKeyException) {
				logger.debug("Duplicate Entry");
				throw new DuplicateEntryException();
			}

}


}

class TestDataSet implements ResultSetExtractor {
	@Override
	public List<BrandList> extractData(ResultSet resultSet) throws SQLException, DataAccessException {

		List<BrandList> brandLists = new ArrayList<BrandList>();
		while (resultSet.next()) {
			BrandList brandList = new BrandList();
			brandList.setBrandId(resultSet.getString("BRAND_ID"));
			brandList.setBrandName(resultSet.getString("BRAND_VALUE"));
			brandLists.add(brandList);
			System.out.println("Inside DAo iteration :" +brandList);
			System.out.println("Inside DAo iteration list:" +brandLists);
		}

		return brandLists;
	}

}

