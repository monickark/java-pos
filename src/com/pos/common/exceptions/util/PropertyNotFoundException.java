package com.pos.common.exceptions.util;

import com.pos.common.constants.ErrorCodeConstant;

public class PropertyNotFoundException extends Exception {

	String message = ErrorCodeConstant.PROPERTY_NOT_FOUND;

	@Override
	public String getMessage() {
		return message;
	}

}
