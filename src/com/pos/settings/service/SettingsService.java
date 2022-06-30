package com.pos.settings.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.SequenceConstant;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.exceptions.UpdateFailedException;
import com.pos.common.util.AlphaSequenceUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.SessionCache;
import com.pos.settings.controller.SettingsVO;
import com.pos.settings.dao.ISettingsDAO;
import com.pos.settings.dao.Settings;

@Service
public class SettingsService implements ISettingsService {

	@Autowired
	ISettingsDAO settingsDAO;
	@Autowired
	@Qualifier(value = "simpleIdGenerator")
	IIdGeneratorService simpleIdGenerator;
	@Autowired
	CommonBusiness commonBussiness;

	Logger logger = Logger.getLogger(SettingsService.class);

	@Override
	public void addSettings(SettingsVO settingVO, SessionCache sessionCache,
			ApplicationCache applicationCache) throws DatabaseException,
			DuplicateEntryException {

		logger.debug("Inserting Company Details");
		Integer sequence = simpleIdGenerator.getNextId(
				SequenceConstant.COMPANY_SEQUENCE, 1);
		String companyIdSequence = AlphaSequenceUtil.generateAlphaSequence(
				ApplicationConstant.STRING_COMPANY_SEQ, sequence);

		Settings settings = new Settings();
		commonBussiness.changeObject(settings, settingVO);
		settings.setDbTs(1);
		settings.setDelFlg("N");
		settings.setCompanyId(companyIdSequence);
		settings.setrCreId(sessionCache.getUserSessionDetails().getUserId());
		settings.setrModId(sessionCache.getUserSessionDetails().getUserId());

		settingsDAO.insertSetting(settings);

	}

	@Override
	public SettingsVO getCompanyDetails() throws NoDataFoundException {

		Settings settings = settingsDAO.selectCompanyDetails();
		SettingsVO settingsVO = new SettingsVO();
		commonBussiness.changeObject(settingsVO, settings);
		return settingsVO;

	}

	// TO update the settings
	@Override
	public void updateSettings(SettingsVO settingVO, SessionCache sessionCache,
			ApplicationCache applicationCache) throws UpdateFailedException,
			NoDataFoundException {

		Settings settings = new Settings();
		commonBussiness.changeObject(settings, settingVO);
		settings.setrModTime(sessionCache.getUserSessionDetails().getUserId());
		settings.setrModId(sessionCache.getUserSessionDetails().getUserId());
		settingsDAO.updateSettings(settings);
	}

}
