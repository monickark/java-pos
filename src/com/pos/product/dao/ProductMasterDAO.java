/*******************************************************************************
 * 2018, All rights reserved.
 *******************************************************************************/
package com.pos.product.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.framework.dao.BaseDao;
import com.pos.product.controller.ProductMasterVO;
import com.pos.product.dao.IProductMasterDAO;
import com.pos.product.dao.ProductMaster;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of ProductMasterDAO.
 * 
 * @author Ebidrive
 */
@Repository
public class ProductMasterDAO extends BaseDao implements IProductMasterDAO {
	Logger logger = Logger.getLogger(ProductMasterDAO.class);

	/**
	 * Description of the method insertProductMaster.
	 * 
	 * @param productMaster
	 * @throws DuplicateEntryException
	 */
	@Override
	public void insertProductMaster(final ProductMaster productMaster) throws DuplicateEntryException {
		// Start of user code for method insertProductMaster
		
		System.out.println("Inside Product Master insert :"+ productMaster);
		StringBuffer query = new StringBuffer();
		query = query.append("insert into ptmt(DB_TS,PRODUCT_ID,PRODUCT_NAME,CATEGORY,BRAND,COLOUR,MODEL,SIM_TYPE,"
				+ "SIM_CARD_SIZE,DIMENSIONS,DISPLAY,BATTERY,NON_REMOVAL_BATTERY,RAM_CAPACITY,OS,DESCRIPTION,"
				+ "PUBLISHED,DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?,now(),?)");
		logger.debug(" Executing prepared SQL query");
		try {
			getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement preparedStatement) throws SQLException {
					preparedStatement.setInt(1, productMaster.getDbTs());
					preparedStatement.setString(2, productMaster.getProductId());
					preparedStatement.setString(3, productMaster.getProductName());
					preparedStatement.setString(4, productMaster.getCategory());
					preparedStatement.setString(5, productMaster.getBrand());
					preparedStatement.setString(6, productMaster.getColour());
					preparedStatement.setString(7, productMaster.getModel());
					preparedStatement.setString(8, productMaster.getSimType());
					preparedStatement.setString(9, productMaster.getSimCardSize());
					preparedStatement.setString(10, productMaster.getDimensions());
					preparedStatement.setString(11, productMaster.getDisplay());
					preparedStatement.setString(12, productMaster.getBattery());
					preparedStatement.setString(13, productMaster.getNonRemovalBattery());
					preparedStatement.setString(14, productMaster.getRamCapacity());
					preparedStatement.setString(15, productMaster.getOs());
					preparedStatement.setString(16, productMaster.getDescription());
					
					preparedStatement.setString(17, productMaster.getPublished());
					preparedStatement.setString(18, productMaster.getDelFlg());
					preparedStatement.setString(19, productMaster.getRCreId());
					preparedStatement.setString(20, productMaster.getRModId());
				}
			});
		} catch (DuplicateKeyException duplicateKeyException) {
			logger.debug("Duplicate Entry");
			throw new DuplicateEntryException();
		}
		// End of user code
	}

	public List<ProductMaster> selectProductMaster() throws NoDataFoundException {
		List<ProductMaster> productMasters = new ArrayList<ProductMaster>();
		StringBuffer sql = new StringBuffer()
				.append("SELECT p.DB_TS, PRODUCT_ID, PRODUCT_NAME,BRAND as brand_id, category, b.brand_value as brand,  "
						+ "COLOUR, MODEL as model_id, bm.model_value as model,\r\n" + 
						"SIM_TYPE, SIM_CARD_SIZE, DIMENSIONS, DISPLAY, BATTERY, NON_REMOVAL_BATTERY, RAM_CAPACITY,\r\n" + 
						"OS, DESCRIPTION, SHORT_DESCRIPTION, PUBLISHED\r\n" + 
						"FROM\r\n" + 
						"productmaster p, brand b, brand_model bm\r\n" + 
						"where\r\n" + 
						"p.brand = b.brand_id and\r\n" + 
						"bm.brand_id = b.brand_id and\r\n" + 
						"bm.brand_id = p.brand and\r\n" + 
						"p.model = bm.model_id and\r\n" + 
						"p.del_flg='N';");
		productMasters = (List<ProductMaster>) getJdbcTemplate().query(sql.toString(), new TestDataSet());

		return productMasters;

	}

	@SuppressWarnings("rawtypes")
	class TestDataSet implements ResultSetExtractor {
		@Override
		public List<ProductMaster> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
			List<ProductMaster> productMasters = new ArrayList<ProductMaster>();
			while (resultSet.next()) {
				ProductMaster productMaster = new ProductMaster();
				productMaster.setProductId(resultSet.getString("PRODUCT_ID"));
				productMaster.setProductName(resultSet.getString("PRODUCT_NAME"));
				productMaster.setCategory(resultSet.getString("CATEGORY"));
				productMaster.setBrand(resultSet.getString("BRAND"));
				productMaster.setColour(resultSet.getString("COLOUR"));
				productMaster.setModel(resultSet.getString("MODEL"));
				productMaster.setSimType(resultSet.getString("SIM_TYPE"));
				productMaster.setSimCardSize(resultSet.getString("SIM_CARD_SIZE"));
				productMaster.setDimensions(resultSet.getString("DIMENSIONS"));
				productMaster.setDisplay(resultSet.getString("DISPLAY"));
				productMaster.setBattery(resultSet.getString("BATTERY"));
				productMaster.setNonRemovalBattery(resultSet.getString("NON_REMOVAL_BATTERY"));
				productMaster.setRamCapacity(resultSet.getString("RAM_CAPACITY"));
				productMaster.setOs(resultSet.getString("OS"));
				productMaster.setDescription(resultSet.getString("DESCRIPTION"));
				productMaster.setPublished(resultSet.getString("PUBLISHED"));

				productMasters.add(productMaster);
			}

			return productMasters;

		}
	}

	@SuppressWarnings("unchecked")
	public ProductMaster viewProduct(final ProductMaster productMaster) throws NoDataFoundException {
		ProductMaster productMaster1 = null;
		StringBuffer query = new StringBuffer()

				.append("select PRODUCT_ID,PRODUCT_NAME,CATEGORY,BRAND,COLOUR,MODEL,SIM_TYPE,SIM_CARD_SIZE,DIMENSIONS,DISPLAY,BATTERY,\"\r\n"
						+ "						+ \"NON_REMOVAL_BATTERY,RAM_CAPACITY,OS,DESCRIPTION,PUBLISHED from ptmt where PRODUCT_ID=?; ");
		productMaster1 = (ProductMaster) getJdbcTemplate().query(query.toString(), new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, productMaster.getProductId());

			}

		}, new TestDataSet1());
		System.out.println("Product Object in dao: " + productMaster1);

		return productMaster1;
	}

	

	@Override
	public void editProductMaster(final ProductMaster productMaster) throws UpdateFailedException {
		// TODO Auto-generated method stub
		System.out.println("Product Master in dao" + productMaster);
		StringBuffer query = new StringBuffer();
		query = query.append(
				"update ptmt set DB_TS=?,CATEGORY=?,COLOUR=?,SIM_TYPE=?,"
				+ "SIM_CARD_SIZE=?,DIMENSIONS=?,DISPLAY=?,BATTERY=?,NON_REMOVAL_BATTERY=?,RAM_CAPACITY=?,OS=?,DESCRIPTION=?,"
				+ "PUBLISHED=?,R_MOD_TIME=now() WHERE PRODUCT_ID=?");

		System.out.println(" Query  :" + query);
		getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pss) throws SQLException {
				// TODO Auto-generated method stub
				pss.setInt(1, 1);
				pss.setString(2, productMaster.getCategory());
				pss.setString(3, productMaster.getColour());
				pss.setString(4, productMaster.getSimType());
				pss.setString(5, productMaster.getSimCardSize());
				pss.setString(6, productMaster.getDimensions());
				pss.setString(7, productMaster.getDisplay());
				pss.setString(8, productMaster.getBattery());
				pss.setString(9, productMaster.getNonRemovalBattery());
				pss.setString(10, productMaster.getRamCapacity());
				pss.setString(11, productMaster.getOs());
				pss.setString(12, productMaster.getDescription());
				pss.setString(13, productMaster.getPublished());
				pss.setString(14, productMaster.getProductId());
			}

		});

	}

	@SuppressWarnings("unchecked")
	@Override
	public ProductMaster selectProductMaster(final ProductMaster productMaster) throws UpdateFailedException {

		System.out.println("ProductId in DAO" + productMaster);
		ProductMaster pm = new ProductMaster();
		StringBuffer query = new StringBuffer()

				.append("select p.DB_TS,PRODUCT_ID,PRODUCT_NAME,CATEGORY,BRAND_VALUE AS BRAND,COLOUR,"
						+ " MODEL_VALUE AS MODEL,SIM_TYPE,SIM_CARD_SIZE,DIMENSIONS,DISPLAY,BATTERY,NON_REMOVAL_BATTERY,"
						+ " RAM_CAPACITY,OS,DESCRIPTION,PUBLISHED from ptmt p, brand b, brand_model bm where "
						+ " P.BRAND = B.BRAND_ID AND P.MODEL = BM.MODEL_ID AND B.BRAND_ID = BM.BRAND_ID AND"
						+ " PRODUCT_ID=?; ");

		pm = (ProductMaster) getJdbcTemplate().query(query.toString(), new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pss) throws SQLException {
				pss.setString(1, productMaster.getProductId());

			}

		}, new TestDataSet1());

		return pm;
	}

	@Override
	public void deleteProduct(final ProductMaster pm) {
		// TODO Auto-generated method stub
		StringBuffer query=new StringBuffer();
		query=query.append("update ptmt set DB_TS=?,CATEGORY=?,COLOUR=?,SIM_TYPE=?,"
				+ "SIM_CARD_SIZE=?,DIMENSIONS=?,DISPLAY=?,BATTERY=?,NON_REMOVAL_BATTERY=?,RAM_CAPACITY=?,OS=?,DESCRIPTION=?,"
				+ "PUBLISHED=?,DEL_FLG=?,R_MOD_TIME=now() WHERE PRODUCT_ID=?");
		System.out.println("JDBC in delete:" + getJdbcTemplate());
		System.out.println("Product Master in delete:" + pm.toString());
		int changedrows=getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pss) throws SQLException {
				// TODO Auto-generated method stub
				pss.setInt(1, 1);
				pss.setString(2, pm.getCategory());
				pss.setString(3, pm.getColour());
				pss.setString(4, pm.getSimType());
				pss.setString(5, pm.getSimCardSize());
				pss.setString(6, pm.getDimensions());
				pss.setString(7, pm.getDisplay());
				pss.setString(8, pm.getBattery());
				pss.setString(9, pm.getNonRemovalBattery());
				pss.setString(10, pm.getRamCapacity());
				pss.setString(11, pm.getOs());
				pss.setString(12, pm.getDescription());
				pss.setString(13, pm.getPublished());
				pss.setString(14, "Y");
				pss.setString(15, pm.getProductId());
			}
			
		});
		if(changedrows==0) {
			System.out.println("No data updated");
		}
		
	}

	
	
	@SuppressWarnings("rawtypes")
	class TestDataSet1 implements ResultSetExtractor {
		@Override
		public ProductMaster extractData(ResultSet resultSet) throws SQLException, DataAccessException {

			ProductMaster productMaster = new ProductMaster();
			if (resultSet.next()) {
				productMaster.setDbTs(resultSet.getInt("DB_TS"));
				productMaster.setProductId(resultSet.getString("PRODUCT_ID"));
				productMaster.setProductName(resultSet.getString("PRODUCT_NAME"));
				productMaster.setCategory(resultSet.getString("CATEGORY"));
				productMaster.setBrand(resultSet.getString("BRAND"));
				productMaster.setColour(resultSet.getString("COLOUR"));
				productMaster.setModel(resultSet.getString("MODEL"));
				productMaster.setSimType(resultSet.getString("SIM_TYPE"));
				productMaster.setSimCardSize(resultSet.getString("SIM_CARD_SIZE"));
				productMaster.setDimensions(resultSet.getString("DIMENSIONS"));
				productMaster.setDisplay(resultSet.getString("DISPLAY"));
				productMaster.setBattery(resultSet.getString("BATTERY"));
				productMaster.setNonRemovalBattery(resultSet.getString("NON_REMOVAL_BATTERY"));
				productMaster.setRamCapacity(resultSet.getString("RAM_CAPACITY"));
				productMaster.setOs(resultSet.getString("OS"));
				productMaster.setDescription(resultSet.getString("DESCRIPTION"));
				productMaster.setPublished(resultSet.getString("PUBLISHED"));
			}

			return productMaster;
		}

	}

}
