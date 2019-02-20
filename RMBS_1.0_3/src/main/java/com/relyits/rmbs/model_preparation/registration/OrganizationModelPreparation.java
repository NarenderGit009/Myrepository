package com.relyits.rmbs.model_preparation.registration;


import java.text.ParseException;

import com.relyits.rmbs.beans.registration.RegistrationBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model.registration.ResourceModel;
import com.relyits.rmbs.model_preparation.resource.AddressModelPreparation;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;




public class OrganizationModelPreparation {
	
	private static OrganizationModel organizationModel = null;
	private static AddressModel addressModel = null;
	private static ResourceModel resourceModel= null;
	private static RoleModel roleModel = null;
	private static RoleModel creatorRoleModel = null;
	

	/*******************************************************************************************/
	/***************************************   Organization  ***********************************/
	/*******************************************************************************************/
	
	/**
	 * @param registrationBean
	 * @return
	 */
	public static OrganizationModel prepareOrganizationModel(RegistrationBean registrationBean){
		organizationModel = new OrganizationModel();
		addressModel = new AddressModel();
		resourceModel=new ResourceModel();
		roleModel =new RoleModel();
		creatorRoleModel =new RoleModel();
//		MenuModel menuModel = new MenuModel();
		
		//organizationModel.setId(1);
		organizationModel.setInitial("Mr");
		organizationModel.setFirstName(registrationBean.getFirstName());
		organizationModel.setLastName(registrationBean.getLastName());
		organizationModel.setUserName(registrationBean.getUserName());
		organizationModel.setGender(registrationBean.getGender());
		organizationModel.setPassword(registrationBean.getPassword());
		organizationModel.setName(registrationBean.getName());
		organizationModel.setTinNo(registrationBean.getTinNo());
		organizationModel.setImagePath(registrationBean.getImagePath());
		java.sql.Date dob = null,registredDateTime=null,updatedDateTime=null,lastLoginedDateTime = null;
		try {
			dob = DateAndTimeUtilities.parseStringDateToSqlDate(registrationBean.getDob());
			registredDateTime=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime());
			updatedDateTime=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime());
			lastLoginedDateTime=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		organizationModel.setDob(dob);
		organizationModel.setRegisteredDateTime(registredDateTime);
		organizationModel.setUpdatedDateTime(updatedDateTime);
		organizationModel.setLastLoginedDateTime(lastLoginedDateTime);

/*		organizationModel.setExpiryDays(0);
		organizationModel.setLicenseKey("");
		organizationModel.setLicenseValidDays(0);
		organizationModel.setDaysCount(0);
 */
		addressModel.setAddress(registrationBean.getAddressBean().getAddress());
		addressModel.setEmail(registrationBean.getAddressBean().getEmail());
		addressModel.setMobile(registrationBean.getAddressBean().getMobile());
		resourceModel.setAddressModel(addressModel);
		
		roleModel.setId(2);//Assigning role as Organization
		resourceModel.setRoleModel(roleModel);
		
		creatorRoleModel.setId(1);//Stamping the creator role is 1 means administrator
		resourceModel.setCreatorRoleModel(creatorRoleModel);//creator role assigning to resource model using creator role model
	
		organizationModel.setResourceModel(resourceModel);// assigning the created resource to the organization model
		
/*	   menuModel.setId(1);
	   resourceModel.setMenuModel(menuModel);
*/
		return organizationModel;
	}

	public static OrganizationModel prepareOrganizationModelFromUserSessionBean(UserSessionBean userSessionBean){
		organizationModel = new OrganizationModel();
		resourceModel=new ResourceModel();
	
		
		organizationModel.setId(userSessionBean.getId());
		organizationModel.setInitial(userSessionBean.getInitial());
		organizationModel.setFirstName(userSessionBean.getFirstName());
		organizationModel.setLastName(userSessionBean.getLastName());
		organizationModel.setUserName(userSessionBean.getUserName());
		organizationModel.setGender(userSessionBean.getGender());
		organizationModel.setName(userSessionBean.getName());
		organizationModel.setTinNo(userSessionBean.getTinNo());
		
		organizationModel.setDob(userSessionBean.getDob());
		organizationModel.setRegisteredDateTime(userSessionBean.getRegisteredDateTime());
		organizationModel.setUpdatedDateTime(userSessionBean.getUpdatedDateTime());
		organizationModel.setLastLoginedDateTime(userSessionBean.getLastLoginedDateTime());
		
		resourceModel=AddressModelPreparation.prepareResourceModel(userSessionBean.getResourceBean());
		
		organizationModel.setResourceModel(resourceModel);
		return organizationModel;
	}
}
