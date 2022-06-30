package com.pos.common.exceptions;

import com.pos.common.constants.ErrorCodeConstant;

public class PasswordrequestedLoginFailException extends Exception {

	String message = ErrorCodeConstant.PASSWORD_REQUESTED_LOGIN_FAILS;

	@Override
	public String getMessage() {
		return message;
	}
}
