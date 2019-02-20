package com.relyits.rmbs.beans.menu;

import java.sql.Date;

public class MenuBean {
	
	private Integer id;
	private String parentMenuIds;
	private String childMenuIds;
	private Date createdDate;
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
