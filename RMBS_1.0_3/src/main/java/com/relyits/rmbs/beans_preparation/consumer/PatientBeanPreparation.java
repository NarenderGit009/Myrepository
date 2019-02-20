package com.relyits.rmbs.beans_preparation.consumer;

import com.relyits.rmbs.beans.consumer.PatientBean;
import com.relyits.rmbs.model.consumer.PatientModel;

public class PatientBeanPreparation {

	private static PatientBean patientBean=null;
	  
	public static PatientBean preparePatientBean(PatientModel patientModel){
		  
		  patientBean=new PatientBean();
		  patientBean.setCreatedBy(patientModel.getCreatedBy());
		  patientBean.setGender(patientModel.getGender());
		  patientBean.setId(patientModel.getId());
		  patientBean.setName(patientModel.getName());
		  
		  return patientBean;
	  
	  }
}
