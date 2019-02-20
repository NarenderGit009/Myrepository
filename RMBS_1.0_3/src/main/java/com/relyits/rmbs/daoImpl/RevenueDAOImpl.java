package com.relyits.rmbs.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.relyits.rmbs.dao.RevenueDAO;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;
import com.relyits.rmbs.model.sales.SalesOrderModel;

@Repository("revenueDAO")
public class RevenueDAOImpl implements RevenueDAO{

	@Autowired
	private SessionFactory sessionFactory;


	@SuppressWarnings("rawtypes")
	public List<PurchaseOrderModel> revenuePurchaseOrder(java.util.Date fromDate,
			java.util.Date toDate,int branchId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(PurchaseOrderModel.class, "purchaseOrderModel")
				.setProjection(Projections.projectionList()
						.add(Projections.property("id"), "id")
						.add(Projections.property("orderIdByDate"), "orderIdByDate")
						.add(Projections.property("billingDateAndTime"), "billingDateAndTime")
						.add(Projections.property("payAmount"),"payAmount")
						.add(Projections.property("discountPrice"),"discountPrice")
						.add(Projections.property("totalVAT"),"totalVAT")
						.add(Projections.property("amount"),"amount")
						.add(Projections.property("purchaseOrderModel.branchModel"),"branchModel"))

						.setResultTransformer(Transformers.aliasToBean(PurchaseOrderModel.class))
						.add(Restrictions.between("purchaseOrderModel.billingDateAndTime", fromDate, toDate))
						.add(Restrictions.eq("purchaseOrderModel.branchModel.id", branchId));

		List purchaseOrderModels= criteria.list();	

		session.close();
		
		return purchaseOrderModels;
	}

	
	@SuppressWarnings("rawtypes")
	public List<SalesOrderModel> revenueSalesOrder(java.util.Date fromDate,
			java.util.Date toDate,int branchId,int catId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria=session.createCriteria(SalesOrderModel.class, "salesOrderModel")
				.setProjection(Projections.projectionList()
						.add(Projections.property("id"), "id")
						.add(Projections.property("orderIdByDate"), "orderIdByDate")
						.add(Projections.property("billingDateAndTime"), "billingDateAndTime")
						.add(Projections.property("payAmount"),"payAmount")
						.add(Projections.property("discountPrice"),"discountPrice")
						.add(Projections.property("totalVAT"),"totalVAT")
						.add(Projections.property("amount"),"amount")
						.add(Projections.property("salesOrderModel.branchModel"),"branchModel")
						.add(Projections.property("salesOrderModel.categoryModel"),"categoryModel"))

						.setResultTransformer(Transformers.aliasToBean(SalesOrderModel.class))
						.add(Restrictions.between("salesOrderModel.billingDateAndTime", fromDate, toDate))
						.add(Restrictions.eq("salesOrderModel.branchModel.id", branchId))
						.add(Restrictions.eq("salesOrderModel.categoryModel.id",catId ));

		List salesOrderModels= criteria.list();	

		session.close();
		
		return salesOrderModels;
	}
}
