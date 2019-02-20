package com.relyits.rmbs.controller;



import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
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

import com.relyits.rmbs.beans.purchase.PurchaseOrderBean;
import com.relyits.rmbs.beans.purchase.PurchaseReportBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.SubCategoryModel;
import com.relyits.rmbs.model.registration.AgencyModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model.registration.OutletModel;
import com.relyits.rmbs.model.registration.ResourceModel;
import com.relyits.rmbs.service.BranchService;
import com.relyits.rmbs.service.ReportsService;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;
import com.relyits.rmbs.utilities.FormUtilities;
import com.relyits.rmbs.utilities.MasterProductsDownloadService;
import com.relyits.rmbs.utilities.ProductStockDownloadService;
import com.relyits.rmbs.utilities.PurchaeOrderLineitemsReportsDownloadService;
import com.relyits.rmbs.utilities.PurchaseOrderDownloadService;
import com.relyits.rmbs.utilities.PurchaseOrderListDownloadService;
import com.relyits.rmbs.utilities.SessionUtilities;
import com.relyits.rmbs.utilities.StatusResponse;
import com.relyits.rmbs.utilities.TokenService;

@Controller
public class ReportsController {

	//	************purchase order reports*************
	@Autowired
	private PurchaseOrderController purchaseController;

	@Autowired
	private ReportsService reportsService;

	@Autowired
	private BranchService branchService; 

	@Autowired
	private TokenService tokenService;
	@Autowired
	private MasterProductsDownloadService downloadService;

	@Autowired
	private ProductStockDownloadService productStockDownloadService;

	@Autowired
	private PurchaseOrderListDownloadService purchaseOrderListDownloadService;

	@Autowired
	private PurchaseOrderDownloadService purchaseOrderDownloadService;

	@Autowired
	private PurchaeOrderLineitemsReportsDownloadService pLineitemsReportsDownloadService;
	
	private List<PurchaseOrderBean> purchaseOrderBeans=null;
	private BranchModel branchModel;
	private AgencyModel agencyModel=null;
	private OrganizationModel organizationModel = null;
	private PurchaseOrderModel purchaseOrderModel = null;
	private PurchaseLineItemsModel purchaseLineItemsModel = null; 
	private OutletModel outletModel = null;
	private RoleModel creatorRoleModel = null;
	private ResourceModel resourceModel = null;
	
	private UserSessionBean userSessionBean = null;
	private Map<String, Object> model=null;
	private int organization,branch,outlet ;
	private Map<String, String> properties= null;
	private Date fromDate = null;
	private Date toDate = null;
	@Value("${category.medical}") String categorymedical;
	@Value("${category.general}") String categorygeneral;
	@Value("${role.organization}") String org;
	@Value("${role.branch}") String branchRole;
	@Value("${role.outlet}") String outletRole;

	public Map<String, String> initializeProperties(){

		organization = Integer.parseInt(org);
		branch = Integer.parseInt(branchRole);
		outlet = Integer.parseInt(outletRole);

		return properties;
	}

	//*****************product reports stuff********************

	//**************jasper reports for master products******************

	@RequestMapping(value="/download/progress")
	public @ResponseBody StatusResponse checkDownloadProgress(@RequestParam String token) {
		System.out.println("********/download/progress********* ");
		return new StatusResponse(true, tokenService.check(token));
	}

	@RequestMapping(value="/download/token")
	public @ResponseBody StatusResponse getDownloadToken() {
		System.out.println("********/download/token********* ");
		return new StatusResponse(true, tokenService.generate());
	}

	@RequestMapping(value="productMasterReports/download")
	public void download(@RequestParam String type,
			@RequestParam String token, 
			HttpServletResponse response) {
		System.out.println("**download servcing called **"+response.toString());
		downloadService.download(type, token, response);
	}

	//		**********Jasper reports for product stock ***********

