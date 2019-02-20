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


import com.relyits.rmbs.beans.resources.AddressBean;
import com.relyits.rmbs.beans.resources.CategoryBean;
import com.relyits.rmbs.beans.resources.RoleBean;
import com.relyits.rmbs.beans.resources.StatusBean;
import com.relyits.rmbs.beans.registration.DoctorBean;
import com.relyits.rmbs.beans.registration.ResourceBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.beans_preparation.registration.DoctorBeanPreparation;
import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.registration.DoctorModel;
import com.relyits.rmbs.model.registration.ResourceModel;
import com.relyits.rmbs.model_preparation.registration.DoctorModelPreparation;
import com.relyits.rmbs.service.DoctorService;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;
import com.relyits.rmbs.utilities.FormUtilities;
import com.relyits.rmbs.utilities.SessionUtilities;



@Controller
public class DoctorController {

	@Autowired
	private DoctorService doctorService;	

	private static DoctorModel doctorModel = null;
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
	int doctor;
	int disable ;
	int enable;
	int delete;
	int offline;
	int inactive;
	int active;
	int account;
	int login;
	int user;
	String doctorSuccess = null;

	@Value("${role.admin}") String adminRole;
	@Value("${role.doctor}") String doctorRole;
	@Value("${status.disable}") String disableStatus;
	@Value("${status.enable}") String enableStatus;
	@Value("${status.delete}") String deleteStatus;
	@Value("${status.offline}") String offlineStatus;
	@Value("${status.inactive}") String inactiveStatus;
	@Value("${status.active}") String activeStatus;	
	@Value("${category.account}") String accountCategory;
	@Value("${category.login}") String loginCategory;
	@Value("${category.user}") String userCategory;
	@Value("${message.registerDoctorSuccess}") String doctorSuccess1;


	public Map<String, String> initializeProperties(){

		admin=Integer.parseInt(adminRole);
		doctor = Integer.parseInt(doctorRole);
		enable = Integer.parseInt(enableStatus);
		disable = Integer.parseInt(disableStatus);
		delete = Integer.parseInt(deleteStatus);
		inactive = Integer.parseInt(inactiveStatus);
		active = Integer.parseInt(activeStatus);
		offline = Integer.parseInt(offlineStatus);
		user = Integer.parseInt(userCategory);
		account = Integer.parseInt(accountCategory);
		login = Integer.parseInt(loginCategory);
		doctorSuccess = doctorSuccess1;


		return properties;
	}

	/////////////////////////***********************///////////////////////

