package com.relyits.rmbs.service;



import java.util.Date;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;

import com.relyits.rmbs.beans.purchase.PurchaseLineItemsBean;
import com.relyits.rmbs.beans.purchase.PurchaseOrderBean;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.model.sales.SalesOrderModel;


public interface RevenueService {

	public List<PurchaseOrderModel> revenuePurchaseOrder(Date fromDate, Date toDate,int branchId);

	public List<SalesOrderModel> revenueSalesOrder(java.util.Date fromDate,Date toDate,int branchId,int catId);

}
