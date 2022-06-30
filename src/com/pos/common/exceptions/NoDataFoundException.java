package com.pos.common.exceptions;

import com.pos.common.constants.ErrorCodeConstant;

public class NoDataFoundException extends Exception {
	String message = ErrorCodeConstant.NO_RECORD_FOUND;

	public String getMessage() {
		return message;
	}


}
