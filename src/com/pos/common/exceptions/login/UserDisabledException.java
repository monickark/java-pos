package com.pos.common.exceptions.login;

import com.pos.common.constants.ErrorCodeConstant;

public class UserDisabledException extends Exception {
	String message = ErrorCodeConstant.USER_DISABLED;

	@Override
	public String getMessage() {
		return message;
	}

}
