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
@Table(name="RMBS503", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS50301"),   //id
		           @UniqueConstraint(columnNames = "RMBS50302"),   //menuItem
		           @UniqueConstraint(columnNames = "RMBS50303")})  //link
public class ChildMenuModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS50301", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RMBS50302", unique = true, nullable = false, length = 100)
	private String menuItem;
	
	@OneToOne
	@JoinColumn(name = "PM_RMBS50201", nullable = false)
	private ParentMenuModel parentMenuModel;

	@Column(name = "RMBS50303", unique = true, nullable = false, length = 100)
	private String link;
	
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

	public ParentMenuModel getParentMenuModel() {
		return parentMenuModel;
	}

	public void setParentMenuModel(ParentMenuModel parentMenuModel) {
		this.parentMenuModel = parentMenuModel;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public CategoryModel getCategoryModel() {
		return categoryModel;
	}

	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}

	
}
