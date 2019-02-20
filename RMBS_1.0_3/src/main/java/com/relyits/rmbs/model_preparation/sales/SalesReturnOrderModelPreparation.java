package com.relyits.rmbs.model_preparation.sales;

import java.text.ParseException;

import com.relyits.rmbs.model.sales.SalesLineItemsModel;
import com.relyits.rmbs.model.sales.SalesOrderModel;
import com.relyits.rmbs.model.sales.SalesReturnLineItemsModel;
import com.relyits.rmbs.model.sales.SalesReturnOrderModel;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;



public class SalesReturnOrderModelPreparation {
	
	private static SalesReturnOrderModel salesReturnOrderModel=null;
	
	public static SalesReturnOrderModel prepareSSalesReturnOrderModel(SalesOrderModel salesOrderModel) throws ParseException{
	
		salesReturnOrderModel=new SalesReturnOrderModel();
		salesReturnOrderModel.setAmount(salesOrderModel.getAmount());
		salesReturnOrderModel.setBillingDateAndTime(DateAndTimeUtilities.getCurrentDateTimeInSqlFormat());
		salesReturnOrderModel.setBranchModel(salesOrderModel.getBranchModel());
		salesReturnOrderModel.setCustomerModel(salesOrderModel.getCustomerModel());
		salesReturnOrderModel.setDeductionOnMargin(salesOrderModel.getMargin());
		salesReturnOrderModel.setDiscountPrice(salesOrderModel.getDiscountPrice());
		salesReturnOrderModel.setDoctorModel(salesOrderModel.getDoctorModel());
		salesReturnOrderModel.setOrderIdByDate(""+salesReturnOrderModel.getBillingDateAndTime());
		salesReturnOrderModel.setOutletModel(salesOrderModel.getOutletModel());
		//salesReturnOrderModel.setPatientModel(salesOrderModel.getPatientModel());
		//salesReturnOrderModel.setReasonModel()
		salesReturnOrderModel.setStatusModel(salesOrderModel.getStatusModel());
		salesReturnOrderModel.setTotalVAT(salesOrderModel.getTotalVAT());
		salesReturnOrderModel.setPayAmount(salesOrderModel.getPayAmount());
		
		

		return salesReturnOrderModel;
	

 }
}