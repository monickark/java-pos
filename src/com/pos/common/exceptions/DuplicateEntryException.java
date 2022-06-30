package com.pos.common.exceptions;

import com.pos.common.constants.ErrorCodeConstant;

public class DuplicateEntryException extends Exception {
	
	String message = ErrorCodeConstant.DUPLICATE_ENTRY;

	public String getMessage() {
		return message;
	}

	
}
