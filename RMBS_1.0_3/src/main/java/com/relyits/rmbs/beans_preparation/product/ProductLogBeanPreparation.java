package com.relyits.rmbs.beans_preparation.product;

import java.util.ArrayList;
import java.util.List;

import com.relyits.rmbs.beans.product.ProductBean;
import com.relyits.rmbs.beans.product.ProductLogBean;
import com.relyits.rmbs.beans_preparation.registration.BranchBeanPreparation;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.product.ProductLogModel;
import com.relyits.rmbs.model.product.ProductModel;


public class ProductLogBeanPreparation {
	
	
	 private static ProductLogBean productLogBean=null;
		
		public static ProductLogBean prepareProductLogBean(ProductLogModel productLogModel){
			productLogBean = new ProductLogBean();
				productLogBean.setId(productLogModel.getId());
				productLogBean.setDate(productLogModel.getDate());
				productLogBean.setFeildName(productLogModel.getFeildName());
				productLogBean.setNewValue(productLogModel.getNewValue());
				productLogBean.setOldValue(productLogModel.getOldValue());
				productLogBean.setUpdater(productLogModel.getUpdater());
				productLogBean.setBranchBean(BranchBeanPreparation.prepareBranchBean(productLogModel.getBranchModel()));
				productLogBean.setCreatorRoleBean(AddressBeanPreparation.prepareCreatorRoleBean(productLogModel.getCreatorRoleModel()));
				productLogBean.setProductInventoryBean(ProductInventoryBeanPreparation.prepareProductInventoryBean(productLogModel.getProductInventoryModel()));
			    
					return productLogBean;
			}
		
		public static List<ProductLogBean> prepareListofProductLogBean(List<ProductLogModel> productLogModel){
			List<ProductLogBean> productLogBeans = null;
			   if(productLogModel != null && !productLogModel.isEmpty()){		
				   productLogBeans = new ArrayList<ProductLogBean>();				
				for(ProductLogModel productLogModel1 : productLogModel){
					
					productLogBeans.add(prepareProductLogBean(productLogModel1));
					
	             }
			}
			return productLogBeans;
		}
	

}
