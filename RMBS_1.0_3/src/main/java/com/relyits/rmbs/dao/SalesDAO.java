package com.relyits.rmbs.dao;

import java.util.List;

import com.relyits.rmbs.model.product.ProductInventoryModel;
import com.relyits.rmbs.model.sales.SalesLineItemsModel;
import com.relyits.rmbs.model.sales.SalesOrderModel;


public interface SalesDAO {
	
	public SalesLineItemsModel createSalesOrder(SalesLineItemsModel salesLineItemsModel);
	
	public SalesOrderModel getSalesOrder(SalesOrderModel salesOrderModel);
	
	public SalesLineItemsModel getSalesOrderLineItemById(SalesLineItemsModel salesLineItemsModel);
	
	public SalesLineItemsModel createSalesOrderLineItems(SalesLineItemsModel salesLineItemsModel);
	
	public List<SalesLineItemsModel> updateSalesOrder(SalesLineItemsModel salesLineItemsModel);
	
	public List<SalesLineItemsModel> updateSalesLineItem(ProductInventoryModel oldProductInventoryModel,SalesLineItemsModel salesLineItemsModel);
	
	public SalesOrderModel confirmSalesOrder(List<SalesLineItemsModel> salesLineItemsModels);
	
	public List<SalesOrderModel> SalesOrderListByOrganization(SalesOrderModel SalesOrderModel);
	
	public List<SalesOrderModel> SalesOrderListByBranch(SalesOrderModel SalesOrderModel);

	public List<SalesOrderModel> SalesOrderListByOutlet(SalesOrderModel SalesOrderModel);
	
	public List<SalesLineItemsModel> getSalesLineItems(SalesLineItemsModel SalesLineItemsModel);
	
	public List<SalesLineItemsModel> SalesLineItemsListByOrganization(SalesLineItemsModel SalesLineItemsModel);
	
	public List<SalesLineItemsModel> SalesLineItemsListByBranch(SalesLineItemsModel SalesLineItemsModel);

	public List<SalesLineItemsModel> SalesLineItemsListByOutlet(SalesLineItemsModel SalesLineItemsModel);
	
	public List<SalesLineItemsModel> getSalesLineItemsModelsBySalesOrderModel(SalesOrderModel SalesOrderModel) ;

	public List<SalesOrderModel> salesOrderListByOrganization(SalesOrderModel salesOrderModel);
	
	public List<SalesOrderModel> salesOrderListByBranchOrOutlet(SalesOrderModel salesOrderModel);
}
