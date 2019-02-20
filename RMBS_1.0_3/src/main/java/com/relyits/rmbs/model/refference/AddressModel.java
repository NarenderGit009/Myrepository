package com.relyits.rmbs.model.refference;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="RMBS801", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS80101") })   //id
public class AddressModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS80101", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RMBS80102", nullable = false, length = 100)
	private String address;
	
	@Column(name = "RMBS80103", nullable = false, length = 100)
	private Long mobile;
	
	@Column(name = "RMBS80104", nullable = false, length = 100)
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
	

}
