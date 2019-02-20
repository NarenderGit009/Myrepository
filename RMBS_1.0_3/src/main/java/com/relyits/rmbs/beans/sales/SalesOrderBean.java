package com.relyits.rmbs.beans.sales;

import java.sql.Date;

import com.relyits.rmbs.beans.consumer.CustomerBean;
import com.relyits.rmbs.beans.consumer.PatientBean;
import com.relyits.rmbs.beans.registration.BranchBean;
import com.relyits.rmbs.beans.registration.DoctorBean;
import com.relyits.rmbs.beans.registration.OutletBean;
import com.relyits.rmbs.beans.resources.CategoryBean;
import com.relyits.rmbs.beans.resources.StatusBean;

public class SalesOrderBean {

	private Integer id;
	private Double amount;
	private CustomerBean customerBean;
	private Date billingDateAndTime;
	private BranchBean branchBean;
	private String orderIdByDate;
	private CategoryBean categoryBean;
	private StatusBean statusBean;
	private Double discountPrice;
	private OutletBean outletBean;
	private Double totalVAT;
	private DoctorBean doctorBean;
	private PatientBean patientBean;
	private Double margin;
	private Double payAmount;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public CustomerBean getCustomerBean() {
		return customerBean;
	}
	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
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
	
	public String getOrderIdByDate() {
		return orderIdByDate;
	}
	public void setOrderIdByDate(String orderIdByDate) {
		this.orderIdByDate = orderIdByDate;
	}
	public CategoryBean getCategoryBean() {
		return categoryBean;
	}
	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}
	public StatusBean getStatusBean() {
		return statusBean;
	}
	public void setStatusBean(StatusBean statusBean) {
		this.statusBean = statusBean;
	}
	public Double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public OutletBean getOutletBean() {
		return outletBean;
	}
	public void setOutletBean(OutletBean outletBean) {
		this.outletBean = outletBean;
	}
	public Double getTotalVAT() {
		return totalVAT;
	}
	public void setTotalVAT(Double totalVAT) {
		this.totalVAT = totalVAT;
	}
	public DoctorBean getDoctorBean() {
		return doctorBean;
	}
	public void setDoctorBean(DoctorBean doctorBean) {
		this.doctorBean = doctorBean;
	}
	public PatientBean getPatientBean() {
		return patientBean;
	}
	public void setPatientBean(PatientBean patientBean) {
		this.patientBean = patientBean;
	}
	public Double getMargin() {
		return margin;
	}
	public void setMargin(Double margin) {
		this.margin = margin;
	}
	public Double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
	
	
}
