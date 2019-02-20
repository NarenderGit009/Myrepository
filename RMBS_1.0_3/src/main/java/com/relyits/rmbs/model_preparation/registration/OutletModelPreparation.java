package com.relyits.rmbs.model_preparation.registration;

import java.text.ParseException;

import com.relyits.rmbs.beans.registration.OutletBean;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OutletModel;
import com.relyits.rmbs.model_preparation.resource.AddressModelPreparation;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;




public class OutletModelPreparation {
	
	private static OutletModel outletModel=null;
	private static BranchModel branchModel=null;
	private static java.sql.Date dob = null,registredDateTime=null,updatedDateTime=null,lastLoginedDateTime = null;
	public static OutletModel prepareOutletModel(OutletBean outletBean){
		outletModel = new OutletModel();
		branchModel = new BranchModel();
		
		outletModel.setInitial(outletBean.getInitial());
		outletModel.setFirstName(outletBean.getFirstName());
		outletModel.setLastName(outletBean.getLastName());
		outletModel.setUserName(outletBean.getUserName());
		outletModel.setGender(outletBean.getGender());
		outletModel.setPassword(outletBean.getPassword());
		//outletModel.setName(outletBean.getName());
		outletModel.setDaysCount(outletBean.getDaysCount());
		
		
		try {
			dob = DateAndTimeUtilities.parseStringDateToSqlDate(outletBean.getDob());
			registredDateTime=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime());
			updatedDateTime=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime());
			lastLoginedDateTime=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		outletModel.setDob(dob);
		outletModel.setRegisteredDateTime(registredDateTime);
		outletModel.setUpdatedDateTime(updatedDateTime);
		outletModel.setLastLoginedDateTime(lastLoginedDateTime);
		
		branchModel.setId(outletBean.getBranchBean().getId());
	    outletModel.setBranchModel(branchModel);
		
		outletModel.setResourceModel(AddressModelPreparation.prepareResourceModel(outletBean.getResourceBean()));

		return outletModel;
	}

}
