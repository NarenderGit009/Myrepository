package com.relyits.rmbs.service;

import java.util.List;

import com.relyits.rmbs.model.registration.DoctorModel;

public interface DoctorService {
	
    public boolean registerDoctor(DoctorModel doctorModel);
	
	public List<DoctorModel> listDoctors();
	 
	public List<DoctorModel>  listDoctorsByCreator(DoctorModel doctorModel);
	
	public List<DoctorModel>  listDoctorsByCategory(DoctorModel doctorModel);
	
	public DoctorModel getDoctor(DoctorModel doctorModel);
	
	public void disableDoctor(DoctorModel doctorModel);
	
	public void deleteDoctor(DoctorModel DoctorModel);
	
	public void enableDoctor(DoctorModel doctorModel);
	
	public void enableAllDoctors(DoctorModel doctorModel);
	
	public void disableAllDoctors(DoctorModel doctorModel);
	
	public void deleteAllDoctors(DoctorModel doctorModel);
	

	

}
