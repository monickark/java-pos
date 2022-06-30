package com.pos.admin.service;

import java.io.IOException;

import javax.servlet.ServletContext;

import com.pos.admin.controller.InstituteMasterVO;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DeleteFailedException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.FileNotFoundInDatabase;
import com.pos.common.exceptions.FileNotSaveException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.exceptions.batch.NoRecordFoundException;
import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.common.exceptions.util.TableNotSpecifiedForAuditException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.sessCache.UserSessionDetails;

//Interface for Institute Master Service Class 
public interface IInstituteMasterService {

	void selectInstituteMasterRec(ApplicationCache applicationCache,
			InstituteMasterVO instVO) throws DatabaseException,
			PropertyNotFoundException;

	void updateInstituteMasterRec(InstituteMasterVO instVO,
			UserSessionDetails userSessionDetails,
			ApplicationCache applicationCache,ServletContext servletContext) throws DuplicateEntryException,
			FileNotFoundInDatabase, NoRecordFoundException, DatabaseException,
			UpdateFailedException, TableNotSpecifiedForAuditException, IllegalStateException, IOException, DeleteFailedException, FileNotSaveException;


}
