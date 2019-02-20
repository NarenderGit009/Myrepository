package com.relyits.rmbs.controller;


import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.relyits.rmbs.beans.registration.BranchBean;
import com.relyits.rmbs.beans.registration.OutletBean;
import com.relyits.rmbs.beans.registration.RegistrationBean;
import com.relyits.rmbs.beans.registration.ResourceBean;
import com.relyits.rmbs.beans.resources.AddressBean;
import com.relyits.rmbs.beans.resources.CategoryBean;
import com.relyits.rmbs.beans.resources.RoleBean;
import com.relyits.rmbs.beans.resources.StatusBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model.registration.OutletModel;
import com.relyits.rmbs.model.registration.ResourceModel;
import com.relyits.rmbs.model_preparation.registration.BranchModelPreparation;
import com.relyits.rmbs.model_preparation.registration.OrganizationModelPreparation;
import com.relyits.rmbs.model_preparation.registration.OutletModelPreparation;
import com.relyits.rmbs.model_preparation.resource.AddressModelPreparation;
import com.relyits.rmbs.service.BranchService;
import com.relyits.rmbs.service.OrganizationService;
import com.relyits.rmbs.service.OutletService;
import com.relyits.rmbs.utilities.ExposablePropertyPaceholderConfigurer;
import com.relyits.rmbs.utilities.FormUtilities;
import com.relyits.rmbs.utilities.SessionUtilities;

@Controller
public class ValidationController {

	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private BranchService branchService;
	@Autowired
	private OutletService outletService;
	//	@Autowired
	//	private HttpServletRequest request;

	@Autowired
	private ExposablePropertyPaceholderConfigurer propertyUtilities;

	
	private static ResourceBean resourceBean = null;
	private static RoleBean roleBean = null;
	private static RoleBean creatorRoleBean = null;
	private static StatusBean accountStatusBean = null;
	private static StatusBean loginStatusBean = null;
	private static CategoryBean roleCategoryBean = null;
	private static CategoryBean creatorRoleCategoryBean = null;
	private static CategoryBean accountStatusCategoryBean = null;
	private static CategoryBean loginstatusCategoryBean = null;
	private static UserSessionBean userSessionBean = null;
	private static BranchBean branchBean = null;
	private static AddressBean addressBean = null;

	private static OrganizationModel organizationModel = null;
	private static BranchModel branchModel = null;
	private static OutletModel outletModel = null;
	static ResourceModel resourceModel = null;
	static AddressModel addressModel = null;
	static RoleModel roleModel = null;
	static RoleModel creatorRoleModel = null;
	static StatusModel accountStatusModel = null;
	static StatusModel loginStatusModel = null;
	static CategoryModel categoryModel = null;
	static CategoryModel accountStatusCategoryModel = null;
	static CategoryModel loginStatusCategoryModel = null;
	static CategoryModel roleCategoryModel = null;
	static CategoryModel creatorRoleCategoryModel = null;

	Map<String, String> properties= null;

	int admin, organization,branch,outlet,inactive,active,offline,online,user,account,login;
	
	String organizationError = null;
	String branchError = null;
	String outletError = null;
	String loginError = null;
	String outletSuccess = null;
	/*private ValidationController(){
		initializeProperties1();
		System.out.println("Constuctor initializeProperties1 admin role >>>>>>>>>>>>>>"+admin);
	}*/

	/******************************************************************************************************/
	/*********************************    Application Launching methods    ***********************************/
	/******************************************************************************************************/


	@Value("${role.admin}") String adminRole;
	@Value("${role.organization}") String organizationRole;
	@Value("${role.branch}") String branchRole;
	@Value("${role.outlet}") String outletRole;
	@Value("${status.inactive}") String inactiveStatus;
	@Value("${status.active}") String activeStatus;
	@Value("${status.offline}") String offlineStatus;
	@Value("${status.online}") String onlineStatus;
	@Value("${category.user}") String userCategory;
	@Value("${category.account}") String accountCategory;
	@Value("${category.login}") String loginCategory;
	@Value("${message.organizationRegistrationError}") String orgError;
	@Value("${message.branchRegistrationError}") String branchError1;
	@Value("${message.outLetRegistrationError}") String outletError1;
	@Value("${message.outLetRegistrationSuccess}") String outletSuccess1;
	@Value("${message.loginerror}") String loginError1;
	
