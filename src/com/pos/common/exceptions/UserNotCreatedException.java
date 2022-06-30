package com.pos.common.exceptions;

import com.pos.common.constants.ErrorCodeConstant;



public class UserNotCreatedException extends Exception {

	String message = ErrorCodeConstant.USERID_NOT_CREATED;

	public String getMessage() {
		return message;
	}

}
