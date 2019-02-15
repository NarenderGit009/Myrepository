package com.anny.HibernateDemo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	@Id
	private int lid;
	private String lname;
	
	@ManyToOne
	private EmployeModel employeModel;
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public EmployeModel getEmployeModel() {
		return employeModel;
	}
	public void setEmployeModel(EmployeModel employeModel) {
		this.employeModel = employeModel;
	}
	
	
}
