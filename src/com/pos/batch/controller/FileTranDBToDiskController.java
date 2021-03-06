package com.pos.batch.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pos.batch.service.IFileTranDBToDiskService;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.ErrorCodeConstant;
import com.pos.common.dropdown.service.IDropDownListService;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.util.ErrorDescriptionNotFoundException;
import com.pos.common.util.ErrorCodeUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.SessionCache;

@Controller
public class FileTranDBToDiskController {
	Logger logger = Logger.getLogger(BatchFileUploadController.class);
	
	@Autowired
	IFileTranDBToDiskService fileTranDBToDiskService;
	@Autowired
	IDropDownListService dropDownListService;
	@Autowired
	ErrorCodeUtil errorCodeUtil;
	
	
	@RequestMapping(value = "/batchFileTransfer", method = RequestMethod.GET)
	public String displayForm(@ModelAttribute("fileTransferVO") FileTransferVO fileUploadForm) {
		logger.debug("Going to render File Transfer from Database to Disk operation Page");
		return ".pos.transferFileDBD";
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
	
	@RequestMapping(value = "/batchFileTransfer", method = RequestMethod.POST)
	public String fileTransfer(@ModelAttribute("fileTransferVO") FileTransferVO fileVO,
			HttpSession session,HttpServletRequest request,RedirectAttributes redirect) throws DatabaseException, ErrorDescriptionNotFoundException{
		
		logger.debug("File Transfer starts from controller");
		
		request.setAttribute("fileTransferVO", fileVO);
		
		SessionCache sessionCache = (SessionCache) session
				.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session
				.getServletContext().getAttribute(
						ApplicationConstant.APPLICATION_CACHE);
		
		String batchSrlNo = fileTranDBToDiskService.tranferingFilesToDisk(fileVO, 
				sessionCache.getUserSessionDetails(), session.getServletContext(), applicationCache);
		
		request.setAttribute("batchSrlNo", batchSrlNo);
		
		redirect.addFlashAttribute(
				"success",
				ErrorCodeConstant.BATCH_INITIATE
						+ ": "
						+ "Batch Id :"
						+ batchSrlNo
						+ " "
						+ errorCodeUtil.getErrorDescription(applicationCache,
								ErrorCodeConstant.BATCH_INITIATE));
		return "redirect:/batchFileTransfer.htm";
		
	}
	
	
	@ExceptionHandler({DatabaseException.class,ErrorDescriptionNotFoundException.class})
	public ModelAndView handleException(Exception ex, HttpSession session,
			HttpServletRequest request) {
		FileTransferVO fileTransferVO = (FileTransferVO) request
				.getAttribute("fileTransferVO");
		ModelAndView mav = new ModelAndView(".pos.transferFileDBD", "fileTransferVO",
				fileTransferVO);
		mav.getModelMap().addAttribute("error", ex.getMessage());
		return mav;
	}
	

}
