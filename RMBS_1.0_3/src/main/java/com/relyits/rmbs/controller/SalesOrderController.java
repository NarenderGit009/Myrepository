package com.relyits.rmbs.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.relyits.rmbs.beans.consumer.CustomerBean;
import com.relyits.rmbs.beans.product.ProductInventoryBean;
import com.relyits.rmbs.beans.registration.BranchBean;
import com.relyits.rmbs.beans.registration.OutletBean;
import com.relyits.rmbs.beans.resources.AddressBean;
import com.relyits.rmbs.beans.resources.CategoryBean;
import com.relyits.rmbs.beans.resources.StatusBean;
import com.relyits.rmbs.beans.sales.SalesFormBean;
import com.relyits.rmbs.beans.sales.SalesLineItemsBean;
import com.relyits.rmbs.beans.sales.SalesOrderBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.beans_preparation.consumer.CustomerBeanPreparation;
import com.relyits.rmbs.beans_preparation.product.ProductInventoryBeanPreparation;
import com.relyits.rmbs.beans_preparation.resources.AddressBeanPreparation;
import com.relyits.rmbs.beans_preparation.sales.SalesFormBeanPreparation;
import com.relyits.rmbs.beans_preparation.sales.SalesLineItemsBeanPreparation;
import com.relyits.rmbs.beans_preparation.sales.SalesOrderBeanPreparation;
import com.relyits.rmbs.model.consumer.CustomerModel;
import com.relyits.rmbs.model.product.ProductInventoryModel;
import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.refference.SubCategoryModel;
import com.relyits.rmbs.model.registration.AgencyModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.DoctorModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model.registration.OutletModel;
import com.relyits.rmbs.model.sales.SalesLineItemsModel;
import com.relyits.rmbs.model.sales.SalesOrderModel;
import com.relyits.rmbs.model_preparation.sales.SalesLineItemsModelPreparation;
import com.relyits.rmbs.service.BranchService;
import com.relyits.rmbs.service.ConsumerService;
import com.relyits.rmbs.service.DoctorService;
import com.relyits.rmbs.service.OutletService;
import com.relyits.rmbs.service.ProductService;
import com.relyits.rmbs.service.ResourcesService;
import com.relyits.rmbs.service.SalesService;
import com.relyits.rmbs.utilities.FormUtilities;
import com.relyits.rmbs.utilities.SessionUtilities;

@Controller
public class SalesOrderController {
	@Autowired
	private BranchService branchService;
	@Autowired
	private OutletService outletService;
	@Autowired
	private ProductService productService;
	@Autowired
	private SalesService salesService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private ConsumerService consumerService;
	@Autowired
	private ResourcesService resourcesService;

	private AgencyModel agencyModel=null;
	private BranchModel branchModel = null;
	private ProductInventoryModel productInventoryModel = null;
	private OrganizationModel organizationModel = null;
	private SubCategoryModel subCategoryModel = null;
	private CategoryModel categoryModel = null;
	private SalesOrderModel salesOrderModel = null;
	private SalesLineItemsModel salesLineItemsModel = null;
	private OutletModel outletModel = null;
	private CustomerModel customerModel = null;
	private AddressModel addressModel = null;
	private CustomerBean customerBean = null;
	private AddressBean addressBean = null;

	CategoryBean categoryBean=null;
	OutletBean outletBean=null;
	StatusBean statusBean=null;
	BranchBean branchBean=null;
	StatusModel statusModel=null;

	private SalesFormBean salesFormBean=null;
	private UserSessionBean userSessionBean = null;

	Map<String, Object> model = null;

	Map<String, String> properties= null;

	int medical,general,organization,branch,outlet,sales,preSales,open,close ;

	@Value("${category.medical}") String categorymedical;
	@Value("${category.general}") String categorygeneral;
	@Value("${category.sales}") String categorysales;
	@Value("${category.pre_sales}") String categorypresales;
	@Value("${role.organization}") String org;
	@Value("${role.branch}") String branchRole;
	@Value("${role.outlet}") String outletRole;
	@Value("${status.open}") String statusopen;
	@Value("${status.closed}") String statusclose;
	


	public Map<String, String> initializeProperties(){

		medical=Integer.parseInt(categorymedical);
		general = Integer.parseInt(categorygeneral);
		organization = Integer.parseInt(org);
		branch = Integer.parseInt(branchRole);
		outlet = Integer.parseInt(outletRole);
		sales = Integer.parseInt(categorysales);
		preSales = Integer.parseInt(categorypresales);
		open = Integer.parseInt(statusopen);
		close = Integer.parseInt(statusclose);

		return properties;
	}

