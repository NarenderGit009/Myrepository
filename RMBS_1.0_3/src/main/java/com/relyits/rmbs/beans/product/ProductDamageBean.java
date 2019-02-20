package com.relyits.rmbs.beans.product;

import java.sql.Date;

import com.relyits.rmbs.beans.registration.AgencyBean;
import com.relyits.rmbs.beans.resources.ReasonBean;
import com.relyits.rmbs.beans.resources.RoleBean;



public class ProductDamageBean {
	
	private Integer id;
	private AgencyBean agencyBean;
	private Integer quantity;
	private Date damagedDate;
	private ReasonBean reasonBean;
	private ProductInventoryBean productInventoryBean;
	private Integer creator;
	private RoleBean creatorRoleBean;
	private String creatorName;
	
	
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
	public Date getDamagedDate() {
		return damagedDate;
	}
	public void setDamagedDate(Date damagedDate) {
		this.damagedDate = damagedDate;
	}
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	public AgencyBean getAgencyBean() {
		return agencyBean;
	}
	public void setAgencyBean(AgencyBean agencyBean) {
		this.agencyBean = agencyBean;
	}
	public ReasonBean getReasonBean() {
		return reasonBean;
	}
	public void setReasonBean(ReasonBean reasonBean) {
		this.reasonBean = reasonBean;
	}
	public ProductInventoryBean getProductInventoryBean() {
		return productInventoryBean;
	}
	public void setProductInventoryBean(ProductInventoryBean productInventoryBean) {
		this.productInventoryBean = productInventoryBean;
	}
	public RoleBean getCreatorRoleBean() {
		return creatorRoleBean;
	}
	public void setCreatorRoleBean(RoleBean creatorRoleBean) {
		this.creatorRoleBean = creatorRoleBean;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	
    
	
	

}
