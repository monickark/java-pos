package com.pos.settings.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.framework.dao.BaseDao;

@Repository
public class SettingsDAO extends BaseDao implements ISettingsDAO {

	Logger logger = Logger.getLogger(SettingsDAO.class);

	@Override
	public void insertSetting(final Settings setting)
			throws DuplicateEntryException {

		StringBuffer query = new StringBuffer();
		query = query
				.append("insert into company(DB_TS,COMPANY_ID,ADDRESS_1,ADDRESS_2,LICENSE_NO,MOBILE_NO,EMAIL,PROMO_DISCOUNT,TAX,PRINTER_NAME,"
						+ "DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID)"
						+ "values(?,?,?,?,?,?,?,?,?,?,?,now(),?,now(),?)");
		logger.debug(" Executing prepared SQL query");
		try {
			getJdbcTemplate().update(query.toString(),
					new PreparedStatementSetter() {

						@Override
						public void setValues(PreparedStatement pss)
								throws SQLException {
							pss.setInt(1, setting.getDbTs());
							pss.setString(2, setting.getCompanyId());
							pss.setString(3, setting.getAddress1());
							pss.setString(4, setting.getAddress2());
							pss.setString(5, setting.getLicenseNo());
							pss.setString(6, setting.getMobileNo());
							pss.setString(7, setting.getEmail());
							pss.setString(8, setting.getPromoDiscount());
							pss.setString(9, setting.getTax());
							pss.setString(10, setting.getPrinterName());
							pss.setString(11, setting.getDelFlg());
							pss.setString(12, setting.getrCreId());
							pss.setString(13, setting.getrModId());
						}

					});
		} catch (DuplicateKeyException duplicateKeyException) {
			logger.debug("Duplicate Entry");
			throw new DuplicateEntryException();
		}
	}

	@Override
	public Settings selectCompanyDetails() throws NoDataFoundException {
		Settings settings = new Settings();
		StringBuffer sql = new StringBuffer();
		sql.append("select COMPANY_ID,ADDRESS_1,ADDRESS_2,LICENSE_NO,MOBILE_NO,EMAIL,PROMO_DISCOUNT,TAX,PRINTER_NAME"
				+ " from company where DEL_FLG='N'");
		settings = (Settings) getJdbcTemplate().query(sql.toString(),
				new CompanyData());
		if (settings == null) {
			throw new NoDataFoundException();
		}
		return settings;

	}

	class CompanyData implements ResultSetExtractor<Settings> {
		@Override
		public Settings extractData(ResultSet resultSet) throws SQLException,
				DataAccessException {

			Settings settings = null;
			while (resultSet.next()) {
				settings = new Settings();
				settings.setCompanyId(resultSet.getString("COMPANY_ID"));
				settings.setAddress1(resultSet.getString("ADDRESS_1"));
				settings.setAddress2(resultSet.getString("ADDRESS_2"));
				settings.setLicenseNo(resultSet.getString("LICENSE_NO"));
				settings.setMobileNo(resultSet.getString("MOBILE_NO"));
				settings.setEmail(resultSet.getString("EMAIL"));
				settings.setPromoDiscount(resultSet.getString("PROMO_DISCOUNT"));
				settings.setTax(resultSet.getString("TAX"));
				settings.setPrinterName(resultSet.getString("PRINTER_NAME"));
			}

			return settings;

		}

	}

	@Override
	public void updateSettings(final Settings settings)
			throws UpdateFailedException {
		logger.debug("Inside update method");
		StringBuffer sql = new StringBuffer();
		sql.append(" update company set DB_TS=?, ADDRESS_1=?,ADDRESS_2=?,LICENSE_NO=?,MOBILE_NO=?,EMAIL=?,PROMO_DISCOUNT=?,TAX=?,PRINTER_NAME=?,"
				+ "R_MOD_TIME=now(),R_MOD_ID=? where COMPANY_ID=? and DEL_FLG='N'");
		logger.debug("update query :" + sql.toString());
		int updateStatus = getJdbcTemplate().update(sql.toString(),
				new PreparedStatementSetter() {

					@Override
					public void setValues(PreparedStatement ps)
							throws SQLException {
						ps.setInt(1, settings.getDbTs() + 1);

						ps.setString(2, settings.getAddress1().trim());
						ps.setString(3, settings.getAddress2().trim());
						ps.setString(4, settings.getLicenseNo());
						ps.setString(5, settings.getMobileNo().trim());
						ps.setString(6, settings.getEmail());
						ps.setString(7, settings.getPromoDiscount());
						ps.setString(8, settings.getTax());
						ps.setString(9, settings.getPrinterName());

						ps.setString(10, settings.getrModId());

						ps.setString(11, settings.getCompanyId());

					}

				});
		if (updateStatus == 0) {
			throw new UpdateFailedException();

		}

	}

}
