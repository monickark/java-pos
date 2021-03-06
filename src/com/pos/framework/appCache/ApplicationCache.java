package com.pos.framework.appCache;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pos.admin.dao.BranchMaster;
import com.pos.framework.appCache.dao.CommonCode;
import com.pos.framework.appCache.dao.MenuProfileOptionLinking;
import com.pos.framework.appCache.dao.PropertyMaintenance;
import com.pos.framework.appCache.dao.SMSProperty;
import com.pos.framework.appCache.dao.TableMaintenance;

public class ApplicationCache implements Serializable {
	List<CommonCode> commoncode;
	Map<String, String> commoncodeMap;
	Map<String, String> errorcode;
	List<PropertyMaintenance> propertyManagement;
	Map<String, ArrayList<MenuProfileOptionLinking>> menuProfileList;
	Map<String, MenuProfileOptionLinking> menuIdList;
	private String getCurrentAcademicYear;
	List<TableMaintenance> tableMaintenances;
	List<BranchMaster> branchLists;
	List<SMSProperty> smsProperty;

	public List<BranchMaster> getBranchLists() {
		return branchLists;
	}

	public void setBranchLists(List<BranchMaster> list) {
		branchLists = list;
	}

	public Map<String, MenuProfileOptionLinking> getMenuIdList() {
		return menuIdList;
	}

	public void setMenuIdList(Map<String, MenuProfileOptionLinking> menuIdList) {
		this.menuIdList = menuIdList;
	}

	public Map<String, ArrayList<MenuProfileOptionLinking>> getMenuProfileList() {
		return menuProfileList;
	}

	public void setMenuProfileList(
			Map<String, ArrayList<MenuProfileOptionLinking>> menuProfileList) {
		this.menuProfileList = menuProfileList;
	}

	public String getGetCurrentAcademicYear() {
		return getCurrentAcademicYear;
	}

	public void setGetCurrentAcademicYear(String getCurrentAcademicYear) {
		this.getCurrentAcademicYear = getCurrentAcademicYear;
	}

	public List<TableMaintenance> getTableMaintenances() {
		return tableMaintenances;
	}

	public void setTableMaintenances(List<TableMaintenance> tableMaintenances) {
		this.tableMaintenances = tableMaintenances;
	}

	public void setCommoncode(List<CommonCode> commoncode) {
		this.commoncode = commoncode;
	}

	public List<CommonCode> getCommoncode() {
		return commoncode;
	}

	public Map<String, String> getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(Map<String, String> errorcode) {
		this.errorcode = errorcode;
	}

	public List<PropertyMaintenance> getPropertyManagement() {
		return propertyManagement;
	}

	public void setPropertyManagement(
			List<PropertyMaintenance> propertyManagement) {
		this.propertyManagement = propertyManagement;
	}

	public Map<String, String> getCommoncodeMap() {
		return commoncodeMap;
	}

	public void setCommoncodeMap(Map<String, String> commoncodeMap) {
		this.commoncodeMap = commoncodeMap;
	}

	public List<SMSProperty> getSmsProperty() {
		return smsProperty;
	}

	public void setSmsProperty(List<SMSProperty> smsProperty) {
		this.smsProperty = smsProperty;
	}

}
