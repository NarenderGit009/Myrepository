package com.relyits.rmbs.service;

import java.util.List;

import com.relyits.rmbs.model.registration.BranchModel;

public interface BranchService {

  
	//************************ Branch **********************************
	
	public BranchModel checkBranchAvailability(BranchModel branchModel);
	
	 public boolean createBranch(BranchModel branchModel);
	 
	 public List<BranchModel> getBranchesByOrganization(BranchModel userBranch);
	 
	 public List<BranchModel> getAccountRequestsByBranches(BranchModel branchModel);
		
	 public BranchModel getBranchbyId(BranchModel branchModel);	
		
	 public boolean changeBranchStatus(BranchModel branchModel);
	 

	 

	 
}
