package com.relyits.rmbs.dao;

import java.util.List;


import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;

public interface PurchaseDAO {
	public int createPurchaseOrder(List<PurchaseLineItemsModel> purchaseLineItemsModel);
	
	public List<PurchaseOrderModel> purchaseOrderListByOrganization(PurchaseOrderModel purchaseOrderModel);
	
	public List<PurchaseOrderModel> purchaseOrderListByBranch(PurchaseOrderModel purchaseOrderModel);

	public List<PurchaseOrderModel> purchaseOrderListByOutlet(PurchaseOrderModel purchaseOrderModel);
	
	public List<PurchaseLineItemsModel> getPurchaseLineItems(PurchaseLineItemsModel purchaseLineItemsModel);
	
	public List<PurchaseLineItemsModel> purchaseLineItemsListByOrganization(PurchaseLineItemsModel purchaseLineItemsModel);
	
	public List<PurchaseLineItemsModel> purchaseLineItemsListByBranch(PurchaseLineItemsModel purchaseLineItemsModel);

	public List<PurchaseLineItemsModel> purchaseLineItemsListByOutlet(PurchaseLineItemsModel purchaseLineItemsModel);
	
	public List<PurchaseLineItemsModel> getPurchaseLineItemsModelsByPurcheseOrderModel(PurchaseOrderModel purchaseOrderModel) ;
	
    public List<String> getPurchaseInvoiceNo(PurchaseOrderModel purchaseOrderModel);

}
