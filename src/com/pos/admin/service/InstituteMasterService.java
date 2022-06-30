package com.pos.admin.service;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pos.admin.controller.InstituteMasterVO;
import com.pos.admin.dao.IInstituteMasterDAO;
import com.pos.admin.dao.InstituteMaster;
import com.pos.admin.dao.InstituteMasterKey;
import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.AuditConstant;
import com.pos.common.constants.PropertyManagementConstant;
import com.pos.common.constants.TableNameConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DeleteFailedException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.FileNotFoundInDatabase;
import com.pos.common.exceptions.FileNotSaveException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.exceptions.batch.NoRecordFoundException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.common.exceptions.util.TableNotSpecifiedForAuditException;
import com.pos.common.files.dao.IFileMasterDao;
import com.pos.common.files.service.FileMasterHelper;
import com.pos.common.util.PropertyManagementUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.audit.service.DoAudit;
import com.pos.framework.sessCache.UserSessionDetails;

//Institute Master Service Class
@Service
public class InstituteMasterService implements IInstituteMasterService {

	// Logging
	Logger logger = Logger.getLogger(InstituteMasterService.class);

	@Autowired
	IInstituteMasterDAO instMasterDao;
	@Autowired
	CommonBusiness commonBusiness;
	// Helper class to do Auditing
	@Autowired
	DoAudit doAudit;
	@Autowired
	FileMasterHelper fileMasterHelper;
	@Autowired
	IFileMasterDao fileMasterDao;
	@Autowired
	PropertyManagementUtil prpmUtil;

	@Override
	// method to Select Institute Master List
	public void selectInstituteMasterRec(ApplicationCache applicationCache,
			InstituteMasterVO instVO) throws DatabaseException,
			PropertyNotFoundException {
		// logger.debug("inside selectInstituteMasterRec method");
		InstituteMaster selectedInstMasterRecord = instMasterDao
				.selectInstituteMasterRec(null,null);
		commonBusiness.changeObject(instVO, selectedInstMasterRecord);	
		instVO.setSingleBranch(prpmUtil.getPropertyValue(applicationCache,
				instVO.getInstId(), instVO.getInstId(),
				PropertyManagementConstant.INST_SINGLE_BRANCH));			

	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	// method to Update InstituteMaster
	public void updateInstituteMasterRec(InstituteMasterVO instVO,
			UserSessionDetails userSessionDetails,
			ApplicationCache applicationCache,ServletContext servletContext) throws FileNotFoundInDatabase,
			DuplicateEntryException, NoRecordFoundException, DatabaseException,
			UpdateFailedException, TableNotSpecifiedForAuditException, IllegalStateException, IOException, DeleteFailedException, FileNotSaveException {

		logger.debug("inside updateInstituteMaster method");
		InstituteMaster selectedInstMasterRecord = instMasterDao
				.selectInstituteMasterRec(instVO.getDbTs(), instVO.getInstId());
		InstituteMaster updatedInstMaster = new InstituteMaster();
		InstituteMasterKey updatedInstMasterKey = new InstituteMasterKey();
		// map the UIObject to Pojo
		commonBusiness.changeObject(updatedInstMaster, instVO);
		// Copy the Key from Pojo
		commonBusiness.changeObject(updatedInstMasterKey,
				selectedInstMasterRecord);
		updatedInstMaster.setDbTs(selectedInstMasterRecord.getDbTs());
		updatedInstMaster.setDelFlag(selectedInstMasterRecord.getDelFlag());
		updatedInstMaster.setrModId(userSessionDetails.getUserId());

		// for Institute Logo updation
		fileMasterHelper.fileUpload(applicationCache,
				instVO.getInstLogo(),
				ApplicationConstant.INSTITUTE_BRANCH_LOGO_KEY,
				updatedInstMaster.getDbTs(), userSessionDetails,
				userSessionDetails.getUserId(), instVO.getInstId(),ApplicationConstant.DEFAULT_FILE_SRL_NO,"",servletContext);

		// InstituteMaster Updation
		instMasterDao.updateInstituteMasterRec(updatedInstMaster,
				updatedInstMasterKey);

		// functional audit
		doAudit.doFunctionalAudit(userSessionDetails,
				AuditConstant.INSM_UPDATE, " ");
		logger.debug("Completed Functional Auditing");

		// Database audit
		String oldRecString = selectedInstMasterRecord
				.toStringForAuditInstMasterRecord();
		InstituteMaster selectNewRecord = instMasterDao
				.selectInstituteMasterRec(null,null);
		String newRecString = selectNewRecord
				.toStringForAuditInstMasterRecord();
		doAudit.doDatabaseAudit(applicationCache, userSessionDetails,
				TableNameConstant.INSTITUTE_MASTER,
				selectedInstMasterRecord.toStringForAuditInstMasterKey(),
				oldRecString, AuditConstant.TYPE_OF_OPER_UPDATE, newRecString,
				"");

		logger.debug("Completed Database Auditing");

	}
	

}
