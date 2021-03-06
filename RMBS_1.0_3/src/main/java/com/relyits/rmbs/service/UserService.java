package com.relyits.rmbs.service;

import java.util.List;

import com.relyits.rmbs.model.menu.ChildMenuModel;
import com.relyits.rmbs.model.menu.MenuModel;
import com.relyits.rmbs.model.registration.OrganizationModel;

/**
 * @author Amar Rao Errabelli
 *
 */


public interface UserService {

	public OrganizationModel checkAvailabilty(OrganizationModel organizationModel);
	
	public boolean  createOraganization(OrganizationModel organizationModel);
	
	public OrganizationModel loginValidate(OrganizationModel organizationModel);

	public List<OrganizationModel> listUsers();
	
	public OrganizationModel getUser(int userid);
	
	public void deleteUser(OrganizationModel organizationModel);
	
	//******************menu*******************
	
	public int[] createUserMenu(MenuModel menuModel);
	
	public List<ChildMenuModel> getUserchildMenu(int[] childMenuOptions);
}
