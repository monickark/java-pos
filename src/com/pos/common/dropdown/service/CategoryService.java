package com.pos.common.dropdown.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pos.common.dropdown.dao.BrandList;
import com.pos.common.dropdown.dao.Category;
import com.pos.common.dropdown.dao.ICategoryDAO;
import com.pos.common.exceptions.NoDataFoundException;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	ICategoryDAO categoryDAO;
	public Map<String, String> getCategory()
			throws NoDataFoundException {
		List<Category> categories = categoryDAO
				.selectCategory();
		System.out.println("Category Service :" +categories);
		System.out.println("Category Service  size:" +categories.size());
		Map<String, String> categoryMap = new LinkedHashMap<String, String>();
		for (Category category : categories) {
			categoryMap.put(category.getCategoryId(),
					category.getCategoryName());
			
		}
		System.out.println("Brand Map Service :" +categoryMap);
		return categoryMap;

	}

}
