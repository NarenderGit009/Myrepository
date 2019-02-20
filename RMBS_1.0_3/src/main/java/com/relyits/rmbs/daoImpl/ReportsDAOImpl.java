package com.relyits.rmbs.daoImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.transform.Transformers;


import com.relyits.rmbs.beans.purchase.PurchaseLineItemsBean;
import com.relyits.rmbs.beans.purchase.PurchaseOrderBean;
import com.relyits.rmbs.beans.registration.AgencyBean;
import com.relyits.rmbs.beans.registration.BranchBean;
import com.relyits.rmbs.beans.registration.OrganizationBean;
import com.relyits.rmbs.beans.registration.ResourceBean;
import com.relyits.rmbs.beans.resources.ReasonBean;
import com.relyits.rmbs.beans.resources.RoleBean;
import com.relyits.rmbs.beans_preparation.purchase.PurchaseLineItemsBeanPreparation;
import com.relyits.rmbs.beans_preparation.purchase.PurchaseOrderBeanPreparation;
import com.relyits.rmbs.dao.ReportsDAO;
import com.relyits.rmbs.model.product.ProductInventoryModel;
import com.relyits.rmbs.model.product.ProductModel;
import com.relyits.rmbs.model.purchase.PurchaseLineItemsModel;
import com.relyits.rmbs.model.purchase.PurchaseOrderModel;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Repository("reportsDAO")
public class ReportsDAOImpl implements ReportsDAO{

	@Autowired
	private SessionFactory sessionFactory;

	private List<PurchaseOrderBean> purchaseOrderBeans=null;

	private ArrayList<PurchaseOrderModel> purchaseOrderModels = null;
	// *********products reports DAOImpl Stuff ********
	private PurchaseOrderBean purchaseOrderBean = null;
	private BranchBean branchBean = null;
	private ResourceBean resourceBean = null;
	private RoleBean roleBean = null;
	private OrganizationBean organizationBean = null;
	@Override
	public JRDataSource retrieveAllExistedProucts() {

		Session session=sessionFactory.openSession();

		Criteria criteria=session.createCriteria(ProductModel.class)
				.setProjection(Projections.projectionList()
						.add(Projections.property("name"), "name")
						.add(Projections.property("code"), "code")
						.add(Projections.property("schDrug"), "schDrug")
						.add(Projections.property("mFCompanay"), "mFCompanay")
						.add(Projections.property("createdDate"), "createdDate"))
						.setResultTransformer(Transformers.aliasToBean(ProductModel.class));
		@SuppressWarnings("unchecked")
		List<ProductModel> list =criteria.list();
		System.out.println("list size ************ "+list.size());
		JRDataSource ds = new JRBeanCollectionDataSource(list,false);
		session.close();
		return ds;
	}
	@Override
	public JRDataSource productStockListBybranch(int branchId){
		Session session=sessionFactory.openSession();
		ProductInventoryModel productInventoryModel=new ProductInventoryModel();
		Criteria criteria=session.createCriteria(ProductInventoryModel.class, "productInventory")
				.createAlias("productInventory.productModel", "product")
//				.createAlias("product.branchModel", "branchModel")
				.createAlias("productInventory.creatorRoleModel", "branch")
				//.setFetchMode("product", FetchMode.EAGER)
		.setProjection(Projections.projectionList()
					//.add(Projections.property("product.name"),"product.name")
					.add(Projections.property("quantity"), "quantity")
					.add(Projections.property("batchNo"), "batchNo")
					.add(Projections.property("price"),"price")
					.add(Projections.property("expiryDate"),"expiryDate")
					.add(Projections.property("productInventory.productModel"),"productModel")
					.add(Projections.property("productInventory.branchModel"),"branchModel"))

				    .setResultTransformer(Transformers.aliasToBean(ProductInventoryModel.class))
		.add(Restrictions.eq("branch.id", branchId));

		@SuppressWarnings("unchecked")
		List<ProductInventoryModel> list=criteria.list();

		for(int i=0;i<list.size();i++){

			Integer s=list.get(i).getId();
			System.out.println("*&************* "+s);
		}
		session.close();
		JRDataSource ds=new JRBeanCollectionDataSource(list,false);
		return ds;
	}

	// *********purchase reports DAOImpl Stuff ********

	@Override
	public List<PurchaseOrderBean> purchaseOrderReports(java.util.Date fromDate,
			java.util.Date toDate,int branchId) {
		// TODO Auto-generated method stub
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
						.add(Projections.property("invoiceNo"),"invoiceNo")
						.add(Projections.property("purchaseOrderModel.branchModel"),"branchModel"))

