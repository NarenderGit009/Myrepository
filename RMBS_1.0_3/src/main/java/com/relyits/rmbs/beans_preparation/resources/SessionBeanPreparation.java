package com.relyits.rmbs.beans_preparation.resources;


import com.relyits.rmbs.beans.registration.OrganizationBean;
import com.relyits.rmbs.beans.registration.ResourceBean;
import com.relyits.rmbs.beans.resources.AddressBean;
import com.relyits.rmbs.beans.resources.CategoryBean;
import com.relyits.rmbs.beans.resources.RoleBean;
import com.relyits.rmbs.beans.resources.StatusBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.beans_preparation.registration.BranchBeanPreparation;
import com.relyits.rmbs.beans_preparation.registration.OrganizationBeanPreparation;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model.registration.OutletModel;

public class SessionBeanPreparation {

	
	private static UserSessionBean userSessionBean=null;
	private static ResourceBean resourceBean=null;
	private static OrganizationBean organizationBean=null;

	/*******************************************************************************************/
	/***************************************   User Session  ***********************************/
	/*******************************************************************************************/

	public static UserSessionBean prepareUserSessionBeanFromOrganizationModel(OrganizationModel organizationModel){
		
		userSessionBean = new UserSessionBean();
		resourceBean = new ResourceBean();

		userSessionBean.setId(organizationModel.getId());
		userSessionBean.setUserName(organizationModel.getUserName());
		userSessionBean.setFirstName(organizationModel.getFirstName());
		userSessionBean.setLastName(organizationModel.getLastName());
		userSessionBean.setName(organizationModel.getName());
/*		roleBean.setId(organizationModel.getResourceModel().getRoleModel().getId());
		roleBean.setRole(organizationModel.getResourceModel().getRoleModel().getRole());
		
		creatorRoleBean.setId(organizationModel.getResourceModel().getCreatorRoleModel().getId());
		creatorRoleBean.setRole(organizationModel.getResourceModel().getCreatorRoleModel().getRole());
		
		addressBean.setId(organizationModel.getResourceModel().getAddressModel().getId());
		addressBean.setAddress(organizationModel.getResourceModel().getAddressModel().getAddress());
		addressBean.setAddress(organizationModel.getResourceModel().getAddressModel().getEmail());
		addressBean.setMobile(organizationModel.getResourceModel().getAddressModel().getMobile());
		
		accountStatusBean.setId(organizationModel.getResourceModel().getAccountStatusModel().getId());
		accountStatusBean.setFlag(organizationModel.getResourceModel().getAccountStatusModel().getStatus());
		
		loginStatusBean.setId(organizationModel.getResourceModel().getLoginStatusModel().getId());
		loginStatusBean.setFlag(organizationModel.getResourceModel().getLoginStatusModel().getStatus());
		categoryBean.setId(organizationModel.getResourceModel().getRoleModel().getCategoryModel().getId());
		categoryBean.setCategory(organizationModel.getResourceModel().getRoleModel().getCategoryModel().getCategory());          */
		
		resourceBean = AddressBeanPreparation.prepareResourceBean(organizationModel.getResourceModel());                                                                     
				
		/*			resourceBean.setId(organizationModel.getResourceModel().getId());
		resourceBean.setCreatedBy(organizationModel.getResourceModel().getCreatedBy());
		
		
		resourceBean.setRoleBean(AddressBeanPreparation.prepareRoleBean(organizationModel.getResourceModel().getRoleModel()));
		resourceBean.setCreatorRoleBean(AddressBeanPreparation.prepareRoleBean(organizationModel.getResourceModel().getCreatorRoleModel()));
		resourceBean.setAddressBean(AddressBeanPreparation.prepareAddressBean(organizationModel.getResourceModel().getAddressModel()));
		resourceBean.setAccountStatusBean(AddressBeanPreparation.prepareAccountStatusBean(organizationModel.getResourceModel().getAccountStatusModel()));
		resourceBean.setLoginStatusBean(AddressBeanPreparation.prepareLoginStatusBean(organizationModel.getResourceModel().getLoginStatusModel()));            
	
			
		resourceBean.setRoleBean(roleBean);
		resourceBean.setCreatorRoleBean(creatorRoleBean);
		resourceBean.setAddressBean(addressBean);
		resourceBean.setAccountStatusBean(accountStatusBean);
		resourceBean.setLoginStatusBean(loginStatusBean);                    */
				
		userSessionBean.setResourceBean(resourceBean);
		
		return userSessionBean;
		
	}
	
