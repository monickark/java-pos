package com.pos.common.exceptions.util;

import com.pos.common.constants.ErrorCodeConstant;

public class TableNotSpecifiedForAuditException extends Exception {

	String message = ErrorCodeConstant.TABLE_NOT_SPECIFIED_FOR_AUDIT;

	@Override
	public String getMessage() {
		return message;

	}

}