	@RequestMapping(value="/openSalesOrderEntryForm" , method=RequestMethod.GET)
	public ModelAndView SalesEntryForm(@ModelAttribute("command") SalesLineItemsBean salesLineItemsBean,BindingResult result,
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
				model.put("initials", FormUtilities.getInitial());
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
				model.put("doctors", getDoctorsList());
				model.put("createdby",userSessionBean.getId());
				System.out.println("method called");
			} catch (Exception e) {

				e.printStackTrace();
			}
			if(task_type.contentEquals("main") && task_form_type.contentEquals("medical")){

				if(mode[1]== organization){
					return new ModelAndView("openProductSalesFormByOrganization", model);
				}else if(mode[1]== branch){
					return new ModelAndView("openProductSalesFormByBranch", model);
				}else if(mode[1]== outlet){
					return new ModelAndView("openProductSalesFormByOutlet", model);
				}
			}/*else if(task_type.contentEquals("main") && task_form_type.contentEquals("general")){
				if(mode[1]== organization){
					return new ModelAndView("openGeneralProductSalesFormByOrganization", model);
				}else if(mode[1]== branch){
					return new ModelAndView("openGeneralProductSalesFormByBranch", model);
				}else if(mode[1]== outlet){
					return new ModelAndView("openGeneralProductSalesFormByOutlet", model);


			}*/else if(task_type.contentEquals("sub") && task_form_type.contentEquals("medical")){
				return new ModelAndView("reOpenProductSalesForm", model);
			}/*else if(task_type.contentEquals("sub") && task_form_type.contentEquals("general")){
				return new ModelAndView("reOpenMedicalProductSalesForm", model);
			}*/
		}else{
			return new ModelAndView("error");
		}
		return null;
		//		Map<String, Object> model = new HashMap<String, Object>();
		//		return new ModelAndView("SalesMedicalForm");
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
	public LinkedHashMap<Integer, String> getDoctorsList(){
		LinkedHashMap<Integer, String> doctors = new LinkedHashMap<Integer, String>();
		List<DoctorModel> doctor= doctorService.listDoctors();
		for(int i=0; i<doctor.size(); i++){
			int id=doctor.get(i).getId();
			String name=doctor.get(i).getDoctorName();
			System.out.println(id+"-----------"+name);
			doctors.put(id, name);
		}
		return doctors;
	}


	List<SalesLineItemsModel> salesLineItemsModels=null;
	List<SalesFormBean> salesFormBeans=null;

	@RequestMapping(value = "/getUnCompletedSalesOrder", 
			method = RequestMethod.POST, 
			headers="Accept=*/*")
	public @ResponseBody List<SalesFormBean> getUnComplatedOrder(HttpServletRequest request,HttpSession session){

		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		if(mode[0]==1){
			fileName=mode[2]+".txt";
			path=request.getRealPath("/SO/"+fileName);
			System.out.println("File Path >>>>>>>>>"+path);
			int sOId=0;
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
				salesFormBeans = (List<SalesFormBean>)ois.readObject();
				System.out.println(salesFormBeans.size());
				for(SalesFormBean bean:salesFormBeans){
					sOId=bean.getsOId();
					System.out.println("***************"+bean.getsOId());
					System.out.println("***************"+bean.getBatNo());
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if(sOId!=0){
				salesOrderModel=new SalesOrderModel();
				salesOrderModel.setId(sOId);
				salesLineItemsModels=salesService.getSalesLineItemsModelsBySalesOrderModel(salesOrderModel);
				salesFormBeans=SalesFormBeanPreparation.prepareSalesFormBeansList(salesLineItemsModels);
			}/*else{
				fileName=mode[2]+".txt";
				path=request.getRealPath("/PSO/"+fileName);
				System.out.println("File Path >>>>>>>>>"+path);
				int pSOId=0;
				try {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
					salesFormBeans = (List<SalesFormBean>)ois.readObject();
					System.out.println(salesFormBeans.size());
					for(SalesFormBean bean:salesFormBeans){
						pSOId=bean.getsOId();
						System.out.println("***************"+bean.getsOId());
						System.out.println("***************"+bean.getBatNo());
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}if(pSOId!=0){
					salesOrderModel=new SalesOrderModel();
					salesOrderModel.setId(pSOId);
					salesLineItemsModels=salesService.getSalesLineItemsModelsBySalesOrderModel(salesOrderModel);
					salesFormBeans=SalesFormBeanPreparation.prepareSalesFormBeansList(salesLineItemsModels);
				}
			}*/
		}


		return salesFormBeans;

	}

	@RequestMapping(value = "/loadInCompletedPreSales", 
			method = RequestMethod.POST, 
			headers="Accept=*/*")
	public @ResponseBody List<SalesFormBean> getInCompletedPreSalesOrderIntoSalesForm(HttpServletRequest request,HttpSession session){

		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		if(mode[0]==1){
			fileName=mode[2]+".txt";
			path=request.getRealPath("/PSO/"+fileName);
			int sOId=0;
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
				salesFormBeans = (List<SalesFormBean>)ois.readObject();
				System.out.println(salesFormBeans.size());
				for(SalesFormBean bean:salesFormBeans){
					sOId=bean.getsOId();
					System.out.println("***************"+bean.getsOId());
					System.out.println("***************"+bean.getBatNo());
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if(sOId!=0){
				salesOrderModel=new SalesOrderModel();
				salesOrderModel.setId(sOId);
				salesLineItemsModels=salesService.getSalesLineItemsModelsBySalesOrderModel(salesOrderModel);
				salesFormBeans=SalesFormBeanPreparation.prepareSalesFormBeansList(salesLineItemsModels);
			}
		}


		return salesFormBeans;

	}
	@RequestMapping(value = "/loadPreSales", 
			method = RequestMethod.POST, 
			headers="Accept=*/*")
	public @ResponseBody boolean getPreSalesOrderIntoSalesForm(HttpServletRequest request,HttpSession session,
			@RequestParam("pSOId") String pSOId){

		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		salesFormBeans=new ArrayList<SalesFormBean>();
		model=new HashMap<String, Object>();
		boolean retunFlag=false;
		if(mode[0]==1){
			
		
			fileName=mode[2]+".txt";
			path=request.getRealPath("/SO/"+fileName);
			System.out.println("File Path >>>>>>>>>"+path);
			int sOId=0;
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
				salesFormBeans = (List<SalesFormBean>)ois.readObject();
				System.out.println(salesFormBeans.size());
				for(SalesFormBean bean:salesFormBeans){
					sOId=bean.getsOId();
					System.out.println("***************"+bean.getsOId());
					System.out.println("***************"+bean.getBatNo());
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if(sOId!=0){
				
				
			}else{
				salesLineItemsModel = new SalesLineItemsModel();
				salesOrderModel = new SalesOrderModel();
				salesOrderModel.setId(Integer.parseInt(pSOId));
				salesLineItemsModel.setSalesOrderModel(salesOrderModel);

				salesLineItemsModels=salesService.getSalesLineItemsModelsBySalesOrderModel(salesOrderModel);
				
				salesFormBeans=SalesFormBeanPreparation.prepareSalesFormBeansList(salesLineItemsModels);
				
			//	String fileName=mode[2]+".txt";
			//	String path=request.getRealPath("/PSO/"+fileName);

				FileOutputStream fos;
				try {
					fos = new FileOutputStream(path);
					objectOutputStream = new ObjectOutputStream(fos);
					objectOutputStream.writeObject(salesFormBeans);
					objectOutputStream.flush();
					objectOutputStream.close();
					retunFlag=true;
				} catch (Exception e) {
					e.printStackTrace();
					retunFlag=false;
				}
			}
			
			
			
			

		}

		return retunFlag;

	}	
	
	ObjectOutputStream objectOutputStream;

	@RequestMapping(value = "/submitSalesOrder", 
			method = RequestMethod.POST, 
			headers="Accept=*/*")
	public ModelAndView saveOrder(HttpServletRequest request,HttpSession session,
											@RequestParam("flag") String orderType,
											@RequestParam("oDis") String overall_discount,
											@RequestParam("dId") String doctorId){

		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		String returnMsg=null;
		if(mode[0]==1){
			fileName=mode[2]+".txt";
			path=request.getRealPath("/SO/"+fileName);
			int sOId=0;
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
				salesFormBeans = (List<SalesFormBean>)ois.readObject();
				System.out.println(salesFormBeans.size());
				for(SalesFormBean bean:salesFormBeans){
					sOId=bean.getsOId();
					System.out.println("***************"+bean.getsOId());
					System.out.println("***************"+bean.getBatNo());
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			if(sOId!=0){
				salesOrderModel=new SalesOrderModel();
				salesOrderModel.setId(sOId);
				salesLineItemsModels=salesService.getSalesLineItemsModelsBySalesOrderModel(salesOrderModel);




				if(salesLineItemsModels.size()!=0){
					salesOrderModel=salesLineItemsModels.get(0).getSalesOrderModel();
				}
				categoryModel=new CategoryModel();
				if(orderType.contentEquals("0")){
					categoryModel.setId(preSales);
				}else{
					categoryModel.setId(sales);
				}
				categoryModel=resourcesService.getCategory(categoryModel);
				DoctorModel doctorModel=new DoctorModel();
				doctorModel.setId(Integer.parseInt(doctorId));
				doctorModel=doctorService.getDoctor(doctorModel);
				
				statusModel=new StatusModel();
				statusModel.setId(close);
				statusModel=resourcesService.getStatus(statusModel);
				List<SalesLineItemsModel> itemModels=new ArrayList<SalesLineItemsModel>();
				
				SalesOrderModel salesOrderModel1=new SalesOrderModel();
				int count=0;
				for(SalesLineItemsModel itemModel:salesLineItemsModels){
					
					if(!overall_discount.contentEquals("") && !overall_discount.contentEquals("0") ){
						productInventoryModel=new ProductInventoryModel();
						productInventoryModel=itemModel.getProductInventoryModel();
					
				/*		salesLineItemsBean.setSalesOrderBean(salesOrderBean);
						salesLineItemsBean.setAmount(SalesLineItemsModelPreparation.getAmount(productInventoryBean.getPrice(), salesLineItemsBean.getQuantity()));
						salesLineItemsBean.setMargin(SalesLineItemsModelPreparation.getMargin(salesLineItemsBean.getProductInventoryBean().getDlPrice(), salesLineItemsBean.getProductInventoryBean().getPrice(),salesLineItemsBean.getQuantity(), salesLineItemsBean.getVat(), salesLineItemsBean.getDiscount()));
						salesLineItemsBean.setNetPrice(SalesLineItemsModelPreparation.getNetPrice(salesLineItemsBean.getProductInventoryBean().getPrice(), salesLineItemsBean.getVat(), salesLineItemsBean.getDiscount()));
							
				*/		
						Double payAmount=SalesLineItemsModelPreparation.getPayAmount(itemModel.getUnitPrice(), itemModel.getQuantity(), itemModel.getVat(), itemModel.getDiscount()+Double.parseDouble(overall_discount));
						Double vatAmount=SalesLineItemsModelPreparation.getLineItemVatPrice(itemModel.getUnitPrice(), itemModel.getQuantity(), itemModel.getVat(), itemModel.getDiscount()+Double.parseDouble(overall_discount));
						Double disAmount=SalesLineItemsModelPreparation.getLineItemDiscountPrice(itemModel.getUnitPrice(), itemModel.getQuantity(), itemModel.getDiscount()+Double.parseDouble(overall_discount));
						Double margin=SalesLineItemsModelPreparation.getMargin(productInventoryModel.getDlPrice(), itemModel.getUnitPrice(), itemModel.getQuantity(), itemModel.getVat(), itemModel.getDiscount()+Double.parseDouble(overall_discount));
						Double netPrice=SalesLineItemsModelPreparation.getNetPrice(productInventoryModel.getPrice(), itemModel.getVat(), itemModel.getDiscount()+Double.parseDouble(overall_discount));
						
						itemModel.setDiscount(itemModel.getDiscount()+Double.parseDouble(overall_discount));
						itemModel.setNetPrice(netPrice);
						itemModel.setMargin(margin);
						
						if(count==0){
							salesOrderModel1.setDiscountPrice(disAmount);
							salesOrderModel1.setMargin(margin);
							salesOrderModel1.setPayAmount(payAmount);
							salesOrderModel1.setTotalVAT(vatAmount);	
							
						}else{
							salesOrderModel1.setDiscountPrice(disAmount+salesOrderModel1.getDiscountPrice());
							salesOrderModel1.setMargin(margin+salesOrderModel1.getMargin());
							salesOrderModel1.setPayAmount(payAmount+salesOrderModel1.getPayAmount());
							salesOrderModel1.setTotalVAT(vatAmount+salesOrderModel1.getTotalVAT());
						}
						
						
						
						salesOrderModel.setDiscountPrice(salesOrderModel1.getDiscountPrice());
						salesOrderModel.setMargin(salesOrderModel1.getMargin());
						salesOrderModel.setPayAmount(salesOrderModel1.getPayAmount());
						salesOrderModel.setTotalVAT(salesOrderModel1.getTotalVAT());
						salesOrderModel.setOverallDiscount(Double.parseDouble(overall_discount));
					}

					salesOrderModel.setDoctorModel(doctorModel);
					itemModel.setStatusModel(statusModel);
					salesOrderModel.setCategoryModel(categoryModel);
					
					salesOrderModel.setStatusModel(statusModel);
					itemModel.setSalesOrderModel(salesOrderModel);
					itemModels.add(itemModel);
					
					count++;
				}
				
				
				
				salesOrderModel=salesService.confirmSalesOrder(itemModels);
				if(salesOrderModel!=null){
					returnMsg="Sales Order Successfully Submitted";
					/*File file = new File(path);
					if(file.delete()){
						System.out.println(file.getName() + " is deleted!");
					}else{
						System.out.println("Delete operation is failed.");
					}
					Path p =  Paths.get(path);
					try {
						Files.delete(p);
					} catch (NoSuchFileException x) {
						//uh oh file does not exist
					} catch (DirectoryNotEmptyException x) {
						//hmm do we really want to delete a directory containing files?
					} catch (IOException x) {
						//catch all for other IO problems
					} 
					 */
					fileName=mode[2]+".txt";
					path=request.getRealPath("/");
					System.out.println("******path*********"+path);
					path=path+"SO/"+fileName;
					FileOutputStream fos;
					try {
						fos = new FileOutputStream(path);
						objectOutputStream = new ObjectOutputStream(fos);
						salesFormBeans=new ArrayList<SalesFormBean>();
						objectOutputStream.writeObject(salesFormBeans);
						objectOutputStream.flush();
						objectOutputStream.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
					model = new HashMap<String, Object>();
					salesLineItemsModels=salesService.getSalesLineItemsModelsBySalesOrderModel(salesOrderModel);
					model.put("Items", salesLineItemsModels);
					salesOrderModel.setDiscountPrice(Double.parseDouble(new DecimalFormat("##.##").format(salesOrderModel.getDiscountPrice())));
					salesOrderModel.setTotalVAT(Double.parseDouble(new DecimalFormat("##.##").format(salesOrderModel.getTotalVAT())));
					salesOrderModel.setPayAmount(Double.parseDouble(new DecimalFormat("##.##").format(salesOrderModel.getPayAmount())));
					salesOrderModel.setAmount(Double.parseDouble(new DecimalFormat("##.##").format(salesOrderModel.getAmount())));
					model.put("Order", salesOrderModel);



					Map<String,String> vatDetails=new HashMap<String,String>();
					Map vatMap=new HashMap();
					double vat_percent=0;
					double vat_applied_amount=0;
					double vat_amount=0;
					double[] vat_Array = null;
					//String vatDeatils="";
					for(SalesLineItemsModel saLineItemsModel1:salesLineItemsModels){
						vat_percent=saLineItemsModel1.getVat();
						double dicounted_amount=(saLineItemsModel1.getAmount())*(saLineItemsModel1.getDiscount()/100);
						vat_applied_amount=(saLineItemsModel1.getAmount()-dicounted_amount);
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

						vatDetails.put(""+vat_Array[0]+"", "vat on " + Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[1])) + " @ "+vat_Array[0]+" is "+ Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[2])));
						//vatDeatils=vatDeatils+"<div>vat on " + Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[1])) + " @ "+vat_Array[0]+" is "+ Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[2]))+"</div>";
						total_Vat_Appaly_Amount=total_Vat_Appaly_Amount+Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[1]));
						total_Vat=total_Vat+Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[2]));
					}//)
					//vatDeatils=vatDeatils+"<div>-------------------------------------------------</div>";
					//vatDeatils=vatDeatils+"<div>total vat on "+total_Vat_Appaly_Amount+ " is "+total_Vat+"</div>";
					vatDetails.put("Total", "total vat on "+total_Vat_Appaly_Amount+ " is "+total_Vat+"");

					System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> vatDeatils >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+vatDetails);
					model.put("vatDetails", vatDetails);
				}


			}




		}
		model.put("flag", "SO");
		return new ModelAndView("sOInvoiceView", model);
	}
	@RequestMapping(value = "/loadInvoiceBySales", 
			method = RequestMethod.POST, 
			headers="Accept=*/*")
	public ModelAndView printOrder(HttpServletRequest request,HttpSession session,@RequestParam("sOId") String sOID){

		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		String returnMsg=null;
		if(mode[0]==1){


			salesOrderModel=new SalesOrderModel();
			salesOrderModel.setId(Integer.parseInt(sOID));
			salesLineItemsModels=salesService.getSalesLineItemsModelsBySalesOrderModel(salesOrderModel);

			if(salesLineItemsModels!=null){
				returnMsg="Sales Order Successfully Submitted";
				salesOrderModel=salesLineItemsModels.get(0).getSalesOrderModel();
				model = new HashMap<String, Object>();
				model.put("Items", salesLineItemsModels);
				salesOrderModel.setDiscountPrice(Double.parseDouble(new DecimalFormat("##.##").format(salesOrderModel.getDiscountPrice())));
				salesOrderModel.setTotalVAT(Double.parseDouble(new DecimalFormat("##.##").format(salesOrderModel.getTotalVAT())));
				salesOrderModel.setPayAmount(Double.parseDouble(new DecimalFormat("##.##").format(salesOrderModel.getPayAmount())));
				salesOrderModel.setAmount(Double.parseDouble(new DecimalFormat("##.##").format(salesOrderModel.getAmount())));

				model.put("Order", salesOrderModel);


				Map<String,String> vatDetails=new HashMap<String,String>();
				Map vatMap=new HashMap();
				double vat_percent=0;
				double vat_applied_amount=0;
				double vat_amount=0;
				double[] vat_Array = null;
				//String vatDeatils="";
				for(SalesLineItemsModel saLineItemsModel1:salesLineItemsModels){
					vat_percent=saLineItemsModel1.getVat();
					double dicounted_amount=(saLineItemsModel1.getAmount())*(saLineItemsModel1.getDiscount()/100);
					vat_applied_amount=(saLineItemsModel1.getAmount()-dicounted_amount);
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

					vatDetails.put(""+vat_Array[0]+"", "vat on " + Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[1])) + " @ "+vat_Array[0]+" is "+ Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[2])));
					//vatDeatils=vatDeatils+"<div>vat on " + Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[1])) + " @ "+vat_Array[0]+" is "+ Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[2]))+"</div>";
					total_Vat_Appaly_Amount=total_Vat_Appaly_Amount+Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[1]));
					total_Vat=total_Vat+Double.parseDouble(new DecimalFormat("##.##").format(vat_Array[2]));
				}//)
				//vatDeatils=vatDeatils+"<div>-------------------------------------------------</div>";
				//vatDeatils=vatDeatils+"<div>total vat on "+total_Vat_Appaly_Amount+ " is "+total_Vat+"</div>";
				vatDetails.put("Total", "total vat on "+total_Vat_Appaly_Amount+ " is "+total_Vat+"");

				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> vatDeatils >>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+vatDetails);
				model.put("vatDetails", vatDetails);
			}


		}

		model.put("flag", "SO");
		return new ModelAndView("sOInvoiceView", model);
	}

	//
	@RequestMapping(value = "/getLineItem", method = RequestMethod.POST, headers="Accept=*/*")
	public @ResponseBody SalesFormBean loadLineItem(HttpServletRequest request,HttpSession session,
			@RequestParam("solid") String solid){

		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);

		if(mode[0]==1){
			salesLineItemsModel=new SalesLineItemsModel();
			salesLineItemsModel.setId(Integer.parseInt(solid));
			salesLineItemsModel=salesService.getSalesOrderLineItemById(salesLineItemsModel);
			salesFormBean=SalesFormBeanPreparation.prepareSalesFormBean(salesLineItemsModel);
			salesFormBean.setsOId(salesLineItemsModel.getProductInventoryModel().getId());
		}
		return salesFormBean;
	}


	@RequestMapping(value = "/removeLineItem", method = RequestMethod.POST, headers="Accept=*/*")
	public @ResponseBody List<SalesFormBean> removeLineItemFromSalesOrder(HttpServletRequest request,HttpSession session,
			@RequestParam("solid") String solid){

		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);

		if(mode[0]==1){
			salesLineItemsModel=new SalesLineItemsModel();
			salesLineItemsModel.setId(Integer.parseInt(solid));
			salesLineItemsModel=salesService.getSalesOrderLineItemById(salesLineItemsModel);

			salesOrderModel=salesLineItemsModel.getSalesOrderModel();

			productInventoryModel=productService.getProductInventory(salesLineItemsModel.getProductInventoryModel());

			productInventoryModel.setQuantity(productInventoryModel.getQuantity()+salesLineItemsModel.getQuantity());

			Double payAmount=SalesLineItemsModelPreparation.getPayAmount(salesLineItemsModel.getUnitPrice(), salesLineItemsModel.getQuantity(), salesLineItemsModel.getVat(), salesLineItemsModel.getDiscount());
			Double vatAmount=SalesLineItemsModelPreparation.getLineItemVatPrice(salesLineItemsModel.getUnitPrice(), salesLineItemsModel.getQuantity(), salesLineItemsModel.getVat(), salesLineItemsModel.getDiscount());
			Double disAmount=SalesLineItemsModelPreparation.getLineItemDiscountPrice(salesLineItemsModel.getUnitPrice(), salesLineItemsModel.getQuantity(), salesLineItemsModel.getDiscount());

			salesOrderModel.setPayAmount(salesOrderModel.getPayAmount()-payAmount);
			salesOrderModel.setAmount(salesOrderModel.getAmount()-salesLineItemsModel.getAmount());
			salesOrderModel.setDiscountPrice(salesOrderModel.getDiscountPrice()-disAmount);
			salesOrderModel.setTotalVAT(salesOrderModel.getTotalVAT()-vatAmount);
			salesOrderModel.setMargin(salesLineItemsModel.getMargin()-salesLineItemsModel.getMargin());
			salesLineItemsModel.setSalesOrderModel(salesOrderModel);
			salesLineItemsModel.setProductInventoryModel(productInventoryModel);
			salesLineItemsModels=salesService.updateSalesOrder(salesLineItemsModel);
			salesFormBeans=new ArrayList<SalesFormBean>();
			if(salesLineItemsModels!=null){
				salesFormBeans=SalesFormBeanPreparation.prepareSalesFormBeansList(salesLineItemsModels);
			}
			String fileName=mode[2]+".txt";
			String path=request.getRealPath("/SO/"+fileName);

			FileOutputStream fos;
			try {
				fos = new FileOutputStream(path);
				objectOutputStream = new ObjectOutputStream(fos);
				objectOutputStream.writeObject(salesFormBeans);
				objectOutputStream.flush();
				objectOutputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return salesFormBeans;
	}

	String fileName=null;
	String path=null;

	@RequestMapping(value = "/createSalesOrder", 
			method = RequestMethod.POST, 
			headers="Accept=*/*")
	public @ResponseBody List<SalesFormBean> createOrder(HttpServletRequest request,@ModelAttribute("command") SalesLineItemsBean salesLineItemsBean,BindingResult result,HttpSession session) {

		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		if(mode[0]==1){
			if(salesLineItemsBean.getId()==null){
				productInventoryModel=new ProductInventoryModel();
				productInventoryModel.setId(salesLineItemsBean.getProductInventoryBean().getId());
				productInventoryModel=productService.getProductInventory(productInventoryModel);

				ProductInventoryBean productInventoryBean=ProductInventoryBeanPreparation.prepareProductInventoryBean(productInventoryModel);

				SalesOrderBean salesOrderBean=salesLineItemsBean.getSalesOrderBean();
				salesOrderBean.setCategoryBean(categoryBean);
				salesOrderBean.setOutletBean(outletBean);
				salesOrderBean.setBranchBean(branchBean);


				fileName=mode[2]+".txt";
				path=request.getRealPath("/SO/"+fileName);
				int sOId=0;
				try {
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
					salesFormBeans = (List<SalesFormBean>)ois.readObject();
					System.out.println(salesFormBeans.size());
					for(SalesFormBean bean:salesFormBeans){
						sOId=bean.getsOId();
						System.out.println("***************"+bean.getsOId());
						System.out.println("***************"+bean.getBatNo());
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}


				if(sOId==0){
					salesOrderBean.setOrderIdByDate("");
					salesOrderBean.setAmount(SalesLineItemsModelPreparation.getAmount(productInventoryBean.getPrice(), salesLineItemsBean.getQuantity()));
					salesOrderBean.setDiscountPrice(SalesLineItemsModelPreparation.getTotalDiscountPrice(productInventoryBean.getPrice(), salesLineItemsBean.getQuantity(), salesLineItemsBean.getDiscount()));
					salesOrderBean.setTotalVAT(SalesLineItemsModelPreparation.getTotalVatPrice(productInventoryBean.getPrice(), salesLineItemsBean.getQuantity(), salesLineItemsBean.getVat(), salesLineItemsBean.getDiscount()));
					salesOrderBean.setMargin(SalesLineItemsModelPreparation.getMargin(productInventoryBean.getDlPrice(),productInventoryBean.getPrice(), salesLineItemsBean.getQuantity(), salesLineItemsBean.getVat(), salesLineItemsBean.getDiscount()));
					salesOrderBean.setPayAmount(SalesLineItemsModelPreparation.getPayAmount(productInventoryBean.getPrice(), salesLineItemsBean.getQuantity(), salesLineItemsBean.getVat(), salesLineItemsBean.getDiscount()));

					customerBean=new CustomerBean();
					addressBean=new AddressBean();
					customerModel=new CustomerModel();
					addressModel=new AddressModel();
					CustomerBean customerBean1=new CustomerBean();

					customerBean=salesLineItemsBean.getSalesOrderBean().getCustomerBean();
					addressBean=customerBean.getAddressBean();
				
					customerModel.setId(1);
					customerModel=consumerService.getDefaultCustomer(customerModel);
					addressModel=customerModel.getAddressModel();
					customerBean1.setRoleBean(AddressBeanPreparation.prepareRoleBean(resourcesService.getRole(customerModel.getRoleModel())));
					
					
					
					if((customerBean.getId()==null) && (customerBean.getName()==null ||  customerBean.getName()=="" ) && 
							(customerBean.getAddressBean().getAddress()==null || customerBean.getAddressBean().getAddress()=="") && 
							(customerBean.getAddressBean().getMobile()==null) &&
							(customerBean.getAddressBean().getEmail()==null || customerBean.getAddressBean().getEmail()=="") ){

						customerBean=CustomerBeanPreparation.prepareCustomerBean(customerModel);

					}else if(customerBean.getId()!=null){
						customerModel.setId(salesOrderBean.getCustomerBean().getId());
						customerModel=consumerService.getDefaultCustomer(customerModel);
						customerBean=CustomerBeanPreparation.prepareCustomerBean(customerModel);

					}else{

					//	if(customerBean.getId()==null){
							customerBean.setCreatedBy(mode[2]);
							if(customerBean.getName()==null || customerBean.getName()==""){
								customerBean.setName(customerModel.getName());

							}
							if((customerBean.getAddressBean().getMobile()==null)
									&&	(customerBean.getAddressBean().getAddress()==null || customerBean.getAddressBean().getAddress()=="")
									&& (customerBean.getAddressBean().getEmail()==null || customerBean.getAddressBean().getEmail()=="")){
								customerBean.setAddressBean(AddressBeanPreparation.prepareAddressBean(addressModel));

							}else{
								addressBean=new AddressBean();
								addressBean=customerBean.getAddressBean();
								if(customerBean.getAddressBean().getAddress()==null || customerBean.getAddressBean().getAddress()==""){
									addressBean.setAddress(addressModel.getAddress());
								}if(customerBean.getAddressBean().getMobile()==null){
									addressBean.setMobile(addressModel.getMobile());
								}if(customerBean.getAddressBean().getEmail()==null || customerBean.getAddressBean().getEmail()==""){
									addressBean.setEmail(addressModel.getEmail());
								}
								
								
								customerBean.setAddressBean(addressBean);
							}
						//}
							customerBean.setRoleBean(customerBean1.getRoleBean());
					}
					
					salesOrderBean.setCustomerBean(customerBean);




				/*	if(customerBean.getId()==null){

						customerModel.setId(1);
						customerModel=consumerService.getDefaultCustomer(customerModel);
						addressModel=customerModel.getAddressModel();
						customerBean1=CustomerBeanPreparation.prepareCustomerBean(customerModel);
						//customerBean1.setRoleBean(AddressBeanPreparation.prepareRoleBean(resourcesService.getRole(customerModel.getRoleModel())));
					}

					if(customerBean.getId()==null){
						customerBean.setCreatedBy(mode[2]);
						if(customerBean.getName()==null || customerBean.getName()==""){
							customerBean.setName(customerModel.getName());

						}
						if((customerBean.getAddressBean().getMobile()==null)
								&&	(customerBean.getAddressBean().getAddress()==null || customerBean.getAddressBean().getAddress()=="")
								&& (customerBean.getAddressBean().getEmail()==null || customerBean.getAddressBean().getEmail()=="")){
							customerBean.setAddressBean(AddressBeanPreparation.prepareAddressBean(addressModel));

						}else{
							addressBean=new AddressBean();
							addressBean=customerBean.getAddressBean();
							if(customerBean.getAddressBean().getAddress()==null || customerBean.getAddressBean().getAddress()==""){
								addressBean.setAddress(addressModel.getAddress());
							}if(customerBean.getAddressBean().getMobile()==null){
								addressBean.setMobile(addressModel.getMobile());
							}if(customerBean.getAddressBean().getEmail()==null || customerBean.getAddressBean().getEmail()==""){
								addressBean.setEmail(addressModel.getEmail());
							}
							customerBean.setAddressBean(addressBean);
						}
					}else{
						customerModel.setId(salesOrderBean.getCustomerBean().getId());
						customerModel=consumerService.getDefaultCustomer(customerModel);
						customerBean=CustomerBeanPreparation.prepareCustomerBean(customerModel);
					}
					customerBean.setRoleBean(customerBean1.getRoleBean());
					salesOrderBean.setCustomerBean(customerBean);*/
				}else{

					//int soid=(int) session.getAttribute("sales_oid");
					salesOrderModel=new SalesOrderModel();
					salesOrderModel.setId(sOId);
					salesOrderModel=salesService.getSalesOrder(salesOrderModel);
					//	if(salesOrderModel.)
					salesOrderBean.setId(salesOrderModel.getId());
					salesOrderBean.setOrderIdByDate(salesOrderModel.getOrderIdByDate());
					salesOrderBean.setAmount(SalesLineItemsModelPreparation.getAmount(productInventoryBean.getPrice(), salesLineItemsBean.getQuantity())+salesOrderModel.getAmount());
					salesOrderBean.setDiscountPrice(SalesLineItemsModelPreparation.getTotalDiscountPrice(productInventoryBean.getPrice(), salesLineItemsBean.getQuantity(), salesLineItemsBean.getDiscount())+salesOrderModel.getDiscountPrice());
					salesOrderBean.setTotalVAT(SalesLineItemsModelPreparation.getTotalVatPrice(productInventoryBean.getPrice(), salesLineItemsBean.getQuantity(), salesLineItemsBean.getVat(), salesLineItemsBean.getDiscount())+salesOrderModel.getTotalVAT());
					salesOrderBean.setMargin(SalesLineItemsModelPreparation.getMargin(productInventoryBean.getDlPrice(),productInventoryBean.getPrice(), salesLineItemsBean.getQuantity(), salesLineItemsBean.getVat(), salesLineItemsBean.getDiscount())+salesOrderModel.getMargin());
					salesOrderBean.setPayAmount(SalesLineItemsModelPreparation.getPayAmount(productInventoryBean.getPrice(), salesLineItemsBean.getQuantity(), salesLineItemsBean.getVat(), salesLineItemsBean.getDiscount())+salesOrderModel.getPayAmount());

				}
				salesLineItemsBean.setProductInventoryBean(productInventoryBean);
				salesLineItemsBean.setOutletBean(outletBean);
				salesLineItemsBean.setSalesOrderBean(salesOrderBean);
				salesLineItemsBean.setAmount(SalesLineItemsModelPreparation.getAmount(productInventoryBean.getPrice(), salesLineItemsBean.getQuantity()));
				salesLineItemsBean.setMargin(SalesLineItemsModelPreparation.getMargin(salesLineItemsBean.getProductInventoryBean().getDlPrice(), salesLineItemsBean.getProductInventoryBean().getPrice(),salesLineItemsBean.getQuantity(), salesLineItemsBean.getVat(), salesLineItemsBean.getDiscount()));
				salesLineItemsBean.setNetPrice(SalesLineItemsModelPreparation.getNetPrice(salesLineItemsBean.getProductInventoryBean().getPrice(), salesLineItemsBean.getVat(), salesLineItemsBean.getDiscount()));
				salesLineItemsBean.setPreparationCharges(0.00);



				salesLineItemsModel=SalesLineItemsModelPreparation.prepareSalesLineItemsModel(salesLineItemsBean);

				outletModel=new OutletModel();
				outletModel.setId(mode[2]);
				outletModel=outletService.getOutlet(outletModel);

				branchModel=new BranchModel();
				branchModel.setId(productInventoryBean.getBranchBean().getId());
				branchModel=branchService.getBranchbyId(branchModel);

				categoryModel=new CategoryModel();
				categoryModel.setId(sales);
				categoryModel=resourcesService.getCategory(categoryModel);

				statusModel=new StatusModel();
				statusModel.setId(open);
				statusModel=resourcesService.getStatus(statusModel);

				salesOrderModel=salesLineItemsModel.getSalesOrderModel();
				salesOrderModel.setOutletModel(outletModel);
				salesOrderModel.setBranchModel(branchModel);
				salesOrderModel.setCategoryModel(categoryModel);
				salesOrderModel.setStatusModel(statusModel);
				salesOrderModel.setOverallDiscount(0.0);



				salesLineItemsModel.setSalesOrderModel(salesOrderModel);
				salesLineItemsModel.setOutletModel(outletModel);
				salesLineItemsModel.setStatusModel(statusModel);
				salesLineItemsModel.setUnitPrice(productInventoryModel.getPrice());
				salesLineItemsModel.setExpiryDate(productInventoryModel.getExpiryDate());

				salesLineItemsModel=salesService.createSalesOrder(salesLineItemsModel);
				//	salesFormBean=SalesFormBeanPreparation.prepareSalesFormBean(salesLineItemsModel);

				salesLineItemsModels=salesService.getSalesLineItemsModelsBySalesOrderModel(salesLineItemsModel.getSalesOrderModel());

				salesFormBeans=SalesFormBeanPreparation.prepareSalesFormBeansList(salesLineItemsModels);

				try {

					fileName=mode[2]+".txt";


					path=request.getRealPath("/");
					System.out.println("******path*********"+path);
					path=path+"SO/"+fileName;
					FileOutputStream fos=new FileOutputStream(path);
					objectOutputStream = new ObjectOutputStream(fos);
					objectOutputStream.writeObject(salesFormBeans);

					objectOutputStream.flush();

					objectOutputStream.close();

					// the object input stream reads the objects back from the file and
					// creates java objects out of them. It recreates all
					// references that were present when the objects were written
					ObjectInputStream objectInputStream = new ObjectInputStream(
							new FileInputStream(path));



					// start getting the objects out in the order in which they were written
					salesFormBeans = (List<SalesFormBean>) objectInputStream.readObject();
					System.out.println(salesFormBeans.size());
					for(SalesFormBean bean:salesFormBeans){
						System.out.println("***************"+bean.getsOId());
						System.out.println("***************"+bean.getBatNo());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}


			}else{
				salesLineItemsModel=new SalesLineItemsModel();
				salesLineItemsModel.setId(salesLineItemsBean.getId());
				salesLineItemsModel=salesService.getSalesOrderLineItemById(salesLineItemsModel);


				salesOrderModel=salesLineItemsModel.getSalesOrderModel();

				productInventoryModel=productService.getProductInventory(salesLineItemsModel.getProductInventoryModel());



				Double payAmount=SalesLineItemsModelPreparation.getPayAmount(salesLineItemsModel.getUnitPrice(), salesLineItemsModel.getQuantity(), salesLineItemsModel.getVat(), salesLineItemsModel.getDiscount());
				Double vatAmount=SalesLineItemsModelPreparation.getLineItemVatPrice(salesLineItemsModel.getUnitPrice(), salesLineItemsModel.getQuantity(), salesLineItemsModel.getVat(), salesLineItemsModel.getDiscount());
				Double disAmount=SalesLineItemsModelPreparation.getLineItemDiscountPrice(salesLineItemsModel.getUnitPrice(), salesLineItemsModel.getQuantity(), salesLineItemsModel.getDiscount());

				salesOrderModel.setPayAmount(salesOrderModel.getPayAmount()-payAmount);
				salesOrderModel.setAmount(salesOrderModel.getAmount()-salesLineItemsModel.getAmount());
				salesOrderModel.setDiscountPrice(salesOrderModel.getDiscountPrice()-disAmount);
				salesOrderModel.setTotalVAT(salesOrderModel.getTotalVAT()-vatAmount);
				salesOrderModel.setMargin(salesLineItemsModel.getMargin()-salesLineItemsModel.getMargin());




				productInventoryModel.setQuantity(productInventoryModel.getQuantity()+salesLineItemsModel.getQuantity());
				ProductInventoryModel newProductInventoryModel=new ProductInventoryModel();
				int pid=productInventoryModel.getId();
				if(pid==salesLineItemsBean.getProductInventoryBean().getId()){
					newProductInventoryModel=productInventoryModel;

				}else{

					newProductInventoryModel.setId(salesLineItemsBean.getProductInventoryBean().getId());
					newProductInventoryModel=productService.getProductInventory(newProductInventoryModel);
				}
				/****************************************************************************/



				salesOrderModel.setAmount(SalesLineItemsModelPreparation.getAmount(newProductInventoryModel.getPrice(), salesLineItemsBean.getQuantity())+salesOrderModel.getAmount());
				salesOrderModel.setDiscountPrice(SalesLineItemsModelPreparation.getTotalDiscountPrice(newProductInventoryModel.getPrice(), salesLineItemsBean.getQuantity(), salesLineItemsBean.getDiscount())+salesOrderModel.getDiscountPrice());
				salesOrderModel.setTotalVAT(SalesLineItemsModelPreparation.getTotalVatPrice(newProductInventoryModel.getPrice(), salesLineItemsBean.getQuantity(), salesLineItemsBean.getVat(), salesLineItemsBean.getDiscount())+salesOrderModel.getTotalVAT());
				salesOrderModel.setMargin(SalesLineItemsModelPreparation.getMargin(newProductInventoryModel.getDlPrice(),newProductInventoryModel.getPrice(), salesLineItemsBean.getQuantity(), salesLineItemsBean.getVat(), salesLineItemsBean.getDiscount())+salesOrderModel.getMargin());
				salesOrderModel.setPayAmount(SalesLineItemsModelPreparation.getPayAmount(newProductInventoryModel.getPrice(), salesLineItemsBean.getQuantity(), salesLineItemsBean.getVat(), salesLineItemsBean.getDiscount())+salesOrderModel.getPayAmount());

				//newProductInventoryModel.setQuantity(newProductInventoryModel.getQuantity()-salesLineItemsBean.getQuantity());

				salesLineItemsModel.setProductInventoryModel(newProductInventoryModel);
				salesLineItemsModel.setSalesOrderModel(salesOrderModel);

				salesLineItemsModel.setAmount(SalesLineItemsModelPreparation.getAmount(newProductInventoryModel.getPrice(), salesLineItemsBean.getQuantity()));
				salesLineItemsModel.setMargin(SalesLineItemsModelPreparation.getMargin(newProductInventoryModel.getDlPrice(), newProductInventoryModel.getPrice(),salesLineItemsBean.getQuantity(), salesLineItemsBean.getVat(), salesLineItemsBean.getDiscount()));
				salesLineItemsModel.setNetPrice(SalesLineItemsModelPreparation.getNetPrice(newProductInventoryModel.getPrice(), salesLineItemsBean.getVat(), salesLineItemsBean.getDiscount()));
				salesLineItemsModel.setPreparationCharges(0.00);
				salesLineItemsModel.setVat(salesLineItemsBean.getVat());
				salesLineItemsModel.setDiscount(salesLineItemsBean.getDiscount());
				salesLineItemsModel.setDelivaeredQuantity(salesLineItemsBean.getQuantity());
				salesLineItemsModel.setDeliverableQuantity(newProductInventoryModel.getQuantity());
				salesLineItemsModel.setExpiryDate(newProductInventoryModel.getExpiryDate());
				salesLineItemsModel.setQuantity(salesLineItemsBean.getQuantity());
				salesLineItemsModel.setUnitPrice(newProductInventoryModel.getPrice());

				salesLineItemsModels=salesService.updateSalesLineItem(productInventoryModel,salesLineItemsModel);

				salesFormBeans=SalesFormBeanPreparation.prepareSalesFormBeansList(salesLineItemsModels);

				try {

					fileName=mode[2]+".txt";

					path=request.getRealPath("/");
					System.out.println("******path*********"+path);
					path=path+"SO/"+fileName;
					FileOutputStream fos=new FileOutputStream(path);
					objectOutputStream = new ObjectOutputStream(fos);
					objectOutputStream.writeObject(salesFormBeans);

					objectOutputStream.flush();

					objectOutputStream.close();

					// the object input stream reads the objects back from the file and
					// creates java objects out of them. It recreates all
					// references that were present when the objects were written
					ObjectInputStream objectInputStream = new ObjectInputStream(
							new FileInputStream(path));



					// start getting the objects out in the order in which they were written
					salesFormBeans = (List<SalesFormBean>) objectInputStream.readObject();
					System.out.println(salesFormBeans.size());
					for(SalesFormBean bean:salesFormBeans){
						System.out.println("***************"+bean.getsOId());
						System.out.println("***************"+bean.getBatNo());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}




			}

		}
		return salesFormBeans;

	}


	@RequestMapping(value = "/getCustomer", 
			method = RequestMethod.POST, 
			headers="Accept=*/*")
	public @ResponseBody CustomerModel loadCustomer(@RequestParam(value="mobile") String mobileNo,
			HttpSession session) {

		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		if(mode[0]==1){

			long val =  ((Number)Long.valueOf(mobileNo)).intValue();

			addressModel=new AddressModel();
			customerModel=new CustomerModel();
			addressModel.setMobile(Long.valueOf(mobileNo));
			customerModel.setAddressModel(addressModel);

			List<CustomerModel> customerModels=new ArrayList<CustomerModel>();

			customerModels=consumerService.getCustomer(customerModel);
			if(customerModels.size()>0){
				customerModel=customerModels.get(0);
			}
		}	
		return customerModel;
	}
	List<SalesOrderModel> salesOrderModels = null;
	@RequestMapping(value = "/salesOrderList", method = RequestMethod.GET)
	public ModelAndView salesOrderList(HttpSession session,
			@ModelAttribute("command") SalesOrderBean salesOrderBean ,BindingResult result,
			@RequestParam(value="flag") String flag,
			@RequestParam(value="task_type") String task_type
			){
		initializeProperties();
		userSessionBean = SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){  
			model = new HashMap<String, Object>();
			salesOrderModel = new SalesOrderModel();
			organizationModel = new OrganizationModel();
			branchModel = new BranchModel();
			salesOrderModels = new ArrayList<SalesOrderModel>();
			categoryModel = new CategoryModel();
			if(task_type.contentEquals("sales")){
			categoryModel.setId(sales);
			}
			else if(task_type.contentEquals("preSales")){
				categoryModel.setId(preSales);
				}
			salesOrderModel.setCategoryModel(categoryModel);
			try {   

			if(mode[1]== outlet){			     
					branchModel.setId(userSessionBean.getBranchBean().getId());	
					salesOrderModel.setBranchModel(branchModel); 
					salesOrderModels = salesService.salesOrderListByBranchOrOutlet(salesOrderModel);

				}else 
				if(mode[1]== branch){
					branchModel.setId(mode[2]);
					salesOrderModel.setBranchModel(branchModel); 
					salesOrderModels = salesService.salesOrderListByBranchOrOutlet(salesOrderModel);

				}else if(mode[1]== organization){
					organizationModel.setId(mode[2]);
					branchModel.setOrganizationModel(organizationModel);
					salesOrderModel.setBranchModel(branchModel); 

					salesOrderModels = salesService.salesOrderListByOrganization(salesOrderModel);
					
				}

				System.out.println("method called");
			} catch (Exception e) {

				e.printStackTrace();
			}
						
			model.put("salesOrders", SalesOrderBeanPreparation.prepareListOfSalesOrderBean(salesOrderModels));
			model.put("sale", sales);
			model.put("preSale", preSales);
			
			if(flag.contentEquals("task_main")){
				return new ModelAndView("salesOrderList",model);
			}else {
				return new ModelAndView("reOpenSalesOrderList",model);
			}
		}else{
			return new ModelAndView("error");
		}  

	}
	@RequestMapping(value = "/getSalesLineItems",
			method = RequestMethod.POST)
	public ModelAndView  getSalesLineItems(HttpSession session,@ModelAttribute("command")                     
	SalesLineItemsBean salesLineItemsBean,BindingResult result,
	@RequestParam(value="sOId") String sOId,
	@RequestParam(value="flag") String flag)
			throws Exception {
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){  
			System.out.println("********Purchase Line Items ******* ");
			salesLineItemsModel = new SalesLineItemsModel();
			salesOrderModel = new SalesOrderModel();
			salesOrderModel.setId(Integer.parseInt(sOId));
			salesLineItemsModel.setSalesOrderModel(salesOrderModel);

			model = new HashMap<String, Object>();
			model.put("flag", flag);
			model.put("salesLineItems", SalesLineItemsBeanPreparation.prepareListOfSalesLineItemsBean(salesService.getSalesLineItemsModelsBySalesOrderModel(salesOrderModel)));
			model.put("sale", sales);
			model.put("preSale", preSales);

			return new ModelAndView("salesLineItemsList",model);
		}else{
			return new ModelAndView("error");
		}  
	}


}