	@RequestMapping(value="/productStockReports/download")
	public void productStockDownloadReportsByBranch(HttpSession session,@RequestParam String type,
			@RequestParam String token,
			HttpServletResponse response){
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){
			int branchId=mode[1];
			productStockDownloadService.download(type, token, response, branchId);
		}
	} 

	//***************purchase order Reports stuff****************

	@RequestMapping(value = "/openPurchaseReportForm",method = RequestMethod.GET)
	public ModelAndView openPurchaseReportForm(HttpSession session,@ModelAttribute("command")PurchaseReportBean purchaseReportBean,BindingResult result){
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		initializeProperties();
		if(mode[0]==1){
			BranchModel branchModel = new BranchModel();
			OrganizationModel organizationModel = new OrganizationModel();
			organizationModel.setId(userSessionBean.getId());
			branchModel.setOrganizationModel(organizationModel);
			model=new HashMap<String , Object>();
			if(mode[1]== branch){
				branchModel.setId(mode[2]);
				branchModel = branchService.getBranchbyId(branchModel);

				model.put("branch", userSessionBean.getName());
				model.put("branchId", userSessionBean.getId());
				//model.put("organization", userSessionBean.getOrganizationBean().getName());
				//model.put("organizationId", userSessionBean.getOrganizationBean().getId());
				model.put("report", "--select--");
				model.put("reportId", 0);
				model.put("reportInitials", FormUtilities.getreportInitial());
				//return new ModelAndView("openPurchaseReportFormByBranch",model);

			}
			else{
				model.put("branch", "--Select Branch--");
				model.put("branchId", 0);
				//model.put("organization", userSessionBean.getOrganizationBean().getName());
				//model.put("organizationId", userSessionBean.getOrganizationBean().getId());
				model.put("branches", purchaseController.getBranches(branchModel));
				model.put("report", "--select--");
				model.put("reportId", 0);
				model.put("reportInitials", FormUtilities.getreportInitial());
				//return new ModelAndView("openPurchaseReportFormByOrg",model);
			}
				return new ModelAndView("openPurchaseReportForm",model);
		}
		else{
			return new ModelAndView("error",model);
		}
	}
	@RequestMapping(value = "/openPurchaseOrdersView",method = RequestMethod.POST)
	public ModelAndView purchaseOrderReports(@ModelAttribute("command")PurchaseReportBean purchaseReportBean,BindingResult result) throws ParseException{

		branchModel = new BranchModel();
		branchModel.setId(purchaseReportBean.getOutletBean().getId());
		Calendar cal = Calendar.getInstance();
		String key = purchaseReportBean.getInitial();
		switch (key) {
		case "1":
			fromDate = DateAndTimeUtilities.parseStringDateToSqlDateFormat(DateAndTimeUtilities.getCurrentDate());
			toDate=DateAndTimeUtilities.parseStringDateToSqlDateFormat(DateAndTimeUtilities.getCurrentDate());
			break;
		
		case "2":
			toDate=DateAndTimeUtilities.parseStringDateToSqlDateFormat(DateAndTimeUtilities.getCurrentDate());
			fromDate = DateAndTimeUtilities.parseStringDateToSqlDateFormat(DateAndTimeUtilities.getSubtractedDate(cal,0));
			break;
		case "3":
			toDate=DateAndTimeUtilities.parseStringDateToSqlDateFormat(DateAndTimeUtilities.getCurrentDate());
			fromDate = DateAndTimeUtilities.parseStringDateToSqlDateFormat(DateAndTimeUtilities.getSubtractedDate(cal,2));
			break;
		default:
			fromDate = DateAndTimeUtilities.parseStringDateToSqlDateFormat(purchaseReportBean.getFromDate());
			toDate=DateAndTimeUtilities.parseStringDateToSqlDateFormat(purchaseReportBean.getToDate());
			break;
		}
		/*if(purchaseReportBean.getInitial().equals("1")){
			fromDate = DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDate());
			toDate=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDate());
		}else if(purchaseReportBean.getInitial().equals("2")){

			toDate=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDate());
			fromDate = DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getSubtractedDate(cal,0));

		}else if(purchaseReportBean.getInitial().equals("3")){

			toDate=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDate());
			fromDate = DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getSubtractedDate(cal,2));
		}else{
			fromDate = DateAndTimeUtilities.parseStringDateToSqlDate(purchaseReportBean.getFromDate());
			toDate=DateAndTimeUtilities.parseStringDateToSqlDate(purchaseReportBean.getToDate());
		}*/
		int branchId=branchModel.getId();
		purchaseOrderBeans=new ArrayList<PurchaseOrderBean>();
		purchaseOrderBeans=reportsService.purchaseOrderReports(fromDate, toDate,branchId);

		for(int i=0;i<purchaseOrderBeans.size();i++){
			System.out.println("list values"+purchaseOrderBeans.get(i).getOrderIdByDate());
		}
		model=new HashMap<String , Object>();
		model.put("purchaseOrderBean", purchaseOrderBeans);
		return new ModelAndView("purchaseOrdersView",model);
	}

	@RequestMapping(value="/purchaseReports/download")
	public void purchaseReportsDownloads(HttpSession session,@RequestParam String type,
			@RequestParam String token,@RequestParam Integer bId,@RequestParam String cat,
			@RequestParam String frm,@RequestParam String todate,
			HttpServletResponse response) throws ParseException{
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		initializeProperties();
		if(mode[0]==1){

			branchModel = new BranchModel();
			branchModel.setId(bId);

			Calendar cal = Calendar.getInstance();
			switch (cat) {
			case "1":
				fromDate = DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDate());
				toDate=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDate());
				break;
			case "2":
				toDate=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDate());
				fromDate = DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getSubtractedDate(cal,0));
				break;
			case "3":
				toDate=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDate());
				fromDate = DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getSubtractedDate(cal,2));
				break;
			case "4":
				fromDate = DateAndTimeUtilities.parseStringDateToSqlDate(frm);
				toDate=DateAndTimeUtilities.parseStringDateToSqlDate(todate);
			default:
				break;
			}
			/*	if(cat.equals("1")){
				fromDate = DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDate());
				toDate=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDate());
			}else if(cat.equals("2")){

				toDate=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDate());
				fromDate = DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getSubtractedDate(cal,0));

			}else if(cat.equals("3")){

				toDate=DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDate());
				fromDate = DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getSubtractedDate(cal,2));
			}else if(cat.equals("4")){
				fromDate = DateAndTimeUtilities.parseStringDateToSqlDate(frm);
				toDate=DateAndTimeUtilities.parseStringDateToSqlDate(todate);
			}
			*/
			int branchId=branchModel.getId();
		//	String userName=userSessionBean.getUserName();
			purchaseOrderDownloadService.download(type, token, response,fromDate,toDate,branchId);

			/*if(mode[1]==organization){
				int branchId=branchModel.getId();
				String userName=userSessionBean.getUserName();
				purchaseOrderDownloadService.download(type, token, response,fromDate,toDate,branchId,userName);
			}else if(mode[1]==branch){
				int branchId=branchModel.getId();
				purchaseOrderDownloadService.download(type, token, response,fromDate,toDate,branchId,userName);
			}else{
				int branchId=branchModel.getId();
				purchaseOrderDownloadService.download(type, token, response,fromDate,toDate,branchId,userName);
			}*/
		}
	} 
	
	@RequestMapping(value = "/purchaseOrderListReports/download")
	public void purchaseOrderListReports(HttpSession session,@RequestParam String type,
			@RequestParam String token,
			HttpServletResponse response){
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		initializeProperties();
		if(mode[0]==1){
			purchaseOrderModel = new PurchaseOrderModel();
			organizationModel = new OrganizationModel();
			branchModel = new BranchModel();
			creatorRoleModel = new RoleModel();
			resourceModel = new ResourceModel();
			if(mode[1]==branch){
				creatorRoleModel.setId(mode[1]);
				resourceModel.setCreatorRoleModel(creatorRoleModel);
				branchModel.setResourceModel(resourceModel);
				branchModel.setId(mode[2]);
				//purchaseOrderModel.setBranchModel(branchModel);
				purchaseOrderModel.setBranchModel(branchModel);
				purchaseOrderListDownloadService.download(type, token, response, purchaseOrderModel);
			}if(mode[1]==organization){
				creatorRoleModel.setId(mode[1]);
				resourceModel.setCreatorRoleModel(creatorRoleModel);
				organizationModel.setResourceModel(resourceModel);
				organizationModel.setId(mode[2]);
				branchModel.setOrganizationModel(organizationModel);
				purchaseOrderModel.setBranchModel(branchModel);
				purchaseOrderListDownloadService.download(type, token, response, purchaseOrderModel);
			}
		}
	}
	
	@RequestMapping(value = "/purchaseOrderLineitemsReports/download")
	public void purchaseOrderLineitemsReports(HttpSession session,@RequestParam String type,
			@RequestParam String token,@RequestParam String invoice,
			HttpServletResponse response){
		userSessionBean = SessionUtilities.giveMeSession(session);
		int mode[] = SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		if(mode[0]==1){
//			purchaseLineItemsModel = new PurchaseLineItemsModel();
			purchaseOrderModel = new PurchaseOrderModel();
			purchaseOrderModel.setInvoiceNo(invoice);
//			purchaseLineItemsModel.setPurchaseOrderModel(purchaseOrderModel);
			pLineitemsReportsDownloadService.download(type, token, response, purchaseOrderModel);
		}
	}
}