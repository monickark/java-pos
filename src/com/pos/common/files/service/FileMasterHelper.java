package com.pos.common.files.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.PropertyManagementConstant;
import com.pos.common.constants.SequenceConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DeleteFailedException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.FileNotFoundInDatabase;
import com.pos.common.exceptions.FileNotSaveException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.common.files.dao.FileHistory;
import com.pos.common.files.dao.FileMaster;
import com.pos.common.files.dao.IFileHistoryDao;
import com.pos.common.files.dao.IFileMasterDao;
import com.pos.common.files.dao.IFileMasterListDao;
import com.pos.common.util.AlphaSequenceUtil;
import com.pos.common.util.DateUtil;
import com.pos.common.util.PropertyManagementUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.audit.service.DoAudit;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.UserSessionDetails;

//Helper class for file operations
@Component
public class FileMasterHelper {

	// Logging
	Logger logger = Logger.getLogger(FileMasterHelper.class);

	@Autowired
	IIdGeneratorService simpleIdGenerator;
	@Autowired
	IFileMasterDao fileMasterDao;
	@Autowired
	IFileMasterListDao fileMasterListDao;
	// Helper class to do Auditing
	@Autowired
	DoAudit doAudit;
	@Autowired
	DateUtil dateUtil;
	@Autowired
	IFileHistoryDao fileHistoryDao;
	@Autowired
	CommonBusiness commonBusiness;
	@Autowired
	FileSaveHelper fileSaveHelper;
	@Autowired
	PropertyManagementUtil propertyManagementUtil;
	public void fileUpload(ApplicationCache applicationCache,
			MultipartFile imagefile, String fileType, Integer dbtsValue,
			UserSessionDetails userSessionDetails, String rCreId,
			String instId, String branchId, String linkId, String fileSrlNo,String profileGrp,ServletContext servletContext)
			throws DuplicateEntryException, FileNotFoundInDatabase,
			DatabaseException, IllegalStateException, IOException, DeleteFailedException, FileNotSaveException {
		if (branchId != null) {
			userSessionDetails.setBranchId(branchId);
		}
		if (instId != null) {
			userSessionDetails.setInstId(instId);
		}
		fileUpload(applicationCache, imagefile, fileType, dbtsValue,
				userSessionDetails, rCreId, linkId, fileSrlNo,profileGrp,servletContext);
	}

	// Method to update a single file/image
	public void fileUpload(ApplicationCache applicationCache,
			MultipartFile imagefile, String fileType, Integer dbtsValue,
			UserSessionDetails userSessionDetails, String rCreId,
			String linkId, String fileSrlNo,String profileGrp,ServletContext servletContext) throws DuplicateEntryException,
			FileNotFoundInDatabase, DatabaseException, IllegalStateException, IOException, DeleteFailedException, FileNotSaveException {
		FileMaster file = null;
		try {

			if (!imagefile.isEmpty()) {
				file = new FileMaster();
				BeanUtils.copyProperties(file, imagefile);
				file.setFileType(fileType);
				Integer seq = simpleIdGenerator.getNextId(
						SequenceConstant.FILE_REF_KEY, 1);
				file.setFileRefno((AlphaSequenceUtil.generateAlphaSequence(
						ApplicationConstant.STRING_FILE_MASTER_SEQ, seq)));
				file.setLinkId(linkId);
				file.setInputStream(imagefile.getInputStream());
				file.setFile(imagefile);
				file.setContentType(imagefile.getContentType());
				file.setSize(imagefile.getSize());
				file.setDbTs(dbtsValue);
				file.setInstId(userSessionDetails.getInstId());
				file.setBranchId(userSessionDetails.getBranchId());
				file.setDelFlg("N");
				file.setrModId(userSessionDetails.getUserId());
				file.setrModTime(dateUtil.getCurrentDateWithTime());
				file.setrCreId(rCreId);
				file.setrCreTime(dateUtil.getCurrentDateWithTime());
				if ((fileSrlNo == null) || (fileSrlNo == "")) {
					file.setFileSrlno(ApplicationConstant.DEFAULT_FILE_SRL_NO);
				} else {
					file.setFileSrlno(fileSrlNo);
				}

			}

		} catch (IllegalAccessException illegalAccessException) {
			logger.error(illegalAccessException);
		} catch (InvocationTargetException invocationTargetException) {
			logger.error(invocationTargetException);
		} catch (IOException e) {
			logger.error("IO Exception in FileMaster", e);
		}	
		doFileInsert(applicationCache, file, userSessionDetails,profileGrp,servletContext);

	}

