package com.pos.accessories.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.accessories.controller.AddAccessoriesVO;
import com.pos.accessories.dao.AccessoriesList;
import com.pos.accessories.dao.IAccessoriesListDAO;
import com.pos.common.business.CommonBusiness;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;

@Service
public class AccessoriesListService implements IAccessoriesListService{

	@Autowired
	private CommonBusiness commonBussiness;
	@Autowired
	private IAccessoriesListDAO accessoriesListDAO;
	@Override
	public List<AddAccessoriesVO> selectAccessoriesList(AddAccessoriesVO addAccessoriesVO)throws NoDataFoundException, DuplicateEntryException  {
		
		System.out.println("Acc List service:" +addAccessoriesVO);
		
		List<AddAccessoriesVO> addAccessoriesVOs = new ArrayList<AddAccessoriesVO>();
		AccessoriesList accessoriesList = new AccessoriesList();
		commonBussiness.changeObject(accessoriesList, addAccessoriesVO);

		List<AccessoriesList> accessoriesLists = accessoriesListDAO.selectAccessoriesList();

		for (AccessoriesList accessoriesList2 : accessoriesLists) {
			AddAccessoriesVO addAccessoriesVO2 = new AddAccessoriesVO();
			commonBussiness.changeObject(addAccessoriesVO2, accessoriesList2);
			addAccessoriesVOs.add(addAccessoriesVO2);
		}

		return addAccessoriesVOs;
	}

}
