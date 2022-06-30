package com.pos.batch.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pos.batch.controller.BatchDataUploadVO;
import com.pos.common.batch.util.ExcelValidation.ClassNames;
import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.AuditConstant;
import com.pos.common.constants.BatchConstants;
import com.pos.common.constants.PropertyManagementConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.batch.DataIntegrityException;
import com.pos.common.exceptions.batch.RuntimeExceptionForBatch;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.common.util.DateUtil;
import com.pos.common.util.PropertyManagementUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.audit.service.DoAudit;
import com.pos.framework.sessCache.UserSessionDetails;
import com.pos.user.dao.IUserLinkListDao;
import com.pos.user.dao.IUserListDao;
import com.pos.user.dao.User;
import com.pos.user.dao.UserLink;
@Component
public class BatchInsertHelper {
	Logger logger = Logger.getLogger(BatchInsertHelper.class);
	@Autowired
	CommonBusiness commonBusiness;	
	@Autowired
	DoAudit doAudit;
	@Autowired
	IUserLinkListDao userLinkListDao;
	@Autowired
	IUserListDao userListDao;
	@Autowired
	PropertyManagementUtil propertyManagementUtil;
	@Autowired
	DateUtil dateUtil;

	
	@Transactional(rollbackFor = Exception.class)
	public void dataBaseInsertCall(
			List<Map<String, ArrayList<Object>>> listOfObjectMaps,			
			BatchDataUploadVO importDataVO,
			UserSessionDetails userSessionDetails,
			String batchSerialNo,ApplicationCache applicationCache) throws RuntimeExceptionForBatch, DataIntegrityException, DuplicateEntryException, DatabaseException, NumberFormatException, PropertyNotFoundException {
		
		String remarks = null;	
		String auditConstant = null;	
			
		for (int index = 0; index < listOfObjectMaps.size(); index++) {
			Map<String, ArrayList<Object>> objectMap = listOfObjectMaps
					.get(index);		
			for(Object classNameFromMap :objectMap.keySet()){			
				ClassNames className = ClassNames
						.valueOf(classNameFromMap.toString());				
				switch (className) {
				
				case UserLink: {
					
					
					List<UserLink> userLinkList = new ArrayList<UserLink>();				
					logger.info("Start inserting into UserLinking table");															
					for (Object userLink : objectMap.get(className.toString())) {
						UserLink userLinkObj = new UserLink();
						commonBusiness.changeObject(userLinkObj, userLink);
						userLinkObj.setDb_ts(1);
						userLinkObj.setDeleteFlag("N");
						userLinkObj.setrCreId(BatchConstants.BATCH_UPLD_USER_ID);
						userLinkObj.setrModId(BatchConstants.BATCH_UPLD_USER_ID);						
						userLinkObj.setInstId(importDataVO.getInstId());											
						userLinkObj.setBranchId(importDataVO.getBranchId());		
						userLinkList.add(userLinkObj);
					}
					userLinkListDao.insertListOfUserLinkRec(userLinkList);
					
					break;
				}
				case UserVO: {
					List<User> userList = new ArrayList<User>();
					for (Object usrObj : objectMap.get(className.toString())) {
						User user = new User();
						commonBusiness.changeObject(user, usrObj);
						String[] userAndPassword = new String[2];
						userAndPassword[0] = user.getUserId();
						userAndPassword[1] = user.getPassword();
						user.setDb_ts(1);
						user.setInstId(importDataVO.getInstId());
						user.setBranchId(importDataVO.getBranchId());
						user.setPassword(commonBusiness
								.createPasswordForUser(userAndPassword[1]));
						int days = Integer.parseInt(propertyManagementUtil
								.getPropertyValue(applicationCache,
										userSessionDetails.getInstId(),
										userSessionDetails.getBranchId(),
										PropertyManagementConstant.PWD_EXPIRY_PRD)
								.toString());
						String expiryDate = dateUtil.addDaysToCurrentDate(days);						
						user.setPasswordExpiryDate(expiryDate);					
						user.setrCreId(BatchConstants.BATCH_UPLD_USER_ID);
						user.setrModId(BatchConstants.BATCH_UPLD_USER_ID);
						user.setLastLogoutTime(ApplicationConstant.LAST_LOGOUT_TIME);
						user.setTotalNoOfLogin("0");
						user.setUserEnableFlag("Y");
						user.setDeleteFlag("N");
						user.setrModId(BatchConstants.BATCH_UPLD_USER_ID);
						user.setrCreId(BatchConstants.BATCH_UPLD_USER_ID);
						user.setPasswordResetFlag("Y");					
							userList.add(user);
					}
					userListDao.insertUserList(userList);
					break;
				}
				
				

				}
																		

			}
		}		
			 remarks = "Batch Program Name :"
						+ importDataVO.getBatchName() + "," + "Data type :"
						+ importDataVO.getDataType() + ","
						+ "Batch Serial No:" + batchSerialNo;	
			 auditConstant = AuditConstant.BATCH_PROGRAM_SUCCESS;
																	
		
			doAudit.doFunctionalAudit(userSessionDetails,auditConstant
					, remarks);
			logger.info("Completed Functional Auditing..");
					
		
	}
	
	
}
