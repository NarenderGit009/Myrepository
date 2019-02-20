package com.relyits.rmbs.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.relyits.rmbs.beans.registration.OutletBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.beans_preparation.registration.OutletBeanPreparation;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model.registration.OutletModel;
import com.relyits.rmbs.model.registration.ResourceModel;
import com.relyits.rmbs.service.BranchService;
import com.relyits.rmbs.service.OrganizationService;
import com.relyits.rmbs.service.OutletService;

@Controller
public class OutletController {


	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private BranchService branchService;

	@Autowired
	private OutletService outletService;

	BranchModel branchModel = null;
	OrganizationModel organizationModel = null;
	UserSessionBean userSessionBean = null;

	ResourceModel resourceModel = null;
	StatusModel accountStatusModel = null;
	StatusModel loginStatusModel = null;
	OutletModel outletModel = null;


	Map<String, String> properties= null;
	int inactive;
	int active;

	@Value("${status.inactive}") String inactiveStatus;
	@Value("${status.active}") String activeStatus;

	public Map<String, String> initializeProperties(){

		inactive = Integer.parseInt(inactiveStatus);
		active = Integer.parseInt(activeStatus);

		return properties;
	}

	//////////////////////////////**********************///////////////////////		 	

	@RequestMapping(value = "/getOutlet",method = RequestMethod.POST)
	public @ResponseBody OutletBean getOutlet(@RequestParam(value = "outlet") String outletId,
			HttpSession session)
					throws Exception {
		System.out.println("getBranch executed>>>>>>>>>>>>>>>");
		outletModel=new OutletModel();
		int bid=Integer.parseInt(outletId);
		outletModel.setId(bid);
		outletModel = outletService.getOutlet(outletModel);
		System.out.println(outletModel.getFirstName()+" "+outletModel.getLastName());
		return OutletBeanPreparation.prepareOutLetBean(outletModel);

	}

	@RequestMapping(value = "/updateOutletStatusByBranch",
			method = RequestMethod.POST)
	public @ResponseBody OutletBean updateOutletStatusByBranch(@RequestParam(value = "outlet") String outletId,
			@RequestParam(value = "flag") String flag,
			HttpSession session)
					throws Exception {
		initializeProperties();
		outletModel=new OutletModel();
		int bid=Integer.parseInt(outletId);
		outletModel.setId(bid);
		resourceModel = new ResourceModel();
		accountStatusModel = new StatusModel();

		outletModel=outletService.getOutlet(outletModel);

		resourceModel=outletModel.getResourceModel();

		if(flag.contentEquals("0")){
			accountStatusModel.setId(active);
			resourceModel.setAccountStatusModel(accountStatusModel);
		}else{
			accountStatusModel.setId(inactive);
			resourceModel.setAccountStatusModel(accountStatusModel); 

		}
		outletModel.setResourceModel(resourceModel);
		boolean returnresult=outletService.changeOutletStatus(outletModel);
		if(returnresult){
			outletModel=outletService.getOutlet(outletModel);
		}

		return OutletBeanPreparation.prepareOutLetBean(outletModel); 

	}  

	

}
