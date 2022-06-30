package com.pos.product.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.dao.BaseDao;

@Repository
public class ProductInventoryListDAO extends BaseDao implements IProductInventoryListDAO{
	Logger logger = Logger.getLogger(ProductInventoryListDAO.class.getName());
	@Override
	public List<ProductInventory> selectProductInventory() throws NoDataFoundException{
		// TODO Auto-generated method stub
		List<ProductInventory> productMasters = new ArrayList<ProductInventory>();
		StringBuffer sql = new StringBuffer()
				.append("select INVENTORY_ID,date_format(INV_DATE, '%d/%m/%Y') as inv_date,b.brand_Value, bm.model_value, "
						+ "pi.PRODUCT_ID,pm.product_name,\r\n" + 
						"GROUP_CONCAT(DISTINCT(pi.COLOUR)) as colour,\r\n" + 
						"GROUP_CONCAT(IMEI) as IMEI,\r\n" + 
						"						count(IMEI) as Quantity from\r\n" + 
						"						product_inventory pi, productmaster pm, brand b, brand_model bm\r\n" + 
						"						where\r\n" + 
						"						pi.product_id = pm.product_id and\r\n" + 
						"            bm.brand_id = b.brand_Id and\r\n" + 
						"            pm.brand = b.brand_Id and\r\n" + 
						"            pm.model=bm.model_id and\r\n" + 
						"						pi.del_flg='N'\r\n" + 
						"						group by date_format(inv_date, '%Y-%m-%d'), pi.product_id\r\n" + 
						"						order by inv_date;");
		
		productMasters = (List<ProductInventory>) getJdbcTemplate().query(sql.toString(), new TestDataSet());

		return productMasters;
	}

	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public List<ProductInventory> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			List<ProductInventory> productList = new ArrayList<ProductInventory>();
			while (resultSet.next()) {
				ProductInventory product = new ProductInventory();
				product.setInventoryId(resultSet.getString("INVENTORY_ID"));
				product.setInventoryDate(resultSet.getString("INV_DATE"));
				product.setBrand(resultSet.getString("BRAND_VALUE"));
				product.setModel(resultSet.getString("MODEL_VALUE"));
				product.setProductId(resultSet.getString("PRODUCT_ID"));
				product.setProductName(resultSet.getString("product_name"));
				product.setColour(resultSet.getString("COLOUR"));
				product.setImei(resultSet.getString("IMEI"));
				product.setQuantity(resultSet.getString("Quantity"));
			

				productList.add(product);
			}

			return productList;

		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductInventory> viewProductInventory(final String productId, final String inventoryDate) throws NoDataFoundException {
		List<ProductInventory> productMasters = new ArrayList<ProductInventory>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT inventory_id,inv_date, pi.product_id, product_name, pi.colour, imei, cost_price, sell_price FROM product_inventory pi, productmaster pm\r\n" + 
				"where pm.product_id = pi.product_id and pi.product_id=? and date_format(INV_DATE, '%d/%m/%Y') = ? and pi.del_flg='N'");
		productMasters = (List<ProductInventory>) getJdbcTemplate().query(sql.toString(),
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement pss) throws SQLException {
						pss.setString(1, productId);
						pss.setString(2, inventoryDate);
					}
			
		},new ModelList());
		return productMasters;
	}

	
	@SuppressWarnings("rawtypes")
	class ModelList implements ResultSetExtractor {

		@Override
		public List<ProductInventory> extractData(ResultSet rs)
				throws SQLException, DataAccessException {
			List<ProductInventory> ProductInventories = new ArrayList<ProductInventory>();
			while (rs.next()) {
				ProductInventory productInventory = new ProductInventory();
				productInventory.setInventoryId(rs.getString("INVENTORY_ID"));
				productInventory.setInventoryDate(rs.getString("INV_DATE"));
				productInventory.setProductId(rs.getString("PRODUCT_ID"));
				productInventory.setProductName(rs.getString("PRODUCT_NAME"));
				productInventory.setColour(rs.getString("COLOUR"));
				productInventory.setImei(rs.getString("IMEI"));
				productInventory.setCostPrice(rs.getString("COST_PRICE"));
				productInventory.setSellPrice(rs.getString("SELL_PRICE"));
				
				
				
				ProductInventories.add(productInventory);
			}
			return ProductInventories;
		}
	}

	
}
