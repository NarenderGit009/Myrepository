
package com.relyits.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="child_menu", schema="RMBS")
public class ChildMenu implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "menu_child_id")
	private Integer idchild;

	
	
    @Column(name="child_menu_content")
	private String childmenucontent;
    
    @OneToOne
	@JoinColumn(name="menu_parent_id")
	private ParentMenu parentMenu;
	
	
	public Integer getIdchild() {
		return idchild;
	}


	public void setIdchild(Integer idchild) {
		this.idchild = idchild;
	}


	public String getChildmenucontent() {
		return childmenucontent;
	}


	public void setChildmenucontent(String childmenucontent) {
		this.childmenucontent = childmenucontent;
	}


	public ParentMenu getParentMenu() {
		return parentMenu;
	}


	public void setParentMenu(ParentMenu parentMenu) {
		this.parentMenu = parentMenu;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

