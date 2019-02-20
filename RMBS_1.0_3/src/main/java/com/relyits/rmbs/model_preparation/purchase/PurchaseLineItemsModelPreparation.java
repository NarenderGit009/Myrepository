package com.relyits.rmbs.model_preparation.purchase;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.relyits.rmbs.beans.resources.PurchaseFormBean;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model_preparation.product.ProductInventoryModelPreparation;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;



public class PurchaseLineItemsModelPreparation {

	private static PurchaseLineItemsModel purchaseLineItemsModel=null;
	private static List<PurchaseLineItemsModel> purchaseLineItemsModels=null;
   
	public static PurchaseLineItemsModel preparepurchaseLineItemsModelFromPurchaseFormBean(PurchaseFormBean purchaseFormBean) throws ParseException{
		purchaseLineItemsModel= new PurchaseLineItemsModel();
		purchaseLineItemsModel.setId(purchaseFormBean.getpOLId());
		purchaseLineItemsModel.setAmount(getAmount(purchaseFormBean));
		purchaseLineItemsModel.setDiscount(purchaseFormBean.getDisPrcnt());
		purchaseLineItemsModel.setExpiryDate(DateAndTimeUtilities.parseStringDateToSqlDate(purchaseFormBean.getExpDate()));
		purchaseLineItemsModel.setNetPrice(purchaseFormBean.getnPr());
		purchaseLineItemsModel.setPayAmount(purchaseFormBean.getlAmt());
		purchaseLineItemsModel.setPreparationCharges(purchaseFormBean.getPprChrgs());
		purchaseLineItemsModel.setQuantity(purchaseFormBean.getQntty());
		purchaseLineItemsModel.setFreeQuantity(purchaseFormBean.getfQntty());
		purchaseLineItemsModel.setUnitPrice(purchaseFormBean.getuPr());
		purchaseLineItemsModel.setVat(purchaseFormBean.getVat());
		purchaseLineItemsModel.setProductInventoryModel(ProductInventoryModelPreparation.prepareProductInventoryModelFromPurchaseFormBean(purchaseFormBean));
		purchaseLineItemsModel.setPurchaseOrderModel(PurchaseOrderModelPreparation.preparePurchaseOrderModelFromPurchaseFormbean(purchaseFormBean));
		return purchaseLineItemsModel;
		
	}
	public static List<PurchaseLineItemsModel> preparepurchaseLineItemsModelsListFromPurchaseFormBeansList(List<PurchaseFormBean> purchaseFormBeans) throws ParseException{
		purchaseLineItemsModels= new ArrayList<PurchaseLineItemsModel>();
	    for(PurchaseFormBean purchaseFormBean: purchaseFormBeans){
	    	purchaseLineItemsModels.add(preparepurchaseLineItemsModelFromPurchaseFormBean(purchaseFormBean));
	    }
	    return purchaseLineItemsModels;
		
	}
	private static double getAmount(PurchaseFormBean purchaseFormBean){
		double lineAmount=0.0;
		double amount=0.0;
		double vat_Percent=0.0;
		double dis_Percent=0.0;
	//	double lineItem_Dis_Amount=0.0;
	//	double lineItem_Vat_Amount=0.0;
		
		lineAmount=purchaseFormBean.getlAmt();
		vat_Percent=purchaseFormBean.getVat();
		dis_Percent=purchaseFormBean.getDisPrcnt();
		
		amount=(lineAmount*100*100)/((100+vat_Percent)*(100-dis_Percent));
		return Double.parseDouble(new DecimalFormat("##.##").format(amount));
		 
		
	}
}
