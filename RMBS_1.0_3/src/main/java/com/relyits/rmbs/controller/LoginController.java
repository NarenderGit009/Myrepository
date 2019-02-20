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



import com.relyits.rmbs.beans.menu.MenuBean;
import com.relyits.rmbs.beans.registration.RegistrationBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.model.menu.ChildMenuModel;
import com.relyits.rmbs.model.menu.MenuModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.service.OrganizationService;
import com.relyits.rmbs.utilities.FormUtilities;
import com.relyits.rmbs.utilities.SessionUtilities;

@Controller
public class LoginController {

	@Autowired
	private OrganizationService organizationService;

	private UserSessionBean userSessionBean = null;
	private Map<String, Object> model = null;


	Map<String, String> properties= null;

	int admin;
	int organization ;
	int branch;
	int outlet;
	int inactive;
	int active;
	String loginError = null;

	@Value("${role.admin}") String adminRole;
	@Value("${role.organization}") String organizationRole;
	@Value("${role.branch}") String branchRole;
	@Value("${role.outlet}") String outletRole;
	@Value("${status.inactive}") String inactiveStatus;
	@Value("${status.active}") String activeStatus;	
	@Value("${message.loginerror}") String loginError1;

	public Map<String, String> initializeProperties(){

		admin=Integer.parseInt(adminRole);
		organization = Integer.parseInt(organizationRole);
		branch = Integer.parseInt(branchRole);
		outlet = Integer.parseInt(outletRole);
		inactive = Integer.parseInt(inactiveStatus);
		active = Integer.parseInt(activeStatus);		
		loginError = loginError1;

		return properties;
	}


	////////////*************************////////////////////////


