package com.relyits.rmbs.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.relyits.rmbs.dao.UserDao;
import com.relyits.rmbs.model.menu.ChildMenuModel;
import com.relyits.rmbs.model.menu.MenuModel;
import com.relyits.rmbs.model.registration.OrganizationModel;
import com.relyits.rmbs.service.UserService;

/**
 * @author Amar Errabelli
 *
 */
@Service("userService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	
	public OrganizationModel checkAvailabilty(OrganizationModel organizationModel) {
		return userDao.checkAvailabilty(organizationModel);
	}
	
	//@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean  createOraganization(OrganizationModel organizationModel) {
		return userDao.createOraganization(organizationModel);
	}
	
	public OrganizationModel loginValidate(OrganizationModel organizationModel){
		return userDao.loginValidate(organizationModel);
		
	}
	
	public List<OrganizationModel> listUsers() {
		return userDao.listUsers();
	}

	public OrganizationModel getUser(int empid) {
		return userDao.getUser(empid);
	}
	
	public void deleteUser(OrganizationModel organizationModel) {
		userDao.deleteUser(organizationModel);
	}

	//**************************menu***************************
	
	public List<ChildMenuModel> getUserchildMenu(int[] childMenuOptions) {
		return userDao.getUserchildMenu(childMenuOptions);
	}

	public int[] createUserMenu(MenuModel menuModel) {
		return userDao.createUserMenu(menuModel);
	}



}