						//.add(Projections.property("createdBy"),"createdBy"))
	
						.setResultTransformer(Transformers.aliasToBean(PurchaseOrderModel.class))
						.add(Restrictions.between("purchaseOrderModel.billingDateAndTime", fromDate, toDate))
						.add(Restrictions.eq("purchaseOrderModel.branchModel.id", branchId));

		purchaseOrderModels=(ArrayList<PurchaseOrderModel>) criteria.list();
		purchaseOrderBeans=new ArrayList<PurchaseOrderBean>();

		roleBean = new RoleBean();
		resourceBean = new ResourceBean();
		branchBean = new BranchBean();
		organizationBean = new OrganizationBean();
		for(int i=0;i<purchaseOrderModels.size();i++){
			purchaseOrderBean = new PurchaseOrderBean();
			purchaseOrderBean.setId(purchaseOrderModels.get(i).getId());
			purchaseOrderBean.setOrderIdByDate(purchaseOrderModels.get(i).getOrderIdbyDate());
			purchaseOrderBean.setBillingDateAndTime(purchaseOrderModels.get(i).getBillingDateAndTime());
			purchaseOrderBean.setPayAmount(purchaseOrderModels.get(i).getPayAmount());
			purchaseOrderBean.setDiscountPrice(purchaseOrderModels.get(i).getPayAmount());
			purchaseOrderBean.setTotalVAT(purchaseOrderModels.get(i).getTotalVAT());
			purchaseOrderBean.setInvoiceNo(purchaseOrderModels.get(i).getInvoiceNo());
			roleBean.setRole(purchaseOrderModels.get(i).getBranchModel().getResourceModel().getRoleModel().getRole());
			branchBean.setUserName(purchaseOrderModels.get(i).getBranchModel().getUserName());
			organizationBean.setUserName(purchaseOrderModels.get(i).getBranchModel().getOrganizationModel().getUserName());
			branchBean.setOrganizationBean(organizationBean);
			resourceBean.setRoleBean(roleBean);
			branchBean.setResourceBean(resourceBean);
			purchaseOrderBean.setBranchBean(branchBean);
			purchaseOrderBeans.add(purchaseOrderBean);
		}
		session.close();
		//JRDataSource ds=new JRBeanCollectionDataSource(list);
		return purchaseOrderBeans;
	}
	@Override
	public JRDataSource purchaseOrderListReports(PurchaseOrderModel purchaseOrderModel) {
		
		Session session = sessionFactory.openSession();
		
		/*Criteria criteria = session.createCriteria(PurchaseOrderModel.class, "purchaseOrderModel")
				.createAlias("purchaseOrderModel.branchModel", "branch")
				.createAlias("purchaseOrderModel.agencyModel", "agency")
				.createAlias("branch.organizationModel", "org")
				.setProjection(Projections.projectionList()
						.add(Projections.property("id"), "id")
						.add(Projections.property("orderIdByDate"), "orderIdByDate")
						.add(Projections.property("billingDateAndTime"), "billingDateAndTime")
						.add(Projections.property("payAmount"),"payAmount")
						.add(Projections.property("discountPrice"),"discountPrice")
						.add(Projections.property("totalVAT"),"totalVAT")
						.add(Projections.property("invoiceNo"),"invoiceNo")
						.add(Projections.property("purchaseOrderModel.branchModel"),"branchModel")
						.add(Projections.property("purchaseOrderModel.agencyModel"), "agencyModel"))
						.setResultTransformer(Transformers.aliasToBean(PurchaseOrderModel.class))
						.add(Restrictions.eq("branch.organizationModel.id", purchaseOrderModel.getBranchModel().getOrganizationModel().getId()));*/
			//@SuppressWarnings("unchecked")
			//ArrayList<PurchaseOrderModel> purchaseOrderModels=(ArrayList<PurchaseOrderModel>)criteria.list();
		
			
			if(purchaseOrderModel.getBranchModel().getOrganizationModel()!=null){
				Query query = session.createSQLQuery(
						"CALL purchaseReports(:id,:role)")
						.addEntity(PurchaseOrderModel.class)
						.setParameter("id",purchaseOrderModel.getBranchModel().getOrganizationModel().getId())
						.setParameter("role",purchaseOrderModel.getBranchModel().getOrganizationModel().getResourceModel().getCreatorRoleModel().getId());
				List<PurchaseOrderModel> purchaseOrderModels = query.list();
				purchaseOrderBeans=PurchaseOrderBeanPreparation.prepareListOfPurchaseOrderBean(purchaseOrderModels);

			}
		
			else if(purchaseOrderModel.getBranchModel().getId()!=null){
				Query query = session.createSQLQuery(
						"CALL purchaseReports(:id,:role)")
						.addEntity(PurchaseOrderModel.class)
						.setParameter("id",purchaseOrderModel.getBranchModel().getId())
						.setParameter("role",purchaseOrderModel.getBranchModel().getResourceModel().getCreatorRoleModel().getId());
				@SuppressWarnings("unchecked")
				List<PurchaseOrderModel> purchaseOrderModels = query.list();
				purchaseOrderBeans=PurchaseOrderBeanPreparation.prepareListOfPurchaseOrderBean(purchaseOrderModels);
				//purchaseOrderBeans = convertPurchaseModelToBean(purchaseOrderModels);
				}
		
		JRDataSource jr = new JRBeanCollectionDataSource(purchaseOrderBeans,false);
		return jr;
	}
	
	public List<PurchaseOrderBean> convertPurchaseModelToBean(List<PurchaseOrderModel> purchaseOrderModels){
		
		purchaseOrderBeans=new ArrayList<PurchaseOrderBean>();
		AgencyBean agencyBean = null;
		PurchaseOrderBean purchaseOrderBean = null;
		BranchBean branchBean = null;
		OrganizationBean organizationBean = null;
		for(int i=0;i<purchaseOrderModels.size();i++){
			purchaseOrderBean = new PurchaseOrderBean();
			agencyBean = new AgencyBean();
			branchBean = new BranchBean();
			organizationBean = new OrganizationBean();
			purchaseOrderBean.setId(purchaseOrderModels.get(i).getId());
			purchaseOrderBean.setOrderIdByDate(purchaseOrderModels.get(i).getOrderIdbyDate());
			purchaseOrderBean.setBillingDateAndTime(purchaseOrderModels.get(i).getBillingDateAndTime());
			purchaseOrderBean.setPayAmount(purchaseOrderModels.get(i).getPayAmount());
			purchaseOrderBean.setDiscountPrice(purchaseOrderModels.get(i).getPayAmount());
			purchaseOrderBean.setTotalVAT(purchaseOrderModels.get(i).getTotalVAT());
			purchaseOrderBean.setInvoiceNo(purchaseOrderModels.get(i).getInvoiceNo());
			agencyBean.setAgencyName(purchaseOrderModels.get(i).getAgencyModel().getAgencyName());
			branchBean.setName(purchaseOrderModels.get(i).getBranchModel().getName());
			branchBean.setUserName(purchaseOrderModels.get(i).getBranchModel().getUserName());
			organizationBean.setUserName(purchaseOrderModels.get(i).getBranchModel().getOrganizationModel().getUserName());
			
			branchBean.setOrganizationBean(organizationBean);
			purchaseOrderBean.setAgencyBean(agencyBean);
			purchaseOrderBean.setBranchBean(branchBean);
			purchaseOrderBeans.add(purchaseOrderBean);
		}
		return purchaseOrderBeans;
		
	}
	@Override
	public List<PurchaseLineItemsBean> purchaseOrderLineitemsReports(
			PurchaseOrderModel purchaseOrderModel) {
		Session session = sessionFactory.openSession();
		
			Criteria criteria = session.createCriteria(PurchaseLineItemsModel.class,"purchaseLineItems")
					.createAlias("purchaseLineItems.purchaseOrderModel", "purchaseOrder")
					.add(Restrictions.eq("purchaseOrder.invoiceNo",purchaseOrderModel.getInvoiceNo()));		        

			List<PurchaseLineItemsModel> purchaseLineItemsModels = criteria.list();
			System.out.println("**********criteria.list()*********"+purchaseLineItemsModels.size());
			/*	PurchaseLineItemsModel purchaseLineItemsModel1 = null;
			for(int i=0;i<purchaseLineItems.size();i++){
				purchaseLineItemsModel1=(PurchaseLineItemsModel) purchaseLineItems.get(i);
			}
		*/
			List<PurchaseLineItemsBean> purchaseLineItemsBeans=PurchaseLineItemsBeanPreparation.prepareListOfPurchaseLineItemsBean(purchaseLineItemsModels);
//			JRDataSource jd = new JRBeanCollectionDataSource(purchaseLineItemsBeans);

		
		return purchaseLineItemsBeans;
	}
}
