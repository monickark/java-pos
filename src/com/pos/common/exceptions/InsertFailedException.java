package com.pos.common.exceptions;

import com.pos.common.constants.ErrorCodeConstant;



public class InsertFailedException extends Exception {

	String message = ErrorCodeConstant.INSERT_FAILED;

	public String getMessage() {
		return message;
	}

}
