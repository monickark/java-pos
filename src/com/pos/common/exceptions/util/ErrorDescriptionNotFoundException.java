package com.pos.common.exceptions.util;

import com.pos.common.constants.ErrorCodeConstant;

public class ErrorDescriptionNotFoundException extends Exception {

	String message = ErrorCodeConstant.ERROR_DESCRIPTION_NOT_FOUND;

	@Override
	public String getMessage() {
		return message;
	}

}
