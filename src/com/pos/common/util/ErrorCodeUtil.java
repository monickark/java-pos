package com.pos.common.util;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pos.common.exceptions.util.ErrorDescriptionNotFoundException;
import com.pos.framework.appCache.ApplicationCache;

@Component
public class ErrorCodeUtil {
	Logger logger = Logger.getLogger(ErrorCodeUtil.class);
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private ApplicationCache applicationCache;

	public Object getErrorDescription(ApplicationCache applicationCache,
			String code) throws ErrorDescriptionNotFoundException {
		logger.debug("ErrorCodeUtil values :Application cache :"
				+ applicationCache + "  code :" + code);
		Map<String, String> attribute2 = applicationCache.getErrorcode();
		String description = attribute2.get(code);
		if (description == null) {
			logger.error("No description found for code:" + code);
			throw new ErrorDescriptionNotFoundException();

		}
		return description;

	}

}
