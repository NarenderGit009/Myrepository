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

import com.relyits.rmbs.dao.DoctorDAO;
import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.registration.DoctorModel;
import com.relyits.rmbs.model.registration.ResourceModel;

@Repository("doctorDAO")
public class DoctorDAOImpl implements DoctorDAO{

	@Autowired
	private SessionFactory sessionFactory;
	

	public boolean registerDoctor(DoctorModel doctorModel) {
		  boolean success = false;  
		  System.out.println("*******masterDao**************");
		  DoctorModel doctorModel1 =null;
	//	  Session session = sessionFactory.openSession();
		
	/*	if(doctorModel.getId()==null){
		
			sessionFactory.getCurrentSession().saveOrUpdate(doctorModel)	;
			
			}else{*/
				
					Session session= sessionFactory.openSession();
					session.beginTransaction();
				//	try{

				/*	 Query query1=hsession.createSQLQuery(" UPDATE test1.rmbs005 SET " +
					 		"rmbs00501="+doctorModel.getId()
							 +", rmbs00502='"+doctorModel.getdoctorModelName()
							  +"', rmbs00503='"+doctorModel.getInitial()
							 +"', rmbs00506='"+doctorModel.getAddress()
							 +"', rmbs00512="+doctorModel.getCreatedby()
							 +", rmbs00507="+doctorModel.getPhno()
							 +", rmbs00508='"+doctorModel.getEmail()
							 +"', rmbs00509='"+doctorModel.getQualification()
							 +"', rmbs00510='"+doctorModel.getSpecialization()
							 +"', rmbs00511='"+doctorModel.getHospitalName()
							 +"' where rmbs00501="+doctorModel.getId()+";");
					
					i=query1.executeUpdate();*/
			
			doctorModel1 = new DoctorModel();
			doctorModel1=doctorModel;
			
			AddressModel addressModel = new AddressModel();
						
			RoleModel roleModel = (RoleModel)session.get(RoleModel.class, doctorModel.getResourceModel().getRoleModel().getId());
			
			RoleModel creatorRoleModel =(RoleModel)session.get(RoleModel.class, doctorModel.getResourceModel().getCreatorRoleModel().getId());
			
			StatusModel accountStatusModel = (StatusModel)session.get(StatusModel.class, doctorModel.getResourceModel().getAccountStatusModel().getId());
			
			StatusModel loginStatusModel = (StatusModel)session.get(StatusModel.class, doctorModel.getResourceModel().getLoginStatusModel().getId());
			
			addressModel = doctorModel.getResourceModel().getAddressModel();
			session.saveOrUpdate(addressModel);
			
			ResourceModel resourceModel = new ResourceModel();
			resourceModel.setId(doctorModel.getResourceModel().getId());
			resourceModel.setAccountStatusModel(accountStatusModel);
			resourceModel.setLoginStatusModel(loginStatusModel);
			resourceModel.setCreatorRoleModel(creatorRoleModel);
			resourceModel.setRoleModel(roleModel);
			resourceModel.setAddressModel(addressModel);	
			resourceModel.setCreatedBy(doctorModel.getResourceModel().getCreatedBy());
			
			session.saveOrUpdate(resourceModel);			
			
			
			doctorModel1.setResourceModel(resourceModel);
			
			session.saveOrUpdate(doctorModel1);	
													
			session.getTransaction().commit();
				    success = true;
			
			//		System.out.println("******Updated Rows******"+);
					
				//sessionFactory.getCurrentSession().update(agencyModel);
				
	//		}catch(Exception e){
		//		System.out.println("Exception"+e);
				
				session.cancelQuery();
	//		}
		return success;
				
	}	
		
		
	
	
	@SuppressWarnings("unchecked")
	 public List<DoctorModel> listDoctors() {
			
			return (List<DoctorModel>) sessionFactory.getCurrentSession().createCriteria(DoctorModel.class).list();
		}

