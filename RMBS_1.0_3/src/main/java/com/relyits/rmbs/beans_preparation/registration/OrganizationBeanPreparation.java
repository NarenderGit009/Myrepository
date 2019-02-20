package com.relyits.rmbs.beans_preparation.registration;

import com.relyits.rmbs.beans.registration.OrganizationBean;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.registration.OrganizationModel;




public class OrganizationBeanPreparation {
	
	private static OrganizationBean organizationBean = null;

	public static OrganizationBean prepareOrganizationModelBean(OrganizationModel organizationModel){
		organizationBean = new OrganizationBean();
		
		
		organizationBean.setId(organizationModel.getId());
		organizationBean.setUserName(organizationModel.getFirstName());
		organizationBean.setLastName(organizationModel.getLastName());
		organizationBean.setInitial(organizationModel.getInitial());
		organizationBean.setGender(organizationModel.getGender());
		organizationBean.setName(organizationModel.getName());
		organizationBean.setTinNo(organizationModel.getTinNo());
		organizationBean.setDob(organizationModel.getDob());
		organizationBean.setRegisteredDateTime(organizationModel.getRegisteredDateTime());
		organizationBean.setUpdatedDateTime(organizationModel.getUpdatedDateTime());
		organizationBean.setLastLoginedDateTime(organizationModel.getLastLoginedDateTime());
		organizationBean.setExpiryDays(0);
		organizationBean.setLicenseKey("");
		organizationBean.setLicenseValidDays(0);
		organizationBean.setDaysCount(0);
		organizationBean.setResourceBean(AddressBeanPreparation.prepareResourceBean(organizationModel.getResourceModel()));
		

		
		return organizationBean;
	}
	
}
