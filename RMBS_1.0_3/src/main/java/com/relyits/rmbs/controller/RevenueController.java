package com.relyits.rmbs.controller;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.springframework.web.servlet.ModelAndView;

import com.relyits.rmbs.beans.purchase.PurchaseOrderBean;
import com.relyits.rmbs.beans.sales.RevenueBean;
import com.relyits.rmbs.beans.sales.SalesOrderBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.beans_preparation.purchase.PurchaseOrderBeanPreparation;
import com.relyits.rmbs.beans_preparation.sales.SalesOrderBeanPreparation;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model.sales.SalesOrderModel;
import com.relyits.rmbs.service.BranchService;
import com.relyits.rmbs.service.OrganizationService;
import com.relyits.rmbs.service.OutletService;
import com.relyits.rmbs.service.RevenueService;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;
import com.relyits.rmbs.utilities.FormUtilities;
import com.relyits.rmbs.utilities.SessionUtilities;

@Controller
public class RevenueController {

	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private BranchService branchService;
	@Autowired
	private OutletService outletService;
	
	@Autowired
	private RevenueService revenueService;
	
	@Autowired
	private PurchaseOrderController purchaseController;

	
	private UserSessionBean userSessionBean = null;
	
	private BranchModel branchModel = null;
	private OrganizationModel organizationModel = null;
	private CategoryModel categoryModel = null;
	
	
//	private List<PurchaseOrderBean> purchaseOrderBeans=null;
//	private List<SalesOrderBean> salesOrderBeans=null;
	
	private Map<String, Object> model=null;
	private Map<String, String> properties= null;
	
	private int organization,branch,outlet,salesId,preSalesId;	
	
	private String purchase = null;
	private String sales = null;
	private String preSales = null;
	
	private Date fromDate = null;
	private Date toDate = null;
	@Value("${category.medical}") String categorymedical;
	@Value("${category.general}") String categorygeneral;
	@Value("${category.sales}") String categorysales;
	@Value("${category.pre_sales}") String categorypresales;
	@Value("${role.organization}") String org;
	@Value("${role.branch}") String branchRole;
	@Value("${role.outlet}") String outletRole;
	@Value("${period.today}") String todayRevenue;
	@Value("${period.month}") String monthlyRevenue;
	@Value("${period.quarter}") String quarterlyRevenue;
	@Value("${period.halfyear}") String halfRevenue;
	@Value("${period.year}") String yearlyRevenue;
	@Value("${revenue.sales}") String salesRevenue;
	@Value("${revenue.preSales}") String preSalesRevenue;
	@Value("${revenue.purchase}") String purchaseRevenue;
	
	public Map<String, String> initializeProperties(){

		organization = Integer.parseInt(org);
		branch = Integer.parseInt(branchRole);
		outlet = Integer.parseInt(outletRole);
		salesId = Integer.parseInt(categorysales);
		preSalesId = Integer.parseInt(categorypresales);
		sales = salesRevenue.trim();
		purchase = purchaseRevenue.trim();
		preSales = preSalesRevenue.trim();
		

		return properties;
	}
	
