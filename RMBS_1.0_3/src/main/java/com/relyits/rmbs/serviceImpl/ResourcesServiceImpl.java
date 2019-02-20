package com.relyits.rmbs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relyits.rmbs.dao.ResourcesDAO;
import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.ReasonModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.refference.SubCategoryModel;
import com.relyits.rmbs.service.ResourcesService;

@Service("ResourcesService")
public class ResourcesServiceImpl implements ResourcesService{

	@Autowired
	private ResourcesDAO resourcesDAO;

	/********************    Status Related   *****************************/
	
	public List<StatusModel> createStatus(List<StatusModel> statusModels) {
		return resourcesDAO.createStatus(statusModels);
	}

	public List<StatusModel> updateStatusFields(List<StatusModel> statusModels) {
		return resourcesDAO.updateStatusFields(statusModels);
	}

	public List<StatusModel> getStatusList() {
		return resourcesDAO.getStatusList();
	}

	public StatusModel getStatus(StatusModel statusModel) {
		return resourcesDAO.getStatus(statusModel);
	}

	/********************    Category Related   *****************************/
	
	public List<CategoryModel> createCategory(List<CategoryModel> categoryModels) {
		return resourcesDAO.createCategory(categoryModels);
	}

	public List<CategoryModel> updateCategoriesFields(
			List<CategoryModel> categoryModels) {
		return resourcesDAO.updateCategoriesFields(categoryModels);
	}

	public CategoryModel getCategory(CategoryModel categoryModel) {
		return resourcesDAO.getCategory(categoryModel);
	}

	public List<CategoryModel> getCategoriesList() {
		return resourcesDAO.getCategoriesList();
	}

	/********************  Sub  Category Related   *****************************/
	
	public List<SubCategoryModel> createSubCategory(
			List<SubCategoryModel> subCategoryModels) {
		return resourcesDAO.createSubCategory(subCategoryModels);
	}

	public List<SubCategoryModel> updateSubCategoriesFields(
			List<SubCategoryModel> subCategoryModels) {
		return resourcesDAO.updateSubCategoriesFields(subCategoryModels);
	}

	public SubCategoryModel getSubCategory(SubCategoryModel subCategoryModel) {
		return resourcesDAO.getSubCategory(subCategoryModel);
	}

	public List<SubCategoryModel> getSubCategoriesList() {
		return resourcesDAO.getSubCategoriesList();
	}

	/********************  Role Related   *****************************/
	
	public List<RoleModel> createRole(List<RoleModel> roleModels) {
		return resourcesDAO.createRole(roleModels);
	}

	public List<RoleModel> updateRoleFields(List<RoleModel> roleModels) {
		return resourcesDAO.updateRoleFields(roleModels);
	}

	public RoleModel getRole(RoleModel roleModel) {
		return resourcesDAO.getRole(roleModel);
	}

	public List<RoleModel> getRolesList() {
		return resourcesDAO.getRolesList();
	}

	/********************  Address Related   *****************************/
	
	public List<AddressModel> createAddress(List<AddressModel> addressModels) {
		return resourcesDAO.createAddress(addressModels);
	}

	public List<AddressModel> updateAddress(List<AddressModel> addressModels) {
		return resourcesDAO.updateAddress(addressModels);
	}

	public AddressModel getAddress(AddressModel addressModel) {
		return resourcesDAO.getAddress(addressModel);
	}

	public List<AddressModel> getAddressesList() {
		return resourcesDAO.getAddressesList();
	}
	
	/********************  Reason Related   *****************************/
	
	public List<ReasonModel> createReason(List<ReasonModel> reasonModels) {
		return resourcesDAO.createReason(reasonModels);
	}

	public List<ReasonModel> updateReasonFields(List<ReasonModel> reasonModels) {
		return resourcesDAO.updateReasonFields(reasonModels);
	}

	public ReasonModel getReason(ReasonModel reasonModel) {
		return resourcesDAO.getReason(reasonModel);
	}

	public List<ReasonModel> getReasonsList() {
		return resourcesDAO.getReasonsList();
	}
	
	
	
}
