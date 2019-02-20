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
@Table(name="RMBS804", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS80401"),  //id
		           @UniqueConstraint(columnNames = "RMBS80402")})  //category 
public class CategoryModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS80401", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RMBS80402", unique = true, nullable = false, length = 100)
	private String category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
