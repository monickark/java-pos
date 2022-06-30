package com.pos.common.util;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.pos.common.exceptions.util.PropertyNotFoundException;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.appCache.dao.SMSProperty;
@Component
public class SMSPropertyManagementUtil {
	Logger logger = Logger.getLogger(SMSPropertyManagementUtil.class);

	public String getPropertyValue(ApplicationCache applicationCache,
			String instid, String branchId, String code)
			throws PropertyNotFoundException {
		logger.debug("SMSManagementUtil values :Application cache :"
				+ applicationCache + "  instid :" + instid + "  branchId :"
				+ branchId + "  code :" + code);
		for (SMSProperty smsProperty : applicationCache.getSmsProperty()) {
			if (smsProperty.getInstId().equals(instid)
					&& (smsProperty.getBranchId().equals(branchId))
					&& (smsProperty.getPropertyName().equals(code))) {
				return smsProperty.getPropertyValue();
			}

		}
		logger.error("No value found for " + applicationCache + "  instid :"
				+ instid + "  branchId :" + branchId + "  code :" + code);
		throw new PropertyNotFoundException();
	}

}
