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

import com.pos.common.business.CommonBusiness;
import com.pos.common.constants.ApplicationConstant;
import com.pos.common.constants.SequenceConstant;
import com.pos.common.dropdown.dao.BrandList;
import com.pos.common.dropdown.dao.IBrandListDAO;
import com.pos.common.exceptions.DatabaseException;
import com.pos.common.exceptions.DuplicateEntryException;
import com.pos.common.exceptions.NoDataFoundException;
import com.pos.common.util.AlphaSequenceUtil;
import com.pos.framework.appCache.ApplicationCache;
import com.pos.framework.seqGen.service.IIdGeneratorService;
import com.pos.framework.sessCache.SessionCache;
import com.pos.framework.sessCache.UserSessionDetails;
import com.pos.product.controller.BrandVO;
@Service
public class BrandListService implements IBrandListService {
	@Autowired
	IBrandListDAO brandListDao;
	@Autowired
	@Qualifier(value = "simpleIdGenerator")
	IIdGeneratorService simpleIdGenerator;
	@Autowired
	CommonBusiness commonBusiness;
	public Map<String, String> getBrandList(
			)
			throws NoDataFoundException {
		List<BrandList> brandLists = brandListDao
				.selectBrandList();
		System.out.println("Brand List Service :" +brandLists);
		System.out.println("Brand List Service  size:" +brandLists.size());
		Map<String, String> brandMap = new LinkedHashMap<String, String>();
		for (BrandList brandList : brandLists) {
			brandMap.put(brandList.getBrandId(),
					brandList.getBrandName());
			
		}
		System.out.println("Brand Map Service :" +brandMap);
		return brandMap;

	}

	@Override
	public void addBrand(BrandVO brandListVO, SessionCache sessionCache,
			ApplicationCache applicationCahce) throws DatabaseException, DuplicateEntryException {
		
		System.out.println("Brand service :" +brandListVO);
		
		Integer sequence = simpleIdGenerator.getNextId(SequenceConstant.BRAND_SEQUENCE, 1);
		String brandIdSequence = AlphaSequenceUtil.generateAlphaSequence(ApplicationConstant.STRING_BRAND_SEQ,
				sequence);
		BrandList brandList = new BrandList();
		commonBusiness.changeObject(brandList, brandListVO);
		brandList.setDbTs(1);
		brandList.setDelFlg("N");
		brandList.setBrandId(brandIdSequence);
		brandList.setrCreId(sessionCache.getUserSessionDetails().getUserId());
		brandList.setrModId(sessionCache.getUserSessionDetails().getUserId());
		
		System.out.println("BrandList service :" +brandList);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Calendar cal = Calendar.getInstance();
		 
		 String creTime=dateFormat.format(cal.getTime());
		 brandList.setrCreTime(creTime);

		 String modTime=dateFormat.format(cal.getTime());
		 brandList.setrModTime(modTime);
		brandListDao.addBrand(brandList);
	}



}





