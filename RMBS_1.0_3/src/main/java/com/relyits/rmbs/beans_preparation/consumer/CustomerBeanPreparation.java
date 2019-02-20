package com.relyits.rmbs.beans_preparation.consumer;

import com.relyits.rmbs.beans.consumer.CustomerBean;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.consumer.CustomerModel;

public class CustomerBeanPreparation {
      
	  private static CustomerBean customerBean=null;
	

	  public static CustomerBean prepareCustomerBean(CustomerModel customerModel){
		  customerBean=new CustomerBean();
		  
		  customerBean.setCreatedBy(customerModel.getCreatedBy());
		  customerBean.setGender(customerModel.getGender());
		  customerBean.setId(customerModel.getId());
		  customerBean.setName(customerModel.getName());
		  customerBean.setAddressBean(AddressBeanPreparation.prepareAddressBean(customerModel.getAddressModel()));
		  customerBean.setRoleBean(AddressBeanPreparation.prepareRoleBean(customerModel.getRoleModel()));
		  
		  return customerBean;
	  
	  }	
	
}
