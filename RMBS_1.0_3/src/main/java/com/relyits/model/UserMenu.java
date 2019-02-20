
package com.relyits.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_menu", schema="RMBS")
public class UserMenu implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_user_menu")
	private Integer menuid;

	@Column(name="menu_parent_id")
	private String parentmenu;
	
	@Column(name="menu_child_id")
	private String childmenu;
	
	
	public Integer getMenuid() {
		return menuid;
	}


	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}


	public String getParentmenu() {
		return parentmenu;
	}


	public void setParentmenu(String parentmenu) {
		this.parentmenu = parentmenu;
	}


	public String getChildmenu() {
		return childmenu;
	}


	public void setChildmenu(String childmenu) {
		this.childmenu = childmenu;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

