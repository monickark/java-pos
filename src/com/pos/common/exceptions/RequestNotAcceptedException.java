package com.pos.common.exceptions;

import com.pos.common.constants.ErrorCodeConstant;



public class RequestNotAcceptedException extends Exception {

	String message = ErrorCodeConstant.BATCH_UPDATE_FAILED;

	public String getMessage() {
		return message;
	}

}
