package com.pos.report.service;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.report.controller.SalesRefundReportVO;

public interface ISalesRefundReportService {

	List<SalesRefundReportVO> selectSalesRefundReport(SalesRefundReportVO salesRefundReportVO) throws NoDataFoundException;

}
