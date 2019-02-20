package com.relyits.rmbs.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.ejb.HibernateEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Repository;

import com.relyits.rmbs.dao.PurchaseDAO;
import com.relyits.rmbs.dao.SalesDAO;
import com.relyits.rmbs.model.product.ProductInventoryModel;
import com.relyits.rmbs.model.product.ProductModel;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.model.refference.CategoryModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.SubCategoryModel;
import com.relyits.rmbs.model.registration.AgencyModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.sales.SalesLineItemsModel;
import com.relyits.rmbs.model.sales.SalesOrderModel;


@Repository("salesDAO")
public class SalesDAOImpl implements SalesDAO{

	@Autowired
	private SessionFactory sessionFactory;
	private SalesLineItemsModel salesLineItemsModel=null;
	private SalesOrderModel salesOrderModel=null;
	private ProductModel productModel = null;
	private ProductInventoryModel productInventoryModel=null;
	private CategoryModel categoryModel=null;
	private SubCategoryModel subCategoryModel=null;
	private RoleModel creatorRoleModel=null;
	private AgencyModel agencyModel=null;
	private BranchModel branchModel=null;
	private List<SalesLineItemsModel> salesLineItemsModels=null;
	
	public SalesLineItemsModel createSalesOrder(SalesLineItemsModel salesLineItemsModel1) {
		Session session=sessionFactory.openSession();
		int i=0;
	/*	try{
			i=(int) session.createSQLQuery("select max(RMBS30101) from rmbs.rmbs301").list().get(i);
		}catch(Exception e){
             
		}*/
		
		try {
			session.beginTransaction();
			salesOrderModel=new SalesOrderModel();
			salesOrderModel=salesLineItemsModel1.getSalesOrderModel();
			
		/*	String oIdByDt="SO"+salesOrderModel.getOrderIdbyDate().replaceAll("-", "")+"/"
					+salesOrderModel.getBranchModel().getId()+"/"
					+salesOrderModel.getOutletModel().getId()+"/"
					+(i+1);
			
		*/	if(salesOrderModel.getId()==null){
			session.saveOrUpdate(salesOrderModel.getCustomerModel().getAddressModel());
			session.saveOrUpdate(salesOrderModel.getCustomerModel());
			}
			
			session.saveOrUpdate(salesOrderModel);
			int sOId=salesOrderModel.getId();
			
			String oIdByDt="SO"+salesOrderModel.getOrderIdByDate().replaceAll("-", "")+"/"
					+salesOrderModel.getBranchModel().getId()+"/"
					+salesOrderModel.getOutletModel().getId()+"/"
					+sOId;
			salesOrderModel.setOrderIdByDate(oIdByDt);
			
			session.saveOrUpdate(salesOrderModel);
			
			session.saveOrUpdate(salesLineItemsModel1);
			
			int sLIId=salesLineItemsModel1.getId();
			productInventoryModel=salesLineItemsModel1.getProductInventoryModel();
			productInventoryModel.setQuantity(productInventoryModel.getQuantity()-salesLineItemsModel1.getQuantity());
			session.saveOrUpdate(productInventoryModel);
			session.getTransaction().commit();
			
			salesLineItemsModel=(SalesLineItemsModel) session.get(SalesLineItemsModel.class, sLIId);
		} catch (Exception e) {
			session.cancelQuery();
			session.close();
		}
		
		return salesLineItemsModel;
	}
	public SalesOrderModel getSalesOrder(SalesOrderModel salesOrderModel1){
		Session session=sessionFactory.openSession();
		salesOrderModel=(SalesOrderModel) session.get(SalesOrderModel.class, salesOrderModel1.getId());
		session.close();
		return salesOrderModel;
	}
	
	public SalesLineItemsModel getSalesOrderLineItemById(SalesLineItemsModel salesLineItemsModel1){
		Session session=sessionFactory.openSession();
		salesLineItemsModel=(SalesLineItemsModel) session.get(SalesLineItemsModel.class, salesLineItemsModel1.getId());
		session.close();
		return salesLineItemsModel;
	}
	public SalesLineItemsModel createSalesOrderLineItems(SalesLineItemsModel salesLineItemsModel){
		
		return salesLineItemsModel;
	}
	
	public List<SalesLineItemsModel> updateSalesOrder(SalesLineItemsModel salesLineItemsModel1){
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			salesOrderModel=new SalesOrderModel();
			salesOrderModel=salesLineItemsModel1.getSalesOrderModel();
	
			
			session.update(salesOrderModel);
			productInventoryModel=salesLineItemsModel1.getProductInventoryModel();
			session.update(productInventoryModel);
			session.delete(salesLineItemsModel1);
			session.getTransaction().commit();
			
		    Criteria itemsCriteria=session.createCriteria(SalesLineItemsModel.class,"lineItems")	
		    		.createAlias("lineItems.salesOrderModel", "Order")
		    		.add(Restrictions.eq("Order.id",salesOrderModel.getId()));
		    salesLineItemsModels=itemsCriteria.list();
		    if(salesLineItemsModels.size()==0){
		    	session.beginTransaction();
		    	session.delete(salesOrderModel);
		    	session.getTransaction().commit();
		    }
		} catch (Exception e) {
			session.cancelQuery();
			session.close();
		}
		
