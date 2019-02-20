package com.relyits.rmbs.dao;

import java.util.List;

import com.relyits.rmbs.model.sales.SalesLineItemsModel;
import com.relyits.rmbs.model.sales.SalesReturnLineItemsModel;
import com.relyits.rmbs.model.sales.SalesReturnOrderModel;


public interface SalesReturnsDAO {
	
	public List<SalesReturnLineItemsModel> createSalesReturnOrder(List<SalesReturnLineItemsModel> salesReturnLineItemsModels,List<SalesLineItemsModel> salesLineItemsModel);
	
	public SalesReturnOrderModel getSalesReturnOrder(SalesReturnOrderModel salesReturnOrderModel);
	
	public SalesReturnLineItemsModel createSalesReturnOrderLineItems(SalesReturnLineItemsModel salesReturnLineItemsModel);

	public List<SalesReturnLineItemsModel> getSalesReturnLineItemsModelsBySalesReturnOrderModel(SalesReturnOrderModel salesReturnOrderModel1);
	
	/*public SalesLineItemsModel getSalesOrderLineItemById(SalesLineItemsModel salesLineItemsModel);
	
	
	public List<SalesLineItemsModel> updateSalesOrder(SalesLineItemsModel SalesLineItemsModel);
	
	public List<SalesLineItemsModel> updateSalesLineItem(ProductInventoryModel oldProductInventoryModel,SalesLineItemsModel SalesLineItemsModel);
	
	public SalesOrderModel confirmSalesOrder(List<SalesLineItemsModel> salesLineItemsModels);
	
	public List<SalesOrderModel> SalesOrderListByOrganization(SalesOrderModel SalesOrderModel);
	
	public List<SalesOrderModel> SalesOrderListByBranch(SalesOrderModel SalesOrderModel);

	public List<SalesOrderModel> SalesOrderListByOutlet(SalesOrderModel SalesOrderModel);

	public List<SalesLineItemsModel> getSalesLineItems(SalesLineItemsModel SalesLineItemsModel);
	
	public List<SalesLineItemsModel> SalesLineItemsListByOrganization(SalesLineItemsModel SalesLineItemsModel);
	
	public List<SalesLineItemsModel> SalesLineItemsListByBranch(SalesLineItemsModel SalesLineItemsModel);

	public List<SalesLineItemsModel> SalesLineItemsListByOutlet(SalesLineItemsModel SalesLineItemsModel);


    public List<SalesOrderModel> salesOrderListByOrganization(SalesOrderModel salesOrderModel);
	
	public List<SalesOrderModel> salesOrderListByBranchOrOutlet(SalesOrderModel salesOrderModel);
	*/
}
