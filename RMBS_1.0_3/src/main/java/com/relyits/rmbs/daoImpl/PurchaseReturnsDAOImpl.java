package com.relyits.rmbs.daoImpl;

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

import com.relyits.rmbs.beans.purchase.PurchaseLineItemsBean;
import com.relyits.rmbs.beans_preparation.purchase.PurchaseLineItemsBeanPreparation;
import com.relyits.rmbs.dao.PurchaseReturnsDAO;
import com.relyits.rmbs.model.product.ProductInventoryModel;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.model.purchase.PurchaseReturnLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseReturnOrderModel;
import com.relyits.rmbs.model.registration.BranchModel;

@Repository("purchaseReturnDAO")
public class PurchaseReturnsDAOImpl implements PurchaseReturnsDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	private PurchaseReturnOrderModel purchaseReturnOrderModel = null;
	private PurchaseLineItemsModel purchaseLineItemsModel = null;

//	**************purchase returns stuff*******************

	private ProductInventoryModel productInventoryModel = null;

	private PurchaseOrderModel purchaseOrderModel = null;

	private PurchaseLineItemsModel purchaseLineItemsModel1 = null;
	
	public List<String> getPurchaseInvoiceNo(PurchaseOrderModel purchaseOrderModel){
		
		Session session = sessionFactory.openSession();
		
		Criteria criteria = session.createCriteria(PurchaseOrderModel.class , "purchaseModel")
				.createAlias("purchaseModel.branchModel", "branch")
				.setProjection(Projections.projectionList()
						.add(Projections.property("purchaseModel.orderIdByDate"),"orderIdByDate"))
						.setResultTransformer(Transformers.aliasToBean(PurchaseOrderModel.class))
				.add(Restrictions.eq("branch.id", purchaseOrderModel.getBranchModel().getId()))
				.add(Restrictions.like("purchaseModel.orderIdByDate", purchaseOrderModel.getOrderIdbyDate(),MatchMode.ANYWHERE));
		@SuppressWarnings("unchecked")
		List<String> list = criteria.list();
		return list;
	}

	
	public PurchaseLineItemsModel getPurchaseLineItemsById(
			PurchaseLineItemsModel purchaseLineItemsModel) {
		
		Session session = sessionFactory.openSession();
		/*Criteria criteria = session.createCriteria(PurchaseLineItemsModel.class, "purchaseLineItemsModel")
				.add(Restrictions.eq("id", purchaseLineItemsModel.getId()));
		@SuppressWarnings("unchecked")
		List<PurchaseLineItemsModel> purchaseLineItemsModels= criteria.list();*/
		
		purchaseLineItemsModel1  = (PurchaseLineItemsModel) session.get(PurchaseLineItemsModel.class, purchaseLineItemsModel.getId());
//		List purchaseLineItemsModels = query.list();
		PurchaseLineItemsBean purchaseLineItemsBean = new PurchaseLineItemsBean();
//		purchaseLineItemsBean = PurchaseLineItemsBeanPreparation.preparePurchaseLineItemsBean(purchaseLineItemsModel);
		session.close();
		return purchaseLineItemsModel1;
	}
	
	public List<PurchaseLineItemsBean> getPurchaseLineItemsByPOId(PurchaseOrderModel purchaseOrderModel){
		
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(PurchaseLineItemsModel.class,"pLineItems")
				.createAlias("pLineItems.purchaseOrderModel", "pModel")
				.add(Restrictions.eq("pModel.id",purchaseOrderModel.getId()));
		
		List<PurchaseLineItemsModel> purchaseLineItemsModels = criteria.list();
		List<PurchaseLineItemsBean> purchaseLineItemsBeans=PurchaseLineItemsBeanPreparation.prepareListOfPurchaseLineItemsBean(purchaseLineItemsModels);
		session.close();
		return purchaseLineItemsBeans;

	}


	@Override
	public int createPurchaseReturnOrder(
			PurchaseReturnLineItemsModel purchaseReturnLineItemsModel, int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*public int createPurchaseReturnOrder(PurchaseReturnLineItemsModel purchaseReturnLineItemsModel,int id)
	{
		int i=0;
		int j=0;
		int k=0;
		Integer returnId = 0;
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		purchaseLineItemsModel = new PurchaseLineItemsModel();
		try{
			j=(int) session.createSQLQuery("select max(RMBS40301) from rmbs.rmbs403").list().get(i);
		}catch(Exception e){

		}
		
		purchaseReturnOrderModel = new PurchaseReturnOrderModel();
		
		purchaseReturnOrderModel = purchaseReturnLineItemsModel.getPurchaseReturnOrderModel();
		
		purchaseReturnOrderModel.setPurchaseOrderModel((PurchaseOrderModel) session.get(PurchaseOrderModel.class, purchaseReturnLineItemsModel.getPurchaseReturnOrderModel().getPurchaseOrderModel().getId()));
		purchaseReturnOrderModel.setBranchModel((BranchModel)session.get(BranchModel.class, purchaseReturnLineItemsModel.getPurchaseReturnOrderModel().getBranchModel().getId()));
		if(purchaseReturnOrderModel.getId()==0){
			String pOId = "PR"+purchaseReturnOrderModel.getOrderIdByDate().replaceAll("-", "")+"/"
					+purchaseReturnOrderModel.getBranchModel().getId()+"/"
					+purchaseReturnOrderModel.getAgencyModel().getId()+"/"
					+(j+1);
			purchaseReturnOrderModel.setOrderIdByDate(pOId);
		session.save(purchaseReturnOrderModel);
		returnId = purchaseReturnOrderModel.getId();
		}
		else
		{
			String pOId = "PR"+purchaseReturnOrderModel.getOrderIdByDate().replaceAll("-", "")+"/"
					+purchaseReturnOrderModel.getBranchModel().getId()+"/"
					+purchaseReturnOrderModel.getAgencyModel().getId()+"/"
					+(j);
			purchaseReturnOrderModel.setOrderIdByDate(pOId);
			Double x=(Double) session.createSQLQuery("select RMBS40302 from rmbs.rmbs403 where RMBS40301="+purchaseReturnOrderModel.getId()+"").list().get(i);
			Double y=(Double) session.createSQLQuery("select RMBS40306 from rmbs.rmbs403 where RMBS40301="+purchaseReturnOrderModel.getId()+"").list().get(i);
			Double z=(Double) session.createSQLQuery("select RMBS40307 from rmbs.rmbs403 where RMBS40301="+purchaseReturnOrderModel.getId()+"").list().get(i);

			purchaseReturnOrderModel.setAmount(x+purchaseReturnLineItemsModel.getPurchaseReturnOrderModel().getAmount());
			purchaseReturnOrderModel.setDiscountPrice(y+purchaseReturnLineItemsModel.getPurchaseReturnOrderModel().getDiscountPrice());
			purchaseReturnOrderModel.setTotalVAT(z+purchaseReturnLineItemsModel.getPurchaseReturnOrderModel().getTotalVAT());
			session.saveOrUpdate(purchaseReturnOrderModel);
			
			returnId = purchaseReturnOrderModel.getId();
		}
		productInventoryModel  = new ProductInventoryModel();
		productInventoryModel = purchaseReturnLineItemsModel.getProductInventoryModel();
		
		int qty = purchaseReturnLineItemsModel.getDelivaeredQuantity();
	
		int quantity = productInventoryModel.getQuantity()-qty;
		productInventoryModel.setQuantity(quantity);
		session.saveOrUpdate(productInventoryModel);
		session.save(purchaseReturnLineItemsModel);
		
		/*Criteria criteria = session.createCriteria(PurchaseLineItemsModel.class, "purchaseReturnOrderModel")
							.createAlias("purchaseReturnOrderModel.purchaseOrderModel", "pModel")
							.add(Restrictions.eq("purchaseReturnOrderModel.purchaseOrderModel", purchaseReturnLineItemsModel.getPurchaseReturnOrderModel().getPurchaseOrderModel()));
		
		List<PurchaseLineItemsModel> purchaseLineItemsModels = criteria.list();
		
		purchaseLineItemsModel= (PurchaseLineItemsModel) session.get(PurchaseLineItemsModel.class, id);
		purchaseLineItemsModel.setDeliverableQuantity(purchaseLineItemsModel.getDeliverableQuantity()-purchaseReturnLineItemsModel.getDelivaeredQuantity());
		session.saveOrUpdate(purchaseLineItemsModel);
		session.getTransaction().commit();
		return returnId;
	}*/
}
