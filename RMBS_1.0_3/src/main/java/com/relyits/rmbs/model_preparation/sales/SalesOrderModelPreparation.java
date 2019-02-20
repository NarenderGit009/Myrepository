package com.relyits.rmbs.model_preparation.sales;

import java.text.ParseException;

import com.relyits.rmbs.beans.sales.SalesOrderBean;
import com.relyits.rmbs.model.sales.SalesOrderModel;
import com.relyits.rmbs.model_preparation.consumer.CustomerModelPreparation;
import com.relyits.rmbs.model_preparation.consumer.PatientModelPreparation;
import com.relyits.rmbs.model_preparation.registration.BranchModelPreparation;
import com.relyits.rmbs.model_preparation.registration.DoctorModelPreparation;
import com.relyits.rmbs.model_preparation.registration.OutletModelPreparation;
import com.relyits.rmbs.model_preparation.resource.AddressModelPreparation;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;


public class SalesOrderModelPreparation {
	
	   private static SalesOrderModel salesOrderModel=null;
	    
		public static SalesOrderModel prepareSalesOrderBean(SalesOrderBean salesOrderBean){
			salesOrderModel=new SalesOrderModel();
			salesOrderModel.setAmount(salesOrderBean.getAmount());
			try {
				salesOrderModel.setBillingDateAndTime(DateAndTimeUtilities.getCurrentDateTimeInSqlFormat());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			//salesOrderModel.setBranchModel(BranchModelPreparation.prepareBranchModel(salesOrderBean.getBranchBean()));
			//salesOrderModel.setCategoryModel(AddressModelPreparation.prepareCategoryModel(salesOrderBean.getCategoryBean()));
			if(salesOrderBean.getCustomerBean().getName()!=""){
			salesOrderModel.setCustomerModel(CustomerModelPreparation.prepareCustomerModel(salesOrderBean.getCustomerBean()));
			}
			salesOrderModel.setDiscountPrice(salesOrderBean.getDiscountPrice());
			try {
				if(salesOrderBean.getDoctorBean()!=null){
				salesOrderModel.setDoctorModel(DoctorModelPreparation.prepareDoctorModel(salesOrderBean.getDoctorBean()));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
			salesOrderModel.setId(salesOrderBean.getId());
			salesOrderModel.setMargin(salesOrderBean.getMargin());
			salesOrderModel.setOrderIdByDate(salesOrderModel.getBillingDateAndTime()+"");
			//salesOrderModel.setOutletModel(OutletModelPreparation.prepareOutletModel(salesOrderBean.getOutletBean()));
		/*	if(salesOrderBean.getPatientBean()!=null){
				salesOrderModel.setPatientModel(PatientModelPreparation.preparePatientModel(salesOrderBean.getPatientBean()));
			}*/
			//salesOrderModel.setStatusModel(AddressModelPreparation.prepareStatusModel(salesOrderBean.getStatusBean()));
			salesOrderModel.setPayAmount(salesOrderBean.getPayAmount());
			salesOrderModel.setTotalVAT(salesOrderBean.getTotalVAT());
			
			return salesOrderModel;
			
		}

}
