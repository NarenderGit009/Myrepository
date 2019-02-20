package com.relyits.rmbs.beans_preparation.registration;

import java.util.ArrayList;
import java.util.List;


import com.relyits.rmbs.beans.registration.DoctorBean;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.model.registration.DoctorModel;

public class DoctorBeanPreparation {
	

	private static DoctorBean doctorBean = null;

		public static  DoctorBean prepareDoctorBean(DoctorModel doctorModel){
		doctorBean = new DoctorBean();
		doctorBean.setId(doctorModel.getId());
		doctorBean.setDoctorName(doctorModel.getDoctorName());
		doctorBean.setInitial(doctorModel.getInitial());
		doctorBean.setGender(doctorModel.getGender());
		doctorBean.setQualification(doctorModel.getQualification());
		doctorBean.setSpecialization(doctorModel.getSpecialization());
		doctorBean.setHospitalName(doctorModel.getHospitalName());
		doctorBean.setCreatedDate(doctorModel.getCreatedDate());
		doctorBean.setUpdatedDate(doctorModel.getUpdatedDate());
		
		doctorBean.setResourceBean(AddressBeanPreparation.prepareResourceBean(doctorModel.getResourceModel()));
			
		return doctorBean;
	}
	
	public static List<DoctorBean> prepareListofDoctorBean(List<DoctorModel> doctorModel){
		List<DoctorBean> doctorBeans = null;
		if(doctorModel != null && !doctorModel.isEmpty()){
			doctorBeans = new ArrayList<DoctorBean>();		
			for(DoctorModel doctorModel1 : doctorModel){			
				doctorBeans.add(prepareDoctorBean(doctorModel1));
			}
		}	
		return doctorBeans;
   }
			
			
				
			
	/*	
	
						java.sql.Date createdDate=null,updatedDate=null;
			
					
					try {
						createdDate=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime());
						updatedDate=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime());
					} catch (ParseException e) {
						
						e.printStackTrace();
					}
				
				AddressBean addressBean = new AddressBean();
				ResourceBean resourceBean = new ResourceBean();
				StatusBean accountStatusBean= new StatusBean();
				RoleBean roleBean = new RoleBean();
				RoleBean creatorRoleBean = new RoleBean();
				
				addressBean.setMobile(doctorModel.getResourceModel().getAddressModel().getMobile());
				addressBean.setEmail(doctorModel.getResourceModel().getAddressModel().getEmail());
				addressBean.setAddress(doctorModel.getResourceModel().getAddressModel().getAddress());
				
				accountStatusBean.setId(doctorModel.getResourceModel().getAccountStatusModel().getId());
				roleBean.setId(doctorModel.getResourceModel().getRoleModel().getId());
				creatorRoleBean.setId(doctorModel.getResourceModel().getCreatorRoleModel().getId());
				
				resourceBean.setAddressBean(addressBean);
				resourceBean.setAccountStatusBean(accountStatusBean);
				resourceBean.setCreatedBy(doctorModel.getResourceModel().getCreatedBy());	*/
				
			
					
		
	

}
