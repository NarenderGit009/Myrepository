package com.relyits.rmbs.daoImpl;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;

import com.relyits.rmbs.dao.UserDao;
import com.relyits.rmbs.model.menu.ChildMenuModel;
import com.relyits.rmbs.model.menu.MenuModel;
import com.relyits.rmbs.model.refference.AddressModel;
import com.relyits.rmbs.model.refference.RoleModel;
import com.relyits.rmbs.model.refference.StatusModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model.registration.ResourceModel;


/**
 * @author Amar Rao Errabelli
 *
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	@SuppressWarnings("rawtypes")
	public OrganizationModel checkAvailabilty(OrganizationModel organizationModel) {
		 System.out.println(organizationModel.getUserName());
		
		 Session session = sessionFactory.getCurrentSession();
		 session.beginTransaction();
				 ArrayList list=(ArrayList)session.createQuery("FROM OrganizationModel WHERE RMBS10102 = '"+organizationModel.getUserName()+"'")
				 .list();
			session.getTransaction().commit();	 
			System.out.println(list.isEmpty());
			OrganizationModel userregister1=null;
		 if(!list.isEmpty()){
		 userregister1=(OrganizationModel)list.get(0);
		 }
		 session.close();
	
		 return userregister1; 
	 }
	
	
	public boolean  createOraganization(OrganizationModel organizationModel) {
		boolean success = false;   
		 Session session = sessionFactory.openSession();
         
	        session.beginTransaction();  
		try {
			// obtaining session is omitted
			System.out.println("createOraganization of dao impl");
	
			
	 RoleModel roleModel=(RoleModel) session.get(RoleModel.class, 2);
			 
    RoleModel creatorRoleModel=(RoleModel) session.get(RoleModel.class, 1);
		
	StatusModel accountStatusModel=(StatusModel) session.get(StatusModel.class, 1);	
	
	StatusModel loginStatusModel=(StatusModel) session.get(StatusModel.class, 3);
	
	AddressModel addressModel=organizationModel.getResourceModel().getAddressModel();
	 session.save(addressModel);
	
	ResourceModel resourceModel = new ResourceModel();
	resourceModel.setAccountStatusModel(accountStatusModel);
	resourceModel.setLoginStatusModel(loginStatusModel);
	resourceModel.setCreatorRoleModel(creatorRoleModel);
	resourceModel.setRoleModel(roleModel);
	resourceModel.setAddressModel(addressModel);		 
			 
	session.save(resourceModel);
	
	organizationModel.setResourceModel(resourceModel);
	
	session.save(organizationModel);
			 
	session.getTransaction().commit();
			success = true;
		} catch (Exception e) {
			
			System.out.println("Exception   "+e);
			
			// log it and swallow exception
			// calling code has to be sure to check on success flag; 
			// otherwise it has no idea something went wrong
			session.cancelQuery();
		} 
		session.close();
		return success ;
	}
	
    
	 @SuppressWarnings("rawtypes")
	public OrganizationModel loginValidate(OrganizationModel organizationModel){
		 System.out.println(organizationModel.getUserName());
		 System.out.println(organizationModel.getPassword());
		 Session session = sessionFactory.getCurrentSession();
		 session.beginTransaction();
				 ArrayList list=(ArrayList)session.createQuery("FROM OrganizationModel WHERE RMBS10102 = '"+organizationModel.getUserName()+"' and password = '"+organizationModel.getPassword()+"'")
				 .list();
			session.getTransaction().commit();	 
		 OrganizationModel userregister1=null;
		 if(!list.isEmpty()){
		 userregister1=(OrganizationModel)list.get(0);
		 }
		 session.close();
		 return userregister1; 
	 }
	
	@SuppressWarnings("unchecked")
	public List<OrganizationModel> listUsers() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(OrganizationModel.class);
		
		
		session.close();
		return criteria.list();
	}

	public OrganizationModel getUser(int userid) {
		Session session = sessionFactory.getCurrentSession();
		OrganizationModel organizationModel=(OrganizationModel) session.get(OrganizationModel.class, userid);
		session.close();
		return organizationModel;
	}

	public void deleteUser(OrganizationModel organizationModel) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM Employee WHERE empid = "+organizationModel.getId()).executeUpdate();
	  session.close();
	}


	//********************menu**********************
	
	@SuppressWarnings("unchecked")
	public List<ChildMenuModel> getUserchildMenu(int[] childMenuOptions) {
		int i=0;
     		int flag=childMenuOptions[i];
     		String query=null;
     		if(flag==1){
     			query="FROM ChildMenuModel WHERE id in (";
		for(i=1;i<childMenuOptions.length;i++){
			if(childMenuOptions[i]!=0){
			query=query+childMenuOptions[i];
			System.out.println(childMenuOptions.length);
			if(childMenuOptions[i+1]!=0){
				query=query+",";
			}
			}
			
		}
		query=query+")";
     		}else{
     			query="FROM ChildMenu";
     		}
		System.out.println("*********query*********"+query);
		Session session = sessionFactory.getCurrentSession();
		 session.beginTransaction();
		 return (List<ChildMenuModel>)session.createQuery(query)
				 .list();
			
		
		
		
		
		
		/*			DetachedCriteria detachedCriteria = DetachedCriteria
			                .forClass(ChildMenu.class);
			        detachedCriteria.add(Restrictions.disjunction()).add(
			                Property.forName("idchild").in(childMenuOptions));
			        return (List<ChildMenu>)detachedCriteria.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
	*/
		 //return (List<ChildMenu>)crt.list();
 /*DetachedCriteria criteria =DetachedCriteria.forClass(
		 ChildMenu.class)
   .add(Restrictions.disjunction()
       .add( Property.forName("idchild").in(childMenuOptions) )
       
   );
 
 Criteria crit = session.createCriteria(Survey.class);
 Criterion price = Restrictions.gt("Id",new Integer(0));
 Criterion name = Restrictions.like("name","S%");
 Disjunction disjunction = Restrictions.disjunction();
 disjunction.add(price);
 disjunction.add(name);
 crit.add(disjunction);

 
 List results = crit.list(); 
 
 */ 
 
	}

    public int[] createUserMenu(MenuModel menuModel) {
	String options=menuModel.getChildMenuIds();	
	if(options!=null){	
		 String[] child = options.split(",");
		 int[] childId = new int[50];
		 int j=0;
		// childId[j]=Integer.parseInt(flag);
		 
		 for (String i : child){
			 System.out.println("id----"+i);
		
			 childId[j]=Integer.parseInt(i);
			 System.out.println("childId[j]----"+childId);
			 j++;
		 }
	}
	return null;
	}


}
