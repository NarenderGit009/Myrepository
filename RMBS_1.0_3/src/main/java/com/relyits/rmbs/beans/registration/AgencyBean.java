package com.relyits.rmbs.beans.registration;

import java.sql.Date;


public class AgencyBean {
	
	private Integer id;
	private String agencyName;
	private String cstNo;
	private String dlNo1;
	private String dlNo2;
	private Date createdDate;
	private Date updatedDate;
	private ResourceBean resourceBean;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getCstNo() {
		return cstNo;
	}
	public void setCstNo(String cstNo) {
		this.cstNo = cstNo;
	}
	public String getDlNo1() {
		return dlNo1;
	}
	public void setDlNo1(String dlNo1) {
		this.dlNo1 = dlNo1;
	}
	public String getDlNo2() {
		return dlNo2;
	}
	public void setDlNo2(String dlNo2) {
		this.dlNo2 = dlNo2;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public ResourceBean getResourceBean() {
		return resourceBean;
	}
	public void setResourceBean(ResourceBean resourceBean) {
		this.resourceBean = resourceBean;
	}
	
	

}
