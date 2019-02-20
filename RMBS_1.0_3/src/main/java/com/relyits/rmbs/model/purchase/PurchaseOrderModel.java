package com.relyits.rmbs.model.purchase;

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

import com.relyits.rmbs.model.registration.AgencyModel;
import com.relyits.rmbs.model.registration.BranchModel;

@Entity
@Table(name="RMBS401", 
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS40101"), //id
		           @UniqueConstraint(columnNames = "RMBS40105"),   //orderIdbyDate
                   @UniqueConstraint(columnNames = "RMBS40108")})  // invoiceNo
public class PurchaseOrderModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS40101", unique = true, nullable = false)
	private Integer id;
		
	@Column(name = "RMBS40102", nullable = false, length = 100)
	private Double amount;
	
	@OneToOne
	@JoinColumn(name = "AG_RMBS10401", nullable = false)
	private AgencyModel agencyModel;
		
	@Column(name = "RMBS40103", nullable = false, length = 50)
	private Date billingDateAndTime;
	
	@Column(name = "RMBS40104", nullable = false, length = 50)
	private Date deliveryDate;
	
	@OneToOne
	@JoinColumn(name = "BR_RMBS10201", nullable = false)
	private BranchModel branchModel;
	
	@Column(name = "RMBS40105", unique = true, nullable = false, length = 50)
	private String orderIdByDate;
		
/*	@OneToOne
	@JoinColumn(name = "ST_RMBS80301", nullable = false)
	private StatusModel statusModel;*/
	
	@Column(name = "RMBS40106", nullable = false, length = 50)
	private Double discountPrice;
	
/*	@OneToOne
	@JoinColumn(name = "OL_RMBS10301", nullable = false)
	private OutletModel outletModel;*/
	
	@Column(name = "RMBS40107", nullable = false, length = 50)
	private Double totalVAT;
	
/*	@OneToOne
	@JoinColumn(name = "DR_RMBS10501", nullable = false)
	private DoctorModel doctorModel;
	
	@OneToOne
	@JoinColumn(name = "PT_RMBS60201", nullable = false)
	private PatientModel patientModel;*/
	
	@Column(name = "RMBS40108", unique = true, nullable = false, length = 50)
	private String invoiceNo;
	
	@Column(name = "RMBS40109", nullable = false, length = 50)
	private Double payAmount;

	@Column(name = "RMBS40110", nullable = false, length = 50)
	private Double overallDiscount;

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

	public AgencyModel getAgencyModel() {
		return agencyModel;
	}

	public void setAgencyModel(AgencyModel agencyModel) {
		this.agencyModel = agencyModel;
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

	public BranchModel getBranchModel() {
		return branchModel;
	}

	public void setBranchModel(BranchModel branchModel) {
		this.branchModel = branchModel;
	}

	public String getOrderIdbyDate() {
		return orderIdByDate;
	}

	public void setOrderIdByDate(String orderIdByDate) {
		this.orderIdByDate = orderIdByDate;
	}

/*	public StatusModel getStatusModel() {
		return statusModel;
	}

	public void setStatusModel(StatusModel statusModel) {
		this.statusModel = statusModel;
	}*/

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

/*	public OutletModel getOutletModel() {
		return outletModel;
	}

	public void setOutletModel(OutletModel outletModel) {
		this.outletModel = outletModel;
	}*/

	public Double getTotalVAT() {
		return totalVAT;
	}

	public void setTotalVAT(Double totalVAT) {
		this.totalVAT = totalVAT;
	}

/*	public DoctorModel getDoctorModel() {
		return doctorModel;
	}

	public void setDoctorModel(DoctorModel doctorModel) {
		this.doctorModel = doctorModel;
	}

	public PatientModel getPatientModel() {
		return patientModel;
	}

	public void setPatientModel(PatientModel patientModel) {
		this.patientModel = patientModel;
	}
*/
	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Double getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(Double payAmount) {
		this.payAmount = payAmount;
	}

	public Double getOverallDiscount() {
		return overallDiscount;
	}

	public void setOverallDiscount(Double overallDiscount) {
		this.overallDiscount = overallDiscount;
	}


	

}
