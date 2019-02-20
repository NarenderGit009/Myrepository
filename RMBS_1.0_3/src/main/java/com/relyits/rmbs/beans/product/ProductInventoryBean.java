package com.relyits.rmbs.beans.product;

import java.sql.Date;

import com.relyits.rmbs.beans.registration.AgencyBean;
import com.relyits.rmbs.beans.registration.BranchBean;
import com.relyits.rmbs.beans.resources.RoleBean;



public class ProductInventoryBean {

	private Integer id;
	private ProductBean productBean;
	private Integer quantity;
	private Integer quantityPerStrip;
	private Integer noOfstrips;
	private BranchBean branchBean;
	private RoleBean creatorRoleBean;
	private Integer createdBy;
	private String expiryDate;
	private String batchNo;
	private Double price;
	private Double vat;
	private Double pwVat;
	private Double vatPrice;
	private Double dlPrice;
	private Double dlPricePerstrip;
	private Double pricePerStrip;
	private AgencyBean agencyBean;
	private Date createdDate;
	private Date updatedDate;
	private String message;
	private Long expiryDays;
	private Integer freeQuantity;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Integer getQuantityPerStrip() {
		return quantityPerStrip;
	}
	public void setQuantityPerStrip(Integer quantityPerStrip) {
		this.quantityPerStrip = quantityPerStrip;
	}
	public Integer getNoOfstrips() {
		return noOfstrips;
	}
	public void setNoOfstrips(Integer noOfstrips) {
		this.noOfstrips = noOfstrips;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
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
	public Double getDlPricePerstrip() {
		return dlPricePerstrip;
	}
	public void setDlPricePerstrip(Double dlPricePerstrip) {
		this.dlPricePerstrip = dlPricePerstrip;
	}
	public Double getPricePerStrip() {
		return pricePerStrip;
	}
	public void setPricePerStrip(Double pricePerStrip) {
		this.pricePerStrip = pricePerStrip;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		updatedDate = updatedDate;
	}
	public ProductBean getProductBean() {
		return productBean;
	}
	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	public BranchBean getBranchBean() {
		return branchBean;
	}
	public void setBranchBean(BranchBean branchBean) {
		this.branchBean = branchBean;
	}
	public RoleBean getCreatorRoleBean() {
		return creatorRoleBean;
	}
	public void setCreatorRoleBean(RoleBean creatorRoleBean) {
		this.creatorRoleBean = creatorRoleBean;
	}
	public AgencyBean getAgencyBean() {
		return agencyBean;
	}
	public void setAgencyBean(AgencyBean agencyBean) {
		this.agencyBean = agencyBean;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getExpiryDays() {
		return expiryDays;
	}
	public void setExpiryDays(Long expiryDays) {
		this.expiryDays = expiryDays;
	}
	public Integer getFreeQuantity() {
		return freeQuantity;
	}
	public void setFreeQuantity(Integer freeQuantity) {
		this.freeQuantity = freeQuantity;
	}
	
	
	
}
