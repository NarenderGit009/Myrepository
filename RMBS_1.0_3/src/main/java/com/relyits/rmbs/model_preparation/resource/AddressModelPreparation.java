package com.relyits.rmbs.model_preparation.resource;

import com.relyits.rmbs.beans.registration.ResourceBean;
import com.relyits.rmbs.beans.resources.AddressBean;
import com.relyits.rmbs.beans.resources.CategoryBean;
import com.relyits.rmbs.beans.resources.PurchaseFormBean;
import com.relyits.rmbs.beans.resources.RoleBean;
import com.relyits.rmbs.beans.resources.StatusBean;
import com.relyits.rmbs.beans.resources.SubCategoryBean;
import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.refference.SubCategoryModel;
import com.relyits.rmbs.model.registration.ResourceModel;

public class AddressModelPreparation {
	
	
	 private static ResourceModel resourceModel = null;
	 private static AddressModel addressModel = null; 
	 private static RoleModel roleModel = null;
	 private static RoleModel creatorRoleModel = null;
	 private static StatusModel accountStatusModel = null;
	 private static StatusModel loginStatusModel = null;
	 private static StatusModel statusModel = null;
	 private static CategoryModel categoryModel = null;
	 private static SubCategoryModel subCategoryModel = null;
	
	
	public static ResourceModel prepareResourceModel(ResourceBean resourcBean){
		resourceModel = new ResourceModel();
		
		resourceModel.setId(resourcBean.getId());
		resourceModel.setCreatedBy(resourcBean.getCreatedBy());
					
		resourceModel.setAddressModel(prepareAddressModel(resourcBean.getAddressBean()));
		resourceModel.setAccountStatusModel(prepareAccountStatusModel(resourcBean.getAccountStatusBean()));
		resourceModel.setLoginStatusModel(prepareLoginStatusModel(resourcBean.getLoginStatusBean()));
		resourceModel.setRoleModel(prepareRoleModel(resourcBean.getRoleBean()));
		resourceModel.setCreatorRoleModel(prepareCreatorRoleModel(resourcBean.getCreatorRoleBean()));
		
		return resourceModel;
	}
	public static AddressModel prepareAddressModel(AddressBean addressBean){
		addressModel = new AddressModel();
		
		addressModel.setId(addressBean.getId());
		addressModel.setMobile(addressBean.getMobile());
		addressModel.setEmail(addressBean.getEmail());
		addressModel.setAddress(addressBean.getAddress());			
		
		return addressModel;
	}
	public static RoleModel prepareRoleModel(RoleBean roleBean){
		roleModel = new RoleModel();
		
		roleModel.setId(roleBean.getId());
		roleModel.setRole(roleBean.getRole());
		roleModel.setCategoryModel(prepareCategoryModel(roleBean.getCategoryBean()));
					
		return roleModel;
	}
	public static RoleModel prepareCreatorRoleModel(RoleBean creatorRoleBean){
		creatorRoleModel = new RoleModel();
		
		creatorRoleModel.setId(creatorRoleBean.getId());
		creatorRoleModel.setRole(creatorRoleBean.getRole());
		creatorRoleModel.setCategoryModel(prepareCategoryModel(creatorRoleBean.getCategoryBean()));
					
		return creatorRoleModel;
	}
	public static StatusModel prepareAccountStatusModel(StatusBean accountStatusBean){
		accountStatusModel = new StatusModel();
		
		accountStatusModel.setId(accountStatusBean.getId());
		accountStatusModel.setStatus(accountStatusBean.getFlag());
		accountStatusModel.setCategoryModel(prepareCategoryModel(accountStatusBean.getCategoryBean()));
		
		return accountStatusModel;
	}
	public static StatusModel prepareLoginStatusModel(StatusBean loginStatusBean){
		loginStatusModel = new StatusModel();
		
		loginStatusModel.setId(loginStatusBean.getId());
		loginStatusModel.setStatus(loginStatusBean.getFlag());
		loginStatusModel.setCategoryModel(prepareCategoryModel(loginStatusBean.getCategoryBean()));
	
		return loginStatusModel;
	}
	public static StatusModel prepareStatusModel(StatusBean statusBean){
		statusModel = new StatusModel();
		
		statusModel.setId(statusBean.getId());
		statusModel.setStatus(statusBean.getFlag());
		statusModel.setCategoryModel(prepareCategoryModel(statusBean.getCategoryBean()));
	
		return statusModel;
	}
	public static CategoryModel prepareCategoryModel(CategoryBean categoryBean){
		categoryModel = new CategoryModel();
		   
		categoryModel.setId(categoryBean.getId());
		categoryModel.setCategory(categoryBean.getCategory());
		
		return categoryModel;
	}
	public static SubCategoryModel prepareSubCategoryModel(SubCategoryBean subCategoryBean){
		subCategoryModel = new SubCategoryModel();
		   
		subCategoryModel.setId(subCategoryBean.getId());
		subCategoryModel.setCategory(subCategoryBean.getSubCategory());
		
		return subCategoryModel;
	}
	/////////////////////// Purchase Related ///////////////////////////////////
	public static RoleModel prepareCreatorRoleModelFromPurchaseFormBean(PurchaseFormBean purchaseFormBean){
		creatorRoleModel = new RoleModel();

		creatorRoleModel.setId(purchaseFormBean.getcRId());
		//creatorRoleBean.setRole(creatorRoleModel.getRole());
		//creatorRoleBean.setCategoryBean(prepareCategoryBean(creatorRoleModel.getCategoryModel()));

		return creatorRoleModel;
	}
	public static CategoryModel prepareCategoryModelFromPurchaseFormBean(PurchaseFormBean purchaseFormBean){
		categoryModel = new CategoryModel();

		categoryModel.setId(purchaseFormBean.getCatId());
		//categoryBean.setCategory(categoryModel.getCategory());

		return categoryModel;
	}
	public static SubCategoryModel prepareSubCategoryModelFromPurchaseFormBean(PurchaseFormBean purchaseFormBean){
		subCategoryModel = new SubCategoryModel();

		subCategoryModel.setId(purchaseFormBean.getsCatId());
		//subCategoryBean.setSubCategory(subCategoryModel.getCategory());

		return subCategoryModel;
	}
}
