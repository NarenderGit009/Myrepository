package com.relyits.rmbs.beans.purchase;

import com.relyits.rmbs.beans.registration.OutletBean;

public class PurchaseReportBean {

	private OutletBean outletBean;
	private String initial;
	private String fromDate;
	private String toDate;
	public OutletBean getOutletBean() {
		return outletBean;
	}

	public void setOutletBean(OutletBean outletBean) {
		this.outletBean = outletBean;
	}

	public String getInitial() {
		return initial;
	}

	public void setInitial(String initial) {
		this.initial = initial;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	
}
