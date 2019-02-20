package com.relyits.bean;

import java.sql.Date;

/**
 * @author Amar Errabelli
 *
 */
public class AgencyRegisterBean{
	private Integer id;
	private String agencyName;
	private String address;
	private Long phno;
	private String cstNo;
	private String dlNo1;
	private String dlNo2;
	private String msg;
	private Integer createdby;
	private Date createdDate;
	private Date updatedDate;
	private String status;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}

	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
