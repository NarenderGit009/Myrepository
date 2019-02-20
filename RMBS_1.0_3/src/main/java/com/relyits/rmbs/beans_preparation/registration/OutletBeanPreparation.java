package com.relyits.rmbs.beans_preparation.registration;

import java.util.ArrayList;
import java.util.List;

import com.relyits.rmbs.beans.registration.OutletBean;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.registration.OutletModel;




public class OutletBeanPreparation {
	
	private static OutletBean outletBean = null;
	private static List<OutletBean> outletBeans = null;
	
	public static OutletBean prepareOutLetBean(OutletModel outletModel){
		
		outletBean = new OutletBean();

		outletBean.setId(outletModel.getId());
		outletBean.setInitial(outletModel.getInitial());
		outletBean.setFirstName(outletModel.getFirstName());
		outletBean.setLastName(outletModel.getLastName());
		outletBean.setUserName(outletModel.getUserName());
		outletBean.setGender(outletModel.getGender());
		outletBean.setPassword(outletModel.getPassword());
	    outletBean.setDob(outletModel.getDob()+"");
		outletBean.setRegisteredDateTime(outletModel.getRegisteredDateTime());
		outletBean.setUpdatedDateTime(outletModel.getUpdatedDateTime());
		outletBean.setLastLoginedDateTime(outletModel.getLastLoginedDateTime());
		outletBean.setDaysCount(outletModel.getDaysCount());
        outletBean.setBranchBean(BranchBeanPreparation.prepareBranchBean(outletModel.getBranchModel()));
		outletBean.setOrganizationBean(OrganizationBeanPreparation.prepareOrganizationModelBean(outletModel.getBranchModel().getOrganizationModel()));
		outletBean.setResourceBean(AddressBeanPreparation.prepareResourceBean(outletModel.getResourceModel()));

		return outletBean;
	}
	public static List<OutletBean> prepareListofOutletsBeans(List<OutletModel> outletModels){
		outletBeans = new ArrayList<OutletBean>();
		if(outletModels != null && !outletModels.isEmpty()){
			
			
			for(OutletModel outletModel : outletModels){
				outletBeans.add(prepareOutLetBean(outletModel));
			}
		}	
		return outletBeans;
   }
	
}