	@RequestMapping(value ="/AdminLoginValidationSuccess", method = RequestMethod.GET)
	public ModelAndView adminLogin(@ModelAttribute("command") RegistrationBean registrationBean,BindingResult result,HttpSession session)
	{
		initializeProperties();
		userSessionBean=SessionUtilities.giveMeSession(session);
		int[] mode=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		if(mode[0]==1 && mode[1]==1){
			model = new HashMap<String, Object>();
			if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==inactive && userSessionBean.getResourceBean().getRoleBean().getId()==admin){
				model.put("Logger",  userSessionBean);
				return new ModelAndView("adminInactiveLogin", model);
			}else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==active && userSessionBean.getResourceBean().getRoleBean().getId()==admin){
				model.put("Logger",  userSessionBean);
				return new ModelAndView("adminLoginSucces", model);
			}else{
				System.out.println(loginError);
				model.put("Logger",  userSessionBean);
				model.put("message",loginError);
				model.put("initials",FormUtilities.getInitial());
				return new ModelAndView("login", model);
			}
		} 
		return new ModelAndView("error");
	}

	@RequestMapping(value ="/OrganizationLoginValidationSuccess",method = RequestMethod.GET)
	public ModelAndView organizationLogin(@ModelAttribute("command") RegistrationBean registrationBean,BindingResult result,HttpSession session)
	{
		initializeProperties();
		userSessionBean=SessionUtilities.giveMeSession(session);
		int[] mode=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		if(mode[0]==1 && mode[1]==2){
			model = new HashMap<String, Object>();
			if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==inactive && userSessionBean.getResourceBean().getRoleBean().getId()==organization){
				model.put("Logger",  userSessionBean);
				return new ModelAndView("organizationInactiveLogin", model);
			}else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==active && userSessionBean.getResourceBean().getRoleBean().getId()==organization){
				model.put("Logger",  userSessionBean);
				return new ModelAndView("organizationLoginSucces", model);
			}else{
				System.out.println(loginError);
				model.put("Logger",  userSessionBean);
				model.put("message",loginError);
				model.put("initials",FormUtilities.getInitial());
				return new ModelAndView("login", model);
			}
		} 
		return new ModelAndView("error");
	}

	@RequestMapping(value ="/BranchLoginValidationSuccess",  method = RequestMethod.GET)
	public ModelAndView branchLogin(HttpSession session,@ModelAttribute("command") RegistrationBean registrationBean,BindingResult result)
	{
		initializeProperties();
		userSessionBean=SessionUtilities.giveMeSession(session);
		int[] mode=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		if(mode[0]==1 && mode[1]==3){
			model = new HashMap<String, Object>();
			if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==inactive && userSessionBean.getResourceBean().getRoleBean().getId()==branch){
				System.out.println("Inactive login");
				model.put("Logger",  userSessionBean);
				return new ModelAndView("branchInactiveLogin", model);
			}else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==active&& userSessionBean.getResourceBean().getRoleBean().getId()==branch){
				System.out.println("Active login");
				model.put("Logger",  userSessionBean);
				return new ModelAndView("branchLoginSucces", model);
			}else{
				System.out.println(loginError);
				model.put("Logger",  userSessionBean);
				model.put("message",loginError);
				model.put("initials",FormUtilities.getInitial());
				return new ModelAndView("login", model);
			}
		} 
		return new ModelAndView("error");
	}

	@RequestMapping(value ="/OutletLoginValidationSuccess", method = RequestMethod.GET)
	public ModelAndView outletLogin(HttpSession session,@ModelAttribute("command") RegistrationBean registrationBean,BindingResult result)
	{
		initializeProperties();
		userSessionBean=SessionUtilities.giveMeSession(session);
		int[] mode=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		if(mode[0]==1 && mode[1]==4){
			model = new HashMap<String, Object>();
			if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==inactive && userSessionBean.getResourceBean().getRoleBean().getId()==outlet){
				System.out.println("Inactive login");
				model.put("Logger",  userSessionBean);
				return new ModelAndView("outLetInactiveLogin", model);
			}else if(userSessionBean.getResourceBean().getAccountStatusBean().getId()==active&& userSessionBean.getResourceBean().getRoleBean().getId()==outlet){
				System.out.println("Active login");
				model.put("Logger",  userSessionBean);
				return new ModelAndView("outletLoginSucces", model);
			}else{
				System.out.println(loginError);
				model.put("Logger",  userSessionBean);
				model.put("message",loginError);
				model.put("initials",FormUtilities.getInitial());
				return new ModelAndView("login", model);
			}
		} 
		return new ModelAndView("error");
	}








	/*	@Value("${message.registrationerror}")
    private String message;
	@RequestMapping(value ="/register", 
			        method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("command") 
	                                 UserRegistrationBean userregistrationbean, 
			                         BindingResult result)
	   {
		OrganizationModel userregister = ModelPreparationController.prepareUserModel(userregistrationbean);
		OrganizationModel userregister1=userService.checkAvailabilty(userregister);
		if(userregister1==null){
		boolean returnResult=userService.createOraganization(userregister);
		return new ModelAndView("redirect:/login.html");
		}else{
			Map<String, Object> model = new HashMap<String, Object>();
			System.out.println(message);
			model.put("message",message);
			model.put("initials",getinitial());
			return new ModelAndView("login", model);
		}
	}
/*	@Value("${message.loginerror}")
    private String loginerror;
	@RequestMapping(value ="/dologin",
			        method = RequestMethod.POST)
	public ModelAndView doLogin(HttpSession session,
			                    @ModelAttribute("command") 
	                            UserRegistrationBean userregistrationbean, 
			                    BindingResult result) 
	{

		OrganizationModel userregister=new OrganizationModel();
		userregister.setUsername(userregistrationbean.getUsername());
		userregister.setPassword(userregistrationbean.getPassword());
		userregister=userService.loginValidate(userregister);
		Map<String, Object> model = new HashMap<String, Object>();
		if(userregister!=null){
			String msg=createSession(userregister,session);
			System.out.println("*****************"+msg+"*************");
			userregister.setLastlogineddatetime(getCurrentDateTime());
			userregister.setStatus("Y");
			userService.registerUser(userregister);
            model.put("Logger",  userregister);
			 if(userregister.getActive().contentEquals("Y") && userregister.getRole().contentEquals("1")){
		            return new ModelAndView("adminLoginSucces",model);
			 }else if(userregister.getActive().contentEquals("Y") && userregister.getRole().contentEquals("2")){

		            return new ModelAndView("userLoginSucces",model);
	         }else if(userregister.getActive().contentEquals("N") && userregister.getRole().contentEquals("1")){

		            return new ModelAndView("adminInactiveLogin",model); 
			 }else if(userregister.getActive().contentEquals("N") && userregister.getRole().contentEquals("2")){

		            return new ModelAndView("userInactiveLogin",model); 
			 }else{
				 model.put("loginerrormessage",loginerror);
					model.put("initials",getinitial());
					return new ModelAndView("login", model);
			 }

		}else{
			//here we have to check the branch owner login details in user branches table
			System.out.println(loginerror);
			model.put("loginerrormessage",loginerror);
			model.put("initials",getinitial());
			return new ModelAndView("login", model);
		}
	}

	@RequestMapping(value ="/home",
    method = RequestMethod.GET)
public ModelAndView goToHome(HttpSession session,
		                     @RequestParam(value="aid") String aid)
{
		 String mode[]=validateSession(aid, session);
			System.out.println("user session "+mode[0]+", user role "+mode[1]);
			Map<String, Object> model = new HashMap<String, Object>();
			if(mode[0].contentEquals("1")){
				if(mode[1].contentEquals("1")){
					 return new ModelAndView("adminLoginSucces",model);
				}else{
					System.out.println("user login");
					 return new ModelAndView("userLoginSucces",model);
				}
			}
			return new ModelAndView("error");

}*/

	@RequestMapping(value ="/changePassword", 
			method = RequestMethod.GET)
	public ModelAndView changePassword(@ModelAttribute("command") 
	RegistrationBean registrationBean, 
	BindingResult result)
	{
		initializeProperties();
		model = new HashMap<String, Object>();
		OrganizationModel organizationModel=organizationService.getUser(registrationBean.getId());
		//	model.put("Logger", BeanPreparationController.prepareRegistrationBean(organizationModel));
		System.out.println(organizationModel.getPassword());
		if(organizationModel.getResourceModel().getAccountStatusModel().getId()==inactive){
			return new ModelAndView("inactiveUserPwdChange",model);
		}else{
			return new ModelAndView("activeUserPwdChange",model);	
		}
	}


	@RequestMapping(value = "/saveMenu",
			method = RequestMethod.POST)
	public @ResponseBody String createMenu(HttpSession session,
			@ModelAttribute("command") MenuBean menuBean,
			@RequestParam(value="menu") String menu,
			@RequestParam(value="flag") String flag)
					throws Exception {

		// menuBean.setChildMenuIds(menu);
		MenuModel menuModel = new MenuModel();
		menuModel.setChildMenuIds(menu);


		organizationService.createUserMenu(menuModel);

		System.out.println("menu      "+menu);
		// System.out.println("flag      "+flag);
		return "amar";
	}

	@RequestMapping(value = "/loadMenu",
			method = RequestMethod.POST)
	public @ResponseBody List<ChildMenuModel> getChildMenu(HttpSession session,
			@ModelAttribute("command") ChildMenuModel childMenuModel,
			@RequestParam(value="flag") String flag)
					throws Exception {
		return null;
		/*	 OrganizationModel organizationModel=ValidationController.giveMeSession(session);
		 String parentMenuOPtions=organizationModel.getResourceModel().getMenuModel().getParentMenuIds();
		 String childMenuOPtions=organizationModel.getResourceModel().getMenuModel().getChildMenuIds();
		 String[] parent = parentMenuOPtions.split(",");

		 String[] child = childMenuOPtions.split(",");
		 int[] childId = new int[50];
		 int j=0;
		 childId[j]=Integer.parseInt(flag);
		 for (String i : child){
			 System.out.println("id----"+i);
		//	 childId= new int[j+1];
			 childId[j+1]=Integer.parseInt(i);
			 System.out.println("childId[j]----"+childId);
			 j++;
		 }

		 List<ChildMenuModel> childMenuModels= userService.getUserchildMenu(childId);

		 System.out.println(childMenuModels);
			 return childMenuModels;*/
	}

	/*	loadMenu
	 * @RequestMapping(value = "/getProduct",
				        method = RequestMethod.POST)
		public @ResponseBody ProductEntryBean getProduct(HttpSession session,
				                                         @ModelAttribute("command") ProductEntryBean productEntryBean,
		                                                 @RequestParam(value="pid") String productid,
		                                                 @RequestParam(value="flag") String flag)
				                                         throws Exception {
			Product productModel=new Product();
		    productModel.setPid(Integer.parseInt(productid));
		    productModel=masterService.getProduct(productModel);
		    ProductInventory productInventoryModel = new ProductInventory();
		    productInventoryModel.setProduct(productModel);
		    productEntryBean=prepareProductEnrtyBean(productInventoryModel);
		  //  productEntryBean.setMfcompany(productModel.getMfcompany());
		  //  productEntryBean.setSchdrug(productModel.getSchdrug());
		  //  productEntryBean.setSubcategory(productModel.getSubcategory());
			return productEntryBean;
		}*/
	public static void getUserMenu(OrganizationModel organizationModel){
		/*	 String parentMenuOPtions=organizationModel.getResourceModel().getMenuModel().getParentMenuIds();
		 String childMenuOPtions=organizationModel.getResourceModel().getMenuModel().getChildMenuIds();
		 String[] parent = parentMenuOPtions.split(",");

		 String[] child = childMenuOPtions.split(",");
		 System.out.println("parent ******************** "+parent.length);

		 System.out.println("child *********************** "+child.length);*/
	}

	/* public static String createSession(OrganizationModel userregister,HttpSession session){

		 session.setAttribute("user",userregister );

		// getUserMenu(userregister);
		// LoginController lg=new LoginController();
		 //lg.getChildMenu(userregister);

		 return "session created";

	 }
	 ;
	 public static OrganizationModel giveMeSession(HttpSession session){
		 Object o=(Object)session.getAttribute("user");
		 OrganizationModel ur=(OrganizationModel)o;

		 return ur;

	 }

	 public static String[] validateSession(String id,HttpSession session){
		    String user[] = new String[10];
		    user[0]="0";
			//Object o=(Object)session.getAttribute("user");
			// OrganizationModel ur=(OrganizationModel)o;
		    OrganizationModel ur= giveMeSession(session);
			if(ur!=null && id!=null){
			 if(ur.getUserId()==Integer.parseInt(id)){
				 user[0]="1";
				 user[1]=ur.getRole();
				 user[2]=ur.getShopname();

				 return user;
			 }else{

		         return user;
			 }
	 }else{

         return user;
	 }
			}*/
}
