package com.relyits.rmbs.beans.notifications;

import java.sql.Date;


public class MailNotificationsBean {
	
	private Integer id;
	private String message;
	private Date createdDate;
//	private CategoryBean categoryBean;
	private Integer createdBy;
//	private RoleBean roleBean;
	private Integer responsibility;
//	private RoleBean roleBean1;
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
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
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
	public RoleBean getRoleBean1() {
		return roleBean1;
	}
	public void setRoleBean1(RoleBean roleBean1) {
		this.roleBean1 = roleBean1;
	}
	public StatusBean getStatusBean() {
		return statusBean;
	}
	public void setStatusBean(StatusBean statusBean) {
		this.statusBean = statusBean;
	}

	*/
	

}