	// method to do file insert operation for Institute Master Logo
	public void doFileInsert(ApplicationCache applicationCache,
			FileMaster file, UserSessionDetails userSessionDetails,String profileGrp,ServletContext servletContext)
			throws DuplicateEntryException, FileNotFoundInDatabase,
			DatabaseException, IllegalStateException, IOException, DeleteFailedException, FileNotSaveException {
	
		FileMaster fileMaster = null;
		if (file != null) {
			
			//Check for prpm constant for database or filesystem storage
			String stuFileStorage = null;
			try {
				String prpmConstant = null;
				if(profileGrp.equals(ApplicationConstant.PG_STUDENT)){
					prpmConstant = PropertyManagementConstant.STU_FILE_STORAGE;
				}else if(profileGrp.equals(ApplicationConstant.PG_STAFF)){
					prpmConstant = PropertyManagementConstant.STF_FILE_STORAGE;
				}
				stuFileStorage=	propertyManagementUtil.getPropertyValue(applicationCache, userSessionDetails.getInstId(),
						userSessionDetails.getBranchId(),prpmConstant);
			} catch (PropertyNotFoundException e) {
				logger.error("Prpm value for File storage option not found");
				e.printStackTrace();
			}					
		String fileSrlNo = file.getFileSrlno();
				if (fileSrlNo == "") {
					fileSrlNo = ApplicationConstant.DEFAULT_FILE_SRL_NO;
				}
				fileMaster = fileMasterDao.getSingleFile(file.getInstId(),
						file.getBranchId(), file.getLinkId(),
						file.getFileType(), fileSrlNo);
							
				
				FileHistory fileHis = new FileHistory();
				commonBusiness.changeObject(fileHis, fileMaster);
				fileHis.setFlmtRCreId(fileMaster.getrCreId());
				fileHis.setFlmtRCreTime(fileMaster.getrCreTime());
				fileHis.setrCreId(userSessionDetails.getUserId());

				Integer srlNo = 0;
				srlNo = simpleIdGenerator.getNextId(
						SequenceConstant.FILE_HISTROY_SRL_NO, 1);
				fileHis.setFileHtSrlNo(AlphaSequenceUtil.generateAlphaSequence(
						ApplicationConstant.STRING_FILE_HISTORY_SEQ, srlNo));
				

				fileMasterDao.insertSingleFile(file, 1);
			
			
		}
			}

	// Method to get FileMaster Object for Batch of Files used in Admission
	public FileMaster getFileMasterObject(MultipartFile image,
			String fileSrlNo, String studentAdmisNo,
			UserSessionDetails userSessionDetails, String fileType)
			throws IOException, IllegalAccessException,
			InvocationTargetException, DatabaseException {
		FileMaster file = null;
		if ((image!=null)&&(!image.isEmpty())){
			file = new FileMaster();
			BeanUtils.copyProperties(file, image);
			file.setFileType(fileType);
			Integer seq = simpleIdGenerator.getNextId(
					SequenceConstant.FILE_REF_KEY, 1);
			file.setFileRefno((AlphaSequenceUtil.generateAlphaSequence(
					ApplicationConstant.STRING_FILE_MASTER_SEQ, seq)));
			file.setLinkId(studentAdmisNo);
			file.setInputStream(image.getInputStream());
			file.setFile(image);
			file.setContentType(image.getContentType());
			file.setSize(image.getSize());
			file.setInstId(userSessionDetails.getInstId());
			file.setBranchId(userSessionDetails.getBranchId());
			file.setDelFlg("N");
			file.setrModId(userSessionDetails.getUserId());
			file.setrModTime(dateUtil.getCurrentDateWithTime());
			file.setrCreId(userSessionDetails.getUserId());
			file.setrCreTime(dateUtil.getCurrentDateWithTime());
			file.setFileSrlno(fileSrlNo);
		}
		return file;

	}

	// Method to insert List of files in FileMaster as a batch used in Admission
	public void insertBatchOfFiles(List<FileMaster> fileMaster,String stuFileStorage,String profileGrp,ServletContext servletContext)
			throws DatabaseException, IllegalStateException, IOException, FileNotSaveException {	
	
			 Integer seqStarting = simpleIdGenerator.getNextId(
				SequenceConstant.FILE_REF_KEY, fileMaster.size());
		try {
			if (fileMaster != null && fileMaster.size() > 0) {
				Integer seq = seqStarting;
				seq=seq+1;			
				if(!stuFileStorage.equals(ApplicationConstant.FILE_IN_DB)){
					
					for(FileMaster fileMas:fileMaster){
						StringBuffer directoryStructure = new StringBuffer(fileSaveHelper.getDestinationDirectory(fileMaster.get(0).getInstId(), fileMaster.get(0).getBranchId(),
								profileGrp, fileMaster.get(0).getLinkId(),"",""));						
						if(!fileMas.getFileType().split("_")[0].equals(ApplicationConstant.PHOTO_CONSTANT)){
							String relativePath = (directoryStructure.append("/").append(ApplicationConstant.FILE_SEQ_CONSTANT+seq.toString()).append(".jpeg")).toString();
							String dirPath = FileSaveHelper.fileLocation(servletContext).concat(relativePath);		
							logger.debug("File Location :"+dirPath);
							fileSaveHelper.saveMultipartToDisk(dirPath, fileMas.getFile());							
							fileMas.setInputStream(null);	
							fileMas.setFileName(seq.toString()+".jpeg");
							fileMas.setFilepath(relativePath);
							seq++;
							
						}																		
					}
				}					
				fileMasterListDao.fileBatch(fileMaster, seqStarting);
			}
		} catch (DuplicateEntryException e) {

		}		

	}
	
		
}
