package com.relyits.rmbs.model.sales;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.relyits.rmbs.model.consumer.CustomerModel;
import com.relyits.rmbs.model.consumer.PatientModel;
import com.relyits.rmbs.model.refference.ReasonModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.DoctorModel;
import com.relyits.rmbs.model.registration.OutletModel;

@Entity
@Table(name="RMBS303", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS30301"),     //id
		           @UniqueConstraint(columnNames = "RMBS30304")})   //orderIdbyDate  
public class SalesReturnOrderModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS30301", unique = true, nullable = false)
	private Integer id;
		
	@Column(name = "RMBS30302", nullable = false, length = 100)
	private Double amount;
	
	@OneToOne
	@JoinColumn(name = "CST_RMBS60101", nullable = false)
	private CustomerModel customerModel;
		
	@Column(name = "RMBS30303", nullable = false, length = 50)
	private Date billingDateAndTime;
	
	@OneToOne
	@JoinColumn(name = "BR_RMBS10201", nullable = false)
	private BranchModel branchModel;

	@Column(name = "RMBS30304", unique = true, nullable = false, length = 50)
	private String orderIdByDate;
			
	@OneToOne
	@JoinColumn(name = "ST_RMBS80301", nullable = false)
	private StatusModel statusModel;
	
	@Column(name = "RMBS30305", nullable = false, length = 50)
	private Double discountPrice;
	
	@OneToOne
	@JoinColumn(name = "OL_RMBS10301", nullable = false)
	private OutletModel outletModel;
	
	@Column(name = "RMBS30306", nullable = false, length = 50)
	private Double totalVAT;
	
	@OneToOne
	@JoinColumn(name = "DR_RMBS10501", nullable = false)
	private DoctorModel doctorModel;
/*	
	@OneToOne
	@JoinColumn(name = "PT_RMBS60201", nullable = false)
	private PatientModel patientModel;
*/	
	@OneToOne
	@JoinColumn(name = "RS_RMBS80601", nullable = true)
	private ReasonModel reasonModel;
	
	@OneToOne
	@JoinColumn(name = "SO_RMBS30101", nullable = false)
	private SalesOrderModel salesOrderModel;
	
	@Column(name = "RMBS30307", nullable = false, length = 50)
	private Double deductionOnMargin;

	@Column(name = "RMBS30308", nullable = false, length = 100)
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

	public CustomerModel getCustomerModel() {
		return customerModel;
	}

	public void setCustomerModel(CustomerModel customerModel) {
		this.customerModel = customerModel;
	}

	public Date getBillingDateAndTime() {
		return billingDateAndTime;
	}

	public void setBillingDateAndTime(Date billingDateAndTime) {
		this.billingDateAndTime = billingDateAndTime;
	}

	public BranchModel getBranchModel() {
		return branchModel;
	}

	public void setBranchModel(BranchModel branchModel) {
		this.branchModel = branchModel;
	}

	public String getOrderIdByDate() {
		return orderIdByDate;
	}

	public void setOrderIdByDate(String orderIdByDate) {
		this.orderIdByDate = orderIdByDate;
	}

	public StatusModel getStatusModel() {
		return statusModel;
	}

	public void setStatusModel(StatusModel statusModel) {
		this.statusModel = statusModel;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public OutletModel getOutletModel() {
		return outletModel;
	}

	public void setOutletModel(OutletModel outletModel) {
		this.outletModel = outletModel;
	}

	public Double getTotalVAT() {
		return totalVAT;
	}

	public void setTotalVAT(Double totalVAT) {
		this.totalVAT = totalVAT;
	}

	public DoctorModel getDoctorModel() {
		return doctorModel;
	}

	public void setDoctorModel(DoctorModel doctorModel) {
		this.doctorModel = doctorModel;
	}
/*
	public PatientModel getPatientModel() {
		return patientModel;
	}

	public void setPatientModel(PatientModel patientModel) {
		this.patientModel = patientModel;
	}
*/
	public ReasonModel getReasonModel() {
		return reasonModel;
	}

	public void setReasonModel(ReasonModel reasonModel) {
		this.reasonModel = reasonModel;
	}

	public SalesOrderModel getSalesOrderModel() {
		return salesOrderModel;
	}

	public void setSalesOrderModel(SalesOrderModel salesOrderModel) {
		this.salesOrderModel = salesOrderModel;
	}

	public Double getDeductionOnMargin() {
		return deductionOnMargin;
	}

	public void setDeductionOnMargin(Double deductionOnMargin) {
		this.deductionOnMargin = deductionOnMargin;
	}

	public Double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
	



}
