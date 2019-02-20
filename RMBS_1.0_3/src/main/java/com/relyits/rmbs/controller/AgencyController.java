package com.relyits.rmbs.controller;

import java.util.HashMap;
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

import com.relyits.rmbs.beans.registration.AgencyBean;
import com.relyits.rmbs.beans.registration.ResourceBean;
import com.relyits.rmbs.beans.resources.AddressBean;
import com.relyits.rmbs.beans.resources.CategoryBean;
import com.relyits.rmbs.beans.resources.RoleBean;
import com.relyits.rmbs.beans.resources.StatusBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.beans_preparation.registration.AgencyBeanPreparation;
import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.registration.AgencyModel;
import com.relyits.rmbs.model.registration.ResourceModel;
import com.relyits.rmbs.model_preparation.registration.AgencyModelPreparation;
import com.relyits.rmbs.service.AgencyService;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;
import com.relyits.rmbs.utilities.SessionUtilities;

@Controller
public class AgencyController {

	@Autowired
	private AgencyService agencyService;

	private static AgencyModel agencyModel = null;
	private static ResourceBean resourceBean = null;
	private static AddressBean addressBean = null; 
	private static RoleBean roleBean = null;
	private static RoleBean creatorRoleBean = null;
	private static StatusBean accountStatusBean = null;
	private static StatusBean loginStatusBean = null;
//	private static CategoryBean categoryBean = null;
	private static CategoryBean roleCategoryBean = null;
	private static CategoryBean creatorRoleCategoryBean = null;
	private static CategoryBean accountStatusCategoryBean = null;
	private static CategoryBean loginStatusCategoryBean = null;

	static ResourceModel resourceModel = null;
	static AddressModel addressModel = null;
	static RoleModel roleModel = null;
	static RoleModel creatorRoleModel = null;
	static StatusModel accountStatusModel = null;
	static StatusModel loginStatusModel = null;
	static CategoryModel categoryModel = null;

	Map<String, Object> model = null;

	Map<String, String> properties= null;

	int admin;
	int agency;
	int disable ;
	int enable;
	int delete;
	int offline;
	int inactive;
	int active;
	int account;
	int login;
	int user;
	String agencySuccess = null;

	@Value("${role.admin}") String adminRole;
	@Value("${role.agency}") String agencyRole;
	@Value("${status.disable}") String disableStatus;
	@Value("${status.enable}") String enableStatus;
	@Value("${status.delete}") String deleteStatus;
	@Value("${status.offline}") String offlineStatus;
	@Value("${status.inactive}") String inactiveStatus;
	@Value("${status.active}") String activeStatus;	
	@Value("${category.account}") String accountCategory;
	@Value("${category.login}") String loginCategory;
	@Value("${category.user}") String userCategory;
	@Value("${message.registerAgencySuccess}") String agencySuccess1;


	public Map<String, String> initializeProperties(){

		admin=Integer.parseInt(adminRole);
		agency = Integer.parseInt(agencyRole);
		enable = Integer.parseInt(enableStatus);
		disable = Integer.parseInt(disableStatus);
		delete = Integer.parseInt(deleteStatus);
		inactive = Integer.parseInt(inactiveStatus);
		active = Integer.parseInt(activeStatus);
		offline = Integer.parseInt(offlineStatus);
		user = Integer.parseInt(userCategory);
		account = Integer.parseInt(accountCategory);
		login = Integer.parseInt(loginCategory);
		agencySuccess = agencySuccess1;


		return properties;
	}
	////////////////////////////********************/////////////////////////////


