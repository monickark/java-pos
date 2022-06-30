package com.pos.batch.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.pos.batch.dao.BatchPgms;
import com.pos.batch.service.IBatchPgmsService;
import com.pos.batch.service.IBatchStatusService;
import com.pos.common.batch.util.ExcelUtils;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.dropdown.service.IDropDownListService;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.batch.NoRecordFoundException;
import com.pos.common.util.CommonCodeUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.framework.sessCache.UserSessionDetails;

//Controller class for ExcelCreation
@Controller
public class ExcelController {
	Logger logger = Logger.getLogger(ExcelController.class);

	@Autowired
	CommonCodeUtil commonCodeUtil;
	@Autowired
	IBatchStatusService batchStatusService;
	
	@Autowired
	IDropDownListService dropDownListService;
	


	// Method to Render the Export Data Page
	@RequestMapping(value = "/batchExport", method = RequestMethod.GET)
	public ModelAndView loadUploadPage(
			@ModelAttribute("exportData") ExportTemplateVO exportDataVO,HttpServletRequest request, HttpSession session,
			HttpServletResponse response)
			throws ParserConfigurationException, SAXException, IOException, NoRecordFoundException {
		
		logger.info("Excel file download page is opening");
		ModelAndView mav = new ModelAndView(".pos.exportData");		
		
		if(request.getParameter("CreateTemp")!=null){
			logger.info("Started to prepare the excel");			
			exportDataVO.setBatchName(ApplicationConstant.BATCH_PGMS_EXCEL_IMPORT);		
			logger.debug("Create Temp REquest Value:"+request.getParameter("CreateTemp"));
			SessionCache sessionCache = (SessionCache) session
					.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
			ApplicationCache applicationCache = (ApplicationCache) session
					.getServletContext().getAttribute(
							ApplicationConstant.APPLICATION_CACHE);
			
			BatchPgms batch = batchStatusService.getBatchPgmRec(exportDataVO, sessionCache.getUserSessionDetails());											
			
			HSSFWorkbook workBook = ExcelUtils.prepareWorkBook(response,
					ExcelUtils.getHeader(session,exportDataVO.getDataType(),  batch.getXmlFileName().split(",")),ExcelUtils.readXML(session, exportDataVO.getDataType(),  batch.getXmlFileName().split(",")),
					applicationCache, batch.getSheetName().split(","));	
			
			ExcelUtils.generateWorkbook(response, workBook, batch.getExcelFileName());
			logger.info("Excel file is ready for download");
			return null;
		}
		return mav;
	}	

	
	@ModelAttribute("branchList")
	public Map<String, String> gerBranchList(HttpSession session,
			HttpServletRequest httpSevletRequest, HttpServletResponse response,
			ModelMap model) throws IOException, NoDataFoundException {
		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		Map<String, String> map = dropDownListService.getBranchListTag(sessionCache.getUserSessionDetails());
		httpSevletRequest.setAttribute("branchList", map);
		return map;

	}

	// Method to handle the User-defined exceptions
	@ExceptionHandler({ NoRecordFoundException.class })
	public ModelAndView handleException(Exception ex, HttpSession session,
			HttpServletRequest request) {

		ExportTemplateVO fileVO = new ExportTemplateVO();
		ModelAndView mav = new ModelAndView(".pos.exportData", "fileup",
				fileVO);
		mav.getModelMap().addAttribute("error", ex.getMessage());
		return mav;

	}

}
