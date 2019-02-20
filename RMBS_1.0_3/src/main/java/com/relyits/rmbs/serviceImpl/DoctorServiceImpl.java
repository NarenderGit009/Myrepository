package com.relyits.rmbs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.relyits.rmbs.dao.DoctorDAO;
import com.relyits.rmbs.model.registration.DoctorModel;
import com.relyits.rmbs.service.DoctorService;

@Service("doctorService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDAO doctorDAO;
	
	public boolean registerDoctor(DoctorModel doctorModel) {
		return doctorDAO.registerDoctor(doctorModel);
	}

   public List<DoctorModel> listDoctors() {
		
		return doctorDAO.listDoctors();
	}

	
	public List<DoctorModel> listDoctorsByCreator(DoctorModel doctorModel) {
		
		return doctorDAO.listDoctorsByCreator(doctorModel);
	}

	
	public DoctorModel getDoctor(DoctorModel doctorModel) {
		
		return doctorDAO.getDoctor(doctorModel);
	}

	
	public void disableDoctor(DoctorModel doctorModel) {
		doctorDAO.disableDoctor(doctorModel);
		
	}
	public void deleteDoctor(DoctorModel doctorModel) {
		doctorDAO.deleteDoctor(doctorModel);
		
	}
	public void enableDoctor(DoctorModel doctorModel) {
		doctorDAO.enableDoctor(doctorModel);
		
	}
	
	public void enableAllDoctors(DoctorModel doctorModel) {
		doctorDAO.enableAllDoctors(doctorModel);
		
	}

   public void disableAllDoctors(DoctorModel doctorModel) {
	   doctorDAO.disableAllDoctors(doctorModel);
		
	}
	
   public void deleteAllDoctors(DoctorModel doctorModel) {
	   doctorDAO.deleteAllDoctors(doctorModel);
		
	}
   
   public List<DoctorModel> listDoctorsByCategory(DoctorModel doctorModel) {
		
		return doctorDAO.listDoctorsByCategory(doctorModel);
	}
   

}
