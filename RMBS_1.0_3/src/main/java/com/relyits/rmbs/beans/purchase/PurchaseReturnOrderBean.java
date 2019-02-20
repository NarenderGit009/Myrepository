package com.relyits.rmbs.beans.purchase;

import java.sql.Date;

import com.relyits.rmbs.beans.registration.AgencyBean;
import com.relyits.rmbs.beans.registration.BranchBean;
import com.relyits.rmbs.beans.resources.ReasonBean;


public class PurchaseReturnOrderBean {
	
	private Integer id;
	private Double amount;
	private AgencyBean agencyBean;
	private Date billingDateAndTime;
	private Date deliveryDate;
	private BranchBean branchBean;
	private String orderIdByDate;
//	private StatusBean statusBean;
	private Double discountPrice;
//	private OutletBean outletBean;
	private Double totalVAT;
//	private DoctorBean doctorBean;
//	private PatientBean patientBean;
	private String invoiceNo;
	private ReasonBean reasonBean;
	private Double deductionOnPaidAmount;
	
	
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
	public AgencyBean getAgencyBean() {
		return agencyBean;
	}
	public void setAgencyBean(AgencyBean agencyBean) {
		this.agencyBean = agencyBean;
	}
	public Date getBillingDateAndTime() {
		return billingDateAndTime;
	}
	public void setBillingDateAndTime(Date billingDateAndTime) {
		this.billingDateAndTime = billingDateAndTime;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
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
/*	public StatusBean getStatusBean() {
		return statusBean;
	}
	public void setStatusBean(StatusBean statusBean) {
		this.statusBean = statusBean;
	}*/
	public Double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}
/*	public OutletBean getOutletBean() {
		return outletBean;
	}
	public void setOutletBean(OutletBean outletBean) {
		this.outletBean = outletBean;
	}*/
	public Double getTotalVAT() {
		return totalVAT;
	}
	public void setTotalVAT(Double totalVAT) {
		this.totalVAT = totalVAT;
	}
/*	public DoctorBean getDoctorBean() {
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
	}*/
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public ReasonBean getReasonBean() {
		return reasonBean;
	}
	public void setReasonBean(ReasonBean reasonBean) {
		this.reasonBean = reasonBean;
	}
	public Double getDeductionOnPaidAmount() {
		return deductionOnPaidAmount;
	}
	public void setDeductionOnPaidAmount(Double deductionOnPaidAmount) {
		this.deductionOnPaidAmount = deductionOnPaidAmount;
	}
	
	
	
	

}
