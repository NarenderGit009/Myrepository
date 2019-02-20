package com.relyits.rmbs.model.registration;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="RMBS104", schema="RMBS",
            uniqueConstraints = {
		           @UniqueConstraint(columnNames = "RMBS10401"),   //id
		           @UniqueConstraint(columnNames = "RMBS10402")})  // agencyName
public class AgencyModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RMBS10401", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "RMBS10402", unique = true, nullable = false, length = 100)
	private String agencyName;
	
	@Column(name = "RMBS10403", nullable = false, length = 100)
	private String cstNo;
	
	@Column(name = "RMBS10404", nullable = false, length = 100)
	private String dlNo1;
	
	@Column(name = "RMBS10405", nullable = false, length = 100)
	private String dlNo2;
	
	@Column(name = "RMBS10406", nullable = false, length = 25)
	private Date createdDate;
	
	@Column(name = "RMBS10407", nullable = false, length = 25)
	private Date updatedDate;

	@OneToOne
	@JoinColumn(name = "RS_RMBS10601", nullable = false)
	private ResourceModel resourceModel;

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

	public ResourceModel getResourceModel() {
		return resourceModel;
	}

	public void setResourceModel(ResourceModel resourceModel) {
		this.resourceModel = resourceModel;
	}
	
	
}
