package com.relyits.rmbs.model.notifications;

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

import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;

@Entity
@Table(name="RMBS703", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS70301") })   //id
public class RegistrationNotificationsModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS70301", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RMBS70302", nullable = false, length = 100)
	private String message;
	
	@Column(name = "RMBS70303", nullable = false, length = 50)
	private Integer noOfRemainingDays;
	
	@Column(name = "RMBS70304", nullable = false, length = 50)
	private Integer noOfUsedDays;
	
	@Column(name = "RMBS70305", nullable = false, length = 25)
	private Date createdDate;
	
	@OneToOne
	@JoinColumn(name = "CT_RMBS80401", nullable = false)
	private CategoryModel categoryModel;
	
	@Column(name = "RMBS70306", nullable = false, length = 50)
	private Integer responsibility;
	
	@OneToOne
	@JoinColumn(name = "RL_RMBS80201", nullable = false)
	private RoleModel roleModel;
	
	@OneToOne
	@JoinColumn(name = "ST_RMBS80301", nullable = false)
	private StatusModel statusModel;

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

	public CategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	public Integer getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(Integer responsibility) {
		this.responsibility = responsibility;
	}

	public RoleModel getRoleModel() {
		return roleModel;
	}

	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}

	public StatusModel getStatusModel() {
		return statusModel;
	}

	public void setStatusModel(StatusModel statusModel) {
		this.statusModel = statusModel;
	}
	
	

}
