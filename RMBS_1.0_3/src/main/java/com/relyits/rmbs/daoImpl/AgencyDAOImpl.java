package com.relyits.rmbs.daoImpl;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.relyits.rmbs.dao.AgencyDAO;
import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.registration.AgencyModel;
import com.relyits.rmbs.model.registration.DoctorModel;
import com.relyits.rmbs.model.registration.ResourceModel;

@Repository("agencyDAO")
public class AgencyDAOImpl implements AgencyDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unused")
	public boolean registerAgency(AgencyModel agencyModel){
		  boolean success = false;  
		  System.out.println("*******masterDao**************");
		  AgencyModel agencyModel1 =null;
		//  Session session = sessionFactory.openSession();
		
	/*	if(agencyModel.getId()==null){
		  sessionFactory.getCurrentSession().save(agencyModel);
		}else{*/
			
		     Session session= sessionFactory.openSession();
			     session.beginTransaction();
				try{
			/*	 Query query1=hsession.createSQLQuery(" UPDATE test1.agency SET " +
				 		"aid="+agencyModel.getAid()
						 +", A_NAME='"+agencyModel.getAgencyNme()
						 +"', ADDRESS='"+agencyModel.getAddress()
						 +"', CREATED_BY='"+agencyModel.getCreatedby()
						 +"', CST_NUM='"+agencyModel.getCstNo()
						 +"', DL1_NUM='"+agencyModel.getDlNo1()
						 +"', DL2_NUM='"+agencyModel.getDlNo2()
						 +"', PHONE_NUM="+agencyModel.getPhno()
						 +", UPDATED_DATE=NOW()"
						 +" where aid="+agencyModel.getAid()+";");
				
				int i=query1.executeUpdate();*/
					agencyModel1 = new AgencyModel();
					agencyModel1 = agencyModel;
					
					AddressModel addressModel = new AddressModel();
					
					RoleModel roleModel = (RoleModel)session.get(RoleModel.class, agencyModel.getResourceModel().getRoleModel().getId());
					
					RoleModel creatorRoleModel =(RoleModel)session.get(RoleModel.class, agencyModel.getResourceModel().getCreatorRoleModel().getId());
					
					StatusModel accountStatusModel = (StatusModel)session.get(StatusModel.class, agencyModel.getResourceModel().getAccountStatusModel().getId());
					
					StatusModel loginStatusModel = (StatusModel)session.get(StatusModel.class, agencyModel.getResourceModel().getLoginStatusModel().getId());
					
					addressModel = agencyModel.getResourceModel().getAddressModel();
					session.saveOrUpdate(addressModel);
					
					ResourceModel resourceModel = new ResourceModel();
					resourceModel.setId(agencyModel.getResourceModel().getId());
					resourceModel.setAccountStatusModel(accountStatusModel);
					resourceModel.setLoginStatusModel(loginStatusModel);
					resourceModel.setCreatorRoleModel(creatorRoleModel);
					resourceModel.setRoleModel(roleModel);
					resourceModel.setAddressModel(addressModel);	
					resourceModel.setCreatedBy(agencyModel.getResourceModel().getCreatedBy());
					
					session.saveOrUpdate(resourceModel);
					
					agencyModel.setResourceModel(resourceModel);
					
					session.saveOrUpdate(agencyModel);
															
					session.getTransaction().commit();
					    success = true;
					
			
			//	System.out.println("******Updated Rows******");
			//sessionFactory.getCurrentSession().update(agencyModel);
			
		}catch(Exception e){
			System.out.println("************"+e);
		}
			
		return success;
	  }    
		@SuppressWarnings("unchecked")
		public List<AgencyModel> listAgencies(){
			return (List<AgencyModel>) sessionFactory.getCurrentSession().createCriteria(AgencyModel.class).list();
			
		}
		
		@SuppressWarnings("unchecked")
		public List<AgencyModel> listAgenciesByCreator(AgencyModel agencyModel){
			System.out.println("*******DAOIMPL****listAgenciesByCreator()****"+agencyModel.getId());
		try{
		/*	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AgencyModel.class,"Agency")
					.add(Restrictions.eq("createdBy",agencyModel.getResourceModel().getCreatedBy()))
					.createAlias("Agency.resourceModel", "Resource")
					.createAlias("Resource.accountStatusModel", "AC_STATUS")
			        .add(Restrictions.eq("AC_STATUS",agencyModel.getResourceModel().getAccountStatusModel().getStatus()));
		//	.add(Restrictions.ne("status", "I"));
			System.out.println("**********criteria.list()*********"+criteria.list().size());
		//	return criteria.list();
			return (List<AgencyModel>) sessionFactory.getCurrentSession().createCriteria(AgencyModel.class).list();*/
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AgencyModel.class,"agency");
			return criteria.list();
		}catch(Exception e){
			     System.out.println("Exception"+e);
	
		return null;
		}
		}
		
		

		@SuppressWarnings("unchecked")
		public List<AgencyModel> listAgenciesByCategory(AgencyModel agencyModel) {
			System.out.println("*******DAOIMPL****listAgenciesByCategory()****"+agencyModel.getId());
		try{
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AgencyModel.class,"Agency")
					
					.createAlias("Agency.resourceModel", "Resource")
					.createAlias("Resource.accountStatusModel", "AC_STATUS")
					//.add(Restrictions.eq("Resource.createdBy",agencyModel.getResourceModel().getCreatedBy()))
			        .add(Restrictions.eq("AC_STATUS.id",agencyModel.getResourceModel().getAccountStatusModel().getId()));
			      //  .add(Restrictions.ne("AC_STATUS", ""))
					;
			System.out.println("**********criteria.list()*********"+criteria.list().size());
			return criteria.list();
			//return (List<agencyModel>) sessionFactory.getCurrentSession().createCriteria(agencyModel.class).list();
		}catch(Exception e){
			     System.out.println("**********************"+e);
	
		return null;	
		  }
		}
		
		@SuppressWarnings("rawtypes")
		public AgencyModel getAgency(AgencyModel agencyModel){
			Session session = sessionFactory.openSession();
			if(agencyModel.getId()!=null){
				 return (AgencyModel) sessionFactory.getCurrentSession().get(AgencyModel.class, agencyModel.getId());
			}else{
				
				Criteria criteria = session.createCriteria(AgencyModel.class,"agency")
						.createAlias("agency.resourceModel", "Resource")
						.createAlias("Resource.accountStatusModel", "AC_STATUS")
						.add(Restrictions.eq("Resource.createdBy",agencyModel.getResourceModel().getCreatedBy()))
						.add(Restrictions.eq("agencyName",agencyModel.getAgencyName()))		        
		                .add(Restrictions.eq("AC_STATUS.id",agencyModel.getResourceModel().getAccountStatusModel().getId()));
					      
						//.add(Restrictions.ne("status", "I"));
					
						    List agencies = criteria.list();
							System.out.println("**********criteria.list()*********"+criteria.list().size());
							AgencyModel agencyModel1 = null;
							for(int i=0;i<agencies.size();i++){
								agencyModel1=(AgencyModel) agencies.get(i);
							}
							
							return agencyModel1;
		    }
		}	
		
		public void deleteAgency(AgencyModel agencyModel){
			Session hsession=sessionFactory.getCurrentSession();
			hsession.beginTransaction();
	/*		Query query1=hsession.createSQLQuery(" UPDATE RMBS.RMBS106 SET RMBS10601="+agencyModel.getResourceModel().getId()
					 +", AC_ST_RMBS80301="+agencyModel.getResourceModel().getAccountStatusModel().getId()
				  //    +", UPDATED_DATE=NOW()"
					 +" where RMBS10601="+agencyModel.getResourceModel().getId()+";");
			
			int i=query1.executeUpdate();
			System.out.println("******Deleted Agencies******"+i);
			hsession.getTransaction().commit();*/
			Query query = hsession.createSQLQuery(
					"CALL UpdateAccountStatus(:flag,:id)")
					.addEntity(DoctorModel.class)
					.setParameter("flag", agencyModel.getResourceModel().getAccountStatusModel().getId())
			         .setParameter("id", agencyModel.getResourceModel().getId());
			int i=query.executeUpdate();
			System.out.println("******delete Doctors******"+i);
			hsession.getTransaction().commit();
		}
		
		public void disableAgency(AgencyModel agencyModel) {
			Session hsession=sessionFactory.getCurrentSession();
			hsession.beginTransaction();
			System.out.println("Disable Agency");
	/*		Query query1=hsession.createSQLQuery(" UPDATE RMBS.RMBS106 SET RMBS10601="+agencyModel.getResourceModel().getId()
					 +", AC_ST_RMBS80301="+agencyModel.getResourceModel().getAccountStatusModel().getId()
				 //     +", UPDATED_DATE=NOW()"
					 +" where RMBS10601="+agencyModel.getResourceModel().getId()+";");
			
			int i=query1.executeUpdate();
			System.out.println("******Disabled Agencies******"+i);
			hsession.getTransaction().commit();*/
			Query query = hsession.createSQLQuery(
					"CALL UpdateAccountStatus(:flag,:id)")
					.addEntity(DoctorModel.class)
					.setParameter("flag", agencyModel.getResourceModel().getAccountStatusModel().getId())
			         .setParameter("id", agencyModel.getResourceModel().getId());
			int i=query.executeUpdate();
			System.out.println("******disable Doctors******"+i);
			hsession.getTransaction().commit();
		}
		
		public void enableAgency(AgencyModel agencyModel) {
			Session hsession=sessionFactory.getCurrentSession();
			hsession.beginTransaction();
		/*	Query query1=hsession.createSQLQuery(" UPDATE RMBS.RMBS106 SET RMBS10601="+agencyModel.getResourceModel().getId()
					 +",AC_ST_RMBS80301="+agencyModel.getResourceModel().getAccountStatusModel().getId()
				  //    +", UPDATED_DATE=NOW()"
					 +" where RMBS10601="+agencyModel.getResourceModel().getId()+";");
			
			int i=query1.executeUpdate();
			System.out.println("******Enabled Agencies******"+i);
			hsession.getTransaction().commit();*/
			Query query = hsession.createSQLQuery(
					"CALL UpdateAccountStatus(:flag,:id)")
					.addEntity(DoctorModel.class)
					.setParameter("flag", agencyModel.getResourceModel().getAccountStatusModel().getId())
			         .setParameter("id", agencyModel.getResourceModel().getId());
			int i=query.executeUpdate();
			System.out.println("******enable Doctors******"+i);
			hsession.getTransaction().commit();
		}

		
	
		public void disableAllAgencies(AgencyModel agencyModel) {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			  System.out.println("disable all agencies"); 

			  ScrollableResults agencies = sessionFactory.getCurrentSession().createCriteria(AgencyModel.class,"agency")
						.createAlias("agency.resourceModel", "Resource")
						.createAlias("Resource.accountStatusModel", "AC_STATUS")
						.add(Restrictions.eq("Resource.createdBy",agencyModel.getResourceModel().getCreatedBy()))					      
		                .add(Restrictions.ne("AC_STATUS.id",agencyModel.getResourceModel().getAccountStatusModel().getId()))
		                .setCacheMode(CacheMode.IGNORE)
		                .scroll(ScrollMode.FORWARD_ONLY);
			
			
			while ( agencies.next() ) {
				AgencyModel agency = (AgencyModel) agencies.get(0);
				StatusModel accountStatusModel = new StatusModel();
		     	ResourceModel resourceModel = new ResourceModel();
				
				resourceModel = agency.getResourceModel();
			    accountStatusModel.setId(agencyModel.getResourceModel().getAccountStatusModel().getId());
			    resourceModel.setAccountStatusModel(accountStatusModel);
			    agency.setResourceModel(resourceModel);
				
				disableAgency(agency);
					
			}
			   
			tx.commit();
			session.close();
			
		}

	
		
		public void enableAllAgencies(AgencyModel agencyModel) {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			
			ScrollableResults agencies = sessionFactory.getCurrentSession().createCriteria(AgencyModel.class,"agency")
					.createAlias("agency.resourceModel", "Resource")
					.createAlias("Resource.accountStatusModel", "AC_STATUS")
					.add(Restrictions.eq("Resource.createdBy",agencyModel.getResourceModel().getCreatedBy()))					      
	                .add(Restrictions.ne("AC_STATUS.id",agencyModel.getResourceModel().getAccountStatusModel().getId()))
	                .setCacheMode(CacheMode.IGNORE)
	                .scroll(ScrollMode.FORWARD_ONLY);
			
				while ( agencies.next() ) {
				AgencyModel agency = (AgencyModel) agencies.get(0);
				StatusModel accountStatusModel = new StatusModel();
				ResourceModel resourceModel = new ResourceModel();
				
				resourceModel = agency.getResourceModel();
			    accountStatusModel.setId(agencyModel.getResourceModel().getAccountStatusModel().getId());
			    resourceModel.setAccountStatusModel(accountStatusModel);
			    agency.setResourceModel(resourceModel);
				
				enableAgency(agency);
			
				
			 /*   if ( ++count % 20 == 0 ) {
			        //flush a batch of updates and release memory:
			        session.flush();
			        session.clear();
			    }
		}*/
			}
			tx.commit();
			session.close();
			
		}
			
	

		
	
		public void deleteAllAgencies(AgencyModel agencyModel) {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			   
		//	ScrollableResults agencies = session.getNamedQuery("getAgenciesByCreator")
		//	    .setInteger("cid", agencyModel.getCreatedby())
		//	    .setString("status", "D")
			ScrollableResults agencies = sessionFactory.getCurrentSession().createCriteria(AgencyModel.class,"agency")
					.createAlias("agency.resourceModel", "Resource")
					.createAlias("Resource.accountStatusModel", "AC_STATUS")
					.add(Restrictions.eq("Resource.createdBy",agencyModel.getResourceModel().getCreatedBy()))					      
	                .add(Restrictions.ne("AC_STATUS.id",agencyModel.getResourceModel().getAccountStatusModel().getId()))
	                .setCacheMode(CacheMode.IGNORE)
	                .scroll(ScrollMode.FORWARD_ONLY);	
			
			while ( agencies.next() ) {
				AgencyModel agency = (AgencyModel) agencies.get(0);
				StatusModel accountStatusModel = new StatusModel();
				ResourceModel resourceModel = new ResourceModel();
				
				resourceModel = agency.getResourceModel();
			    accountStatusModel.setId(agencyModel.getResourceModel().getAccountStatusModel().getId());
			    resourceModel.setAccountStatusModel(accountStatusModel);
			    agency.setResourceModel(resourceModel);
				
			    deleteAgency(agency);
			/*	session.update(agency);
				
			//	agency.updateStuff();
			    if ( ++count % 20 == 0 ) {
			        //flush a batch of updates and release memory:
			        session.flush();
			        session.clear();
			    }*/
			}
			   
			tx.commit();
			session.close();
			
		}


}
