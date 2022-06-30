package com.pos.common.exceptions;

import com.pos.common.constants.ErrorCodeConstant;



public class UpdateFailedException extends Exception {

	String message = ErrorCodeConstant.UPDATE_FAILED;

	public String getMessage() {
		return message;
	}

}
