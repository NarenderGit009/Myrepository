package com.relyits.rmbs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relyits.rmbs.beans.purchase.PurchaseLineItemsBean;
import com.relyits.rmbs.dao.PurchaseReturnsDAO;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.model.purchase.PurchaseReturnLineItemsModel;
import com.relyits.rmbs.service.PurchaseReturnsService;

@Service("purchaseReturnService")
public class PurchaseReturnsServiceImpl implements PurchaseReturnsService{

	@Autowired
	private PurchaseReturnsDAO purchaseReturnsDAO;
	
	public List<String> getPurchaseInvoiceNo(
			PurchaseOrderModel purchaseOrderModel) {
		return purchaseReturnsDAO.getPurchaseInvoiceNo(purchaseOrderModel);
	}

	
	public PurchaseLineItemsModel getPurchaseLineItemsById(PurchaseLineItemsModel purchaseLineItemsModel) {
	return purchaseReturnsDAO.getPurchaseLineItemsById(purchaseLineItemsModel);
	}


	
	public List<PurchaseLineItemsBean> getPurchaseLineItemsByPOId(PurchaseOrderModel purchaseOrderModel) {
		return purchaseReturnsDAO.getPurchaseLineItemsByPOId(purchaseOrderModel);
	}


	@Override
	public int createPurchaseReturnOrder(PurchaseReturnLineItemsModel purchaseReturnLineItemsModel , int id) {
		return purchaseReturnsDAO.createPurchaseReturnOrder(purchaseReturnLineItemsModel,id);
	}
}
