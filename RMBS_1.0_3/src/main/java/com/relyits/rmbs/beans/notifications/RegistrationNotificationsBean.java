package com.relyits.rmbs.beans.notifications;

import java.sql.Date;




public class RegistrationNotificationsBean {
	
	
	private Integer id;
	private String message;
	private Integer noOfRemainingDays;
	private Integer noOfUsedDays;
	private Date createdDate;
//	private CategoryBean categoryBean;
	private Integer responsibility;
//	private RoleBean roleBean;
//	private StatusBean statusBean;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getNoOfRemainingDays() {
		return noOfRemainingDays;
	}
	public void setNoOfRemainingDays(Integer noOfRemainingDays) {
		this.noOfRemainingDays = noOfRemainingDays;
	}
	public Integer getNoOfUsedDays() {
		return noOfUsedDays;
	}
	public void setNoOfUsedDays(Integer noOfUsedDays) {
		this.noOfUsedDays = noOfUsedDays;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(Integer responsibility) {
		this.responsibility = responsibility;
	}
/*	public CategoryBean getCategoryBean() {
		return categoryBean;
	}
	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}
	public RoleBean getRoleBean() {
		return roleBean;
	}
	public void setRoleBean(RoleBean roleBean) {
		this.roleBean = roleBean;
	}
	public StatusBean getStatusBean() {
		return statusBean;
	}
	public void setStatusBean(StatusBean statusBean) {
		this.statusBean = statusBean;
	}
    
	*/
	
	
	

}
