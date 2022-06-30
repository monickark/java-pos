package com.pos.report.service;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.report.controller.SalesReportVO;

public interface ISalesReportService {

	List<SalesReportVO> selectSalesReport(SalesReportVO salesReportVO) throws NoDataFoundException;

}
