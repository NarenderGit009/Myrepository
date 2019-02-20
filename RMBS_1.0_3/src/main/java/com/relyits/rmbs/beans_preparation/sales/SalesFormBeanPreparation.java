package com.relyits.rmbs.beans_preparation.sales;

import java.util.ArrayList;
import java.util.List;

import com.relyits.rmbs.beans.sales.SalesFormBean;
import com.relyits.rmbs.beans.sales.SalesLineItemsBean;
import com.relyits.rmbs.beans_preparation.product.ProductInventoryBeanPreparation;
import com.relyits.rmbs.beans_preparation.registration.OutletBeanPreparation;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.sales.SalesLineItemsModel;
import com.relyits.rmbs.model_preparation.registration.OutletModelPreparation;



public class SalesFormBeanPreparation {

	private static SalesFormBean salesFormBean=null;
	private static List<SalesFormBean> salesFormBeans=null;
	
	public static SalesFormBean prepareSalesFormBean(SalesLineItemsModel salesLineItemsModel){
		
		salesFormBean=new SalesFormBean();
		
		salesFormBean.setlAmt(salesLineItemsModel.getAmount());
		salesFormBean.setBatNo(salesLineItemsModel.getProductInventoryModel().getBatchNo());
		salesFormBean.setBlDtAndTm(salesLineItemsModel.getSalesOrderModel().getBillingDateAndTime()+"");
		salesFormBean.setCat(salesLineItemsModel.getProductInventoryModel().getProductModel().getCategoryModel().getCategory());
		salesFormBean.setDisPr(salesLineItemsModel.getDiscount());
		salesFormBean.setDisPrcnt(salesLineItemsModel.getDiscount());
		salesFormBean.setDlvDt(salesLineItemsModel.getSalesOrderModel().getBillingDateAndTime()+"");
		salesFormBean.setExpDate(salesLineItemsModel.getProductInventoryModel().getExpiryDate()+"");
		salesFormBean.setmFC(salesLineItemsModel.getProductInventoryModel().getProductModel().getmFCompanay());
		salesFormBean.setnPr(salesLineItemsModel.getNetPrice());
		salesFormBean.setOrdAmt(salesLineItemsModel.getSalesOrderModel().getPayAmount());
		salesFormBean.setOrdAmt_wt_vat_and_Dis(salesLineItemsModel.getSalesOrderModel().getAmount());
		salesFormBean.setOverall_disPrcnt(salesLineItemsModel.getSalesOrderModel().getOverallDiscount());
		salesFormBean.setpName(salesLineItemsModel.getProductInventoryModel().getProductModel().getName());
		salesFormBean.setPprChrgs(salesLineItemsModel.getPreparationCharges());
		salesFormBean.setPr(salesLineItemsModel.getUnitPrice());
		salesFormBean.setpWVat(salesLineItemsModel.getNetPrice());
		salesFormBean.setQntty(salesLineItemsModel.getQuantity());
		salesFormBean.setRowId(salesLineItemsModel.getId());
		salesFormBean.setCat(salesLineItemsModel.getProductInventoryModel().getProductModel().getCategoryModel().getCategory());
		salesFormBean.setsCat(salesLineItemsModel.getProductInventoryModel().getProductModel().getSubCategoryModel().getCategory());
		salesFormBean.setSchD(salesLineItemsModel.getProductInventoryModel().getProductModel().getSchDrug());
		salesFormBean.setsOId(salesLineItemsModel.getSalesOrderModel().getId());
		salesFormBean.setsOLId(salesLineItemsModel.getId());
		salesFormBean.setTotDis(salesLineItemsModel.getSalesOrderModel().getDiscountPrice());
		salesFormBean.setTotVat(salesLineItemsModel.getSalesOrderModel().getTotalVAT());
		salesFormBean.setuPr(salesLineItemsModel.getProductInventoryModel().getPrice());
		salesFormBean.setVat(salesLineItemsModel.getVat());
		salesFormBean.setVatPr(salesLineItemsModel.getVat());
		
			return salesFormBean;

	}
	
	public static List<SalesFormBean> prepareSalesFormBeansList(List<SalesLineItemsModel> salesLineItemsModels){
	
		salesFormBeans=new ArrayList<SalesFormBean>();
		
		for(SalesLineItemsModel salesLineItemsModel:salesLineItemsModels){
			salesFormBeans.add(prepareSalesFormBean(salesLineItemsModel));
		}
		
		return salesFormBeans;
	
	}
}