	public Map<String, String> initializeProperties(){

		admin=Integer.parseInt(adminRole);
		organization = Integer.parseInt(organizationRole);
		branch = Integer.parseInt(branchRole);
		outlet = Integer.parseInt(outletRole);
		inactive = Integer.parseInt(inactiveStatus);
		active = Integer.parseInt(activeStatus);
		offline = Integer.parseInt(offlineStatus);
		online = Integer.parseInt(onlineStatus);
		user = Integer.parseInt(userCategory);
		account = Integer.parseInt(accountCategory);
		login = Integer.parseInt(loginCategory);
		organizationError = orgError;
		branchError = branchError1;
		outletError = outletError1;
		loginError = loginError1;
		outletSuccess = outletSuccess1;
		return properties;
	}


	//Application starting here
	@RequestMapping(value = "/index",  method = RequestMethod.GET)
	public ModelAndView welcome() {

		/*	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 */
		final Logger logger = Logger.getLogger(ValidationController.class);
	//	 Logger barlogger = Logger.getLogger(ValidationController.class);
		

		logger.debug("Calling ValidationController start....");
		logger.debug("Calling ValidationController end....");
	//	barlogger.info("It's the Validation Controller ");
	//	barlogger.error("Error in Validation Controller");
	//	barlogger.warn("Warning in Validation Controller");
		
		
		initializeProperties();
		//ExposablePropertyPaceholderConfigurer exprops= new ExposablePropertyPaceholderConfigurer();
		//	 ApplicationContext context = new ClassPathXmlApplicationContext();
		//	System.out.println(context.getBean("propertyConfigurer"));

		return new ModelAndView("redirect:/home.html");
	}




	//launching home page  
	@RequestMapping(value = "/home",  method = RequestMethod.GET)
	public ModelAndView Home(@ModelAttribute("command")  RegistrationBean regitrationBean,BindingResult result) 
	{
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("initials",FormUtilities.getInitial());//getting initials from get initial method to registration form initial drop down
		return new ModelAndView("login", model);
	}

	/*******************************************************************************************************/
	/********************** Registration Availability Validation Methods  ***********************************/
	/**
	 * @throws IOException *****************************************************************************************************/

	@RequestMapping(value ="/validateRegistration",method = RequestMethod.POST)
	public ModelAndView orgnizationRegistrationValidation(HttpSession session,@ModelAttribute("command") RegistrationBean regitrastionBean,BindingResult result,HttpServletRequest request) throws ParseException, IOException 
	{
		
		initializeProperties();
		userSessionBean = (UserSessionBean) session.getAttribute("user");
		organizationModel = new OrganizationModel();
		FormUtilities.generateImagePath(request, regitrastionBean, session);

		organizationModel = OrganizationModelPreparation.prepareOrganizationModel(regitrastionBean);
		OrganizationModel organizationModel1=organizationService.checkAvailabilty(organizationModel);

		if(organizationModel1 == null){
			branchModel = new BranchModel();
			branchModel.setUserName(regitrastionBean.getUserName());
			BranchModel branchModel1 = branchService.checkBranchAvailability(branchModel);
			if(branchModel1==null){
				outletModel = new OutletModel();
				outletModel.setUserName(regitrastionBean.getUserName());
				OutletModel outletModel1=outletService.checkOutletAvailability(outletModel);
				if(outletModel1==null){
					
                     resourceModel = new ResourceModel();
                     creatorRoleModel = new RoleModel();
                     creatorRoleCategoryModel = new CategoryModel();
                     roleModel = new RoleModel();
                     roleCategoryModel = new CategoryModel();
                     accountStatusModel = new StatusModel();
                     accountStatusCategoryModel = new CategoryModel();
                     loginStatusModel = new StatusModel();
                     loginStatusCategoryModel = new CategoryModel();
                     addressModel = new AddressModel();
                                         
                     roleCategoryModel.setId(user);
                     roleModel.setId(organization);
                     roleModel.setCategoryModel(roleCategoryModel);
                     resourceModel.setRoleModel(roleModel);
                     
                     creatorRoleCategoryModel.setId(user);
                     creatorRoleModel.setId(admin);                     
                     creatorRoleModel.setCategoryModel(creatorRoleCategoryModel);
                     resourceModel.setCreatorRoleModel(creatorRoleModel);
                                         
                     accountStatusCategoryModel.setId(account);
                     accountStatusModel.setId(inactive);
                     accountStatusModel.setCategoryModel(accountStatusCategoryModel);
                     resourceModel.setAccountStatusModel(accountStatusModel);
                                         
                     loginStatusCategoryModel.setId(login);
                     loginStatusModel.setId(offline);
                     loginStatusModel.setCategoryModel(loginStatusCategoryModel);
                     resourceModel.setLoginStatusModel(loginStatusModel);
                     
                    
                     
                     resourceModel.setAddressModel(AddressModelPreparation.prepareAddressModel(regitrastionBean.getAddressBean()));
                     
                     organizationModel.setResourceModel(resourceModel);
                     
                     
                    
					session.setAttribute("registrationModel", organizationModel);
					return new ModelAndView("redirect:/OraganizationRegistrationValidationSuccess.html");
				}
			}
		}
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println(organizationError);
		model.put("message",organizationError);
		model.put("initials",FormUtilities.getInitial());
		return new ModelAndView("login", model);
	}

