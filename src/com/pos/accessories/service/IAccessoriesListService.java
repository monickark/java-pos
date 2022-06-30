package com.pos.accessories.service;

import java.util.List;

import com.pos.accessories.controller.AddAccessoriesVO;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;

public interface IAccessoriesListService {

	

	List<AddAccessoriesVO> selectAccessoriesList(AddAccessoriesVO addAccessoriesVO)
			throws NoDataFoundException, DuplicateEntryException;

}
