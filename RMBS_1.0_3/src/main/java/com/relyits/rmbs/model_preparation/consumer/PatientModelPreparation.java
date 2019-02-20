package com.relyits.rmbs.model_preparation.consumer;

import com.relyits.rmbs.beans.consumer.PatientBean;
import com.relyits.rmbs.model.consumer.PatientModel;

public class PatientModelPreparation {

	private static PatientModel patientModel=null;
	  
	public static PatientModel preparePatientModel(PatientBean patientBean){
		  
		patientModel=new PatientModel();
		patientModel.setCreatedBy(patientBean.getCreatedBy());
		patientModel.setGender(patientBean.getGender());
		patientModel.setId(patientBean.getId());
		patientModel.setName(patientBean.getName());
		  
		  return patientModel;
	  
	  }
}
