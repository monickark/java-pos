package com.pos.sale.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.PrinterName;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimplePrintServiceExporterConfiguration;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.ErrorCodeConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.SessionCache;
import com.pos.sale.service.ITradeinService;
import com.pos.settings.controller.SettingsVO;
import com.pos.settings.service.ISettingsService;

@Controller
public class TradeinController {
	
	Logger logger = Logger.getLogger(TradeinController.class.getName());

	@Autowired
	ITradeinService tradeinService;
	@Autowired
	ISettingsService settingsService;
	
	@RequestMapping(value = "/tradein", method = RequestMethod.GET)
	public ModelAndView addTradeinGet(@ModelAttribute("tradein") TradeinVO tradeinVO, HttpSession session) throws NoDataFoundException {
		session.setAttribute("sign", null);
		ModelAndView mav = new ModelAndView(".pos.tradein","tradein", tradeinVO);
		return mav;
}
	
	@RequestMapping(value = "/tradein", method = RequestMethod.POST)
	public String addTradeinPost(@ModelAttribute("tradein") TradeinVO tradeinVO, HttpSession session,
			HttpServletRequest request, Model model)
			throws DatabaseException, NoDataFoundException, DuplicateEntryException{
		
		SessionCache sessionCache = (SessionCache) session.getAttribute(ApplicationConstant.SESSION_CACHE_KEY);
		ApplicationCache applicationCache = (ApplicationCache) session.getServletContext()
				.getAttribute(ApplicationConstant.APPLICATION_CACHE);
		
		
		String sign = (String) request.getParameter("sign-hid");
		String imei = (String) request.getParameter("imei");
		System.out.println("+==============================================================");
		System.out.println("sign :"+sign +" imei:"+imei);
		tradeinService.addTradein(tradeinVO,sessionCache,applicationCache,session);
		if(!sign.equals(null) && !sign.equals("")){
			saveImage(request, sign);
			tradeinService.addTradeinSale(imei, sign);
			session.setAttribute("sign", sign);
		}
			return "redirect:/tradein.htm?invoice";
		
	}
	
	@RequestMapping(value = "/tradein", method = RequestMethod.GET, params = { "getSign" })
	public @ResponseBody String getSignature(HttpSession session,
			HttpServletRequest request,HttpServletResponse response, ModelMap map)
			throws NoDataFoundException, UpdateFailedException {

		String returnSign = (String) session.getAttribute("sign");
		System.out.println("signature :" + returnSign);
		if(returnSign==null || returnSign==""){
			response.setStatus(406);
		}
		return returnSign;

	}
	
