package com.relyits.rmbs.model.product;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.registration.AgencyModel;

public class FileDataModel {

	private static CommonsMultipartFile fileData;
	private AgencyModel agencyModel;
	private String createdBy;
	public static CommonsMultipartFile getFileData() {
		return fileData;
	}

	public static void setFileData(CommonsMultipartFile fileData) {
		FileDataModel.fileData = fileData;
	}

	public AgencyModel getAgencyModel() {
		return agencyModel;
	}

	public void setAgencyModel(AgencyModel agencyModel) {
		this.agencyModel = agencyModel;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
