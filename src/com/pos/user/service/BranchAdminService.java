package com.pos.user.service;

import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.AuditConstant;
import com.pos.common.constants.SequenceConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DeleteFailedException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.FileNotFoundInDatabase;
import com.pos.common.exceptions.FileNotSaveException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.exceptions.UserNotCreatedException;
import com.pos.common.exceptions.login.InvalidUserIdException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.common.files.service.FileMasterHelper;
import com.pos.common.util.AlphaSequenceUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.audit.service.DoAudit;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.UserSessionDetails;
import com.pos.user.controller.BranchAdminVO;
import com.pos.user.controller.UserCreationVO;
import com.pos.user.dao.IUserDao;
import com.pos.user.dao.IUserLinkDao;
import com.pos.user.util.UserCreation;

//Institute Master Service Class
@Service
public class BranchAdminService implements IBranchAdminService {
	@Autowired
	CommonBusiness commonBusiness;
	@Autowired
	UserCreation userCreation;
	@Autowired
	IUserLinkDao userLinkDao;
	@Autowired
	IUserDao userDao;
	@Autowired
	FileMasterHelper fileMasterHelper;
	@Autowired
	AlphaSequenceUtil alphaSequenceUtil;
	@Autowired
	DoAudit doAudit;
	@Autowired
	@Qualifier(value = "simpleIdGenerator")
	private IIdGeneratorService simpleIdGenerator;
	// Logging
	Logger logger = Logger.getLogger(BranchAdminService.class);
	
	@Override
	public void selectStaffDetails(BranchAdminVO adminVO,
			UserSessionDetails userSessionDetails) throws NoDataFoundException,
			UserNotCreatedException {
		if (adminVO.getIsSingleBranch().equals("Y")) {
			adminVO.setBranchId(userSessionDetails.getInstId());
		}
		
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertBranchAdmin(BranchAdminVO adminVO,
			UserSessionDetails userSessionDetails,
			ApplicationCache applicationCache,ServletContext servletContext) throws FileNotFoundInDatabase,
			DuplicateEntryException, InvalidUserIdException,
			UpdateFailedException, DatabaseException, NumberFormatException,
			PropertyNotFoundException, IllegalStateException, IOException, DeleteFailedException, FileNotSaveException {
		if (adminVO.getIsSingleBranch().equals("Y")) {
			adminVO.setBranchId(userSessionDetails.getInstId());
			
		}
		/*if (adminVO.getIsStaff().equals(ApplicationConstant.PG_NON_STAFF)) {
			NonStaff nonStaff = new NonStaff();
			commonBusiness.changeObject(nonStaff, adminVO);
			nonStaff.setDbTs(1);
			nonStaff.setStaffId(alphaSequenceUtil.generateAlphaSequence(
					ApplicationConstant.STRING_NON_STAFF_SEQ, simpleIdGenerator
							.getNextId(SequenceConstant.NONSTAFF_USER_SEQUENCE,
									1)));
			nonStaff.setInstId(userSessionDetails.getInstId());
			nonStaff.setrCreId(userSessionDetails.getUserId());
			nonStaff.setrModId(userSessionDetails.getUserId());
			nonStaff.setDelFlg("N");
			logger.debug("Single Branch or not :" + adminVO.getIsSingleBranch());
			
			nonStaffDetailsDAO.insertNonStaffDetails(nonStaff);
			fileMasterHelper.fileUpload(applicationCache,
					adminVO.getStaffPhoto(),
					ApplicationConstant.NON_STAFF_PHOTO, 1, userSessionDetails,
					userSessionDetails.getUserId(),
					userSessionDetails.getInstId(), adminVO.getBranchId(),
					nonStaff.getStaffId(),ApplicationConstant.DEFAULT_FILE_SRL_NO,ApplicationConstant.PG_NON_STAFF,servletContext);
			
			UserCreationVO userCreationVO = new UserCreationVO();
			userCreationVO.setApplicationCache(applicationCache);
			userCreationVO.setLinkId(nonStaff.getStaffId());
			userCreationVO.setMenuProfile(ApplicationConstant.BRANCH_ADMIN);
			userCreationVO.setPassword(adminVO.getPassword());
			userCreationVO.setProfileGroup(ApplicationConstant.PG_NON_STAFF);
			userCreationVO.setRole("");
			userCreationVO.setUserId(adminVO.getUserId());
			userCreationVO.setUserSessionDetails(userSessionDetails);
			
			userCreation.createUser(userCreationVO);
			String remarks = "inst_id:" + userSessionDetails.getInstId()
					+ ",branch_id:" + adminVO.getBranchId() + ",admin_id:"
					+ adminVO.getStaffId();
			doAudit.doFunctionalAudit(userSessionDetails,
					AuditConstant.NSTF_USER_CREATE, remarks);
		}*/
	}
}
