package com.anny.HibernateDemo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity()
@Table(name="employee")
public class EmployeModel {

	@Id
	private int id;
	@Column(name="Emp_name")
	private String name;
	private String email;
	@OneToMany(mappedBy="employeModel")
	private List<Laptop> laptop=new ArrayList<Laptop>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	@Override
	public String toString() {
		return "EmployeModel [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
}
