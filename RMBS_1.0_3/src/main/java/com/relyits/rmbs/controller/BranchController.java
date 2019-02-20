package com.relyits.rmbs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.relyits.rmbs.beans.registration.OutletBean;
import com.relyits.rmbs.beans.registration.RegistrationBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.beans_preparation.registration.BranchBeanPreparation;
import com.relyits.rmbs.beans_preparation.registration.OutletBeanPreparation;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model.registration.OutletModel;
import com.relyits.rmbs.model.registration.ResourceModel;
import com.relyits.rmbs.service.BranchService;
import com.relyits.rmbs.service.OrganizationService;
import com.relyits.rmbs.service.OutletService;
import com.relyits.rmbs.utilities.SessionUtilities;

@Controller
public class BranchController {



	@Autowired
	private BranchService branchService;

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private OutletService outletService;

	BranchModel branchModel = null;
	OrganizationModel organizationModel = null;
	UserSessionBean userSessionBean = null;

	ResourceModel resourceModel = null;
	StatusModel accountStatusModel = null;
	StatusModel loginStatusModel = null;
	OutletModel outletModel = null;


	Map<String, Object> model = null;	

	Map<String, String> properties= null;

	int inactive ;
	int active ;

	@Value("${status.inactive}") String inactiveStatus;
	@Value("${status.active}") String activeStatus;

	public Map<String, String> initializeProperties(){

		inactive = Integer.parseInt(inactiveStatus);
		active = Integer.parseInt(activeStatus);

		return properties;
	}

	///////////////////*********************///////////////////////

	/*
	@RequestMapping(value = "/updateBranchStatusByAdmin",method = RequestMethod.POST)
	public @ResponseBody BranchModel updateBranchStatusByOrganization(@RequestParam(value = "owner") String branch,
			@RequestParam(value = "menu") String menuOptions,
			@RequestParam(value = "flag") String flag,
			HttpSession session)
					throws Exception {
		initializeProperties();

		branchModel=new BranchModel();
		int branchId=Integer.parseInt(branch);
		branchModel.setId(branchId);
		branchModel=branchService.getBranchbyId(branchModel);
		accountStatusModel = new StatusModel();
		resourceModel = new ResourceModel();

		accountStatusModel=branchModel.getResourceModel().getAccountStatusModel();
		resourceModel=branchModel.getResourceModel();

		boolean returnResult;
		if(flag.contentEquals("0")){
			accountStatusModel.setId(active);
			resourceModel.setAccountStatusModel(accountStatusModel);

		}else{
			accountStatusModel.setId(inactive);
			resourceModel.setAccountStatusModel(accountStatusModel);

		}


		branchModel.setResourceModel(resourceModel);
		returnResult=branchService.changeBranchStatus(branchModel);
		if(returnResult){
			branchModel=branchService.getBranchbyId(branchModel);

		}else{

		}
		return branchModel; 

	}
	 */

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/branchesList", method = RequestMethod.GET)
	public ModelAndView branchesList(HttpSession session,@ModelAttribute("command")  
	RegistrationBean registrationBean,
	BindingResult result/*, @RequestParam(value="userId") String userId */)
	{
		initializeProperties();
		System.out.println("************************organizationsList*********************");
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		System.out.println("************************"+userSessionBean+"*********************");
		int mode[]=SessionUtilities.validateSession(""+userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){
			organizationModel=new OrganizationModel();
			System.out.println("userSessionBean id >>>>>>>>>>>>>>>> "+userSessionBean.getId());
			organizationModel.setId(userSessionBean.getId());
			resourceModel = new ResourceModel();
			accountStatusModel = new StatusModel();

			accountStatusModel.setId(active);

			resourceModel.setAccountStatusModel(accountStatusModel);


			model = new HashMap<String, Object>();
			if(mode[1]==1){

				organizationModel.setResourceModel(resourceModel);
				model.put("users", organizationService.getAccountRequestsByOrganizations(organizationModel));
			
				List<OrganizationModel> Orgs=(List<OrganizationModel>)model.get("users");
				for(int i=0;i<Orgs.size();i++){
					OrganizationModel org=Orgs.get(i);

					System.out.println("*************FirstName************"+org.getFirstName());
					System.out.println("*************LastName*************"+org.getLastName());
					System.out.println("*************UserName*************"+org.getUserName());
					System.out.println("*************AccountStatus********"+org.getResourceModel().getAccountStatusModel().getStatus());
					System.out.println("*************Address**************"+org.getResourceModel().getAddressModel().getAddress());

				}
				return new ModelAndView("OrganizationsList",model);


			}else if(mode[1]==2){
				branchModel = new BranchModel();
				branchModel.setOrganizationModel(organizationModel);
				branchModel.setResourceModel(resourceModel);
				//BranchBeanPreparation.prepareListofBranchesBeans(listsService.getAccountRequestsByBranches(branchModel))
				model.put("branches", BranchBeanPreparation.prepareListofBranchesBeans(branchService.getAccountRequestsByBranches(branchModel))); 

				return new ModelAndView("roleThreeUsersList",model); 

			}else{
				outletModel = new OutletModel();
				branchModel = new BranchModel();
				branchModel.setId(userSessionBean.getId());
				outletModel.setBranchModel(branchModel);
				outletModel.setResourceModel(resourceModel);
			//	model.put("outlets", OutletBeanPreparation.prepareListofOutletsBeans(outletService.getOutletListsByBranch(outletModel))); 
                 model.put("outlets", null);
				 List<OutletBean> outlets=OutletBeanPreparation.prepareListofOutletsBeans(outletService.getOutletListsByBranch(outletModel));
			       System.out.println("*****Before Model insertion******");
			       for(OutletBean outletBean:outlets){
			        
			       System.out.println("*************outlet Name************"+outletBean.getUserName());
			       System.out.println("*************Account Status*************"+outletBean.getResourceBean().getAccountStatusBean().getId());
			       System.out.println("*************BranchBefore*************"+outletBean.getBranchBean().getId());
			           
			       
			       }
			       
			       model.put("outlets", outlets); 
			       
			       System.out.println("*****After Model insertion******");
			           List<OutletBean> outlets1=(List<OutletBean>)model.get("outlets");
			       for(int i=0;i<outlets1.size();i++){
			        OutletBean outlet1=outlets.get(i);
			        
			       System.out.println("*************outlets Name************"+outlet1.getUserName());
			       System.out.println("*************Account Status*************"+outlet1.getResourceBean().getAccountStatusBean().getId());
			       System.out.println("*************BranchAfter*************"+outlet1.getBranchBean().getId());
			           
			       
			       }

				return new ModelAndView("outletsList",model);
			}
		}else{
			return new ModelAndView("error");
		}

	}

