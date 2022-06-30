package com.pos.product.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.framework.dao.BaseDao;
@Repository 
public class ProductInventoryDAO extends BaseDao implements IProductInventoryDAO {
	Logger logger = Logger.getLogger(ProductInventoryDAO.class);
	@Override
	public void insertProductInventory(final ProductMaster productMaster)throws DuplicateEntryException {
		// TODO Auto-generated method stub
		System.out.println("Product InventoryDAO :" +productMaster);
		StringBuffer query = new StringBuffer();
		query = query.append("insert into ptiv(DB_TS,INVENTORY_ID,INV_DATE,PRODUCT_ID,COLOUR,"
				+ "IMEI,COST_PRICE,SELL_PRICE,DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID) "
				+ "values(?,?,?,?,?,?,?,?,?,now(),?,now(),?)");
		try {
			getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement pss) throws SQLException {
					// TODO Auto-generated method stub
					pss.setInt(1,productMaster.getDbTs());
					pss.setString(2,productMaster.getInventoryId());
					pss.setString(3, productMaster.getInvoiceDate());
					pss.setString(4, productMaster.getProductId());
					pss.setString(5, productMaster.getColour());
					pss.setString(6, productMaster.getImei());
					pss.setString(7, productMaster.getCostPrice());
					pss.setString(8, productMaster.getSellPrice());
					pss.setString(9, productMaster.getDelFlg());
					pss.setString(10, productMaster.getRCreId());
					pss.setString(11, productMaster.getRModId());
					
				}
				
			});
		}
		catch (DuplicateKeyException duplicateKeyException){
			logger.debug("Duplicate Entry");
			throw new DuplicateEntryException();
		}
		
	}
	
	
	@Override
	public void deleteProductInventory(final String imei,final String rModId) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		query=query.append("update ptiv set DEL_FLG=?, R_MOD_TIME=now(), R_MOD_ID=? WHERE IMEI=?");
		System.out.println("JDBC in delete:" + getJdbcTemplate());
		int changedrows=getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pss) throws SQLException {
				// TODO Auto-generated method stub
				pss.setString(1, "Y");
				pss.setString(2, rModId);
				pss.setString(3, imei);
			}
			
		});
		if(changedrows==0) {
			System.out.println("No data updated");
		}
		
	}

}
