package com.relyits.rmbs.dao;

import java.util.List;

import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.ReasonModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.refference.SubCategoryModel;


public interface ResourcesDAO {
	
	/********************    Status Related   *****************************/
	  
	public List<StatusModel> createStatus(List<StatusModel> statusModels);
	
	public List<StatusModel> updateStatusFields(List<StatusModel> statusModels);
	
	public List<StatusModel> getStatusList();
	
	public StatusModel getStatus(StatusModel statusModel);
  
	/********************    Category Related   *****************************/ 

	public List<CategoryModel> createCategory(List<CategoryModel> categoryModels);
	
	public List<CategoryModel> updateCategoriesFields(List<CategoryModel> categoryModels);
	
	public CategoryModel getCategory(CategoryModel categoryModel);
	
	public List<CategoryModel> getCategoriesList();
	
	/********************    Sub Category Related   *****************************/ 

	public List<SubCategoryModel> createSubCategory(List<SubCategoryModel> subCategoryModels);
	
	public List<SubCategoryModel> updateSubCategoriesFields(List<SubCategoryModel> subCategoryModels);
	
	public SubCategoryModel getSubCategory(SubCategoryModel subCategoryModel);
	
	public List<SubCategoryModel> getSubCategoriesList();
	
	/********************    Role Related   *****************************/ 

	public List<RoleModel> createRole(List<RoleModel> roleModels);
	
	public List<RoleModel> updateRoleFields(List<RoleModel> roleModels);
	
	public RoleModel getRole(RoleModel roleModel);
	
	public List<RoleModel> getRolesList();
	
	/********************    Address Related   *****************************/ 

	public List<AddressModel> createAddress(List<AddressModel> addressModels);
	
	public List<AddressModel> updateAddress(List<AddressModel> addressModels);
	
	public AddressModel getAddress(AddressModel addressModel);
	
	public List<AddressModel> getAddressesList();
	
	/********************    Reason Related   *****************************/ 

	public List<ReasonModel> createReason(List<ReasonModel> reasonModels);
	
	public List<ReasonModel> updateReasonFields(List<ReasonModel> reasonModels);
	
	public ReasonModel getReason(ReasonModel reasonModel);
	
	public List<ReasonModel> getReasonsList();
}
