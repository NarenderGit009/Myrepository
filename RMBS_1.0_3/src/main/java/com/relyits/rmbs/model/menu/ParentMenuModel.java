package com.relyits.rmbs.model.menu;

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

import com.relyits.rmbs.model.refference.CategoryModel;

@Entity
@Table(name="RMBS502", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS50201"),   //id
		           @UniqueConstraint(columnNames = "RMBS50202")})  //menuItem
public class ParentMenuModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS50201", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RMBS50202", unique = true, nullable = false, length = 100)
	private String menuItem;
	
	@OneToOne
	@JoinColumn(name = "CT_RMBS80401", nullable = false)
	private CategoryModel categoryModel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}

	public CategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}
	
	
	

}
