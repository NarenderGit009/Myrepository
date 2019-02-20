package com.relyits.rmbs.service;

import java.util.List;

import com.relyits.rmbs.beans.purchase.PurchaseLineItemsBean;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.model.purchase.PurchaseReturnLineItemsModel;

public interface PurchaseReturnsService {

	public List<String> getPurchaseInvoiceNo(PurchaseOrderModel purchaseOrderModel);

	public PurchaseLineItemsModel getPurchaseLineItemsById(PurchaseLineItemsModel purchaseLineItemsModel);

	public List<PurchaseLineItemsBean> getPurchaseLineItemsByPOId(PurchaseOrderModel purchaseOrderModel);

	public int createPurchaseReturnOrder(PurchaseReturnLineItemsModel purchaseReturnLineItemsModel, int id);

}
