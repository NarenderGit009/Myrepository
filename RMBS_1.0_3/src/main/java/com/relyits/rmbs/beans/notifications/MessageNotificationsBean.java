package com.relyits.rmbs.beans.notifications;

import java.sql.Date;

import com.relyits.rmbs.beans.resources.CategoryBean;
import com.relyits.rmbs.beans.resources.RoleBean;
import com.relyits.rmbs.beans.resources.StatusBean;



public class MessageNotificationsBean {

	
	private Integer id;
	private String message;
	private Date createdDate;
	private CategoryBean categoryBean;
	private Integer createdBy;
	private RoleBean creatorRoleBean;
	private Integer responsibility;
	private RoleBean responsibleRoleBean;
	private StatusBean statusBean;
	private String creatorName;
	private String responserName;
	
	
	
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
	public CategoryBean getCategoryBean() {
		return categoryBean;
	}
	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}
	
	public RoleBean getCreatorRoleBean() {
		return creatorRoleBean;
	}
	public void setCreatorRoleBean(RoleBean creatorRoleBean) {
		this.creatorRoleBean = creatorRoleBean;
	}
	public RoleBean getResponsibleRoleBean() {
		return responsibleRoleBean;
	}
	public void setResponsibleRoleBean(RoleBean responsibleRoleBean) {
		this.responsibleRoleBean = responsibleRoleBean;
	}
	
	
	public StatusBean getStatusBean() {
		return statusBean;
	}
	public void setStatusBean(StatusBean statusBean) {
		this.statusBean = statusBean;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public String getResponserName() {
		return responserName;
	}
	public void setResponserName(String responserName) {
		this.responserName = responserName;
	}
	
    
	
	
	
	
	
}
