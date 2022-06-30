package com.pos.common.exceptions;

import com.pos.common.constants.ErrorCodeConstant;



public class DeleteFailedException extends Exception {

	String message = ErrorCodeConstant.DELETE_FAILED;

	public String getMessage() {
		return message;
	}

}
