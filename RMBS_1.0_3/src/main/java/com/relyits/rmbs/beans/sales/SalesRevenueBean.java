package com.relyits.rmbs.beans.sales;

import java.sql.Date;

import com.relyits.rmbs.beans.registration.BranchBean;
import com.relyits.rmbs.beans.registration.OutletBean;
import com.relyits.rmbs.beans.resources.CategoryBean;

public class SalesRevenueBean {

	private Integer id;
	private Date billingDateAndTime;
	private BranchBean branchBean;
	private String orderIdbyDate;
	private CategoryBean categoryBean;
	private OutletBean outletBean;
	private String rA;
	private String fromDate;
	private String toDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getBillingDateAndTime() {
		return billingDateAndTime;
	}
	public void setBillingDateAndTime(Date billingDateAndTime) {
		this.billingDateAndTime = billingDateAndTime;
	}
	public BranchBean getBranchBean() {
		return branchBean;
	}
	public void setBranchBean(BranchBean branchBean) {
		this.branchBean = branchBean;
	}
	public String getOrderIdbyDate() {
		return orderIdbyDate;
	}
	public void setOrderIdbyDate(String orderIdbyDate) {
		this.orderIdbyDate = orderIdbyDate;
	}
	public CategoryBean getCategoryBean() {
		return categoryBean;
	}
	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}
	public OutletBean getOutletBean() {
		return outletBean;
	}
	public void setOutletBean(OutletBean outletBean) {
		this.outletBean = outletBean;
	}
	public String getrA() {
		return rA;
	}
	public void setrA(String rA) {
		this.rA = rA;
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
