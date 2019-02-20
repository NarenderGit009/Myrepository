
package com.relyits.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries(
		@NamedQuery(
				name="getAgenciesByCreator", 
        		query="FROM AgencyRegister a where a.createdby=:cid and a.status=:status"
				)
		)

@Entity
@Table(name="agency", schema="RMBS")


public class AgencyRegister implements Serializable{


	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "aid")
	private Integer aid;
	
	@Column(name = "CREATED_BY")
	private Integer createdby;
	
	@Column(name="A_NAME")
	private String agencyNme;
	
	@Column(name="ADDRESS")
	private String address;
	
	
	@Column(name="PHONE_NUM")
	private Long phno;
	
	@Column(name="CST_NUM")
	private String cstNo;
	
	@Column(name="DL1_NUM")
	private String dlNo1;
	
	@Column(name="DL2_NUM")
	private String dlNo2;
	

	@Column(name="CRATED_DATE")
	private Date createdDate;
	
	@Column(name="UPDATED_DATE")
	private Date updatedDate;
	
	@Column(name="STATUS",columnDefinition = "TEXT default `E`")
	private String status;
	
   public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}

	public String getAgencyNme() {
		return agencyNme;
	}

	public void setAgencyNme(String agencyNme) {
		this.agencyNme = agencyNme;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
