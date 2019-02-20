
package com.relyits.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parent_menu", schema="RMBS")
public class ParentMenu implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "menu_parent_id")
	private Integer idparent;

	@Column(name="parent_menu_content")
	private String parentmenucontent;
	
	
	
	public Integer getIdparent() {
		return idparent;
	}



	public void setIdparent(Integer idparent) {
		this.idparent = idparent;
	}



	public String getParentmenucontent() {
		return parentmenucontent;
	}



	public void setParentmenucontent(String parentmenucontent) {
		this.parentmenucontent = parentmenucontent;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