	@RequestMapping(value ="/validateBranchRegistration",method = RequestMethod.POST)
	public ModelAndView branchRegistrationValidation(/*HttpServletRequest request,*/HttpSession session,@ModelAttribute("command") BranchBean branchBean,BindingResult result) throws ParseException 
	{
		
		initializeProperties();
		userSessionBean = (UserSessionBean) session.getAttribute("user");
		organizationModel=new OrganizationModel();
		organizationModel.setUserName(branchBean.getUserName());
		OrganizationModel organizationModel1=organizationService.checkAvailabilty(organizationModel);

		if(organizationModel1==null){
			branchModel = new BranchModel();
			branchModel.setUserName(branchBean.getUserName());
			BranchModel branchModel1 = branchService.checkBranchAvailability(branchModel);
			if(branchModel1==null){
				outletModel = new OutletModel();
				outletModel.setUserName(branchBean.getUserName());
				OutletModel outletModel1=outletService.checkOutletAvailability(outletModel);
				if(outletModel1==null){
					accountStatusBean = new StatusBean();
					accountStatusCategoryBean = new CategoryBean();
					loginStatusBean = new StatusBean();
					loginstatusCategoryBean = new CategoryBean();
					roleBean = new RoleBean();
					creatorRoleBean = new RoleBean();
					resourceBean = new ResourceBean();
					roleCategoryBean = new CategoryBean();
					creatorRoleCategoryBean = new CategoryBean();

					accountStatusBean.setId(inactive);
					accountStatusCategoryBean.setId(account);
					accountStatusBean.setCategoryBean(accountStatusCategoryBean);

					loginStatusBean.setId(offline);
					loginstatusCategoryBean.setId(login);
					loginStatusBean.setCategoryBean(loginstatusCategoryBean);

					roleCategoryBean.setId(user);
					roleBean.setId(branch);
					roleBean.setCategoryBean(roleCategoryBean);

					creatorRoleCategoryBean.setId(userSessionBean.getResourceBean().getRoleBean().getCategoryBean().getId());
					creatorRoleBean.setId(userSessionBean.getResourceBean().getRoleBean().getId());
					creatorRoleBean.setCategoryBean(creatorRoleCategoryBean);

					resourceBean=branchBean.getResourceBean();
					resourceBean.setCreatedBy(userSessionBean.getId());
					resourceBean.setAccountStatusBean(accountStatusBean);
					resourceBean.setLoginStatusBean(loginStatusBean);
					resourceBean.setRoleBean(roleBean);
					resourceBean.setCreatorRoleBean(creatorRoleBean);

					branchBean.setDaysCount(0);
					branchBean.setNoOfOutlets(0);
					branchBean.setResourceBean(resourceBean);

					branchModel = BranchModelPreparation.prepareBranchModel(branchBean);
					//branchModel.setOrganizationModel(OrganizationModelPreparation.prepareOrganizationModelFromUserSessionBean(userSessionBean));
					//organizationModel = ModelPreparationController.prepareUserModel(regitrastionBean);
					organizationModel= new OrganizationModel(); 
					organizationModel.setId(userSessionBean.getId());
					branchModel.setOrganizationModel(organizationModel);

					session.setAttribute("branchModel", branchModel);
					return new ModelAndView("redirect:/BranchRegistrationValidationSuccess.html");
				}
			}
		}
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("BranchErrMessage-->"+branchError);
		model.put("message",branchError);
		model.put("initials",FormUtilities.getInitial());
		return new ModelAndView("reOpenBranchRegisterForm", model);



	}

