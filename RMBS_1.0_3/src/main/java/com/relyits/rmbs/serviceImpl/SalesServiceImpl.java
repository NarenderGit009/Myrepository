package com.relyits.rmbs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relyits.rmbs.dao.ProductDAO;
import com.relyits.rmbs.dao.SalesDAO;
import com.relyits.rmbs.model.product.ProductInventoryModel;
import com.relyits.rmbs.model.sales.SalesLineItemsModel;
import com.relyits.rmbs.model.sales.SalesOrderModel;
import com.relyits.rmbs.service.SalesService;

@Service("SalesService")
public class SalesServiceImpl implements SalesService{

	@Autowired
	private SalesDAO salesDAO;
	
	
	public SalesLineItemsModel createSalesOrder(SalesLineItemsModel salesLineItemsModel){
		return salesDAO.createSalesOrder(salesLineItemsModel);
	}
	
	public SalesOrderModel getSalesOrder(SalesOrderModel salesOrderModel){
		return salesDAO.getSalesOrder(salesOrderModel);
	}
	
	public SalesLineItemsModel getSalesOrderLineItemById(SalesLineItemsModel salesLineItemsModel){
		return salesDAO.getSalesOrderLineItemById(salesLineItemsModel);
	}
	public SalesLineItemsModel createSalesOrderLineItems(SalesLineItemsModel salesLineItemsModel){
		 return salesDAO.createSalesOrderLineItems(salesLineItemsModel);	
	}
	
	public List<SalesLineItemsModel> updateSalesOrder(SalesLineItemsModel SalesLineItemsModel){
		return salesDAO.updateSalesOrder(SalesLineItemsModel);
	}
	
	public List<SalesLineItemsModel> updateSalesLineItem(ProductInventoryModel oldProductInventoryModel,SalesLineItemsModel salesLineItemsModel){
		return salesDAO.updateSalesLineItem(oldProductInventoryModel,salesLineItemsModel);
	}
	
	public SalesOrderModel confirmSalesOrder(List<SalesLineItemsModel> salesLineItemsModels){
		return salesDAO.confirmSalesOrder(salesLineItemsModels);
	}
	
	public List<SalesOrderModel> SalesOrderListByOrganization(SalesOrderModel salesOrderModel) {
		return salesDAO.SalesOrderListByOrganization(salesOrderModel);
	}


	@Override
	public List<SalesOrderModel> SalesOrderListByBranch(SalesOrderModel salesOrderModel) {
		return salesDAO.SalesOrderListByBranch(salesOrderModel);
	}


	@Override
	public List<SalesOrderModel> SalesOrderListByOutlet(SalesOrderModel salesOrderModel) {
		return salesDAO.SalesOrderListByOutlet(salesOrderModel);
	}


	@Override
	public List<SalesLineItemsModel> getSalesLineItems(SalesLineItemsModel salesLineItemsModel) {
			return salesDAO.getSalesLineItems(salesLineItemsModel);
	}


	@Override
	public List<SalesLineItemsModel> SalesLineItemsListByOrganization(SalesLineItemsModel salesLineItemsModel) {
		return salesDAO.SalesLineItemsListByOrganization(salesLineItemsModel);
	}


	@Override
	public List<SalesLineItemsModel> SalesLineItemsListByBranch(SalesLineItemsModel salesLineItemsModel) {
		return salesDAO.SalesLineItemsListByBranch(salesLineItemsModel);
	}


	@Override
	public List<SalesLineItemsModel> SalesLineItemsListByOutlet(SalesLineItemsModel salesLineItemsModel) {
		return salesDAO.SalesLineItemsListByOutlet(salesLineItemsModel);
	}


	@Override
	public List<SalesLineItemsModel> getSalesLineItemsModelsBySalesOrderModel(SalesOrderModel salesOrderModel) {
		return salesDAO.getSalesLineItemsModelsBySalesOrderModel(salesOrderModel);
	}

	@Override
	public List<SalesOrderModel> salesOrderListByOrganization(SalesOrderModel salesOrderModel) {
		return salesDAO.salesOrderListByOrganization(salesOrderModel);
	}

	@Override
	public List<SalesOrderModel> salesOrderListByBranchOrOutlet(SalesOrderModel salesOrderModel) {
		return salesDAO.salesOrderListByBranchOrOutlet(salesOrderModel);
	}
}