	@RequestMapping(value="/doctorForm" , method=RequestMethod.GET)
	public ModelAndView doctorRegistrationForm(// @RequestParam(value = "uid") String id,
			HttpSession session,
			@ModelAttribute("command") DoctorBean doctorBean){
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){		

			try {
				model = new HashMap<String, Object>();
				// model.put("agencies",  prepareListofAgencyBean(doctorService.listAgencies()));
				model.put("createdby",userSessionBean.getId());
				System.out.println("method called");
			} catch (Exception e) {
				e.printStackTrace();
			}
			model.put("initials",FormUtilities.getInitial());
			return new ModelAndView("openDoctorForm", model);
		}else{
			return new ModelAndView("error");
		}

	}



	@RequestMapping(value = "/addDoctor",method = RequestMethod.POST)
	public ModelAndView addDoctor(HttpSession session,
			@ModelAttribute("command") DoctorBean doctorBean,BindingResult result,
			@RequestParam(value="flag") String flag)
					throws Exception  {	

		initializeProperties();

		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){		
			System.out.println("*******Doctor Registration******");
			int returnMode=0;
			doctorBean.getId();
			if(doctorBean!=null){

				if(doctorBean.getId()!=null){
					returnMode=1;
					doctorModel = new DoctorModel();
					doctorModel.setId(doctorBean.getId());
					doctorModel=doctorService.getDoctor(doctorModel);

					System.out.println("******if*******");
					DoctorBean oldDoctorBean=DoctorBeanPreparation.prepareDoctorBean(doctorModel);

					resourceBean= oldDoctorBean.getResourceBean();              			

					addressBean = doctorBean.getResourceBean().getAddressBean();//new address
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

					doctorBean.setCreatedDate(oldDoctorBean.getCreatedDate());
					doctorBean.setResourceBean(resourceBean);


					doctorModel = DoctorModelPreparation.prepareDoctorModel(doctorBean);


				}else{

					//	doctorBean=prepareDoctorBean(doctorModel);

					System.out.println("**********else**********");

					resourceBean= doctorBean.getResourceBean();

					addressBean = doctorBean.getResourceBean().getAddressBean();

					/*	accountStatusBean = new StatusBean();
		    accountStatusBean.setId(Integer.parseInt(enable3));

		    loginStatusBean = new StatusBean();
		    loginStatusBean.setId(Integer.parseInt(offline3));

		    roleBean = new RoleBean();
		    roleBean.setId(Integer.parseInt(role3));		  

		    creatorRoleBean = new RoleBean();
		    creatorRoleBean.setId(mode[1]);

		    accountCategoryBean = new CategoryBean();
		    accountCategoryBean.setId(Integer.parseInt(account));*/
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
					roleBean.setId(doctor);
					roleBean.setCategoryBean(roleCategoryBean);

					creatorRoleCategoryBean.setId(user);
					creatorRoleBean.setId(admin);
					creatorRoleBean.setCategoryBean(creatorRoleCategoryBean);

					resourceBean.setAddressBean(addressBean);
					resourceBean.setAccountStatusBean(accountStatusBean);
					resourceBean.setLoginStatusBean(loginStatusBean);
					resourceBean.setRoleBean(roleBean);
					resourceBean.setCreatorRoleBean(creatorRoleBean);
					resourceBean.setCreatedBy(doctorBean.getResourceBean().getCreatedBy());


					doctorBean.setResourceBean(resourceBean);
					doctorBean.setCreatedDate(DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime()));


					doctorModel = DoctorModelPreparation.prepareDoctorModel(doctorBean);		

				}


				/*	mappingDetails.put("Role", Integer.parseInt(roleDoctor));
		mappingDetails.put("Ac_Status", Integer.parseInt(enable));
		mappingDetails.put("C_Role", mode[1]);
		mappingDetails.put("Lg_Status", Integer.parseInt(offline));*/
				//	DoctorModel doctorModel =ModelPreparationController.prepareDoctorRegisterModel(doctorBean,mappingDetails);
				model = new HashMap<String, Object>();
				//	ResourceModel resourceModel = new ResourceModel();
				if(doctorModel!=null){

					boolean returnResult = doctorService.registerDoctor(doctorModel);
					//model.put("agency", agencyRegisterBean);

					if(returnResult){
						if(returnMode==0){
							System.out.println(returnResult);
							model.put("msg", doctorSuccess);	
							model.put("initials",FormUtilities.getInitial());
							return new ModelAndView("doctorForm",model); 
						}else{
							model.put("doctors",  DoctorBeanPreparation.prepareListofDoctorBean(doctorService.listDoctorsByCreator(doctorModel)));
							model.put("Enable",enable);
							model.put("Disable",disable);
							model.put("Delete",delete);

							return new ModelAndView("doctorsList",model);
						}
					}
				}

			}



		}
		return new ModelAndView("error");
	}	



	@RequestMapping(value = "/validateDoctor",method = RequestMethod.POST)
	public @ResponseBody String validateDoctor(HttpSession session,
			@RequestParam(value="doctorName") String doctorName,
			@RequestParam(value="uid") String id )
					throws Exception{
		/*		int mode[]=SessionUtilities.validateSession(id, session);
			System.out.println("user session "+mode[0]+", user role "+mode[1]);
			if(mode[0]==1){
		 */  initializeProperties();
		 doctorModel = new DoctorModel();
		 resourceModel.setCreatedBy(Integer.parseInt(id));
		 accountStatusModel.setId(enable);
		 resourceModel.setAccountStatusModel(accountStatusModel);
		 doctorModel.setResourceModel(resourceModel);
		 doctorModel.setDoctorName(doctorName);
		 String doctor="enable3";


		 DoctorModel doctorModel1=doctorService.getDoctor(doctorModel);


		 if(doctorModel1!=null){
			 doctor=doctorModel1.getDoctorName();
		 }else{

		 }
		 System.out.println(doctor);

		 return doctor;
		 //		}
		 //		return message2;

	}


	@RequestMapping(value = "/doctorsList", method = RequestMethod.GET)
	public ModelAndView doctorsList(HttpSession session,
			@ModelAttribute("command") DoctorBean doctorBean,	
			BindingResult result){
		//	@RequestParam(value="uid") String id 
		initializeProperties();
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){		
			Map<String, Object> model = new HashMap<String, Object>();
			doctorModel = new DoctorModel();
			resourceModel = new ResourceModel();
			accountStatusModel = new StatusModel();

			resourceModel.setCreatedBy(userSessionBean.getId());		     
			accountStatusModel.setId(enable);     
			resourceModel.setAccountStatusModel(accountStatusModel);
			doctorModel.setResourceModel(resourceModel);
			//     DoctorModel doctorModel =ModelPreparationController.prepareDoctorRegisterModel(doctorBean,mappingDetails);  
			model.put("doctors",  DoctorBeanPreparation.prepareListofDoctorBean(doctorService.listDoctorsByCreator(doctorModel)));
			model.put("Enable",enable);
			model.put("Disable",disable);
			model.put("Delete",delete);

			/*	    List<DoctorBean> doctors=(List<DoctorBean>)model.get("doctors");
		     for(int i=0;i<doctors.size();i++){
		    	 DoctorBean doctor=doctors.get(i);

		     System.out.println("*************Name************"+doctor.getDoctorName());
		     System.out.println("*************CreatedBy*************"+doctor.getResourceBean().getAccountStatusBean().getId());
		     System.out.println("*************CreatedBy*************"+doctor.getResourceBean().getCreatedBy());


		     }*/

			return new ModelAndView("doctorsLists", model);
		}else{
			return new ModelAndView("error");
		}


	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getDoctor",
			method = RequestMethod.POST)
	public ModelAndView editDoctor(HttpSession session,
			@ModelAttribute("command")
	DoctorBean doctorBean,BindingResult result,
	@RequestParam(value="id") String doctorid)
			throws Exception {
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){		
			System.out.println("editDoctor called");
			doctorModel = new DoctorModel();
			doctorModel.setId(Integer.parseInt(doctorid));
			doctorModel=doctorService.getDoctor(doctorModel);

			Map<String, Object> model = new HashMap<String, Object>();
			model.put("initials",FormUtilities.getInitial());

			model.put("doctor",  DoctorBeanPreparation.prepareDoctorBean(doctorModel)); 
			model.put("doctors", DoctorBeanPreparation.prepareListofDoctorBean(doctorService.listDoctors()));
			DoctorBean doctorBean1=(DoctorBean)model.get("doctor");
			if(doctorBean1==null){

				System.out.println("*************Name************"+doctorBean1.getDoctorName());
				System.out.println("*************CreatedBy*************"+doctorBean1.getResourceBean().getAccountStatusBean().getId());
				System.out.println("*************CreatedBy*************"+doctorBean1.getResourceBean().getCreatedBy());


			}
			System.out.println("**************Doctors list*************");
			List<DoctorBean> doctors=(List<DoctorBean>)model.get("doctors");
			for(int i=0;i<doctors.size();i++){
				doctorBean1=doctors.get(i);

				System.out.println("*************Name************"+doctorBean1.getDoctorName());
				System.out.println("*************CreatedBy*************"+doctorBean1.getResourceBean().getAccountStatusBean().getId());
				System.out.println("*************CreatedBy*************"+doctorBean1.getResourceBean().getCreatedBy());


			}

			return new ModelAndView("editDoctorForm", model);
		}else{
			return new ModelAndView("error");
		}

	}



	@RequestMapping(value = "/changeDoctorStatus",
			method = RequestMethod.POST)
	public ModelAndView updateDoctorStatus(HttpSession session,
			@ModelAttribute("command") DoctorBean doctorBean,
			@RequestParam(value="uid") String createdBy,
			@RequestParam(value="id") String doctorid,
			@RequestParam(value="flag") String flag)
					throws Exception {
		initializeProperties();
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){	


			doctorModel = new DoctorModel();
			doctorModel.setId(Integer.parseInt(doctorid));
			doctorModel=doctorService.getDoctor(doctorModel);	

			resourceModel = doctorModel.getResourceModel();
			accountStatusModel = new StatusModel();		 


			//	 doctorModel.setId(Integer.parseInt(doctorid));
			System.out.println("Doctor Id"+doctorModel.getId());

			if(flag.contentEquals("0")){
				accountStatusModel.setId(disable);
				resourceModel.setAccountStatusModel(accountStatusModel);
				doctorModel.setResourceModel(resourceModel);
				doctorService.disableDoctor(doctorModel);
			}else if(flag.contentEquals("1")){
				accountStatusModel.setId(enable);
				resourceModel.setAccountStatusModel(accountStatusModel);
				doctorModel.setResourceModel(resourceModel);
				doctorService.enableDoctor(doctorModel);
			}else{
				accountStatusModel.setId(delete);
				resourceModel.setAccountStatusModel(accountStatusModel);
				doctorModel.setResourceModel(resourceModel);
				doctorService.deleteDoctor(doctorModel);
			}
			model = new HashMap<String, Object>();
			doctorModel = new DoctorModel();
			resourceModel = new ResourceModel();
			accountStatusModel = new StatusModel();

			resourceModel.setCreatedBy(Integer.parseInt(createdBy));		     
			accountStatusModel.setId(enable);     
			resourceModel.setAccountStatusModel(accountStatusModel);
			doctorModel.setResourceModel(resourceModel);
			//     DoctorModel doctorModel =ModelPreparationController.prepareDoctorRegisterModel(doctorBean,mappingDetails);  
			model.put("doctors",  DoctorBeanPreparation.prepareListofDoctorBean(doctorService.listDoctorsByCreator(doctorModel)));
			model.put("Enable",enable);
			model.put("Disable",disable);
			model.put("Delete",delete);

			/*	    List<DoctorBean> doctors=(List<DoctorBean>)model.get("doctors");
		     for(int i=0;i<doctors.size();i++){
		    	 DoctorBean doctor=doctors.get(i);

		     System.out.println("*************Name************"+doctor.getDoctorName());
		     System.out.println("*************CreatedBy*************"+doctor.getResourceBean().getAccountStatusBean().getId());
		     System.out.println("*************CreatedBy*************"+doctor.getResourceBean().getCreatedBy());


		     }*/return new ModelAndView("doctorsList",model);
		     //	return new ModelAndView("redirect:/doctorsList.html?uid="+createdBy);
		}else{
			return new ModelAndView("error");
		}

	}		

	@RequestMapping(value = "/updateDoctors", 
			method = RequestMethod.POST)
	public ModelAndView updateDoctorsStatus(HttpSession session,
			@ModelAttribute("command") DoctorBean doctorBean,
			@RequestParam(value="uid") String uid,
			@RequestParam(value="flag") String flag)
					throws Exception {
		initializeProperties();
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){	
			doctorModel = new DoctorModel(); 
			accountStatusModel = new StatusModel();
			resourceModel = new ResourceModel();

			resourceModel.setCreatedBy(Integer.parseInt(uid));

			if(flag.contentEquals("0")){
				accountStatusModel.setId(enable);
				resourceModel.setAccountStatusModel(accountStatusModel);
				doctorModel.setResourceModel(resourceModel);
				doctorService.enableAllDoctors(doctorModel);
			}else if(flag.contentEquals("1")){
				accountStatusModel.setId(disable);
				resourceModel.setAccountStatusModel(accountStatusModel);
				doctorModel.setResourceModel(resourceModel);    
				doctorService.disableAllDoctors(doctorModel);
			}else if(flag.contentEquals("2")){
				accountStatusModel.setId(delete);
				resourceModel.setAccountStatusModel(accountStatusModel);
				doctorModel.setResourceModel(resourceModel);
				doctorService.deleteAllDoctors(doctorModel);
			}
			model = new HashMap<String, Object>();

			model.put("msg", doctorSuccess);
			//model.put("agencies",  prepareListofAgencyBean(doctorService.listAgencies()));
			model.put("doctors",  DoctorBeanPreparation.prepareListofDoctorBean(doctorService.listDoctorsByCreator(doctorModel)));
			model.put("Enable",enable);
			model.put("Disable",disable);
			model.put("Delete",delete);

			return new ModelAndView("doctorsList",model);

		}else{
			return new ModelAndView("error");
		}
	}

	@RequestMapping(value = "/getDoctorssByCategory", 
			method = RequestMethod.POST)
	public ModelAndView doctorsListByCategory(HttpSession session,
			@ModelAttribute("command") DoctorBean doctorBean,
			BindingResult result,
			@RequestParam(value="uid") String uid,
			@RequestParam(value="flag") String flag) {
		initializeProperties();
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){	
			model = new HashMap<String, Object>();
			doctorModel = new DoctorModel();
			resourceModel = new ResourceModel();
			accountStatusModel = new StatusModel();

			resourceModel.setCreatedBy(Integer.parseInt(uid));

			if(flag.contentEquals("T")){
				model.put("doctors",  DoctorBeanPreparation.prepareListofDoctorBean(doctorService.listDoctorsByCreator(doctorModel)));
				model.put("Enable",enable);
				model.put("Disable",disable);
				model.put("Delete",delete);
			}else if(flag.contentEquals("0")){
				accountStatusModel.setId(enable);
				resourceModel.setAccountStatusModel(accountStatusModel);
				doctorModel.setResourceModel(resourceModel);
				model.put("doctors",  DoctorBeanPreparation.prepareListofDoctorBean(doctorService.listDoctorsByCategory(doctorModel)));
				model.put("Enable",enable);
				model.put("Disable",disable);
				model.put("Delete",delete);
			}else{
				accountStatusModel.setId(disable);
				resourceModel.setAccountStatusModel(accountStatusModel);
				doctorModel.setResourceModel(resourceModel);
				model.put("doctors",  DoctorBeanPreparation.prepareListofDoctorBean(doctorService.listDoctorsByCategory(doctorModel)));
				model.put("Enable",enable);
				model.put("Disable",disable);
				model.put("Delete",delete);
			}
			return new ModelAndView("doctorsList", model);
		}else{
			return new ModelAndView("error");
		}

	}





}
