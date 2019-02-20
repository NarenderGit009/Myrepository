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
@Table(name="RMBS105", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS10501")})   //id
		           
public class DoctorModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS10501", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RMBS10502", nullable = false, length = 100)
	private String doctorName;
	
	@Column(name = "RMBS10503", nullable = false, length = 25)
	private String initial;
	
	@Column(name = "RMBS10504", nullable = false, length = 25)
	private String gender;
	
	@Column(name = "RMBS10505", nullable = false, length = 100)
	private String qualification;
	
	@Column(name = "RMBS10506", nullable = false, length = 100)
	private String specialization;
	
	@Column(name = "RMBS10507", nullable = false, length = 100)
	private String hospitalName;
	
	@Column(name = "RMBS10508", nullable = false, length = 25)
	private Date createdDate;
	
	@Column(name = "RMBS10509", nullable = false, length = 25)
	private Date updatedDate;

	@OneToOne
	@JoinColumn(name = "RS_RMBS10601", nullable = false)
	private ResourceModel resourceModel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public ResourceModel getResourceModel() {
		return resourceModel;
	}

	public void setResourceModel(ResourceModel resourceModel) {
		this.resourceModel = resourceModel;
	}
 
    
}
