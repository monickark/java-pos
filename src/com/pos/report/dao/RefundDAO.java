package com.pos.report.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.framework.dao.BaseDao;

@Repository
public class RefundDAO extends BaseDao implements IRefundDAO {

	Logger logger = Logger.getLogger(RefundDAO.class.getName());
	@Override
	public void insertRefund(final ProductReport productReport)throws DuplicateEntryException {
		
		StringBuffer query = new StringBuffer();
		query = query.append("insert into sare(DB_TS,INVOICE_NO,PRODUCT_ID,REFUND_AMOUNT,REFUND_REASON,DEL_FLG,R_CRE_TIME,R_CRE_ID,R_MOD_TIME,R_MOD_ID)"
				+ "values(?,?,?,?,?,?,now(),?,now(),?)");
		logger.debug(" Executing prepared SQL query");
		
		try {
			getJdbcTemplate().update(query.toString(), new PreparedStatementSetter() {

				@Override
				public void setValues(PreparedStatement pss) throws SQLException {
					pss.setInt(1, productReport.getDbTs());
					pss.setString(2, productReport.getInvoiceNo());
					pss.setString(3, productReport.getProductId());
					pss.setString(4, productReport.getRefundAmount());
					pss.setString(5, productReport.getRefundReason());
					pss.setString(6, productReport.getDelFlg());
					pss.setString(7, productReport.getrCreId());
					pss.setString(8, productReport.getrModId());
					
					
				}
				
			});
		}catch (DuplicateKeyException duplicateKeyException) {
			logger.debug("Duplicate Entry");
			throw new DuplicateEntryException();
		}
	}

}
