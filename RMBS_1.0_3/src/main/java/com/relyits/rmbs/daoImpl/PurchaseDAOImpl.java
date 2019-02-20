package com.relyits.rmbs.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.relyits.rmbs.dao.PurchaseDAO;
import com.relyits.rmbs.model.product.ProductInventoryModel;
import com.relyits.rmbs.model.product.ProductModel;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.SubCategoryModel;
import com.relyits.rmbs.model.registration.AgencyModel;
import com.relyits.rmbs.model.registration.BranchModel;


@Repository("purchaseDAO")
public class PurchaseDAOImpl implements PurchaseDAO{

	@Autowired
	private SessionFactory sessionFactory;
	PurchaseLineItemsModel purchaseLineItemsModel=null;
	PurchaseOrderModel purchaseOrderModel=null;

	ProductModel productModel = null;
	ProductInventoryModel productInventoryModel=null;
	CategoryModel categoryModel=null;
	SubCategoryModel subCategoryModel=null;
	RoleModel creatorRoleModel=null;
	AgencyModel agencyModel=null;
	BranchModel branchModel=null;

	public int createPurchaseOrder(List<PurchaseLineItemsModel> purchaseLineItemsModels){
		int count=0;
		int returnval=0;
		if(purchaseLineItemsModels!=null){

			int i=0;
			int j=0;
			int k=0;
			Session session=sessionFactory.openSession();
			session.beginTransaction();

			try{
				j=(Integer) session.createSQLQuery("select max(RMBS40101) from rmbs.rmbs401").list().get(i);
			}catch(Exception e){

			}


			//	try {

			System.out.println("branch>>>>>>>>>>>>>>>>>"+purchaseLineItemsModels.get(i).getPurchaseOrderModel().getBranchModel().getId());
			purchaseOrderModel=purchaseLineItemsModels.get(i).getPurchaseOrderModel();


		//	if(purchaseLineItemsModels.get(i).getProductInventoryModel().getId()!=null){
				productInventoryModel=new ProductInventoryModel();
				agencyModel=new AgencyModel();
				agencyModel=(AgencyModel)session.get(AgencyModel.class, purchaseLineItemsModels.get(i).getProductInventoryModel().getAgencyModel().getId());
				purchaseOrderModel.setAgencyModel(agencyModel);
				

		//	}

			String oIdByDt="PO"+purchaseOrderModel.getOrderIdbyDate().replaceAll("-", "")+"/"
					+purchaseOrderModel.getBranchModel().getId()+"/"
					+purchaseOrderModel.getAgencyModel().getId()+"/"
					+(j+1);
			//  purchaseOrderModel.setAgencyModel((AgencyModel)hSession.get(AgencyModel.class, purchaseLineItemsModels.get(i).getPurchaseOrderModel().getAgencyModel().getId()));
			purchaseOrderModel.setOrderIdByDate(oIdByDt);
			purchaseOrderModel.setAgencyModel((AgencyModel)session.get(AgencyModel.class, 1));
			purchaseOrderModel.setBranchModel((BranchModel)session.get(BranchModel.class, purchaseLineItemsModels.get(i).getPurchaseOrderModel().getBranchModel().getId()));
			session.save(purchaseOrderModel);
			returnval=purchaseOrderModel.getId();
			if(purchaseOrderModel.getId()!=null){
				for(i=0;i<purchaseLineItemsModels.size();i++){
					purchaseLineItemsModel=new PurchaseLineItemsModel();
					purchaseLineItemsModel=purchaseLineItemsModels.get(i);
					if(purchaseLineItemsModel!=null || !purchaseLineItemsModel.equals(null)){

						productModel = new ProductModel();
						productInventoryModel= new ProductInventoryModel();
						categoryModel = new CategoryModel();
						subCategoryModel = new SubCategoryModel();
						creatorRoleModel = new RoleModel();
						
						branchModel = new BranchModel();

						productInventoryModel=purchaseLineItemsModel.getProductInventoryModel();

						productModel = productInventoryModel.getProductModel();

					

						////////////////////////////////////////////
						if(productInventoryModel.getId()==null ){//validating in inventory

							if(productModel.getId()==null){//validating in products

								//	Session session1 = sessionFactory.openSession();
								//	session.beginTransaction();
								if(i==0){
									try{
										k=(Integer) session.createSQLQuery("select max(RMBS20101) from rmbs.rmbs201").list().get(i);

									}catch(Exception e){

									}
								}
								// System.out.println("**select max(RMBS20101) from rmbs.rmbs201   "+i.get(0));
								//	session1.close();

								System.out.println("**productModel.getCategoryModel().getId()****"+productModel.getCategoryModel().getId());
								System.out.println("**productModel.getSubCategoryModel().getId()****"+productModel.getSubCategoryModel().getId());
								System.out.println("**productModel.getCreatorRoleModel().getId()****"+productModel.getCreatorRoleModel().getId());
								//System.out.println("**productInventoryModel.getAgencyModel().getId()****"+productInventoryModel.getAgencyModel().getId());
								System.out.println("**productInventoryModel.getBranchModel().getId()****"+productInventoryModel.getBranchModel().getId());

								categoryModel=(CategoryModel) session.get(CategoryModel.class, productModel.getCategoryModel().getId());
								subCategoryModel=(SubCategoryModel) session.get(SubCategoryModel.class, productModel.getSubCategoryModel().getId());
								creatorRoleModel=(RoleModel) session.get(RoleModel.class, productModel.getCreatorRoleModel().getId());
							//	agencyModel=(AgencyModel) session.get(AgencyModel.class, 1/*productInventoryModel.getAgencyModel().getId()*/);
								branchModel=(BranchModel) session.get(BranchModel.class, productInventoryModel.getBranchModel().getId());

								System.out.println("***************productModel categoryModel******************"+categoryModel.getId());

								//session.createQuery("select max(proj_id) from javaproj");


								//	if(productModel.getId()==null){
								String pCode=productModel.getName().substring(0, 3)+"/"
										+productModel.getmFCompanay().substring(0, 3)+"/"
										+productModel.getCategoryModel().getId()+"/"
										+productModel.getSubCategoryModel().getId()+"/"
										+(k+1);
								productModel.setCode(pCode);
								productModel.setCategoryModel(categoryModel);
								productModel.setAgencyModel(agencyModel);
								productModel.setSubCategoryModel(subCategoryModel);
								productModel.setCreatorRoleModel(creatorRoleModel);
						
								session.save(productModel);
								k=productModel.getId();
								//	}.
								productInventoryModel.setProductModel(productModel);
								productInventoryModel.setCreatorRoleModel(creatorRoleModel);
								productInventoryModel.setAgencyModel(purchaseOrderModel.getAgencyModel());
								productInventoryModel.setBranchModel(purchaseOrderModel.getBranchModel());

								session.save(productInventoryModel);

								purchaseLineItemsModel.setPurchaseOrderModel(purchaseOrderModel);
								purchaseLineItemsModel.setProductInventoryModel(productInventoryModel);

								session.save(purchaseLineItemsModel);

								//	session.getTransaction().commit();
								//session.close();

							}else{

								productModel=(ProductModel) session.get(ProductModel.class, productModel.getId());
								creatorRoleModel=(RoleModel) session.get(RoleModel.class, productModel.getCreatorRoleModel().getId());
								productInventoryModel.setProductModel(productModel);
								productInventoryModel.setCreatorRoleModel(creatorRoleModel);
								productInventoryModel.setAgencyModel(purchaseOrderModel.getAgencyModel());
								productInventoryModel.setBranchModel(purchaseOrderModel.getBranchModel());
				
								session.save(productInventoryModel);

								purchaseLineItemsModel.setPurchaseOrderModel(purchaseOrderModel);
								purchaseLineItemsModel.setProductInventoryModel(productInventoryModel);

								session.save(purchaseLineItemsModel);

								//	session.getTransaction().commit();
								//	session.close();
							}
						}else{
							//session = sessionFactory.openSession();
							//session.beginTransaction();

							Query query = session.createSQLQuery(
									"CALL updateProductInventoryByQuantity(:pIId,:quantity,:userId,:userRole,:branchId)")
									.addEntity(ProductInventoryModel.class)
									.setParameter("pIId",productInventoryModel.getId())
									.setParameter("quantity", productInventoryModel.getQuantity())
									.setParameter("userId", productInventoryModel.getCreatedBy())
									.setParameter("userRole",productInventoryModel.getCreatorRoleModel().getId())
									.setParameter("branchId",productInventoryModel.getBranchModel().getId());
							int l=query.executeUpdate();
							if(l!=0){
								productInventoryModel=(ProductInventoryModel) session.get(ProductInventoryModel.class, productInventoryModel.getId());
								purchaseLineItemsModel.setPurchaseOrderModel(purchaseOrderModel);
								purchaseLineItemsModel.setProductInventoryModel(productInventoryModel);

								session.save(purchaseLineItemsModel);

								//	session.getTransaction().commit();
								//	session.close();
							}

						}
						/////////////////////////////////////////////

					}

					if(purchaseLineItemsModels.size()!=i+1){
						session.getTransaction().commit();
						count++;
						session.beginTransaction();
					}else{
						session.getTransaction().commit();
						count++;
						session.close();
					}

				}


			}



			//	} catch (Exception e) {
			//	session.cancelQuery();
			//}


		}

		return returnval;

	}

