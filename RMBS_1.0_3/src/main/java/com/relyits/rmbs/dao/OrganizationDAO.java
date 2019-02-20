package com.relyits.rmbs.dao;

import java.util.List;

import com.relyits.rmbs.model.menu.ChildMenuModel;
import com.relyits.rmbs.model.menu.MenuModel;
import com.relyits.rmbs.model.registration.OrganizationModel;

public interface OrganizationDAO {
	
	public OrganizationModel checkAvailabilty(OrganizationModel organizationModel);

	public boolean  createOraganization(OrganizationModel organizationModel);
    
    public OrganizationModel loginValidate(OrganizationModel organizationModel);

	public List<OrganizationModel> getlistOfOrganizations();
	
	public OrganizationModel getUser(int userid);
	
	public void deleteUser(OrganizationModel organizationModel);
	
    public List<OrganizationModel> roleTwoUsersList(OrganizationModel organizationModel);
	
	public List<OrganizationModel> roleFourUsersList(OrganizationModel organizationModel);
	
	public OrganizationModel getOrganizationbyId(OrganizationModel organizationModel);
	
	public int changeOrganizationActiveStatus(OrganizationModel organizationModel);
	
	public List<OrganizationModel> getAccountRequestsByOrganizations(OrganizationModel organizationModel);


	//******************menu*******************
	
	public int[] createUserMenu(MenuModel menuModel);
	
	public List<ChildMenuModel> getUserchildMenu(int[] childMenuOptions);
}