	@SuppressWarnings("unchecked")
	public List<DoctorModel> listDoctorsByCreator(DoctorModel doctorModel) {
		System.out.println("*******DAOIMPL****listDoctorsByCreator()****"+doctorModel.getId());
		try{
		/*	Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DoctorModel.class,"doctor")
					.createAlias("doctor.resourceModel", "Resource")
					.createAlias("Resource.accountStatusModel", "AC_STATUS")
			.add(Restrictions.eq("AC_STATUS.id",doctorModel.getResourceModel().getAccountStatusModel().getId()));
		
			System.out.println("**********criteria.list()*********"+criteria.list().size());
			return criteria.list();*/
			
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DoctorModel.class,"doctor");
			return criteria.list();
		}catch(Exception e){
			     System.out.println("Exception"+e);
	
		return null;
		}
	}
	

	@SuppressWarnings("rawtypes")
	public DoctorModel getDoctor(DoctorModel doctorModel) {
		Session session = sessionFactory.openSession();
		if(doctorModel.getId()!=null){
			 return (DoctorModel) sessionFactory.getCurrentSession().get(DoctorModel.class, doctorModel.getId());
		}else{
			
			Criteria criteria = session.createCriteria(DoctorModel.class,"doctor")
					.createAlias("doctor.resourceModel", "Resource")
					.createAlias("Resource.accountStatusModel", "AC_STATUS")
					.add(Restrictions.eq("Resource.createdBy",doctorModel.getResourceModel().getCreatedBy()))
					.add(Restrictions.eq("doctorName",doctorModel.getDoctorName()))			        
	                .add(Restrictions.eq("AC_STATUS.id",doctorModel.getResourceModel().getAccountStatusModel().getId()));
					//.add(Restrictions.ne("status", "I"));
				
					    List doctors = criteria.list();
						System.out.println("**********criteria.list()*********"+criteria.list().size());
						DoctorModel doctorModel1 = null;
						for(int i=0;i<doctors.size();i++){
							doctorModel1=(DoctorModel) doctors.get(i);
						}
						
						return doctorModel1;
	    }
		
	}
	
	

	public void disableDoctor(DoctorModel doctorModel) {
		Session hsession=sessionFactory.getCurrentSession();
		hsession.beginTransaction();
	
		System.out.println("Disable Doctor");
	/*	Query query1=hsession.createSQLQuery(" UPDATE RMBS.RMBS106 SET RMBS10601="+doctorModel.getResourceModel().getId()
				  +", AC_ST_RMBS80301="+doctorModel.getResourceModel().getAccountStatusModel().getId()
			   //   +", UPDATED_DATE=NOW()"
				 +" where RMBS10601="+doctorModel.getResourceModel().getId()+";");
		
		int i=query1.executeUpdate();
		System.out.println("******Disabled Doctors******"+i);
		hsession.getTransaction().commit();*/
		Query query = hsession.createSQLQuery(
				"CALL UpdateAccountStatus(:flag,:id)")
				.addEntity(DoctorModel.class)
				.setParameter("flag", doctorModel.getResourceModel().getAccountStatusModel().getId())
		         .setParameter("id", doctorModel.getResourceModel().getId());
		int i=query.executeUpdate();
		System.out.println("******disable Doctors******"+i);
		hsession.getTransaction().commit();
		
	}
	
	public void deleteDoctor(DoctorModel doctorModel) {
		Session hsession=sessionFactory.getCurrentSession();
		hsession.beginTransaction();
	/*	Query query1=hsession.createSQLQuery(" UPDATE RMBS.RMBS106 SET RMBS10601="+doctorModel.getResourceModel().getId()
				 +",AC_ST_RMBS80301="+doctorModel.getResourceModel().getAccountStatusModel().getId()
			     // +", UPDATED_DATE=NOW()"
				 +" where RMBS10601="+doctorModel.getResourceModel().getId()+";");
		
		int i=query1.executeUpdate();
		System.out.println("******Deleted Doctors******"+i);
		hsession.getTransaction().commit();*/
		Query query = hsession.createSQLQuery(
				"CALL UpdateAccountStatus(:flag,:id)")
				.addEntity(DoctorModel.class)
				.setParameter("flag", doctorModel.getResourceModel().getAccountStatusModel().getId())
		         .setParameter("id", doctorModel.getResourceModel().getId());
		int i=query.executeUpdate();
		System.out.println("******delete Doctors******"+i);
		hsession.getTransaction().commit();
		
	}
	/*Query query = session.createSQLQuery(
	"CALL GetStocks(:stockCode)")
	.addEntity(Stock.class)
	.setParameter("stockCode", "7277");
 
List result = query.list();
for(int i=0; i<result.size(); i++){
	Stock stock = (Stock)result.get(i);
	System.out.println(stock.getStockCode());
}*/
	public void enableDoctor(DoctorModel doctorModel) {
		Session hsession=sessionFactory.getCurrentSession();
		hsession.beginTransaction();
		/*	Query query1=hsession.createSQLQuery(" UPDATE RMBS.RMBS106 SET RMBS10601="+doctorModel.getResourceModel().getId()
				 +", AC_ST_RMBS80301="+doctorModel.getResourceModel().getAccountStatusModel().getId()
			    //  +", UPDATED_DATE=NOW()"
				 +" where RMBS10601="+doctorModel.getResourceModel().getId()+";");
		
		int i=query1.executeUpdate();
		System.out.println("******Enable Doctors******"+i);
		hsession.getTransaction().commit();
		*/
		Query query = hsession.createSQLQuery(
				"CALL UpdateAccountStatus(:flag,:id)")
				.addEntity(DoctorModel.class)
				.setParameter("flag", doctorModel.getResourceModel().getAccountStatusModel().getId())
		         .setParameter("id", doctorModel.getResourceModel().getId());
		int i=query.executeUpdate();
		System.out.println("******Enable Doctors******"+i);
		hsession.getTransaction().commit();
	}
	
	public void enableAllDoctors(DoctorModel doctorModel) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		   
	//	ScrollableResults doctors = session.getNamedQuery("getDoctorsByCreator")
