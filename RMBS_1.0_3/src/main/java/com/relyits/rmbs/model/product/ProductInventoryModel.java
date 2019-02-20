package com.relyits.rmbs.model.product;

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

import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.registration.AgencyModel;
import com.relyits.rmbs.model.registration.BranchModel;

@Entity
@Table(name="RMBS202", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS20201"),   //id
		           @UniqueConstraint(columnNames = {"RMBS20205","BR_RMBS10201","AG_RMBS10401"})})  // batchNo
public class ProductInventoryModel implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS20201", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "P_RMBS20101", nullable = false)
	private ProductModel productModel;
	
	@Column(name = "RMBS20202", nullable = false, length = 50)
	private Integer quantity;
	
	@OneToOne
	@JoinColumn(name = "BR_RMBS10201", nullable = false)
	private BranchModel branchModel;
	
	@OneToOne
	@JoinColumn(name = "CRL_RMBS70201", nullable = false)
	private RoleModel creatorRoleModel;
	
	@Column(name = "RMBS20203", nullable = false, length = 25)
	private Integer createdBy;
	
	@Column(name = "RMBS20204", nullable = false, length = 25)
	private Date expiryDate;
	
	@Column(name = "RMBS20205", unique = true, nullable = false, length = 100)
	private String batchNo;
	
	@Column(name = "RMBS20206", nullable = false, length = 50)
	private Double price;
	
	@Column(name = "RMBS20207", nullable = false, length = 100)
	private Double vat;
	
	@Column(name = "RMBS20208", nullable = false, length = 100)
	private Double pwVat;
	
	@Column(name = "RMBS20209", nullable = false, length = 100)
	private Double vatPrice;
	
	@Column(name = "RMBS20210", nullable = false, length = 100)
	private Double dlPrice;
	
	@OneToOne
	@JoinColumn(name = "AG_RMBS10401", nullable = false)
	private AgencyModel agencyModel;
	
	@Column(name = "RMBS20211", nullable = false, length = 100)
	private Date createdDate;
	
	@Column(name = "RMBS20212", nullable = false, length = 100)
	private Date updatedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductModel getProductModel() {
		return productModel;
	}

	public void setProductModel(ProductModel productModel) {
		this.productModel = productModel;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BranchModel getBranchModel() {
		return branchModel;
	}

	public void setBranchModel(BranchModel branchModel) {
		this.branchModel = branchModel;
	}

	

	public RoleModel getCreatorRoleModel() {
		return creatorRoleModel;
	}

	public void setCreatorRoleModel(RoleModel creatorRoleModel) {
		this.creatorRoleModel = creatorRoleModel;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getVat() {
		return vat;
	}

	public void setVat(Double vat) {
		this.vat = vat;
	}

	
	public Double getPwVat() {
		return pwVat;
	}

	public void setPwVat(Double pwVat) {
		this.pwVat = pwVat;
	}

	public Double getVatPrice() {
		return vatPrice;
	}

	public void setVatPrice(Double vatPrice) {
		this.vatPrice = vatPrice;
	}

	public Double getDlPrice() {
		return dlPrice;
	}

	public void setDlPrice(Double dlPrice) {
		this.dlPrice = dlPrice;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public AgencyModel getAgencyModel() {
		return agencyModel;
	}

	public void setAgencyModel(AgencyModel agencyModel) {
		this.agencyModel = agencyModel;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	
	
	
	

}
