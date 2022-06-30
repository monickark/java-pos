package com.pos.common.dropdown.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.pos.brand.dao.Brand;
import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.SequenceConstant;
import com.pos.common.dropdown.dao.BrandList;
import com.pos.common.dropdown.dao.BrandModelList;
import com.pos.common.dropdown.dao.IBrandModelListDAO;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.util.AlphaSequenceUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.SessionCache;
import com.pos.product.controller.ModelVO;
@Service
public class BrandModelListService implements IBrandModelListService {
@Autowired
IBrandModelListDAO brandModelListDAO;
@Autowired
@Qualifier(value = "simpleIdGenerator")
IIdGeneratorService simpleIdGenerator;
@Autowired
CommonBusiness commonBusiness;
public Map<String, String> getBrandModelList()
		throws NoDataFoundException {
	List<BrandModelList> brandModelLists = brandModelListDAO
			.selectBrandModelList();
	System.out.println("Brand Model List Service :" +brandModelLists);
	System.out.println("Brand Model List Service  size:" +brandModelLists.size());
	Map<String, String> brandModelMap = new LinkedHashMap<String, String>();
	for (BrandModelList brandModelList : brandModelLists) {
		brandModelMap.put(brandModelList.getModelId(),brandModelList.getModelValue());
		
	}
	System.out.println("Brand Model Map Service :" +brandModelMap);
	return brandModelMap;

}

@Override
public void addBrandModel(ModelVO brandModelListVO, SessionCache sessionCache,
		ApplicationCache applicationCache) throws DatabaseException, DuplicateEntryException{
	
	System.out.println("Brand Model service :" +brandModelListVO);
	
	Integer sequence = simpleIdGenerator.getNextId(SequenceConstant.MODEL_SEQUENCE, 1);
	String modelIdSequence = AlphaSequenceUtil.generateAlphaSequence(ApplicationConstant.STRING_MODEL_SEQ,
			sequence);
	
	BrandModelList brandModelList = new BrandModelList();
	commonBusiness.changeObject(brandModelList, brandModelListVO);
	brandModelList.setDbTs(1);
	brandModelList.setDelFlg("N");
	brandModelList.setModelId(modelIdSequence);
	brandModelList.setBrandId(brandModelListVO.getBrandId());
	brandModelList.setrCreId(sessionCache.getUserSessionDetails().getUserId());
	brandModelList.setrModId(sessionCache.getUserSessionDetails().getUserId());
	
	System.out.println("Brand Model List service :" +brandModelList);
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	 Calendar cal = Calendar.getInstance();
	 
	 String creTime=dateFormat.format(cal.getTime());
	 brandModelList.setrCreTime(creTime);

	 String modTime=dateFormat.format(cal.getTime());
	 brandModelList.setrModTime(modTime);
	 
	 brandModelListDAO.addBrandModel(brandModelList);
}

@Override
public Map<String, String> getBrandModelList(String brand)
		throws NoDataFoundException {
	List<BrandModelList> brandModelLists = brandModelListDAO
			.selectBrandModelList(brand);
	System.out.println("Brand Model List Service :" +brandModelLists);
	System.out.println("Brand Model List Service  size:" +brandModelLists.size());
	Map<String, String> brandModelMap = new LinkedHashMap<String, String>();
	for (BrandModelList brandModelList : brandModelLists) {
		brandModelMap.put(brandModelList.getModelId(),brandModelList.getModelValue());
		
	}
	System.out.println("Brand Model Map Service :" +brandModelMap);
	return brandModelMap;

}

}
