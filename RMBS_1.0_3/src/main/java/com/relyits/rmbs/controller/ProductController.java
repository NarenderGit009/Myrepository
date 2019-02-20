package com.relyits.rmbs.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
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

import com.relyits.rmbs.beans.registration.BranchRegistrationFormBean;
import com.relyits.rmbs.beans.product.FileBean;
import com.relyits.rmbs.beans.product.ProductBean;
import com.relyits.rmbs.beans.product.ProductDamageBean;
import com.relyits.rmbs.beans.product.ProductInventoryBean;
import com.relyits.rmbs.beans.product.ProductLogBean;
import com.relyits.rmbs.beans.registration.AgencyBean;
import com.relyits.rmbs.beans.registration.BranchBean;
import com.relyits.rmbs.beans.resources.CategoryBean;
import com.relyits.rmbs.beans.resources.RoleBean;
import com.relyits.rmbs.beans.resources.SubCategoryBean;
import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.beans_preparation.product.ProductBeanPreparation;
import com.relyits.rmbs.beans_preparation.product.ProductDamageBeanPreparation;
import com.relyits.rmbs.beans_preparation.product.ProductInventoryBeanPreparation;
import com.relyits.rmbs.beans_preparation.product.ProductLogBeanPreparation;
import com.relyits.rmbs.model.product.FileDataModel;
import com.relyits.rmbs.model.product.ProductDamageModel;
import com.relyits.rmbs.model.product.ProductInventoryModel;
import com.relyits.rmbs.model.product.ProductLogModel;
import com.relyits.rmbs.model.product.ProductModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.SubCategoryModel;
import com.relyits.rmbs.model.registration.AgencyModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model_preparation.product.ProductInventoryModelPreparation;
import com.relyits.rmbs.service.BranchService;
import com.relyits.rmbs.service.OrganizationService;
import com.relyits.rmbs.service.OutletService;
import com.relyits.rmbs.service.ProductService;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;
import com.relyits.rmbs.utilities.ExposablePropertyPaceholderConfigurer;
import com.relyits.rmbs.utilities.FormUtilities;
import com.relyits.rmbs.utilities.SessionUtilities;


@Controller
public class ProductController {


	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private BranchService branchService;
	@Autowired
	private OutletService outletService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ExposablePropertyPaceholderConfigurer properitesMap;

	private ProductInventoryModel productInventoryModel=null;
	private ProductInventoryBean productInventoryBean=null;
	private ProductModel productModel=null;
	private ProductLogModel productLogModel=null;
	private ProductBean productBean=null;
	private CategoryBean categoryBean=null;
	private SubCategoryModel subCategoryModel=null;
	private List<ProductModel> list=null;

	private  AgencyModel agencyModel=null;
	private  BranchModel branchModel=null;
	private  RoleModel creatorRoleModel=null;
	private OrganizationModel organizationModel = null;
	private ProductDamageModel productDamageModel = null;

	private SubCategoryBean subCategoryBean = null;
	private  RoleBean creatorRoleBean=null;
	private  AgencyBean agencyBean=null;
	@SuppressWarnings("unused")
	private  BranchBean branchBean=null;

	private UserSessionBean userSessionBean = null;


	List<String> productsList = null;
	Map<Integer,String> categories;
	CategoryModel categoryModel = null;


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



	//***************************Product*****************************

	Map<String, Object> model = null;

