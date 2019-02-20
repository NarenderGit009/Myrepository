package com.relyits.rmbs.beans_preparation.product;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.relyits.rmbs.beans.product.ProductInventoryBean;
import com.relyits.rmbs.beans.resources.PurchaseFormBean;
import com.relyits.rmbs.beans_preparation.registration.AgencyBeanPreparation;
import com.relyits.rmbs.beans_preparation.registration.BranchBeanPreparation;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.product.ProductInventoryModel;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;



public class ProductInventoryBeanPreparation {
	
	private static ProductInventoryBean productInventoryBean=null;
	

	
	public static ProductInventoryBean prepareProductInventoryBean(ProductInventoryModel productInventoryModel){
		productInventoryBean=new ProductInventoryBean();
		productInventoryBean.setBatchNo(productInventoryModel.getBatchNo());
		productInventoryBean.setId(productInventoryModel.getId());
		productInventoryBean.setPrice(productInventoryModel.getPrice());
		productInventoryBean.setDlPrice(productInventoryModel.getDlPrice());
		productInventoryBean.setQuantity(productInventoryModel.getQuantity());
		productInventoryBean.setVat(productInventoryModel.getVat());
		productInventoryBean.setPwVat(productInventoryModel.getPwVat());
		productInventoryBean.setVatPrice(productInventoryModel.getVatPrice());
		productInventoryBean.setExpiryDate(""+productInventoryModel.getExpiryDate()+"");
		productInventoryBean.setProductBean(ProductBeanPreparation.prepareProductBean(productInventoryModel.getProductModel()));
        productInventoryBean.setCreatedBy(productInventoryModel.getCreatedBy());
        productInventoryBean.setBranchBean(BranchBeanPreparation.prepareBranchBean(productInventoryModel.getBranchModel()));
        productInventoryBean.setAgencyBean(AgencyBeanPreparation.prepareAgencyBean(productInventoryModel.getAgencyModel()));
        productInventoryBean.setCreatorRoleBean(AddressBeanPreparation.prepareRoleBean(productInventoryModel.getCreatorRoleModel()));
        productInventoryBean.setCreatedDate(productInventoryModel.getCreatedDate());
        productInventoryBean.setUpdatedDate(productInventoryModel.getUpdatedDate());
      
        
        
		
		return productInventoryBean;
	}



	public static List<ProductInventoryBean> prepareListofProductInventoryBeanromExpairyProductInventoryModel(List<ProductInventoryModel> products) throws ParseException{
		List<ProductInventoryBean> productInventoryBeans = null;
		   if(products != null && !products.isEmpty()){		
			   productInventoryBeans = new ArrayList<ProductInventoryBean>();			
			for(ProductInventoryModel productInventoryModel : products){	
				productInventoryBean=prepareProductInventoryBean(productInventoryModel);
				productInventoryBean.setExpiryDays(DateAndTimeUtilities.getDaysDifference(productInventoryModel.getExpiryDate()));
				productInventoryBeans.add(productInventoryBean);	
				
				
             }
		}
		return productInventoryBeans;
	}
	public static List<ProductInventoryBean> prepareListofProductInventoryBean(List<ProductInventoryModel> products){
		List<ProductInventoryBean> productInventoryBeans = null;
		   if(products != null && !products.isEmpty()){		
			   productInventoryBeans = new ArrayList<ProductInventoryBean>();			
			for(ProductInventoryModel productInventoryModel : products){	
		        
				productInventoryBeans.add(prepareProductInventoryBean(productInventoryModel));	
				
				
             }
		}
		return productInventoryBeans;
	}
	public static ProductInventoryBean prepareProductInventoryBeanFromPurchaseFormBean(PurchaseFormBean purchaseFormBean) throws ParseException{
		productInventoryBean=new ProductInventoryBean();
		productInventoryBean.setBatchNo(purchaseFormBean.getBatNo());
		productInventoryBean.setId(purchaseFormBean.getPiId());
		productInventoryBean.setPrice(purchaseFormBean.getPr());
		productInventoryBean.setDlPrice(purchaseFormBean.getuPr());
		productInventoryBean.setQuantity(purchaseFormBean.getQntty()+purchaseFormBean.getfQntty());
		productInventoryBean.setVat(purchaseFormBean.getVat());
		productInventoryBean.setPwVat(purchaseFormBean.getpWVat());
		productInventoryBean.setVatPrice(purchaseFormBean.getVatPr());
		productInventoryBean.setExpiryDate(purchaseFormBean.getExpDate());
		productInventoryBean.setCreatedBy(purchaseFormBean.getcById());
        productInventoryBean.setCreatedDate(DateAndTimeUtilities.getCurrentDateTimeInSqlFormat());
        productInventoryBean.setUpdatedDate(DateAndTimeUtilities.getCurrentDateTimeInSqlFormat());
        productInventoryBean.setProductBean(ProductBeanPreparation.prepareProductBeanFormPurchaseFormBean(purchaseFormBean));
        productInventoryBean.setBranchBean(BranchBeanPreparation.prepareBranchBeanFromPurchaseFormBean(purchaseFormBean));
        productInventoryBean.setAgencyBean(AgencyBeanPreparation.prepareAgencyBeanFromPurchaseFormBean(purchaseFormBean));
        productInventoryBean.setCreatorRoleBean(AddressBeanPreparation.prepareCreatorRoleBeanFromPurchaseFormBean(purchaseFormBean));
        return productInventoryBean;
	}
}
