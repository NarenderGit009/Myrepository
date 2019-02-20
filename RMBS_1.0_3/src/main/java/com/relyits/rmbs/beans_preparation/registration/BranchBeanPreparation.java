package com.relyits.rmbs.beans_preparation.registration;

import java.util.ArrayList;
import java.util.List;

import com.relyits.rmbs.beans.registration.BranchBean;
import com.relyits.rmbs.beans.registration.DoctorBean;
import com.relyits.rmbs.beans.resources.PurchaseFormBean;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.DoctorModel;




public class BranchBeanPreparation {

	private static BranchBean branchBean = null;
	
	
	public static BranchBean prepareBranchBean(BranchModel branchModel){
		
		branchBean = new BranchBean();

		
		branchBean.setId(branchModel.getId());
		branchBean.setNoOfOutlets(branchModel.getNoOfOutlets());
		branchBean.setInitial(branchModel.getInitial());
		branchBean.setFirstName(branchModel.getFirstName());
		branchBean.setLastName(branchModel.getLastName());
		branchBean.setUserName(branchModel.getUserName());
		branchBean.setGender(branchModel.getGender());
		branchBean.setPassword(branchModel.getPassword());
		branchBean.setName(branchModel.getName());
		branchBean.setTinNo(branchModel.getTinNo());
	    branchBean.setDob(branchModel.getDob()+"");
		branchBean.setRegisteredDateTime(branchModel.getRegisteredDateTime());
		branchBean.setUpdatedDateTime(branchModel.getUpdatedDateTime());
		branchBean.setLastLoginedDateTime(branchModel.getLastLoginedDateTime());
		branchBean.setDaysCount(branchModel.getDaysCount());
		//branchBean.setOrganizationBean()
		
		branchBean.setResourceBean(AddressBeanPreparation.prepareResourceBean(branchModel.getResourceModel()));

		return branchBean;
	}
	
	public static BranchBean prepareBranchBeanFromPurchaseFormBean(PurchaseFormBean purchaseFormBean){
		branchBean = new BranchBean();
		branchBean.setId(purchaseFormBean.getBrId());
		return branchBean;
	}
	public static List<BranchBean> prepareListofBranchesBeans(List<BranchModel> branchModels){
		List<BranchBean> branchBeans = null;
		if(branchModels != null && !branchModels.isEmpty()){
			branchBeans = new ArrayList<BranchBean>();
			
			for(BranchModel branchModel : branchModels){
				branchBeans.add(prepareBranchBean(branchModel));
			}
		}	
		return branchBeans;
   }
	
}
