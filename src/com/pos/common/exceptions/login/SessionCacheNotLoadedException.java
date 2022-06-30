package com.pos.common.exceptions.login;

import com.pos.common.constants.ErrorCodeConstant;

public class SessionCacheNotLoadedException extends Exception {

	String message = ErrorCodeConstant.SESSION_CACHE_FAILED;

	@Override
	public String getMessage() {
		return message;
	}
}
