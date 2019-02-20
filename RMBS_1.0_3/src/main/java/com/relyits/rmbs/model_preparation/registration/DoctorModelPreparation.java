package com.relyits.rmbs.model_preparation.registration;



import java.text.ParseException;

import com.relyits.rmbs.beans.registration.DoctorBean;
import com.relyits.rmbs.model.registration.DoctorModel;
import com.relyits.rmbs.model_preparation.resource.AddressModelPreparation;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;





public class DoctorModelPreparation {
	
	static DoctorModel doctorModel = null;

	/*******************************************************************************************/
	/***************************************   Doctor ******************************************/
	/**
	 * @throws ParseException *****************************************************************************************/
	
	public static DoctorModel prepareDoctorModel(DoctorBean doctorBean) throws ParseException{
		
		System.out.println("***********PrepareModel****************");
		doctorModel = new DoctorModel();
		
		doctorModel.setId(doctorBean.getId());
		doctorModel.setDoctorName(doctorBean.getDoctorName());
		doctorModel.setInitial(doctorBean.getInitial());
		doctorModel.setGender(doctorBean.getGender());
		doctorModel.setQualification(doctorBean.getQualification());
		doctorModel.setSpecialization(doctorBean.getSpecialization());
		doctorModel.setHospitalName(doctorBean.getHospitalName());
		doctorModel.setCreatedDate(doctorBean.getCreatedDate());
		doctorModel.setUpdatedDate(DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime()));
		doctorModel.setResourceModel(AddressModelPreparation.prepareResourceModel(doctorBean.getResourceBean()));			
		
		
		return doctorModel;
	
	
			
	}
	

}
