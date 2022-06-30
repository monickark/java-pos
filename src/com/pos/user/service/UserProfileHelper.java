package com.pos.user.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pos.common.business.CommonBusiness;
import com.pos.framework.sessCache.UserSessionDetails;

@Component
public class UserProfileHelper {
	@Autowired
	CommonBusiness commonBusiness;

	// Admin Profile
	public void getAdminProfile(UserSessionDetails userSessionDetails,
			InputStream inputStream) {

		try {
			byte[] bytes = IOUtils.toByteArray(inputStream);
			userSessionDetails.setUserPhoto(bytes);
			userSessionDetails.setUserName("admin");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
