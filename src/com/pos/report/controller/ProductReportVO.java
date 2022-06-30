package com.pos.report.controller;

import java.util.Arrays;

public class ProductReportVO {

	private String[] refundAmount;
	private String[] refundReason;
	public String[] getRefundAmount() {
		return refundAmount;
	}
	public void setRefundAmount(String[] refundAmount) {
		this.refundAmount = refundAmount;
	}
	public String[] getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(String[] refundReason) {
		this.refundReason = refundReason;
	}
	@Override
	public String toString() {
		return "ProductReportVO [refundAmount=" + Arrays.toString(refundAmount) + ", refundReason="
				+ Arrays.toString(refundReason) + ", getRefundAmount()=" + Arrays.toString(getRefundAmount())
				+ ", getRefundReason()=" + Arrays.toString(getRefundReason()) + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
