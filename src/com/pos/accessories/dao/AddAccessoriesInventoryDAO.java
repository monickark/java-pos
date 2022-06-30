package com.pos.accessories.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.dao.BaseDao;

@Repository
public class AddAccessoriesInventoryDAO extends BaseDao implements IAddAccessoriesInventoryDAO {

	@Override
	public void insertAccessoriesInventory(final AddAccessoriesInventory addAccessoriesInventory)throws DuplicateEntryException {
		
		StringBuffer query = new StringBuffer();
		query = query.append("insert into accessories_inventory(DB_TS,INVENTORY_ID,ACCESSORIES_ID,QUANTITY,COST_PRICE, SELLING_PRICE,SHORT_DESCRIPTION,"
				+ "DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID)"
				+ "values(?,?,?,?,?,?,?,?,now(),?,now(),?)");
		try {
			getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement pss) throws SQLException {
					pss.setInt(1, addAccessoriesInventory.getDbTs());
					pss.setString(2, addAccessoriesInventory.getAccessoriesInventoryId());
					pss.setString(3, addAccessoriesInventory.getAccessoriesId());
					pss.setString(4, addAccessoriesInventory.getQuantity());
					pss.setString(5, addAccessoriesInventory.getCostPrice());
					pss.setString(6, addAccessoriesInventory.getSellingPrice());
					pss.setString(7, addAccessoriesInventory.getShortDescription());
					pss.setString(8, addAccessoriesInventory.getDelFlg());
					pss.setString(9, addAccessoriesInventory.getrCreId());
					pss.setString(10, addAccessoriesInventory.getrModId());
					
				}
				
			});
		}catch (DuplicateKeyException duplicateKeyException) {
			
			throw new DuplicateEntryException();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public AddAccessoriesInventory getList(final String accessoriesId) throws NoDataFoundException{
		
		StringBuffer sql = new StringBuffer();
		sql.append("select INVENTORY_ID,QUANTITY,COST_PRICE,SELLING_PRICE,SHORT_DESCRIPTION from accessories_inventory WHERE ACCESSORIES_ID=? and DEL_FLG='N'");
		AddAccessoriesInventory addAccessoriesInventory = (AddAccessoriesInventory) getJdbcTemplate().query(sql.toString(),
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement pss) throws SQLException {
						pss.setString(1, accessoriesId);	
						
					}
			
		},new ModelList3());
		if(addAccessoriesInventory==null){
			throw new NoDataFoundException();
		}
		return addAccessoriesInventory;
	}


	@SuppressWarnings("rawtypes")
	class ModelList3 implements ResultSetExtractor {

		@Override
		public AddAccessoriesInventory extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			AddAccessoriesInventory addAccessoriesInventory = null;
			while (rs.next()) {
				addAccessoriesInventory = new AddAccessoriesInventory();
				addAccessoriesInventory.setAccessoriesInventoryId(rs.getString("INVENTORY_ID"));
				addAccessoriesInventory.setQuantity(rs.getString("QUANTITY"));
				addAccessoriesInventory.setCostPrice(rs.getString("COST_PRICE"));
				addAccessoriesInventory.setSellingPrice(rs.getString("SELLING_PRICE"));
				addAccessoriesInventory.setShortDescription(rs.getString("SHORT_DESCRIPTION"));
			}
			return addAccessoriesInventory;
		}
	}
	
	@Override
	public void updateAccessoryInventory(final String accessoryId,final String qty, final String rModId) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		query=query.append("update accessories_inventory set QUANTITY=QUANTITY-"+qty+", R_MOD_TIME=now(), R_MOD_ID=? WHERE ACCESSORIES_ID=?");
		System.out.println("JDBC in delete:" + getJdbcTemplate());
		int changedrows=getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pss) throws SQLException {
				// TODO Auto-generated method stub
				pss.setString(1, rModId);
				pss.setString(2, accessoryId);
			}
			
		});
		if(changedrows==0) {
			System.out.println("No data updated");
		}
		
	}
	
	

}
