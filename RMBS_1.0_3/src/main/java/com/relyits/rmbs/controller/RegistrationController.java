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
import org.springframework.web.servlet.ModelAndView;

import com.relyits.rmbs.beans.registration.BranchBean;
import com.relyits.rmbs.beans.registration.OutletBean;
import com.relyits.rmbs.beans.registration.RegistrationBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model.registration.OutletModel;
import com.relyits.rmbs.model.registration.ResourceModel;
import com.relyits.rmbs.service.BranchService;
import com.relyits.rmbs.service.OrganizationService;
import com.relyits.rmbs.service.OutletService;
import com.relyits.rmbs.utilities.FormUtilities;
import com.relyits.rmbs.utilities.SessionUtilities;

@Controller
public class RegistrationController {

	@Autowired
	private OrganizationService organizationService;

	@Autowired
	private BranchService branchService;

	@Autowired
	private OutletService outletService;	

	private static UserSessionBean userSessionBean = null;

	static ResourceModel resourceModel = null;
	static AddressModel addressModel = null;
	static RoleModel roleModel = null;
	static RoleModel creatorRoleModel = null;
	static StatusModel accountStatusModel = null;
	static StatusModel loginStatusModel = null;
	static CategoryModel categoryModel = null;


	Map<String, String> properties= null;

	String organizationError = null;
	String branchError = null;
	String outletError = null;
	String loginError = null;
	String organizationSuccess = null;
	String branchSuccess= null;
	String outletSuccess = null;

	@Value("${message.organizationRegistrationError}") String orgError;
	@Value("${message.branchRegistrationError}") String branchError1;
	@Value("${message.outLetRegistrationError}") String outletError1;
	@Value("${message.loginerror}") String loginError1;
	@Value("${message.organizationRegistrationSuccess}") String orgSuccess;
	@Value("${message.branchRegistrationSuccess}") String branchSuccess1;
	@Value("${message.outLetRegistrationError}") String outletSuccess1;


	public Map<String, String> initializeProperties(){

		organizationError = orgError;
		branchError = branchError1;
		outletError = outletError1;
		loginError = loginError1;
		organizationSuccess = orgSuccess;
		branchSuccess = branchSuccess1;
		outletSuccess = outletSuccess1;

		return properties;
	}


	@RequestMapping(value ="/OraganizationRegistrationValidationSuccess", method = RequestMethod.GET)
	public ModelAndView registerUser(HttpSession session,@ModelAttribute("command") RegistrationBean registrationBean, BindingResult result)
	{
		initializeProperties();  
		
		OrganizationModel organizationModel=(OrganizationModel) session.getAttribute("registrationModel");
		System.out.println("registerUser of registration controller");
		session.removeAttribute("registrationModel");
		Map<String, Object> model = new HashMap<String, Object>();
		if(organizationModel!=null){

			boolean retutnResult=organizationService.createOraganization(organizationModel);
			if(retutnResult){
				System.out.println(retutnResult);
				model.put("message",organizationSuccess);
				model.put("initials",FormUtilities.getInitial());
				return new ModelAndView("login", model);
			}else{
				System.out.println(retutnResult);
				model.put("message",organizationError);
				model.put("initials",FormUtilities.getInitial());
				return new ModelAndView("login", model);	
			}
		}else{

			System.out.println(organizationError);
			model.put("message",organizationError);
			model.put("initials",FormUtilities.getInitial());
			return new ModelAndView("login", model);
		}
	}


