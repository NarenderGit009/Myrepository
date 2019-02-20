package com.relyits.rmbs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relyits.rmbs.dao.ProductDAO;
import com.relyits.rmbs.dao.PurchaseDAO;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.service.ProductService;
import com.relyits.rmbs.service.PurchaseService;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService{

	@Autowired
	private PurchaseDAO purchaseDAO;
	
	
	public int createPurchaseOrder(List<PurchaseLineItemsModel> purchaseLineItemsModel){
    return purchaseDAO.createPurchaseOrder(purchaseLineItemsModel);
	}


	@Override
	public List<PurchaseOrderModel> purchaseOrderListByOrganization(PurchaseOrderModel purchaseOrderModel) {
		return purchaseDAO.purchaseOrderListByOrganization(purchaseOrderModel);
	}


	@Override
	public List<PurchaseOrderModel> purchaseOrderListByBranch(PurchaseOrderModel purchaseOrderModel) {
		return purchaseDAO.purchaseOrderListByBranch(purchaseOrderModel);
	}


	@Override
	public List<PurchaseOrderModel> purchaseOrderListByOutlet(PurchaseOrderModel purchaseOrderModel) {
		return purchaseDAO.purchaseOrderListByOutlet(purchaseOrderModel);
	}


	@Override
	public List<PurchaseLineItemsModel> getPurchaseLineItems(PurchaseLineItemsModel purchaseLineItemsModel) {
			return purchaseDAO.getPurchaseLineItems(purchaseLineItemsModel);
	}


	@Override
	public List<PurchaseLineItemsModel> purchaseLineItemsListByOrganization(PurchaseLineItemsModel purchaseLineItemsModel) {
		return purchaseDAO.purchaseLineItemsListByOrganization(purchaseLineItemsModel);
	}


	@Override
	public List<PurchaseLineItemsModel> purchaseLineItemsListByBranch(PurchaseLineItemsModel purchaseLineItemsModel) {
		return purchaseDAO.purchaseLineItemsListByBranch(purchaseLineItemsModel);
	}


	@Override
	public List<PurchaseLineItemsModel> purchaseLineItemsListByOutlet(PurchaseLineItemsModel purchaseLineItemsModel) {
		return purchaseDAO.purchaseLineItemsListByOutlet(purchaseLineItemsModel);
	}


	@Override
	public List<PurchaseLineItemsModel> getPurchaseLineItemsModelsByPurcheseOrderModel(PurchaseOrderModel purchaseOrderModel) {
		return purchaseDAO.getPurchaseLineItemsModelsByPurcheseOrderModel(purchaseOrderModel);
	}
	
	@Override
	public List<String> getPurchaseInvoiceNo(PurchaseOrderModel purchaseOrderModel) {
		return purchaseDAO.getPurchaseInvoiceNo(purchaseOrderModel);
	}
}
