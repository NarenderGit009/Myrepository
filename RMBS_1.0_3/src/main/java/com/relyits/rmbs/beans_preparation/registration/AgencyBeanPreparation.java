package com.relyits.rmbs.beans_preparation.registration;

import java.util.ArrayList;
import java.util.List;

import com.relyits.rmbs.beans.registration.AgencyBean;
import com.relyits.rmbs.beans.resources.PurchaseFormBean;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.registration.AgencyModel;

public class AgencyBeanPreparation {
	
	private static AgencyBean agencyBean=null;
	
	public static AgencyBean prepareAgencyBean(AgencyModel agencyModel){
		agencyBean = new AgencyBean();
		
		agencyBean.setId(agencyModel.getId());
		agencyBean.setAgencyName(agencyModel.getAgencyName());
		agencyBean.setCstNo(agencyModel.getCstNo());
		agencyBean.setDlNo1(agencyModel.getDlNo1());
		agencyBean.setDlNo2(agencyModel.getDlNo2());
		agencyBean.setCreatedDate(agencyModel.getCreatedDate());
		agencyBean.setUpdatedDate(agencyModel.getUpdatedDate());
		agencyBean.setResourceBean(AddressBeanPreparation.prepareResourceBean(agencyModel.getResourceModel()));
		
		
		return agencyBean;
	}
	public static AgencyBean prepareAgencyBeanFromPurchaseFormBean(PurchaseFormBean purchaseFormBean){
		agencyBean = new AgencyBean();
		agencyBean.setId(purchaseFormBean.getAgeId());
		return agencyBean;
	}
	
	public static List<AgencyBean> prepareListofAgencyBean(List<AgencyModel> agencyModel){
		List<AgencyBean> agencyBeans = null;
		if(agencyModel != null && !agencyModel.isEmpty()){
			agencyBeans = new ArrayList<AgencyBean>();
			for(AgencyModel agencyModel1 : agencyModel){		
				
				agencyBeans.add(prepareAgencyBean(agencyModel1));
			}
		}
		return agencyBeans;
	}
	
}
