package com.relyits.rmbs.service;

import java.util.List;

import com.relyits.rmbs.model.registration.AgencyModel;

public interface AgencyService {
	
	public boolean registerAgency(AgencyModel agencyModel);
	
 	public List<AgencyModel> listAgencies();
 
 	public List<AgencyModel>  listAgenciesByCreator(AgencyModel agencyModel);
 
 	public List<AgencyModel>  listAgenciesByCategory(AgencyModel agencyModel);
	
	public AgencyModel getAgency(AgencyModel agencyModel);
	
	public void disableAgency(AgencyModel agencyModel);
	
	public void disableAllAgencies(AgencyModel agencyModel);
	
	public void enableAgency(AgencyModel agencyModel);
	
	public void enableAllAgencies(AgencyModel agencyModel);
	
	public void deleteAgency(AgencyModel agencyModel);
	
	public void deleteAllAgencies(AgencyModel agencyModel);



}
