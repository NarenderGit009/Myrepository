package com.relyits.rmbs.beans_preparation.resources;

import com.relyits.rmbs.beans.registration.ResourceBean;
import com.relyits.rmbs.beans.resources.AddressBean;
import com.relyits.rmbs.beans.resources.CategoryBean;
import com.relyits.rmbs.beans.resources.PurchaseFormBean;
import com.relyits.rmbs.beans.resources.ReasonBean;
import com.relyits.rmbs.beans.resources.RoleBean;
import com.relyits.rmbs.beans.resources.StatusBean;
import com.relyits.rmbs.beans.resources.SubCategoryBean;
import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.ReasonModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.refference.SubCategoryModel;
import com.relyits.rmbs.model.registration.ResourceModel;

public class AddressBeanPreparation {

	private static ResourceBean resourceBean = null;
	private static AddressBean addressBean = null; 
	private static RoleBean roleBean = null;
	private static RoleBean creatorRoleBean = null;
	private static StatusBean statusBean = null;
	private static StatusBean accountStatusBean = null;
	private static StatusBean loginStatusBean = null;
	private static CategoryBean categoryBean = null;
	private static SubCategoryBean subCategoryBean = null;
	private static ReasonBean reasonBean = null;

	public static ResourceBean prepareResourceBean(ResourceModel resourceModel){
		resourceBean = new ResourceBean();

		resourceBean.setId(resourceModel.getId());
		resourceBean.setCreatedBy(resourceModel.getCreatedBy());

		resourceBean.setAddressBean(prepareAddressBean(resourceModel.getAddressModel()));
		resourceBean.setAccountStatusBean(prepareAccountStatusBean(resourceModel.getAccountStatusModel()));
		resourceBean.setLoginStatusBean(prepareLoginStatusBean(resourceModel.getLoginStatusModel()));
		resourceBean.setRoleBean(prepareRoleBean(resourceModel.getRoleModel()));
		resourceBean.setCreatorRoleBean(prepareCreatorRoleBean(resourceModel.getCreatorRoleModel()));

		return resourceBean;
	}
	public static AddressBean prepareAddressBean(AddressModel addressModel){
		addressBean = new AddressBean();

		addressBean.setId(addressModel.getId());
		addressBean.setMobile(addressModel.getMobile());
		addressBean.setEmail(addressModel.getEmail());
		addressBean.setAddress(addressModel.getAddress());   

		return addressBean;
	}
	public static StatusBean prepareStatusBean(StatusModel statusModel){
		statusBean = new StatusBean();

		statusBean.setId(statusModel.getId());
		statusBean.setFlag(statusModel.getStatus());   
		statusBean.setCategoryBean(prepareCategoryBean(statusModel.getCategoryModel()));

		return statusBean;
	}
	public static StatusBean prepareAccountStatusBean(StatusModel accountStatusModel){
		accountStatusBean = new StatusBean();

		accountStatusBean.setId(accountStatusModel.getId());
		accountStatusBean.setFlag(accountStatusModel.getStatus());   
		accountStatusBean.setCategoryBean(prepareCategoryBean(accountStatusModel.getCategoryModel()));

		return accountStatusBean;
	} 
	public static StatusBean prepareLoginStatusBean(StatusModel loginStatusModel){
		loginStatusBean = new StatusBean();

		loginStatusBean.setId(loginStatusModel.getId());
		loginStatusBean.setFlag(loginStatusModel.getStatus());   
		loginStatusBean.setCategoryBean(prepareCategoryBean(loginStatusModel.getCategoryModel()));

		return loginStatusBean;
	}
	public static RoleBean prepareRoleBean(RoleModel roleModel){
		roleBean = new RoleBean();

		roleBean.setId(roleModel.getId());
		roleBean.setRole(roleModel.getRole());
		roleBean.setCategoryBean(prepareCategoryBean(roleModel.getCategoryModel()));

		return roleBean;
	}
	public static RoleBean prepareCreatorRoleBean(RoleModel creatorRoleModel){
		creatorRoleBean = new RoleBean();

		creatorRoleBean.setId(creatorRoleModel.getId());
		creatorRoleBean.setRole(creatorRoleModel.getRole());
		creatorRoleBean.setCategoryBean(prepareCategoryBean(creatorRoleModel.getCategoryModel()));

		return creatorRoleBean;
	}
	public static CategoryBean prepareCategoryBean(CategoryModel categoryModel){
		categoryBean = new CategoryBean();

		categoryBean.setId(categoryModel.getId());
		categoryBean.setCategory(categoryModel.getCategory());

		return categoryBean;
	}
	public static SubCategoryBean prepareSubCategoryBean(SubCategoryModel subCategoryModel){
		subCategoryBean = new SubCategoryBean();

		subCategoryBean.setId(subCategoryModel.getId());
		subCategoryBean.setSubCategory(subCategoryModel.getCategory());

		return subCategoryBean;
	}
	public static ReasonBean prepareReasonBean(ReasonModel reasonModel){
		reasonBean = new ReasonBean();
		
		reasonBean.setId(reasonModel.getId());
		reasonBean.setReason(reasonModel.getReason());
		reasonBean.setCategoryBean(AddressBeanPreparation.prepareCategoryBean(reasonModel.getCategoryModel()));
		
		return reasonBean;
		
	}
	/////////////////////// Purchase Related ///////////////////////////////////
	public static RoleBean prepareCreatorRoleBeanFromPurchaseFormBean(PurchaseFormBean purchaseFormBean){
		creatorRoleBean = new RoleBean();

		creatorRoleBean.setId(purchaseFormBean.getcRId());
		//creatorRoleBean.setRole(creatorRoleModel.getRole());
		//creatorRoleBean.setCategoryBean(prepareCategoryBean(creatorRoleModel.getCategoryModel()));

		return creatorRoleBean;
	}
	public static CategoryBean prepareCategoryBeanFromPurchaseFormBean(PurchaseFormBean purchaseFormBean){
		categoryBean = new CategoryBean();

		categoryBean.setId(purchaseFormBean.getCatId());
		//categoryBean.setCategory(categoryModel.getCategory());

		return categoryBean;
	}
	public static SubCategoryBean prepareSubCategoryBeanFromPurchaseFormBean(PurchaseFormBean purchaseFormBean){
		subCategoryBean = new SubCategoryBean();

		subCategoryBean.setId(purchaseFormBean.getsCatId());
		//subCategoryBean.setSubCategory(subCategoryModel.getCategory());

		return subCategoryBean;
	}
	
}
