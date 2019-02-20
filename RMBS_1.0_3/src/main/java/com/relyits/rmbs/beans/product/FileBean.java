package com.relyits.rmbs.beans.product;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.relyits.rmbs.beans.registration.AgencyBean;

public class FileBean {

	  private CommonsMultipartFile fileData;
	  private AgencyBean agencyBean;
	  private String createdBy;
	  public CommonsMultipartFile getFileData()
	  {
	    return fileData;
	  }

	  public void setFileData(CommonsMultipartFile fileData)
	  {
	    this.fileData = fileData;
	  }

	public AgencyBean getAgencyBean() {
		return agencyBean;
	}

	public void setAgencyBean(AgencyBean agencyBean) {
		this.agencyBean = agencyBean;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	  
}
