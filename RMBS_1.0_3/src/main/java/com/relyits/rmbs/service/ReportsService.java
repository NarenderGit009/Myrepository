package com.relyits.rmbs.service;



import java.util.Date;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;

import com.relyits.rmbs.beans.purchase.PurchaseLineItemsBean;
import com.relyits.rmbs.beans.purchase.PurchaseOrderBean;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;


public interface ReportsService {

	// ********product reports service*******
	
	public JRDataSource retrieveAllExistedProucts();	
	
	public JRDataSource productStockListBybranch(int branchId);

	// ********purchase reports service*******

	public List<PurchaseOrderBean> purchaseOrderReports(Date fromDate,Date toDate,int branchId);

	public JRDataSource purchaseOrderListReports(PurchaseOrderModel purchaseOrderModel);

	public List<PurchaseLineItemsBean> purchaseOrderLineitemsReports(PurchaseOrderModel purchaseOrderModel);

}
