package com.relyits.rmbs.beans.sales;

import java.sql.Date;

import com.relyits.rmbs.beans.consumer.CustomerBean;
import com.relyits.rmbs.beans.consumer.PatientBean;
import com.relyits.rmbs.beans.registration.BranchBean;
import com.relyits.rmbs.beans.registration.DoctorBean;
import com.relyits.rmbs.beans.registration.OutletBean;
import com.relyits.rmbs.beans.resources.ReasonBean;
import com.relyits.rmbs.beans.resources.StatusBean;


public class SalesReturnOrderBean {
	
	private Integer id;
	private Double amount;
	private CustomerBean customerBean;
	private Date billingDateAndTime;
	private BranchBean branchBean;
	private String orderIdbyDate;
	private StatusBean statusBean;
	private Double discountPrice;
	private OutletBean outletBean;
	private Double totalVAT;
	private DoctorBean doctorBean;
	private PatientBean patientBean;
	private ReasonBean reasonBean;
	private Double deductionOnMargin;
	private SalesOrderBean salesOrderBean;
	
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
	public String getOrderIdbyDate() {
		return orderIdbyDate;
	}
	public void setOrderIdbyDate(String orderIdbyDate) {
		this.orderIdbyDate = orderIdbyDate;
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
	public ReasonBean getReasonBean() {
		return reasonBean;
	}
	public void setReasonBean(ReasonBean reasonBean) {
		this.reasonBean = reasonBean;
	}
	public Double getDeductionOnMargin() {
		return deductionOnMargin;
	}
	public void setDeductionOnMargin(Double deductionOnMargin) {
		this.deductionOnMargin = deductionOnMargin;
	}
	public SalesOrderBean getSalesOrderBean() {
		return salesOrderBean;
	}
	public void setSalesOrderBean(SalesOrderBean salesOrderBean) {
		this.salesOrderBean = salesOrderBean;
	}
	
	
	
	

}
