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

import com.relyits.rmbs.beans.registration.RegistrationBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model.registration.ResourceModel;
import com.relyits.rmbs.service.BranchService;
import com.relyits.rmbs.service.OrganizationService;
import com.relyits.rmbs.utilities.SessionUtilities;

@Controller
public class OrganizationController {


	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private BranchService branchService;


	BranchModel branchModel = null;
	OrganizationModel organizationModel = null;
	UserSessionBean userSessionBean = null;

	ResourceModel resourceModel = null;
	StatusModel accountStatusModel = null;
	StatusModel loginStatusModel = null;

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

	//////////////////////**********************////////////////////

	@RequestMapping(value = "/updateOrgStatusByAdmin",
			method = RequestMethod.POST)
	public @ResponseBody OrganizationModel updateOwnerStatusByAdmin(@RequestParam(value = "owner") String Organization,
			@RequestParam(value = "menu") String menuOptions,
			@RequestParam(value = "flag") String flag,
			HttpSession session)
					throws Exception {
		userSessionBean = (UserSessionBean) session.getAttribute("user");
		initializeProperties();
		organizationModel=new OrganizationModel();
		int OrgId=Integer.parseInt(Organization);
		organizationModel.setId(OrgId);
		organizationModel=organizationService.getOrganizationbyId(organizationModel);
		accountStatusModel = new StatusModel();
		resourceModel = new ResourceModel();
		
       
		accountStatusModel=organizationModel.getResourceModel().getAccountStatusModel();
		resourceModel=organizationModel.getResourceModel();

		int returnResult=0;
		if(flag.contentEquals("0")){
			accountStatusModel.setId(active);
			 resourceModel.setCreatedBy(userSessionBean.getId());
			resourceModel.setAccountStatusModel(accountStatusModel);

		}else{
			//   	active="N";
			accountStatusModel.setId(inactive);
			resourceModel.setAccountStatusModel(accountStatusModel);

		}


		organizationModel.setResourceModel(resourceModel);
		returnResult=organizationService.changeOrganizationStatus(organizationModel);
		if(returnResult!=0){
			organizationModel=organizationService.getOrganizationbyId(organizationModel);

		}else{

		}
		return organizationModel; 

	}


	@RequestMapping(value = "/organizationsList", method = RequestMethod.GET)
	public ModelAndView ownersList(HttpSession session,@ModelAttribute("command")  
	RegistrationBean registrationBean,
	BindingResult result)
	{
		initializeProperties();
		System.out.println("************************organizationsList*********************");
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		System.out.println("************************"+userSessionBean+"*********************");
		int mode[]=SessionUtilities.validateSession(""+userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){
			organizationModel=new OrganizationModel();

			resourceModel = new ResourceModel();
			accountStatusModel = new StatusModel();

			accountStatusModel.setId(active);

			resourceModel.setAccountStatusModel(accountStatusModel);


			Map<String, Object> model = new HashMap<String, Object>();
			if(mode[1]==1){

				organizationModel.setResourceModel(resourceModel);
				model.put("users", organizationService.getAccountRequestsByOrganizations(organizationModel));
				@SuppressWarnings("unchecked")
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
				branchModel.setResourceModel(resourceModel);

				model.put("branches", branchService.getAccountRequestsByBranches(branchModel)); 

				return new ModelAndView("roleThreeUsersList",model); 

			}else{
				branchModel.setResourceModel(resourceModel); 
				model.put("branches", branchService.getAccountRequestsByBranches(branchModel)); 

				return new ModelAndView("roleThreeUsersList",model);
			}
		}else{
			return new ModelAndView("error");
		}

	}

	@RequestMapping(value = "/getUser",
			method = RequestMethod.POST)
	public @ResponseBody OrganizationModel getUser(@RequestParam(value = "owner") String userid,
			HttpSession session)
					throws Exception {
		organizationModel=new OrganizationModel();
		int orgId=Integer.parseInt(userid);
		organizationModel.setId(orgId);
		return organizationService.getOrganizationbyId(organizationModel);

	}




}
