package com.relyits.rmbs.beans_preparation.product;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.relyits.rmbs.beans.product.ProductBean;
import com.relyits.rmbs.beans.product.ProductInventoryBean;
import com.relyits.rmbs.beans.resources.PurchaseFormBean;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.product.ProductModel;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;


public class ProductBeanPreparation {
	
	private static ProductBean productBean=null;
	private static ProductInventoryBean productInventoryBean=null;
	

	
	public static ProductBean prepareProductBean(ProductModel productModel){
			productBean=new ProductBean();
			productBean.setId(productModel.getId());
			productBean.setName(productModel.getName());
			productBean.setCode(productModel.getCode());
			productBean.setmFCompanay(productModel.getmFCompanay());
			productBean.setSchDrug(productModel.getSchDrug());
			productBean.setCreatedBy(productModel.getCreatedBy());
			productBean.setCreatorRoleBean(AddressBeanPreparation.prepareCreatorRoleBean(productModel.getCreatorRoleModel()));
			productBean.setSubCategoryBean(AddressBeanPreparation.prepareSubCategoryBean(productModel.getSubCategoryModel()));
			productBean.setCategoryBean(AddressBeanPreparation.prepareCategoryBean(productModel.getCategoryModel()));
			productBean.setCreatedDate(productModel.getCreatedDate());
		
		    
				return productBean;
		}

	public static ProductBean prepareProductBeanFormPurchaseFormBean(PurchaseFormBean purchaseFormBean) throws ParseException{
		productBean=new ProductBean();
		productBean.setId(purchaseFormBean.getpId());
		productBean.setName(purchaseFormBean.getpName());
		productBean.setCode(purchaseFormBean.getpCode());
		productBean.setmFCompanay(purchaseFormBean.getmFC());
		productBean.setSchDrug(purchaseFormBean.getSchD());
		productBean.setCreatedBy(purchaseFormBean.getcById());
		productBean.setCreatedDate(DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime()));
		productBean.setCreatorRoleBean(AddressBeanPreparation.prepareCreatorRoleBeanFromPurchaseFormBean(purchaseFormBean));
		productBean.setSubCategoryBean(AddressBeanPreparation.prepareSubCategoryBeanFromPurchaseFormBean(purchaseFormBean));
		productBean.setCategoryBean(AddressBeanPreparation.prepareCategoryBeanFromPurchaseFormBean(purchaseFormBean));
		return productBean;
	}	
	
	public static List<ProductBean> prepareListofProductBean(List<ProductModel> productModel){
		List<ProductBean> productBeans = null;
		   if(productModel != null && !productModel.isEmpty()){		
			   productBeans = new ArrayList<ProductBean>();			
			for(ProductModel productModel1 : productModel){					
				productBeans.add(prepareProductBean(productModel1));
				
             }
		}
		return productBeans;
	}
}
