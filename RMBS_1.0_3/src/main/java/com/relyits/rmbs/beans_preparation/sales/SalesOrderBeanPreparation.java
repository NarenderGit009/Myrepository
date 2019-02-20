package com.relyits.rmbs.beans_preparation.sales;

import java.util.ArrayList;
import java.util.List;

import com.ibm.icu.text.DecimalFormat;
import com.relyits.rmbs.beans.sales.SalesOrderBean;
import com.relyits.rmbs.beans_preparation.consumer.CustomerBeanPreparation;
import com.relyits.rmbs.beans_preparation.consumer.PatientBeanPreparation;
import com.relyits.rmbs.beans_preparation.registration.BranchBeanPreparation;
import com.relyits.rmbs.beans_preparation.registration.DoctorBeanPreparation;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.sales.SalesOrderModel;


public class SalesOrderBeanPreparation {
	
    private static SalesOrderBean salesOrderBean=null;
    
	public static SalesOrderBean prepareSalesOrderBean(SalesOrderModel salesOrderModel){
		
		salesOrderBean = new SalesOrderBean();
		salesOrderBean.setAmount(Double.parseDouble(new DecimalFormat("##.##").format(salesOrderModel.getAmount())));
		salesOrderBean.setBillingDateAndTime(salesOrderModel.getBillingDateAndTime());
		salesOrderBean.setBranchBean(BranchBeanPreparation.prepareBranchBean(salesOrderModel.getBranchModel()));
		salesOrderBean.setCategoryBean(AddressBeanPreparation.prepareCategoryBean(salesOrderModel.getCategoryModel()));
		salesOrderBean.setCustomerBean(CustomerBeanPreparation.prepareCustomerBean(salesOrderModel.getCustomerModel()));
		salesOrderBean.setDiscountPrice(Double.parseDouble(new DecimalFormat("##.##").format(salesOrderModel.getDiscountPrice())));
		if(salesOrderModel.getDoctorModel()!=null){
			salesOrderBean.setDoctorBean(DoctorBeanPreparation.prepareDoctorBean(salesOrderModel.getDoctorModel()));
		}		
		salesOrderBean.setId(salesOrderModel.getId());
		salesOrderBean.setMargin(salesOrderModel.getMargin());
		salesOrderBean.setOrderIdByDate(salesOrderModel.getOrderIdByDate());
		//salesOrderBean.setOutletBean(OutletBeanPreparation.prepareOutLetBean(salesOrderModel.getOutletModel()));
/*		if(salesOrderModel.getPatientModel()!=null){
		salesOrderBean.setPatientBean(PatientBeanPreparation.preparePatientBean(salesOrderModel.getPatientModel()));
		}
*/		salesOrderBean.setStatusBean(AddressBeanPreparation.prepareStatusBean(salesOrderModel.getStatusModel()));
		salesOrderBean.setTotalVAT(Double.parseDouble(new DecimalFormat("##.##").format(salesOrderModel.getTotalVAT())));
		salesOrderBean.setPayAmount(Double.parseDouble(new DecimalFormat("##.##").format(salesOrderModel.getPayAmount())));
		
		return salesOrderBean;
		
	}
	
	public static List<SalesOrderBean> prepareListOfSalesOrderBean(List<SalesOrderModel> sales){
		List<SalesOrderBean> salesOrderBeans = null;
		if(sales != null && !sales.isEmpty()){
			salesOrderBeans = new ArrayList<SalesOrderBean>();				
			for(SalesOrderModel salesOrderModel : sales){
				salesOrderBeans.add(prepareSalesOrderBean(salesOrderModel));
				}
		}


return salesOrderBeans;


}
	
	public static SalesOrderBean prepareSalesOrderBeanForRevenueAccounts(SalesOrderModel salesOrderModel){
		
		salesOrderBean = new SalesOrderBean();			
		
		salesOrderBean.setId(salesOrderModel.getId());
		salesOrderBean.setAmount(salesOrderModel.getAmount());
		salesOrderBean.setBillingDateAndTime(salesOrderModel.getBillingDateAndTime());
		salesOrderBean.setOrderIdByDate(salesOrderModel.getOrderIdByDate());
		salesOrderBean.setDiscountPrice(salesOrderModel.getDiscountPrice());
		salesOrderBean.setPayAmount(salesOrderModel.getPayAmount());
		salesOrderBean.setTotalVAT(salesOrderModel.getTotalVAT());
		salesOrderBean.setBranchBean(BranchBeanPreparation.prepareBranchBean(salesOrderModel.getBranchModel()));
						
	return salesOrderBean;


	}

	public static List<SalesOrderBean> prepareListOfSalesOrderBeanForRevenueAccounts(List<SalesOrderModel> salesOrderModels){
		List<SalesOrderBean> salesOrderBeans = null;
		if(salesOrderModels != null && !salesOrderModels.isEmpty()){
			salesOrderBeans = new ArrayList<SalesOrderBean>();				
			for(SalesOrderModel salesOrderModel : salesOrderModels){
				salesOrderBeans.add(prepareSalesOrderBeanForRevenueAccounts(salesOrderModel));
				}
		}


	return salesOrderBeans;


	}
	
}
