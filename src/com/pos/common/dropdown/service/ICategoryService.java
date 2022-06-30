package com.pos.common.dropdown.service;

import java.util.Map;

import com.pos.common.exceptions.NoDataFoundException;

public interface ICategoryService {

	Map<String, String> getCategory() throws NoDataFoundException;

}