	@RequestMapping(value="/productEntryForm" ,
			method=RequestMethod.GET)
	public ModelAndView productEntryForm(HttpSession session,
			@ModelAttribute("command") ProductInventoryBean productInventoryBean,
			@RequestParam("task_form_type") String task_form_type,
			@RequestParam("task_type") String task_type){
		initializeProperties();
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		initializeProperties();
		if(mode[0]==1){

			model = new HashMap<String, Object>();	
			//	if(session.)
			String returnMessage=(String) session.getAttribute("msg");
			session.removeAttribute("msg");
			BranchModel branchModel = new BranchModel();
			OrganizationModel organizationModel = new OrganizationModel();
			organizationModel.setId(userSessionBean.getId());
			branchModel.setOrganizationModel(organizationModel);
			SubCategoryModel subCategoryModel = new SubCategoryModel();
			CategoryModel categoryModel = new CategoryModel();

			categoryModel.setId(medical);
			subCategoryModel.setCategoryModel(categoryModel);

			try {

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
			model.put("msg", returnMessage);
			if(task_type.contentEquals("main") && task_form_type.contentEquals("medical")){

				if(mode[1]== organization){
					return new ModelAndView("openMedicalProductEntryFormByOrganization", model);
				}else if(mode[1]== branch){
					return new ModelAndView("openMedicalProductEntryFormByBranch", model);
				}else if(mode[1]== outlet){
					return new ModelAndView("openMedicalProductEntryFormByOutlet", model);
				}
			}else if(task_type.contentEquals("main") && task_form_type.contentEquals("general")){
				if(mode[1]==organization){
					return new ModelAndView("openGeneralProductEntryFormByOrganization", model);
				}else if(mode[1]== branch){
					return new ModelAndView("openGeneralProductEntryFormByBranch", model);
				}else if(mode[1]== outlet){
					return new ModelAndView("openGeneralProductEntryFormByOutlet", model);
				}
			}else if(task_type.contentEquals("sub") && task_form_type.contentEquals("medical")){
				return new ModelAndView("reOpenMedicalProductEntryForm", model);
			}else if(task_type.contentEquals("sub") && task_form_type.contentEquals("general")){
				return new ModelAndView("reOpenGeneralProductEntryForm", model);
			}//openGeneralProductEntryFormByOrganization
		}else{
			return new ModelAndView("error");
		}
		return null;

	}
	/*
	@RequestMapping(value = "/get_medical_agency_list", 
			method = RequestMethod.GET, 
			headers="Accept=*//*")
	public @ResponseBody List<String> getAgenciesList(@RequestParam("term") String phrase,
			@RequestParam("type") String type,
			@RequestParam("shopid") String shopid) {
		Product product = new Product();
		product.setCategory(type);
		product.setShopid(Integer.parseInt(shopid));
		List<String> countryList = productService.getAgenciesList(product,phrase.trim());
		System.out.println("*******countryList****"+countryList.size());
		List<String> agencies = new ArrayList<>();
		for(int i=0;i<countryList.size();i++){
			Object o=(Object)countryList.get(i);
			AgencyModel agencyModel =(AgencyModel)o;
			agencies.add(agencyModel.getAgencyName()+"-"+agencyModel.getId());

		}
		return agencies;
	}
			 */
	@RequestMapping(value = "/get_medical_agency_list", 
			method = RequestMethod.GET, 
			headers="Accept=*/*")
	public @ResponseBody List<String> getAgenciesLists(@RequestParam("term") String phrase/*,
			@RequestParam("type") String type,
			@RequestParam("shopid") String shopid*/) {
		agencyModel = new AgencyModel();
		agencyModel.setAgencyName(phrase);
		//product.setShopid(Integer.parseInt(shopid));
		List<String> agenciesList = productService.getAgenciesList(agencyModel);
		List<String> agencies = new ArrayList<String>();
		for(int i=0;i<agenciesList.size();i++){
			Object o=(Object)agenciesList.get(i);
			agencyModel =(AgencyModel)o;
			agencies.add(agencyModel.getAgencyName()+"_"+agencyModel.getId());

		}
		return agencies;
	}

	/*	@RequestMapping(value = "/get_medical_products_list", 
			method = RequestMethod.GET, 
			headers="Accept=*//*")
	public @ResponseBody List<String> getProductsList(@RequestParam("term") String phrase,
			@RequestParam("type") String type,
			@RequestParam("shopid") String shopid) {
		Product product1 = new Product();
		product1.setCategory(type);
		product1.setShopid(Integer.parseInt(shopid));
		List<String> productsList = productService.getProductsList(product1,phrase.trim());
		List<String> products = new ArrayList<>();
		for(int i=0;i<productsList.size();i++){
			Object o=(Object)productsList.get(i);
			Product product =(Product)o;
			System.out.println("*****List<String> countryList*****"+product.getPname());
			products.add(product.getPname()+"-"+product.getPid());
		}

		return products;
	}*/

	@RequestMapping(value = "/get_products_list", 
			method = RequestMethod.GET, 
			headers="Accept=*/*")
	public @ResponseBody List<String> getProductsList(@RequestParam("term") String phrase,
			@RequestParam("type") String type,
			@RequestParam("bId") String shopid,
			@RequestParam("flag") String flag) {
		productModel = new ProductModel();
		categoryModel = new CategoryModel();

		categoryModel.setId(Integer.parseInt(type));
		productModel.setCategoryModel(categoryModel);

		productModel.setName(phrase);
		List<String> products = new ArrayList<String>();
		if(flag.contentEquals("P")){
			productsList = productService.getProductsList(productModel);
			for(int i=0;i<productsList.size();i++){
				Object o=(Object)productsList.get(i);
				productModel =(ProductModel)o;
				System.out.println("*****List<String> productsList*****"+productModel.getName());
				products.add(productModel.getName()+"_"+productModel.getSubCategoryModel().getCategory()+"_"+productModel.getId());
			}
		}else{
			productInventoryModel=new ProductInventoryModel();
			branchModel = new BranchModel();
			branchModel.setId(Integer.parseInt(shopid));
			productInventoryModel.setProductModel(productModel);
			productInventoryModel.setBranchModel(branchModel);
			List<ProductModel> productModels=productService.getInventroyProductsList(productInventoryModel);
			for(int i=0;i<productModels.size();i++){
				System.out.println("*****List<String> productsList*****"+productModels.get(i).getName());
				products.add(productModels.get(i).getName()+"_"+productModels.get(i).getSubCategoryModel().getCategory()+"_"+productModels.get(i).getId());
			}
		}

		
		return products;
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



	@RequestMapping(value = "saveProduct", 
			method = RequestMethod.POST)
	public  ModelAndView saveProduct(HttpSession session,@ModelAttribute("command") ProductInventoryBean productInventoryBean,
			@RequestParam(value="uid") String uid) throws Exception {

		System.out.println("**productInventoryBean.getProductBean().getCategoryBean().getId()****"+productInventoryBean.getProductBean().getCategoryBean().getId());
		System.out.println("**productInventoryBean.getProductBean().getSubCategoryBean().getId()****"+productInventoryBean.getProductBean().getSubCategoryBean().getId());

		System.out.println("**productInventoryBean.getAgencyBean().getId()"+productInventoryBean.getAgencyBean().getId());
		System.out.println("**productInventoryBean.getBranchBean().getId()****"+productInventoryBean.getBranchBean().getId());


		int mode[]=SessionUtilities.validateSession(uid, session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){

			Map<String, Object> model = new HashMap<String, Object>();

			agencyModel = new AgencyModel();
			branchModel = new BranchModel();
			creatorRoleModel = new RoleModel();
			productInventoryModel = new ProductInventoryModel();
			productModel = new ProductModel();
			productBean = new ProductBean();
			creatorRoleBean = new RoleBean();

			agencyBean = new AgencyBean();
			branchBean = new BranchBean();

			if(productInventoryBean.getId()==null){
				System.out.println("productInventoryBean.getBranchBean().getId() "+productInventoryBean.getBranchBean().getId());






				//agencyModel.setId(productInventoryBean.getAgencyBean().getId());
				//branchModel.setId(productInventoryBean.getBranchBean().getId());
				creatorRoleBean.setId(mode[1]);
				//productInventoryModel.setAgencyModel(agencyModel);
				//productInventoryModel.setBranchModel(branchModel);
				productInventoryBean.setCreatorRoleBean(creatorRoleBean);
				productInventoryBean.setCreatedBy(mode[2]);



				productBean=productInventoryBean.getProductBean();
				productBean.setCreatedBy(mode[2]);

				System.out.println("creatorRoleBean.setId(mode[1]); "+creatorRoleBean.getId());

				productBean.setCreatorRoleBean(creatorRoleBean);

				System.out.println("productBean.setCreatoerRoleBean(creatorRoleBean); "+productBean.getCreatorRoleBean().getId());

				productInventoryBean.setProductBean(productBean);

				productInventoryModel=ProductInventoryModelPreparation.prepareProductInventoryModel(productInventoryBean);


				productService.addProduct(productInventoryModel);
				model.put("msg", "Product Successfully Saved");

				/*BranchModel branchModel = new BranchModel();
				OrganizationModel organizationModel = new OrganizationModel();
				organizationModel.setId(Integer.parseInt(uid));
				branchModel.setOrganizationModel(organizationModel);
				model.put("categories", getcategories());
				model.put("branches", getBranches(branchModel));
				//model.put("msg", productEntryBean.getMsg());
				model.put("createdby",Integer.parseInt(uid));*/
			}else{

				productInventoryModel.setId(productInventoryBean.getId());
				productInventoryModel.setQuantity(productInventoryBean.getQuantity());
				int i=productService.upadteProductInventoryQuantity(productInventoryModel);
				if(i>0){
					model.put("msg", "Product Quantity Successfully Updated");
				}else{
					model.put("msg", "Some Problem: Upadate failed");
				}

			}
			session.setAttribute("msg", model.get("msg"));
			return new ModelAndView("redirect:/productEntryForm.html?task_type=sub&task_form_type=medical");



		}else{
			return new ModelAndView("error");
		}

	} 
	@RequestMapping(value = "/getProduct",
			method = RequestMethod.POST)
	public @ResponseBody ProductModel getProduct(HttpSession session,
			@RequestParam(value="pid") String productid,
			@RequestParam(value="flag") String flag)
					throws Exception {
		ProductModel productModel=new ProductModel();
		productModel.setId(Integer.parseInt(productid));
		productModel=productService.getProduct(productModel);


		return productModel;
	}

	@RequestMapping(value = "/getBatches",
			method = RequestMethod.POST)
	public @ResponseBody List<ProductInventoryBean> getProductBatches(HttpSession session,
			@RequestParam(value="pid") String productid,
			@RequestParam("bId") String shopid,
			@RequestParam(value="Qty") String quantity)
					throws Exception {
		productModel=new ProductModel();
		productInventoryModel=new ProductInventoryModel();
		branchModel=new BranchModel();
		productInventoryBeans=new ArrayList<ProductInventoryBean>();
		productInventoryModels=new ArrayList<ProductInventoryModel>();
		
		productModel.setId(Integer.parseInt(productid));
		branchModel.setId(Integer.parseInt(shopid));

		productInventoryModel.setQuantity(Integer.parseInt(quantity));
		productInventoryModel.setBranchModel(branchModel);
		productInventoryModel.setProductModel(productModel);
        
		productInventoryModels=productService.getProductBatches(productInventoryModel);
		productInventoryBeans=ProductInventoryBeanPreparation.prepareListofProductInventoryBean(productInventoryModels);


		return productInventoryBeans;
	}
	
	@RequestMapping(value = "/loadProductInventory", method = RequestMethod.POST)
	public @ResponseBody ProductInventoryBean getProductByBatchNo(
			@RequestParam(value="bNo") String InvId){
		productInventoryBean=new ProductInventoryBean();
		productInventoryModel=new ProductInventoryModel();
		productInventoryModel.setId(Integer.parseInt(InvId));
		productInventoryModel=productService.loadProductInventoryModel(productInventoryModel);
		productInventoryBean=ProductInventoryBeanPreparation.prepareProductInventoryBean(productInventoryModel);
				return productInventoryBean;
	}
	@RequestMapping(value = "/validateBatchNo", method = RequestMethod.POST)
	public @ResponseBody ProductInventoryBean getProductByBatchNo(
			@RequestParam(value="batchNo") String batchNo,
			@RequestParam(value="bId") String branchId,
			@RequestParam(value="type") String type,
			@RequestParam(value="aId") String agencyId)
					throws Exception {
		initializeProperties();
		productInventoryModel=new ProductInventoryModel();
		productModel=new ProductModel();
		categoryModel = new CategoryModel();
		branchModel = new BranchModel();
		subCategoryBean = new SubCategoryBean();
		agencyModel=new AgencyModel();

		categoryModel.setId(Integer.parseInt(type));
		productModel.setCategoryModel(categoryModel);
		agencyModel.setId(Integer.parseInt(agencyId));
		productInventoryModel.setBatchNo(batchNo);
		productInventoryModel.setProductModel(productModel);
		productInventoryModel.setAgencyModel(agencyModel);
		branchModel.setId(Integer.parseInt(branchId));
		productInventoryModel.setBranchModel(branchModel);

		ProductInventoryModel productInventoryModel1=productService.getProductInventoryModelByBatchNo(productInventoryModel);


		agencyBean = new AgencyBean();
		categoryBean = new CategoryBean();
		productBean = new ProductBean();
		productInventoryBean = new ProductInventoryBean();

		if(productInventoryModel1!=null){

			categoryBean.setCategory(productInventoryModel1.getProductModel().getCategoryModel().getCategory());
			categoryBean.setId(productInventoryModel1.getProductModel().getCategoryModel().getId());

			subCategoryBean.setId(productInventoryModel1.getProductModel().getSubCategoryModel().getId());
			subCategoryBean.setSubCategory(productInventoryModel1.getProductModel().getSubCategoryModel().getCategory());

			agencyBean.setAgencyName(productInventoryModel1.getAgencyModel().getAgencyName());
			agencyBean.setId(productInventoryModel1.getAgencyModel().getId());

			productBean.setName(productInventoryModel1.getProductModel().getName());
			productBean.setSchDrug(productInventoryModel1.getProductModel().getSchDrug());
			productBean.setmFCompanay(productInventoryModel1.getProductModel().getmFCompanay());
			productBean.setId(productInventoryModel1.getProductModel().getId());

			/*	    
			productInventoryBean.setAgencyBean(agencyBean);
			productInventoryBean.setProductBean(productBean);
		    productInventoryBean.setId(productInventoryModel1.getId());
		    productInventoryBean.setPrice(productInventoryModel1.getPrice());
		    productInventoryBean.setDlPrice(productInventoryModel1.getDlPrice());
		    productInventoryBean.setBatchNo(productInventoryModel1.getBatchNo());
		    productInventoryBean.setVat(productInventoryModel1.getVat());
		    productInventoryBean.setPwVat(productInventoryModel1.getPwVat());
			 */	    productInventoryBean.setMessage("Batch  existed in "+productInventoryModel1.getProductModel().getCategoryModel().getCategory()+" Products");

		}else{
			if(type.contentEquals(""+medical)){
				categoryModel.setId(general);
				productModel.setCategoryModel(categoryModel);
			}else if(type.contentEquals(""+general)){
				categoryModel.setId(medical);
				productModel.setCategoryModel(categoryModel);   
			}
			productInventoryModel.setProductModel(productModel);
			productInventoryModel1=productService.getProductInventoryModelByBatchNo(productInventoryModel);


			if(productInventoryModel1!=null){


				categoryBean.setCategory(productInventoryModel1.getProductModel().getCategoryModel().getCategory());
				categoryBean.setId(productInventoryModel1.getProductModel().getCategoryModel().getId());

				subCategoryBean.setId(productInventoryModel1.getProductModel().getSubCategoryModel().getId());
				subCategoryBean.setSubCategory(productInventoryModel1.getProductModel().getSubCategoryModel().getCategory());

				agencyBean.setAgencyName(productInventoryModel1.getAgencyModel().getAgencyName());
				agencyBean.setId(productInventoryModel1.getAgencyModel().getId());

				productBean.setName(productInventoryModel1.getProductModel().getName());
				productBean.setSchDrug(productInventoryModel1.getProductModel().getSchDrug());
				productBean.setmFCompanay(productInventoryModel1.getProductModel().getmFCompanay());
				productBean.setId(productInventoryModel1.getProductModel().getId());

				//productBean.setCategoryBean(AddressBeanPreparation.prepareCategoryBean(productInventoryModel1.getProductModel().getCategoryModel()));
				productBean.setCategoryBean(categoryBean);
				productInventoryBean.setProductBean(productBean);
				productInventoryBean.setMessage("Batch  existed in "+productInventoryModel1.getProductModel().getCategoryModel().getCategory()+" Products");
			}else{

				categoryBean.setId(Integer.parseInt(type));
				productBean.setCategoryBean(categoryBean);
				productInventoryBean.setProductBean(productBean);
				productInventoryBean.setMessage("Batch not existed in your inventory");
			}
		}

		productBean.setCategoryBean(categoryBean);
		productBean.setSubCategoryBean(subCategoryBean);
		productInventoryBean.setAgencyBean(agencyBean);
		productInventoryBean.setProductBean(productBean);
		if(productInventoryModel1!=null){
			productInventoryBean.setId(productInventoryModel1.getId());
			productInventoryBean.setPrice(productInventoryModel1.getPrice());
			productInventoryBean.setDlPrice(productInventoryModel1.getDlPrice());
			productInventoryBean.setBatchNo(productInventoryModel1.getBatchNo());
			productInventoryBean.setVat(productInventoryModel1.getVat());
			productInventoryBean.setPwVat(productInventoryModel1.getPwVat());
			productInventoryBean.setExpiryDate(productInventoryModel1.getExpiryDate()+"");
		}
		//  productInventoryBean.setMessage("Batch  existed in "+productInventoryModel1.getProductModel().getCategoryModel().getCategory()+" Products");


		System.out.println(productInventoryBean.getProductBean().getCategoryBean().getId());
		return productInventoryBean;
	}

	//@Value("${message.registrationerror}")
	// private String message;
	@RequestMapping(value ="/openBranchFrom", 
			method = RequestMethod.GET)
	public ModelAndView openBranch(HttpSession session,
			@RequestParam(value="uid") String uid,
			@ModelAttribute("command") 
	BranchRegistrationFormBean branchRegistrationFormBean, 
	BindingResult result)
	{

		int mode[]=SessionUtilities.validateSession(uid, session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){

			Map<String, Object> model = new HashMap<String, Object>();
			//    model.put("categories", getcategories());
			//    model.put("msg", productEntryBean.getMsg());
			model.put("createdby",Integer.parseInt(uid));
			model.put("shopname",mode[2]);
			model.put("initials",FormUtilities.getInitial());
			return new ModelAndView("openBranchRegisterForm",model);
		}else{
			return new ModelAndView("error");
		}



	}

	@RequestMapping(value = "/masterProductsList", method = RequestMethod.GET)
	public ModelAndView medicalProductsList(HttpSession session,
			@ModelAttribute("command") ProductBean productBean,	
			BindingResult result){
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){		
			model = new HashMap<String, Object>();
			productModel = new ProductModel();
			//	categoryModel = new CategoryModel();
			//	categoryModel.setId(Integer.parseInt(medical));

			//	productModel.setCategoryModel(categoryModel);

			model.put("createdRole", mode[1]);
			model.put("productCreatedBy", mode[2]);

			model.put("products", ProductBeanPreparation.prepareListofProductBean(productService.listProductsByCreator(productModel)));

			System.out.println("Product Controller>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			return new ModelAndView("masterProductsList",model);
		}else{
			return new ModelAndView("error");
		}		



	}

	@RequestMapping(value = "/productStockList", method = RequestMethod.GET)
	public ModelAndView productStockList(HttpSession session,
			@ModelAttribute("command") ProductInventoryBean productInventoryBean,	
			BindingResult result)
		//	@RequestParam("task_type") String task_type
	{
		initializeProperties();
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){		
			model = new HashMap<String, Object>();
			productInventoryModel = new ProductInventoryModel();
			organizationModel = new OrganizationModel();
			branchModel = new BranchModel();

			try {			

				if(mode[1]== outlet){			     
					branchModel.setId(userSessionBean.getBranchBean().getId());	
					productInventoryModel.setBranchModel(branchModel); 
					model.put("products",ProductInventoryBeanPreparation.prepareListofProductInventoryBean(productService.listProductsInventoryByOutlet(productInventoryModel)));

					model.put("createdRole", mode[1]);
					model.put("productCreatedBy", mode[2]);
				}else if(mode[1]== branch){
					branchModel.setId(mode[2]);
					productInventoryModel.setBranchModel(branchModel); 
					model.put("products",ProductInventoryBeanPreparation.prepareListofProductInventoryBean(productService.listProductsInventoryByBranch(productInventoryModel)));

					model.put("createdRole", mode[1]);
					model.put("productCreatedBy", mode[2]);
				}else{
					organizationModel.setId(mode[2]);
					branchModel.setOrganizationModel(organizationModel);
					productInventoryModel.setBranchModel(branchModel); 
					model.put("products",ProductInventoryBeanPreparation.prepareListofProductInventoryBean(productService.listProductsInventoryByOrganization(productInventoryModel)));

					model.put("createdRole", mode[1]);
					model.put("productCreatedBy", mode[2]);
				}
				productInventoryModel.setBranchModel(branchModel); 
				model.put("createdby",userSessionBean.getId());
				System.out.println("method called");
			} catch (Exception e) {

				e.printStackTrace();
			}
	//		if(task_type == "main"){
				
				return new ModelAndView("productsStockList",model);
	/*		}else if(task_type == "sub"){
				return new ModelAndView("productsStockListByBranch",model);
			}else{
		
			return new ModelAndView("productsStockListByOutlet",model);
			}*/
		}else{
			return new ModelAndView("error");
		}		



	}

	@RequestMapping(value = "/getProductInventory",
			method = RequestMethod.POST)
	public @ResponseBody ProductInventoryBean getProductInventory(HttpSession session,
			@ModelAttribute("command")
	ProductInventoryBean productInventoryBean,BindingResult result,
	@RequestParam(value="id") String productInventoryid)
			throws Exception {
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){		
			System.out.println("editProduct >>>>>>>>>>>>>>>>> ");
			productInventoryModel = new ProductInventoryModel();
			productInventoryModel.setId(Integer.parseInt(productInventoryid));

			productInventoryModel=productService.getProductInventory(productInventoryModel);
			
		}
		return ProductInventoryBeanPreparation.prepareProductInventoryBean(productInventoryModel);
	}

