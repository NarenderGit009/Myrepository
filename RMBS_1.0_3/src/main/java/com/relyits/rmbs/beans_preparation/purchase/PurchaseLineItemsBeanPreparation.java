package com.relyits.rmbs.beans_preparation.purchase;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.relyits.rmbs.beans.purchase.PurchaseLineItemsBean;
import com.relyits.rmbs.beans.purchase.PurchaseOrderBean;
import com.relyits.rmbs.beans.resources.PurchaseFormBean;
import com.relyits.rmbs.beans_preparation.product.ProductInventoryBeanPreparation;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;



public class PurchaseLineItemsBeanPreparation {

	private static PurchaseLineItemsBean purchaseLineItemsBean=null;
	private static List<PurchaseLineItemsBean> purchaseLineItemsBeans=null;
   
	public static PurchaseLineItemsBean preparePurchaseLineItemsBeanFromPurchaseFormBean(PurchaseFormBean purchaseFormBean) throws ParseException{
		purchaseLineItemsBean= new PurchaseLineItemsBean();
		purchaseLineItemsBean.setId(purchaseFormBean.getpOLId());
		purchaseLineItemsBean.setAmount(purchaseFormBean.getlAmt());
		purchaseLineItemsBean.setDiscount(purchaseFormBean.getDisPrcnt());
		purchaseLineItemsBean.setExpiryDate(DateAndTimeUtilities.parseStringDateToSqlDate(purchaseFormBean.getExpDate()));
		purchaseLineItemsBean.setNetPrice(purchaseFormBean.getnPr());
		purchaseLineItemsBean.setPayAmount(null);
		purchaseLineItemsBean.setPreparationCharges(purchaseFormBean.getPprChrgs());
		purchaseLineItemsBean.setQuantity(purchaseFormBean.getQntty());
		purchaseLineItemsBean.setFreeQantity(purchaseFormBean.getfQntty());
		purchaseLineItemsBean.setUnitPrice(purchaseFormBean.getuPr());
		purchaseLineItemsBean.setVat(purchaseFormBean.getVat());
		purchaseLineItemsBean.setProductInventoryBean(ProductInventoryBeanPreparation.prepareProductInventoryBeanFromPurchaseFormBean(purchaseFormBean));
		purchaseLineItemsBean.setPurchaseOrderBean(PurchaseOrderBeanPreparation.preparePurchaseOrderBeanFromPurchaseFormbean(purchaseFormBean));
		return purchaseLineItemsBean;
		
	}
	public static List<PurchaseLineItemsBean> preparePurchaseLineItemsBeansListFromPurchaseFormBeansList(List<PurchaseFormBean> purchaseFormBeans) throws ParseException{
		purchaseLineItemsBeans= new ArrayList<PurchaseLineItemsBean>();
	    for(PurchaseFormBean purchaseFormBean: purchaseFormBeans){
	    	purchaseLineItemsBeans.add(preparePurchaseLineItemsBeanFromPurchaseFormBean(purchaseFormBean));
	    }
	    return purchaseLineItemsBeans;
		
	}
	
	public static PurchaseLineItemsBean preparePurchaseLineItemsBean(PurchaseLineItemsModel purchaseLineItemsModel){
		purchaseLineItemsBean = new PurchaseLineItemsBean();
		
		  
		  Double amount = purchaseLineItemsModel.getAmount();
		  Double unitPrice = purchaseLineItemsModel.getUnitPrice();
		  Double discount = purchaseLineItemsModel.getDiscount();
		  Double netPrice = purchaseLineItemsModel.getNetPrice();
		  Double vat = purchaseLineItemsModel.getVat();
		  Double preparationCharges = purchaseLineItemsModel.getPreparationCharges();
		  Double payAmount = purchaseLineItemsModel.getPayAmount();
		  
		  purchaseLineItemsBean.setId(purchaseLineItemsModel.getId());
		  purchaseLineItemsBean.setQuantity(purchaseLineItemsModel.getQuantity());
		  purchaseLineItemsBean.setFreeQantity(purchaseLineItemsModel.getFreeQuantity());
		  purchaseLineItemsBean.setAmount(Double.parseDouble(new DecimalFormat("##.##").format(amount)));
		  purchaseLineItemsBean.setUnitPrice(Double.parseDouble(new DecimalFormat("##.##").format(unitPrice)));
		  purchaseLineItemsBean.setDiscount(Double.parseDouble(new DecimalFormat("##.##").format(discount)));
		  purchaseLineItemsBean.setNetPrice(Double.parseDouble(new DecimalFormat("##.##").format(netPrice)));
		  purchaseLineItemsBean.setVat(Double.parseDouble(new DecimalFormat("##.##").format(vat)));
		  purchaseLineItemsBean.setPreparationCharges(Double.parseDouble(new DecimalFormat("##.##").format(preparationCharges)));
		  purchaseLineItemsBean.setExpiryDate(purchaseLineItemsModel.getExpiryDate());
		  purchaseLineItemsBean.setPayAmount(Double.parseDouble(new DecimalFormat("##.##").format(payAmount)));
		  purchaseLineItemsBean.setProductInventoryBean(ProductInventoryBeanPreparation.prepareProductInventoryBean(purchaseLineItemsModel.getProductInventoryModel()));
		  purchaseLineItemsBean.setPurchaseOrderBean(PurchaseOrderBeanPreparation.preparePurchaseOrderBean(purchaseLineItemsModel.getPurchaseOrderModel()));
		  purchaseLineItemsBean.setDeliverableQuantity(purchaseLineItemsModel.getDeliverableQuantity()); 
		return purchaseLineItemsBean;
			
	}
	
	public static List<PurchaseLineItemsBean> prepareListOfPurchaseLineItemsBean(List<PurchaseLineItemsModel> purchaseLineItemsModel){
		List<PurchaseLineItemsBean> purchaseLineItemBeans = null;
		if(purchaseLineItemsModel != null && !purchaseLineItemsModel.isEmpty()){
			purchaseLineItemBeans = new ArrayList<PurchaseLineItemsBean>();				
			for(PurchaseLineItemsModel purchaseLineItemsModel1 : purchaseLineItemsModel){
				purchaseLineItemBeans.add(preparePurchaseLineItemsBean(purchaseLineItemsModel1));
				}
		}


return purchaseLineItemBeans;


}
}
