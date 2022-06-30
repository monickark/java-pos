package com.pos.accessories.dao;

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
public class AddAccessoriesDAO extends BaseDao implements IAddAccessoriesDAO{

	Logger logger = Logger.getLogger(AddAccessoriesDAO.class.getName());
	@Override
	public void insertAddAccessories(final AddAccessories addAccessories) throws DuplicateEntryException{
		
		StringBuffer query = new StringBuffer();
		query = query.append("insert into accessories(DB_TS,ACCESSORIES_ID,CATEGORY,BRAND,NAME,DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID)"
				+ "values(?,?,?,?,?,?,now(),?,now(),?)");
		try {
			getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement pss) throws SQLException {
					pss.setInt(1, addAccessories.getDbts());
					pss.setString(2, addAccessories.getAccessoriesId());
					pss.setString(3, addAccessories.getCategory());
					pss.setString(4, addAccessories.getBrand());
					pss.setString(5, addAccessories.getName());
					pss.setString(6, addAccessories.getDelFlg());
					pss.setString(7, addAccessories.getrCreId());
					pss.setString(8, addAccessories.getrModId());
					
					
				}
				
			});
		}catch (DuplicateKeyException duplicateKeyException) {
			
			throw new DuplicateEntryException();
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<AddAccessories> selectBrand(final String category) throws NoDataFoundException{
		
		List<AddAccessories> addAccessories = new ArrayList<AddAccessories>();
		StringBuffer sql = new StringBuffer();
		sql.append("select b.BRAND_VALUE,a.BRAND from accessories a left join brand b on b.BRAND_ID=a.BRAND WHERE a.CATEGORY=? and a.DEL_FLG='N'");
		addAccessories = (List<AddAccessories>) getJdbcTemplate().query(sql.toString(),
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement pss) throws SQLException {
						
						pss.setString(1, category);
					}
			
		},new ModelList1());
		System.out.println("Acc:"+addAccessories);
		if(addAccessories.size()==0){
			throw new NoDataFoundException();
		}
		return addAccessories;
	}
	
	@SuppressWarnings("rawtypes")
	class ModelList1 implements ResultSetExtractor {

		@Override
		public List<AddAccessories> extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			List<AddAccessories> addAccessoriess = new ArrayList<AddAccessories>();
			while (rs.next()) {
				AddAccessories addAccessories = new AddAccessories();
				addAccessories.setAccessoriesId(rs.getString("BRAND"));
				addAccessories.setBrand(rs.getString("BRAND_VALUE"));
				addAccessoriess.add(addAccessories);
			}
			return addAccessoriess;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AddAccessories> selectName(final String category, final String brand) throws NoDataFoundException{
		
		List<AddAccessories> addAccessories = new ArrayList<AddAccessories>();
		StringBuffer sql = new StringBuffer();
		sql.append("select ACCESSORIES_ID,NAME from accessories WHERE BRAND=? and CATEGORY=? and DEL_FLG='N'");
		addAccessories = (List<AddAccessories>) getJdbcTemplate().query(sql.toString(),
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement pss) throws SQLException {
						pss.setString(1, brand);
						pss.setString(2, category);
					}
			
		},new ModelList());
		if(addAccessories.size()==0){
			throw new NoDataFoundException();
		}
		return addAccessories;
	}
	
	@SuppressWarnings("rawtypes")
	class ModelList implements ResultSetExtractor {

		@Override
		public List<AddAccessories> extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			List<AddAccessories> addAccessoriess = new ArrayList<AddAccessories>();
			while (rs.next()) {
				AddAccessories addAccessories = new AddAccessories();
				addAccessories.setAccessoriesId(rs.getString("ACCESSORIES_ID"));
				addAccessories.setName(rs.getString("NAME"));
				addAccessoriess.add(addAccessories);
			}
			return addAccessoriess;
		}
	}
}
