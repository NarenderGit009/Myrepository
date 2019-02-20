package com.relyits.rmbs.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.relyits.rmbs.beans.product.ProductInventoryBean;
import com.relyits.rmbs.beans.purchase.PurchaseLineItemsBean;
import com.relyits.rmbs.beans.purchase.PurchaseOrderBean;
import com.relyits.rmbs.beans.resources.PurchaseFormBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.beans_preparation.product.ProductInventoryBeanPreparation;
import com.relyits.rmbs.beans_preparation.purchase.PurchaseLineItemsBeanPreparation;
import com.relyits.rmbs.beans_preparation.purchase.PurchaseOrderBeanPreparation;
import com.relyits.rmbs.model.product.ProductInventoryModel;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.SubCategoryModel;
import com.relyits.rmbs.model.registration.AgencyModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model.registration.OutletModel;
import com.relyits.rmbs.model_preparation.purchase.PurchaseLineItemsModelPreparation;
import com.relyits.rmbs.service.BranchService;
import com.relyits.rmbs.service.ProductService;
import com.relyits.rmbs.service.PurchaseService;
import com.relyits.rmbs.service.ReportsService;
import com.relyits.rmbs.utilities.DidgitsToEnglishWordsConvertionUtilities;
import com.relyits.rmbs.utilities.NumToWords;
import com.relyits.rmbs.utilities.SessionUtilities;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@Controller
public class PurchaseOrderController {
	@Autowired
	private BranchService branchService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PurchaseService purchaseService;

	@Autowired
	private ReportsService reportsService;
	private AgencyModel agencyModel=null;
	private BranchModel branchModel = null;
	private OrganizationModel organizationModel = null;
	private SubCategoryModel subCategoryModel = null;
	private CategoryModel categoryModel = null;
	private PurchaseOrderModel purchaseOrderModel = null;
	private PurchaseLineItemsModel purchaseLineItemsModel = null; 
	private OutletModel outletModel = null;

	private UserSessionBean userSessionBean = null;

	Map<String, Object> model = null;
	
	Map<String, String> properties= null;
	
  int medical,general,organization,branch,outlet ;
	
	@Value("${category.medical}") String categorymedical;
	@Value("${category.general}") String categorygeneral;
	@Value("${role.organization}") String org;
	@Value("${role.branch}") String branchRole;
	@Value("${role.outlet}") String outletRole;


	public Map<String, String> initializeProperties(){

		medical=Integer.parseInt(categorymedical);
		general = Integer.parseInt(categorygeneral);
		organization = Integer.parseInt(org);
		branch = Integer.parseInt(branchRole);
		outlet = Integer.parseInt(outletRole);
		
		return properties;
	}

