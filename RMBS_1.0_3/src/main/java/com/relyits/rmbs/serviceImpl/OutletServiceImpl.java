package com.relyits.rmbs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.relyits.rmbs.dao.OutletDao;
import com.relyits.rmbs.model.registration.OutletModel;
import com.relyits.rmbs.service.OutletService;

/**
 * @author Amar Errabelli
 *
 */
@Service("outletService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OutletServiceImpl implements OutletService{

	@Autowired
	private OutletDao outletDao;

	public OutletModel checkOutletAvailability(OutletModel outletModel) {
		return outletDao.checkOutletAvailability(outletModel);
	}

	public boolean createOutlet(OutletModel outletModel) {
		return outletDao.createOutlet(outletModel);
	}

    public OutletModel getOutlet(OutletModel outletModel) {
		return outletDao.getOutlet(outletModel);
	}

	public boolean changeOutletStatus(OutletModel outletModel) {
		return outletDao.changeOutletStatus(outletModel);
	}
    
	public List<OutletModel> getOutletListsByBranch(OutletModel outletModel) {
		return outletDao.getOutletListsByBranch(outletModel);
	}

	public List<OutletModel> getOutletListsByOrganization(OutletModel outletModel) {
		return outletDao.getOutletListsByOrganization(outletModel);
	}


}
