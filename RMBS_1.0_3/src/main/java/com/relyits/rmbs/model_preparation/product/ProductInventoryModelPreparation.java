package com.relyits.rmbs.model_preparation.product;

import java.text.ParseException;

import com.relyits.rmbs.beans.product.ProductInventoryBean;
import com.relyits.rmbs.beans.resources.PurchaseFormBean;
import com.relyits.rmbs.model.product.ProductInventoryModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.registration.AgencyModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model_preparation.registration.AgencyModelPreparation;
import com.relyits.rmbs.model_preparation.registration.BranchModelPreparation;
import com.relyits.rmbs.model_preparation.resource.AddressModelPreparation;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;


public class ProductInventoryModelPreparation {
			
	private static ProductInventoryModel productInventoryModel=null;
	private static AgencyModel agencyModel=null;
	private static BranchModel branchModel=null;
	private static RoleModel creatorRoleModel=null;

	public static ProductInventoryModel prepareProductInventoryModel(ProductInventoryBean productInventoryBean) throws ParseException{

		branchModel = new BranchModel();
		agencyModel = new AgencyModel();
		creatorRoleModel = new RoleModel();
		
		productInventoryModel=new ProductInventoryModel();
		productInventoryModel.setBatchNo(productInventoryBean.getBatchNo());
		productInventoryModel.setId(productInventoryBean.getId());
		productInventoryModel.setPrice(productInventoryBean.getPrice());
		productInventoryModel.setDlPrice(productInventoryBean.getDlPrice());
		productInventoryModel.setQuantity(productInventoryBean.getQuantity());
		productInventoryModel.setVat(11.00);
		productInventoryModel.setPwVat(11.00);
		productInventoryModel.setVatPrice(11.00);
		productInventoryModel.setExpiryDate(DateAndTimeUtilities.parseStringDateToSqlDate(productInventoryBean.getExpiryDate()));
		productInventoryModel.setProductModel(ProductModelPreparation.prepareProductModel(productInventoryBean.getProductBean()));
        productInventoryModel.setCreatedBy(productInventoryBean.getCreatedBy());
        productInventoryModel.setCreatedDate(DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime()));
        productInventoryModel.setUpdatedDate(DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime()));
       
        branchModel.setId(productInventoryBean.getBranchBean().getId());
        agencyModel.setId(productInventoryBean.getAgencyBean().getId());
        creatorRoleModel.setId(productInventoryBean.getCreatorRoleBean().getId());
        productInventoryModel.setBranchModel(branchModel);
        productInventoryModel.setAgencyModel(agencyModel);
        productInventoryModel.setCreatorRoleModel(creatorRoleModel);
        
        /* productInventoryModel.setBranchModel(BranchModelPreparation.prepareBranchModel(productInventoryBean.getBranchBean()));
        productInventoryModel.setAgencyModel(AgencyModelPreparation.prepareAgencyModel(productInventoryBean.getAgencyBean()));
        productInventoryModel.setCreatorRoleModel(AddressModelPreparation.prepareRoleModel(productInventoryBean.getCreatorRoleBean()));
        */
		return productInventoryModel;
	}
	public static ProductInventoryModel prepareProductInventoryModelFromPurchaseFormBean(PurchaseFormBean purchaseFormBean) throws ParseException{
		productInventoryModel=new ProductInventoryModel();
		productInventoryModel.setBatchNo(purchaseFormBean.getBatNo());
		productInventoryModel.setId(purchaseFormBean.getPiId());
		productInventoryModel.setPrice(purchaseFormBean.getPr());
		productInventoryModel.setDlPrice(purchaseFormBean.getuPr());
		productInventoryModel.setQuantity(purchaseFormBean.getQntty()+purchaseFormBean.getfQntty());
		productInventoryModel.setVat(purchaseFormBean.getVat());
		productInventoryModel.setPwVat(purchaseFormBean.getpWVat());
		productInventoryModel.setVatPrice(purchaseFormBean.getVatPr());
		productInventoryModel.setExpiryDate(DateAndTimeUtilities.parseStringDateToSqlDate(purchaseFormBean.getExpDate()));
		productInventoryModel.setCreatedBy(purchaseFormBean.getcById());
        productInventoryModel.setCreatedDate(DateAndTimeUtilities.getCurrentDateTimeInSqlFormat());
        productInventoryModel.setUpdatedDate(DateAndTimeUtilities.getCurrentDateTimeInSqlFormat());
        productInventoryModel.setProductModel(ProductModelPreparation.prepareProductModelFormPurchaseFormBean(purchaseFormBean));
        productInventoryModel.setBranchModel(BranchModelPreparation.prepareBranchModelFromPurchaseFormBean(purchaseFormBean));
        productInventoryModel.setAgencyModel(AgencyModelPreparation.prepareAgencyModelFromPurchaseFormBean(purchaseFormBean));
        productInventoryModel.setCreatorRoleModel(AddressModelPreparation.prepareCreatorRoleModelFromPurchaseFormBean(purchaseFormBean));
        return productInventoryModel;
	}
	
}
