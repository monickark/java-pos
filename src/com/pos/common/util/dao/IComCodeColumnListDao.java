package com.pos.common.util.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface IComCodeColumnListDao {
public List<ComCodeColumn> getCommonCodeColumnList(ComCodeColumnSearch comCodeColumnKey) throws NoDataFoundException ;

}
