package com.pos.common.dropdown.dao;

import java.util.List;

import com.pos.common.exceptions.NoDataFoundException;

public interface ICategoryDAO {

	List<Category> selectCategory() throws NoDataFoundException;

}
