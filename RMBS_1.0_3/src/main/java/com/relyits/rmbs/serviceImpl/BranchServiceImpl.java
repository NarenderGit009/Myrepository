package com.relyits.rmbs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.relyits.rmbs.dao.BranchDAO;
import com.relyits.rmbs.dao.OrganizationDAO;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.DoctorModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.service.BranchService;

@Service("branchService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BranchServiceImpl implements BranchService{

   @Autowired
	private BranchDAO branchDAO;
	
   @Autowired
  	private OrganizationDAO userDao;
   
		//****************************Branch*******************************	
	
	
	public BranchModel checkBranchAvailability(BranchModel branchModel) {
		return branchDAO.checkBranchAvailability(branchModel);
	}

	
	public boolean createBranch(BranchModel branchModel) {
		return branchDAO.createBranch(branchModel);
		
	}

	public List<BranchModel> getBranchesByOrganization(BranchModel branchModel){
         return branchDAO.getBranchesByOrganization(branchModel);
	}

	public List<BranchModel> getAccountRequestsByBranches(BranchModel branchModel) {
		return branchDAO.getAccountRequestsByBranches(branchModel);
	
	}

	public BranchModel getBranchbyId(BranchModel branchModel) {
		return branchDAO.getBranchbyId(branchModel);
	}

	public boolean changeBranchStatus(BranchModel branchModel) {
		return branchDAO.changeBranchStatus(branchModel);
	}



	
	
	
	
	

	
	

	
	
	
	
	
	

	
	

	

	
	
	



}


