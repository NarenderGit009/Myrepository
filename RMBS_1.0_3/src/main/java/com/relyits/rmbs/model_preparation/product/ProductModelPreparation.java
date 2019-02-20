package com.relyits.rmbs.model_preparation.product;


import java.text.ParseException;

import com.relyits.rmbs.beans.product.ProductBean;
import com.relyits.rmbs.beans.resources.PurchaseFormBean;
import com.relyits.rmbs.model.product.ProductModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.SubCategoryModel;
import com.relyits.rmbs.model_preparation.resource.AddressModelPreparation;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;

public class ProductModelPreparation {
	
	
	private static ProductModel productModel = null;
	private static RoleModel creatorRoleModel = null;
	private static CategoryModel categoryModel = null;
	private static SubCategoryModel subCategoryModel = null;
	
	public static ProductModel prepareProductModel(ProductBean productBean) throws ParseException{
	
		productModel=new ProductModel();
		creatorRoleModel = new RoleModel();
		categoryModel = new CategoryModel();
		subCategoryModel = new SubCategoryModel();
		
		productModel.setName(productBean.getName());
		productModel.setmFCompanay(productBean.getmFCompanay());
		productModel.setSchDrug(productBean.getSchDrug());
		productModel.setId(productBean.getId());
		productModel.setCreatedBy(productBean.getCreatedBy());
		productModel.setCreatedDate(DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime()));
		
		categoryModel.setId(productBean.getCategoryBean().getId());
		subCategoryModel.setId(productBean.getSubCategoryBean().getId());
		creatorRoleModel.setId(productBean.getCreatorRoleBean().getId());
		/*
		productModel.setSubCategoryModel(AddressModelPreparation.prepareSubCategoryModel(productBean.getSubCategoryBean()));
		productModel.setCategoryModel(AddressModelPreparation.prepareCategoryModel(productBean.getCategoryBean()));
		productModel.setCreatorRoleModel(AddressModelPreparation.prepareRoleModel(productBean.getCreatoerRoleBean()));
		 */   
		productModel.setCategoryModel(categoryModel);
		productModel.setSubCategoryModel(subCategoryModel);
		productModel.setCreatorRoleModel(creatorRoleModel);
		//productModel.setCode(categoryModel.getId()+"-"+subCategoryModel.getId()+"-"+creatorRoleModel.getId());
				return productModel;
		}
	
	public static ProductModel prepareProductModelFormPurchaseFormBean(PurchaseFormBean purchaseFormBean) throws ParseException{
		productModel=new ProductModel();
		productModel.setId(purchaseFormBean.getpId());
		productModel.setName(purchaseFormBean.getpName());
		productModel.setCode(purchaseFormBean.getpCode());
		productModel.setmFCompanay(purchaseFormBean.getmFC());
		productModel.setSchDrug(purchaseFormBean.getSchD());
		productModel.setCreatedBy(purchaseFormBean.getcById());
		productModel.setCreatedDate(DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime()));
		productModel.setCreatorRoleModel(AddressModelPreparation.prepareCreatorRoleModelFromPurchaseFormBean(purchaseFormBean));
		productModel.setSubCategoryModel(AddressModelPreparation.prepareSubCategoryModelFromPurchaseFormBean(purchaseFormBean));
		productModel.setCategoryModel(AddressModelPreparation.prepareCategoryModelFromPurchaseFormBean(purchaseFormBean));
		return productModel;
	}
	

}
