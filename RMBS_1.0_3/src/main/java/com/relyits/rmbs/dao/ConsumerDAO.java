package com.relyits.rmbs.dao;

import java.util.List;

import com.relyits.rmbs.model.consumer.CustomerModel;
import com.relyits.rmbs.model.sales.SalesLineItemsModel;
import com.relyits.rmbs.model.sales.SalesOrderModel;


public interface ConsumerDAO {
	public List<CustomerModel> getCustomer(CustomerModel customerModel);
	
	public CustomerModel getDefaultCustomer(CustomerModel customerModel);
}