	@RequestMapping(value = "/getBranch",method = RequestMethod.POST)
	public @ResponseBody BranchModel getBranch(@RequestParam(value = "branch") String branchid,
			HttpSession session)
					throws Exception {
		System.out.println("getBranch executed>>>>>>>>>>>>>>>");
		branchModel=new BranchModel();
		int bid=Integer.parseInt(branchid);
		branchModel.setId(bid);
		branchModel = branchService.getBranchbyId(branchModel);
		System.out.println(branchModel.getName());
		return branchModel;

	}

	@RequestMapping(value = "/updateBranchStatusByAdmin",
			method = RequestMethod.POST)
	public @ResponseBody BranchModel updateBranchStatusByOwner(@RequestParam(value = "branch") String branchId,
			@RequestParam(value = "flag") String flag,
			HttpSession session)
					throws Exception {
		initializeProperties();
		branchModel=new BranchModel();
		int bid=Integer.parseInt(branchId);
		branchModel.setId(bid);
		resourceModel = new ResourceModel();
		accountStatusModel = new StatusModel();

		branchModel=branchService.getBranchbyId(branchModel);

		resourceModel=branchModel.getResourceModel();

		if(flag.contentEquals("0")){
			accountStatusModel.setId(active);
			resourceModel.setAccountStatusModel(accountStatusModel);
		}else{
			accountStatusModel.setId(inactive);
			resourceModel.setAccountStatusModel(accountStatusModel); 

		}
		branchModel.setResourceModel(resourceModel);
		boolean returnresult=branchService.changeBranchStatus(branchModel);
		if(returnresult){
			branchModel=branchService.getBranchbyId(branchModel);
		}

		return branchModel; 

	}

}