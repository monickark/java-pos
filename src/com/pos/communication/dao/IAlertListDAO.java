package com.pos.communication.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface IAlertListDAO {
	public List<Alert> getAlertList(final AlertListKey alertListKey)
			throws NoDataFoundException;
	public List<Alert> getAlertListForDashBoard(final AlertListKey alertListKey,String profileGroup)
			throws NoDataFoundException;
}