	@RequestMapping(value = "/tradein", method = RequestMethod.GET, params = { "invoice" })
	public ModelAndView tradeInInvoice(
			@ModelAttribute("tradein") TradeinVO tradeinVO, Model model,
			HttpSession session, HttpServletRequest request) throws NoDataFoundException, DuplicateEntryException {
		TradeinVO tradeinVO1 = (TradeinVO) session.getAttribute("tradeinVO");
		List<TradeinVO> tradeinVOs =new ArrayList<TradeinVO>();
		tradeinVOs.add(tradeinVO1);
		model.addAttribute("tradeinVO", tradeinVO1);
		session.setAttribute("tradeinVO",tradeinVO1);
		
		SettingsVO settingsVO = settingsService.getCompanyDetails();
		model.addAttribute("settingsVO", settingsVO);
		session.setAttribute("settingsVO",settingsVO);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();		 
		String today=dateFormat.format(cal.getTime());
		model.addAttribute("today", today);
		
		session.setAttribute("tradeinVOs", tradeinVOs);
		ModelAndView mav = new ModelAndView(".pos.tradeinInvoice", "tradein", tradeinVO1);

		return mav;

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/tradein", method = RequestMethod.GET, params = { "print" })
	public String printInvoice(
			@ModelAttribute("tradein") TradeinVO tradeinVO,
			HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		logger.info("Received request to download PDF report");
		String input = request.getSession().getServletContext()
				.getRealPath("//reports//TradeInInvoice.jrxml");
		List<TradeinVO> tradeinVOs = (List<TradeinVO>) session.getAttribute("tradeinVOs");
		
		TradeinVO tradeinVO1=new TradeinVO();
		tradeinVOs.add(0,tradeinVO1);
		
		JasperReport jasperReport1 = null;
		String sign = null;
		try {
			logger.info("In jasper datasource");
			TradeinVO tradeinVO2 = (TradeinVO) session.getAttribute("tradeinVO");			
			SettingsVO settingsVO = (SettingsVO) session.getAttribute("settingsVO");
			String sign1 = (String) session.getAttribute("sign");
			System.out.println("settingsVO:"+settingsVO.toString());
			JRDataSource datasource = new JRBeanCollectionDataSource(
					tradeinVOs);
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("datasource", datasource);
			logger.info("Generating INVOICE PDF...");
			String path = request
					.getSession()
					.getServletContext()
					.getRealPath( "//images//logo//logo_retail.png");
			parameterMap.put("logo", path);
			if(sign1!=null && !sign1.isEmpty() ){
				sign = request.getSession().getServletContext()
						.getRealPath("//reports//test_image2.jpeg");
			}

			parameterMap.put("sign", sign);
			
			parameterMap.put("invoiceNo", tradeinVO2.getT_invoiceId());
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();		 
			String today=dateFormat.format(cal.getTime());
			parameterMap.put("address1", settingsVO.getAddress1());
			parameterMap.put("address2", settingsVO.getAddress2());
			parameterMap.put("license", settingsVO.getLicenseNo());
			parameterMap.put("mobile", settingsVO.getMobileNo());
			parameterMap.put("emailId", settingsVO.getEmail());
			
			parameterMap.put("date", today);
			parameterMap.put("netAmount", tradeinVO2.getResaleValue());
			parameterMap.put("amountPayable", tradeinVO2.getResaleValue());

			parameterMap.put("name", tradeinVO2.getCustomerName());
			parameterMap.put("contactNo", tradeinVO2.getContactNo());
			parameterMap.put("licenceNo", tradeinVO2.getLisenceNumber());
			parameterMap.put(JRParameter.IS_IGNORE_PAGINATION,Boolean.TRUE);
			
			
			jasperReport1 = JasperCompileManager.compileReport(input);
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport1, parameterMap, datasource);
			
			//Get the printers job and names
			/*PrinterJob printerJob = PrinterJob.getPrinterJob();*/
			PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);

			//Lets set the printer name based on the registered printers driver name
			String selectedPrinter = settingsVO.getPrinterName();
			System.out.println("Number of print services: " + services.length);
			PrintService selectedService = null;

			//Set the printing settings
			PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
			printRequestAttributeSet.add(MediaSizeName.ISO_A4);
			if (jasperPrint.getOrientationValue() == net.sf.jasperreports.engine.type.OrientationEnum.LANDSCAPE) { 
			  printRequestAttributeSet.add(OrientationRequested.LANDSCAPE); 
			} else { 
			  printRequestAttributeSet.add(OrientationRequested.PORTRAIT); 
			}
			PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();
			printServiceAttributeSet.add(new PrinterName(selectedPrinter, null));

			JRPrintServiceExporter exporter = new JRPrintServiceExporter();
			SimplePrintServiceExporterConfiguration configuration = new SimplePrintServiceExporterConfiguration();
			configuration.setPrintRequestAttributeSet(printRequestAttributeSet);
			configuration.setPrintServiceAttributeSet(printServiceAttributeSet);
			configuration.setDisplayPageDialog(false);
			configuration.setDisplayPrintDialog(false);

			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setConfiguration(configuration);

			//Iterate through available printer, and once matched with our CANON PIXMA, go ahead and print!
			if(services.length != 0 || services != null){
			  for(PrintService service : services){
			      String existingPrinter = service.getName();
			      System.out.println("service"+service.getName());
			      if(existingPrinter.equals(selectedPrinter))
			      {
			          selectedService = service;
			          break;
			      }
			  }
			}
			if(selectedService != null)
			{	
			  try{
			      //Lets the printer do its magic!
			      exporter.exportReport();
			      logger.info("Print Success");
			  }catch(Exception e){
			    //IF something goes wrong with the printer, lets just print it as PDF?
				  System.out.println("PRINTER SET NOT PRINTING");
				  logger.info("Printing Failed");
			    JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Invoice("+tradeinVO2.getT_invoiceId()+").pdf");
			    e.printStackTrace();
			  }
			}else{
			  //IF you did not set the printer, lets just print it as PDF?
				System.out.println("NOT PRINTER SET");
				logger.debug("Printer Not Matched");
			  JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Invoice("+tradeinVO2.getT_invoiceId()+").pdf");
			}
			
		} catch (JRException e) {
			session.setAttribute("tradeinVOs", null);
			session.setAttribute("tradeinVO", null);
			session.setAttribute("settingsVO", null);
			session.setAttribute("sign", null);
			logger.error("Printer function not Performed");
			e.printStackTrace();
			
		}
		session.setAttribute("tradeinVOs", null);
		session.setAttribute("tradeinVO", null);
		session.setAttribute("settingsVO", null);
		session.setAttribute("sign", null);
		try
        {
		 if(sign!=null && !sign.isEmpty()){
            Files.deleteIfExists(Paths.get(sign));
		 }
        } 
        catch(NoSuchFileException e) 
        { 
            System.out.println("No such file/directory exists"); 
        } 
		return "redirect:/tradeinList.htm";
	}
	
	private void saveImage(HttpServletRequest request, String image){
		System.out.println("inside saveimag :" +image);
	        String[] strings = image.split(",");
	        String extension;
	        switch (strings[0]) {//check image's extension
	            case "data:image/jpeg;base64":
	                extension = "jpeg";
	                break;
	            case "data:image/png;base64":
	                extension = "png";
	                break;
	            default://should write cases for more images types
	                extension = "jpg";
	                break;
	        }
	        //convert base64 string to binary data
	        byte[] data = DatatypeConverter.parseBase64Binary(strings[1]);
	        System.out.println("strings[1] : " +strings[1]);
	        System.out.println("Data : " +data);
	        System.out.println("path12"+ request.getSession().getServletContext()
					.getRealPath("//reports//"));
	        String path1 = request.getSession().getServletContext()
					.getRealPath("//reports//");
	         String path = path1 +"//test_image2." + extension;
	        File file = new File(path);
	        try {
				file.createNewFile();
			    System.out.println(path+" File Created");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
	            outputStream.write(data);
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	        	
	        }
	    }
	
	@ExceptionHandler({ DuplicateEntryException.class })
	public ModelAndView handleException(Exception ex, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView(".pos.tradein", "tradein", new TradeinVO() );
		mav.getModelMap().addAttribute("error",
				ErrorCodeConstant.DUPLICATE_ENTRY);
		return mav;

	}
	}

	