	@RequestMapping(value="/agencyForm" ,
			method=RequestMethod.GET)
	public ModelAndView agencyForm( //@RequestParam(value = "uid") String id,
			HttpSession session,
			@ModelAttribute("command") AgencyBean agencyBean)
	{

		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){
			try {
				model = new HashMap<String, Object>();
				// model.put("agencies",  prepareListofAgencyBean(agencyService.listAgencies()));
				model.put("createdBy",userSessionBean.getId());
				System.out.println("method called");
			} catch (Exception e) {

				e.printStackTrace();
			}
			return new ModelAndView("openAgencyForm", model);
		}else{
			return new ModelAndView("error");
		}

	}

	@RequestMapping(value = "/validateagency",
			method = RequestMethod.POST)
	public @ResponseBody String validateagency(HttpSession session,
			@RequestParam(value="agency") String agencyName,
			@RequestParam(value="uid") String userid )
					throws Exception{
		//	int mode[]=SessionUtilities.validateSession(userid, session);
		//	System.out.println("user session "+mode[0]+", user role "+mode[1]);
		//	if(mode[0]==1){ 
		initializeProperties();
		agencyModel = new AgencyModel();
		resourceModel = new ResourceModel();
		accountStatusModel = new StatusModel();

		resourceModel.setCreatedBy(Integer.parseInt(userid));
		accountStatusModel.setId(enable);
		resourceModel.setAccountStatusModel(accountStatusModel);
		agencyModel.setAgencyName(agencyName);
		agencyModel.setResourceModel(resourceModel);
		String agency="E";


		AgencyModel agencyModel1=agencyService.getAgency(agencyModel);

		if(agencyModel1!=null){
			agency=agencyModel1.getAgencyName();
		}else{

		}

		System.out.println(agency);
		return agency;

	}


	@RequestMapping(value = "/addAgency",
			method = RequestMethod.POST)
	public ModelAndView add(HttpSession session,
			@ModelAttribute("command") AgencyBean agencyBean,BindingResult result,
			@RequestParam(value="flag") String flag)
					throws Exception  {
		initializeProperties();
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){
			System.out.println("*******Agency Registration******");

			agencyBean.getId();
			int returnMode = 0;
			if(agencyBean!=null){
				if(agencyBean.getId()!=null){
					returnMode = 1;
					agencyModel = new AgencyModel();
					agencyModel.setId(agencyBean.getId());
					agencyModel=agencyService.getAgency(agencyModel);

					System.out.println("******if*******");
					AgencyBean oldAgencyBean = AgencyBeanPreparation.prepareAgencyBean(agencyModel);

					resourceBean= oldAgencyBean.getResourceBean();              			

					addressBean = agencyBean.getResourceBean().getAddressBean();//new address
					addressBean.setId(resourceBean.getAddressBean().getId()); // assigning old address id to the new address

					accountStatusBean = resourceBean.getAccountStatusBean();

					loginStatusBean = resourceBean.getLoginStatusBean();

					roleBean = resourceBean.getRoleBean();

					creatorRoleBean = resourceBean.getCreatorRoleBean();


					resourceBean.setAddressBean(addressBean);
					resourceBean.setAccountStatusBean(accountStatusBean);
					resourceBean.setLoginStatusBean(loginStatusBean);
					resourceBean.setRoleBean(roleBean);
					resourceBean.setCreatorRoleBean(creatorRoleBean);

					agencyBean.setCreatedDate(oldAgencyBean.getCreatedDate());
					agencyBean.setResourceBean(resourceBean);


					agencyModel = AgencyModelPreparation.prepareAgencyModel(agencyBean);


				}else{

					//	doctorBean=prepareDoctorBean(doctorModel);

					System.out.println("**********else**********");

					resourceBean= agencyBean.getResourceBean();

					addressBean = agencyBean.getResourceBean().getAddressBean();

					accountStatusBean = new StatusBean();
					accountStatusCategoryBean = new CategoryBean();
					loginStatusBean = new StatusBean();
					loginStatusCategoryBean = new CategoryBean();
					roleBean = new RoleBean();
					creatorRoleBean = new RoleBean();
					resourceBean = new ResourceBean();
					roleCategoryBean = new CategoryBean();
					creatorRoleCategoryBean = new CategoryBean();

					accountStatusBean.setId(enable);
					accountStatusCategoryBean.setId(account);
					accountStatusBean.setCategoryBean(accountStatusCategoryBean);

					loginStatusBean.setId(offline);
					loginStatusCategoryBean.setId(login);
					loginStatusBean.setCategoryBean(loginStatusCategoryBean);

					roleCategoryBean.setId(user);
					roleBean.setId(agency);
					roleBean.setCategoryBean(roleCategoryBean);

					creatorRoleCategoryBean.setId(user);
					creatorRoleBean.setId(admin);
					creatorRoleBean.setCategoryBean(creatorRoleCategoryBean);

					resourceBean.setAddressBean(addressBean);
					resourceBean.setAccountStatusBean(accountStatusBean);
					resourceBean.setLoginStatusBean(loginStatusBean);
					resourceBean.setRoleBean(roleBean);
					resourceBean.setCreatorRoleBean(creatorRoleBean);
					resourceBean.setCreatedBy(agencyBean.getResourceBean().getCreatedBy());


					agencyBean.setResourceBean(resourceBean);
					agencyBean.setCreatedDate(DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime()));


					agencyModel = AgencyModelPreparation.prepareAgencyModel(agencyBean);		

				}


				model = new HashMap<String, Object>();
				//  AgencyModel agencyModel =AgencyModelPreparation.prepareAgencyModel(agencyBean);
				//   agencyModel.setStatus("E");
				if(agencyModel!=null){
					boolean returnResult = agencyService.registerAgency(agencyModel);

					if(returnResult){  
						if(returnMode==0){
							System.out.println(returnResult);
							model.put("msg", agencySuccess);			 
							return new ModelAndView("agencyForm",model); 
						}else{
							// model.put("agencies",  prepareListofAgencyBean(agencyService.listAgencies()));
							model.put("agencies",  AgencyBeanPreparation.prepareListofAgencyBean(agencyService.listAgenciesByCreator(agencyModel)));
							model.put("Enable",enable);
							model.put("Disable",disable);
							model.put("Delete",delete);

							return new ModelAndView("agenciesList",model);
						}    
					}
				} 
			}
		}
		return new ModelAndView("error");
	}


	@RequestMapping(value = "/agenciesList",
			method = RequestMethod.GET)
	public ModelAndView agenciesList(HttpSession session,
			@ModelAttribute("command") AgencyBean agencyBean,	
			BindingResult result) {
		//	@RequestParam(value="uid") String id
		initializeProperties();
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){
			model = new HashMap<String, Object>();
			agencyModel = new AgencyModel();		   
			resourceModel = new ResourceModel();
			accountStatusModel = new StatusModel();

			resourceModel.setCreatedBy(userSessionBean.getId());
			accountStatusModel.setId(enable); 
			resourceModel.setAccountStatusModel(accountStatusModel);
			agencyModel.setResourceModel(resourceModel);
			// model.put("agencies",  prepareListofAgencyBean(agencyService.listAgencies()));
			model.put("agencies",  AgencyBeanPreparation.prepareListofAgencyBean(agencyService.listAgenciesByCreator(agencyModel)));
			model.put("Enable",enable);
			model.put("Disable",disable);
			model.put("Delete",delete);

			return new ModelAndView("agenciesLists", model);
		}else{
			return new ModelAndView("error");
		}

	}


	@RequestMapping(value = "/editAgency",				
			method = RequestMethod.POST)
	public ModelAndView editDoctor(HttpSession session,
			@ModelAttribute("command")
	AgencyBean agencyBean,BindingResult result,
	@RequestParam(value="id") String agencyId)
			throws Exception {

		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){		
			System.out.println("editAgency called");
			agencyModel = new AgencyModel();
			agencyModel.setId(Integer.parseInt(agencyId));
			agencyModel=agencyService.getAgency(agencyModel);

			model = new HashMap<String, Object>();         
			model.put("agency",  AgencyBeanPreparation.prepareAgencyBean(agencyModel)); 
			model.put("agencies", AgencyBeanPreparation.prepareListofAgencyBean(agencyService.listAgencies()));
			AgencyBean agencyBean1=(AgencyBean)model.get("agency");
			if(agencyBean1!=null){

				System.out.println("*************Name************"+agencyBean1.getAgencyName());
				System.out.println("*************CreatedBy*************"+agencyBean1.getResourceBean().getAccountStatusBean().getId());
				System.out.println("*************CreatedBy*************"+agencyBean1.getResourceBean().getCreatedBy());


			}
			/*    System.out.println("**************Agencies list*************");
       		    List<AgencyBean> agencies=(List<AgencyBean>)model.get("agencies");
		     for(int i=0;i<agencies.size();i++){
		    	 agencyBean1=agencies.get(i);

		     System.out.println("*************Name************"+agencyBean1.getAgencyName());
		     System.out.println("*************CreatedBy*************"+agencyBean1.getResourceBean().getAccountStatusBean().getId());
		     System.out.println("*************CreatedBy*************"+agencyBean1.getResourceBean().getCreatedBy());


		     }*/

			return new ModelAndView("EditAgencyForm", model);
		}else{
			return new ModelAndView("error");
		}

	}	

	@RequestMapping(value = "/changeAgencyStatus",
			method = RequestMethod.POST)
	public ModelAndView agencyStatusUpdate(HttpSession session,
			@ModelAttribute("command") AgencyBean agencyBean,
			@RequestParam(value="uid") String createdBy,
			@RequestParam(value="id") String id,
			@RequestParam(value="flag") String flag)
					throws Exception {
		initializeProperties();
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){
			agencyModel=new AgencyModel();
			agencyModel.setId(Integer.parseInt(id));
			agencyModel = agencyService.getAgency(agencyModel);

			resourceModel = agencyModel.getResourceModel();
			accountStatusModel = new StatusModel();	 		

			if(flag.contentEquals("0")){
				accountStatusModel.setId(disable);
				resourceModel.setAccountStatusModel(accountStatusModel);
				agencyModel.setResourceModel(resourceModel);                        	 
				agencyService.disableAgency(agencyModel);
			}else if(flag.contentEquals("1")){
				accountStatusModel.setId(delete);
				resourceModel.setAccountStatusModel(accountStatusModel);
				agencyModel.setResourceModel(resourceModel);		        	
				agencyService.deleteAgency(agencyModel);
			}else{   
				accountStatusModel.setId(enable);
				resourceModel.setAccountStatusModel(accountStatusModel);
				agencyModel.setResourceModel(resourceModel);
				agencyService.enableAgency(agencyModel);
			}

			model = new HashMap<String, Object>();
			agencyModel = new AgencyModel();
			resourceModel = new ResourceModel();  
			accountStatusModel = new StatusModel();

			resourceModel.setCreatedBy(Integer.parseInt(createdBy));		     
			accountStatusModel.setId(enable);     
			resourceModel.setAccountStatusModel(accountStatusModel);
			agencyModel.setResourceModel(resourceModel);        

			model.put("msg", agencySuccess);
			//model.put("agencies",  prepareListofAgencyBean(agencyService.listAgencies()));
			model.put("agencies",  AgencyBeanPreparation.prepareListofAgencyBean(agencyService.listAgenciesByCreator(agencyModel)));
			model.put("Enable",enable);
			model.put("Disable",disable);
			model.put("Delete",delete);
			return new ModelAndView("agenciesList",model);
		}else{
			return new ModelAndView("error");
		}

	}

	@RequestMapping(value = "/updateAgencies", 
			method = RequestMethod.POST)
	public ModelAndView updateAgenciesStatus(HttpSession session,
			@ModelAttribute("command") AgencyBean agencyBean,
			@RequestParam(value="uid") String uid,
			@RequestParam(value="flag") String flag)
					throws Exception {
		initializeProperties();
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){
			agencyModel = new AgencyModel();
			resourceModel = new ResourceModel();
			accountStatusModel = new StatusModel();

			resourceModel.setCreatedBy(Integer.parseInt(uid));

			if(flag.contentEquals("0")){
				accountStatusModel.setId(enable);
				resourceModel.setAccountStatusModel(accountStatusModel);
				agencyModel.setResourceModel(resourceModel);
				agencyService.enableAllAgencies(agencyModel);
			}else if(flag.contentEquals("1")){
				accountStatusModel.setId(disable);
				resourceModel.setAccountStatusModel(accountStatusModel);
				agencyModel.setResourceModel(resourceModel);
				agencyService.disableAllAgencies(agencyModel);
			}else if(flag.contentEquals("2")){
				accountStatusModel.setId(delete);
				resourceModel.setAccountStatusModel(accountStatusModel);
				agencyModel.setResourceModel(resourceModel);
				agencyService.deleteAllAgencies(agencyModel);
			}
			model = new HashMap<String, Object>();

			model.put("msg", agencySuccess);
			//model.put("agencies",  prepareListofAgencyBean(agencyService.listAgencies()));
			model.put("agencies",  AgencyBeanPreparation.prepareListofAgencyBean(agencyService.listAgenciesByCreator(agencyModel)));
			model.put("Enable",enable);
			model.put("Disable",disable);
			model.put("Delete",delete);

			return new ModelAndView("agenciesList",model);
		}else{
			return new ModelAndView("error");
		}
	}

	@RequestMapping(value = "/getAgenciesByCategory", 
			method = RequestMethod.POST)
	public ModelAndView agenciesListByCategory(HttpSession session,
			@ModelAttribute("command") AgencyBean agencyBean,
			BindingResult result,

			@RequestParam(value="uid") String uid,
			@RequestParam(value="flag") String flag) {
		initializeProperties();
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){
			Map<String, Object> model = new HashMap<String, Object>();
			agencyModel = new AgencyModel();
			resourceModel = new ResourceModel();
			accountStatusModel = new StatusModel();

			resourceModel.setCreatedBy(Integer.parseInt(uid));


			if(flag.contentEquals("T")){

				model.put("agencies",  AgencyBeanPreparation.prepareListofAgencyBean(agencyService.listAgenciesByCreator(agencyModel)));
				model.put("Enable",enable);
				model.put("Disable",disable);
				model.put("Delete",delete);
			}else if(flag.contentEquals("0")){
				accountStatusModel.setId(enable);
				resourceModel.setAccountStatusModel(accountStatusModel);
				agencyModel.setResourceModel(resourceModel);	
				model.put("agencies",  AgencyBeanPreparation.prepareListofAgencyBean(agencyService.listAgenciesByCategory(agencyModel)));
				model.put("Enable",enable);
				model.put("Disable",disable);
				model.put("Delete",delete);
			}else{   
				accountStatusModel.setId(disable);
				resourceModel.setAccountStatusModel(accountStatusModel);
				agencyModel.setResourceModel(resourceModel);
				model.put("agencies",  AgencyBeanPreparation.prepareListofAgencyBean(agencyService.listAgenciesByCategory(agencyModel))); 
				model.put("Enable",enable);
				model.put("Disable",disable);
				model.put("Delete",delete);
			}
			//  	agencyModel.setStatus(flag);
			//	 model.put("agencies",  AgencyBeanPreparation.prepareListofAgencyBean(agencyService.listAgenciesByCategory(agencyModel)));

			return new ModelAndView("agenciesList", model);
		}else{
			return new ModelAndView("error");
		}

	}

}
