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
import com.relyits.rmbs.dao.SalesReturnsDAO;
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
import com.relyits.rmbs.model.sales.SalesReturnLineItemsModel;
import com.relyits.rmbs.model.sales.SalesReturnOrderModel;


@Repository("salesReturnsDAO")
public class SalesReturnsDAOImpl implements SalesReturnsDAO{

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
	
	private SalesReturnLineItemsModel salesReturnLineItemsModel=null;
	private SalesReturnOrderModel salesReturnOrderModel=null;
	
	public List<SalesReturnLineItemsModel> createSalesReturnOrder(List<SalesReturnLineItemsModel> salesReturnLineItemsModels,List<SalesLineItemsModel> salesLineItemsModels) {
		Session session=sessionFactory.openSession();
		int i=0;
	
		
		try {
			session.beginTransaction();
		int count=0;
		int sOId=0;
		String oIdByDt="";
		salesReturnOrderModel=new SalesReturnOrderModel();
			for(SalesReturnLineItemsModel salesReturnLineItemsModel1:salesReturnLineItemsModels){
				count++;
				
			if(count==1){	
			salesReturnOrderModel=salesReturnLineItemsModel1.getSalesReturnOrderModel();
			
				if(salesReturnOrderModel.getId()==null){
					session.saveOrUpdate(salesReturnOrderModel);

					 sOId=salesReturnOrderModel.getId();
					oIdByDt="SRO"+salesReturnOrderModel.getOrderIdByDate().replaceAll("-", "")+"/"
							+salesReturnOrderModel.getBranchModel().getId()+"/"
							+salesReturnOrderModel.getOutletModel().getId()+"/"
							+sOId;
					salesReturnOrderModel.setOrderIdByDate(oIdByDt);
					session.saveOrUpdate(salesReturnOrderModel);
				}
				
			}else{
				
				SalesReturnOrderModel orderModel=salesReturnLineItemsModel1.getSalesReturnOrderModel();
				 
				orderModel.setAmount(orderModel.getAmount()+salesReturnOrderModel.getAmount());
				orderModel.setDiscountPrice(orderModel.getDiscountPrice()+salesReturnOrderModel.getDiscountPrice());
				orderModel.setDeductionOnMargin(orderModel.getDeductionOnMargin()+salesReturnOrderModel.getDeductionOnMargin());
				orderModel.setTotalVAT(orderModel.getTotalVAT()+salesReturnOrderModel.getTotalVAT());
				orderModel.setId(sOId);
				
				SalesOrderModel salesOrderModel=salesReturnOrderModel.getSalesOrderModel();
				salesReturnOrderModel=orderModel;
				salesReturnOrderModel.setOrderIdByDate(oIdByDt);
				salesReturnOrderModel.setSalesOrderModel(salesOrderModel);
				session.merge(salesReturnOrderModel);
			}
			
			
			
			
			
			session.saveOrUpdate(salesReturnLineItemsModel1);
			session.saveOrUpdate(salesLineItemsModels.get(count-1));
			int sLIId=salesReturnLineItemsModel1.getId();
			productInventoryModel=salesReturnLineItemsModel1.getProductInventoryModel();
			session.merge(productInventoryModel);
		
			}
		
			session.getTransaction().commit();
		
			Criteria salesReturnLineItemsCriteria=session.createCriteria(SalesReturnLineItemsModel.class,"SRLI")
					.createAlias("SRLI.salesReturnOrderModel", "SRO")
					.add(Restrictions.eq("SRO.id", salesReturnOrderModel.getId()));
					
			salesReturnLineItemsModels=salesReturnLineItemsCriteria.list();
		} catch (Exception e) {
			session.cancelQuery();
		}finally{
			session.close();			
		}
		
		return salesReturnLineItemsModels;
	}

	public SalesReturnOrderModel getSalesReturnOrder(SalesReturnOrderModel salesReturnOrderModel) {
		return null;
	}

	public SalesReturnLineItemsModel createSalesReturnOrderLineItems(SalesReturnLineItemsModel salesReturnLineItemsModel) {
		return null;
	}

	public List<SalesReturnLineItemsModel> getSalesReturnLineItemsModelsBySalesReturnOrderModel(SalesReturnOrderModel salesReturnOrderModel1) {
		
		Session session=sessionFactory.openSession();
		
		Criteria salesReturnLineItemsCriteria=session.createCriteria(SalesReturnLineItemsModel.class,"salesReturnLineItemsModel")
				.createAlias("salesReturnLineItemsModel.salesReturnOrderModel", "saleReturnOrder")
				.add(Restrictions.eq("saleReturnOrder.id",salesReturnOrderModel1.getId()));
		List<SalesReturnLineItemsModel> salesReturnLineItemsModels=salesReturnLineItemsCriteria.list();
		session.close();
		return salesReturnLineItemsModels;
	}



	
	

}
