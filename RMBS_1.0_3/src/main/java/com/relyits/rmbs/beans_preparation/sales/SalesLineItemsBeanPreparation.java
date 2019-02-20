package com.relyits.rmbs.beans_preparation.sales;

import java.util.ArrayList;
import java.util.List;

import com.ibm.icu.text.DecimalFormat;
import com.relyits.rmbs.beans.sales.SalesLineItemsBean;
import com.relyits.rmbs.beans_preparation.product.ProductInventoryBeanPreparation;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.sales.SalesLineItemsModel;



public class SalesLineItemsBeanPreparation {

	private static SalesLineItemsBean salesLineItemsBean=null;
	private static List<SalesLineItemsBean> salesLineItemsBeans = null;
	
	public static SalesLineItemsBean prepareSalesLineItemsBean(SalesLineItemsModel salesLineItemsModel){

		salesLineItemsBean=new SalesLineItemsBean();
		salesLineItemsBean.setAmount(Double.parseDouble(new DecimalFormat("##.##").format(salesLineItemsModel.getAmount())));
		salesLineItemsBean.setDelivaeredQuantity(salesLineItemsModel.getDelivaeredQuantity());
		salesLineItemsBean.setDeliverableQuantity(salesLineItemsModel.getDeliverableQuantity());
		salesLineItemsBean.setDiscount(Double.parseDouble(new DecimalFormat("##.##").format(salesLineItemsModel.getDiscount())));
		salesLineItemsBean.setExpiryDate(salesLineItemsModel.getExpiryDate());
		salesLineItemsBean.setId(salesLineItemsModel.getId());
		salesLineItemsBean.setMargin(salesLineItemsModel.getMargin());
		salesLineItemsBean.setNetPrice(Double.parseDouble(new DecimalFormat("##.##").format(salesLineItemsModel.getNetPrice())));
		salesLineItemsBean.setPreparationCharges(salesLineItemsModel.getPreparationCharges());
		salesLineItemsBean.setQuantity(salesLineItemsModel.getQuantity());
		salesLineItemsBean.setUnitPrice(Double.parseDouble(new DecimalFormat("##.##").format(salesLineItemsModel.getUnitPrice())));
		salesLineItemsBean.setVat(Double.parseDouble(new DecimalFormat("##.##").format(salesLineItemsModel.getVat())));
		//salesLineItemsBean.setOutletBean(OutletBeanPreparation.prepareOutLetBean(salesLineItemsModel.getOutletModel()));
		salesLineItemsBean.setProductInventoryBean(ProductInventoryBeanPreparation.prepareProductInventoryBean(salesLineItemsModel.getProductInventoryModel()));
		salesLineItemsBean.setSalesOrderBean(SalesOrderBeanPreparation.prepareSalesOrderBean(salesLineItemsModel.getSalesOrderModel()));
		salesLineItemsBean.setStatusBean(AddressBeanPreparation.prepareStatusBean(salesLineItemsModel.getStatusModel()));
		
		return salesLineItemsBean;

	}
	
	public static List<SalesLineItemsBean> prepareListOfSalesLineItemsBean(List<SalesLineItemsModel> salesLineItemsModels){
		
		if(salesLineItemsModels != null && !salesLineItemsModels.isEmpty()){
			salesLineItemsBeans = new ArrayList<SalesLineItemsBean>();				
			for(SalesLineItemsModel salesLineItemsModel : salesLineItemsModels){
				salesLineItemsBeans.add(prepareSalesLineItemsBean(salesLineItemsModel));
				}
		}
		return salesLineItemsBeans;
	}

}