//	    .setInteger("cid", doctorModel.getResourceModel().getCreatedBy())
				 //   .setString("status", "D")
		ScrollableResults doctors = sessionFactory.getCurrentSession().createCriteria(DoctorModel.class,"doctor")
				.createAlias("doctor.resourceModel", "Resource")
				.createAlias("Resource.accountStatusModel", "AC_STATUS")
				.add(Restrictions.eq("Resource.createdBy",doctorModel.getResourceModel().getCreatedBy()))
		        .add(Restrictions.ne("AC_STATUS.id",doctorModel.getResourceModel().getAccountStatusModel().getId()))
		        .setCacheMode(CacheMode.IGNORE)
		        .scroll(ScrollMode.FORWARD_ONLY);
	
		while ( doctors.next() ) {
			DoctorModel doctorModel1 = (DoctorModel) doctors.get(0);
			StatusModel accountStatusModel = new StatusModel();
			ResourceModel resourceModel = new ResourceModel();
			
			resourceModel = doctorModel1.getResourceModel();
		    accountStatusModel.setId(doctorModel.getResourceModel().getAccountStatusModel().getId());
		    resourceModel.setAccountStatusModel(accountStatusModel);
		    doctorModel1.setResourceModel(resourceModel);
		    
		    enableDoctor(doctorModel1);
			
		/*	session.update(doctorModel1);
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
	
	public void disableAllDoctors(DoctorModel doctorModel) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		   
	//	ScrollableResults doctors = session.getNamedQuery("getDoctorsByCreator")
	//	    .setInteger("cid", doctorModel.getResourceModel().getCreatedBy())
	//	    .setString("status", "E")
		ScrollableResults doctors = sessionFactory.getCurrentSession().createCriteria(DoctorModel.class,"doctor")
				.createAlias("doctor.resourceModel", "Resource")
				.createAlias("Resource.accountStatusModel", "AC_STATUS")
				.add(Restrictions.eq("Resource.createdBy",doctorModel.getResourceModel().getCreatedBy()))
		        .add(Restrictions.ne("AC_STATUS.id",doctorModel.getResourceModel().getAccountStatusModel().getId()))
		        .setCacheMode(CacheMode.IGNORE)
		        .scroll(ScrollMode.FORWARD_ONLY);
		
		while ( doctors.next() ) {
			DoctorModel doctorModel1 = (DoctorModel) doctors.get(0);
			StatusModel accountStatusModel = new StatusModel();
			ResourceModel resourceModel = new ResourceModel();
			
			resourceModel = doctorModel1.getResourceModel();
		    accountStatusModel.setId(doctorModel.getResourceModel().getAccountStatusModel().getId());
		    resourceModel.setAccountStatusModel(accountStatusModel);
		    doctorModel1.setResourceModel(resourceModel);
		    
		    disableDoctor(doctorModel1);
			
		/*	session.update(doctorModel1);
		    if ( ++count % 20 == 0 ) {
		        //flush a batch of updates and release memory:
		        session.flush();
		        session.clear();
		    }*/
		}
		   
		tx.commit();
		session.close();
	}

	public void deleteAllDoctors(DoctorModel doctorModel) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		   
	//	ScrollableResults doctors = session.getNamedQuery("getDoctorsByCreator")
	//	    .setInteger("cid", doctorModel.getResourceModel().getCreatedBy())
	//	    .setString("status", "D")
		ScrollableResults doctors = sessionFactory.getCurrentSession().createCriteria(DoctorModel.class,"doctor")
				.createAlias("doctor.resourceModel", "Resource")
				.createAlias("Resource.accountStatusModel", "AC_STATUS")
				.add(Restrictions.eq("Resource.createdBy",doctorModel.getResourceModel().getCreatedBy()))
		        .add(Restrictions.ne("AC_STATUS.id",doctorModel.getResourceModel().getAccountStatusModel().getId()))
		        .setCacheMode(CacheMode.IGNORE)
		        .scroll(ScrollMode.FORWARD_ONLY);
		
		while ( doctors.next() ) {
			DoctorModel doctorModel1 = (DoctorModel) doctors.get(0);
			StatusModel accountStatusModel = new StatusModel();
			ResourceModel resourceModel = new ResourceModel();
			
			resourceModel = doctorModel1.getResourceModel();
		    accountStatusModel.setId(doctorModel.getResourceModel().getAccountStatusModel().getId());
		    resourceModel.setAccountStatusModel(accountStatusModel);
		    doctorModel1.setResourceModel(resourceModel);
		    
		    deleteDoctor(doctorModel1);			
		/*	session.update(doctorModel1);
		    if ( ++count % 20 == 0 ) {
		        //flush a batch of updates and release memory:
		        session.flush();
		        session.clear();
		    }*/
		}
		   
		tx.commit();
		session.close();
		
		
	}
	
	@SuppressWarnings("unchecked")
	public List<DoctorModel> listDoctorsByCategory(DoctorModel doctorModel) {
		System.out.println("*******DAOIMPL****listDoctorsByCategory()****"+doctorModel.getId());
		try{
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(DoctorModel.class,"doctor")
					.createAlias("doctor.resourceModel", "Resource")
					.createAlias("Resource.accountStatusModel", "AC_STATUS")
					//.add(Restrictions.eq("Resource.createdBy",doctorModel.getResourceModel().getCreatedBy()))
			        .add(Restrictions.eq("AC_STATUS.id",doctorModel.getResourceModel().getAccountStatusModel().getId()));
			
		         //	.add(Restrictions.eq("status",doctorModel.getStatus()))
			
			System.out.println("**********criteria.list()*********"+criteria.list().size());
			return criteria.list();
			//return (List<AgencyModel>) sessionFactory.getCurrentSession().createCriteria(agencyModel.class).list();
		}catch(Exception e){
			     System.out.println("**********************"+e);
	
		return null;	
		}
	}
	

}
