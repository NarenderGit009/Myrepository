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
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.DoctorModel;
import com.relyits.rmbs.model.registration.OutletModel;

@Entity
@Table(name="RMBS301", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS30101"),  //id
		           @UniqueConstraint(columnNames = "RMBS30104")})   //orderIdbyDate
public class SalesOrderModel implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS30101", unique = true, nullable = false)
	private Integer id;
		
	@Column(name = "RMBS30102", nullable = false, length = 100)
	private Double amount;
	
	@OneToOne
	@JoinColumn(name = "CST_RMBS60101", nullable = true)
	private CustomerModel customerModel;
		
	@Column(name = "RMBS30103", nullable = false, length = 50)
	private Date billingDateAndTime;
	
	@OneToOne
	@JoinColumn(name = "BR_RMBS10201", nullable = false)
	private BranchModel branchModel;
	
	@Column(name = "RMBS30104", unique = true, nullable = false, length = 50)
	private String orderIdByDate;
	
	@OneToOne
	@JoinColumn(name = "CT_RMBS80401", nullable = false)
	private CategoryModel categoryModel;
	
	@OneToOne
	@JoinColumn(name = "ST_RMBS80301", nullable = false)
	private StatusModel statusModel;
	
	@Column(name = "RMBS30105", nullable = false, length = 50)
	private Double discountPrice;
	
	@OneToOne
	@JoinColumn(name = "OL_RMBS10301", nullable = false)
	private OutletModel outletModel;
	
	@Column(name = "RMBS30106", nullable = false, length = 50)
	private Double totalVAT;
	
	@OneToOne
	@JoinColumn(name = "DR_RMBS10501", nullable = true)
	private DoctorModel doctorModel;
	
/*	@OneToOne
	@JoinColumn(name = "PT_RMBS60201", nullable = true)
	private PatientModel patientModel;
*/	
	@Column(name = "RMBS30107", nullable = false, length = 50)
	private Double margin;

	@Column(name = "RMBS30108", nullable = false, length = 50)
	private Double overallDiscount;
	
	@Column(name = "RMBS30109", nullable = false, length = 100)
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

	public CategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
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
	public Double getMargin() {
		return margin;
	}

	public void setMargin(Double margin) {
		this.margin = margin;
	}

	public Double getOverallDiscount() {
		return overallDiscount;
	}

	public void setOverallDiscount(Double overallDiscount) {
		this.overallDiscount = overallDiscount;
	}

	public Double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}
	
	

}
