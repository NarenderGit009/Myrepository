package com.relyits.rmbs.model.menu;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="RMBS501", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS50101") })   //id
public class MenuModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS50101", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RMBS50102", nullable = false, length = 100)
	private String parentMenuIds;
	
	@Column(name = "RMBS50103", nullable = false, length = 100)
	private String childMenuIds;
	
	@Column(name = "RMBS50104", nullable = false, length = 100)
	private Date createdDate;
	
	@Column(name = "RMBS50105", nullable = false, length = 100)
	private Date UpadtedDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParentMenuIds() {
		return parentMenuIds;
	}

	public void setParentMenuIds(String parentMenuIds) {
		this.parentMenuIds = parentMenuIds;
	}

	public String getChildMenuIds() {
		return childMenuIds;
	}

	public void setChildMenuIds(String childMenuIds) {
		this.childMenuIds = childMenuIds;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpadtedDate() {
		return UpadtedDate;
	}

	public void setUpadtedDate(Date upadtedDate) {
		UpadtedDate = upadtedDate;
	}
	
	

}
