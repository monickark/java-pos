package com.pos.sale.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.customer.controller.CustomerVO;
import com.pos.customer.service.ICustomerService;
import com.pos.sale.service.ISaleInfoService;
import com.pos.sale.service.ISaleService;
import com.pos.settings.controller.SettingsVO;
import com.pos.settings.service.ISettingsService;

@Controller
public class SaleInvoiceController {

	Logger logger = Logger.getLogger(SaleInvoiceController.class.getName());

	@Autowired
	ISaleInfoService saleInfoService;
	@Autowired
	ISettingsService settingsService;
	@Autowired
	ISaleService salesService;
	@Autowired
	ICustomerService customerService;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/possale", method = RequestMethod.GET, params = { "invoice" })
	public ModelAndView saleInvoice(@ModelAttribute("possale") PosVO posVO,
			HttpServletRequest request, HttpSession session, Model model)
			throws DatabaseException, DuplicateEntryException,
			NoDataFoundException {
		System.out.println("Inside invoice generate");
		List<PosVO> posVOs = (List<PosVO>) session.getAttribute("pos_list");
		
		SettingsVO settingsVO = settingsService.getCompanyDetails();
		SalesVO salesVO = (SalesVO) session.getAttribute("salesVO");
		System.out.println("Invoice get salesVO vo :" + salesVO.toString());
		if (session.getAttribute("customerVO") != null) {
			CustomerVO customerVO = (CustomerVO) session.getAttribute("customerVO");
			model.addAttribute("customerVO", customerVO);
		}
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();		 
		String today=dateFormat.format(cal.getTime());
		model.addAttribute("salesVO", salesVO);

		model.addAttribute("settingsVO", settingsVO);
		session.setAttribute("settingsVO",settingsVO);
		System.out.println("Data list size111 " + posVOs.size());
		
		System.out.println("Data list data " + posVOs);
		ModelAndView mav = new ModelAndView(".pos.possaleInvoice", "possale", posVO);
		mav.getModelMap().addAttribute("today", today);
		return mav;

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/possale", method = RequestMethod.GET, params = { "print" })
	public String printInvoice(
			@ModelAttribute("possale") PosVO posVO,
			HttpSession session, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		logger.info("Received request to download PDF report");
		String input = request.getSession().getServletContext()
				.getRealPath("//reports//Invoice.jrxml");

		JasperReport jasperReport1 = null;
		try {
			logger.info("In jasper datasource");
			List<PosVO> posVOs = (List<PosVO>) session.getAttribute("pos_list");
			
				PosVO posVO1=new PosVO();
				posVOs.add(0,posVO1);
			
			System.out.println("Data list sizePrint " + posVOs.size());
			SalesVO salesVO = (SalesVO) session.getAttribute("salesVO");
			System.out.println("salesVO" + salesVO.toString());
			
			SettingsVO settingsVO = (SettingsVO) session.getAttribute("settingsVO");
			System.out.println("settingsVO:"+settingsVO.toString());
			JRDataSource datasource = new JRBeanCollectionDataSource(
					posVOs);
			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("datasource", datasource);
			logger.info("Generating INVOICE PDF...");
			logger.info("Report List :" + posVOs);
			String path = request
					.getSession()
					.getServletContext()
					.getRealPath( "//images//logo//logo_retail.png");
			parameterMap.put("logo", path);
			parameterMap.put("invoiceNo", salesVO.getInvoiceNo());
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();		 
			String today=dateFormat.format(cal.getTime());
			parameterMap.put("address1", settingsVO.getAddress1());
			parameterMap.put("address2", settingsVO.getAddress2());
			parameterMap.put("license", settingsVO.getLicenseNo());
			parameterMap.put("mobile", settingsVO.getMobileNo());
			parameterMap.put("emailId", settingsVO.getEmail());
			
			parameterMap.put("date", today);
			parameterMap.put("promoDiscount", salesVO.getPromoDiscount());
			parameterMap.put("netAmount", salesVO.getNetAmount());
			parameterMap.put("tax", salesVO.getTax());
			parameterMap.put("amountPayable", salesVO.getAmountPayable());
			if (session.getAttribute("customerVO") != null) {
				CustomerVO customerVO = (CustomerVO) session.getAttribute("customerVO");
				System.out.println("CustomerVO:"+customerVO.toString());
				if(!customerVO.getCustomerName().equals(null) && !customerVO.getCustomerName().equals("")){
					System.out.println("Customer Name:"+customerVO.getCustomerName());
					System.out.println("IF");
					parameterMap.put("customerDetails", "Customer Details : ");
				}
				else{
					System.out.println("Else");
					parameterMap.put("customerDetails", "");
				}
				parameterMap.put("name", customerVO.getCustomerName());
				parameterMap.put("address", customerVO.getAddress());
				parameterMap.put("state", customerVO.getState());
				parameterMap.put("country", customerVO.getCountry());
				parameterMap.put("postCode", customerVO.getPostCode());
				parameterMap.put("email", customerVO.getEmail());
			}else{
					parameterMap.put("customerDetails", "");
					parameterMap.put("name", "");
					parameterMap.put("address", "");
					parameterMap.put("state", "");
					parameterMap.put("country", "");
					parameterMap.put("postCode", "");
					parameterMap.put("email", "");
			}
			
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
			    JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Invoice("+salesVO.getInvoiceNo()+").pdf");
			    e.printStackTrace();
			  }
			}else{
			  //IF you did not set the printer, lets just print it as PDF?
				System.out.println("NOT PRINTER SET");
				logger.debug("Printer Not Matched");
			  JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\Invoice("+salesVO.getInvoiceNo()+").pdf");
			}
			
		} catch (JRException e) {
			WebUtils.setSessionAttribute(request, "pos_list",
					null);
			logger.error("Printer function not Performed");
			e.printStackTrace();
			
		}
		session.setAttribute("pos_list", null);
		session.setAttribute("salesVO", null);
		session.setAttribute("settingsVO", null);
		if (session.getAttribute("customerVO") != null) {
			session.setAttribute("customerVO", null);
		}
		return "redirect:/possale.htm";
		/*return new ModelAndView(".pos.possale", "possale", new PosVO());*/
	}
	
	@RequestMapping(value = "/possale", method = RequestMethod.GET, params = { "invoiceNo" })
	public ModelAndView invoiceReport(@ModelAttribute("possale") PosVO posVO ,HttpServletRequest httpServletRequest,HttpSession session)
			throws DatabaseException, DuplicateEntryException, NoDataFoundException
			{
		
		
		
		String invoiceNo = httpServletRequest.getParameter("Id");
		SalesVO salesVO = salesService.getSales(invoiceNo);
		WebUtils.setSessionAttribute(httpServletRequest, "salesVO", salesVO);
		
		List<PosVO> posVOs = saleInfoService.getInfo(invoiceNo);
		WebUtils.setSessionAttribute(httpServletRequest, "pos_list", posVOs);
		
		String customerId = salesVO.getCustomerId();
		CustomerVO customerVO=null;
		try {
			customerVO = customerService.getCustomer(customerId);
			System.out.println("CustomerNo "+customerVO);
			WebUtils.setSessionAttribute(httpServletRequest, "customerVO", customerVO);
		} catch (NoDataFoundException e) {
			WebUtils.setSessionAttribute(httpServletRequest, "customerVO", null);
		}
		
		
		SettingsVO settingsVO = settingsService.getCompanyDetails();
		session.setAttribute("settingsVO",settingsVO);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();		 
		String today=dateFormat.format(cal.getTime());
		
		
		ModelAndView mav = new ModelAndView(".pos.possaleInvoice", "possale", posVO);
		mav.getModelMap().addAttribute("today", today);
		return mav;

		
	}
	
}
