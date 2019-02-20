package com.relyits.rmbs.model_preparation.consumer;

import com.relyits.rmbs.beans.consumer.CustomerBean;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.consumer.CustomerModel;
import com.relyits.rmbs.model_preparation.resource.AddressModelPreparation;

public class CustomerModelPreparation {

	  private static CustomerModel customerModel=null;
		

	  public static CustomerModel prepareCustomerModel(CustomerBean customerBean){
		  customerModel=new CustomerModel();
		  
		  customerModel.setCreatedBy(customerBean.getCreatedBy());
		  customerModel.setGender(customerBean.getGender());
		  customerModel.setId(customerBean.getId());
		  customerModel.setName(customerBean.getName());
		  customerModel.setAddressModel(AddressModelPreparation.prepareAddressModel(customerBean.getAddressBean()));
		  customerModel.setRoleModel(AddressModelPreparation.prepareRoleModel(customerBean.getRoleBean()));
		  
		  return customerModel;
	  
	  }	
}
