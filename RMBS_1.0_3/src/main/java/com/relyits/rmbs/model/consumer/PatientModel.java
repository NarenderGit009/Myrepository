package com.relyits.rmbs.model.consumer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.RoleModel;

@Entity
@Table(name="RMBS602", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS60201") })   //id
public class PatientModel implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS60201", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RMBS60202", nullable = false, length = 100)
	private String name;
	
	@Column(name = "RMBS60203", nullable = false, length = 25)
	private String gender;
	
	@OneToOne
	@JoinColumn(name = "ADD_RMBS80101", nullable = false)
	private AddressModel addressModel;
	
	@Column(name = "RMBS60204", nullable = false, length = 25)
	private Integer createdBy;
	
	@OneToOne
	@JoinColumn(name = "RL_RMBS80201", nullable = false)
	private RoleModel roleModel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public AddressModel getAddressModel() {
		return addressModel;
	}

	public void setAddressModel(AddressModel addressModel) {
		this.addressModel = addressModel;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public RoleModel getRoleModel() {
		return roleModel;
	}

	public void setRoleModel(RoleModel roleModel) {
		this.roleModel = roleModel;
	}
	
	


}
