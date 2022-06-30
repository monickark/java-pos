package com.pos.accessories.dao;

import com.pos.common.exceptions.DuplicateEntryException;

public interface IAddCategoryDAO {

	void insertCategory(AddCategory addCategory)throws DuplicateEntryException;

}
