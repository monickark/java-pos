package com.pos.common.exceptions;

import com.pos.common.constants.ErrorCodeConstant;

public class FileNotSaveException extends Exception {

	String message = ErrorCodeConstant.FILE_NOT_SAVE;

	public String getMessage() {
		return message;
	}
	
	
}
