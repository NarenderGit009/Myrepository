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
@Table(name="RMBS103", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS10301"),   //id
		           @UniqueConstraint(columnNames = "RMBS10302")})  // userName
public class OutletModel implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS10301", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RMBS10302", unique = true, nullable = false, length = 100)
	private String userName;
	
	@Column(name = "RMBS10303", nullable = false, length = 25)
	private String initial;
	
	@Column(name = "RMBS10304", nullable = false, length = 25)
	private String gender;
 
	@Column(name = "RMBS10305", nullable = false, length = 100)
	private String firstName;
	
	@Column(name = "RMBS10306", nullable = false, length = 100)
	private String lastName;
	
	@Column(name = "RMBS10307", nullable = false, length = 50)
	private String password;
	
	@Column(name = "RMBS10308", nullable = false, length = 50)
	private Date dob;
	
	@OneToOne
	@JoinColumn(name = "BR_RMBS10201", nullable = false)
	private BranchModel branchModel;
	
	@Column(name = "RMBS10309", nullable = false, length = 50)
	private Date registeredDateTime;
	
	@Column(name = "RMBS10310", nullable = false, length = 50)
	private Date lastLoginedDateTime;
	
	@Column(name = "RMBS10311", nullable = false, length = 50)
	private Date updatedDateTime;
	
	@Column(name = "RMBS10312", nullable = false, length = 50)
	private Integer daysCount;
    
	@OneToOne
	@JoinColumn(name = "RS_RMBS10601", nullable = false)
	private ResourceModel resourceModel;

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

	public BranchModel getBranchModel() {
		return branchModel;
	}

	public void setBranchModel(BranchModel branchModel) {
		this.branchModel = branchModel;
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

	public ResourceModel getResourceModel() {
		return resourceModel;
	}

	public void setResourceModel(ResourceModel resourceModel) {
		this.resourceModel = resourceModel;
	}
	
	
}
