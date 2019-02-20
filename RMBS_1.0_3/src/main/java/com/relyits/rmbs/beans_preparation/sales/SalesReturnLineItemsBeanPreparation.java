package com.relyits.rmbs.beans_preparation.sales;

import java.util.ArrayList;
import java.util.List;

import com.ibm.icu.text.DecimalFormat;
import com.relyits.rmbs.beans.sales.SalesReturnLineItemsBean;
import com.relyits.rmbs.beans_preparation.product.ProductInventoryBeanPreparation;
import com.relyits.rmbs.beans_preparation.registration.OutletBeanPreparation;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.sales.SalesReturnLineItemsModel;



public class SalesReturnLineItemsBeanPreparation {
	
	private static SalesReturnLineItemsBean salesReturnLineItemsBean=null;
	private static List<SalesReturnLineItemsBean> salesReturnLineItemsBeans = null;
	
 public static SalesReturnLineItemsBean preparationSalesReturnLineItemsBean(SalesReturnLineItemsModel salesReturnLineItemsModel){
	 
	 salesReturnLineItemsBean=new SalesReturnLineItemsBean();
	 
	 salesReturnLineItemsBean.setAmount(Double.parseDouble(new DecimalFormat("##.##").format(salesReturnLineItemsModel.getAmount())));
	 salesReturnLineItemsBean.setDeductionOnMargin(Double.parseDouble(new DecimalFormat("##.##").format(salesReturnLineItemsModel.getDeductionOnMargin())));
	 salesReturnLineItemsBean.setDelivaeredQuantity(salesReturnLineItemsModel.getDelivaeredQuantity());
	 salesReturnLineItemsBean.setDeliverableQuantity(salesReturnLineItemsModel.getDeliverableQuantity());
	 salesReturnLineItemsBean.setDiscount(Double.parseDouble(new DecimalFormat("##.##").format(salesReturnLineItemsModel.getDiscount())));
	 salesReturnLineItemsBean.setExpiryDate(salesReturnLineItemsModel.getExpiryDate());
	 salesReturnLineItemsBean.setId(salesReturnLineItemsModel.getId());
	 salesReturnLineItemsBean.setNetPrice(Double.parseDouble(new DecimalFormat("##.##").format(salesReturnLineItemsModel.getNetPrice())));
	 salesReturnLineItemsBean.setOutletBean(OutletBeanPreparation.prepareOutLetBean(salesReturnLineItemsModel.getOutletModel()));
	 salesReturnLineItemsBean.setPreparationCharges(Double.parseDouble(new DecimalFormat("##.##").format(salesReturnLineItemsModel.getPreparationCharges())));
	 salesReturnLineItemsBean.setProductInventoryBean(ProductInventoryBeanPreparation.prepareProductInventoryBean(salesReturnLineItemsModel.getProductInventoryModel()));
	 salesReturnLineItemsBean.setQuantity(salesReturnLineItemsModel.getQuantity());
	 salesReturnLineItemsBean.setSalesReturnOrderBean(SalesReturnOrderBeanPreparation.prepareSalesReturnOrderBean(salesReturnLineItemsModel.getSalesReturnOrderModel()));
	 salesReturnLineItemsBean.setStatusBean(AddressBeanPreparation.prepareStatusBean(salesReturnLineItemsModel.getStatusModel()));
	 salesReturnLineItemsBean.setUnitPrice(Double.parseDouble(new DecimalFormat("##.##").format(salesReturnLineItemsModel.getUnitPrice())));
	 salesReturnLineItemsBean.setVat(Double.parseDouble(new DecimalFormat("##.##").format(salesReturnLineItemsModel.getVat())));
	 
	 return salesReturnLineItemsBean;
 }
	
	public static List<SalesReturnLineItemsBean> prepareListOfSalesReturnLineItemsBeans(List<SalesReturnLineItemsModel> salesReturnLineItemsModels){
		
		if(salesReturnLineItemsModels != null && !salesReturnLineItemsModels.isEmpty()){
			salesReturnLineItemsBeans = new ArrayList<SalesReturnLineItemsBean>();				
			for(SalesReturnLineItemsModel salesReturnLineItemsModel : salesReturnLineItemsModels){
				salesReturnLineItemsBeans.add(preparationSalesReturnLineItemsBean(salesReturnLineItemsModel));
				}
		}


return salesReturnLineItemsBeans;


}

}