		return salesLineItemsModels;
	}
	
	public List<SalesLineItemsModel> updateSalesLineItem(ProductInventoryModel oldProductInventoryModel,SalesLineItemsModel salesLineItemsModel1){
		Session session=sessionFactory.openSession();
		try {
			session.beginTransaction();
			salesOrderModel=new SalesOrderModel();
			salesOrderModel=salesLineItemsModel1.getSalesOrderModel();
			productInventoryModel=salesLineItemsModel1.getProductInventoryModel();
	        if(oldProductInventoryModel.getId()!=productInventoryModel.getId()){
	       	session.update(oldProductInventoryModel);
	        }
			session.update(salesOrderModel);
			productInventoryModel.setQuantity(productInventoryModel.getQuantity()-salesLineItemsModel1.getQuantity());
			session.update(productInventoryModel);
			session.update(salesLineItemsModel1);
			session.getTransaction().commit();
			
		    Criteria itemsCriteria=session.createCriteria(SalesLineItemsModel.class,"lineItems")	
		    		.createAlias("lineItems.salesOrderModel", "Order")
		    		.add(Restrictions.eq("Order.id",salesOrderModel.getId()));
		    salesLineItemsModels=itemsCriteria.list();
		   
		} catch (Exception e) {
			session.cancelQuery();
			session.close();
		}
		
		return salesLineItemsModels;
	}
	
	
	public SalesOrderModel confirmSalesOrder(List<SalesLineItemsModel> salesLineItemsModels){
		
		  StatelessSession hibSession = sessionFactory.openStatelessSession();
		  Transaction hibTx = hibSession.beginTransaction();
		  
		  try {
		    /*  ScrollableResults Items = hibSession
		              .createQuery("SELECT * FROM rmbs.RMBS302 where rmbs.RMBS")
		              .scroll(ScrollMode.FORWARD_ONLY);*/
			  
		  /*    while (Items.next()) {
		          SalesLineItemsModel slim = (SalesLineItemsModel) Items.get(0);
		          slim.setStatusModel(salesLineItemsModel.getStatusModel());
		          hibSession.update(slim);
		      }*/
			  
			  
			  
			 for(SalesLineItemsModel slim:salesLineItemsModels){ 
		          hibSession.update(slim);
		          salesOrderModel=slim.getSalesOrderModel();
			 	}
			 hibSession.update(salesOrderModel);
		      hibTx.commit();
		      hibSession.close();
		  }
		  catch (HibernateException ex) {
			  
		      if (hibTx != null) {
		    	  salesOrderModel=null;
		          hibTx.rollback();
		      }
		      if (hibSession != null) {
		          hibSession.close();
		      }
		      throw new DataAccessResourceFailureException("Hibernate update failed", ex);
		  }
		return salesOrderModel;
	}
	
	
	public List<SalesOrderModel> SalesOrderListByOrganization(
			SalesOrderModel salesOrderModel) {
		
		return null;
	}
	
	public List<SalesOrderModel> SalesOrderListByBranch(
			SalesOrderModel salesOrderModel) {
				return null;
		
	}
	
	public List<SalesOrderModel> SalesOrderListByOutlet(
			SalesOrderModel salesOrderModel) {
	
		return null;
	}
	
	public List<SalesLineItemsModel> getSalesLineItems(
			SalesLineItemsModel salesLineItemsModel) {
		
		return null;
	}
	
	public List<SalesLineItemsModel> SalesLineItemsListByOrganization(
			SalesLineItemsModel salesLineItemsModel) {
		
		return null;
	}
	
	public List<SalesLineItemsModel> SalesLineItemsListByBranch(
			SalesLineItemsModel salesLineItemsModel) {
		
		return null;
	}
	
	public List<SalesLineItemsModel> SalesLineItemsListByOutlet(
			SalesLineItemsModel salesLineItemsModel) {
		return null;
	}
	
	public List<SalesLineItemsModel> getSalesLineItemsModelsBySalesOrderModel(
			SalesOrderModel salesOrderModel1) {
		
		Session session=sessionFactory.openSession();
		
		Criteria salesLineItemsCriteria=session.createCriteria(SalesLineItemsModel.class,"salesLineItemsModel")
				.createAlias("salesLineItemsModel.salesOrderModel", "saleOrder")
				.add(Restrictions.eq("saleOrder.id",salesOrderModel1.getId()));
		List<SalesLineItemsModel> salesLineItemsModels=salesLineItemsCriteria.list();
		session.close();
		return salesLineItemsModels;
	}

	@SuppressWarnings("unchecked")
	public List<SalesOrderModel> salesOrderListByOrganization(SalesOrderModel salesOrderModel) {
		System.out.println("*******DAOIMPL****listpurchaseOrderModelByCreator****"+salesOrderModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(SalesOrderModel.class,"salesOrder")				
					.createAlias("salesOrder.branchModel", "branch")
					.createAlias("branch.organizationModel", "org")
					.createAlias("salesOrder.categoryModel", "category")
					.add(Restrictions.eq("org.id",salesOrderModel.getBranchModel().getOrganizationModel().getId()))
					.add(Restrictions.eq("category.id",salesOrderModel.getCategoryModel().getId()));
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
	public List<SalesOrderModel> salesOrderListByBranchOrOutlet(SalesOrderModel salesOrderModel) {
		System.out.println("*******DAOIMPL****listpurchaseOrderModelByCreator****"+salesOrderModel.getId());
		try{
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(SalesOrderModel.class,"salesOrder")	
					.createAlias("salesOrder.categoryModel", "category")
					.createAlias("salesOrder.branchModel", "branch")
					.add(Restrictions.eq("branch.id",salesOrderModel.getBranchModel().getId()))
					.add(Restrictions.eq("category.id",salesOrderModel.getCategoryModel().getId()));
			//  .add(Restrictions.eq("productInventory.createdBy",productInventoryModel.getCreatedBy()));

			List list = criteria.list();
			System.out.println("products.size() "+list.size());		

			return list;


		}catch(Exception e){

			System.out.println("*****Exception*****"+e);
			return null;
		}
	}

	

}
