package com.relyits.rmbs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.relyits.rmbs.dao.AgencyDAO;
import com.relyits.rmbs.model.registration.AgencyModel;
import com.relyits.rmbs.service.AgencyService;

@Service("agencyService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AgencyServiceImpl implements AgencyService {
	
	 @Autowired
		private AgencyDAO agencyDAO;
	 
	  public boolean registerAgency(AgencyModel agencyModel) {
			return agencyDAO.registerAgency(agencyModel);
			
		}

		public List<AgencyModel> listAgencies() {
			return agencyDAO.listAgencies();
		}

		
		public List<AgencyModel> listAgenciesByCreator(AgencyModel agencyModel) {
			return agencyDAO.listAgenciesByCreator(agencyModel);
		}

		
		public List<AgencyModel> listAgenciesByCategory(AgencyModel agencyModel) {
			return agencyDAO.listAgenciesByCategory(agencyModel);
		}
		
		public AgencyModel getAgency(AgencyModel agencyModel) {
			return agencyDAO.getAgency(agencyModel);
		}

		public void deleteAgency(AgencyModel agencyModel) {
			agencyDAO.deleteAgency(agencyModel);
			
		}

		
		public void disableAgency(AgencyModel agencyModel) {
			agencyDAO.disableAgency(agencyModel);
			
		}

		public void enableAgency(AgencyModel agencyModel) {
			agencyDAO.enableAgency(agencyModel);
			
		}

		
		public void disableAllAgencies(AgencyModel agencyModel) {
			agencyDAO.disableAllAgencies(agencyModel);
			
		}

		
		public void enableAllAgencies(AgencyModel agencyModel) {
			agencyDAO.enableAllAgencies(agencyModel);
			
		}

		
		public void deleteAllAgencies(AgencyModel agencyModel) {
			agencyDAO.deleteAllAgencies(agencyModel);
			
		}
		

}
