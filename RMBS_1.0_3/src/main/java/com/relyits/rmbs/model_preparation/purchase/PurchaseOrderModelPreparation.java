package com.relyits.rmbs.model_preparation.purchase;

import java.text.ParseException;

import com.relyits.rmbs.beans.resources.PurchaseFormBean;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.model_preparation.registration.AgencyModelPreparation;
import com.relyits.rmbs.model_preparation.registration.BranchModelPreparation;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;



public class PurchaseOrderModelPreparation {
	
	private static PurchaseOrderModel purchaseOrderModel=null;

	public static PurchaseOrderModel preparePurchaseOrderModelFromPurchaseFormbean(PurchaseFormBean purchaseFormBean) throws ParseException{
		purchaseOrderModel = new PurchaseOrderModel();
		//purchaseOrderModel.setAmount(purchaseFormBean.getOrdAmt()+purchaseFormBean.getTotDis()-purchaseFormBean.getTotVat());
		purchaseOrderModel.setAmount(purchaseFormBean.getOrdAmt_wt_vat_and_Dis());
		purchaseOrderModel.setOverallDiscount(purchaseFormBean.getOverall_disPrcnt());
		purchaseOrderModel.setBillingDateAndTime(DateAndTimeUtilities.parseStringDateToSqlDate(purchaseFormBean.getExpDate()));
		purchaseOrderModel.setDeliveryDate(DateAndTimeUtilities.getCurrentDateTimeInSqlFormat());
		purchaseOrderModel.setDiscountPrice(purchaseFormBean.getTotDis());
		purchaseOrderModel.setId(purchaseFormBean.getpOId());
		purchaseOrderModel.setInvoiceNo(purchaseFormBean.getInvNo());
		purchaseOrderModel.setOrderIdByDate(""+DateAndTimeUtilities.getCurrentDateTimeInSqlFormat()+"");
		purchaseOrderModel.setPayAmount(purchaseFormBean.getOrdAmt());
		purchaseOrderModel.setTotalVAT(purchaseFormBean.getTotVat());
		purchaseOrderModel.setBranchModel(BranchModelPreparation.prepareBranchModelFromPurchaseFormBean(purchaseFormBean));
	    purchaseOrderModel.setAgencyModel(AgencyModelPreparation.prepareAgencyModelFromPurchaseFormBean(purchaseFormBean));
		return purchaseOrderModel;

	}
	

}