	@RequestMapping(value = "/updateProductInventoryByQuantity", method = RequestMethod.POST)
	public @ResponseBody int updateProductInventoryByQuantity(HttpSession session,
			@RequestParam(value="id") String id,
			@RequestParam(value="bid") String bid,
			@RequestParam(value="qty") String qty){
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		Integer i = 0;
		if(mode[0]==1){		
			model = new HashMap<String, Object>();
			productInventoryModel = new ProductInventoryModel();	
			creatorRoleModel = new RoleModel();
			branchModel = new BranchModel();
			productInventoryModel.setId(Integer.parseInt(id));
			productInventoryModel.setQuantity(Integer.parseInt(qty.trim()));
			creatorRoleModel.setId(mode[1]);			
			productInventoryModel.setCreatorRoleModel(creatorRoleModel);
			productInventoryModel.setCreatedBy(mode[2]);
			branchModel.setId(Integer.parseInt(bid));
			productInventoryModel.setBranchModel(branchModel);
			i=productService.updatePIQuantity(productInventoryModel);
			System.out.println("productInventoryModel****************"+i);
			
		}
		return i;		


	}

	List<ProductLogBean> productLogBeans=null;

	@RequestMapping(value = "/productLogList", method = RequestMethod.GET)
	public ModelAndView productLogList(HttpSession session,
			@ModelAttribute("command") ProductLogBean productLogBean, 
			BindingResult result){
		initializeProperties();
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){  
			model = new HashMap<String, Object>();
			productLogModel = new ProductLogModel();   
			organizationModel = new OrganizationModel();
			branchModel = new BranchModel();

			productLogBeans=new ArrayList<ProductLogBean>();
			try {   
				if(mode[1] == branch){
					branchModel.setId(mode[2]);
					productLogModel.setBranchModel(branchModel); 
					model.put("createdRole", mode[1]);
					model.put("productCreatedBy", mode[2]);
					productLogBeans=ProductLogBeanPreparation.prepareListofProductLogBean(productService.listProductsLogByBranch(productLogModel));


				}else if(mode[1] == organization){
					organizationModel.setId(mode[2]);
					branchModel.setOrganizationModel(organizationModel);
					productLogModel.setBranchModel(branchModel); 
					model.put("createdRole", mode[1]);
					model.put("productCreatedBy", mode[2]);
					
					productLogBeans=ProductLogBeanPreparation.prepareListofProductLogBean(productService.listProductsLogByOrganization(productLogModel));
				}

				for(ProductLogBean productLogBean2:productLogBeans){
					if(productLogBean2.getCreatorRoleBean().getId() == organization){
						organizationModel.setId(productLogBean2.getUpdater());
						organizationModel = organizationService.getOrganizationbyId(organizationModel);
						// organizationModel.setName(productLogBean2.getBranchBean().getOrganizationBean().getName());
						productLogBean2.setUpdaterName(organizationModel.getName());
					}else if(productLogBean2.getCreatorRoleBean().getId() == branch){
						branchModel.setId(productLogBean2.getUpdater());
						branchModel = branchService.getBranchbyId(branchModel);
						productLogBean2.setUpdaterName(branchModel.getName());

					}

				}
				model.put("outlet", outlet);
				model.put("productLogs", productLogBeans);    

			} catch (Exception e) {

				e.printStackTrace();
			}

			return new ModelAndView("ProductsLogList",model);
		}else{
			return new ModelAndView("error");
		}  



	}

	@RequestMapping(value = "/suppliersList", method = RequestMethod.GET)
	public ModelAndView suppliersList(HttpSession session,
			@ModelAttribute("command") ProductInventoryBean productInventoryBean,	
			BindingResult result){
		initializeProperties();
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){		
			model = new HashMap<String, Object>();
			productInventoryModel = new ProductInventoryModel();
			organizationModel = new OrganizationModel();
			branchModel = new BranchModel();

			try {		

				if(mode[1]== branch){
					branchModel.setId(mode[2]);
					productInventoryModel.setBranchModel(branchModel); 
					model.put("products",ProductInventoryBeanPreparation.prepareListofProductInventoryBean(productService.listProductsInventoryByBranch(productInventoryModel)));

					model.put("createdRole", mode[1]);
					model.put("productCreatedBy", mode[2]);
				}else if(mode[1]== organization){
					organizationModel.setId(mode[2]);
					branchModel.setOrganizationModel(organizationModel);
					productInventoryModel.setBranchModel(branchModel); 

					model.put("products",ProductInventoryBeanPreparation.prepareListofProductInventoryBean(productService.listProductsInventoryByOrganization(productInventoryModel)));

					model.put("createdRole", mode[1]);
					model.put("productCreatedBy", mode[2]);
				}					


			} catch (Exception e) {

				e.printStackTrace();
			}		
			return new ModelAndView("suppliersList",model);
		}else{
			return new ModelAndView("error");
		}		



	}

	List<ProductInventoryBean> productInventoryBeans=null;
	@RequestMapping(value = "/expiredProducts", method = RequestMethod.GET)
	public ModelAndView expiredProducts(HttpSession session,
			@ModelAttribute("command") ProductInventoryBean productInventoryBean,BindingResult result,
			@RequestParam(value="task_list_type") String task_list_type
			) throws ParseException{
		initializeProperties();
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){		
			model = new HashMap<String, Object>();
			productInventoryModel = new ProductInventoryModel();
			organizationModel = new OrganizationModel();
			branchModel = new BranchModel();
			productInventoryBeans = new ArrayList<ProductInventoryBean>();			
			productInventoryModel.setExpiryDate(DateAndTimeUtilities.getCurrentDateTimeInSqlFormat());
			try {		
				if(mode[1]== outlet){			     
					branchModel.setId(userSessionBean.getBranchBean().getId());	
					productInventoryModel.setBranchModel(branchModel); 
					productInventoryBeans = ProductInventoryBeanPreparation.prepareListofProductInventoryBean(productService.expiredProductsByOutlet(productInventoryModel));
					model.put("type", task_list_type);
					model.put("createdRole", mode[1]);
					model.put("productCreatedBy", mode[2]);
				}else if(mode[1]== branch){
					branchModel.setId(mode[2]);
					productInventoryModel.setBranchModel(branchModel); 
					productInventoryBeans = ProductInventoryBeanPreparation.prepareListofProductInventoryBean(productService.expiredProductsByBranch(productInventoryModel));

					model.put("type", task_list_type);
					model.put("createdRole", mode[1]);
					model.put("productCreatedBy", mode[2]);
				}else{
					organizationModel.setId(mode[2]);
					branchModel.setOrganizationModel(organizationModel);
					productInventoryModel.setBranchModel(branchModel); 
					productInventoryBeans = ProductInventoryBeanPreparation.prepareListofProductInventoryBean(productService.expiredProductsByOrganization(productInventoryModel));
					model.put("type", task_list_type);
					model.put("createdRole", mode[1]);
					model.put("productCreatedBy", mode[2]);
				}
				/*	String expiryDate = null;
				for(ProductInventoryBean productInventoryBean1 : productInventoryBeans){
					expiryDate =DateAndTimeUtilities.getCurrentDateTime();
					if(productInventoryBean1.getExpiryDate().compareTo(expiryDate)<0){			


					}

				}*/	
				model.put("expiredProducts",productInventoryBeans);

			} catch (Exception e) {

				e.printStackTrace();
			}	

			if(task_list_type.contentEquals("main")){
				return new ModelAndView("expiredProducts",model);
			}else{
				return new ModelAndView("expiredProductsNotification",model);
			}
		}else{
			return new ModelAndView("error");
		}  
	}

	List<ProductDamageBean> productDamageBeans=null;
	@RequestMapping(value = "/damagedProducts", method = RequestMethod.GET)
	public ModelAndView damagedProducts(HttpSession session,
			@ModelAttribute("command") ProductDamageBean productDamageBean,
			BindingResult result)throws ParseException{
		initializeProperties();
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){		
			model = new HashMap<String, Object>();
			productDamageModel = new ProductDamageModel();
			productInventoryModel = new ProductInventoryModel();
			organizationModel = new OrganizationModel();
			branchModel = new BranchModel();
			productDamageBeans = new ArrayList<ProductDamageBean>();			

			try {		
				if(mode[1]== outlet){			     
					branchModel.setId(userSessionBean.getBranchBean().getId());	
					productInventoryModel.setBranchModel(branchModel); 
					productDamageModel.setProductInventoryModel(productInventoryModel);
					productDamageBeans = ProductDamageBeanPreparation.prepareListOfProductDamageBean(productService.listProductsDamageByOutlet(productDamageModel));
					model.put("createdRole", mode[1]);
					model.put("productCreatedBy", mode[2]);
				}else if(mode[1]== branch){
					branchModel.setId(mode[2]);
					productInventoryModel.setBranchModel(branchModel); 
					productDamageModel.setProductInventoryModel(productInventoryModel);
					productDamageBeans = ProductDamageBeanPreparation.prepareListOfProductDamageBean(productService.listProductsDamageByBranch(productDamageModel));

					model.put("createdRole", mode[1]);
					model.put("productCreatedBy", mode[2]);
				}else{
					organizationModel.setId(mode[2]);
					branchModel.setOrganizationModel(organizationModel);
					productInventoryModel.setBranchModel(branchModel); 
					productDamageModel.setProductInventoryModel(productInventoryModel);
					productDamageBeans = ProductDamageBeanPreparation.prepareListOfProductDamageBean(productService.listProductsDamageByOrganization(productDamageModel));

					model.put("createdRole", mode[1]);
					model.put("productCreatedBy", mode[2]);
				}
				for(ProductDamageBean productDamageBean1:productDamageBeans){
					if(productDamageBean1.getCreatorRoleBean().getId() == organization){
						organizationModel.setId(productDamageBean1.getCreator());
						organizationModel = organizationService.getOrganizationbyId(organizationModel);
						// organizationModel.setName(productLogBean2.getBranchBean().getOrganizationBean().getName());
						productDamageBean1.setCreatorName(organizationModel.getName());
					}else if(productDamageBean1.getCreatorRoleBean().getId() == branch){
						branchModel.setId(productDamageBean1.getCreator());
						branchModel = branchService.getBranchbyId(branchModel);
						productDamageBean1.setCreatorName(branchModel.getName());

					}

				}

				model.put("productDamages",productDamageBeans);

			} catch (Exception e) {

				e.printStackTrace();
			}	


			return new ModelAndView("damageProducts",model);

		}else{
			return new ModelAndView("error");
		}  
	}

	List<ProductInventoryModel> productInventoryModels=null;
	@RequestMapping(value = "/expiryProducts", method = RequestMethod.GET)
	public ModelAndView expiryProducts(HttpSession session,
			@ModelAttribute("command") ProductInventoryBean productInventoryBean,
			BindingResult result)throws ParseException{
		initializeProperties();
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){		
			model = new HashMap<String, Object>();		
			productInventoryModel = new ProductInventoryModel();
			organizationModel = new OrganizationModel();
			branchModel = new BranchModel();
			creatorRoleModel = new RoleModel();
			creatorRoleModel.setId(mode[1]);
			productInventoryModel.setCreatorRoleModel(creatorRoleModel);			
			productInventoryModels = new ArrayList<ProductInventoryModel>();
			try {		
				if(mode[1]== outlet){			     
					branchModel.setId(userSessionBean.getBranchBean().getId());	
					productInventoryModel.setBranchModel(branchModel); 
					productInventoryModels =productService.listProductsGoingToExpireByOutlet(productInventoryModel);

				}else if(mode[1]== branch){
					branchModel.setId(mode[2]);
					productInventoryModel.setBranchModel(branchModel); 
					productInventoryModels = productService.listProductsGoingToExpireByBranch(productInventoryModel);


				}else{
					organizationModel.setId(mode[2]);
					branchModel.setOrganizationModel(organizationModel);
					productInventoryModel.setBranchModel(branchModel); 					
					productInventoryModels = productService.listProductsGoingToExpireByOrganization(productInventoryModel);

				}				

				model.put("productsOfNotification", ProductInventoryBeanPreparation.prepareListofProductInventoryBeanromExpairyProductInventoryModel(productInventoryModels));
			} catch (Exception e) {

				e.printStackTrace();
			}	


			return new ModelAndView("productNotifications",model);

		}else{
			return new ModelAndView("error");
		}  
	}
	@RequestMapping(value = "/lessQuantityProducts", method = RequestMethod.GET)
	public ModelAndView lessQuantityProducts(HttpSession session,
			@ModelAttribute("command") ProductInventoryBean productInventoryBean,
			BindingResult result)throws ParseException{
		initializeProperties();
		userSessionBean=SessionUtilities.giveMeSession(session);
		int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
		System.out.println("user session "+mode[0]+", user role "+mode[1]);
		if(mode[0]==1){		
			model = new HashMap<String, Object>();		
			productInventoryModel = new ProductInventoryModel();
			organizationModel = new OrganizationModel();
			branchModel = new BranchModel();
			//		creatorRoleModel = new RoleModel();
			//		creatorRoleModel.setId(mode[1]);
			//		productInventoryModel.setCreatorRoleModel(creatorRoleModel);			
			productInventoryModels = new ArrayList<ProductInventoryModel>();
			try {
				if(mode[1]== outlet){			     
					branchModel.setId(userSessionBean.getBranchBean().getId());	
					productInventoryModel.setBranchModel(branchModel); 
					productInventoryModels =productService.lessQuantityProductsByBranchOrOutlet(productInventoryModel);

				}else if(mode[1] == branch){			     
					branchModel.setId(mode[2]);	
					productInventoryModel.setBranchModel(branchModel); 
					productInventoryModels =productService.lessQuantityProductsByBranchOrOutlet(productInventoryModel);

				}else{
					organizationModel.setId(mode[2]);
					branchModel.setOrganizationModel(organizationModel);
					productInventoryModel.setBranchModel(branchModel); 					
					productInventoryModels = productService.lessQuantityProductsByOrganization(productInventoryModel);

				}				

				model.put("lessQuantityProducts", ProductInventoryBeanPreparation.prepareListofProductInventoryBean(productInventoryModels));
			} catch (Exception e) {

				e.printStackTrace();
			}	


			return new ModelAndView("lessQuantityProducts",model);

		}else{
			return new ModelAndView("error");
		}  
	}


	//**************product upload****************
		@RequestMapping(value="/productsUpload" , method= RequestMethod.GET)
		public ModelAndView uploadForm(HttpSession session,@ModelAttribute("command")FileBean uploadItem, BindingResult result){
			UserSessionBean userSessionBean=SessionUtilities.giveMeSession(session);
			int mode[]=SessionUtilities.validateSession(userSessionBean.getId()+"", session);
			if(mode[0]==1){

				model = new HashMap<String, Object>();
				if(mode[1]==branch){

					model.put("data", uploadItem);
					model.put("agencyId", 0);
					model.put("agency", "--Select Agency--");
					model.put("agencyList", getAgencies());
					model.put("createdby", userSessionBean.getId());
					return new ModelAndView("productsUploadByBranch",model);
				}else if(mode[1]==outlet){
					model.put("data", uploadItem);
					model.put("agencyId", 0);
					model.put("agency", "--Select Agency--");
					model.put("agencyList", getAgencies());
					model.put("createdby", userSessionBean.getId());
					return new ModelAndView("productsUploadByOutlet",model);
				}else{
					model.put("data", uploadItem);
					model.put("agencyId", 0);
					model.put("agency", "--Select Agency--");
					model.put("agencyList", getAgencies());
					model.put("createdby", 	userSessionBean.getId());
					return new ModelAndView("productsUploadByOrg",model);
				}
			}
			else{
				return new ModelAndView("error");
			}

		}

		@RequestMapping(value = "/upload", method = RequestMethod.POST)
		public ModelAndView upload(HttpSession session,@RequestParam(value="uid") String uid,@ModelAttribute("command")FileBean uploadItem, BindingResult result) {
			int mode[]=SessionUtilities.validateSession(uid, session);
			if(mode[0]==1){
				agencyModel=new AgencyModel();
				creatorRoleBean=new RoleBean();
				creatorRoleBean.setId(mode[1]);
				agencyModel.setId(uploadItem.getAgencyBean().getId());
				int createdby=Integer.parseInt(uid);
				int createrRole=creatorRoleBean.getId();
				FileDataModel fdm=new FileDataModel();
				fdm.setFileData(uploadItem.getFileData());
				fdm.setAgencyModel(agencyModel);
				//importProductsData(fdm);
				ByteArrayInputStream bis = new ByteArrayInputStream(FileDataModel.getFileData().getBytes());
				HSSFWorkbook workbook;
				try {
					if (fdm.getFileData().getOriginalFilename().endsWith("xls")) {
						workbook = new HSSFWorkbook(bis);
					} else if (fdm.getFileData().getOriginalFilename().endsWith("xlsx")) {
						workbook = new HSSFWorkbook(bis);
					} else {
						throw new IllegalArgumentException("Received file does not have a standard excel extension.");
					}
					HSSFSheet sheet = workbook.getSheetAt(0);

					list=new ArrayList<ProductModel>();
					Iterator<Row> rowIterator = sheet.iterator();
					while(rowIterator.hasNext()) {
						Row row = rowIterator.next();
						productModel=new ProductModel();

						//For each row, iterate through each columns
						Iterator<Cell> cellIterator = row.cellIterator();
						while(cellIterator.hasNext()) {

							Cell cell = cellIterator.next();
							if(cell.getColumnIndex()==0)
							{
								System.out.println("********product name***** "+cell.toString());
								productModel.setName(cell.toString());
							}else if(cell.getColumnIndex()==1)
							{
								productModel.setmFCompanay(cell.toString());
							}else if(cell.getColumnIndex()==2)
							{
								subCategoryModel=new SubCategoryModel();
								subCategoryModel.setCategory(cell.toString().toUpperCase());
								subCategoryModel.setId(properitesMap.getSubCategoryId(subCategoryModel.getCategory()));
								productModel.setSubCategoryModel(subCategoryModel);

							}else if(cell.getColumnIndex()==3)
							{
								productModel.setSchDrug(cell.toString());
							}
							else if(cell.getColumnIndex()==4)
							{
								categoryModel=new CategoryModel();
								categoryModel.setCategory(cell.toString());
								String catId=properitesMap.getCategoryId("category"+"."+""+categoryModel.getCategory())+"";
								categoryModel.setId(Integer.parseInt(catId));
								productModel.setCategoryModel(categoryModel);
							}

						}   list.add(productModel);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				agencyModel=new AgencyModel();
				agencyModel.setId(fdm.getAgencyModel().getId());
				productService.insertBulkProducts(list,agencyModel,createdby,createrRole);
				model=new HashMap<String, Object>();
				if(mode[1]==branch){
					model.put("message", "upload successfull");
					return new ModelAndView("productsUploadByBranch",model);
				}else if(mode[1]==outlet){
					model.put("message", "upload successfull");
					return new ModelAndView("productsUploadByOutlet",model);
				}else {
				model.put("message", "upload successfull");
				return new ModelAndView("productsUploadByOrg",model);
				}
			}
			else{
				return new ModelAndView("error");
			}
		}

		/*public void importProductsData(FileDataModel fileBean) {
				ByteArrayInputStream bis = new ByteArrayInputStream(FileDataModel.getFileData().getBytes());
				HSSFWorkbook workbook;
				try {
					if (fileBean.getFileData().getOriginalFilename().endsWith("xls")) {
						workbook = new HSSFWorkbook(bis);
					} else if (fileBean.getFileData().getOriginalFilename().endsWith("xlsx")) {
						workbook = new HSSFWorkbook(bis);
					} else {
						throw new IllegalArgumentException("Received file does not have a standard excel extension.");
					}

					HSSFSheet sheet = workbook.getSheetAt(0);

							list=new ArrayList<ProductModel>();
				            Iterator<Row> rowIterator = sheet.iterator();
				            while(rowIterator.hasNext()) {
				            	Row row = rowIterator.next();
				            	productModel=new ProductModel();

				            	//For each row, iterate through each columns
				            	Iterator<Cell> cellIterator = row.cellIterator();
				            	while(cellIterator.hasNext()) {

				            		Cell cell = cellIterator.next();
				            		if(cell.getColumnIndex()==0)
				            		{
				            			System.out.println("********product name***** "+cell.toString());
				            			productModel.setName(cell.toString());
				            		}else if(cell.getColumnIndex()==1)
				            		{
				            			productModel.setmFCompanay(cell.toString());
				            		}else if(cell.getColumnIndex()==2)
				            		{
				            			subCategoryModel=new SubCategoryModel();
				            			subCategoryModel.setCategory(cell.toString().toUpperCase());
				            			subCategoryModel.setId(properitesMap.getSubCategoryId(subCategoryModel.getCategory()));
				            			productModel.setSubCategoryModel(subCategoryModel);

				            		}else if(cell.getColumnIndex()==3)
				            		{
				            			productModel.setSchDrug(cell.toString());
				            		}
				            		else if(cell.getColumnIndex()==4)
				            		{
				            		 	categoryModel=new CategoryModel();
				            			categoryModel.setCategory(cell.toString());
				            			String catId=properitesMap.getCategoryId("category"+"."+""+categoryModel.getCategory())+"";
				            			categoryModel.setId(Integer.parseInt(catId));
				            			productModel.setCategoryModel(categoryModel);
				            		}

				            	}   list.add(productModel);
				            }
				} catch (IOException e) {
					e.printStackTrace();
				}
					agencyModel=new AgencyModel();
					agencyModel.setId(fileBean.getAgencyModel().getId());
				   // productService.insertBulkProducts(list,agencyModel);
			}*/


		public LinkedHashMap<Integer, String> getAgencies(){
			LinkedHashMap<Integer, String> agencies=new LinkedHashMap<Integer,String>();
			List<AgencyModel> list= productService.getAgencyList();
			for(int i=0; i<list.size(); i++){
				/*Object object[]=(Object[])list.get(i);
		            int aid=(int) object[0];
		            String aname=(String) object[1];
					agencies.put(aid, aname);*/
				int aid=list.get(i).getId();
				String aname=list.get(i).getAgencyName();
				System.out.println("****list.get(i).getId()****** "+aid);
				System.out.println("****list.get(i).getAgencyName()****** "+aname);
				agencies.put(aid, aname);
			}
			return agencies;
}
}