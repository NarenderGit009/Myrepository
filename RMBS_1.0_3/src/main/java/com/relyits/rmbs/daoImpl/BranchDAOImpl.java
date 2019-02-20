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

import com.relyits.rmbs.dao.BranchDAO;
import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model.registration.ResourceModel;

@Repository("branchDao")
public class BranchDAOImpl implements BranchDAO{

	@Autowired
	private SessionFactory sessionFactory;

		   //****************************Branch*******************************		
		
		@SuppressWarnings("rawtypes")
		public BranchModel checkBranchAvailability(BranchModel branchModel) {
			
			
			 Session session = sessionFactory.getCurrentSession();
			 session.beginTransaction();
					 ArrayList list=(ArrayList)session.createQuery("FROM BranchModel WHERE RMBS10202 = '"+branchModel.getUserName()+"'")
					 .list();
				session.getTransaction().commit();	 
				BranchModel branchModel1=null;
			 if(!list.isEmpty()){
				 branchModel1=(BranchModel)list.get(0);
			 }
			 return branchModel1; 
			
		}

		private OrganizationModel organizationModel=null;
		private RoleModel roleModel=null;
		private RoleModel creatorRoleModel =null;
		private StatusModel accountStatusModel =null;
		private StatusModel loginStatusModel =null;
		private ResourceModel resourceModel =null;
		private AddressModel addressModel =null;
		
		public boolean createBranch(BranchModel branchModel) {
			
			boolean success = false;  
			Session session = sessionFactory.openSession();
			session.beginTransaction();
		//	try{
System.out.println("branchModel.getOrganizationModel().getId()-->>>>>>>> "+branchModel.getOrganizationModel().getId());
System.out.println("branchModel.getId()-->>>>>>>> "+branchModel.getId());

				organizationModel = (OrganizationModel) session.get(OrganizationModel.class, branchModel.getOrganizationModel().getId());
				branchModel.setOrganizationModel(organizationModel);
				
				
				roleModel = (RoleModel)session.get(RoleModel.class, branchModel.getResourceModel().getRoleModel().getId());
			    creatorRoleModel =(RoleModel)session.get(RoleModel.class, branchModel.getResourceModel().getCreatorRoleModel().getId());
				accountStatusModel = (StatusModel)session.get(StatusModel.class, branchModel.getResourceModel().getAccountStatusModel().getId());
				loginStatusModel = (StatusModel)session.get(StatusModel.class, branchModel.getResourceModel().getLoginStatusModel().getId());
				
				addressModel = new AddressModel();
				addressModel = branchModel.getResourceModel().getAddressModel();
				session.saveOrUpdate(addressModel);
				
				resourceModel = new ResourceModel();
				resourceModel.setId(branchModel.getResourceModel().getId());
				resourceModel.setAccountStatusModel(accountStatusModel);
				resourceModel.setLoginStatusModel(loginStatusModel);
				resourceModel.setCreatorRoleModel(creatorRoleModel);
				resourceModel.setRoleModel(roleModel);
				resourceModel.setAddressModel(addressModel);	
				resourceModel.setCreatedBy(branchModel.getResourceModel().getCreatedBy());
				session.saveOrUpdate(resourceModel);			
				
				branchModel.setResourceModel(resourceModel);
				session.saveOrUpdate(branchModel);	
				
				
				session.getTransaction().commit();
				    success = true;

		//	}catch(Exception e){
		//		System.out.println("Exception"+e);
					
		//		session.cancelQuery();
		//	}
			return success;
			
			
			
			
		}

		@SuppressWarnings({ "unchecked", "unused" })
		public List<BranchModel> getBranchesByOrganization(BranchModel branchModel){
			Session session = sessionFactory.openSession();
			return (List<BranchModel>) sessionFactory.getCurrentSession()
					
					.createCriteria(BranchModel.class, "branch")
					.createAlias("branch.organizationModel", "Org")
					//.add(Restrictions.eq("active",userRegister.getActive()))
					.add(Restrictions.eq("Org.id",branchModel.getOrganizationModel().getId()))
					.list();
		}

/*Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BranchModel.class,"Branch")
					.createAlias("Branch.resourceModel", "Resource")
					.createAlias("Resource.accountStatusModel", "AC_STATUS")
					.createAlias("Branch.organizationModel", "Org")
				//	.createAlias("accountStatusModel", "AC_STATUS")
					.add(Restrictions.eq("Org.id",branchModel.getOrganizationModel().getId()))
			.add(Restrictions.eq("AC_STATUS.id",branchModel.getResourceModel().getAccountStatusModel().getId()));
			System.out.println("**********criteria.list()*********"+criteria.list().size());
			
			
			return criteria.list();*/

		@SuppressWarnings("unchecked")
		public List<BranchModel> getAccountRequestsByBranches(BranchModel branchModel) {
			
			Session hsession=sessionFactory.getCurrentSession();
			hsession.beginTransaction();
			 System.out.println("************ListDAO impl getAccountRequestsByAdmin**********");
		//	try{
				Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BranchModel.class,"Branch")
						.createAlias("Branch.resourceModel", "Resource")
						.createAlias("Resource.accountStatusModel", "AC_STATUS")
						.createAlias("Branch.organizationModel", "Org")
					//	.createAlias("accountStatusModel", "AC_STATUS")
						.add(Restrictions.eq("Org.id",branchModel.getOrganizationModel().getId()))
				.add(Restrictions.eq("AC_STATUS.id",branchModel.getResourceModel().getAccountStatusModel().getId()));
				System.out.println("**********criteria.list()*********"+criteria.list().size());
				
				
				return criteria.list();
				//return (List<AgencyRegister>) sessionFactory.getCurrentSession().createCriteria(AgencyRegister.class).list();
		//	}catch(Exception e){
				//     System.out.println("**********************"+e);
		
			//return null;
		//	}
		}
		
		public BranchModel getBranchbyId(BranchModel BranchModel) {
			return (BranchModel) sessionFactory.getCurrentSession().get(BranchModel.class, BranchModel.getId());
		}

		

		public boolean changeBranchStatus(BranchModel branchModel) {
			boolean success = false;
			Session hsession=sessionFactory.getCurrentSession();
			hsession.beginTransaction();
			try{
			Query query1=hsession.createSQLQuery(" UPDATE rmbs.rmbs106 SET rmbs10601="+branchModel.getResourceModel().getId()
					 +", AC_ST_rmbs80301='"+branchModel.getResourceModel().getAccountStatusModel().getId()+"'"
				       +" where rmbs10601="+branchModel.getResourceModel().getId()+";");
			
			int i=query1.executeUpdate();
			hsession.getTransaction().commit();
			System.out.println("******Updated users******"+i);
			success = true;
			}catch(Exception e){
				
				hsession.cancelQuery();
				
			}
			return success;
			
		}




		
		

		
		

		
		

		
		

		
		

		
		

		

		

	

		

		
}
