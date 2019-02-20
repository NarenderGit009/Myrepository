package com.relyits.rmbs.beans_preparation.sales;

import com.ibm.icu.text.DecimalFormat;
import com.relyits.rmbs.beans.sales.SalesReturnOrderBean;
import com.relyits.rmbs.beans_preparation.consumer.CustomerBeanPreparation;
import com.relyits.rmbs.beans_preparation.consumer.PatientBeanPreparation;
import com.relyits.rmbs.beans_preparation.registration.BranchBeanPreparation;
import com.relyits.rmbs.beans_preparation.registration.DoctorBeanPreparation;
import com.relyits.rmbs.beans_preparation.registration.OutletBeanPreparation;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.beans_preparation.resources.ReasonBeanPreparation;
import com.relyits.rmbs.model.sales.SalesReturnOrderModel;



public class SalesReturnOrderBeanPreparation {
	
	
	private static SalesReturnOrderBean salesReturnOrderBean=null;
	
  public static SalesReturnOrderBean prepareSalesReturnOrderBean(SalesReturnOrderModel salesReturnOrderModel){
	
	  salesReturnOrderBean=new SalesReturnOrderBean();
	  
	  salesReturnOrderBean.setAmount(Double.parseDouble(new DecimalFormat("##.##").format(salesReturnOrderModel.getAmount())));
	  salesReturnOrderBean.setBillingDateAndTime(salesReturnOrderModel.getBillingDateAndTime());
	  salesReturnOrderBean.setBranchBean(BranchBeanPreparation.prepareBranchBean(salesReturnOrderModel.getBranchModel()));
	  salesReturnOrderBean.setCustomerBean(CustomerBeanPreparation.prepareCustomerBean(salesReturnOrderModel.getCustomerModel()));
	  salesReturnOrderBean.setDeductionOnMargin(Double.parseDouble(new DecimalFormat("##.##").format(salesReturnOrderModel.getDeductionOnMargin())));
	  salesReturnOrderBean.setDiscountPrice(Double.parseDouble(new DecimalFormat("##.##").format(salesReturnOrderModel.getDiscountPrice())));
	  salesReturnOrderBean.setDoctorBean(DoctorBeanPreparation.prepareDoctorBean(salesReturnOrderModel.getDoctorModel()));
	  salesReturnOrderBean.setId(salesReturnOrderModel.getId());
	  salesReturnOrderBean.setOrderIdbyDate(salesReturnOrderModel.getOrderIdByDate());
	  salesReturnOrderBean.setOutletBean(OutletBeanPreparation.prepareOutLetBean(salesReturnOrderModel.getOutletModel()));
//	  salesReturnOrderBean.setPatientBean(PatientBeanPreparation.preparePatientBean(salesReturnOrderModel.getPatientModel()));
//	  salesReturnOrderBean.setReasonBean(ReasonBeanPreparation)
	  salesReturnOrderBean.setStatusBean(AddressBeanPreparation.prepareStatusBean(salesReturnOrderModel.getStatusModel()));
	  salesReturnOrderBean.setTotalVAT(Double.parseDouble(new DecimalFormat("##.##").format(salesReturnOrderModel.getTotalVAT())));
	  salesReturnOrderBean.setSalesOrderBean(SalesOrderBeanPreparation.prepareSalesOrderBean(salesReturnOrderModel.getSalesOrderModel()));
	  
	  return salesReturnOrderBean;
  }
	

}
