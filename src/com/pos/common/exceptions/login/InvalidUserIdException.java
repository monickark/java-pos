package com.pos.common.exceptions.login;

import com.pos.common.constants.ErrorCodeConstant;

public class InvalidUserIdException extends Exception {
	String message = ErrorCodeConstant.INVALID_USERID;

	@Override
	public String getMessage() {
		return message;
	}

}
