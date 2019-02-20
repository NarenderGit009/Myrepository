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

import com.relyits.rmbs.dao.ConsumerDAO;
import com.relyits.rmbs.dao.PurchaseDAO;
import com.relyits.rmbs.dao.SalesDAO;
import com.relyits.rmbs.model.consumer.CustomerModel;
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


@Repository("ConsumerDAO")
public class ConsumerDAOImpl implements ConsumerDAO{

	@Autowired
	private SessionFactory sessionFactory;

	
	public List<CustomerModel> getCustomer(CustomerModel customerModel) {
		
		Session session=sessionFactory.openSession();
		Criteria customerCriteria=session.createCriteria(CustomerModel.class,"customer")
				.createAlias("customer.addressModel", "address")
				.add(Restrictions.eq("address.mobile",customerModel.getAddressModel().getMobile()));
		
		return customerCriteria.list();
	}

	public CustomerModel getDefaultCustomer(CustomerModel customerModel) {
		
		Session session=sessionFactory.openSession();
		CustomerModel customerModel2=(CustomerModel) session.get(CustomerModel.class, customerModel.getId());
		session.close();
		return customerModel2;
	}
	

}
