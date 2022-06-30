package com.pos.report.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface ISalesRefundReportDAO {

	List<SalesRefundReport> selectSalesRefundReport() throws NoDataFoundException;

}