	@RequestMapping(value = "/openRevenueAccounts",method = RequestMethod.GET)
	public ModelAndView openRevenueAccountsForm(HttpSession session,
			@ModelAttribute("command") RevenueBean revenueBean,
			BindingResult result){
	
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		initializeProperties();
		if(mode[0]==1){
			branchModel = new BranchModel();
			organizationModel = new OrganizationModel();				
			model=new HashMap<String , Object>();
			if(mode[1] == branch){
				branchModel.setId(mode[2]);
				branchModel = branchService.getBranchbyId(branchModel);
				model.put("branch", userSessionBean.getName());	
				model.put("branchId", userSessionBean.getId());	
				model.put("select", "--select--");
				model.put("revenueId", 0);
				model.put("timePeriod", FormUtilities.getPeriodOfTime());
				model.put("categories", FormUtilities.getCategories());
				

			}
			else if(mode[1] == organization){
				organizationModel.setId(userSessionBean.getId());
				branchModel.setOrganizationModel(organizationModel);
				model.put("branch", "--Select Branch--");
				model.put("branchId", 0);				
				model.put("branches", purchaseController.getBranches(branchModel));
				model.put("select", "--select--");
				model.put("timePeriod", FormUtilities.getPeriodOfTime());
				model.put("categories", FormUtilities.getCategories());
				
			}
				return new ModelAndView("openRevenueAccountsForm",model);
		}
		else{
			return new ModelAndView("error",model);
		}
	}
	
	
	@RequestMapping(value = "/revenueAccounts",method = RequestMethod.POST)
	public ModelAndView revenueAccountsOfPurchase(HttpSession session,@ModelAttribute("command")RevenueBean revenueBean,
			BindingResult result) throws ParseException{
		initializeProperties();
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){
			
		branchModel = new BranchModel();
		categoryModel = new CategoryModel();
		branchModel.setId(revenueBean.getBranchBean().getId());	
		Calendar cal = Calendar.getInstance();
		String key = revenueBean.getRevenueAccount();
		String type = revenueBean.getType();
		switch (key) {
		case "Today":
			fromDate = DateAndTimeUtilities.parseStringDateToDateFormat(DateAndTimeUtilities.getCurrentDate());
			toDate=DateAndTimeUtilities.parseStringDateToDateFormat(DateAndTimeUtilities.getCurrentDate());
			break;
					
		case "Month":
			toDate=DateAndTimeUtilities.parseStringDateToDateFormat(DateAndTimeUtilities.getCurrentDate());
			fromDate = DateAndTimeUtilities.parseStringDateToDateFormat(DateAndTimeUtilities.getSubtractedDate(cal,0));
			break;
		case "Quarter":
			toDate=DateAndTimeUtilities.parseStringDateToDateFormat(DateAndTimeUtilities.getCurrentDate());
			fromDate = DateAndTimeUtilities.parseStringDateToDateFormat(DateAndTimeUtilities.getSubtractedDate(cal,2));
			break;
		case "HalfYear":
			toDate=DateAndTimeUtilities.parseStringDateToDateFormat(DateAndTimeUtilities.getCurrentDate());
			fromDate = DateAndTimeUtilities.parseStringDateToDateFormat(DateAndTimeUtilities.getSubtractedDate(cal,5));
			break;
		case "Year":
			toDate=DateAndTimeUtilities.parseStringDateToDateFormat(DateAndTimeUtilities.getCurrentDate());
			fromDate = DateAndTimeUtilities.parseStringDateToDateFormat(DateAndTimeUtilities.getSubtractedDate(cal,11));
			break;
		
		default:
			fromDate = DateAndTimeUtilities.parseStringDateToDateFormat(revenueBean.getFromDate());
			toDate=DateAndTimeUtilities.parseStringDateToDateFormat(revenueBean.getToDate());
			break;
		}
	
		int branchId=branchModel.getId();
		int catId = 0;
	//	purchaseOrderBeans=new ArrayList<PurchaseOrderBean>();
	//	salesOrderBeans=new ArrayList<SalesOrderBean>();
		model = new HashMap<String , Object>();
		if(type.contentEquals(purchase)){
			
			model.put("revenueAccounts", PurchaseOrderBeanPreparation.prepareListOfPurchaseOrderBeanForRevenueAccounts(revenueService.revenuePurchaseOrder(fromDate, toDate, branchId)));
			model.put("type", purchase);
			model.put("Purchase", purchase);
		}else
		if(type.contentEquals(sales)){
			categoryModel.setId(salesId);
			catId = categoryModel.getId();
			model.put("revenueAccounts", SalesOrderBeanPreparation.prepareListOfSalesOrderBeanForRevenueAccounts(revenueService.revenueSalesOrder(fromDate, toDate, branchId,catId)));
			model.put("type", sales);
			model.put("Sales", sales);
		}else
			if(type.contentEquals(preSales)){
				categoryModel.setId(preSalesId);
				catId = categoryModel.getId();
				model.put("revenueAccounts", SalesOrderBeanPreparation.prepareListOfSalesOrderBeanForRevenueAccounts(revenueService.revenueSalesOrder(fromDate, toDate, branchId,catId)));
				model.put("type", preSales);
				model.put("PreSales", preSales);
			}
	
		
		return new ModelAndView("revenueAccounts",model);
	}else{
		return new ModelAndView("error");
	}
	}

}
