package com.pos.common.exceptions;

import com.pos.common.constants.ErrorCodeConstant;

public class DuplicatesInList extends Exception {



	String message = ErrorCodeConstant.DUPLICATE_ERROR_WITHIN_LIST;

	public String getMessage() {
		return message;
	}

	
}
