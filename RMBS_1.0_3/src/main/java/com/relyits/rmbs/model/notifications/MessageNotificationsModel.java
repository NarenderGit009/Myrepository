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
@Table(name="RMBS705", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS70501") })   //id
public class MessageNotificationsModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS70501", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RMBS70502", nullable = false, length = 100)
	private String message;
		
	@Column(name = "RMBS70503", nullable = false, length = 25)
	private Date createdDate;
	
	@OneToOne
	@JoinColumn(name = "CT_RMBS80401", nullable = false)
	private CategoryModel categoryModel;
	
	@Column(name = "RMBS70504", nullable = false, length = 25)
	private Integer createdBy;
	
	@OneToOne
	@JoinColumn(name = "CRL_RMBS70504_RMBS80201", nullable = false)
	private RoleModel creatorRoleModel;
	
	@Column(name = "RMBS70505", nullable = false, length = 50)
	private Integer responsibility;
	
	@OneToOne
	@JoinColumn(name = "RRL_RMBS70505_RMBS80201", nullable = false)
	private RoleModel responsibleRoleModel;
	
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
	

	public StatusModel getStatusModel() {
		return statusModel;
	}

	public void setStatusModel(StatusModel statusModel) {
		this.statusModel = statusModel;
	}

	public RoleModel getCreatorRoleModel() {
		return creatorRoleModel;
	}

	public void setCreatorRoleModel(RoleModel creatorRoleModel) {
		this.creatorRoleModel = creatorRoleModel;
	}

	public RoleModel getResponsibleRoleModel() {
		return responsibleRoleModel;
	}

	public void setResponsibleRoleModel(RoleModel responsibleRoleModel) {
		this.responsibleRoleModel = responsibleRoleModel;
	}

	
	

}