	@RequestMapping(value="/openPurchaseEntryForm" , method=RequestMethod.GET)
	public ModelAndView purchaseEntryForm(@ModelAttribute("command")PurchaseLineItemsBean purchaseLineItemsBean,BindingResult result,
			@RequestParam("task_form_type") String task_form_type,
			@RequestParam("task_type") String task_type,HttpSession session){
		initializeProperties();
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){
			BranchModel branchModel = new BranchModel();
			OrganizationModel organizationModel = new OrganizationModel();
			organizationModel.setId(userSessionBean.getId());
			branchModel.setOrganizationModel(organizationModel);
			SubCategoryModel subCategoryModel = new SubCategoryModel();
			CategoryModel categoryModel = new CategoryModel();
			categoryModel.setId(medical);
			subCategoryModel.setCategoryModel(categoryModel);
			
			try {
				model = new HashMap<String, Object>();				
				model.put("categories", getSubCategoryList(subCategoryModel));
				if(mode[1]== outlet){
					model.put("branch", userSessionBean.getBranchBean().getName());
					model.put("branchId", userSessionBean.getBranchBean().getId());
					model.put("organization", userSessionBean.getOrganizationBean().getName());
					model.put("organizationId", userSessionBean.getOrganizationBean().getId());
				}else if(mode[1]== branch){
					model.put("branch", userSessionBean.getName());
					model.put("branchId", userSessionBean.getId());
					model.put("organization", userSessionBean.getOrganizationBean().getName());
					model.put("organizationId", userSessionBean.getOrganizationBean().getId());
				}else{
					model.put("branch", "--Select Branch--");
					model.put("branchId", 0);
					model.put("organization", userSessionBean.getName());
					model.put("organizationId", userSessionBean.getId());
					model.put("branches", getBranches(branchModel));  
				}
				model.put("createdby",userSessionBean.getId());
				System.out.println("method called");
			} catch (Exception e) {

				e.printStackTrace();
			}
			if(task_type.contentEquals("main") && task_form_type.contentEquals("medical")){

				if(mode[1]== organization){
					return new ModelAndView("openMedicalProductPurchaseFormByOrganization", model);
				}else if(mode[1]== branch){
					return new ModelAndView("openMedicalProductPurchaseFormByBranch", model);
				}else if(mode[1]== outlet){
					return new ModelAndView("openMedicalProductPurchaseFormByOutlet", model);
				}
			}else if(task_type.contentEquals("main") && task_form_type.contentEquals("general")){
				if(mode[1]== organization){
					return new ModelAndView("openGeneralProductPurchaseFormByOrganization", model);
				}else if(mode[1]== branch){
					return new ModelAndView("openGeneralProductPurchaseFormByBranch", model);
				}else if(mode[1]== outlet){
					return new ModelAndView("openGeneralProductPurchaseFormByOutlet", model);
				}
				
			}else if(task_type.contentEquals("sub") && task_form_type.contentEquals("medical")){
				return new ModelAndView("reOpenMedicalProductPurchaseForm", model);
			}else if(task_type.contentEquals("sub") && task_form_type.contentEquals("general")){
				return new ModelAndView("reOpenMedicalProductPurchaseForm", model);
			}
		}else{
			return new ModelAndView("error");
		}
		return null;
//		Map<String, Object> model = new HashMap<String, Object>();
//		return new ModelAndView("purchaseMedicalForm");
	}
	public LinkedHashMap<Integer, String> getBranches(BranchModel branchModel){
		LinkedHashMap<Integer, String> branches = new LinkedHashMap<Integer, String>();
		List<BranchModel> branchModels= branchService.getBranchesByOrganization(branchModel);
		for(int i=0; i<branchModels.size(); i++){
			int bid=branchModels.get(i).getId();
			String bname=branchModels.get(i).getName();
			System.out.println(bid+"-----------"+bname);
			branches.put(bid, bname);
		}
		System.out.println(branches.keySet().toString());
		return branches;
	}
	public LinkedHashMap<Integer, String> getSubCategoryList(SubCategoryModel subCategoryModel){
		LinkedHashMap<Integer, String> categories = new LinkedHashMap<Integer, String>();
		List<SubCategoryModel> subCategory= productService.getSubCategoryListByCategory(subCategoryModel);
		for(int i=0; i<subCategory.size(); i++){
			int subCategoryid=subCategory.get(i).getId();
			String sCName=subCategory.get(i).getCategory();
			System.out.println(subCategoryid+"-----------"+sCName);
			categories.put(subCategoryid, sCName);
		}
		return categories;
	}
	@RequestMapping(value = "/get_purchase_medical_agency_list", 
			method = RequestMethod.GET, 
			headers="Accept=*/*")
	public @ResponseBody List<String> getAgenciesLists(@RequestParam("term") String phrase){

		agencyModel=new AgencyModel();
		agencyModel.setAgencyName(phrase);
		List<String> agenciesList=productService.getAgenciesList(agencyModel);
		List<String> agencies=new ArrayList<String>();
		for (int i = 0; i < agenciesList.size(); i++) {
			Object o=(Object)agenciesList.get(i);
			agencyModel=(AgencyModel)o;
			agencies.add(agencyModel.getAgencyName()+"_"+agencyModel.getId());
			System.out.println(">>>>>>>>>>>>>>>"+agencies.get(i));
		}
		return agencies;
	}


	PurchaseFormBean purchaseFormBean = null;
	List<PurchaseLineItemsModel> purchaseLineItemsModels=null;
	List<PurchaseFormBean> purchaseFormBeans=null;

	@RequestMapping(value = "/createOrder", 
			method = RequestMethod.POST, 
			headers="Accept=*/*")
	public ModelAndView createOrder(@RequestBody String str,HttpSession session) throws JsonProcessingException, ParseException{
		int POID=0;
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		if(mode[0]==1){
			ObjectMapper mapper = new ObjectMapper();
			purchaseFormBeans=new ArrayList<PurchaseFormBean>();
			try {
				JsonNode node = mapper.readTree(str);
				System.out.println(node.size());

				System.out.println("********************  START*******************");

				for(int i=0;i<node.size();i++){
					purchaseFormBean=new PurchaseFormBean();
					purchaseFormBean = mapper.convertValue(node.get(i), PurchaseFormBean.class);
					purchaseFormBean.setcRId(mode[1]);
					purchaseFormBean.setcById(mode[2]);
					purchaseFormBeans.add(purchaseFormBean);
					System.out.println(">>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
					System.out.println(">>>>>>>>>>>>>>>>>>>>>"+purchaseFormBeans.get(i).getpId()+"-"+purchaseFormBeans.get(i).getpName());
					System.out.println("Order Amount exclude vat & Dis >>>>> "+(purchaseFormBean.getOrdAmt()+(purchaseFormBean.getTotDis()-purchaseFormBean.getTotVat())));
					System.out.println("Dis Ammount      >>>>>>>>>>>>>>>>>>> "+purchaseFormBean.getTotDis());
					System.out.println("Vat Ammount      >>>>>>>>>>>>>>>>>>> "+purchaseFormBean.getTotVat());
					System.out.println("Invoice          >>>>>>>>>>>>>>>>>>> "+purchaseFormBean.getInvNo());
					System.out.println("Pay Ammount      >>>>>>>>>>>>>>>>>>> "+purchaseFormBean.getOrdAmt());
				}
				System.out.println("********************  END*******************");
				System.out.println("Line Items "+purchaseFormBeans.size());
				if(purchaseFormBeans.size()>0){
					purchaseLineItemsModels=new ArrayList<PurchaseLineItemsModel>();
					purchaseLineItemsModels=PurchaseLineItemsModelPreparation.preparepurchaseLineItemsModelsListFromPurchaseFormBeansList(purchaseFormBeans);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			//User theUser = mapper.convertValue(node.get("user"), User.class);
			System.out.println("***********purchaseLineItemsModels.size : "+purchaseLineItemsModels.size());
			POID=purchaseService.createPurchaseOrder(purchaseLineItemsModels);
			purchaseOrderModel=new PurchaseOrderModel();
			purchaseOrderModel.setId(POID);
			purchaseLineItemsModel=new PurchaseLineItemsModel();
			purchaseLineItemsModel.setPurchaseOrderModel(purchaseOrderModel);
		}
		purchaseLineItemsBeans=PurchaseLineItemsBeanPreparation.prepareListOfPurchaseLineItemsBean(purchaseService.getPurchaseLineItems(purchaseLineItemsModel));
		purchaseOrderBean=purchaseLineItemsBeans.get(0).getPurchaseOrderBean();
		Map vatMap=new HashMap();
		double vat_percent=0;
		double vat_applied_amount=0;
		double vat_amount=0;
		double[] vat_Array = null;
		String vatDeatils="";
		for(PurchaseLineItemsBean purchaseLineItemsBean1:purchaseLineItemsBeans){
			vat_percent=purchaseLineItemsBean1.getVat();
			double dicounted_amount=(purchaseLineItemsBean1.getAmount())*(purchaseLineItemsBean1.getDiscount()/100);
			vat_applied_amount=(purchaseLineItemsBean1.getAmount()-dicounted_amount);
			vat_amount=vat_applied_amount*(vat_percent/100);
			
			if(vatMap.size()>0){
				if(!vatMap.containsKey(vat_percent)){
					vat_Array=new double[3];
					vat_Array[0]=vat_percent;
					vat_Array[1]=vat_applied_amount;
					vat_Array[2]=vat_amount;
				}else{
					vat_Array=new double[3];
					vat_Array=(double[]) vatMap.get(vat_percent);
					if(vat_Array[0]==vat_percent){
						vat_Array[1]=vat_Array[1]+vat_applied_amount;
						vat_Array[2]=vat_Array[2]+vat_amount;
					}
				}
			}else{
				vat_Array=new double[3];

				vat_Array[0]=vat_percent;
				vat_Array[1]=vat_applied_amount;
				vat_Array[2]=vat_amount;
			}
			vatMap.put(vat_percent,vat_Array); 
		}
		
		Iterator entries = vatMap.entrySet().iterator();
		double total_Vat=0.00;
		double total_Vat_Appaly_Amount=0.00;
		while (entries.hasNext()) {
		    Map.Entry entry = (Map.Entry) entries.next();
		    Double key = (Double)entry.getKey();
		    vat_Array = (double[])entry.getValue();
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		    System.out.println("vat on " + vat_Array[1] + " @ "+vat_Array[0]+" is "+ vat_Array[2] );
		    vatDeatils=vatDeatils+"vat on " + Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[1])) + " @ "+vat_Array[0]+" is "+ Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[2]))+"<br>";
		    total_Vat_Appaly_Amount=total_Vat_Appaly_Amount+Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[1]));
		    total_Vat=total_Vat+Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[2]));
		}//)
		vatDeatils=vatDeatils+"-------------------------------------------------<br>";
		vatDeatils=vatDeatils+"total vat on "+total_Vat_Appaly_Amount+ " is "+purchaseOrderBean.getTotalVAT();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> vatDeatils >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+vatDeatils);
        model.put("vatDetails", vatDeatils);
		model.put("POLItems", purchaseLineItemsBeans);
		model.put("PODetails", purchaseOrderBean);
		model.put("POAmntInWords",NumToWords.convertToWord(Math.round(purchaseOrderBean.getPayAmount())));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+model.get("POAmntInWords"));
		return new ModelAndView("pOInvoiceView",model);
	}


	@RequestMapping(value = "/purchaseOrderList", method = RequestMethod.GET)
	public ModelAndView purchaseOrderList(HttpSession session,
			@ModelAttribute("command") PurchaseOrderBean purchaseOrderBean ,BindingResult result,
			@RequestParam(value="flag") String flag
			){
		initializeProperties();
		userSessionBean = SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){  
			model = new HashMap<String, Object>();
			purchaseOrderModel = new PurchaseOrderModel();
			organizationModel = new OrganizationModel();
			branchModel = new BranchModel();

			try {   

		/*		if(mode[1]==4){			     
					branchModel.setId(userSessionBean.getBranchBean().getId());	
					purchaseOrderModel.setBranchModel(branchModel); 
					model.put("purchaseOrders",PurchaseOrderBeanPreparation.prepareListOfPurchaseOrderBean(purchaseService.purchaseOrderListByOutlet(purchaseOrderModel)));

					model.put("createdRole", mode[1]);
					model.put("purchaseCreatedBy", mode[2]);
				}else */
				if(mode[1]== branch){
					branchModel.setId(mode[2]);
					purchaseOrderModel.setBranchModel(branchModel); 
					model.put("purchaseOrders",PurchaseOrderBeanPreparation.prepareListOfPurchaseOrderBean(purchaseService.purchaseOrderListByBranch(purchaseOrderModel)));

					model.put("createdRole", mode[1]);
					model.put("purchaseCreatedBy", mode[2]);
				}else if(mode[1]== organization){
					organizationModel.setId(mode[2]);
					branchModel.setOrganizationModel(organizationModel);
					purchaseOrderModel.setBranchModel(branchModel); 

					model.put("purchaseOrders",PurchaseOrderBeanPreparation.prepareListOfPurchaseOrderBean(purchaseService.purchaseOrderListByOrganization(purchaseOrderModel)));
					
					model.put("createdRole", mode[1]);
					model.put("purchaseCreatedBy", mode[2]);
				}

				System.out.println("method called");
			} catch (Exception e) {

				e.printStackTrace();
			}
			if(flag.contentEquals("task_main")){
				return new ModelAndView("purchaseOrderList",model);
			}else{
				return new ModelAndView("reOpenPurchaseOrderList",model);
			}
		}else{
			return new ModelAndView("error");
		}  



	}
	
	
	List<PurchaseLineItemsBean> purchaseLineItemsBeans=null;
	PurchaseOrderBean purchaseOrderBean=null;
	
	@RequestMapping(value = "/loadInvoiceByPurchase",
			method = RequestMethod.POST)
	public ModelAndView  getInvoiceByPurchaseOrder(HttpSession session,@ModelAttribute("command")                     
	PurchaseLineItemsBean purchaseLineItemsBean,BindingResult result,
	@RequestParam(value="id") String pOId)
			throws Exception {
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){  
			System.out.println("********Purchase Line Items ******* ");
			purchaseLineItemsModel = new PurchaseLineItemsModel();
			purchaseOrderModel = new PurchaseOrderModel();
			purchaseOrderModel.setId(Integer.parseInt(pOId));
			purchaseLineItemsModel.setPurchaseOrderModel(purchaseOrderModel);

			model = new HashMap<String, Object>();
			
			purchaseLineItemsBeans=PurchaseLineItemsBeanPreparation.prepareListOfPurchaseLineItemsBean(purchaseService.getPurchaseLineItems(purchaseLineItemsModel));
			purchaseOrderBean=purchaseLineItemsBeans.get(0).getPurchaseOrderBean();
			Map<Double, double[]> vatMap=new HashMap<Double, double[]>();
			double vat_percent=0;
			double vat_applied_amount=0;
			double vat_amount=0;
			double[] vat_Array = null;
			String vatDeatils="";
			for(PurchaseLineItemsBean purchaseLineItemsBean1:purchaseLineItemsBeans){
				vat_percent=purchaseLineItemsBean1.getVat();
				double dicounted_amount=(purchaseLineItemsBean1.getAmount())*(purchaseLineItemsBean1.getDiscount()/100);
				vat_applied_amount=(purchaseLineItemsBean1.getAmount()-dicounted_amount);
				vat_amount=vat_applied_amount*(vat_percent/100);
				
				if(vatMap.size()>0){
					if(!vatMap.containsKey(vat_percent)){
						vat_Array=new double[3];
						vat_Array[0]=vat_percent;
						vat_Array[1]=vat_applied_amount;
						vat_Array[2]=vat_amount;
					}else{
						vat_Array=new double[3];
						vat_Array=(double[]) vatMap.get(vat_percent);
						if(vat_Array[0]==vat_percent){
							vat_Array[1]=vat_Array[1]+vat_applied_amount;
							vat_Array[2]=vat_Array[2]+vat_amount;
						}
					}
				}else{
					vat_Array=new double[3];

					vat_Array[0]=vat_percent;
					vat_Array[1]=vat_applied_amount;
					vat_Array[2]=vat_amount;
				}
				vatMap.put(vat_percent,vat_Array); 
			}
			
			Iterator<?> entries = vatMap.entrySet().iterator();
			double total_Vat=0.00;
			double total_Vat_Appaly_Amount=0.00;
			while (entries.hasNext()) {
			    Map.Entry entry = (Map.Entry) entries.next();
			    Double key = (Double)entry.getKey();
			    vat_Array = (double[])entry.getValue();
			    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			    System.out.println("vat on " + vat_Array[1] + " @ "+vat_Array[0]+"% is "+ vat_Array[2] );
			    vatDeatils=vatDeatils+"vat on " + Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[1])) + " @ "+vat_Array[0]+"% is "+ Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[2]))+"<br>";
			    total_Vat_Appaly_Amount=total_Vat_Appaly_Amount+Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[1]));
			    total_Vat=total_Vat+Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[2]));
			}//)
			vatDeatils=vatDeatils+"-------------------------------------------------<br>";
			vatDeatils=vatDeatils+"total vat on "+total_Vat_Appaly_Amount+ " is "+purchaseOrderBean.getTotalVAT();
            model.put("vatDetails", vatDeatils);
			model.put("POLItems", purchaseLineItemsBeans);
			model.put("PODetails", purchaseOrderBean);
			model.put("POAmntInWords",NumToWords.convertToWord(Math.round(purchaseOrderBean.getPayAmount())));
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+model.get("POAmntInWords"));
			//DidgitsToEnglishWordsConvertionUtilities.convert(number)
			return new ModelAndView("pOInvoiceView",model);
		}else{
			return new ModelAndView("error");
		}  
	}
	
	
	
	
	@RequestMapping(value = "/getPurchaseLineItems",
			method = RequestMethod.POST)
	public ModelAndView  getpurchaseLineItems(HttpSession session,@ModelAttribute("command")                     
	PurchaseLineItemsBean purchaseLineItemsBean,BindingResult result,
	@RequestParam(value="id") String pOId , @RequestParam(value="flag") int flag)
			throws Exception {
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){  
			System.out.println("********Purchase Line Items ******* ");
			purchaseLineItemsModel = new PurchaseLineItemsModel();
			purchaseOrderModel = new PurchaseOrderModel();
			purchaseOrderModel.setId(Integer.parseInt(pOId));
			purchaseLineItemsModel.setPurchaseOrderModel(purchaseOrderModel);

			model = new HashMap<String, Object>();
			model.put("flag", flag);
			model.put("purchaseLineItems", PurchaseLineItemsBeanPreparation.prepareListOfPurchaseLineItemsBean(purchaseService.getPurchaseLineItems(purchaseLineItemsModel)));

			return new ModelAndView("purchaseLineItemsList",model);
		}else{
			return new ModelAndView("error");
		}									  													
	}
	

