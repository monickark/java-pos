package com.pos.report.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.common.business.CommonBusiness;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.report.controller.TillReportVO;
import com.pos.report.dao.ITillReportDAO;
import com.pos.report.dao.TillReport;

@Service
public class TillReportService implements ITillReportService {

	Logger logger = Logger.getLogger(TillReportService.class.getName());
	
	@Autowired
	ITillReportDAO tillReportDAO;
	@Autowired
	private CommonBusiness commonBussiness;
	
	
	@Override
	public List<TillReportVO> selectTillReport(TillReportVO tillReportVO) throws NoDataFoundException{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Calendar cal = Calendar.getInstance();
		 
		 String date=dateFormat.format(cal.getTime());
		 tillReportVO.setDate(date);
		
		List<TillReportVO> tillReportVOs = new ArrayList<TillReportVO>();
		TillReport tillReport = new TillReport();
		commonBussiness.changeObject(tillReport, tillReportVO);

		List<TillReport> tillReports = tillReportDAO.selectTillReport();

		for (TillReport tillReport2 : tillReports) {
			TillReportVO tillReportVO2 = new TillReportVO();
			commonBussiness.changeObject(tillReportVO2,tillReport2);
			tillReportVOs.add(tillReportVO2);
		}
		return tillReportVOs;
	}
}