	@RequestMapping(value ="/validateOutletRegistration",method = RequestMethod.POST)
	public ModelAndView outletRegistrationValidation(/*HttpServletRequest request,*/HttpSession session,@ModelAttribute("command") OutletBean outletBean,BindingResult result) throws ParseException 
	{
		initializeProperties();
		userSessionBean = (UserSessionBean) session.getAttribute("user");
		organizationModel=new OrganizationModel();
		organizationModel.setUserName(outletBean.getUserName());
		OrganizationModel organizationModel1=organizationService.checkAvailabilty(organizationModel);

		if(organizationModel1==null){
			branchModel = new BranchModel();
			branchModel.setUserName(outletBean.getUserName());
			BranchModel branchModel1 = branchService.checkBranchAvailability(branchModel);
			if(branchModel1==null){
				outletModel = new OutletModel();
				outletModel.setUserName(outletBean.getUserName());
				OutletModel outletModel1=outletService.checkOutletAvailability(outletModel);
				if(outletModel1==null){

					accountStatusBean = new StatusBean();
					accountStatusCategoryBean = new CategoryBean();
					loginStatusBean = new StatusBean();
					loginstatusCategoryBean = new CategoryBean();
					roleBean = new RoleBean();
					creatorRoleBean = new RoleBean();
					resourceBean = new ResourceBean();
					roleCategoryBean = new CategoryBean();
					creatorRoleCategoryBean = new CategoryBean();
					branchBean = new BranchBean();
					addressBean = new AddressBean();

					branchBean.setId(userSessionBean.getId());
					//	propertyUtilities.getProperyValue("")
					accountStatusBean.setId(inactive);
					accountStatusCategoryBean.setId(account);
					accountStatusBean.setCategoryBean(accountStatusCategoryBean);

					loginStatusBean.setId(offline);
					loginstatusCategoryBean.setId(login);
					loginStatusBean.setCategoryBean(loginstatusCategoryBean);

					roleCategoryBean.setId(user);
					roleBean.setId(outlet);
					roleBean.setCategoryBean(roleCategoryBean);

					creatorRoleCategoryBean.setId(userSessionBean.getResourceBean().getRoleBean().getCategoryBean().getId());
					creatorRoleBean.setId(userSessionBean.getResourceBean().getRoleBean().getId());
					creatorRoleBean.setCategoryBean(creatorRoleCategoryBean);


					addressBean.setAddress(userSessionBean.getResourceBean().getAddressBean().getAddress());
					addressBean.setEmail(outletBean.getResourceBean().getAddressBean().getEmail());
					addressBean.setMobile(outletBean.getResourceBean().getAddressBean().getMobile());

					resourceBean=outletBean.getResourceBean();
					resourceBean.setAddressBean(addressBean);
					resourceBean.setCreatedBy(userSessionBean.getId());
					resourceBean.setAccountStatusBean(accountStatusBean);
					resourceBean.setLoginStatusBean(loginStatusBean);
					resourceBean.setRoleBean(roleBean);
					resourceBean.setCreatorRoleBean(creatorRoleBean);

					outletBean.setDaysCount(0);
					// outletBean.setNoOfOutlets(0);
					outletBean.setResourceBean(resourceBean);
					outletBean.setBranchBean(branchBean);

					outletModel = OutletModelPreparation.prepareOutletModel(outletBean);


					session.setAttribute("OutletModel", outletModel);
					return new ModelAndView("redirect:/OutletRegistrationValidationSuccess.html");
				}	
			}
		}

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("message",outletError);
		model.put("initials",FormUtilities.getInitial());
		return new ModelAndView("openOutletRegisterForm", model);


	}


