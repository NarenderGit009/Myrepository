package com.relyits.rmbs.model.registration;

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

@Entity
@Table(name="RMBS101", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS10101"),  //id
		           @UniqueConstraint(columnNames = "RMBS10102") // userName
		         /*  @UniqueConstraint(columnNames = "RMBS10117")*/}) //licenseKey
public class OrganizationModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS10101", unique = true)
	private Integer id;
	
	@Column(name = "RMBS10102", unique = true, nullable = false, length = 100)
	private String userName;
	
	@Column(name = "RMBS10103", nullable = false, length = 25)
	private String initial;
	
	@Column(name = "RMBS10104", nullable = false, length = 25)
	private String gender;
 
	@Column(name = "RMBS10105", nullable = false, length = 100)
	private String firstName;
	
	@Column(name = "RMBS10106", nullable = false, length = 100)
	private String lastName;
	
	@Column(name = "RMBS10107", nullable = false, length = 50)
	private String password;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RMBS10108", nullable = false, length = 50, columnDefinition="default CURRENT_TIMESTAMP")
	private Date dob;
	
	@Column(name = "RMBS10109", nullable = false, length = 100)
	private String name;
	
	@Column(name = "RMBS10110", columnDefinition = "varchar(50) default 'Not Available'")
	private String tinNo;
	
	@Column(name = "RMBS10111", length = 50, columnDefinition="default CURRENT_TIMESTAMP")
	private Date registeredDateTime;

	@Column(name = "RMBS10112",  length = 50, columnDefinition="default CURRENT_TIMESTAMP")
	private Date lastLoginedDateTime;
	
	@Column(name = "RMBS10113", length = 50, columnDefinition="default CURRENT_TIMESTAMP")
	private Date updatedDateTime;
/*	
	@Column(name = "RMBS10114", nullable = false, length = 50)
	private Integer daysCount;
	
	@Column(name = "RMBS10115", nullable = false, length = 50)
	private Integer expiryDays;
	
	@Column(name = "RMBS10116", nullable = false, length = 50)
	private Integer licenseValidDays;
	
	@Column(name = "RMBS10117", unique = true, nullable = false, length = 100)
	private String licenseKey;
*/	
	@OneToOne
	@JoinColumn(name = "RS_RMBS10601", nullable = false)
	private ResourceModel resourceModel;
/*	
	@Column(name = "RMBS10118", nullable = false, columnDefinition = "int(15) default 0")
	private Integer noOfBranches;
*/
	@Column(name = "RMBS10119")
	private String imagePath;
	
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTinNo() {
		return tinNo;
	}

	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
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
/*
	public Integer getDaysCount() {
		return daysCount;
	}

	public void setDaysCount(Integer daysCount) {
		this.daysCount = daysCount;
	}

	public Integer getExpiryDays() {
		return expiryDays;
	}

	public void setExpiryDays(Integer expiryDays) {
		this.expiryDays = expiryDays;
	}

	public Integer getLicenseValidDays() {
		return licenseValidDays;
	}

	public void setLicenseValidDays(Integer licenseValidDays) {
		this.licenseValidDays = licenseValidDays;
	}

	public String getLicenseKey() {
		return licenseKey;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}
*/
	public ResourceModel getResourceModel() {
		return resourceModel;
	}

	public void setResourceModel(ResourceModel resourceModel) {
		this.resourceModel = resourceModel;
	}
/*
	public Integer getNoOfBranches() {
		return noOfBranches;
	}

	public void setNoOfBranches(Integer noOfBranches) {
		this.noOfBranches = noOfBranches;
	}
	
	*/

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
