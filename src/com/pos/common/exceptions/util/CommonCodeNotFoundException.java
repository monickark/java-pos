package com.pos.common.exceptions.util;

import com.pos.common.constants.ErrorCodeConstant;

public class CommonCodeNotFoundException extends Exception {

	String message = ErrorCodeConstant.COMMON_CODE_NOT_FOUND;

	@Override
	public String getMessage() {
		return message;
	}

}