	/******************************************************************************************************/
	/*********************************        Login Validations          **********************************/
	/******************************************************************************************************/

	@RequestMapping(value ="/validateLogin",method = RequestMethod.POST)
	public ModelAndView LoginValidation(HttpSession session,@ModelAttribute("command") RegistrationBean registrationBean,BindingResult result) 
	{

		initializeProperties();
		System.out.println("initializeProperties1 admin role >>>>>>>>>>>>>>"+admin);
		organizationModel=new OrganizationModel();
		organizationModel.setUserName(registrationBean.getUserName());
		organizationModel.setPassword(registrationBean.getPassword());
		OrganizationModel organizationModel1=organizationService.loginValidate(organizationModel);
		Map<String, Object> model = new HashMap<String, Object>();

		if(organizationModel1!=null){
			model.put("logger", organizationModel);
			boolean userSession=SessionUtilities.createOrganizationSession(organizationModel1, session);
			System.out.println("*****************"+userSession+"*************");

			if(userSession){
				//				organizationModel.setLastLoginedDateTime(getCurrentDateTime());
				UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);


				if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==active&& userSessionBean.getResourceBean().getRoleBean().getId()==admin){

					return new ModelAndView("redirect:/AdminLoginValidationSuccess.html");

				}else if(/*userSessionBean.getResourceBean().getAccountStatusBean().getId()==active&&*/ userSessionBean.getResourceBean().getRoleBean().getId()==organization){

					return new ModelAndView("redirect:/OrganizationLoginValidationSuccess.html");

				}/*else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==2&& userSessionBean.getResourceBean().getAccountStatusBean().getId()==3){

				 	 return new ModelAndView("redirect:/BranchLoginValidationSuccess.html");

				}else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==2&& userSessionBean.getResourceBean().getAccountStatusBean().getId()==4){

					return new ModelAndView("redirect:/OutletLoginValidationSuccess.html");

				}else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==1&& userSessionBean.getResourceBean().getAccountStatusBean().getId()==1){

					 return new ModelAndView("redirect:/AdminLoginValidationSuccess.html");

				}else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==1&& userSessionBean.getResourceBean().getAccountStatusBean().getId()==2){
		            return new ModelAndView("userInactiveLogin",model); 

				}else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==1&& userSessionBean.getResourceBean().getAccountStatusBean().getId()==3){
		            return new ModelAndView("adminInactiveLogin",model); //

				}else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==1&& userSessionBean.getResourceBean().getAccountStatusBean().getId()==4){
		            return new ModelAndView("userInactiveLogin",model); 

				}*/else{
					model.put("loginerrormessage",loginError);
					model.put("initials",FormUtilities.getInitial());
					return new ModelAndView("login", model);
				}
			}

		}else{
			branchModel = new BranchModel();
			branchModel.setUserName(registrationBean.getUserName());
			branchModel.setPassword(registrationBean.getPassword());
			BranchModel branchModel1 = branchService.checkBranchAvailability(branchModel);
			if(branchModel1!=null){

				boolean userSession=SessionUtilities.createBranchSession(branchModel1, session);
				System.out.println("userSession "+userSession);
				if(userSession){
					System.out.println("USER NAME "+branchModel1.getUserName());
					return new ModelAndView("redirect:/BranchLoginValidationSuccess.html");
				}else{
					model.put("loginerrormessage",loginError);
					model.put("initials",FormUtilities.getInitial());
					return new ModelAndView("login", model);
				}
			}else{
				outletModel = new OutletModel();
				outletModel.setUserName(registrationBean.getUserName());
				outletModel.setPassword(registrationBean.getPassword());
				OutletModel outletModel1 = outletService.checkOutletAvailability(outletModel);
				if(outletModel1!=null){
					boolean userSession=SessionUtilities.createOutletSession(outletModel1, session);
					System.out.println("userSession "+userSession);
					if(userSession){
						System.out.println("USER NAME "+outletModel1.getUserName());
						return new ModelAndView("redirect:/OutletLoginValidationSuccess.html");
					}else{
						model.put("loginerrormessage",loginError);
						model.put("initials",FormUtilities.getInitial());
						return new ModelAndView("login", model);
					}

				}

			}
		}
		model.put("loginerrormessage",loginError);
		model.put("initials",FormUtilities.getInitial());
		return new ModelAndView("login", model);

	}

	//////////////////////////////////// /////////////////////////////////////////////////////
	//////////////////////////    Open Dash Board   //////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value ="/userHome",method = RequestMethod.GET)
	public ModelAndView openDashBoard(HttpSession session,@ModelAttribute("command") RegistrationBean registrationBean,BindingResult result)
	{
		initializeProperties();
		Map<String, Object> model = new HashMap<String, Object>();

		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		if(userSessionBean!=null){
			model.put("logger", userSessionBean);
			if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==active&& userSessionBean.getResourceBean().getRoleBean().getId()==admin){
				return new ModelAndView("redirect:/AdminLoginValidationSuccess.html");
			}else if(/*userSessionBean.getResourceBean().getAccountStatusBean().getId()==active&&*/ userSessionBean.getResourceBean().getRoleBean().getId()==organization){
				return new ModelAndView("redirect:/OrganizationLoginValidationSuccess.html");
			}else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==active&& userSessionBean.getResourceBean().getRoleBean().getId()==branch){
				return new ModelAndView("redirect:/BranchLoginValidationSuccess.html");
			}else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==active&& userSessionBean.getResourceBean().getRoleBean().getId()==outlet){
				return new ModelAndView("redirect:/OutletLoginValidationSuccess.html");
			}/*else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==1&& userSessionBean.getResourceBean().getAccountStatusBean().getId()==1){
          // return new ModelAndView("adminInactiveLogin",model); //
			 return new ModelAndView("redirect:/AdminLoginValidationSuccess.html");
	 	}else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==1&& userSessionBean.getResourceBean().getAccountStatusBean().getId()==2){
           return new ModelAndView("userInactiveLogin",model); 
		}else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==1&& userSessionBean.getResourceBean().getAccountStatusBean().getId()==3){
           return new ModelAndView("adminInactiveLogin",model); //
  		}else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==1&& userSessionBean.getResourceBean().getAccountStatusBean().getId()==4){
           return new ModelAndView("userInactiveLogin",model); 
	 	}*/else{
	 		model.put("loginerrormessage",loginError);
	 		model.put("initials",FormUtilities.getInitial());
	 		return new ModelAndView("login", model);
	 	}
		}else{
			//here we have to check the branch owner login details in user branches table
			System.out.println(loginError);
			model.put("loginerrormessage",loginError);
			model.put("initials",FormUtilities.getInitial());
			return new ModelAndView("login", model);
		}
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////                 Logout          //////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////	

	@RequestMapping(value ="/logout",
			method = RequestMethod.GET)
	public ModelAndView doLogout(HttpSession session,
			@ModelAttribute("command") 
	RegistrationBean registrationBean, 
	BindingResult result)
	{
		session.invalidate();
		return new ModelAndView("redirect:/home.html");
	}
	/////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////  List Validations  /////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(value ="/getUserList",
			method = RequestMethod.GET)
	public ModelAndView generateUserListByRole(HttpSession session,
			@ModelAttribute("command") 
	RegistrationBean registrationBean, 
	BindingResult result)
	{
		initializeProperties();
		UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
		if(userSessionBean.getResourceBean().getRoleBean().getId()==admin){
			return new ModelAndView("redirect:/organizationsList.html");
		}else if(userSessionBean.getResourceBean().getRoleBean().getId()==organization){
			return new ModelAndView("redirect:/branchesList.html");
		}else if(userSessionBean.getResourceBean().getRoleBean().getId()==branch){
			return new ModelAndView("redirect:/outletsList.html");
		}
		return new ModelAndView("error");

	}




}
