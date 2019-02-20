package com.relyits.rmbs.model.refference;

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

@Entity
@Table(name="RMBS803", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS80301"),  //id
		           @UniqueConstraint(columnNames = "RMBS80302")})  //flag 
public class StatusModel implements Serializable{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS80301", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RMBS80302", unique = true, nullable = false, length = 100)
	private String status;

	@OneToOne
	@JoinColumn(name = "CT_RMBS80401", nullable = false)
	private CategoryModel categoryModel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}
	
	

}
