package com.relyits.rmbs.beans_preparation.purchase;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;

import com.ibm.icu.text.DecimalFormat;
import com.relyits.rmbs.beans.purchase.PurchaseOrderBean;
import com.relyits.rmbs.beans.resources.PurchaseFormBean;
import com.relyits.rmbs.beans.resources.StatusBean;
import com.relyits.rmbs.beans_preparation.product.ProductInventoryBeanPreparation;
import com.relyits.rmbs.beans_preparation.registration.AgencyBeanPreparation;
import com.relyits.rmbs.beans_preparation.registration.BranchBeanPreparation;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;

public class PurchaseOrderBeanPreparation {

	private static PurchaseOrderBean purchaseOrderBean=null;

	public static PurchaseOrderBean preparePurchaseOrderBeanFromPurchaseFormbean(PurchaseFormBean purchaseFormBean) throws ParseException{
		purchaseOrderBean = new PurchaseOrderBean();
		purchaseOrderBean.setAmount(purchaseFormBean.getOrdAmt());
		purchaseOrderBean.setBillingDateAndTime(DateAndTimeUtilities.parseStringDateToSqlDate(purchaseFormBean.getBlDtAndTm()));
		purchaseOrderBean.setDeliveryDate(DateAndTimeUtilities.getCurrentDateTimeInSqlFormat());
		purchaseOrderBean.setDiscountPrice(purchaseFormBean.getTotDis());
		purchaseOrderBean.setId(purchaseFormBean.getpOId());
		purchaseOrderBean.setInvoiceNo(purchaseFormBean.getInvNo());
		purchaseOrderBean.setOrderIdByDate(purchaseFormBean.getInvNo());
		purchaseOrderBean.setPayAmount(purchaseFormBean.getOrdAmt());
		purchaseOrderBean.setTotalVAT(purchaseFormBean.getTotVat());
		purchaseOrderBean.setBranchBean(BranchBeanPreparation.prepareBranchBeanFromPurchaseFormBean(purchaseFormBean));
		purchaseOrderBean.setProductInventoryBean(ProductInventoryBeanPreparation.prepareProductInventoryBeanFromPurchaseFormBean(purchaseFormBean));
		return purchaseOrderBean;

	}
	
	public static PurchaseOrderBean preparePurchaseOrderBean(PurchaseOrderModel purchaseOrderModel){
		
				purchaseOrderBean = new PurchaseOrderBean();			
				
				purchaseOrderBean.setId(purchaseOrderModel.getId());
				purchaseOrderBean.setAmount(Double.parseDouble(new DecimalFormat("##.##").format(purchaseOrderModel.getAmount())));
				purchaseOrderBean.setOverallDiscount(Double.parseDouble(new DecimalFormat("##.##").format(purchaseOrderModel.getOverallDiscount())));
				purchaseOrderBean.setBillingDateAndTime(purchaseOrderModel.getBillingDateAndTime());
				purchaseOrderBean.setDeliveryDate(purchaseOrderModel.getDeliveryDate());
				purchaseOrderBean.setOrderIdByDate(purchaseOrderModel.getOrderIdbyDate());
				purchaseOrderBean.setDiscountPrice(Double.parseDouble(new DecimalFormat("##.##").format(purchaseOrderModel.getDiscountPrice())));
				purchaseOrderBean.setInvoiceNo(purchaseOrderModel.getInvoiceNo());
				purchaseOrderBean.setPayAmount(Double.parseDouble(new DecimalFormat("##.##").format(purchaseOrderModel.getPayAmount())));
				purchaseOrderBean.setTotalVAT(Double.parseDouble(new DecimalFormat("##.##").format(purchaseOrderModel.getTotalVAT())));
				purchaseOrderBean.setAgencyBean(AgencyBeanPreparation.prepareAgencyBean(purchaseOrderModel.getAgencyModel()));
				purchaseOrderBean.setBranchBean(BranchBeanPreparation.prepareBranchBean(purchaseOrderModel.getBranchModel()));
								
		return purchaseOrderBean;


}
	

public static List<PurchaseOrderBean> prepareListOfPurchaseOrderBean(List<PurchaseOrderModel> purchases){
			List<PurchaseOrderBean> purchaseOrderBeans = null;
			if(purchases != null && !purchases.isEmpty()){
				purchaseOrderBeans = new ArrayList<PurchaseOrderBean>();				
				for(PurchaseOrderModel purchaseOrderModel : purchases){
					purchaseOrderBeans.add(preparePurchaseOrderBean(purchaseOrderModel));
					}
			}
	
	
	return purchaseOrderBeans;
	
	
}
public static PurchaseOrderBean preparePurchaseOrderBeanForRevenueAccounts(PurchaseOrderModel purchaseOrderModel){
	
	purchaseOrderBean = new PurchaseOrderBean();			
	
	purchaseOrderBean.setId(purchaseOrderModel.getId());
	purchaseOrderBean.setAmount(purchaseOrderModel.getAmount());
	purchaseOrderBean.setBillingDateAndTime(purchaseOrderModel.getBillingDateAndTime());
	purchaseOrderBean.setOrderIdByDate(purchaseOrderModel.getOrderIdbyDate());
	purchaseOrderBean.setDiscountPrice(purchaseOrderModel.getDiscountPrice());
	purchaseOrderBean.setPayAmount(purchaseOrderModel.getPayAmount());
	purchaseOrderBean.setTotalVAT(purchaseOrderModel.getTotalVAT());
	purchaseOrderBean.setBranchBean(BranchBeanPreparation.prepareBranchBean(purchaseOrderModel.getBranchModel()));
					
return purchaseOrderBean;


}

public static List<PurchaseOrderBean> prepareListOfPurchaseOrderBeanForRevenueAccounts(List<PurchaseOrderModel> purchases){
	List<PurchaseOrderBean> purchaseOrderBeans = null;
	if(purchases != null && !purchases.isEmpty()){
		purchaseOrderBeans = new ArrayList<PurchaseOrderBean>();				
		for(PurchaseOrderModel purchaseOrderModel : purchases){
			purchaseOrderBeans.add(preparePurchaseOrderBeanForRevenueAccounts(purchaseOrderModel));
			}
	}


return purchaseOrderBeans;


}
}