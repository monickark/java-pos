package com.pos.accessories.dao;

import java.util.List;

import com.pos.common.exceptions.DuplicateEntryException;

public interface IAccessoriesListDAO {

	List<AccessoriesList> selectAccessoriesList() throws DuplicateEntryException;

}