//	******************purchase returns********************
	@RequestMapping(value ="/openPurchaseReturnsForm", method = RequestMethod.GET)
	public ModelAndView purchaseReturnsForm(){
		
		return new ModelAndView("purchaseReturnsForm");
	}
	
	
	@RequestMapping(value = "/get_purchase_invoiceNo_list", 
	method = RequestMethod.GET, 
	headers="Accept=*/*")
	public @ResponseBody List<String> getPurchaseInvoiceNoList(@RequestParam("term")String phrase){
		
		purchaseOrderModel = new PurchaseOrderModel();
		purchaseOrderModel.setInvoiceNo(phrase);
		List<String> invoiceNoList = purchaseService.getPurchaseInvoiceNo(purchaseOrderModel);
		
		List<String> invoices = new ArrayList<String>();
		for(int i=0;i<invoiceNoList.size();i++){
			Object o = (Object)invoiceNoList.get(i);
			purchaseOrderModel = (PurchaseOrderModel)o;
			invoices.add(purchaseOrderModel.getInvoiceNo());
		}
		return invoices;
	}
	
	@RequestMapping(value = "/dispalyPurchaseLineitems" , method = RequestMethod.POST)
	public ModelAndView purchaseOrderLineitemsDisplay(@RequestParam("invoiceNo")String invoiceNo){
		
		purchaseOrderModel = new PurchaseOrderModel();
		purchaseOrderModel.setInvoiceNo(invoiceNo);
		
		List<PurchaseLineItemsBean> purchaseLineItemsBeans = new ArrayList<PurchaseLineItemsBean>();
		purchaseLineItemsBeans = reportsService.purchaseOrderLineitemsReports(purchaseOrderModel);
		
		model = new HashMap<String, Object>();
		model.put("purchaseLineItemsBeans", purchaseLineItemsBeans);
		return new ModelAndView("purchaseLineItemsDisplay",model);
		
	}
}