	//@Value("${message.registrationerror}")
	// private String message;
	@RequestMapping(value ="/openBranchFrom1", 
			method = RequestMethod.GET)
	public ModelAndView openBranch(HttpSession session,
		//	@RequestParam(value="uid") String uid,
			@ModelAttribute("command") 
	BranchBean branchBean, 
	BindingResult result)
	{

	     userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){

			Map<String, Object> model = new HashMap<String, Object>();
			//    model.put("categories", getcategories());
			//    model.put("msg", productEntryBean.getMsg());

			model.put("createdby",userSessionBean.getId());
			model.put("shopname",mode[2]);
			model.put("initials",FormUtilities.getInitial());

			System.out.println(" Rerurn to openBranchRegisterForm");

			return new ModelAndView("openBranchRegisterForm",model);
		}else{
			return new ModelAndView("error");
		}



	}

	@RequestMapping(value ="/BranchRegistrationValidationSuccess", method = RequestMethod.GET)
	public ModelAndView registerBranch(/*HttpServletRequest request,*/HttpSession session,@ModelAttribute("command") BranchBean branchBean, BindingResult result)
	{
		initializeProperties();

		//String requestString=(String) request.getAttribute("sample");
		//System.out.println("from request BranchModel object "+requestString);

		BranchModel branchModel=(BranchModel) session.getAttribute("branchModel");
		System.out.println("register branch of registration controller");
		session.removeAttribute("branchModel");
		Map<String, Object> model = new HashMap<String, Object>();
		if(branchModel!=null){

			boolean retutnResult=branchService.createBranch(branchModel);
			if(retutnResult){
				System.out.println(branchSuccess);
				model.put("message",branchSuccess);
				model.put("initials",FormUtilities.getInitial());
				return new ModelAndView("reOpenBranchRegisterForm",model);
			}

		}	
		System.out.println(branchError);
		model.put("message",branchError);
		model.put("initials",FormUtilities.getInitial());
		return new ModelAndView("reOpenBranchRegisterForm", model);

	}
	
	@RequestMapping(value ="/openOutletForm", 
			method = RequestMethod.GET)
	public ModelAndView openOutlet(HttpSession session,@ModelAttribute("command") OutletBean outletBean,BindingResult result)
	{
		userSessionBean = SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){

			Map<String, Object> model = new HashMap<String, Object>();
			/*	 model.put("BranchName", userSessionBean.getName());
		 model.put("OrgnizationName", userSessionBean.getOrganizationBean().getName());
		 model.put("OrganizationId",userSessionBean.getOrganizationBean().getId());
		 model.put("BranchId",userSessionBean.getId());*/
			//model.put("shopname",mode[2]);
			model.put("initials",FormUtilities.getInitial());
			/*     outletBean = new OutletBean();
	     OrganizationBean organizationBean = new OrganizationBean();
	     BranchBean branchBean = new BranchBean();
	     AddressBean addressBean = new AddressBean();
	     RoleBean roleBean = new RoleBean();
	     RoleBean creatorRoleBean = new RoleBean();
	     StatusBean accountStatusBean = new StatusBean();
	     StatusBean loginStatusBean = new StatusBean();

	     organizationBean.setId(userSessionBean.getOrganizationBean().getId());
	     branchBean.setId(userSessionBean.getId());
	     addressBean.setId(userSessionBean.getResourceBean().getAddressBean().getId());
	     roleBean.setId(4);
	     creatorRoleBean.setId(userSessionBean.getResourceBean().getRoleBean().getId());
	     accountStatusBean.setId(1);
	     loginStatusBean.setId(3);

			 */

			System.out.println(" Rerurn to openOutletRegisterForm");

			return new ModelAndView("openOutletRegisterForm",model);
		}else{
			return new ModelAndView("error");
		}



	}

	@RequestMapping(value ="/OutletRegistrationValidationSuccess", method = RequestMethod.GET)
	public ModelAndView registerOutlet(HttpSession session,@ModelAttribute("command") OutletBean outletBean, BindingResult result)
	{
		initializeProperties();

		OutletModel outletModel=(OutletModel) session.getAttribute("OutletModel");
		System.out.println("register outlet of registration controller");
		session.removeAttribute("OutletModel");
		Map<String, Object> model = new HashMap<String, Object>();
		if(outletModel!=null){

			boolean retutnResult=outletService.createOutlet(outletModel);
			if(retutnResult){
				System.out.println("OutletSccessMessage"+outletSuccess);
				model.put("message",outletSuccess);
				model.put("initials",FormUtilities.getInitial());
				return new ModelAndView("openOutletRegisterForm",model);
			}

		}	
		System.out.println("OutletErrMessage"+outletError+" "+outletModel);
		model.put("message",outletError);
		model.put("initials",FormUtilities.getInitial());
		return new ModelAndView("openOutletRegisterForm", model);

	}

}