	public static UserSessionBean prepareUserSessionBeanFromBranchModel(BranchModel branchModel){
		
		userSessionBean = new UserSessionBean();
		resourceBean = new ResourceBean();

		userSessionBean.setId(branchModel.getId());
		userSessionBean.setUserName(branchModel.getUserName());
		userSessionBean.setFirstName(branchModel.getFirstName());
		userSessionBean.setLastName(branchModel.getLastName());
		userSessionBean.setName(branchModel.getName());
		organizationBean = new OrganizationBean();
	    organizationBean.setId(branchModel.getOrganizationModel().getId());
	    organizationBean.setName(branchModel.getOrganizationModel().getName());
        userSessionBean.setOrganizationBean(organizationBean);
		resourceBean = AddressBeanPreparation.prepareResourceBean(branchModel.getResourceModel()); 
		
	/*	resourceBean.setId(branchModel.getResourceModel().getId());
		resourceBean.setCreatedBy(branchModel.getResourceModel().getCreatedBy());
		resourceBean.setRoleBean(AddressBeanPreparation.prepareRoleBean(branchModel.getResourceModel().getRoleModel()));
		resourceBean.setCreatorRoleBean(AddressBeanPreparation.prepareRoleBean(branchModel.getResourceModel().getCreatorRoleModel()));
		resourceBean.setAddressBean(AddressBeanPreparation.prepareAddressBean(branchModel.getResourceModel().getAddressModel()));
		resourceBean.setAccountStatusBean(AddressBeanPreparation.prepareAccountStatusBean(branchModel.getResourceModel().getAccountStatusModel()));
		resourceBean.setLoginStatusBean(AddressBeanPreparation.prepareLoginStatusBean(branchModel.getResourceModel().getLoginStatusModel()));
	*/			
		userSessionBean.setResourceBean(resourceBean);
		
		return userSessionBean;
		
	}
	
	public static UserSessionBean prepareUserSessionBeanFromOutletModel(OutletModel outletModel){
		
		userSessionBean = new UserSessionBean();
		resourceBean = new ResourceBean();

		userSessionBean.setId(outletModel.getId());
		userSessionBean.setUserName(outletModel.getUserName());
		userSessionBean.setFirstName(outletModel.getFirstName());
		userSessionBean.setLastName(outletModel.getLastName());
		userSessionBean.setBranchBean(BranchBeanPreparation.prepareBranchBean(outletModel.getBranchModel()));
		userSessionBean.setOrganizationBean(OrganizationBeanPreparation.prepareOrganizationModelBean(outletModel.getBranchModel().getOrganizationModel()));
		resourceBean = AddressBeanPreparation.prepareResourceBean(outletModel.getResourceModel()); 
	
	/*	resourceBean.setId(outletModel.getResourceModel().getId());
		resourceBean.setCreatedBy(outletModel.getResourceModel().getCreatedBy());
		resourceBean.setRoleBean(AddressBeanPreparation.prepareRoleBean(outletModel.getResourceModel().getRoleModel()));
		resourceBean.setCreatorRoleBean(AddressBeanPreparation.prepareRoleBean(outletModel.getResourceModel().getCreatorRoleModel()));
		resourceBean.setAddressBean(AddressBeanPreparation.prepareAddressBean(outletModel.getResourceModel().getAddressModel()));
		resourceBean.setAccountStatusBean(AddressBeanPreparation.prepareAccountStatusBean(outletModel.getResourceModel().getAccountStatusModel()));
		resourceBean.setLoginStatusBean(AddressBeanPreparation.prepareLoginStatusBean(outletModel.getResourceModel().getLoginStatusModel()));
	*/
		userSessionBean.setResourceBean(resourceBean);
		
		return userSessionBean;
		
	}
}
