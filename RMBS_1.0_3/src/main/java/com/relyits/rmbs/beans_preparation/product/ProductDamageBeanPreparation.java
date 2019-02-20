package com.relyits.rmbs.beans_preparation.product;

import java.util.ArrayList;
import java.util.List;

import com.relyits.rmbs.beans.product.ProductDamageBean;
import com.relyits.rmbs.beans_preparation.registration.AgencyBeanPreparation;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.product.ProductDamageModel;



public class ProductDamageBeanPreparation {
	
	private static ProductDamageBean productDamageBean = null;
	
	public static ProductDamageBean prepareProductDamageBean(ProductDamageModel productDamageModel){
		
		productDamageBean = new ProductDamageBean();
		productDamageBean.setId(productDamageModel.getId());
		productDamageBean.setQuantity(productDamageModel.getQuantity());
		productDamageBean.setDamagedDate(productDamageModel.getDamagedDate());
		productDamageBean.setAgencyBean(AgencyBeanPreparation.prepareAgencyBean(productDamageModel.getAgencyModel()));
		productDamageBean.setCreator(productDamageModel.getCreator());
		productDamageBean.setCreatorRoleBean(AddressBeanPreparation.prepareCreatorRoleBean(productDamageModel.getCreatorRoleModel()));
		productDamageBean.setProductInventoryBean(ProductInventoryBeanPreparation.prepareProductInventoryBean(productDamageModel.getProductInventoryModel()));
		productDamageBean.setReasonBean(AddressBeanPreparation.prepareReasonBean(productDamageModel.getReasonModel()));
		
		
		
		return productDamageBean;
		
	}
	
	public static List<ProductDamageBean> prepareListOfProductDamageBean(List<ProductDamageModel> productDamageModels){
		List<ProductDamageBean> productDamageBeans = null;
		if(productDamageModels != null && !productDamageModels.isEmpty()){
			productDamageBeans = new ArrayList<ProductDamageBean>();
			for(ProductDamageModel productDamageModel : productDamageModels){
				productDamageBeans.add(prepareProductDamageBean(productDamageModel));
				
			}
		}		
		
		return productDamageBeans;
		
	}

}
