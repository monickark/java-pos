package com.pos.admin.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface IDataLogListDao {
public List<DataLog> getDataLogList(DataLogKey dataLogKey) throws NoDataFoundException;
}
