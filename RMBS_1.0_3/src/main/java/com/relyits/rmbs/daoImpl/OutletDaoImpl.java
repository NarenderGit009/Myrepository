package com.relyits.rmbs.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.relyits.rmbs.dao.OutletDao;
import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OutletModel;
import com.relyits.rmbs.model.registration.ResourceModel;


@Repository("outletDao")
public class OutletDaoImpl implements OutletDao{

	@Autowired
	private SessionFactory sessionFactory;
	private BranchModel branchModel=null;
	private RoleModel roleModel=null;
	private RoleModel creatorRoleModel =null;
	private StatusModel accountStatusModel =null;
	private StatusModel loginStatusModel =null;
	private ResourceModel resourceModel =null;
	private AddressModel addressModel =null;
	
	@SuppressWarnings("rawtypes")
	public OutletModel checkOutletAvailability(OutletModel outletModel) {
		 System.out.println(outletModel.getUserName());
			
		 Session session = sessionFactory.getCurrentSession();
		 session.beginTransaction();
				 ArrayList list=(ArrayList)session.createQuery("FROM OutletModel WHERE RMBS10302 = '"+outletModel.getUserName()+"'")
				 .list();
			session.getTransaction().commit();	 
			System.out.println(list.isEmpty());
			OutletModel OutletModel1=null;
		 if(!list.isEmpty()){
			 OutletModel1=(OutletModel)list.get(0);
		 }
		 session.close();
	
		 return OutletModel1; 
	
}
	

	public boolean createOutlet(OutletModel outletModel) {
		
		
		
		boolean success = false;  
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	//	try{
		
		  System.out.println("outletModel.getBranchModel().getId() "+outletModel.getBranchModel().getId());
            branchModel = new BranchModel();
			branchModel = (BranchModel) session.get(BranchModel.class, outletModel.getBranchModel().getId());
			outletModel.setBranchModel(branchModel);
			
			
			roleModel = (RoleModel)session.get(RoleModel.class, outletModel.getResourceModel().getRoleModel().getId());
		    creatorRoleModel =(RoleModel)session.get(RoleModel.class, outletModel.getResourceModel().getCreatorRoleModel().getId());
			accountStatusModel = (StatusModel)session.get(StatusModel.class, outletModel.getResourceModel().getAccountStatusModel().getId());
			loginStatusModel = (StatusModel)session.get(StatusModel.class, outletModel.getResourceModel().getLoginStatusModel().getId());
			
			addressModel = new AddressModel();
			addressModel = outletModel.getResourceModel().getAddressModel();
			session.saveOrUpdate(addressModel);
			
			resourceModel = new ResourceModel();
			resourceModel.setId(outletModel.getResourceModel().getId());
			resourceModel.setAccountStatusModel(accountStatusModel);
			resourceModel.setLoginStatusModel(loginStatusModel);
			resourceModel.setCreatorRoleModel(creatorRoleModel);
			resourceModel.setRoleModel(roleModel);
			resourceModel.setAddressModel(addressModel);	
			resourceModel.setCreatedBy(outletModel.getResourceModel().getCreatedBy());
			session.saveOrUpdate(resourceModel);			
			
			outletModel.setResourceModel(resourceModel);
			session.saveOrUpdate(outletModel);	
			
			
			session.getTransaction().commit();
			    success = true;

	//	}catch(Exception e){
	//		System.out.println("Exception"+e);
				
	//		session.cancelQuery();
	//	}
		return success;
		
		
		
	}
	
	public OutletModel getOutlet(OutletModel outletModel) {
		return (OutletModel) sessionFactory.getCurrentSession().get(OutletModel.class, outletModel.getId());
	}

	public boolean changeOutletStatus(OutletModel outletModel) {
		boolean success = false;
		Session hsession=sessionFactory.getCurrentSession();
		hsession.beginTransaction();
		try{
		Query query1=hsession.createSQLQuery(" UPDATE rmbs.rmbs106 SET rmbs10601="+outletModel.getResourceModel().getId()
				 +", AC_ST_rmbs80301='"+outletModel.getResourceModel().getAccountStatusModel().getId()+"'"
			       +" where rmbs10601="+outletModel.getResourceModel().getId()+";");
		
		int i=query1.executeUpdate();
		hsession.getTransaction().commit();
		System.out.println("******Updated users******"+i);
		success = true;
		}catch(Exception e){
			
			hsession.cancelQuery();
			
		}
		return success;
		
	}


	@SuppressWarnings("unchecked")
	public List<OutletModel> getOutletListsByBranch(OutletModel outletModel) {
		
		Session hsession=sessionFactory.getCurrentSession();
		hsession.beginTransaction();
		 System.out.println("************ListDAO impl getAccountRequestsByAdmin**********");
		 System.out.println("************Resource.accountStatusModel AC_STATUS********** "+outletModel.getResourceModel().getAccountStatusModel().getId());
		 System.out.println("************Outlet.branchModel Branch********** "+outletModel.getBranchModel().getId());
	//	try{
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(OutletModel.class,"Outlet")
					.createAlias("Outlet.resourceModel", "Resource")
					.createAlias("Resource.accountStatusModel", "AC_STATUS")
					.createAlias("Outlet.branchModel", "Branch")
				//	.createAlias("accountStatusModel", "AC_STATUS")
					.add(Restrictions.eq("Branch.id",outletModel.getBranchModel().getId()))
			.add(Restrictions.eq("AC_STATUS.id",outletModel.getResourceModel().getAccountStatusModel().getId()));
			System.out.println("**********criteria.list()*********"+criteria.list().size());
			
			hsession.getTransaction().commit();
			
			return criteria.list();
			//return (List<AgencyRegister>) sessionFactory.getCurrentSession().createCriteria(AgencyRegister.class).list();
	//	}catch(Exception e){
			//     System.out.println("**********************"+e);
	
		//return null;
	//	}
	}

	public List<OutletModel> getOutletListsByOrganization(OutletModel outletModel) {
		return null;
	}



}
