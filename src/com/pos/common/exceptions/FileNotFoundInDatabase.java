package com.pos.common.exceptions;

import com.pos.common.constants.ErrorCodeConstant;

//Exception class for FileNotFoundException
public class FileNotFoundInDatabase extends Exception {
	String message = ErrorCodeConstant.FILE_NOT_FOUND;

	public String getMessage() {
		return message;
	}

	


}
