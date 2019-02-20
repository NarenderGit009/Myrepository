package com.relyits.rmbs.beans.registration;

import com.relyits.rmbs.beans.resources.AddressBean;
import com.relyits.rmbs.beans.resources.RoleBean;
import com.relyits.rmbs.beans.resources.StatusBean;


public class ResourceBean {
	
	private Integer id;
	private StatusBean accountStatusBean;
	private StatusBean loginStatusBean;
	private RoleBean roleBean;
	private AddressBean addressBean;
//	private MenuBean menuBean;
	private RoleBean CreatorRoleBean;  
	private Integer createdBy;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public StatusBean getAccountStatusBean() {
		return accountStatusBean;
	}
	public void setAccountStatusBean(StatusBean accountStatusBean) {
		this.accountStatusBean = accountStatusBean;
	}
	public StatusBean getLoginStatusBean() {
		return loginStatusBean;
	}
	public void setLoginStatusBean(StatusBean loginStatusBean) {
		this.loginStatusBean = loginStatusBean;
	}
	public RoleBean getRoleBean() {
		return roleBean;
	}
	public void setRoleBean(RoleBean roleBean) {
		this.roleBean = roleBean;
	}
	public AddressBean getAddressBean() {
		return addressBean;
	}
	public void setAddressBean(AddressBean addressBean) {
		this.addressBean = addressBean;
	}
	public RoleBean getCreatorRoleBean() {
		return CreatorRoleBean;
	}
	public void setCreatorRoleBean(RoleBean creatorRoleBean) {
		CreatorRoleBean = creatorRoleBean;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	

	

}
