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
@Table(name="RMBS102", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS10201"),   //id
		           @UniqueConstraint(columnNames = "RMBS10202")})  // userName
		           
public class BranchModel implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS10201", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RMBS10202", unique = true, nullable = false, length = 100)
	private String userName;
	
	@Column(name = "RMBS10203", nullable = false, length = 25)
	private String initial;
	
	@Column(name = "RMBS10204", nullable = false, length = 25)
	private String gender;
 
	@Column(name = "RMBS10205", nullable = false, length = 100)
	private String firstName;
	
	@Column(name = "RMBS10206", nullable = false, length = 100)
	private String lastName;
	
	@Column(name = "RMBS10207", nullable = false, length = 50)
	private String password;
	
	@Column(name = "RMBS10208", nullable = false, length = 50)
	private Date dob;
	
	@Column(name = "RMBS10209", nullable = false, length = 100)
	private String name;
	
	@Column(name = "RMBS10210", columnDefinition = "varchar(50) default 'null'")
	private String tinNo;
	
	@OneToOne
	@JoinColumn(name = "ORG_RMBS10101", nullable = false)
	private OrganizationModel organizationModel;
	
	@Column(name = "RMBS10211", nullable = false, length = 50)
	private Date registeredDateTime;
	
	@Column(name = "RMBS10212", nullable = false, length = 50)
	private Date lastLoginedDateTime;
	
	@Column(name = "RMBS10213", nullable = false, length = 50)
	private Date updatedDateTime;
	
	@Column(name = "RMBS10214", nullable = false, length = 50)
	private Integer daysCount;
	
	@Column(name = "RMBS10215", nullable = false, length = 50)
	private Integer noOfOutlets;
	
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

	public OrganizationModel getOrganizationModel() {
		return organizationModel;
	}

	public void setOrganizationModel(OrganizationModel organizationModel) {
		this.organizationModel = organizationModel;
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

	public Integer getNoOfOutlets() {
		return noOfOutlets;
	}

	public void setNoOfOutlets(Integer noOfOutlets) {
		this.noOfOutlets = noOfOutlets;
	}

	public ResourceModel getResourceModel() {
		return resourceModel;
	}

	public void setResourceModel(ResourceModel resourceModel) {
		this.resourceModel = resourceModel;
	}

	
}
