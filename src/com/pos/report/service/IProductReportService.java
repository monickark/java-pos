package com.pos.report.service;

import java.util.List;

import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.report.controller.ProductReportListVO;
import com.pos.report.controller.ProductReportVO;

public interface IProductReportService {
	List<ProductReportListVO> selectProductReport(
			ProductReportListVO productReportVO) throws NoDataFoundException;

	void refund(ProductReportListVO productReportVO, SessionCache sessionCache,
			ApplicationCache applicationCahce) throws DuplicateEntryException;


}