	@Override
	public List<PurchaseLineItemsModel> getPurchaseLineItemsModelsByPurcheseOrderModel(
			PurchaseOrderModel purchaseOrderModel) {
		Session session=sessionFactory.openSession();
		Criteria cr = session.createCriteria(PurchaseLineItemsModel.class,"POLI")
				.createAlias("POLI.purchaseOrderModel", "PO")
				.add(Restrictions.eq("PO.id", purchaseOrderModel.getId()));
		return cr.list();
	}

	@SuppressWarnings("unchecked")
	public List<PurchaseOrderModel> purchaseOrderListByOrganization(PurchaseOrderModel purchaseOrderModel) {
		System.out.println("*******DAOIMPL****listpurchaseOrderModelByCreator****"+purchaseOrderModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(PurchaseOrderModel.class,"purchaseOrder")				
					.createAlias("purchaseOrder.branchModel", "branch")
					.createAlias("branch.organizationModel", "org")
					.add(Restrictions.eq("org.id",purchaseOrderModel.getBranchModel().getOrganizationModel().getId()));
			//  .add(Restrictions.eq("productInventory.createdBy",productInventoryModel.getCreatedBy()));

			List list = criteria.list();
			System.out.println("products.size() "+list.size());		

			return list;


		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PurchaseOrderModel> purchaseOrderListByBranch(PurchaseOrderModel purchaseOrderModel) {
		System.out.println("*******DAOIMPL****listpurchaseOrderModelByCreator****"+purchaseOrderModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(PurchaseOrderModel.class,"purchaseOrder")				
					.createAlias("purchaseOrder.branchModel", "branch")
					.add(Restrictions.eq("branch.id",purchaseOrderModel.getBranchModel().getId()));
			//  .add(Restrictions.eq("productInventory.createdBy",productInventoryModel.getCreatedBy()));

			List list = criteria.list();
			System.out.println("products.size() "+list.size());		

			return list;


		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PurchaseOrderModel> purchaseOrderListByOutlet(PurchaseOrderModel purchaseOrderModel) {
		System.out.println("*******DAOIMPL****listpurchaseOrderModelByCreator****"+purchaseOrderModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(PurchaseOrderModel.class,"purchaseOrder")				
					.createAlias("purchaseOrder.branchModel", "branch")
					.add(Restrictions.eq("branch.id",purchaseOrderModel.getBranchModel().getId()));
			//  .add(Restrictions.eq("productInventory.createdBy",productInventoryModel.getCreatedBy()));

			List list = criteria.list();
			System.out.println("products.size() "+list.size());		

			return list;


		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PurchaseLineItemsModel> getPurchaseLineItems(PurchaseLineItemsModel purchaseLineItemsModel) {
		Session session = sessionFactory.openSession();
		try{
			Criteria criteria = session.createCriteria(PurchaseLineItemsModel.class,"purchaseLineItems")
					.createAlias("purchaseLineItems.purchaseOrderModel", "purchaseOrder")
					.add(Restrictions.eq("purchaseOrder.id",purchaseLineItemsModel.getPurchaseOrderModel().getId()));		        

			List purchaseLineItems = criteria.list();
			System.out.println("**********criteria.list()*********"+purchaseLineItems.size());
			/*	PurchaseLineItemsModel purchaseLineItemsModel1 = null;
			for(int i=0;i<purchaseLineItems.size();i++){
				purchaseLineItemsModel1=(PurchaseLineItemsModel) purchaseLineItems.get(i);
			}
			 */
			return purchaseLineItems;
		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}


	}

	@SuppressWarnings("unchecked")
	public List<PurchaseLineItemsModel> purchaseLineItemsListByOrganization(PurchaseLineItemsModel purchaseLineItemsModel) {
		System.out.println("*******DAOIMPL****listPurchaseLineItemsModelByOrganization****"+purchaseLineItemsModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(PurchaseLineItemsModel.class,"purchaseLineItems")	
					.createAlias("purchaseLineItems.purchaseOrderModel", "purchaseOrder")
					.createAlias("purchaseOrder.branchModel", "branch")
					.createAlias("branch.organizationModel", "org")
					.add(Restrictions.eq("org.id",purchaseLineItemsModel.getPurchaseOrderModel().getBranchModel().getOrganizationModel().getId()));

			List list = criteria.list();
			System.out.println("LineItems.size() "+list.size());		

			return list;


		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<PurchaseLineItemsModel> purchaseLineItemsListByBranch(PurchaseLineItemsModel purchaseLineItemsModel) {
		System.out.println("*******DAOIMPL****listPurchaseLineItemsModelByBranch****"+purchaseLineItemsModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(PurchaseLineItemsModel.class,"purchaseLineItems")	
					.createAlias("purchaseLineItems.purchaseOrderModel", "purchaseOrder")
					.createAlias("purchaseOrder.branchModel", "branch")
					.add(Restrictions.eq("branch.id",purchaseLineItemsModel.getPurchaseOrderModel().getBranchModel().getId()));

			List list = criteria.list();
			System.out.println("LineItems.size() "+list.size());		

			return list;


		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	public List<PurchaseLineItemsModel> purchaseLineItemsListByOutlet(PurchaseLineItemsModel purchaseLineItemsModel) {
		System.out.println("*******DAOIMPL****listPurchaseLineItemsModelByOutlet****"+purchaseLineItemsModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(PurchaseLineItemsModel.class,"purchaseLineItems")	
					.createAlias("purchaseLineItems.purchaseOrderModel", "purchaseOrder")
					.createAlias("purchaseOrder.branchModel", "branch")
					.add(Restrictions.eq("branch.id",purchaseLineItemsModel.getPurchaseOrderModel().getBranchModel().getId()));

			List list = criteria.list();
			System.out.println("LineItems.size() "+list.size());		

			return list;


		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	}

//	**************purchase returns stuff*******************
	
	public List<String> getPurchaseInvoiceNo(PurchaseOrderModel purchaseOrderModel){
		
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(PurchaseOrderModel.class , "purchaseModel")
//				.setProjection(Projections.projectionList()
//						.add(Projections.property("purchaseModel.invoiceNo"),"invoiceNo"))
//						.setResultTransformer(Transformers.aliasToBean(PurchaseOrderModel.class))
				.add(Restrictions.like("invoiceNo", purchaseOrderModel.getInvoiceNo(),MatchMode.ANYWHERE));
		@SuppressWarnings("unchecked")
		List<String> list = criteria.list();
		return list;
	}
}
