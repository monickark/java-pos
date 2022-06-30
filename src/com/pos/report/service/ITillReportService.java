package com.pos.report.service;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;
import com.pos.report.controller.TillReportVO;

public interface ITillReportService {

	List<TillReportVO> selectTillReport(TillReportVO tillReportVO) throws NoDataFoundException;

}
