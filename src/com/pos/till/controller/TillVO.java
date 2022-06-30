package com.pos.till.controller;

import java.io.Serializable;

public class TillVO implements Serializable{

	private String tillId;
	private String date;
	private double amount;
	private String description;
	private String status;
	private String total;
	public String getTillId() {
		return tillId;
	}
	public void setTillId(String tillId) {
		this.tillId = tillId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "TillVO [tillId=" + tillId + ", date=" + date + ", amount=" + amount + ", description=" + description
				+ ", status=" + status + ", total=" + total + ", getTillId()=" + getTillId() + ", getDate()="
				+ getDate() + ", getAmount()=" + getAmount() + ", getDescription()=" + getDescription()
				+ ", getStatus()=" + getStatus() + ", getTotal()=" + getTotal() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
