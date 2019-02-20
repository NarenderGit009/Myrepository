package com.relyits.rmbs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relyits.rmbs.dao.SalesReturnsDAO;
import com.relyits.rmbs.model.sales.SalesLineItemsModel;
import com.relyits.rmbs.model.sales.SalesReturnLineItemsModel;
import com.relyits.rmbs.model.sales.SalesReturnOrderModel;
import com.relyits.rmbs.service.SalesReturnsService;

@Service("SalesReturnService")
public class SalesReturnsServiceImpl implements SalesReturnsService{

	@Autowired
	private SalesReturnsDAO salesRetunsDAO;
	
	
	public List<SalesReturnLineItemsModel> createSalesReturnOrder(List<SalesReturnLineItemsModel> salesReturnLineItemsModels,List<SalesLineItemsModel> salesLineItemsModels){
		return salesRetunsDAO.createSalesReturnOrder(salesReturnLineItemsModels,salesLineItemsModels);
	}


	public SalesReturnOrderModel getSalesReturnOrder(SalesReturnOrderModel salesReturnOrderModel) {
		return salesRetunsDAO.getSalesReturnOrder(salesReturnOrderModel);
	}


	public SalesReturnLineItemsModel createSalesReturnOrderLineItems(SalesReturnLineItemsModel salesReturnLineItemsModel) {
		return salesRetunsDAO.createSalesReturnOrderLineItems(salesReturnLineItemsModel);
	}


	public List<SalesReturnLineItemsModel> getSalesReturnLineItemsModelsBySalesReturnOrderModel(SalesReturnOrderModel salesReturnOrderModel) {
		return salesRetunsDAO.getSalesReturnLineItemsModelsBySalesReturnOrderModel(salesReturnOrderModel);
	}
	
}
