package com.relyits.rmbs.daoImpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.relyits.rmbs.dao.ProductDAO;
import com.relyits.rmbs.model.product.ProductDamageModel;
import com.relyits.rmbs.model.product.ProductInventoryModel;
import com.relyits.rmbs.model.product.ProductLogModel;
import com.relyits.rmbs.model.product.ProductModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.SubCategoryModel;
import com.relyits.rmbs.model.registration.AgencyModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.utilities.DateAndTimeUtilities;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<String> getAgenciesList(AgencyModel agencyModel) {
		Session session = sessionFactory.openSession();
		List<String> list=null;
		try{
			Criteria cr = session.createCriteria(AgencyModel.class,"agency")
					//  .createAlias("agency.resourceModel", "resource")
					.add(Restrictions.like("agencyName", agencyModel.getAgencyName(), MatchMode.ANYWHERE));
			//	.add(Restrictions.eq("resource.createdby",product.getShopid()));
			//               .setResultTransformer(Transformers
			//		        .aliasToBean(AgencyRegister.class));
			//	.setProjection(Projections.projectionList()
			//		    .add(Projections.property("agencyNme"), "agencyNme"))



			//  .add(Projections.property("aid"), "aid"));
			//  .setResultTransformer(Transformers
			//  		.aliasToBean(User.class));

			list = cr.list();
			/*  for(int i=0;i<list.size();i++){
					  System.out.println("*****List<String> list*****"+list.get(i));
					  }*/
			System.out.println("*****List<String> list*****"+list.size());
			session.close();
			return list;
		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
		}
		session.close();
		return list;
	}

	ProductModel productModel = null;
	CategoryModel categoryModel=null;
	SubCategoryModel subCategoryModel=null;
	RoleModel creatorRoleModel=null;
	AgencyModel agencyModel=null;
	BranchModel branchModel=null;

	public void addProduct(ProductInventoryModel productInventoryModel) {

		Session session = sessionFactory.openSession();
		Session session1 = sessionFactory.openSession();
		session.beginTransaction();


		Integer i=(Integer) session1.createSQLQuery("select max(RMBS20101) from rmbs.rmbs201").list().get(0);
		// System.out.println("**select max(RMBS20101) from rmbs.rmbs201   "+i.get(0));
		session1.close();

		productModel = new ProductModel();
		categoryModel = new CategoryModel();
		subCategoryModel = new SubCategoryModel();
		creatorRoleModel = new RoleModel();
		agencyModel = new AgencyModel();
		branchModel = new BranchModel();

		productModel = productInventoryModel.getProductModel();

		System.out.println("**productModel.getCategoryModel().getId()****"+productModel.getCategoryModel().getId());
		System.out.println("**productModel.getSubCategoryModel().getId()****"+productModel.getSubCategoryModel().getId());
		System.out.println("**productModel.getCreatorRoleModel().getId()****"+productModel.getCreatorRoleModel().getId());
		System.out.println("**productInventoryModel.getAgencyModel().getId()****"+productInventoryModel.getAgencyModel().getId());
		System.out.println("**productInventoryModel.getBranchModel().getId()****"+productInventoryModel.getBranchModel().getId());

		categoryModel=(CategoryModel) session.get(CategoryModel.class, productModel.getCategoryModel().getId());
		subCategoryModel=(SubCategoryModel) session.get(SubCategoryModel.class, productModel.getSubCategoryModel().getId());
		creatorRoleModel=(RoleModel) session.get(RoleModel.class, productModel.getCreatorRoleModel().getId());
		agencyModel=(AgencyModel) session.get(AgencyModel.class, productInventoryModel.getAgencyModel().getId());
		branchModel=(BranchModel) session.get(BranchModel.class, productInventoryModel.getBranchModel().getId());

		System.out.println("***************productModel categoryModel******************"+categoryModel.getId());

		//session.createQuery("select max(proj_id) from javaproj");


		if(productModel.getId()==null){
			String code=productModel.getName().substring(0, 3)+"/"
					+productModel.getmFCompanay().substring(0, 3)+"/"
					+productModel.getCategoryModel().getId()+"/"
					+productModel.getSubCategoryModel().getId()+"/"
					+(i+1);
			productModel.setCode(code);
			productModel.setCategoryModel(categoryModel);
			productModel.setAgencyModel(agencyModel);
			productModel.setSubCategoryModel(subCategoryModel);
			productModel.setCreatorRoleModel(creatorRoleModel);

			session.save(productModel);
		}
		productInventoryModel.setProductModel(productModel);
		productInventoryModel.setCreatorRoleModel(creatorRoleModel);
		productInventoryModel.setAgencyModel(agencyModel);
		productInventoryModel.setBranchModel(branchModel);

		session.save(productInventoryModel);
		session.getTransaction().commit();
	}


	@SuppressWarnings("unchecked")
	public List<String> getProductsList(ProductModel productModel) {
		Session session = sessionFactory.openSession();
		List<String> list=null;
		System.out.println("*****productModel*****"+productModel.getCategoryModel().getId());
		try{
			Criteria cr = session.createCriteria(ProductModel.class,"product")
					.createAlias("product.categoryModel", "category")
					.add(Restrictions.like("name", productModel.getName(), MatchMode.ANYWHERE))
					.add(Restrictions.eq("category.id",productModel.getCategoryModel().getId()));
			list = cr.list();
			System.out.println("*****list.size*****"+list.size());
			session.close();
			return list;
		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
		}
		session.close();
		return list;
	}

	public List<ProductModel> getInventroyProductsList(ProductInventoryModel productInventoryModel){
		Session session = sessionFactory.openSession();
		List<ProductModel> list=null;
	//	System.out.println("*****productModel*****"+productModel.getCategoryModel().getId());
		try{
			Criteria cr = session.createCriteria(ProductInventoryModel.class,"productInventory")
					.createAlias("productInventory.productModel", "product")
					.createAlias("productInventory.branchModel", "branch")
					.createAlias("product.categoryModel", "category")
					.setProjection(Projections.projectionList()
							   .add(Projections.property("product.id"), "id")
							   .add(Projections.property("product.name"), "name")
							  .add(Projections.property("product.subCategoryModel"), "subCategoryModel")
						//	   .add(Projections.property("product.subCategoryModel"),"subCategoryModel")
							   .add(Projections.groupProperty("product.name")))
					.add(Restrictions.eq("branch.id", productInventoryModel.getBranchModel().getId()))
					.add(Restrictions.like("product.name", productInventoryModel.getProductModel().getName(), MatchMode.ANYWHERE))
					.add(Restrictions.eq("category.id",productInventoryModel.getProductModel().getCategoryModel().getId()))
					.setResultTransformer(Transformers.aliasToBean(ProductModel.class));
			list = cr.list();
			System.out.println("*****list.size*****"+list.size());
			
			
			
		
			
			
			session.close();
			return list;
		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
		}
		session.close();
		return list;
	}


	public ProductModel getProduct(ProductModel productModel) {
		/*	List<Product> p=(List<Product>) sessionFactory.getCurrentSession().createSQLQuery("select * from Product p WHERE p.Product_Id = "+product.getPid()+";").addEntity(Product.class).list();
				Product product1 = null;
				for(int i=0;i<p.size();i++){
				product1=(Product)p.get(i);
				}
			//	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class);
			//	criteria.setFetchMode(arg0, arg1)

			  return product1;*/
		Session session = sessionFactory.openSession();
		return (ProductModel) session.get(ProductModel.class, productModel.getId());

	}
	public List<ProductInventoryModel> getProductBatches(ProductInventoryModel productInventoryModel) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProductInventoryModel.class,"productInventory")
						.createAlias("productInventory.productModel", "product")
						.createAlias("productInventory.branchModel", "branch")
						.add(Restrictions.eq("product.id",productInventoryModel.getProductModel().getId()))
						.add(Restrictions.eq("branch.id",productInventoryModel.getBranchModel().getId()))
		                .add(Restrictions.gt("productInventory.quantity",productInventoryModel.getQuantity()));
			

		
		
		List<ProductInventoryModel> productInventoryModels=criteria.list();
		session.close();
		return productInventoryModels;

	}

	@SuppressWarnings("rawtypes")
	public ProductInventoryModel getProductInventoryModelByBatchNo(ProductInventoryModel productInventoryModel) {
		ProductInventoryModel productInventoryModel1 = null;
		try {
			Session session = sessionFactory.openSession();
			//Query queryProducts = session.getNamedQuery("getProductDetailsByBatchNo");

			Criteria cr = session.createCriteria(ProductInventoryModel.class,"productInventory")
					.createAlias("productInventory.productModel", "product")
					.createAlias("productInventory.branchModel", "branch")
					.createAlias("product.categoryModel", "category")
					.createAlias("productInventory.agencyModel", "agency")
					.add(Restrictions.eq("productInventory.batchNo",productInventoryModel.getBatchNo()))
					.add(Restrictions.eq("category.id",productInventoryModel.getProductModel().getCategoryModel().getId()))
					.add(Restrictions.eq("branch.id",productInventoryModel.getBranchModel().getId()))
					.add(Restrictions.eq("agency.id",productInventoryModel.getAgencyModel().getId()))
					;


			List list = cr.list();
			System.out.println("products.size() "+list.size());

			for(int i=0;i<list.size();i++){
				productInventoryModel1=(ProductInventoryModel) list.get(i);
			}

		} catch (Exception e) {
			System.out.println(e);
		}



		return productInventoryModel1;
	}
	public ProductInventoryModel loadProductInventoryModel(ProductInventoryModel productInventoryModel){
		Session session=sessionFactory.openSession();
		ProductInventoryModel productInventoryModel1=new ProductInventoryModel();
		productInventoryModel1=(ProductInventoryModel) session.get(ProductInventoryModel.class, productInventoryModel.getId());
		session.close();
		return productInventoryModel1;
		
	}
	public int upadteProductInventoryQuantity(ProductInventoryModel productInventoryModel) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		int result=0;
		//try {
		Query query1=session.createSQLQuery("UPDATE rmbs.rmbs202 SET rmbs20202 = rmbs20202+"+productInventoryModel.getQuantity()
				+" where rmbs20201="+productInventoryModel.getId()+";");

		result=query1.executeUpdate();
		//} catch (Exception e) {
		//	session.cancelQuery();
		//}

		session.getTransaction().commit();
		session.close();
		return result;
	}



	@SuppressWarnings({ "unchecked" })
	public List<SubCategoryModel> getSubCategoryListByCategory(SubCategoryModel subCategoryModel){

		System.out.println("category.id>>>>>>>>>>>>>>>>>>>>>"+subCategoryModel.getCategoryModel().getId());
		Session session = sessionFactory.openSession();
		return (List<SubCategoryModel>) session.createCriteria(SubCategoryModel.class,"subCategory")
				.createAlias("subCategory.categoryModel", "category")												
				//.add(Restrictions.eq("category.id",subCategoryModel.getCategoryModel().getId()))
				.list();


	}	


	@SuppressWarnings("unchecked")
	public List<ProductModel> listProductsByCreator(ProductModel productModel) {
		System.out.println("*******DAOIMPL****listProductsByCreator****"+productModel.getId());
		//	try{
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(ProductModel.class);
		//	session.close();
		return criteria.list();
		//	}catch(Exception e){
		//     System.out.println("Exception"+e);

		//	return null;
		//	}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductInventoryModel> listProductsInventoryByOrganization(ProductInventoryModel productInventoryModel) {
		System.out.println("*******DAOIMPL****listProductsInventoryByCreator****"+productInventoryModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(ProductInventoryModel.class,"productInventory")				
					.createAlias("productInventory.branchModel", "branch")
					.createAlias("branch.organizationModel", "org")
					.add(Restrictions.eq("org.id",productInventoryModel.getBranchModel().getOrganizationModel().getId()));
			//  .add(Restrictions.eq("productInventory.createdBy",productInventoryModel.getCreatedBy()));

			
			List list = criteria.list();
			System.out.println("products.size() "+list.size());		

			return list;


		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductInventoryModel> listProductsInventoryByBranch(ProductInventoryModel productInventoryModel) {
		System.out.println("*******DAOIMPL****listProductsInventoryByCreator****"+productInventoryModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(ProductInventoryModel.class,"productInventory")				
					.createAlias("productInventory.branchModel", "branch")
					.add(Restrictions.eq("branch.id",productInventoryModel.getBranchModel().getId()));
			//  .add(Restrictions.eq("productInventory.createdBy",productInventoryModel.getCreatedBy()));

			
			List list = criteria.list();
			System.out.println("products.size() "+list.size());					

			return list;


		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}	
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductInventoryModel> listProductsInventoryByOutlet(ProductInventoryModel productInventoryModel) {
		System.out.println("*******DAOIMPL****listProductsInventoryByCreator****"+productInventoryModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(ProductInventoryModel.class,"productInventory")				
					.createAlias("productInventory.branchModel", "branch")
					.add(Restrictions.eq("branch.id",productInventoryModel.getBranchModel().getId()));
			//  .add(Restrictions.eq("productInventory.createdBy",productInventoryModel.getCreatedBy()));

			
			List list = criteria.list();
			System.out.println("products.size() "+list.size());					

			return list;


		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}			


	}
	@SuppressWarnings("rawtypes")
	public ProductInventoryModel getProductInventory(ProductInventoryModel productInventoryModel) {
		Session session = sessionFactory.openSession();
		if(productInventoryModel.getId()!=null){
			return (ProductInventoryModel) session.get(ProductInventoryModel.class, productInventoryModel.getId());
		}else{

			Criteria criteria = session.createCriteria(ProductInventoryModel.class,"productInventory")
					.createAlias("productInventory.productModel", "product")
					//	.createAlias("Resource.accountStatusModel", "AC_STATUS");
					.add(Restrictions.eq("productInventory.createdBy",productInventoryModel.getCreatedBy()))
					.add(Restrictions.eq("product.name",productInventoryModel.getProductModel().getName()))	;		        
			//	.add(Restrictions.eq("AC_STATUS.id",doctorModel.getResourceModel().getAccountStatusModel().getId()));
			//.add(Restrictions.ne("status", "I"));

			
			List products = criteria.list();
			System.out.println("**********criteria.list()*********"+criteria.list().size());
			ProductInventoryModel productInventoryModel1 = null;
			for(int i=0;i<products.size();i++){
				productInventoryModel1=(ProductInventoryModel) products.get(i);
			}

			return productInventoryModel1;
		}

	}

	public Integer updatePIQuantity(ProductInventoryModel productInventoryModel) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createSQLQuery(
				"CALL updateProductInventoryByQuantity(:pIId,:quantity,:userId,:userRole,:branchId)")
				.addEntity(ProductInventoryModel.class)
				.setParameter("pIId",productInventoryModel.getId())
				.setParameter("quantity", productInventoryModel.getQuantity())
				.setParameter("userId", productInventoryModel.getCreatedBy())
				.setParameter("userRole",productInventoryModel.getCreatorRoleModel().getId())
				.setParameter("branchId",productInventoryModel.getBranchModel().getId());
		int j=query.executeUpdate();
		/*	List result = query.list();
		ProductInventoryModel productInventoryModel2 = null;
		for(int i=0; i<result.size(); i++){
		productInventoryModel2 = (ProductInventoryModel)result.get(i);
			System.out.println("new Quantity "+productInventoryModel2.getQuantity());
		}
		 */
		System.out.println("******Update Quantity******"+j);
		session.getTransaction().commit();
		ProductInventoryModel productInventoryModel2 =(ProductInventoryModel) session.get(ProductInventoryModel.class, productInventoryModel.getId());
		return productInventoryModel2.getQuantity();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductLogModel> listProductsLogByBranch(ProductLogModel productLogModel) {
		System.out.println("*******DAOIMPL****listProductsLogByCreator****"+productLogModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(ProductLogModel.class,"productLog")				
					.createAlias("productLog.branchModel", "branch")
					.add(Restrictions.eq("branch.id",productLogModel.getBranchModel().getId()));
			//  .add(Restrictions.eq("productInventory.createdBy",productInventoryModel.getCreatedBy()));

			
			List list = criteria.list();
			System.out.println("products.size() "+list.size());					

			return list;


		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}	
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductLogModel> listProductsLogByOrganization(ProductLogModel productLogModel) {
		System.out.println("*******DAOIMPL****listProductsLogByCreator****"+productLogModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(ProductLogModel.class,"productLog")				
					.createAlias("productLog.branchModel", "branch")
					.createAlias("branch.organizationModel", "org")
					.add(Restrictions.eq("org.id",productLogModel.getBranchModel().getOrganizationModel().getId()));
			//  .add(Restrictions.eq("productInventory.createdBy",productInventoryModel.getCreatedBy()));

			
			List list = criteria.list();
			System.out.println("products.size() "+list.size());		

			return list;


		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductInventoryModel> expiredProductsByOrganization(ProductInventoryModel productInventoryModel) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(ProductInventoryModel.class,"productInventory")
				.createAlias("productInventory.branchModel", "branch")
				.createAlias("branch.organizationModel", "org")
				.add(Restrictions.eq("org.id",productInventoryModel.getBranchModel().getOrganizationModel().getId()))
				.add(Restrictions.lt("productInventory.expiryDate", productInventoryModel.getExpiryDate()));
		List list = criteria.list();
		System.out.println("products.size() "+list.size());
	/*	Query query = session.createSQLQuery(
				"CALL expiredProducts()");
			 
			List result = query.list();
			List<ProductInventoryModel> productInventoryModels = null;
			ProductInventoryModel productInventoryModel1=null;
			for(int i=0; i<result.size(); i++){
				productInventoryModel1=new ProductInventoryModel();
				Object object=(Object)result.get(i);
				productInventoryModel1=(ProductInventoryModel) object;
				 productInventoryModels.add(productInventoryModel1);
			
			}*/
			return list;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductInventoryModel> expiredProductsByBranch(ProductInventoryModel productInventoryModel) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(ProductInventoryModel.class,"productInventory")
				.createAlias("productInventory.branchModel", "branch")
				.add(Restrictions.eq("branch.id",productInventoryModel.getBranchModel().getId()))
				.add(Restrictions.lt("productInventory.expiryDate", productInventoryModel.getExpiryDate()));
		List list = criteria.list();
		System.out.println("products.size() "+list.size());
				return list;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductInventoryModel> expiredProductsByOutlet(ProductInventoryModel productInventoryModel) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(ProductInventoryModel.class,"productInventory")
				.createAlias("productInventory.branchModel", "branch")
				.add(Restrictions.eq("branch.id",productInventoryModel.getBranchModel().getId()))
				.add(Restrictions.lt("productInventory.expiryDate", productInventoryModel.getExpiryDate()));
		List list = criteria.list();
		System.out.println("products.size() "+list.size());
				return list;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductInventoryModel> listProductsGroupByOrganization(ProductInventoryModel productInventoryModel) {
		System.out.println("*******DAOIMPL****listProductsInventoryByCreator****"+productInventoryModel.getId());
		try{
			Session session = sessionFactory.openSession();
		/*	Criteria criteria = session.createCriteria(ProductInventoryModel.class,"productInventory")	
					.createAlias("productInventory.productModel", "product")
					.createAlias("productInventory.agencyModel", "agency")
					.createAlias("productInventory.branchModel", "branch")
					.createAlias("branch.organizationModel", "org")
					.add(Restrictions.eq("org.id",productInventoryModel.getBranchModel().getOrganizationModel().getId()))
					.setProjection( Projections.projectionList()
					 .add(Projections.property("product.id"))
					 .add(Projections.sum("productInventory.quantity"))
					 .add(Projections.property("agency.id"))
					.add(Projections.groupProperty("product.id")) );
		List<ProductInventoryModel> result = criteria.list();
				
				
			
			System.out.println("products.size() "+result.size());		*/
			
			
			List result = session.createCriteria(ProductInventoryModel.class, "productInventory")
					.createAlias("productInventory.productModel", "product")
					.createAlias("productInventory.agencyModel", "agency")
					.createAlias("productInventory.branchModel", "branch")
					.createAlias("branch.organizationModel", "org")
				    .setProjection( Projections.projectionList()				    	
				        .add( Projections.property("product.id"), "productInventoryModel.getProductModel().getId()" )
				        .add(Projections.groupProperty("product.id")))
				   .add( Restrictions.eq("org.id", productInventoryModel.getBranchModel().getOrganizationModel().getId()) )
				    .list();

			return result;


		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	
}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductDamageModel> listProductsDamageByOrganization(ProductDamageModel productDamageModel) {
		System.out.println("*******DAOIMPL****listProductsInventoryByCreator****"+productDamageModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(ProductDamageModel.class,"productDamage")
					.createAlias("productDamage.productInventoryModel", "productInventory")
					.createAlias("productInventory.branchModel", "branch")
					.createAlias("branch.organizationModel", "org")
					.add(Restrictions.eq("org.id",productDamageModel.getProductInventoryModel().getBranchModel().getOrganizationModel().getId()));
						
			List list = criteria.list();		
			return list;

		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductDamageModel> listProductsDamageByBranch(ProductDamageModel productDamageModel) {
		System.out.println("*******DAOIMPL****listProductsInventoryByCreator****"+productDamageModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(ProductDamageModel.class,"productDamage")
					.createAlias("productDamage.productInventoryModel", "productInventory")
					.createAlias("productInventory.branchModel", "branch")					
					.add(Restrictions.eq("branch.id",productDamageModel.getProductInventoryModel().getBranchModel().getId()));
						
			List list = criteria.list();		
			return list;

		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductDamageModel> listProductsDamageByOutlet(ProductDamageModel productDamageModel) {
		System.out.println("*******DAOIMPL****listProductsInventoryByCreator****"+productDamageModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(ProductDamageModel.class,"productDamage")
					.createAlias("productDamage.productInventoryModel", "productInventory")
					.createAlias("productInventory.branchModel", "branch")					
					.add(Restrictions.eq("branch.id",productDamageModel.getProductInventoryModel().getBranchModel().getId()));
						
			List list = criteria.list();		
			return list;

		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductInventoryModel> listProductsGoingToExpireByOrganization(ProductInventoryModel productInventoryModel) {
		System.out.println("*******DAOIMPL****listProductsInventoryByCreator****"+productInventoryModel.getId());
		try{
			Session session=sessionFactory.openSession();
			session.beginTransaction();		
		
			//"select * from rmbs202 rs where rs.rmbs20204>now() and rs.rmbs20204<now()+interval 3 month;"
		/*	List results = session.createCriteria(ProductInventoryModel.class,"productInventory")
				    .setProjection( Projections.rowCount() )
				    .createAlias("productInventory.productModel", "product")
				    .createAlias("productInventory.branchModel", "branch")
				    .createAlias("branch.organizationModel", "org")
				    .add( Restrictions.eq("org.id", productInventoryModel.getBranchModel().getOrganizationModel().getId()) )
				     .add( Restrictions.eq("product.name", productInventoryModel.getProductModel().getName()) )
				      .add( Restrictions.eq("productInventory.expiryDate", productInventoryModel.getExpiryDate()) )
				    .add( Expression.and(Expression.gt("productInventory.expiryDate", DateAndTimeUtilities.getCurrentDateTimeInSqlFormat()),Expression.lt("productInventory.expiryDate", DateAndTimeUtilities.getCurrentDateTimeInSqlFormat())))
				    .setResultTransformer(Transformers.aliasToBean(ProductInventoryModel.class))
				    .list();		
			 Calendar now = Calendar.getInstance();
		   now.add(Calendar.DATE, 90);
			Criteria criteria = session.createCriteria(ProductInventoryModel.class,"productInventory")
					.createAlias("productInventory.branchModel", "branch")
					.createAlias("branch.organizationModel", "org")
					.add(Restrictions.eq("org.id",productInventoryModel.getBranchModel().getOrganizationModel().getId()))
					.add(Expression.lt("productInventory.expiryDate", now.getTime()))
				//	.add(Restrictions.lt("productInventory.expiryDate", now.getTime()))
					;
			List list = criteria.list();
			System.out.println("List Size***************"+list.size());
			session.getTransaction().commit();
			session.close();*/		
	/*		String productNotification = "{CALL productNotifications(?,?)}";
					callableStatement = dbConnection.prepareCall(productNotification);
					callableStatement.setInt(1, productInventoryModel.getBranchModel().getId());
					callableStatement.setInt(2, productInventoryModel.getCreatorRoleModel().getId());
					 
			callableStatement.executeQuery();
			rs = (ResultSet) callableStatement.getObject(2);	 
			while (rs.next()) {
				String name = rs.getString(productInventoryModel.getProductModel().getName());				
			}
			
			*/
			Query query = session.createSQLQuery(
					"CALL productNotifications(:id,:role)")
					.addEntity(ProductInventoryModel.class)
					.setParameter("id",productInventoryModel.getBranchModel().getOrganizationModel().getId())
					.setParameter("role",productInventoryModel.getCreatorRoleModel().getId());
			List list = query.list();
						
			session.getTransaction().commit();
			session.close();
			return list;
			
			}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductInventoryModel> listProductsGoingToExpireByBranch(ProductInventoryModel productInventoryModel) {
		System.out.println("*******DAOIMPL****listProductsInventoryByCreator****"+productInventoryModel.getId());
		try{
			Session session=sessionFactory.openSession();
			session.beginTransaction();			
			Query query = session.createSQLQuery(
					"CALL productNotifications(:id,:role)")
					.addEntity(ProductInventoryModel.class)
					.setParameter("id",productInventoryModel.getBranchModel().getId())
					.setParameter("role",productInventoryModel.getCreatorRoleModel().getId())
					;
			List list = query.list();
			session.getTransaction().commit();
			session.close();
			return list;
		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductInventoryModel> listProductsGoingToExpireByOutlet(ProductInventoryModel productInventoryModel) {
		System.out.println("*******DAOIMPL****listProductsInventoryByCreator****"+productInventoryModel.getId());
		try{
			Session session=sessionFactory.openSession();
			session.beginTransaction();			
			Query query = session.createSQLQuery(
					"CALL productNotifications(:id,:role)")
					.addEntity(ProductInventoryModel.class)
					.setParameter("id",productInventoryModel.getBranchModel().getId())
					.setParameter("role",productInventoryModel.getCreatorRoleModel().getId())
					;
			List list = query.list();
			session.getTransaction().commit();
			session.close();
			return list;
		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductInventoryModel> lessQuantityProductsByOrganization(ProductInventoryModel productInventoryModel) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(ProductInventoryModel.class,"productInventory")
				.createAlias("productInventory.branchModel", "branch")
				.createAlias("branch.organizationModel", "org")
				.add(Restrictions.eq("org.id",productInventoryModel.getBranchModel().getOrganizationModel().getId()))
				.add(Restrictions.lt("productInventory.quantity", 20));
		List list = criteria.list();
		System.out.println("products.size() "+list.size());
	
			return list;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ProductInventoryModel> lessQuantityProductsByBranchOrOutlet(ProductInventoryModel productInventoryModel) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(ProductInventoryModel.class,"productInventory")
				.createAlias("productInventory.branchModel", "branch")
				.add(Restrictions.eq("branch.id",productInventoryModel.getBranchModel().getId()))
				.add(Restrictions.lt("productInventory.quantity", 20));
		List list = criteria.list();
		System.out.println("products.size() "+list.size());
	
			return list;
	}
public ArrayList<ProductModel> productAvailabilityCheck(int agencyId,String productName,int subCat){
		
		Session session=sessionFactory.openSession();
		Criteria criteria=session.createCriteria(ProductModel.class,"productModel")
									.createAlias("productModel.agencyModel", "agency")
									.createAlias("productModel.subCategoryModel", "sucCatModel")
									.add(Restrictions.eq("agency.id", agencyId))
									.add(Restrictions.eq("name", productName))
									.add(Restrictions.eq("sucCatModel.id", subCat));
		System.out.println("criteria calling"+criteria);
		List list=criteria.list();
		System.out.println("*****list size ***** "+list.size());
		
		return (ArrayList<ProductModel>) list;
		}

	public void insertBulkProducts(List<ProductModel> proBulklist,AgencyModel agencyModel1,int createdby,int createrRole) {
		// TODO Auto-generated method stub
		productModel = new ProductModel();
		categoryModel = new CategoryModel();
		subCategoryModel = new SubCategoryModel();
		creatorRoleModel = new RoleModel();
		agencyModel = new AgencyModel();
		
		Session session1 = sessionFactory.openSession();
		Session session = sessionFactory.openSession();
		session1.beginTransaction();
		int j=0;
		try{
			List list=(List)session1.createSQLQuery("select max(RMBS20101) from rmbs.rmbs201").list();
			j=(Integer)list.get(j);
		}
		catch(Exception e){

		}session1.close();
		session.beginTransaction();
		for (int i =0;i<proBulklist.size();i++)
		{
			productModel.setName(proBulklist.get(i).getName());
			productModel.setmFCompanay(proBulklist.get(i).getmFCompanay());
			productModel.setSchDrug(proBulklist.get(i).getSchDrug());
			subCategoryModel.setId(proBulklist.get(i).getSubCategoryModel().getId());
			productModel.setSubCategoryModel(subCategoryModel);
			categoryModel.setId(proBulklist.get(i).getCategoryModel().getId());
			productModel.setCategoryModel(categoryModel);
			System.out.println("*****subcat id ** "+subCategoryModel.getId());
			System.out.println("*****cat id ** "+categoryModel.getId());
			agencyModel.setId(agencyModel1.getId());
			productModel.setAgencyModel(agencyModel);
			try {
				productModel.setCreatedDate(DateAndTimeUtilities.parseStringDateToSqlDate(DateAndTimeUtilities.getCurrentDateTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			productModel.setCreatedBy(createdby);
			creatorRoleModel.setId(createrRole);
			productModel.setCreatorRoleModel(creatorRoleModel);
			String code=productModel.getName().substring(0, 3)+"/"
					+productModel.getmFCompanay().substring(0, 3)+"/"
					+productModel.getCategoryModel().getId()+"/"
					+productModel.getSubCategoryModel().getId()+"/"
					+(j+1);
			productModel.setCode(code);
			
			List li=productAvailabilityCheck(agencyModel.getId(), proBulklist.get(i).getName(), subCategoryModel.getId());
			if(li.size()!=0){
				
				throw new IllegalArgumentException("Received file does not have a standard excel extension.");
			}
			else{
				session.save(productModel);
				j=productModel.getId();
			}
			if (i%1 == 0)
			{
				session.flush();
				session.clear();
			}
		}
		//if(session.getTransaction().wasCommitted())
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public ArrayList<AgencyModel> getAgencyList() {
		Session session=sessionFactory.openSession();
		
		Criteria cr = session.createCriteria(AgencyModel.class)
				.add(Restrictions.gt("id", 0));
			    /*.setProjection(Projections.projectionList()
			      .add(Projections.property("id"), "id")
			      .add(Projections.property("agencyName"), "agencyName"));
			   // .setResultTransformer(Transformers.aliasToBean(User.class));*/

		return (ArrayList<AgencyModel>) cr.list();
	}
}