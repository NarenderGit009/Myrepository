package com.relyits.rmbs.utilities;

import javax.servlet.http.HttpSession;

import com.relyits.rmbs.beans.session.UserSessionBean;
import com.relyits.rmbs.beans_preparation.resources.SessionBeanPreparation;
import com.relyits.rmbs.model.registration.BranchModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.model.registration.OutletModel;

public class SessionUtilities {

	
	/*******************************************************************************************************/
	/*********************************     Session Related Methods  *********************************************/
	/*******************************************************************************************************/	 
 
 public static boolean createOrganizationSession(OrganizationModel organizationModel,HttpSession session){
		boolean success = false;
	try {
		UserSessionBean userSessionBean=SessionBeanPreparation.prepareUserSessionBeanFromOrganizationModel(organizationModel);
		session.setAttribute("user",userSessionBean );
		success = true;
	} catch (Exception e) {
	
	} 
 
	 return success;
	
 }
 public static boolean createBranchSession(BranchModel branchModel,HttpSession session){
	 boolean success = false;
	 try {
			UserSessionBean userSessionBean=SessionBeanPreparation.prepareUserSessionBeanFromBranchModel(branchModel);
			session.setAttribute("user",userSessionBean );
			success = true;
	} catch (Exception e) {
		
	}

	 return success;
	
 }
 
 public static boolean createOutletSession(OutletModel outletModel,HttpSession session){
	 boolean success = false;
	 try {
			UserSessionBean userSessionBean=SessionBeanPreparation.prepareUserSessionBeanFromOutletModel(outletModel);
			session.setAttribute("user",userSessionBean );
			success = true;
	} catch (Exception e) {
		
	}

	 return success;
	
 }
 
 public static UserSessionBean giveMeSession(HttpSession session){
	 Object o=(Object)session.getAttribute("user");
	 UserSessionBean userSessionBean=(UserSessionBean)o;
	 System.out.println("giveMeSession  "+userSessionBean.getId());
	 return userSessionBean;
	
 }
 
 public static int[] validateSession(String id,HttpSession session){
	    int user[] = new int[10];
	    user[0]=0;
		//Object o=(Object)session.getAttribute("user");
		// UserRegister ur=(UserRegister)o;
	    UserSessionBean userSessionBean= giveMeSession(session);
		if(userSessionBean!=null && id!=null){
		 if(userSessionBean.getId()==Integer.parseInt(id)){
			 user[0]=1;
			 user[1]=userSessionBean.getResourceBean().getRoleBean().getId();
			 user[2]=userSessionBean.getId();
			 
			 return user;
		 }else{
		
	         return user;
		 }
 }else{
	
     return user;
 }
		}
}
