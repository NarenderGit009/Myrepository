package com.relyits.rmbs.daoImpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.relyits.rmbs.dao.ResourcesDAO;
import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.ReasonModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.refference.SubCategoryModel;


@Repository("ResourcesDAO")
public class ResourcesDAOImpl implements ResourcesDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	private StatusModel statusModel1=null;
	private CategoryModel categoryModel1=null;
	private AddressModel addressModel1=null;
	private ReasonModel reasonModel1=null;
	private RoleModel roleModel1=null;
	private SubCategoryModel subCategoryModel1=null;

	/********************    Status Related   *****************************/

	public List<StatusModel> createStatus(List<StatusModel> statusModels) {
		return null;
	}

	public List<StatusModel> updateStatusFields(List<StatusModel> statusModels) {
		return null;
	}

	public List<StatusModel> getStatusList() {
		return null;
	}

	public StatusModel getStatus(StatusModel statusModel) {
		Session session=sessionFactory.openSession();
		statusModel1=(StatusModel) sessionFactory.openSession().get(StatusModel.class, statusModel.getId());
		session.close();
		return statusModel1;
	}

	/********************    Category Related   *****************************/

	public List<CategoryModel> createCategory(List<CategoryModel> categoryModels) {
		return null;
	}

	public List<CategoryModel> updateCategoriesFields(
			List<CategoryModel> categoryModels) {
		return null;
	}

	public CategoryModel getCategory(CategoryModel categoryModel) {
		Session session=sessionFactory.openSession();
		categoryModel1=(CategoryModel) sessionFactory.openSession().get(CategoryModel.class, categoryModel.getId());
		session.close();
		return categoryModel1;
	}

	public List<CategoryModel> getCategoriesList() {
		return null;
	}

	/********************  Sub  Category Related   *****************************/

	public List<SubCategoryModel> createSubCategory(
			List<SubCategoryModel> subCategoryModels) {
		return null;
	}

	public List<SubCategoryModel> updateSubCategoriesFields(
			List<SubCategoryModel> subCategoryModels) {
		return null;
	}

	public SubCategoryModel getSubCategory(SubCategoryModel subCategoryModel) {
		Session session=sessionFactory.openSession();
		subCategoryModel1=(SubCategoryModel) sessionFactory.openSession().get(CategoryModel.class, subCategoryModel.getId());
		session.close();
		return subCategoryModel1;
	}

	public List<SubCategoryModel> getSubCategoriesList() {
		return null;
	}

	/********************  Role Related   *****************************/

	public List<RoleModel> createRole(List<RoleModel> roleModels) {
		return null;
	}

	public List<RoleModel> updateRoleFields(List<RoleModel> roleModels) {
		return null;
	}

	public RoleModel getRole(RoleModel roleModel) {
		Session session=sessionFactory.openSession();
		roleModel1=(RoleModel) sessionFactory.openSession().get(RoleModel.class, roleModel.getId());
		session.close();
		return roleModel1;
	}

	public List<RoleModel> getRolesList() {
		return null;
	}

	/********************  Address Related   *****************************/

	public List<AddressModel> createAddress(List<AddressModel> addressModels) {
		return null;
	}

	public List<AddressModel> updateAddress(List<AddressModel> addressModels) {
		return null;
	}

	public AddressModel getAddress(AddressModel addressModel) {
		Session session=sessionFactory.openSession();
		addressModel1=(AddressModel) sessionFactory.openSession().get(AddressModel.class, addressModel.getId());
		session.close();
		return addressModel1;
	}

	public List<AddressModel> getAddressesList() {
		return null;
	}

	/********************  Reason Related   *****************************/

	public List<ReasonModel> createReason(List<ReasonModel> reasonModels) {
		return null;
	}

	public List<ReasonModel> updateReasonFields(List<ReasonModel> reasonModels) {
		return null;
	}

	public ReasonModel getReason(ReasonModel reasonModel) {
		Session session=sessionFactory.openSession();
		reasonModel1=(ReasonModel) sessionFactory.openSession().get(ReasonModel.class, reasonModel.getId());
		session.close();
		return reasonModel1;
	}

	public List<ReasonModel> getReasonsList() {
		return null;
	}




}
