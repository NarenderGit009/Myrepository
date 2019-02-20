package com.relyits.rmbs.dao;





import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;

import com.relyits.rmbs.beans.purchase.PurchaseLineItemsBean;
import com.relyits.rmbs.beans.purchase.PurchaseOrderBean;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;

public interface ReportsDAO {
	
	// product reports DAO
	
	public JRDataSource retrieveAllExistedProucts();

	public JRDataSource productStockListBybranch(int branchId);

	// purchase reports DAO
	
	public List<PurchaseOrderBean> purchaseOrderReports(Date fromDate, Date toDate,int branchId);

	public JRDataSource purchaseOrderListReports(PurchaseOrderModel purchaseOrderModel);

	public List<PurchaseLineItemsBean> purchaseOrderLineitemsReports(PurchaseOrderModel purchaseOrderModel);

}
