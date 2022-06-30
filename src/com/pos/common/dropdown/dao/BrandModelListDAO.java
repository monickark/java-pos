package com.pos.common.dropdown.dao;

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
public class BrandModelListDAO extends BaseDao implements IBrandModelListDAO {

	Logger logger = Logger.getLogger(BrandModelListDAO.class.getName());
	
	@SuppressWarnings("unchecked")
	@Override
	public List<BrandModelList> selectBrandModelList() {
		// TODO Auto-generated method stub
		
		 List<BrandModelList> brandModelList = new ArrayList<BrandModelList>();
		StringBuffer sql = new StringBuffer();
		sql.append("select MODEL_ID,Brand_ID,MODEL_VALUE from brand_model WHERE DEL_FLG='N'");
		
		brandModelList = (List<BrandModelList>) getJdbcTemplate().query(sql.toString(), new TestDataSet1());
		
		System.out.println("Brand Model List :" +brandModelList);
		System.out.println("Brand Model List size :" +brandModelList.size());
		return brandModelList;
	}

	@Override
	public void addBrandModel(final BrandModelList brandModelList)throws DuplicateEntryException  {
		StringBuffer query = new StringBuffer();
		query = query.append("insert into brand_model(DB_TS,MODEL_ID,BRAND_ID,MODEL_VALUE,DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID)"
				+ "values(?,?,?,?,?,now(),?,now(),?)");
		
		try {
			getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement pss) throws SQLException {
				pss.setInt(1,brandModelList.getDbTs());	
				pss.setString(2, brandModelList.getModelId());
				pss.setString(3, brandModelList.getBrandId());
				pss.setString(4, brandModelList.getModelValue());
				pss.setString(5, brandModelList.getDelFlg());
				pss.setString(6, brandModelList.getrCreId());
				pss.setString(7, brandModelList.getrModId());
					
				}
				
			});
	
	}
		 catch (DuplicateKeyException duplicateKeyException) {
				
				throw new DuplicateEntryException();
			}
	

}

class TestDataSet1 implements ResultSetExtractor {
	@Override
	public List<BrandModelList> extractData(ResultSet resultSet) throws SQLException, DataAccessException {

		List<BrandModelList> brandModelLists = new ArrayList<BrandModelList>();
		while (resultSet.next()) {
			BrandModelList brandModelList = new BrandModelList();
			brandModelList.setModelId(resultSet.getString("MODEL_ID"));
			brandModelList.setBrandId(resultSet.getString("BRAND_ID"));
			brandModelList.setModelValue(resultSet.getString("MODEL_VALUE"));
			brandModelLists.add(brandModelList);
			System.out.println("Model Inside DAo iteration :" +brandModelList);
			System.out.println("Model Inside DAo iteration list:" +brandModelLists);
		}

		return brandModelLists;

	}

}

@SuppressWarnings("unchecked")
@Override
public List<BrandModelList> selectBrandModelList(final String brand) throws NoDataFoundException {
	// TODO Auto-generated method stub
	
	 List<BrandModelList> brandModelList = new ArrayList<BrandModelList>();
	StringBuffer sql = new StringBuffer();
	sql.append("select MODEL_ID,MODEL_VALUE from brand_model WHERE BRAND_ID=? and DEL_FLG='N'");
	
	brandModelList = (List<BrandModelList>) getJdbcTemplate().query(sql.toString(),
			new PreparedStatementSetter() {

		@Override
		public void setValues(PreparedStatement pss)
				throws SQLException {
			pss.setString(1, brand);
		}

	},new ModelList());
	if (brandModelList == null) {
		throw new NoDataFoundException();
	}
	
	System.out.println("Brand Model List :" +brandModelList);
	System.out.println("Brand Model List size :" +brandModelList.size());
	return brandModelList;
}
class ModelList implements ResultSetExtractor {

	@Override
	public List<BrandModelList> extractData(ResultSet rs)
			throws SQLException, DataAccessException {
		List<BrandModelList> brandModelLists = new ArrayList<BrandModelList>();
		while (rs.next()) {
			BrandModelList brandModelList = new BrandModelList();
			brandModelList.setModelId(rs.getString("MODEL_ID"));
			brandModelList.setModelValue(rs.getString("MODEL_VALUE"));
			brandModelLists.add(brandModelList);
		}
		return brandModelLists;
	}
}

}
