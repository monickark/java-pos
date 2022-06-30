package com.pos.admin.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pos.admin.controller.SMSConfigurationMasterVO;
import com.pos.admin.controller.SMSConfigurationVO;
import com.pos.admin.dao.ISMSConfigurationDAO;
import com.pos.admin.dao.ISMSConfigurationListDAO;
import com.pos.admin.dao.SMSConfiguration;
import com.pos.admin.dao.SMSConfigurationKey;
import com.pos.admin.dao.SMSConfigurationListKey;
import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.AuditConstant;
import com.pos.common.constants.TableNameConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.exceptions.util.TableNotSpecifiedForAuditException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.audit.service.DoAudit;
import com.pos.framework.sessCache.UserSessionDetails;
@Service
public class SMSConfigurationService implements ISMSConfigurationService {
	// Logging
	Logger logger = Logger.getLogger(SMSConfigurationService.class);
	@Autowired
	DoAudit doAudit;
	
	@Autowired
	ISMSConfigurationListDAO smsConfigurationListDAO;
	@Autowired
	ISMSConfigurationDAO smsConfigurationDAO;
	@Autowired
	CommonBusiness commonBusiness;
	@Override
	public SMSConfigurationMasterVO selectStudentGroupList(
			SMSConfigurationMasterVO smsConfigurationMasterVO,
			UserSessionDetails userSessionDetails) throws NoDataFoundException {

		SMSConfigurationListKey smsConfigurationListKey = new SMSConfigurationListKey();
		if(smsConfigurationMasterVO.getSmsConfigVO()!=null){
		commonBusiness.changeObject(smsConfigurationListKey, smsConfigurationMasterVO.getSmsConfigVO());
		}
		smsConfigurationListKey.setInstId(userSessionDetails.getInstId());
		if((smsConfigurationListKey.getBranchId()=="")&&(smsConfigurationListKey.getBranchId()==null)){
		smsConfigurationListKey.setBranchId(userSessionDetails.getBranchId());
		}
		List<SMSConfiguration> smsConfigList = smsConfigurationListDAO.getSMSConfigurationList(smsConfigurationListKey);
		List<SMSConfigurationVO> smsConfigurationVOs = new ArrayList<SMSConfigurationVO>();

		for (int i = 0; i < smsConfigList.size(); i++) {
			SMSConfiguration smsConfiguration = smsConfigList.get(i);
			SMSConfigurationVO smsConfigurationVO = new SMSConfigurationVO();
			commonBusiness.changeObject(smsConfigurationVO, smsConfiguration);
			smsConfigurationVO.setRowId(i);
			smsConfigurationVOs.add(smsConfigurationVO);
		}
		smsConfigurationMasterVO.setSmsConfigListVO(smsConfigurationVOs);
		return smsConfigurationMasterVO;
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void saveSMSConfigurationDetails(
			SMSConfigurationMasterVO smsConfigurationMasterVO,
			UserSessionDetails userSessionDetails, String[] rowIds,
			String[] propertyValues, String[] propertyNames)
			throws NoDataFoundException, UpdateFailedException {
	List<SMSConfiguration> smsConfigurationList=new ArrayList<SMSConfiguration>();
	List<SMSConfigurationListKey> smsConfigurationKeyList=new ArrayList<SMSConfigurationListKey>();
	List<String> values = new ArrayList<String>(Arrays.asList(propertyValues));
	List<String> names = new ArrayList<String>(Arrays.asList(rowIds));
	System.out.println("list sizeeeeeeeeeeeee"+values.size());
	System.out.println("list sizeeeeeeeeeeeee"+names.size());
	values.removeAll(Arrays.asList("", null));
	System.out.println("list sizeeeeeeeeeeeee"+values.size());
	for(int i=0;i<names.size();i++){
		System.out.println("i valuessssssssssss"+i);
		System.out.println(" valuessssssssssss"+values.get(i));
		System.out.println("Namessssss"+names.get(i));	
		SMSConfigurationKey smsConfigurationKey=new SMSConfigurationKey();			
		smsConfigurationKey.setInstId(userSessionDetails.getInstId());
		smsConfigurationKey.setBranchId(smsConfigurationMasterVO.getSmsConfigVO().getBranchId());
		if((smsConfigurationMasterVO.getSmsConfigVO().getPropertyType()==null)||(smsConfigurationMasterVO.getSmsConfigVO().getPropertyType().equals(""))){
			smsConfigurationKey.setPropertyType(smsConfigurationMasterVO.getSmsConfigListVO().get(0).getPropertyType());
		}else{
		smsConfigurationKey.setPropertyType(smsConfigurationMasterVO.getSmsConfigVO().getPropertyType());
		}
		smsConfigurationKey.setPropertyName(names.get(i));
		SMSConfiguration smsConfig=smsConfigurationDAO.selectSMSConfigurationRec(smsConfigurationKey);
		smsConfig.setPropertyValue(values.get(i));
		SMSConfigurationListKey smsConfigurationListKey=new SMSConfigurationListKey();
		commonBusiness.changeObject(smsConfigurationListKey, smsConfig);
		smsConfigurationList.add(smsConfig);
		smsConfigurationKeyList.add(smsConfigurationListKey);
		
			
	}
	for(int j=0;j<smsConfigurationList.size();j++){
		System.out.println("valuesssssssssssssssss"+smsConfigurationList.get(j));
		System.out.println("valuesssssssssssssssss"+smsConfigurationKeyList.get(j));
	}
	
	smsConfigurationListDAO.updateSMSConfigurationDetailsRecs(smsConfigurationList, smsConfigurationKeyList);
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateSMSConfigurationRec(
			SMSConfigurationVO smsConfigurationVO,
			UserSessionDetails userSessionDetails,
			ApplicationCache applicationCache) throws UpdateFailedException,
			NoDataFoundException, DuplicateEntryException, DatabaseException,
			TableNotSpecifiedForAuditException {
		logger.debug("inside update SMS Configuration method");
		SMSConfiguration smsConfiguration = new SMSConfiguration();
		SMSConfigurationKey smsConfigurationKey = new SMSConfigurationKey();
		// map the UIObject to Pojo
		System.out.println("vo to string"+smsConfigurationVO.toString());
		commonBusiness.changeObject(smsConfiguration, smsConfigurationVO);
		commonBusiness.changeObject(smsConfigurationKey, smsConfiguration);
		System.out.println("vo to string not"+smsConfiguration.toString());
		System.out.println("vo to string key"+smsConfigurationKey.toString());
		smsConfigurationKey.setInstId(userSessionDetails.getInstId());
		//smsConfigurationKey.setPropertyName(smsConfiguration.getPropertyName());	

		SMSConfiguration smsConfigurationnew = smsConfigurationDAO.selectSMSConfigurationRec(smsConfigurationKey);
		SMSConfiguration updateSMSConfiguration=new SMSConfiguration();
			commonBusiness.changeObject(updateSMSConfiguration, smsConfigurationnew);
			smsConfigurationKey.setDbTs(smsConfigurationnew.getDbTs());
			updateSMSConfiguration.setrModId(userSessionDetails.getUserId());
			updateSMSConfiguration.setPropertyValue(smsConfiguration.getPropertyValue());
			smsConfigurationDAO.updateSMSConfigurationRec(updateSMSConfiguration, smsConfigurationKey);
			

// functional audit
			doAudit.doFunctionalAudit(userSessionDetails,
					AuditConstant.SMS_CONFIG_UPDATE, " ");
			logger.debug("Completed Functional Auditing");
			
			// Database audit
					String oldRecString = smsConfigurationnew.toStringForAuditSMSConfigurationRecord();
					SMSConfiguration smsConfigurationForAudit = null;
					smsConfigurationKey.setDbTs(0);
					try {
						smsConfigurationForAudit=smsConfigurationDAO.selectSMSConfigurationRec(smsConfigurationKey);
					} catch (NoDataFoundException e) {
						logger.error("No data found  Exception occured in update academic calender:");
						e.printStackTrace();
					}						
					smsConfigurationKey.setDbTs(smsConfigurationForAudit.getDbTs());			
					String newRecString =smsConfigurationForAudit.toStringForAuditSMSConfigurationRecord();
					doAudit.doDatabaseAudit(applicationCache, userSessionDetails,
							TableNameConstant.SMS_CONFIG,
							smsConfigurationKey.toStringForAuditAcademicCalendarKey(),
							oldRecString, AuditConstant.TYPE_OF_OPER_UPDATE, newRecString,
							"");

					logger.debug("Completed Database Auditing");

		

	}

}
