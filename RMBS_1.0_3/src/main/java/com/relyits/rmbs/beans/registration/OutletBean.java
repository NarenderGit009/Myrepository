package com.relyits.rmbs.beans.registration;

import java.sql.Date;


public class OutletBean {
	
	private Integer id;
	private String userName;
	private String initial;
	private String gender;
	private String firstName;
	private String lastName;
	private String password;
	private String confirmPassword;
	private String dob;
	private BranchBean branchBean;
	private Date registeredDateTime;
	private Date lastLoginedDateTime;
	private Date updatedDateTime;
	private Integer daysCount;
	private ResourceBean resourceBean;
	private OrganizationBean organizationBean;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getInitial() {
		return initial;
	}
	public void setInitial(String initial) {
		this.initial = initial;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public BranchBean getBranchBean() {
		return branchBean;
	}
	public void setBranchBean(BranchBean branchBean) {
		this.branchBean = branchBean;
	}
	public Date getRegisteredDateTime() {
		return registeredDateTime;
	}
	public void setRegisteredDateTime(Date registeredDateTime) {
		this.registeredDateTime = registeredDateTime;
	}
	public Date getLastLoginedDateTime() {
		return lastLoginedDateTime;
	}
	public void setLastLoginedDateTime(Date lastLoginedDateTime) {
		this.lastLoginedDateTime = lastLoginedDateTime;
	}
	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}
	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
	public Integer getDaysCount() {
		return daysCount;
	}
	public void setDaysCount(Integer daysCount) {
		this.daysCount = daysCount;
	}
	public ResourceBean getResourceBean() {
		return resourceBean;
	}
	public void setResourceBean(ResourceBean resourceBean) {
		this.resourceBean = resourceBean;
	}
	public OrganizationBean getOrganizationBean() {
		return organizationBean;
	}
	public void setOrganizationBean(OrganizationBean organizationBean) {
		this.organizationBean = organizationBean;
	}
	
	

}
