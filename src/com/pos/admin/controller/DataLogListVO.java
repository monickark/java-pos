package com.pos.admin.controller;
import java.io.Serializable;
public class DataLogListVO implements Serializable{	
	private String instId = "";
	private String branchId = "";
	private String rowid = "";	
	private String pageNo = "";
	private String auditSrlNo ="";	
	private String tableName ="";	
	private String userId ="";
	private String linkId ="";
	private String rCreTime ="";
	private String typeOfOperation ="";
	
	public String getInstId() {
		return instId;
	}	
	public void setInstId(String instId) {
		this.instId = instId;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}		
	public String getRowid() {
		return rowid;
	}
	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	public String getPageNo() {
		return pageNo;
	}
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}	
	public String getAuditSrlNo() {
		return auditSrlNo;
	}
	public void setAuditSrlNo(String auditSrlNo) {
		this.auditSrlNo = auditSrlNo;
	}	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLinkId() {
		return linkId;
	}
	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}
	public String getrCreTime() {
		return rCreTime;
	}
	public void setrCreTime(String rCreTime) {
		this.rCreTime = rCreTime;
	}
	public String getTypeOfOperation() {
		return typeOfOperation;
	}
	public void setTypeOfOperation(String typeOfOperation) {
		this.typeOfOperation = typeOfOperation;
	}
	

}
