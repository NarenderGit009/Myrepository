package com.relyits.rmbs.model_preparation.registration;



import java.text.ParseException;

import com.relyits.rmbs.beans.registration.AgencyBean;
import com.relyits.rmbs.beans.resources.PurchaseFormBean;
import com.relyits.rmbs.model.registration.AgencyModel;
import com.relyits.rmbs.model_preparation.resource.AddressModelPreparation;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;


public class AgencyModelPreparation {

	 static AgencyModel agencyModel = null;

	
	/*******************************************************************************************/
	/***************************************   Agency ******************************************/
	/**
	 * @throws ParseException *****************************************************************************************/
	
	public static AgencyModel prepareAgencyModel(AgencyBean agencyBean) throws ParseException{
		
		System.out.println("***********AgencyPrepareModel****************");
		agencyModel = new AgencyModel();
		
		agencyModel.setId(agencyBean.getId());
		agencyModel.setAgencyName(agencyBean.getAgencyName());
		agencyModel.setCstNo(agencyBean.getCstNo());
		agencyModel.setDlNo1(agencyBean.getDlNo1());
		agencyModel.setDlNo2(agencyBean.getDlNo2());
		agencyModel.setCreatedDate(agencyBean.getCreatedDate());
		agencyModel.setUpdatedDate(DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime()));
		agencyModel.setResourceModel(AddressModelPreparation.prepareResourceModel(agencyBean.getResourceBean()));
		
		
		return agencyModel;
		
		
	}
	public static AgencyModel prepareAgencyModelFromPurchaseFormBean(PurchaseFormBean purchaseFormBean){
		agencyModel = new AgencyModel();
		agencyModel.setId(purchaseFormBean.getAgeId());
		return agencyModel;
	}
	
}
