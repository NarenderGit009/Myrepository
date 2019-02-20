package com.relyits.rmbs.model_preparation.registration;

import java.text.ParseException;

import com.relyits.rmbs.beans.registration.BranchBean;
import com.relyits.rmbs.beans.resources.PurchaseFormBean;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model_preparation.resource.AddressModelPreparation;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;




public class BranchModelPreparation {
	
	private static BranchModel branchModel=null;
	private static java.sql.Date dob = null,registredDateTime=null,updatedDateTime=null,lastLoginedDateTime = null;
	public static BranchModel prepareBranchModel(BranchBean branchBean){
		
		branchModel = new BranchModel();
		branchModel.setInitial(branchBean.getInitial());
		branchModel.setFirstName(branchBean.getFirstName());
		branchModel.setLastName(branchBean.getLastName());
		branchModel.setUserName(branchBean.getUserName());
		branchModel.setGender(branchBean.getGender());
		branchModel.setPassword(branchBean.getPassword());
		branchModel.setName(branchBean.getName());
		branchModel.setTinNo(branchBean.getTinNo());
		branchModel.setDaysCount(branchBean.getDaysCount());
		branchModel.setNoOfOutlets(branchBean.getNoOfOutlets());
		
		try {
			dob = DateAndTimeUtilities.parseStringDateToSqlDate(branchBean.getDob());
			registredDateTime=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime());
			updatedDateTime=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime());
			lastLoginedDateTime=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		branchModel.setDob(dob);
		branchModel.setRegisteredDateTime(registredDateTime);
		branchModel.setUpdatedDateTime(updatedDateTime);
		branchModel.setLastLoginedDateTime(lastLoginedDateTime);
	
		branchModel.setResourceModel(AddressModelPreparation.prepareResourceModel(branchBean.getResourceBean()));

		return branchModel;
	}
	public static BranchModel prepareBranchModelFromPurchaseFormBean(PurchaseFormBean purchaseFormBean){
		branchModel = new BranchModel();
		branchModel.setId(purchaseFormBean.getBrId());
		return branchModel;
	}

}
